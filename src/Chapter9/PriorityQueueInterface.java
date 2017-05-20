package Chapter9;

/**
 * Created by greg on 4/20/16.
 */
public interface PriorityQueueInterface<K,V> {

    public Entry<K,V> insert(K key,V v) throws IllegalArgumentException; // Puts the element into the queue with key
    public Entry<K,V> min();    // returns, but does not remove the smallest Object(k,v) in the queue
    public Entry<K,V> removeMin();  // removes and returns the smallest Object(k,v) in the queue
    public int size();
    public boolean isEmpty();

}
