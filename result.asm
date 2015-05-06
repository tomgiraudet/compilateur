	; entete
	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc, ecrch:proc
	extrn ligsuiv:proc
.model SMALL
.586

.CODE
max:
	enter 6,0
	;iload 6
	push word ptr [bp+6]

	;istore -6
	pop ax
	mov word ptr [bp-6], ax

	;iload -6
	push word ptr [bp-6]

	;iload 4
	push word ptr [bp+4]

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

	;iload -6
	push word ptr [bp-6]

	pop ax
	mov [bp+8], ax
	;goto FSI1
	jmp FSI1

SINON1:
	;iload 4
	push word ptr [bp+4]

	pop ax
	mov [bp+8], ax
FSI1:
	leave
	ret 4
min:
	enter 0,0
	;iload 6
	push word ptr [bp+6]

	;iload 4
	push word ptr [bp+4]

	;iinf
	pop bx
	pop ax
	cmp ax,bx
	jge $+6
	push -1
	jmp $+4
	push 0

	;iffaux
	pop ax
	cmp ax,0
	je SINON2

	;iload 6
	push word ptr [bp+6]

	pop ax
	mov [bp+8], ax
	;goto FSI2
	jmp FSI2

SINON2:
	;iload 4
	push word ptr [bp+4]

	pop ax
	mov [bp+8], ax
FSI2:
	leave
	ret 4
egal:
	enter 10,0
	;iload 6
	push word ptr [bp+6]

	;iload 4
	push word ptr [bp+4]

	;isub
	pop bx
	pop ax
	sub ax,bx
	push ax

	;istore -2
	pop ax
	mov word ptr [bp-2], ax

	;iload 4
	push word ptr [bp+4]

	;iload 6
	push word ptr [bp+6]

	;isub
	pop bx
	pop ax
	sub ax,bx
	push ax

	;istore -4
	pop ax
	mov word ptr [bp-4], ax

	;iload -2
	push word ptr [bp-2]

	;iconst 0
	push word ptr 0

	;iegal
	pop bx
	pop ax
	cmp ax,bx
	jne $+6
	push -1
	jmp $+4
	push 0

	;iffaux
	pop ax
	cmp ax,0
	je SINON3

	;iconst -1
	push word ptr -1

	;istore -6
	pop ax
	mov word ptr [bp-6], ax

	;goto FSI3
	jmp FSI3

SINON3:
FSI3:
	;iload -4
	push word ptr [bp-4]

	;iconst 0
	push word ptr 0

	;iegal
	pop bx
	pop ax
	cmp ax,bx
	jne $+6
	push -1
	jmp $+4
	push 0

	;iffaux
	pop ax
	cmp ax,0
	je SINON4

	;iconst -1
	push word ptr -1

	;istore -8
	pop ax
	mov word ptr [bp-8], ax

	;goto FSI4
	jmp FSI4

SINON4:
FSI4:
	;iload -6
	push word ptr [bp-6]

	;iload -8
	push word ptr [bp-8]

	;iegal
	pop bx
	pop ax
	cmp ax,bx
	jne $+6
	push -1
	jmp $+4
	push 0

	;iffaux
	pop ax
	cmp ax,0
	je SINON5

	;iconst -1
	push word ptr -1

	;istore -10
	pop ax
	mov word ptr [bp-10], ax

	;goto FSI5
	jmp FSI5

SINON5:
FSI5:
	;iload -10
	push word ptr [bp-10]

	pop ax
	mov [bp+8], ax
	leave
	ret 4
func:
	enter 12,0
	;iconst 3
	push word ptr 3

	sub sp, 2
	;iload 10
	push word ptr [bp+10]

	;iload 8
	push word ptr [bp+8]

	call max
	;imul
	pop bx
	pop ax
	imul bx
	push ax

	sub sp, 2
	;iload 6
	push word ptr [bp+6]

	;iload 4
	push word ptr [bp+4]

	call min
	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -2
	pop ax
	mov word ptr [bp-2], ax

	sub sp, 2
	;iload 10
	push word ptr [bp+10]

	;iload 8
	push word ptr [bp+8]

	call max
	;istore -6
	pop ax
	mov word ptr [bp-6], ax

	;iconst 2
	push word ptr 2

	;iload -6
	push word ptr [bp-6]

	;imul
	pop bx
	pop ax
	imul bx
	push ax

	sub sp, 2
	;iload 10
	push word ptr [bp+10]

	;iload 8
	push word ptr [bp+8]

	call max
	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -6
	pop ax
	mov word ptr [bp-6], ax

	sub sp, 2
	;iload 6
	push word ptr [bp+6]

	;iload 4
	push word ptr [bp+4]

	call min
	;istore -8
	pop ax
	mov word ptr [bp-8], ax

	;iload -6
	push word ptr [bp-6]

	;iload -8
	push word ptr [bp-8]

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -4
	pop ax
	mov word ptr [bp-4], ax

	sub sp, 2
	;iload -2
	push word ptr [bp-2]

	;iload -4
	push word ptr [bp-4]

	call egal
	;iffaux
	pop ax
	cmp ax,0
	je SINON6

	;iconst 0
	push word ptr 0

	;istore -10
	pop ax
	mov word ptr [bp-10], ax

	;goto FSI6
	jmp FSI6

SINON6:
	;iconst 1000
	push word ptr 1000

	;ineg
	pop bx
	mov ax, 0
	sub ax, bx
	push ax

	;istore -10
	pop ax
	mov word ptr [bp-10], ax

FSI6:
	;iload -6
	push word ptr [bp-6]

	;iload -10
	push word ptr [bp-10]

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	pop ax
	mov [bp+12], ax
	leave
	ret 8
debut:
	STARTUPCODE
main:
	enter 10,0
	;iconst 6
	push word ptr 6

	;istore -2
	pop ax
	mov word ptr [bp-2], ax

	;iconst 9
	push word ptr 9

	;istore -4
	pop ax
	mov word ptr [bp-4], ax

	;iconst 7
	push word ptr 7

	;istore -6
	pop ax
	mov word ptr [bp-6], ax

	;iconst 4
	push word ptr 4

	;istore -8
	pop ax
	mov word ptr [bp-8], ax

	;aLaLigne
	call ligsuiv

	;iload -8
	push word ptr [bp-8]

	pop ax
	mov [bp+4], ax
	;iload -2
	push word ptr [bp-2]

	;ecrireEnt
	call ecrent

	;iload -4
	push word ptr [bp-4]

	;ecrireEnt
	call ecrent

	;iload -6
	push word ptr [bp-6]

	;ecrireEnt
	call ecrent

	;iload -8
	push word ptr [bp-8]

	;ecrireEnt
	call ecrent

	;aLaLigne
	call ligsuiv

	sub sp, 2
	;iload -2
	push word ptr [bp-2]

	;iload -4
	push word ptr [bp-4]

	;iload -6
	push word ptr [bp-6]

	;iload -8
	push word ptr [bp-8]

	call func
	;istore -10
	pop ax
	mov word ptr [bp-10], ax

	;iload -10
	push word ptr [bp-10]

	;ecrireEnt
	call ecrent

	;queue
	nop
	EXITCODE
	end

