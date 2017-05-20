package Chapter3;

/**
 * Created by greg on 4/18/16.
 */
public class DoubleNode<E> {
    // Node class used for the DoublyLinkedList

    private E element;
    private DoubleNode<E> next;
    private DoubleNode<E> prev;

    public DoubleNode(E e, DoubleNode<E> previous, DoubleNode<E> nextN){
        element = e;
        prev = previous;
        next = nextN;
    }

    public E getElement(){
        return element;
    }

    public DoubleNode<E> getNext(){
        return next;
    }

    public DoubleNode<E> getPrev(){
        return prev;
    }

    public void setNext(DoubleNode<E> e){
        next = e;
    }

    public void setPrev(DoubleNode<E> e){
        prev = e;
    }

}