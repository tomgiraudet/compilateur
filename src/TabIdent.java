import java.util.HashMap;

public class TabIdent {

	int taille;
	private HashMap<String,Ident> table;
	
	public TabIdent(int taille){
		this.taille = taille;
		table = new HashMap<String,Ident>(taille);
	}
	
	public Ident chercheIdent(String clef){
		
	}
	
	public boolean existeIdent(String clef){
		return table.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id){
		
	}
}
