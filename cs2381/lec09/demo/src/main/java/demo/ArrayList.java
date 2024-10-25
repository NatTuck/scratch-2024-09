package demo;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {
    public T[] data;
    private int size;
    public int ops;

    @SuppressWarnings("unchecked")
    ArrayList() {
        this.data = (T[]) new Object[2];
        this.size = 0;
        this.ops = 0;
    }

    @SuppressWarnings("unchecked")
    void add(T xx) {
        if (this.size == this.data.length) {
            T[] oldData = data;
            this.data = (T[]) new Object[oldData.length * 2];

            for (int ii = 0; ii < oldData.length; ++ii) {
                this.data[ii] = oldData[ii];
                ops += 1; // Add one of the previous items
            }
        }

        this.data[this.size] = xx;
        this.size += 1;
        ops += 1; // Add the new item
    }

    T get(int ii) {
        return this.data[ii];
    }

    void set(int ii, T vv) {
        this.data[ii] = vv;
    }

    int size() {
        return this.size;
    }

    int capacity() {
        return this.data.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<T>(this);
    }
}

/*
    for (int ii = 0; ii < xs.size(); ++ii) {
            String xx = xs.get(ii);
            xs.set(ii, xx + "s");
        }

    for (var x : xs) {

    }
*/


class ArrayListIterator<T> implements Iterator<T> {
    int ii;
    ArrayList<T> data;

    ArrayListIterator(ArrayList<T> xs) {
        ii = 0;
        data = xs;
    }

    @Override
    public boolean hasNext() {
        return ii < data.size();
    }

    @Override
    public T next() {
        T item = data.get(ii);
        ii += 1;
        return item;
    }

}
