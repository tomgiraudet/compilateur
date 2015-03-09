
import java.util.ArrayList;
import java.util.List;

public class IdFonction extends Ident {
	
	public IdFonction(Type type) {
		super(type);
		this.paramTypes = new ArrayList<Type>();
	}
	
	public void addParam(Type type) {
		this.paramTypes.add(type);
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
