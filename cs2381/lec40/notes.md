
# Today: Semester Review

## First: The Exam

 - Monday Dec 9 @ 11am - 1:30pm in this room
 


## Semester Review

### Java Language

 - Compiled to bytecode
 - Statically typed
   - Every variable has a type
   - The type of a variable can be generic, allowing any consistent type
   - There is polymorphism, so a type could be the superclass or an interface
     type of the actual object contained in a variable
 - Primitive vs Object types
 - Classes vs Records
   
### ConsList

 - A structure for storing a sequence of 0 or more items of the same type.
 - Immutable
 - Bad at getting items by index

### Array

 - A fixed-length sequence of items of the same type.
 - Provides fast access (O(1)) to get or set items by index. 

### ArrayList

 - Use an Array to efficiently build a list.
 - Make append be amortized O(1) by doubling the array size when it's full.
 
### Ways to look at lists

 - Stack: push, pop
 - Queue: enqueue, take next
 - Deque: operatoins of both a stack and a queue
   - Google "persistent deque functional data structure"
 
### Iterators

 - A way to iterate generically over any collection of items.
 - An item that implements Iterable can be the subject of a for-each loop.


### Asymptotic Complexity

How many steps does it take to do some operation.

In this class:

 - An operation is generally a method call on a data structure.
 - A step is one or a small constant number of machine instructions -
   typically showing up in code as an arithmetic operation or method
   call.

We're interested in comparing rate of growth rather than specific numbers, so:

 - We ignore constant factors.
 - We get a result in big-O notation, usually one of: O(1), O(log n), O(n), O(n log n), O(n^2),
   or O(2^n).


### Sets, Maps

 - A Set is an unordered collection of unique items.
 - A Map is a set of keys and a value associated with each key.


### Association Lists

 - Set: A list of items
 - Map: A list of (K, V) pairs.

Most operations are O(n).



### Skip Lists

 - Take a cons list
 - Add O(log n) extra links that jump further than one step down the list.

Most operations are O(log n).


### Binary Search Tree

 - Instead of having each node have one "rest" field, have it have two children.
 - Now each link followed reduces the number of items left to search by half.

Most operations are O(log n).


### Hash Table

 - Array of values
 - Which slot in the array the value lives in depends on a hash function,
   mapping values to integers (= array indices).
 - Problem: Collisions
 - Solution 1: Probing (try the next slot in the table, scan until empty)
 - Solution 2: Chaining (have an array of lists of values)
 - Either solution can degrade operations to O(n)
 
Most operations are expected O(1).







