package Chapter6;
import Chapter3.SinglyLinkedList;

/**
 * Created by greg on 4/27/16.
 */

// Currently does not check for nulls. Could add functionality to check for null and throw error

public class LinkedStack<E> implements Stack<E> {

    SinglyLinkedList<E> data;

    public LinkedStack(){
        data = new SinglyLinkedList<>();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public E top() {
        return data.first();
    }
}
