package Chapter9;

import java.util.Comparator;

/**
 * Created by greg on 4/20/16.
 */
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueueInterface<K,V> {

    // Implement a version of the Entry interface
    protected static class PQEntry<K,V> implements Entry<K, V>{
        private K key;
        private V value;

        public PQEntry(K k, V v){
            key = k;
            value = v;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        protected void setKey(K k){
            key = k;
        }

        protected void setValue(V v){
            value = v;
        }

    }
    // End of the PQEntry class


    // Will be used to compare the keys of the entries
    // Has the .compare method that takes two objects.
    private Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> c){
        comp = c;
    }

    protected AbstractPriorityQueue(){
        this(new DefaultComparator<K>());
    }

    public int compare(Entry<K,V> a, Entry<K,V> b){

        return comp.compare(a.getKey(), b.getKey());

    }

    protected boolean checkKey(K key) throws IllegalArgumentException{
        try {
            return comp.compare(key, key) == 0;
        }catch (ClassCastException e){
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty(){
        return size()==0;
    }
}