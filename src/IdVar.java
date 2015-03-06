
public class IdVar extends Ident{
	
	protected int offset;
	
	public IdVar(Type _type, int _offset){
		super(_type);
		offset = _offset;
	}
	
	public int getOffset(){
		return offset;
	}

}
