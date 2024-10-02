package hw05;

public interface Queue<T> {
    /**
     * Add an item to back of the queue.
     */
    void push(T item);

    /**
     * Remove an item from the front of the queue.
     */
    T shift();

    /**
     * Look at the first item in the queue.
     */
    T first();

    /**
     * Check if the queue is empty.
     */
    boolean isEmpty();
}
