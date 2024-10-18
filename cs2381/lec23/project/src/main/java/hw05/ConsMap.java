package hw05;

// aka. Association List or AList

public record ConsMap<K, V>(ConsList<Pair<K, V>> data) implements ImmMap<K, V> {

    public static <P, Q> ConsMap<P, Q> empty() {
        return new ConsMap<>(ConsList.<Pair<P, Q>>of());
    }

    @Override
    public boolean containsKey(K key) {
        for (var pair : data) {
            if (pair.key().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ConsMap<K, V> put(K key, V val) {
        return new ConsMap<>(putList(this.data, key, val));
    }

    static <K, V> ConsList<Pair<K, V>> putList(ConsList<Pair<K, V>> xs, K key, V val) {
        if (xs.empty()) {
            return ConsList.of(new Pair<>(key, val));
        }
        else {
            if (xs.first().key().equals(key)) {
                return new Cell<>(new Pair<>(key, val), xs.rest());
            }
            else {
                var newRest = putList(xs.rest(), key, val);
                return new Cell<>(xs.first(), newRest);
            }
        }
    }

    @Override
    public V get(K key) {
         for (var pair : data) {
            if (pair.key().equals(key)) {
                return pair.val();
            }
        }
        throw new RuntimeException("key not in map");
    }

    @Override
    public int size() {
        return data.length();
    }

    
}

record Pair<K, V>(K key, V val) {
    // pass
}