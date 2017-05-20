package Chapter9;

/**
 * Created by greg on 4/29/16.
 */
public class Chapter9Tester {

    public static void main(String[] args){

        /*
        UnsortedPriorityQueue<Integer, Character> queue = new UnsortedPriorityQueue<>();
        queue.insert(1,'b');
        queue.insert(2,'c');
        queue.insert(3,'d');
        queue.insert(0,'a');

        System.out.println(queue.min().getValue());
        */

        HeapAdaptablePriorityQueue<Integer, Character> heap = new HeapAdaptablePriorityQueue<>();
        heap.insert(1, 'b');
        heap.insert(2, 'c');
        heap.insert(3, 'd');
        heap.insert(0, 'a');

        System.out.println(heap.min().getValue());
        heap.replaceValue(heap.min(), 'z');
        System.out.println(heap.min().getValue());

    }

}
