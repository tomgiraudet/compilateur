import java.util.HashMap;

public class TabIdent {

	private HashMap<String,Ident> table;
	private HashMap<String, Ident> localTable;
	
	public TabIdent(){
		table = new HashMap<String,Ident>();
		localTable = new HashMap<String,Ident>();
	}
	
	public Ident chercheIdent(String clef){
		return table.get(clef);
	}
	
	public boolean existeIdent(String clef){
		return table.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id){
		table.put(clef, id);
	}
	
	public void clearLocalTable(){
		localTable.clear();
	}
}
