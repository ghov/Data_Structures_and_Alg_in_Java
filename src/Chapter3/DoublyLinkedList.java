package Chapter3;

/**
 * Created by greg on 4/18/16.
 */
public class DoublyLinkedList<E> implements SinglyLinkedListInterface<E> {

    private int size = 0;
    private DoubleNode<E> header;
    private DoubleNode<E> trailer;

    public DoublyLinkedList(){
        // Set the sentinel nodes here on construction
        header = new DoubleNode<E>(null, null, null);
        trailer = new DoubleNode<E>(null, header, null);
        header.setNext(trailer);
    };

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size==0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public E first() {
        // If empty, return null
        return header.getNext().getElement();
    }

    @Override
    public E last() {
        return trailer.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    @Override
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, DoubleNode<E> pre, DoubleNode<E> n){
        // Adds the new node between the two nodes given
        DoubleNode<E> newNode = new DoubleNode<>(e, pre, n);
        pre.setNext(newNode);
        n.setPrev(newNode);

        size++;
    }

    private E remove(DoubleNode<E> n){
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        size--;
        return n.getElement();
    }


}
