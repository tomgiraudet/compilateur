	; entete
	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc, ecrch:proc
	extrn ligsuiv:proc
.model SMALL
.586

.CODE
debut:
	STARTUPCODE
	;ouvrePrinc 14
	mov bp, sp
	sub sp, 14

	;iconst
	push world ptr 10

	;iconst
	push world ptr 10

	;iconst
	push world ptr 2

	;idiv
	pop bx
	pop ax
	cwd
	idiv bx
	push ax

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;iconst
	push world ptr 5

	;idiv
	pop bx
	pop ax
	cwd
	idiv bx
	push ax

	;istore
	pop ax
	mov word ptr [bp-2], ax

	;iload
	push word ptr [bp-2]

	;iconst
	push world ptr 3

	;iload
	push word ptr [bp-2]

	;imul
	pop bx
	pop ax
	imul bx
	push ax

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;iconst
	push world ptr 10

	;isub
	pop bx
	pop ax
	sub ax,bx
	push ax

	;istore
	pop ax
	mov word ptr [bp-4], ax

	;iconst
	push world ptr -1

	;iconst
	push world ptr -1

	;ior
	pop bx
	pop ax
	or ax,bx
	push ax

	;istore
	pop ax
	mov word ptr [bp-12], ax

	;iload
	push word ptr [bp-2]

	;iload
	push word ptr [bp-4]

	;iconst
	push world ptr 4

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;iinfegal
	pop bx
	pop ax
	cmp ax,bx
	jg $+6
	push -1
	jmp $+4
	push 0

	;istore
	pop ax
	mov word ptr [bp-14], ax

	;queue
	nop
	EXITCODE
	End debut

