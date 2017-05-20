package Chapter6;

/**
 * Created by greg on 4/27/16.
 */

// Data structure that stores new values on top and removes from the top. So its LIFO

public interface Stack<E> {

    void push(E e);
    E pop(); // Removes and returns the element currently on top
    boolean isEmpty();
    int size();
    E top();
    }
