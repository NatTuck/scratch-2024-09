package hw05;

public class App {

    public static void main(String[] args) {
        int[] xs = {1, 2, 3, 4, 5};

        var stack = new ArrayStack<Integer>();

        for (int x : xs) {
            stack.push(x);
        }

        //for (int ii = 0; ii < xs.length; ++ii) {
        //    xs[ii] = stack.pop();
        //}
        int ii = 0;
        while (!stack.isEmpty()) {
            xs[ii++] = stack.pop();
        }

        for (int x : xs) {
            System.out.println(x);
        }
    }
}

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

class MyArrayList<T> {
    int size;
    T[] data;
}