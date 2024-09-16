package demo;


public class ArrayWrap {
    private int[] data;
    public int ops;

    ArrayWrap() {
        this.data = new int[0];
        this.ops = 0;
    }

    // This method takes O(n^2) time.
    // That's too slow.
    void add(int xx) {
        int[] oldData = data;
        this.data = new int[oldData.length + 1];

        for (int ii = 0; ii < oldData.length; ++ii) {
            this.data[ii] = oldData[ii];
            ops += 1; // Add one of the previous items
        }

        this.data[oldData.length] = xx;
        ops += 1; // Add the new item
    }

    int get(int ii) {
        return this.data[ii];
    }

    void set(int ii, int vv) {
        this.data[ii] = vv;
    }

    int size() {
        return this.data.length;
    }
}
