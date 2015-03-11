
public class IdConst extends Ident {
	
	protected int value;
	
	public IdConst(Type _type, int _value){
		super(_type);
		value = _value;
	}
	
	public int getValue(){
		return value;
	}
	
	public boolean isConst() {
		return true;
	}
	
	public boolean isVar() {
		return false;
	}

}
