package Chapter6;

/**
 * Created by greg on 4/27/16.
 */
public interface Deque<E> {

    void addFirst(E e);
    void addLast(E e);
    boolean isEmpty();
    int size();
    E removeFirst() throws IndexOutOfBoundsException;
    E removeLast() throws IndexOutOfBoundsException;
    E first() throws IndexOutOfBoundsException;
    E last() throws IndexOutOfBoundsException;

}
