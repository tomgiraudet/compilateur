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
		Yaka.yvm.etiquette("FAIRE"+idIteration);
		idIteration++;
	}
	
	public void popIteration(){
		int a = imbrication.pop();
		Yka.yvm.togoto("FAIRE"+a);
		Yaka.yvm.etiquette("FAIT"+a);
	}
	
}
