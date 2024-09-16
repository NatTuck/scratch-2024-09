package demo;


public class ArrayList<T> {
    private T[] data;
    private int size;
    public int ops;

    @SuppressWarnings("unchecked")
    ArrayList() {
        this.data = (T[]) new Object[2];
        this.size = 0;
        this.ops = 0;
    }

    @SuppressWarnings("unchecked")
    void add(T xx) {
        if (this.size == this.data.length) {
            T[] oldData = data;
            this.data = (T[]) new Object[oldData.length * 2];

            for (int ii = 0; ii < oldData.length; ++ii) {
                this.data[ii] = oldData[ii];
                ops += 1; // Add one of the previous items
            }
        }

        this.data[this.size] = xx;
        this.size += 1;
        ops += 1; // Add the new item
    }

    T get(int ii) {
        if (ii < 0 || ii >= this.size()) {
            throw new Error("list index out of bounds");
        }

        return this.data[ii];
    }

    void set(int ii, T vv) {
        this.data[ii] = vv;
    }

    int size() {
        return this.size;
    }

    int capacity() {
        return this.data.length;
    }
}
