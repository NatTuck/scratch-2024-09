package hw05;

import java.util.ArrayList;

class ArrayStack<T> implements Stack<T> {
    //ArrayList<T> data = new ArrayList<T>();
    ArrayList<T> data;

    ArrayStack() {
        this.data = new ArrayList<T>();
    }

    @Override
    public void push(T item) {
        // Complexity: Amortized O(1)
        this.data.add(item);
    }

    @Override
    public T pop() {
        // O(1) + O(1) + O(1) = O(1)
        int lastIndex = this.data.size() - 1;  // size() is O(1), just read data.size field.
        T lastItem = this.data.get(lastIndex); // get is O(1)
        this.data.remove(lastIndex); // O(1) because loop happens zero times
        return lastItem; // no need to count a simple return
    }

    @Override
    public boolean isEmpty() {
        return this.data.size() == 0;
    }

    @Override
    public int size() {
        return this.data.size();
    }

}