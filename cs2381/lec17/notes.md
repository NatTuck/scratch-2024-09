
# Lecture 17: Intro to Sets

A set is an unordered collection of unique items.

They are a computer implementation of the mathematical concept of sets.

```python
A = {1, 2, 3}
B = {"apple", "pear", "grape"}
```

In order to be in a set, a type of data must:

 - Have a concept of equality / inequality.

In order to be useful, we'd like our objects in sets to be values, which means
they should be immutable.

Mathematically, sets have the following operations:

 - setA.contains?(item)
 - setA.union(setB)
 - setA.intersect(setB)
 - setA.difference(setB)
 - setA.complement()    # maybe, if we have a concept of domain
 - setA.subset?(setB)
 - setA.superset?(setB)

Practically, a set data type in a program also wants:

 - add
 - remove
 - size
 
Should set objects be mutable?

Probably not by default, no is a mathier answer.

```java
interface Set<T> {
    Set<T> add(T item);
    Set<T> remove(T item);
    
    Set<T> union(Set<T> other);
    Set<T> intersect(Set<T> other);
    
    boolean contains(T item);
    boolean isSuperset(Set<T> other);
    boolean isSubset(Set<T> other);
    
    int size();
}

interface MutableSet<T> {
    void add(T item);
    void remove(T item);
    
    MutableSet<T> union(MutableSet<T> other);
    MutableSet<T> intersect(MutableSet<T> other);
    
    boolean contains(T item);
    boolean isSuperset(MutableSet<T> other);
    boolean isSubset(MutableSet<T> other);
    
    int size();
}

```

Java has immutable / mutable pairs in the standard library:

 - String is immutable
 - StringBuilder is a mutable version


# How to build a Set

Simplest plan: Have a list of the items.

```java
class Set<T> {
    private ArrayList<T> data;
    
    ...
}
```


Inserting into list. Does it being sorted help?

 - For an unsorted list, worst case is N operations or O(n).
 - If it's an ArrayList with random access indexing, we might be able to
   go faster by looking in the middle first.
 - If it's a ConsList, no. Sorted still requires an O(n) scan.

Does allowing duplicates help?

 - Mabye, but let's not because that gives us an unbounded size
   for a bounded set.









