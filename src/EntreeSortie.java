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
		} else {
			// Erreur
		}
	}
	
	void ecrireChaine(String str) {
		str = str.substring(1, str.length()-1);
		Yaka.yvm.ecrireChaine(str);
	}
	
	void lire(String ident) {
		if(Yaka.tabIdent.existeIdent(ident)) {
			if(Yaka.tabIdent.chercheIdent(ident).isVar()) {
				Yaka.yvm.lireEnt(((IdVar)Yaka.tabIdent.chercheIdent(ident)).getOffset());
			}
		} else {
			// Erreur
		}
	}
}
