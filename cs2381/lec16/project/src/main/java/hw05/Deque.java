package hw05;

public interface Deque<T> {
    /**
     * Add to end of sequence.
     */
    void push(T item);

    /**
     * Remove from end of sequence and return.
     */
    T pop();

    /**
     * Add to start of sequence.
     */
    void unshift(T item);

    /**
     * Remove from front and return.
     */
    T shift();

    /**
     * Check if empty.
     */
    boolean isEmpty(); 
}
