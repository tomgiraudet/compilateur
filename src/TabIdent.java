import java.util.HashMap;

public class TabIdent {

	private HashMap<String,Ident> table;
<<<<<<< HEAD
	private HashMap<String, Ident> tableLocale;
	
	public TabIdent(){
		table = new HashMap<String,Ident>();
		tableLocale = new HashMap<String,Ident>();
=======
	private HashMap<String, Ident> localTable;
	
	public TabIdent(){
		table = new HashMap<String,Ident>();
		localTable = new HashMap<String,Ident>();
>>>>>>> 251d3c04a79c7d19cfef76a01266c2b6b5f54536
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
	
<<<<<<< HEAD
	public void rangeIdentLocal(String clef, Ident id){
		tableLocale.put(clef, id);
	}
	
	public void clear(){
		tableLocale.clear();
	}
	
=======
	
	
	
	public Ident chercheLocalIdent(String clef){
		return localTable.get(clef);
	}
	
	public boolean existeLocalIdent(String clef){
		return localTable.containsKey(clef);
	}
	
	public void rangeLocalIdent(String clef, Ident id){
		localTable.put(clef, id);
	}
	
	public void clearLocalTable(){
		localTable.clear();
	}
>>>>>>> 251d3c04a79c7d19cfef76a01266c2b6b5f54536
}
