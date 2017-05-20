package Chapter9;

import java.util.Comparator;
import java.util.ArrayList;

/**
 * Created by greg on 4/30/16.
 */
public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    // Holds the entry elements for internal storage
    protected ArrayList<Entry<K,V>> heap = new ArrayList<>();

    // Constructor with no input
    public HeapPriorityQueue(){
        super();
    }

    // Constructor with input
    public HeapPriorityQueue(Comparator<K> comp){
        super(comp);
    }

    // Utilities used to calculate the index for binary tree structure
    protected int parent(int j){
        return (j-1)/2;
    }

    protected int left(int j){
        return 2*j + 1;
    }

    protected int right(int j){
        return 2*j + 2;
    }

    protected boolean hasLeft(int j){
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j){
        return right(j) < heap.size();
    }

    // Exchanges the items at indices i and j of the heap(array)
    protected void swap(int i, int j){
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Moves the given index item higher until the heap order property is restored
    protected void upheap(int j){
        while(j > 0){   // Continue until reaching root
            int p = parent(j);
            if(compare(heap.get(j), heap.get(p)) >= 0){
                break; // In this case the order is good
            }

            swap(j, p);
            j = p;
        }
    }

    // Move the entry given lower, if neccessary, to maintain the heap order property
    protected void downheap(int j){
        while (hasLeft(j)){
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if(hasRight(j)){
                int rightIndex = right(j);
                // Check which child is smaller
                if(compare(heap.get(rightIndex), heap.get(leftIndex)) < 0){
                    smallChildIndex = rightIndex;
                }
            }

            // compare the small child with the parent
            if(compare(heap.get(smallChildIndex), heap.get(j)) >=0){
                break;
            }
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    @Override
    public Entry<K, V> insert(K key, V v) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest= new PQEntry<>(key, v);
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if(heap.isEmpty()){
            return null;
        }
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        return null;
    }

    @Override
    public int size() {
        return heap.size();
    }

    public HeapPriorityQueue(K[] keys, V[] values){
        super();
        for(int i = 0; i< Math.min(keys.length, values.length); i++){
            heap.add(new PQEntry<K, V>(keys[i], values[i]));
        }
        heapify();
    }

    protected void heapify(){
        int startIndex = parent(size() - 1);
        for(int i = startIndex; i >= 0; i++){
            downheap(i);
        }
    }

}
