
public class Declaration {

	protected int offset;
	protected int offsetParam;
	protected int numberParam;
	protected int numberVar;
	protected Type lastType; 
	protected String lastConstanteName;
	protected IdFunction lastFunction;

	public Declaration() {
		this.offset = 0;
		this.offsetParam = 2;
		this.numberParam = 0;
		this.numberVar = 0;
	}

	// Variables : 
	public void defType(Type _type){
		lastType = _type;
	}

	public void defVariable(String _nom){
		if (!(Yaka.tabIdent.existeLocalIdent(_nom)) && !(Yaka.tabIdent.existeIdent(_nom))){
			Yaka.tabIdent.rangeLocalIdent(_nom, new IdVar(lastType, offset));
			offset -= 2;
			numberVar++;
		}else{
			ErrorManager.errorDeclaration(Yaka.token.beginLine, _nom, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}

	// Constantes :
	public void defConstante(String _nom){
		lastConstanteName = _nom;
	}

	public void setConstante(Type _type, int _valeur) {//throws ErrorException{
		if (!(Yaka.tabIdent.existeIdent(lastConstanteName)) && !(Yaka.tabIdent.existeLocalIdent(lastConstanteName))){
			Yaka.tabIdent.rangeLocalIdent(lastConstanteName, new IdConst(_type, _valeur));
		}else{
			ErrorManager.errorDeclaration(Yaka.token.beginLine, lastConstanteName, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}

	public void setConstante(String ident) {
		if (!(Yaka.tabIdent.existeLocalIdent(lastConstanteName))){
			IdConst cst = (IdConst) Yaka.tabIdent.chercheLocalIdent(ident);
			if(cst != null){ 
				Yaka.tabIdent.rangeLocalIdent(lastConstanteName, new IdConst(cst.type, cst.value));
			}else{
				ErrorManager.errorDeclaration(Yaka.token.beginLine, ident, ErrorManager.IDENT_DOESNT_EXIST);
			}
		}else{
			ErrorManager.errorDeclaration(Yaka.token.beginLine, ident, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}

	public void defParam(String _nom){
		if (!(Yaka.tabIdent.existeIdent(_nom)) && !(Yaka.tabIdent.existeLocalIdent(_nom))){
			Yaka.tabIdent.rangeLocalIdent(_nom, new IdParam(lastType, ++numberParam));
			lastFunction.addParam(lastType);
			offsetParam+=2;
		}else{
			ErrorManager.errorDeclaration(Yaka.token.beginLine, _nom, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}

	public void declareFunction(String _nom){	
		if (!(Yaka.tabIdent.existeIdent(_nom)) && !(Yaka.tabIdent.existeLocalIdent(_nom))){
			Yaka.tabIdent.rangeIdent(_nom, new IdFunction(_nom, lastType));
			lastFunction = (IdFunction) Yaka.tabIdent.chercheIdent(_nom);
			offset -=2;		
		}else{
			ErrorManager.errorDeclaration(Yaka.token.beginLine, _nom, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}

	
	public void endFunction(){
		Yaka.tabIdent.clearLocalTable();
		this.offset = 0;
		this.offsetParam = 2;
		Yaka.yvm.fermeBloc(numberParam*2);
		numberParam = 0;
		numberVar = 0;
	}

	public int getCurrentOffset(){
		return numberVar * 2;
	}

	public int getCurrentOffsetParam(){
		return this.offsetParam;
	}
	
	public void refreshOffsetParam(){
		for(Ident param : Yaka.tabIdent.getLocalTable().values())
			((IdParam) param).offset = numberParam*2 + 4 - (((IdParam) param).offset * 2);
	}
}	

