import java.util.Stack;
public class Iteration {
	private Stack<Integer> imbrication;
	private int idIteration;
	
	public Iteration() {
		this.imbrication = new Stack<Integer>();
		idIteration = 0;
	}
	
	public void pushIteration(){
		imbrication.push(idIteration);
		Yaka.yvm.etiquette("Faire"+idIteration);
		idIteration++;
	}
	
	public void popIteration(){
		Yaka.yvm.etiquette("fait"+imbrication.pop());
	}
	
}
