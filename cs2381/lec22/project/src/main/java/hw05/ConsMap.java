package hw05;

// aka. Association List or AList

public record ConsMap<K, V>(ConsList<Pair<K, V>> data) implements ImmMap<K, V> {

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
    public ImmMap<K, V> put(K key, V val) {
        if (containsKey(key)) {
            putList(this.data, key, val);
        }
    }

    static <K, V> ConsList<Pair<K, V>> putList(ConsList<Pair<K, V>> xs, K key, V val) {
        if (xs.empty()) {
            return ConsList.of(new Pair<>(key, val));
        }


    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    
}

record Pair<K, V>(K key, V val) {
    // pass
}