package hw05;

import java.util.ArrayList;

public class ArrayQueue<T> implements Queue<T> {
    @SuppressWarnings("unchecked")
    T data[] = (T[]) new Object[2];
    int back = 0; // index of next push
    int front = 0; // index of next shift
    int size = 0;

    @Override
    public void push(T item) {
        data[front] = item;
        front = (front + 1) % data.length;
    }
    @Override
    public T shift() {
        T item = data[back];
        back = (back + 1) % data.length;
        return item;
    }
    @Override
    public T first() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'first'");
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }


}
