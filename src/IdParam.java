

	import java.util.ArrayList;
	import java.util.List;

public class IdParam extends Ident {

	public IdParam(Type type, int rank) {
		super(type, 0);
		this.rank = rank;
	}
	
	
	
	public boolean isConst() {
		return false;
	}
	
	public boolean isVar() {
		return false;
	}

	public boolean isParam() {
		return false;
	}
	
	public boolean isFonction() {
		return true;
	}
}
