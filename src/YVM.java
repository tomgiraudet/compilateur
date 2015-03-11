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
		Ecriture.ecrireStringln(this.out,"entete\n");		
	}
	
	public void enqueue (){
		Ecriture.ecrireStringln(this.out,"queue\n");		
	}
	
	// Arithmetique
	public void iadd (){
		System.out.println("called");
		Ecriture.ecrireStringln(this.out,"iadd\n");		
	}
	
	public void isub (){
		Ecriture.ecrireStringln(this.out,"isub\n");
	}
	
	public void imul (){
		Ecriture.ecrireStringln(this.out,"imul\n");
	}
	
	public void idiv(){
		Ecriture.ecrireStringln(this.out,"idiv\n");
	}
	
	public void inot(){
		Ecriture.ecrireStringln(this.out,"inot\n");
	}
	
	public void ineg(){
		Ecriture.ecrireStringln(this.out,"ineg\n");
	}
	
	public void ior(){
		Ecriture.ecrireStringln(this.out,"ior\n");
	}
	
	public void iand (){
		Ecriture.ecrireStringln(this.out,"iand\n");
	}
	
	//Comparaison
	public void iinf(){
		Ecriture.ecrireStringln(this.out,"iinf\n");
	}
	
	public void isup(){
		Ecriture.ecrireStringln(this.out,"isup\n");
	}
	
	public void iinfegal(){
		Ecriture.ecrireStringln(this.out,"iinfegal\n");
	}
	
	public void isupegal(){
		Ecriture.ecrireStringln(this.out,"isupegal\n");
	}
	
	public void iegal(){
		Ecriture.ecrireStringln(this.out,"iegal\n");
	}
	
	public void idiff(){
		Ecriture.ecrireStringln(this.out,"idiff\n");
	}
	
	//Stockage et chargement
	public void iload (int offset){
		Ecriture.ecrireStringln(this.out,"iload " + offset + "\n");
	}
	
	public void istore (int offset){
		Ecriture.ecrireStringln(this.out,"istore " + offset + "\n");
	}
	
	public void iconst (int val){
		Ecriture.ecrireStringln(this.out,"iconst " + val + "\n");
	}
	
	//Controle de flot
	public void ifeq (String etiquette){
		Ecriture.ecrireStringln(this.out,"ifeq " + etiquette + "\n");
	}
	
	public void iffaux (String etiquette){
		Ecriture.ecrireStringln(this.out,"iffaux " + etiquette + "\n");
	}
	
	public void togoto (String etiquette){
		Ecriture.ecrireStringln(this.out,"goto " + etiquette + "\n");
	}
	
	//Instruction de pile
	public void ouvrePrinc (int nbVariable){
		Ecriture.ecrireStringln(this.out,"ouvrePrinc " + nbVariable + "\n");
	}
	
	//Entree - sortie
	public void ecrireEnt (){
		Ecriture.ecrireStringln(this.out,"ecrireEnt\n");
	}
	
	public void ecrireChaine (String chaine){
		Ecriture.ecrireStringln(this.out,"ecrireChaine \"" + chaine + "\"\n");
	}
	
	public void ecrireBool (){
		Ecriture.ecrireStringln(this.out,"ecrireBool\n");
	}
	
	public void lireEnt (int entier) {
		Ecriture.ecrireStringln(this.out,"lireEnt " + entier + "\n");
	}
	
	public void aLaLigne (){
		Ecriture.ecrireStringln(this.out,"aLaLigne\n");
	}
	
}
