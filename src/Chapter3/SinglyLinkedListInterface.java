package Chapter3;

/**
 * Created by greg on 4/18/16.
 */
public interface SinglyLinkedListInterface<E> {

    int size();
    boolean isEmpty();
    E first();
    E last();
    void addFirst(E e);
    void addLast(E e);
    // Removes and returns the first elements
    E removeFirst();

}
