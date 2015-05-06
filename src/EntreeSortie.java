public class EntreeSortie {
	
	void newLine() {
		Yaka.yvm.aLaLigne();
	}
	
	void ecrire() {
		Type type = Yaka.expression.getType();
		if(type==Type.BOOL) {
			Yaka.yvm.ecrireBool();
		} else if(type==Type.INT) {
			Yaka.yvm.ecrireEnt();
		}else{
			ErrorManager.errorDeclaration(Yaka.token.beginLine, ErrorManager.MISMATCH_TYPES);
		}
	}
	
	void ecrireChaine(String str) {
		str = str.substring(1, str.length()-1);
		Yaka.yvm.ecrireChaine(str);
	}
	
	void lire(String ident) {
		if(Yaka.tabIdent.existeLocalIdent(ident)) {
			if(Yaka.tabIdent.chercheLocalIdent(ident).isVar()) {
				Yaka.yvm.lireEnt(((IdVar)Yaka.tabIdent.chercheLocalIdent(ident)).getOffset());
			}
		}else{
			ErrorManager.errorDeclaration(Yaka.token.beginLine, ident, ErrorManager.IDENT_DOESNT_EXIST);
		}
	}
}
