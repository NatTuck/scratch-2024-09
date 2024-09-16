

```python
def add1(x):
    return x + 1

# 1 operation
def add10v1(x):
    return x + 10

# 10 operations
def add10v2(x)
    for _ii in range(10):
        x = x + 1
    return x

# y operations 
def addY(x, y):
    for _ii in range(y):
        x = x + 1
    return x

# 1 operation
def addYv2(x, y):
    return x + y
    

# This function takes about n^2 operations
def selection_sort(xs):
    ys = []
    # we go through the loop n times
    while !xs.empty():
        y = take smallest item from xs # n operations for size-n list
        ys.append(y)
    return ys
```

# Big O notation

"f(x) is O(x)" means:

 - Computing f(x) takes at most k*x operations for some constant k, no matter how big
   a value we pick for x.
 - f(x) takes 35 * n operations, f(x) is O(x) because we can pick k = 36.
 - Compare 10\*n^2 to 100\*n.
 
n     10n^2   100n
5     250     500
100   100k    10k

 - No matter what the constant factors (j, k) are, jn^2 will be bigger than kn for all
   values larger than a sufficiently large n.
 - Big O lets us ignore the constant factor and focus on the part of the function that
   matters for a big enough n.
 - O(1) < O(n) < O(n^2) < O(2^n)
 



# Arrays

 - A collection of 0 or more objects.
 - Objects are all of 1 type.
 - Array size is fixed at creation.
 - Arrays can be looped through with for loops like lists.
 - We can use [] indexing syntax like Python lists.

