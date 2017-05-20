package Chapter6;
import Chapter3.SinglyLinkedList;

/**
 * Created by greg on 4/27/16.
 */

// Don't have to worry about resizing the array

public class LinkedQueue<E> implements Queue<E> {

    SinglyLinkedList<E> data;

    public LinkedQueue(){
        data = new SinglyLinkedList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E first() throws IndexOutOfBoundsException{
        if (data.first() == null){
            throw new IndexOutOfBoundsException("The list is empty");
        }

        return data.first();
    }

    @Override
    public E dequeue() {
        if(data.first() == null){
            throw new IndexOutOfBoundsException("The list is empty");
        }

        return data.removeFirst();
    }
}
