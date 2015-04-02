
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
	@Override
		public boolean isConst() {
			return false;
		}
		
	@Override
		public boolean isVar() {
			return false;
		}
		
	@Override
		public boolean isFunction() {
			return false;
		}
		
	@Override
		public boolean isParam() {
			return true;
		}
}