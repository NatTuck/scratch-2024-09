    .globl main

    .text

# add2(x): return x + 2
add2:
    enter $0, $0

    mov %edi, %eax
    add $400, %eax

    leave
    ret


main:
    enter $0, $0
    
    mov $5, %edi
    call add2

    mov $long_fmt, %rdi
    mov %eax, %esi
    mov $0, %al
    call printf

    mov $0, %eax
    leave
    ret


    .data
long_fmt:   .string "%d\n"
