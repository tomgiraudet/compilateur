
public abstract class Ident {
	
	protected Type type;
	
	public Ident(Type _type){
	 type = _type;	
	}
	
	public Type getType(){
		return type;
	}
	
	abstract public boolean isVar();
	abstract public boolean isConst();
	abstract public boolean isFunction();
	abstract public boolean isParam();
	
	
}
