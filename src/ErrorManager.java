
public class ErrorManager {
	
	static String NOT_CONSTANT_OR_VARIABLE 	= " isn't a constant or a variable";
	static String IDENT_DOESNT_EXIST		= " has not been declared";
	static String MISMATCH_TYPES			= " types don't match at the affectation";
	static String ERROR_IN_EXPRESSION 		= " error in expression";
	static String TYPE_ISSUE				= " type issue";
	static String WRONG_OPERATOR			= " wrong operator";
	static String IDENT_ALREADY_EXISTS		= " already exists";
	static String YVO_NOT_PRESENT			= " Yvo va arriver bient™t";
	
	public static void errorDeclaration(int _lineError, String _identError, String _typeError){
		System.out.println("Line " + _lineError + " : " + _identError + _typeError);
	}
	public static void errorDeclaration(int _lineError, String _typeError){
		System.out.println("Line " + _lineError + " :"+ _typeError);
	}
}
