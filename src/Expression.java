import java.util.Stack;

public class Expression {
	Stack<String> types = new Stack<String>();
	Stack<Character> operations = new Stack<Character>();
	
	
	void ajoutType(Type t){
		types.push(t);
	}
	
	void ajoutOp(char op){
		operations.push(op);
	}
	
	Type testAddSubMulDiv(Type type1, Type type2){
		if(type1 == Type.INT){
			if(type2 == Type.INT){
				return Type.INT;
			}
		}
		return Type.ERROR;
	}
	Type testSupInf(Type type1, Type type2){
		if(type1 == Type.INT){
			if(type2 == Type.INT){
				return Type.BOOL;
			}
		}
		return Type.ERROR;
	}
	Type testEQU(Type type1, Type type2){
		if(type1 == Type.INT){
			if(type2 == Type.INT){
				return Type.BOOL;
			}
		}
		if(type1 == Type.BOOL){
			if(type2 == Type.BOOL){
				return Type.BOOL;
			}
		}
		return Type.ERROR;
	}
	Type testAndOr(Type type1, Type type2){
		if(type1 == Type.BOOL){
			if(type2 == Type.BOOL){
				return Type.BOOL;
			}
		}
		return Type.ERROR;
	}
}
