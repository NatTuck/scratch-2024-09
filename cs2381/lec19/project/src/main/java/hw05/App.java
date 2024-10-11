package hw05;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        var aa = new Cat("Alice");
        var bb = new Cat("Bob");
        var cc = new Cat("Alice");
        var dd = aa;

        if (aa.equals(aa)) {
            System.out.println("a is a");
        }
        
        if (aa.equals(bb)) {
            System.out.println("a is b");
        }
        
        if (aa.equals(cc)) {  // but aa == cc is false
            System.out.println("a is c");
        }
        
        if (aa.equals(dd)) {
            System.out.println("a is d");
        }

    }
}

record Cat(String name) {

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

class ArrayListSet<T> implements MutableSet<T> {
    ArrayList<T> data = new ArrayList<>();

    @Override
    public void add(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void remove(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public MutableSet<T> union(MutableSet<T> other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'union'");
    }

    @Override
    public MutableSet<T> intersect(MutableSet<T> other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersect'");
    }

    @Override
    public boolean contains(T item) {
        for (var xx : this.data) {
            if (item.equals(xx)) {
                return true;    
            }
        }
        return false;
    }

    @Override
    public boolean isSuperset(MutableSet<T> other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSuperset'");
    }

    @Override
    public boolean isSubset(MutableSet<T> other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSubset'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

}