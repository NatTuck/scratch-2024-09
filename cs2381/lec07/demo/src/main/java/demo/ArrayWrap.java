package demo;


public class ArrayWrap {
    private int[] data;
    public int size;

    ArrayWrap() {
        this.data = new int[0];
        this.size = 0;
    }

    void add(int xx) {
        int[] oldData = data;
        this.data = new int[this.size + 1];

        for (int ii = 0; ii < this.size; ++ii) {
            this.data[ii] = oldData[ii];
        }

        data[this.size] = xx;
        
        this.size += 1;
    }

    int get(int ii) {
        return this.data[ii];
    }
}
