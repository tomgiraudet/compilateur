import java.util.List;
import java.util.ArrayList;


public class IdFunction extends Ident {
	
	protected String name;
	protected Type return_type;
	protected List<Type> paramList;
	
	// constructeur
	public IdFunction(String _name, Type _type){
		super(_type);
		paramList = new ArrayList<Type>();
	}
	
	// ajouter un paramètre à la fonction
	public void addParam(Type type) {
		paramList.add(type);
	}
	
	// retourne le nombre de paramètre(s) ajouté(s) à la fonction
	public int getNbParameters() {
		return paramList.size();
	}
	
	// retourne le type de param i
	public Type getTypeOfParameter(int i) {
		return paramList.get(i);
	}
	
	// FONCTIONS DE TEST :
		public boolean isConst() {
			return false;
		}
		
		public boolean isVar() {
			return false;
		}
		
		public boolean isFunction() {
			return true;
		}
		
		public boolean isParam() {
			return false;
		}
}