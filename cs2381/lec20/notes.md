

Unsorted ConsList (no duplicates)

```java
interface Set<T> {
    Set<T> add(T item); // O(n)
    Set<T> remove(T item); // O(n)
    
    Set<T> union(Set<T> other); // O(n * m)
    Set<T> intersect(Set<T> other); // O(n * m)

    boolean contains(T item); // O(n)
    boolean isSuperset(Set<T> other); // O(n * m)`
    
    int size();
}
```


Sorted ArrayList (no duplicates)

```java
interface MutableSet<T> {
    void add(T item); // O(n)
    void remove(T item); // O(n)
    
    MutableSet<T> union(MutableSet<T> other);  // O(n + m log n)
    MutableSet<T> intersect(MutableSet<T> other); // O(n log m)
    
    boolean contains(T item);  // O(log n)
    boolean isSuperset(MutableSet<T> other); // O(n log m)
    
    int size();
}

```






```java
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
