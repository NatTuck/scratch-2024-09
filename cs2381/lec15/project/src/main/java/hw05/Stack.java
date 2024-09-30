package hw05;

interface Stack<T> {
    /**
     * Add an item to the top of the stack
     */
    void push(T item);

    /**
     * Get the top item of the stack, removing it.
     */
    T pop();

    /**
     * Check if stack is empty.
     */
    boolean isEmpty();

    // Optional methods for an abstract stack.

    /**
     * Get the number of items in the stack.
     */
    int size();

    /**
     * Look at the top item without removing it.
     */
    default T peek() {
        T tmp = pop();
        push(tmp);
        return tmp;
    }
}