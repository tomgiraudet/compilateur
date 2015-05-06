import java.util.Stack;
public class Expression {
	private Stack<Type> types;
	private Stack<Operator> operations;
	private IdFunction last_function;
	private Ident identAffect;
	private Stack<IdFunction> functions;
	private Stack<Stack<Type>> parameters;

	public Expression() {
		this.types = new Stack<Type>();
		this.operations = new Stack<Operator>();
		this.functions = new Stack<IdFunction>();
		this.parameters = new Stack<Stack<Type>>();
	}
	void ajoutType(Type t){
		types.push(t);
	}
	void ajoutOp(Operator op){
		operations.push(op);
	}
	Type testAddSubMulDiv(Type type1, Type type2){
		if(type1 == Type.INT){
			if(type2 == Type.INT){
				return Type.INT;
			}
		}
		return Type.ERROR;
	}
	Type testSupInf(Type type1, Type type2){
		if(type1 == Type.INT){
			if(type2 == Type.INT){
				return Type.BOOL;
			}
		}
		return Type.ERROR;
	}
	Type testEQU(Type type1, Type type2){
		if(type1 == Type.INT){
			if(type2 == Type.INT){
				return Type.BOOL;
			}
		}
		if(type1 == Type.BOOL){
			if(type2 == Type.BOOL){
				return Type.BOOL;
			}
		}
		return Type.ERROR;
	}
	Type testAndOr(Type type1, Type type2){
		if(type1 == Type.BOOL){
			if(type2 == Type.BOOL){
				return Type.BOOL;
			}
		}
		return Type.ERROR;
	}


	void testStacks(){
		if(!operations.isEmpty()){				
			switch(operations.pop()){
			case PLUS :
				Yaka.yvm.iadd();
				ajoutType(testAddSubMulDiv(types.pop(), types.pop()));
				break;
			case MOINS :
				Yaka.yvm.isub();
				ajoutType(testAddSubMulDiv(types.pop(), types.pop()));
				break;
			case MUL :
				Yaka.yvm.imul();
				ajoutType(testAddSubMulDiv(types.pop(), types.pop()));
				break;
			case DIV :
				Yaka.yvm.idiv();
				ajoutType(testAddSubMulDiv(types.pop(), types.pop()));
				break;
			case INF :
				Yaka.yvm.iinf();
				ajoutType(testSupInf(types.pop(), types.pop()));
				break;
			case SUP :
				Yaka.yvm.isup();
				ajoutType(testSupInf(types.pop(), types.pop()));
				break;
			case INFE :
				Yaka.yvm.iinfegal();
				ajoutType(testSupInf(types.pop(), types.pop()));
				break;
			case SUPE :
				Yaka.yvm.isupegal();
				ajoutType(testSupInf(types.pop(), types.pop()));
				break;
			case EQU :
				Yaka.yvm.iegal();
				ajoutType(testEQU(types.pop(), types.pop()));
				break;
			case DIFF :
				Yaka.yvm.idiff();
				ajoutType(testEQU(types.pop(), types.pop()));
				break;
			case OR :
				Yaka.yvm.ior();
				ajoutType(testAndOr(types.pop(), types.pop()));
				break;
			case AND :
				Yaka.yvm.iand();
				ajoutType(testAndOr(types.pop(), types.pop()));
				break;
			case NOT :
				Yaka.yvm.inot();
				break;
			case NEG :
				Yaka.yvm.ineg();
				break;
			default :
				ajoutType(Type.ERROR);
			}
		}
	}

