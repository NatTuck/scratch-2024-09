package hw05;

public interface ImmMap<K, V> {
    boolean containsKey(K key);
    ImmMap<K, V> put(K key, V val);
    V get(K key);
    int size();
}
