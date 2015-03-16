
public class Declaration {
	
	protected int offset;
	protected Type lastType; // Utile pour des d�clarations du type public int a,b,c,d
	protected String lastConstanteName;
	

	
	// lit une variable ou une constante et son type (+ sa valeur si c'est une constante)
	// et �a la range avec un certain offset si c'est une variable ou sa valeur si c'est une constante dans TabIdent.
	
	public Declaration() {
		this.offset = -2;
	}
	
	// Variables : 
	public void defTypeVariable(Type _type){
		lastType = _type;
	}
	
	public void defVariable(String _nom){
		Yaka.tabIdent.rangeIdent(_nom, new IdVar(lastType, offset));
		offset -= 2;
		// Penser � rajouter l'erreur si la variable est d�j� pr�sente dans la table (If + erreur)
	}
		
	// Constantes :
	public void defConstante(String _nom){
		lastConstanteName = _nom;
	}
	
	public void setConstante(Type _type, int _valeur) {//throws ErrorException{
		if (!(Yaka.tabIdent.existeIdent(lastConstanteName))){
			Yaka.tabIdent.rangeIdent(lastConstanteName, new IdConst(_type, _valeur));
			//offset -=2;
		}else{
			//throw new ErrorException("Constant already exists");
		}
	}
	
	public void setConstante(String ident) {//throws ErrorException{
		if (!(Yaka.tabIdent.existeIdent(lastConstanteName))){
			IdConst con = (IdConst) Yaka.tabIdent.chercheIdent(ident);
			if(con != null) Yaka.tabIdent.rangeIdent(lastConstanteName, new IdConst(con.type, con.value));
			//else throw new ErrorException("Constant doesn't exist");
			//offset -=2;
		}else{
			//throw new ErrorException("Constant already exists");
		}
	}
	
	
	public int getCurrentOffset(){
		return this.offset+2;
	}
}	

