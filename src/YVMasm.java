
public class YVMasm extends YVM {
	
	private int nbMessage = 0; 
	
	public YVMasm(String _fileName){
		super(_fileName);
	}
	
	// Debut-Fin de code
	public void entete (){
		Ecriture.ecrireStringln(super.out, "	; entete");
		Ecriture.ecrireStringln(super.out, "	extrn lirent:proc, ecrent:proc");
		Ecriture.ecrireStringln(super.out, "	extrn ecrbool:proc, ecrch:proc");
		Ecriture.ecrireStringln(super.out, "	extrn ligsuiv:proc");
		Ecriture.ecrireStringln(super.out, ".model SMALL");
		Ecriture.ecrireStringln(super.out, ".586\n");
		Ecriture.ecrireStringln(super.out, ".CODE");
		Ecriture.ecrireStringln(super.out, "debut:");
		Ecriture.ecrireStringln(super.out, "	STARTUPCODE");
	}
	
	public void enqueue (){
		Ecriture.ecrireStringln(super.out, "	;queue");
		Ecriture.ecrireStringln(super.out, "	nop");
		Ecriture.ecrireStringln(super.out, "	EXITCODE");
		Ecriture.ecrireStringln(super.out, "	End debut\n");
	}
	
	// Arithmetique
		public void iadd (){
			Ecriture.ecrireStringln(super.out, "	;iadd");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	add ax,bx");
			Ecriture.ecrireStringln(super.out, "	push ax\n");
		}
		
		public void isub (){
			Ecriture.ecrireStringln(super.out, "	;isub");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	sub ax,bx");
			Ecriture.ecrireStringln(super.out, "	push ax\n");
		}
		
		public void imul (){
			Ecriture.ecrireStringln(super.out, "	;imul");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	imul bx");
			Ecriture.ecrireStringln(super.out, "	push ax\n");
		}
		
		public void idiv(){
			Ecriture.ecrireStringln(super.out, "	;idiv");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cwd");
			Ecriture.ecrireStringln(super.out, "	idiv bx");
			Ecriture.ecrireStringln(super.out, "	push ax\n");
		}
		
		public void inot(){
			Ecriture.ecrireStringln(super.out, "	;inot");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	not bx");
			Ecriture.ecrireStringln(super.out, "	push ax\n");
		}
		
		public void ineg(){
			Ecriture.ecrireStringln(super.out, "	;ineg");
			//iconst(-1);
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	mov ax, 0");
			Ecriture.ecrireStringln(super.out, "	sub ax, bx");
			Ecriture.ecrireStringln(super.out, "	push ax\n");
		}
		
		public void ior(){
			Ecriture.ecrireStringln(super.out, "	;ior");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	or ax,bx");
			Ecriture.ecrireStringln(super.out, "	push ax\n");
		}
		
		public void iand (){
			Ecriture.ecrireStringln(super.out, "	;iand");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	and ax,bx");
			Ecriture.ecrireStringln(super.out, "	push ax\n");
		}
		
		//Comparaison
		public void iinf(){
			Ecriture.ecrireStringln(super.out, "	;iinf");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jge $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0\n");
		}
		
		public void isup(){
			Ecriture.ecrireStringln(super.out, "	;isup");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jle $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0\n");
		}
		
		public void iinfegal(){
			Ecriture.ecrireStringln(super.out, "	;iinfegal");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jg $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0\n");
		}
		
		public void isupegal(){
			Ecriture.ecrireStringln(super.out, "	;isupegal");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jl $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0\n");
		}
		
		public void iegal(){
			Ecriture.ecrireStringln(super.out, "	;iegal");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	jne $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0\n");
		}
		
		public void idiff(){
			Ecriture.ecrireStringln(super.out, "	;idiff");
			Ecriture.ecrireStringln(super.out, "	pop bx");
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	cmp ax,bx");
			Ecriture.ecrireStringln(super.out, "	je $+6");
			Ecriture.ecrireStringln(super.out, "	push -1");
			Ecriture.ecrireStringln(super.out, "	jmp $+4");
			Ecriture.ecrireStringln(super.out, "	push 0\n");
		}
		
