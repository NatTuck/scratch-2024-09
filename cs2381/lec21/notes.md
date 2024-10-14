

# Interfaces

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
