package hw05;

public interface TreeMap<K extends Comparable<K>, V> extends ImmMap<K, V> {

    public static <K extends Comparable<K>, V> TreeMap<K, V> empty() {
        return new MapLeaf<>();
    }

    boolean isLeaf();

    boolean containsKey(K key);
    TreeMap<K, V> put(K key, V val);
    V get(K key);
    int size();

    TreeMap<K, V> left();
    Pair<K, V> data();
    TreeMap<K, V> right();
}

record MapBranch<K extends Comparable<K>, V>(TreeMap<K, V> left, 
                                             Pair<K, V> data, 
                                             TreeMap<K, V> right) implements TreeMap<K, V> {

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        var cmp = key.compareTo(data().key());
        if (cmp == 0) {
            return true;
        }

        if (cmp < 0) {
            return left().containsKey(key);
        }
        else {
            return right().containsKey(key);
        }
    }

    @Override
    public MapBranch<K, V> put(K key, V val) {
        var cmp = key.compareTo(data().key());
        if (cmp == 0) {
            return this;
        }

        if (cmp < 0) {
            var newLeftSubTree = left().put(key, val);
            if (newLeftSubTree == left()) {
                return this;
            }
            else {
                return new MapBranch<K, V>(newLeftSubTree, data(), right());
            }
        }
        else {
            var newRightSubTree = right().put(key, val);
            if (newRightSubTree == right()) {
                return this;
            }
            else {
                return new MapBranch<K, V>(left(), data(), newRightSubTree);
            }
        }
    }

    @Override
    public V get(K key) {
        var cmp = key.compareTo(data().key());
        if (cmp == 0) {
            return data().val();
        }

        if (cmp < 0) {
            return left().get(key);
        }
        else {
            return right().get(key);
        }
    }

    @Override
    public int size() {
        return 1 + left().size() + right.size();
    }
}

record MapLeaf<K extends Comparable<K>, V>() implements TreeMap<K, V> {

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean containsKey(K item) {
        return false;
    }

    @Override
    public TreeMap<K,V> put(K key, V val) {
        // TODO: May unbalance tree, should fix.
        return new MapBranch<K, V>(this, new Pair<>(key, val), this);
    }

    @Override
    public TreeMap<K,V> left() {
        throw new UnsupportedOperationException("Empty tree has no 'left'");
    }

    @Override
    public Pair<K, V> data() {
        throw new UnsupportedOperationException("Empty tree has no 'data'");
    }

    @Override
    public TreeMap<K,V> right() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Empty tree has no 'right'");
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        throw new RuntimeException("no such key");
    }

    @Override
    public int size() {
        return 0;
    }
}