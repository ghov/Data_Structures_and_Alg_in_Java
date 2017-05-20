package Chapter8;

import java.util.Iterator;

/**
 * Created by greg on 4/16/16.
 */

// The class definitions of the trees should implement root(), parent(), children().
// As apposed to having an abstract class implement the other methods
/*
    Think of Positions as nodes
 */
public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    int numChildren(Position<E> p) throws IllegalArgumentException;
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    int size();
    boolean isEmpty();

    Iterator<E> iterator();
    Iterable<Position<E>> positions();
}
