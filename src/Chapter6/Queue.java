package Chapter6;

/**
 * Created by greg on 4/18/16.
 */

// Data structure that works on a First in, First out principle.

public interface Queue<E> {

    int size(); // Returns the current size of the queue
    boolean isEmpty();
    void enqueue(E e);  // Inserts an elements at the end of a queue
    E first(); // Returns the first element in the queue
    E dequeue();    // Removes and returns the first element of the queue

}
