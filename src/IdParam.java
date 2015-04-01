
public class IdParam extends Ident {
	
	protected int offset;
	
	public IdParam(Type _type, int _offset){
		super(_type);
		offset = _offset;
	}
	
	public int getOffset(){
		return offset;
	}
	
	// FONCTIONS DE TEST :
		public boolean isConst() {
			return false;
		}
		
		public boolean isVar() {
			return false;
		}
		
		public boolean isFunction() {
			return false;
		}
		
		public boolean isParam() {
			return true;
		}
}