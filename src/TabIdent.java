import java.util.HashMap;

public class TabIdent {

	private HashMap<String,Ident> table;
	private HashMap<String, Ident> tableLocale;
	
	public TabIdent(){
		table = new HashMap<String,Ident>();
		tableLocale = new HashMap<String,Ident>();
	}
	
	public Ident chercheIdent(String clef){
		return table.get(clef);
	}
	
	public Ident chercheIdentLocale(String clef){
		return tableLocale.get(clef);
	}
	
	public boolean existeIdent(String clef){
		return table.containsKey(clef);
	}
	
	public boolean existeIdentLocal(String clef){
		return tableLocale.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id){
		table.put(clef, id);
	}
	
	public void rangeIdentLocal(String clef, Ident id){
		tableLocale.put(clef, id);
	}
	
	public void clear(){
		tableLocale.clear();
	}
	
}
