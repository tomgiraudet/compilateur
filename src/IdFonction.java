
import java.util.ArrayList;
import java.util.List;

public class IdFonction {
	
	public IdFonction(Type type) {
		super(type);
		this.paramTypes = new ArrayList<Type>();
	}
	
	public void addParam(Type type) {
		this.paramTypes.add(type);
	}
	
	

	
}
