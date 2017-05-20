package Chapter10;

/**
 * Created by greg on 4/23/16.
 */
public interface Map<K,V> {

    int size();
    boolean isEmpty();
    V get(K k);
    V put(K k, V v);
    V remove(K k);
    Iterable<K> keySet();
    Iterable<V> values();
    Iterable<Entry<K,V>> entrySet();
    // boolean containsKey(K k);

}
