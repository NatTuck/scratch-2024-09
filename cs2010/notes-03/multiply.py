
a = int(input("a? "))
b = int(input("b?" ))

c = 0
    
while b > 0:
    c = c + a
    b = b - 1    # this isn't equality, it's assignment

print("c =", c)

