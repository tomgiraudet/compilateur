	; entete
	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc, ecrch:proc
	extrn ligsuiv:proc
.model SMALL
.586

.CODE
debut:
	STARTUPCODE
	;ouvrePrinc 6
	mov bp, sp
	sub sp, 6

	;lireEnt
	lea dx, [bp-2]
	push dx
	call lirent

	;aLaLigne
	call ligsuiv

	;lireEnt
	lea dx, [bp-4]
	push dx
	call lirent

	;aLaLigne
	call ligsuiv

	;iload -4
	push word ptr [bp-4]

	;istore -6
	pop ax
	mov word ptr [bp-6], ax

	;iload -2
	push word ptr [bp-2]

	;iload -4
	push word ptr [bp-4]

	;isup
	pop bx
	pop ax
	cmp ax,bx
	jle $+6
	push -1
	jmp $+4
	push 0

	;iffaux
	pop ax
	cmp ax,0
	je SINON1

	;iload -2
	push word ptr [bp-2]

	;istore -6
	pop ax
	mov word ptr [bp-6], ax

	;goto FSI1
	jmp FSI1

SINON1:
FSI1:
	;iload -6
	push word ptr [bp-6]

	;ecrireEnt
	call ecrent

	;queue
	nop
	EXITCODE
	End debut

