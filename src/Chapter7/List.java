package Chapter7;

/**
 * Created by greg on 4/19/16.
 */
public interface List<E> {

    int size();
    boolean isEmpty();

    // returns the element stored at index i. Error if index is not in range
    E get(int i) throws IndexOutOfBoundsException;

    // Sets the element at index i to e and return the previous element
    // Error if the index is out of range
    E set(int i, E e) throws IndexOutOfBoundsException;

    // Adds the element e at the index i
    // Error if the index is out of range
    void add(int i, E e) throws IndexOutOfBoundsException;

    // Removes and returns the element stored at index i
    E remove(int i) throws IndexOutOfBoundsException;
}
