package hw05;

class ConsStack<T> implements Stack<T> {
    ConsList<T> data = ConsList.empty();

    @Override
    public void push(T item) {
        // This is O(1)
        this.data = ConsList.cons(item, this.data);
    }

    @Override
    public T pop() {
        // This is O(1)
        T poppedItem = this.data.first();
        this.data = this.data.rest();
        return poppedItem;
    }

    @Override
    public boolean isEmpty() {
        // This is also O(1)
        return this.data.isEmpty();
    }

    @Override
    public int size() {
        // O(n) in size of list
        return data.size();
    }

}