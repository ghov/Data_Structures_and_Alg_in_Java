package Chapter8;

/**
 * Created by greg on 4/16/16.
 */
public interface BinaryTree<E> extends Tree<E>{
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    Position<E> sibling(Position<E> p) throws  IllegalArgumentException;
}
