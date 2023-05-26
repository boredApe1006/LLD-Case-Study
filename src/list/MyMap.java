package list;

public interface MyMap<K,V> {

    void put(K key, V val);

    V get(K key);
}
