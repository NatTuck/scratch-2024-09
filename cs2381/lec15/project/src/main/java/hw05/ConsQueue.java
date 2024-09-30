package hw05;

public class ConsQueue<T> implements Queue<T>{
    // Front is backwards becuase
    // list naturally inserts in reverse order.
    ConsList<T> front = ConsList.empty();

    // Back is forwards so we can shift
    // off of it efficiently.
    ConsList<T> back = ConsList.empty();

    @Override
    public void push(T item) {
        front = ConsList.cons(item, front);
    }

    @Override
    public T shift() {
        if (back.isEmpty()) {
            // Only copies each item
            // once, so O(1) per item.
            back = front.reverse();
            front = ConsList.empty();
        }

        // rest is O(1), total O(n) over n calls
        T item = back.first();
        back = back.rest();
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