	void NegationInt(){
		Operator op = this.operations.pop();
		if(op==Operator.NEG) {
			Yaka.yvm.ineg();
		} else {
			this.types.push(Type.ERROR);
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ErrorManager.WRONG_OPERATOR);
		}
	}

	void NegationBool(){
		Operator op = this.operations.pop();
		if(op==Operator.NOT) {
			Yaka.yvm.inot();
		} else {
			this.types.push(Type.ERROR);
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ErrorManager.WRONG_OPERATOR);
		}
	}

	public void pushBoolean(int a) {
		this.types.push(Type.BOOL);
		Yaka.yvm.iconst(a);
	}


	public void pushIdent(String id) {
		if(Yaka.tabIdent.existeLocalIdent(id)) {
			Ident ident = Yaka.tabIdent.chercheLocalIdent(id);
			this.types.push(ident.getType());
			if(ident.isVar()) {
				Yaka.yvm.iload(((IdVar)ident).getOffset());
			} else if(ident.isConst()) {
				Yaka.yvm.iconst(((IdConst)ident).getValue());
			} else if(ident.isParam()){
				Yaka.yvm.iload(((IdParam)ident).getOffset());
			}else{
				this.types.push(Type.ERROR);
				ErrorManager.errorDeclaration(YakaTokenManager.currentLine, id, ErrorManager.WRONG_OPERATOR);
			}
		} else if(Yaka.tabIdent.existeIdent(id)){
			IdFunction ident = (IdFunction) Yaka.tabIdent.chercheIdent(id);
			functions.push(ident);
			parameters.push(new Stack<Type>());
			this.types.push(ident.getType());
			Yaka.yvm.reserveRetour();
		}else{
			this.types.push(Type.ERROR);
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, id, ErrorManager.IDENT_DOESNT_EXIST);
		}
	}

	void setAffectation(String nom) {
		if(Yaka.tabIdent.existeLocalIdent(nom)) {
			identAffect = Yaka.tabIdent.chercheLocalIdent(nom);
		} else if(Yaka.tabIdent.existeIdent(nom)){
			identAffect = Yaka.tabIdent.chercheIdent(nom);
		}else{
			this.types.push(Type.ERROR);
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, nom, ErrorManager.IDENT_DOESNT_EXIST);
		}
	}

	void affectation() {
		Type varType = identAffect.getType();
		Type valType = types.pop();

		if(this.identAffect.isVar()) {
			if(varType==valType) {
				Yaka.yvm.istore(((IdVar)identAffect).getOffset());
			} else {
				this.types.push(Type.ERROR);
				ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ErrorManager.MISMATCH_TYPES);
			}
		}else if(this.identAffect.isFunction()){
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ErrorManager.FUNCTION_AFFECTATION);
		}else {
			this.types.push(Type.ERROR);
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ErrorManager.IMPOSSIBLE_AFFECTION);
		}
	}

	void pushParameters(){
		if(types.size()>0 && parameters.size() > 0){
			Type t = types.pop();
			parameters.peek().push(t);
		}else{
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ErrorManager.UNKNOWN_ERROR);
		}
	}

	void checkCallFunction(){
		if(functions.size() > 0){
			IdFunction func = functions.pop();
			Stack<Type> params = parameters.pop();
			if(params.size() != func.paramList.size()){
				ErrorManager.errorDeclaration(YakaTokenManager.currentLine, func.name, ErrorManager.WRONG_NUMBER_PARAMETERS);
				return;
			}
			for (int i = 0; i<params.size();i++){
				if(params.get(i) != func.paramList.get(i)){
					ErrorManager.errorDeclaration(YakaTokenManager.currentLine, func.name, ErrorManager.WRONG_TYPE_PARAMETERS);
					return;
				}
			}
			Yaka.yvm.call(func.name);
		}else{
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ErrorManager.UNKNOWN_ERROR);
		}
	}

	void openBlocFunction(String nom){
		last_function = (IdFunction) Yaka.tabIdent.chercheIdent(nom);
		Yaka.yvm.etiquette(nom);
	}

	void checkReturnFunction(){
		if(last_function.type.equals(types.pop())){
			types.push(last_function.type);
		}else{
			types.push(Type.ERROR);
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, last_function.name, ErrorManager.WRONG_RETURN_TYPE);
		}
	}

	public Type getType(){
		return types.pop();
	}

}
