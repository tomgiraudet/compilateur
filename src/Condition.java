import java.util.Stack;
public class Condition {
	private Stack<Integer> imbrication;
	private int idIteration;
	
	
	public Condition() {
		this.imbrication = new Stack<Integer>();
		idIteration = 1;
	}
	
	public void testCondition(){
		Yaka.yvm.iffaux("SINON"+idIteration);
	}
	
	public void si(){
		imbrication.push(idIteration);
	}
	
	public void alors(){
		idIteration++;
	}
	
	public void sinon(){
		int a = imbrication.peek();
		Yaka.yvm.togoto("FSI"+a);
		Yaka.yvm.etiquette("SINON"+a);
	}
	
	public void fsi(){
		int a = imbrication.pop();
		Yaka.yvm.etiquette("FSI"+a);
	}
}
