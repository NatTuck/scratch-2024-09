package lab09;

import java.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HashMap<K, V> {
    Entry<K, V>[] data;
    int size;

    Entry<K, V> empty;
    Entry<K, V> tomb;

    public HashMap() {
        this.empty = new Entry<K, V>(null, null);
        this.tomb = new Entry<K, V>(null, null);

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

    private void grow() {
        var oldData = this.data;

        this.data = newArray(2 * oldData.length);
        this.size = 0;

        for (int ii = 0; ii < this.data.length; ++ii) {
            this.data[ii] = empty;
        }
 
        for (var ent : oldData) {
            if (ent != empty && ent != tomb) {
                insert(ent.key(), ent.val());
            }
        }
    }

    int size() {
        return this.size;
    }

    double loadFactor() {
        return ((double)size())/((double)this.data.length);
    }

    boolean hasKey(K key) {
        var yy = getOrNull(key);
        return yy != null;
    }

    V getOrNull(K key) {
        int code = key.hashCode();
        int slot0 = Math.floorMod(code, this.data.length);

        for (int ii = 0; ii < this.data.length; ++ii) {
            int slot = Math.floorMod(slot0 + ii, this.data.length);

            var ent = this.data[slot];
            if (ent == empty) {
                return null;
            }
            if (key.equals(ent.key())) {
                return this.data[slot].val();
            }
        }
        return null;
    }

    V get(K key) {
        var yy = getOrNull(key);
        if (yy != null) {
            return yy;
        }
        else {
            throw new RuntimeException("no such key");
        }
    }

    void insert(K key, V val) {
        if (loadFactor() >= 0.5) {
            System.out.println("grow!");
            grow();
        }

        int code = key.hashCode();
        int slot0 = Math.floorMod(code, this.data.length);

        for (int ii = 0; ii < this.data.length; ++ii) {
            int slot = Math.floorMod(slot0 + ii, this.data.length);
            System.out.println("insert " + key + " at " + slot);
            if (this.data[slot] == empty || this.data[slot] == tomb) {
                this.data[slot] = new Entry<>(key, val);
                this.size += 1;
                return;
            }
        }
        throw new RuntimeException("table is full");
    }

    void delete(K key) {
        int code = key.hashCode();
        int slot0 = Math.floorMod(code, this.data.length);

        for (int ii = 0; ii < this.data.length; ++ii) {
            int slot = Math.floorMod(slot0 + ii, this.data.length);

            var ent = this.data[slot];
            if (ent == empty) {
                // key not found, do nothing
                return;
            }
            if (key.equals(ent.key())) {
                this.data[slot] = tomb;
                return;
            }
        }
        // key not found, do nothing
    }

    ArrayList<K> keys() {
        var ys = new ArrayList<K>();
        for (var ent : this.data) {
            if (ent.key() != null) {
                ys.add(ent.key());
            }
        }
        return ys;
    } 
}
