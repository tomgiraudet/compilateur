
public abstract class Ident {
	
	protected Type type;
	
	public Ident(Type _type){
	 type = _type;	
	}
	
	public Type getType(){
		return type;
	}
	
	public abstract boolean isVar();
	public abstract boolean isConst();
	
	
}
