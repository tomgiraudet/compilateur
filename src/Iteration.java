import java.util.Stack;
public class Iteration {
	private Stack<Integer> imbrication;
	private int idIteration;
	
	public Iteration() {
		this.imbrication = new Stack<Integer>();
		idIteration = 1;
	}
	
	public void testIteration(){
		Yaka.yvm.iffaux("FAIT"+idIteration);
		idIteration++;
	}
	
	public void pushIteration(){
		imbrication.push(idIteration);
		Yaka.yvm.etiquette("FAIRE"+idIteration);
	}
	
	public void popIteration(){
		int a = imbrication.pop();
		Yaka.yvm.togoto("FAIRE"+a);
		Yaka.yvm.etiquette("FAIT"+a);
	}
	
}
