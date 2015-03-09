
public class Declaration {
	
	protected int offset;
	protected Type lastType; // Utile pour des déclarations du type public int a,b,c,d
	protected String lastConstanteName;
	

	
	// lit une variable ou une constante et son type (+ sa valeur si c'est une constante)
	// et ça la range avec un certain offset si c'est une variable ou sa valeur si c'est une constante dans TabIdent.
	
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
		// Penser à rajouter l'erreur si la variable est déjà présente dans la table (If + erreur)
	}
	
	/*public void setVariable(String _nom, int _valeur){
		if(Yaka.tabIdent.existeIdent(_nom)){
			Ident clef = Yaka.tabIdent.rechercheIdent(_nom);
			
			
		}// Penser au else pour l'envoie de l'erreur
		
	}*/
	
	// Constantes :
	public void defConstante(String _nom){
		lastConstanteName = _nom;
	}
	public void setConstante(Type _type, int _valeur){
		Yaka.TabIdent.rangeIdent(lastConstanteName, new IdConst(_type, offset));
		offset -=2;
		// Penser à rajouter l'erreur si la constante est déjà présente dans la table (If + erreur)
	}
	public void setConstante(String _ident){}
	
	
	
	
}
