package Chapter6;
import Chapter3.DoublyLinkedList;

/**
 * Created by greg on 4/27/16.
 */
public class LinkedDeque<E> implements Deque<E> {

    DoublyLinkedList<E> data;

    public LinkedDeque(){
        data = new DoublyLinkedList<>();
    }

    @Override
    public void addFirst(E e) {
        data.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        data.addLast(e);
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
    public E removeFirst() throws IndexOutOfBoundsException{
        if(data.isEmpty()){
            throw new IndexOutOfBoundsException("The deque is empty");
        }
        return data.removeFirst();
    }

    @Override
    public E removeLast() throws IndexOutOfBoundsException{
        if(data.isEmpty()){
            throw new IndexOutOfBoundsException("The deque is empty");
        }
        return data.removeLast();
    }

    @Override
    public E first() throws IndexOutOfBoundsException{
        if(data.isEmpty()){
            throw new IndexOutOfBoundsException("The deque is empty");
        }
        return data.first();
    }

    @Override
    public E last() throws IndexOutOfBoundsException{
        if(data.isEmpty()){
            throw new IndexOutOfBoundsException("The deque is empty");
        }
        return data.last();
    }
}
