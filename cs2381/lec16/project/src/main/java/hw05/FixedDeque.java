package hw05;

public class FixedDeque<T> implements Deque<T> {
    T data[];
    int front;
    int back;

    @SuppressWarnings("unchecked")
    FixedDeque(int nn) {
        data = (T[]) new Object[nn];
        front = 0;
        back = 0;
    }

    @Override
    public void push(T item) {
        data[back] = item;
        back = (back + 1) % data.length;
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public void unshift(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unshift'");
    }

    @Override
    public T shift() {
        T item = data[front];
        front = (front + 1) % data.length;
        return item;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    
}
