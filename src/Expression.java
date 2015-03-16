import java.util.Stack;
public class Expression {
	private Stack<Type> types;
	private Stack<Operator> operations;
	private Ident identAffect;
	
	public Expression() {
		this.types = new Stack<Type>();
		this.operations = new Stack<Operator>();
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
		while(!operations.isEmpty()){				
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
		//	throw new ErrorException(op+" n'est pas la negation");
		}
	}
	
	void NegationBool(){
		Operator op = this.operations.pop();
		if(op==Operator.NOT) {
		Yaka.yvm.inot();
		} else {
		//	throw new ErrorException(op+" n'est pas le non");
		}
	}

	public void pushBoolean(int a) {
		this.types.push(Type.BOOL);
		Yaka.yvm.iconst(a);
	}
	
	
	public void pushIdent(String id) {
		Ident ident = Yaka.tabIdent.chercheIdent(id);
		if(ident!=null) {
			this.types.push(ident.getType());
			if(ident.isVar()) {
				Yaka.yvm.iload(((IdVar)ident).getOffset());
			} else if(ident.isConst()) {
				Yaka.yvm.iconst(((IdConst)ident).getValue());
			} else {
	//			throw new ErrorException(id+" isn't a constant or a variable");
			}
		} else {
			this.types.push(Type.ERROR);
		//	throw ErrorException("Ident in parameter is null");
		}
	}
	
	void setAffectation(String nom) {
		if(Yaka.tabIdent.existeIdent(nom)) {
			identAffect = Yaka.tabIdent.chercheIdent(nom);
		} else {
			//throw ErrorException(nom+" don't exist");
		}
	}

	void affectation() {
		Type varType = identAffect.getType();
		Type valType = types.pop();
		
		if(this.identAffect.isVar()) {
			if(varType==valType) {
				Yaka.yvm.istore(((IdVar)identAffect).getOffset());
			} else {
				//throw ErrorException("Types don't match at the affectation.");
				
				if(valType==Type.ERROR) {
					//throw ErrorException("Error in the expression.");
				
				} else {
					//throw ErrorException("Type issue.");
				}
			}
			
		} else {
			//throw ErrorException("This isn't a variable");
		}
	}
	
	public Type getType(){
		return types.pop();
	}
	
}
