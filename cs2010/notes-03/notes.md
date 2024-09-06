
# cs2010 Lecture 3: Describing Simple Algorithms

Four ways to write down a simple algorithm:

 - Flow charts
 - Pseudocode
 - IPO Tables
 - Code


## example 1

Pseudocode:

    input a
    input b
    if (a > b)
        larger = a
    else
        larger = b
    output larger
    
    
 - Flowchart with app.code2flow.com
 - IPO Table with a word processor
 - Code by writing code in some language, which we can then run.


## example 2: Multiplication by repeated addition

We can multiply two numbers together by adding the first number to itself
repeatedly a number of times equal to the second number.

**IPO Table (sideways)**

INPUT: a, b

PROCESS:

    set c = 0
    
    while b > 0:
        set c = c + a
        set b = b - 1

OUTPUT: c


**Pseudocode**

    input a, b

    set c = 0
    
    while b > 0:
        set c = c + a
        set b = b - 1

    output c






