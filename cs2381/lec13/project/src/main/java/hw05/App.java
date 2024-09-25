package hw05;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        var xs = ConsList.of("Alice", "Bob", "Carol", "Dave");
        for (var xx : xs) {
            System.out.println(xx);
        }
    }
}

interface Stack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
}

class ArrayStack<T> implements Stack<T>{
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

}

//class ConsStack {
//
//}



class MyArrayList<T> {
    int size;
    T[] data;
}