		//Stockage et chargement
		public void iload (int offset){
			Ecriture.ecrireStringln(super.out, "	;iload " + offset);
			Ecriture.ecrireStringln(super.out, "	push word ptr [bp" + offset + "]\n");
		}
		
		public void istore (int offset){
			Ecriture.ecrireStringln(super.out, "	;istore " + offset);
			Ecriture.ecrireStringln(super.out, "	pop ax");
			Ecriture.ecrireStringln(super.out, "	mov word ptr [bp" + offset + "], ax\n");
		}
		
		public void iconst (int val){
			Ecriture.ecrireStringln(super.out, "	;iconst " + val);
			Ecriture.ecrireStringln(super.out, "	push word ptr " + val +"\n");
		}
		
		//Controle de flot
		public void ifeq (String etiquette){
			Ecriture.ecrireStringln(super.out, "	;ifeq");
			Ecriture.ecrireStringln(super.out, "	pop ax");		
			Ecriture.ecrireStringln(super.out, "	cmp ax,0");
			Ecriture.ecrireStringln(super.out, "	je " + etiquette +"\n");
		}
		
		public void iffaux (String etiquette){
			Ecriture.ecrireStringln(super.out, "	;iffaux");
			Ecriture.ecrireStringln(super.out, "	pop ax");	
			Ecriture.ecrireStringln(super.out, "	cmp ax,0");		
			Ecriture.ecrireStringln(super.out, "	je " + etiquette +"\n");
		}
		
		public void togoto (String etiquette){
			Ecriture.ecrireStringln(super.out, "	;goto " + etiquette);
			Ecriture.ecrireStringln(super.out, "	jmp" + etiquette +"\n");	
		}
		
		public void etiquette (String etiquette){
			Ecriture.ecrireStringln(super.out, etiquette + ":");
		}
		
		//Instruction de pile
		public void ouvrePrinc (int nbVariable){
			Ecriture.ecrireStringln(super.out, "	;ouvrePrinc " + nbVariable);
			Ecriture.ecrireStringln(super.out, "	mov bp, sp");
			Ecriture.ecrireStringln(super.out, "	sub sp, " + nbVariable + "\n");
		}
		
		//Entree - sortie
		public void ecrireEnt (){
			Ecriture.ecrireStringln(super.out, "	;ecrireEnt");
			Ecriture.ecrireStringln(this.out,"	call ecrent\n");
		}
		
		public void ecrireChaine (String chaine){
			Ecriture.ecrireStringln(super.out, "	;ecrireChaine \"" + chaine + "\"");
			Ecriture.ecrireStringln(this.out, ".DATA");
			Ecriture.ecrireStringln(this.out,"	 mess" + nbMessage + " DB \"" + chaine + "$\"");
			Ecriture.ecrireStringln(this.out, ".CODE");
			Ecriture.ecrireStringln(this.out,"	 lea dx, mess" + nbMessage);
			Ecriture.ecrireStringln(this.out,"	 push dx");
			Ecriture.ecrireStringln(this.out,"	 call ecrch\n");
			nbMessage++;
		}
		
		public void ecrireBool (){
			Ecriture.ecrireStringln(super.out, "	;ecrireBool");
			Ecriture.ecrireStringln(super.out, "	;ecrireBool");
			Ecriture.ecrireStringln(this.out,"	call ecrbool\n");
		}
		
		public void lireEnt (int entier) {
			Ecriture.ecrireStringln(super.out, "	;lireEnt");
			Ecriture.ecrireStringln(this.out,"	lea dx, [bp" + entier + "]");
			Ecriture.ecrireStringln(this.out,"	push dx");
			Ecriture.ecrireStringln(this.out,"	call lirent\n");
		}
		
		public void aLaLigne (){
			Ecriture.ecrireStringln(super.out, "	;aLaLigne");
			Ecriture.ecrireStringln(this.out,"	call ligsuiv\n");
		}

}
