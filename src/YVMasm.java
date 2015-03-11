
public class YVMasm extends YVM {
	
	private int nbMessage = 1; 
	
	public YVMasm(String _fileName){
		super(_fileName);
	}
	
	// Debut-Fin de code
	public void entete (){
		Ecriture.ecrireStringln(super.out, ".model SMALL");
		Ecriture.ecrireStringln(super.out, ".586");
		Ecriture.ecrireStringln(super.out, ".CODE");
		Ecriture.ecrireStringln(super.out, "debut :");
		Ecriture.ecrireStringln(super.out, "	STARTUPCODE");
	}
	
	public void enqueue (){
		Ecriture.ecrireStringln(super.out, "	nop");
		Ecriture.ecrireStringln(super.out, "	EXITCODE");
		Ecriture.ecrireStringln(super.out, "	end debut");
	}
	
	// Arithmetique
		public void iadd (){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	add ax,bx");
			Ecriture.ecrireStringln(super.out, "	push ax");
		}
		
		public void isub (){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	sub ax,bx");
			Ecriture.ecrireStringln(super.out, "	push ax");
		}
		
		public void imul (){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	imul bx");
			Ecriture.ecrireStringln(super.out, "	push ax");
		}
		
		public void idiv(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cwd");
			Ecriture.ecrireStringln(super.out, "	idiv bx");
			Ecriture.ecrireStringln(super.out, "	push ax");
		}
		
		public void inot(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	not bx");
			Ecriture.ecrireStringln(super.out, "	push ax");
		}
		
		public void ineg(){
			iconst(-1);
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	neg ax");
			Ecriture.ecrireStringln(super.out, "	push ax");
		}
		
		public void ior(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	or ax,bx");
			Ecriture.ecrireStringln(super.out, "	push ax");
		}
		
		public void iand (){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	and ax,bx");
			Ecriture.ecrireStringln(super.out, "	push ax");
		}
		
		//Comparaison
		public void iinf(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jge $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0");
		}
		
		public void isup(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jle $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0");
		}
		
		public void iinfegal(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jg $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0");
		}
		
		public void isupegal(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jl $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0");
		}
		
		public void iegal(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jne $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0");
		}
		
		public void idiff(){
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	je $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0");
		}
		
		//Stockage et chargement
		public void iload (int offset){
			Ecriture.ecrireStringln(super.out, "	push word ptr [bp+ " + offset + "]");
		}
		
		public void istore (int offset){
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	mov word ptr [bp+ " + offset + "], ax");
		}
		
		public void iconst (int val){
			Ecriture.ecrireStringln(super.out, "	push " + val);
		}
		
		//Controle de flot
		public void ifeq (String etiquette){
			Ecriture.ecrireStringln(super.out, "	pop ax");		// pas sure que �a soit ax la valeur en sommet de pile
			Ecriture.ecrireStringln(super.out, "	cmp ax,0");
			Ecriture.ecrireStringln(super.out, "	je " + etiquette);
		}
		
		public void iffaux (String etiquette){
			Ecriture.ecrireStringln(super.out, "	pop ax");			// pas sure que �a soit ax la valeur en sommet de pile
			Ecriture.ecrireStringln(super.out, "	cmp ax,0");		// comparer des booleens en asm? "test" ...
			Ecriture.ecrireStringln(super.out, "	je " + etiquette);
		}
		
		public void togoto (String etiquette){
			Ecriture.ecrireStringln(super.out, "	jmp" + etiquette);	
		}
		
		//Instruction de pile
		public void ouvrePrinc (int nbVariable){
			Ecriture.ecrireStringln(super.out, "	mov bp, sp");
			Ecriture.ecrireStringln(super.out, "	sub sp " + nbVariable);
		}
		
		//Entree - sortie
		public void ecrireEnt (){
			Ecriture.ecrireStringln(this.out,"	call ecrent");
		}
		
		public void ecrireChaine (String chaine){
			Ecriture.ecrireStringln(this.out, ".DATA");
			Ecriture.ecrireStringln(this.out,"	mess" + nbMessage + " DB \"" + chaine + "=$\"");
			Ecriture.ecrireStringln(this.out, ".CODE");
			Ecriture.ecrireStringln(this.out,"	lea dx, mess" + nbMessage);
			Ecriture.ecrireStringln(this.out,"	push dx");
			Ecriture.ecrireStringln(this.out,"	call ecrch");
			nbMessage++;
		}
		
		public void ecrireBool (){
			Ecriture.ecrireStringln(this.out,"	call ecrbool");
		}
		
		public void lireEnt (int entier) {
			Ecriture.ecrireStringln(this.out,"	lea dx, [bp" + entier + "]");
			Ecriture.ecrireStringln(this.out,"	push dx");
			Ecriture.ecrireStringln(this.out,"	ecrire lirent");
		}
		
		public void aLaLigne (){
			Ecriture.ecrireStringln(this.out,"	call ligsuiv");
		}

}
