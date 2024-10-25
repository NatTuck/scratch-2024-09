package lab09;

import java.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HashMap<K, V> {
    Entry<K, V>[] data;
    int size;

    Entry<K, V> empty;

    public HashMap() {
        this.empty = new Entry<K, V>(null, null);

        this.data = newArray(4);
        this.size = 0;

        for (int ii = 0; ii < this.data.length; ++ii) {
            this.data[ii] = empty;
        }
    }
    
    @SuppressWarnings("unchecked")
    private Entry<K, V>[] newArray(int nn) {
        return (Entry<K, V>[]) Array.newInstance(Entry.class, nn);
    }

    int size() {
        return this.size;
    }

    boolean hasKey(K key) {
        int code = key.hashCode();
        int slot = Math.floorMod(code, this.data.length);
        return key.equals(this.data[slot].key());
    }

    V get(K key) {
        int code = key.hashCode();
        int slot = Math.floorMod(code, this.data.length);
        if (key.equals(this.data[slot].key())) {
            return this.data[slot].val();
        }
        throw new RuntimeException("no such key");
    }

    void insert(K key, V val) {
        int code = key.hashCode();
        int slot0 = Math.floorMod(code, this.data.length);

        for (int ii = 0; ii < this.data.length; ++ii) {
            int slot = Math.floorMod(slot0 + ii, this.data.length);
            if (this.data[slot] == empty) {
                this.data[slot] = new Entry<>(key, val);
                this.size += 1;
                return;
            }
        }
        throw new RuntimeException("table is full");
    }

    void delete(K key) {
        throw new RuntimeException("TODO");
    }

    ArrayList<K> keys() {
        throw new Error("foo");
    } 
}
