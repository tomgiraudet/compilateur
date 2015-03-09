import java.util.Stack;

public class Expression {
	Stack<Type> types = new Stack<Type>();
	Stack<Op> operations = new Stack<Op>();
	
	
	void ajoutType(Type t){
		types.push(t);
	}
	
	void ajoutOp(Op op){
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
		while(operations.peek() != NULL){
			switch(operations.pop()){
			case Op.PLUS :
			case Op.MOINS :
			case Op.MUL :
			case Op.DIV :
				types.push(testAddSubMulDiv(types.pop(), types.pop()));
			break;
			case Op.INF :
			case Op.SUP :
			case Op.INFE :
			case Op.SUPE :
				types.push(testSupInf(types.pop(), types.pop()));
			break;
			case Op.EQU :
			case Op.DIFF :
				types.push(testEQU(types.pop(), types.pop()));
			break;
			case Op.OR :
			case Op.AND :
				types.push(testAndOr(types.pop(), types.pop()));
			break;
			default :
				types.push(Type.ERROR);
			}
		}
	}
	
}