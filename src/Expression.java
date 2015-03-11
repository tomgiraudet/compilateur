import java.util.Stack;

public class Expression {
	Stack<Type> types = new Stack<Type>();
	Stack<Operator> operations = new Stack<Operator>();
	
	
	void ajoutType(Type t){
		types.push(t);
	}
	
	void ajoutOp(Operator op){
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
	
	Type testStacks(){
		while(operations.peek() != null){
			switch(operations.pop()){
			case PLUS :
			case MOINS :
			case MUL :
			case DIV :
				types.push(testAddSubMulDiv(types.pop(), types.pop()));
			break;
			case INF :
			case SUP :
			case INFE :
			case SUPE :
				types.push(testSupInf(types.pop(), types.pop()));
			break;
			case EQU :
			case DIFF :
				types.push(testEQU(types.pop(), types.pop()));
			break;
			case OR :
			case AND :
				types.push(testAndOr(types.pop(), types.pop()));
			break;
			default :
				types.push(Type.ERROR);
			}
		}
	}
	
}