import java.io.OutputStream;

public class YVM {
	
	protected OutputStream out;
	protected String fileName;
	
	public YVM(String _fileName){
		this.fileName = _fileName;
		this.out = Ecriture.ouvrir(this.fileName);
	}
	
	// Debut-Fin de code
	public void entete (){
		Ecriture.ecrireStringln(this.out,"entete");		
	}
	
	public void enqueue (){
		Ecriture.ecrireStringln(this.out,"queue");		
	}
	
	// Arithmetique
	public void iadd (){
		Ecriture.ecrireStringln(this.out,"iadd");		
	}
	
	public void isub (){
		Ecriture.ecrireStringln(this.out,"isub");
	}
	
	public void imul (){
		Ecriture.ecrireStringln(this.out,"imul");
	}
	
	public void idiv(){
		Ecriture.ecrireStringln(this.out,"idiv");
	}
	
	public void inot(){
		Ecriture.ecrireStringln(this.out,"inot");
	}
	
	public void ineg(){
		Ecriture.ecrireStringln(this.out,"ineg");
	}
	
	public void ior(){
		Ecriture.ecrireStringln(this.out,"ior");
	}
	
	public void iand (){
		Ecriture.ecrireStringln(this.out,"iand");
	}
	
	//Comparaison
	public void iinf(){
		Ecriture.ecrireStringln(this.out,"iinf");
	}
	
	public void isup(){
		Ecriture.ecrireStringln(this.out,"isup");
	}
	
	public void iinfegal(){
		Ecriture.ecrireStringln(this.out,"iinfegal");
	}
	
	public void isupegal(){
		Ecriture.ecrireStringln(this.out,"isupegal");
	}
	
	public void iegal(){
		Ecriture.ecrireStringln(this.out,"iegal");
	}
	
	public void idiff(){
		Ecriture.ecrireStringln(this.out,"idiff");
	}
	
	//Stockage et chargement
	public void iload (int offset){
		Ecriture.ecrireStringln(this.out,"iload " + offset);
	}
	
	public void istore (int offset){
		Ecriture.ecrireStringln(this.out,"istore " + offset);
	}
	
	public void iconst (int val){
		Ecriture.ecrireStringln(this.out,"iconst " + val);
	}
	
	//Controle de flot
	public void ifeq (String etiquette){
		Ecriture.ecrireStringln(this.out,"ifeq " + etiquette);
	}
	
	public void iffaux (String etiquette){
		Ecriture.ecrireStringln(this.out,"iffaux " + etiquette);
	}
	
	public void togoto (String etiquette){
		Ecriture.ecrireStringln(this.out,"goto " + etiquette);
	}
	
	//Instruction de pile
	public void ouvrePrinc (int nbVariable){
		Ecriture.ecrireStringln(this.out,"ouvrePrinc " + nbVariable);
	}
	
	//Entree - sortie
	public void ecrireEnt (){
		Ecriture.ecrireStringln(this.out,"ecrireEnt");
	}
	
	public void ecrireChaine (String chaine){
		Ecriture.ecrireStringln(this.out,"ecrireChaine \"" + chaine + "\"");
	}
	
	public void ecrireBool (){
		Ecriture.ecrireStringln(this.out,"ecrireBool");
	}
	
	public void lireEnt (int entier) {
		Ecriture.ecrireStringln(this.out,"lireEnt " + entier);
	}
	
	public void aLaLigne (){
		Ecriture.ecrireStringln(this.out,"aLaLigne");
	}
	
}
