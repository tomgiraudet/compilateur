
public class Declaration {
	
	protected int offset;
	protected int offsetParam;
	protected Type lastType; 
	protected String lastConstanteName;
	protected IdFunction lastFunction;
	
	public Declaration() {
		this.offset = 0;
		this.offsetParam = 2;
	}
	
	// Variables : 
	public void defType(Type _type){
		lastType = _type;
	}
	
	public void defVariable(String _nom){
		if (!(Yaka.tabIdent.existeLocalIdent(_nom))){
			Yaka.tabIdent.rangeLocalIdent(_nom, new IdVar(lastType, offset));
			offset -= 2;
		}else{
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, _nom, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}
		
	// Constantes :
	public void defConstante(String _nom){
		lastConstanteName = _nom;
	}
	
	public void setConstante(Type _type, int _valeur) {//throws ErrorException{
		if (!(Yaka.tabIdent.existeIdent(lastConstanteName))){
			Yaka.tabIdent.rangeIdent(lastConstanteName, new IdConst(_type, _valeur));
		}else{
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, lastConstanteName, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}
	
	public void setConstante(String ident) {
		if (!(Yaka.tabIdent.existeIdent(lastConstanteName))){
			IdConst con = (IdConst) Yaka.tabIdent.chercheIdent(ident);
				if(con != null){ 
				Yaka.tabIdent.rangeIdent(lastConstanteName, new IdConst(con.type, con.value));
				}else{
				ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ident, ErrorManager.IDENT_DOESNT_EXIST);
				}
		}else{
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, ident, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}
	
	// Param :

	public void defParam(String _nom){
		if (!(Yaka.tabIdent.existeLocalIdent(_nom))){
			Yaka.tabIdent.rangeLocalIdent(_nom, new IdParam(lastType, offsetParam));
			lastFunction.addParam(lastType);
			offsetParam +=2;
		}else{
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, _nom, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}
	
	public void declareFunction(String _nom){
		if (!(Yaka.tabIdent.existeIdent(_nom))){
			Yaka.tabIdent.rangeIdent(_nom, new IdFunction(_nom, lastType));
			lastFunction = (IdFunction) Yaka.tabIdent.chercheIdent(_nom);
			offset -=2;
		}else{
			ErrorManager.errorDeclaration(YakaTokenManager.currentLine, _nom, ErrorManager.IDENT_ALREADY_EXISTS);
		}
	}
	
	public void endFunction(){
		Yaka.tabIdent.clearLocalTable();
		this.offset = 0;
		this.offsetParam = 2;
	}
	
	// Offset :
	public int getCurrentOffset(){
		return this.offset+2;
	}
	
	public int getCurrentOffsetParam(){
		return this.offsetParam-2;
	}
}	

