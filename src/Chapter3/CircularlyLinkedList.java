package Chapter3;

/**
 * Created by greg on 4/18/16.
 */
public class CircularlyLinkedList<E> implements SinglyLinkedListInterface<E>{

    // Store a reference to the head and the tail. More efficient
    private int size = 0;
    private Node<E> tail = null;

    public CircularlyLinkedList(){};

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size()==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public E first() {
        if (isEmpty()){
            return null;
        }else{
            return tail.getNext().getElement();
        }
    }

    @Override
    public E last() {
        // Traverse linked list until the next pointer is null. That's our last value
        if (isEmpty()){
            return null;
        }

        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        // If empty, add to root
        if (isEmpty()){
            tail = new Node<>(e, null);
            tail.setNext(tail);
            size++;
        }
        else {
            // Add it after the
            Node newNode = new Node(e, tail.getNext());
            tail.setNext(newNode);
            size++;
        }
    }

    @Override
    public void addLast(E e) {
            addFirst(e);
            rotate(); // Same as tail=tail.getNext()
    }

    @Override
    public E removeFirst() {
        // Check if empty
        if (isEmpty()){
            return null;
        }
        // Store tail so it can be returned
        Node<E> returnNode = tail.getNext();

        // Check if there is only one node
        if (size==1){
            tail = null;
        }else {
            tail.setNext(returnNode.getNext());
        }
        size--;
        return returnNode.getElement();
    }

    public void rotate(){
        // Turns the first element into the last element
        if (!isEmpty()){
            tail = tail.getNext();
        }
    }

}
