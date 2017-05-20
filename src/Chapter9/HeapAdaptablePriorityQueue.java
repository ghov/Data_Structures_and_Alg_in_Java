package Chapter9;

import java.util.Comparator;

/**
 * Created by greg on 4/30/16.
 */
public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> {

    protected static class AdaptablePQEntry<K,V> extends PQEntry<K,V>{

        private int index;
        public AdaptablePQEntry(K key, V value, int i){
            super(key, value);
            index = i;
        }

        public int getIndex(){
            return index;
        }

        public void setIndex(int i){
            index = i;
        }
    }

    public HeapAdaptablePriorityQueue(){
        super();
    }

    public HeapAdaptablePriorityQueue(Comparator<K> comp){
        super(comp);
    }

    protected AdaptablePQEntry<K,V> validate(Entry<K,V> entry) throws IllegalArgumentException{
        if(!(entry instanceof AdaptablePQEntry)){
            throw new IllegalArgumentException("Invalid Entry");
        }

        AdaptablePQEntry<K,V> locator = (AdaptablePQEntry<K,V>) entry;
        int i = locator.getIndex();
        if(i >= heap.size() || heap.get(i) != locator){
            throw new IllegalArgumentException("Invalid Entry");
        }
        return locator;
    }

    protected void swap(int i, int j){
        super.swap(i, j);
        ((AdaptablePQEntry<K,V>)heap.get(i)).setIndex(i);
        ((AdaptablePQEntry<K,V>)heap.get(j)).setIndex(j);
    }

    protected void bubble(int j){
        if(j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0){
            upheap(j);
        }else{
            downheap(j);
        }
    }

    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
        checkKey(key);
        Entry<K,V> newest = new AdaptablePQEntry<>(key, value, heap.size()); // Add it to the end
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;
    }

    public void remove(Entry<K,V> entry) throws IllegalArgumentException{
        AdaptablePQEntry<K,V> locator = validate(entry);
        int j = locator.getIndex();
        if(j == heap.size() - 1){
            heap.remove(j);
        }else{
            swap(j, heap.size() - 1);
            heap.remove(heap.size() - 1);
            bubble(j);
        }
    }

    public void replaceKey(Entry<K,V> entry, K key) throws IllegalArgumentException{
        AdaptablePQEntry<K,V> locator = validate(entry);
        checkKey(key);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

    public void replaceValue(Entry<K,V> entry, V value) throws IllegalArgumentException{
        AdaptablePQEntry<K,V> locator = validate(entry);
        locator.setValue(value);

    }
}
