
public class ErrorManager {
	
	static String NOT_CONSTANT_OR_VARIABLE 	= " this isn't a constant or a variable";
	static String IDENT_DOESNT_EXIST		= " has not been declared";
	static String MISMATCH_TYPES			= " types don't match";
	static String ERROR_IN_EXPRESSION 		= " error in expression";
	static String TYPE_ISSUE				= " type issue";
	static String WRONG_OPERATOR			= " wrong operator";
	static String IDENT_ALREADY_EXISTS		= " already exists";
	static String UNKNOWN_ERROR				= " Whaaat ???";
	static String WRONG_TYPE_PARAMETERS		= " wrong types of parameters";
	static String WRONG_NUMBER_PARAMETERS	= " wrong number of parameters";
	static String WRONG_RETURN_TYPE			= " wrong return type";
	static String FUNCTION_AFFECTATION		= " impossible to affect a function";
	static String IMPOSSIBLE_AFFECTION		= " affectation is impossible";
	static String ILLEGAL_MAIN				= " illegale return";
	
	public static void errorDeclaration(int _lineError, String _identError, String _typeError){
		System.err.println("Line " + _lineError + " : " + _identError + _typeError);
	}
	
	public static void errorDeclaration(int _lineError, String _typeError){
		System.err.println("Line " + _lineError + " :"+ _typeError);
	}
}
