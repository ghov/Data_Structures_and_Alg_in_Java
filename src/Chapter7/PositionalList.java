package Chapter7;

import Chapter7.Position;

/**
 * Created by greg on 4/19/16.
 */
public interface PositionalList<E> {

    int size();
    boolean isEmpty();

    // Return null if empty
    Position<E> first();

    // Return null if empty
    Position<E> last();

    // If p is the first position, return null
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    // Return null is p is the last position
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    Position<E> addFirst(E e);
    Position<E> addLast(E e);

    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
    E set(Position<E> p, E e) throws IllegalArgumentException;
    E remove(Position<E> p) throws IllegalArgumentException;

}
