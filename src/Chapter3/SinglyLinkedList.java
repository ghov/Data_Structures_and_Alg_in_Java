package Chapter3;

/**
 * Created by greg on 4/18/16.
 */
public class SinglyLinkedList<E> implements SinglyLinkedListInterface<E>{

    // Store a reference to the head and the tail. More efficient
    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    public SinglyLinkedList(){};

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
            return head.getElement();
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
            head = new Node<>(e, null);
            tail = head;
            size++;
        }
        else {
            Node newNode = new Node(e, head);
            head = newNode;
            size++;
        }
    }

    @Override
    public void addLast(E e) {
        // If the list is empty then we add to the first one
        if (isEmpty()){
            head = new Node<>(e, null);
            tail = head;
            size++;
        }else {
            // Otherwise we add to the end of the list and append size
            Node newNode = new Node(e, null);
            // Make sure the previous last is now pointing to the new last
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }

    @Override
    public E removeFirst() {
        // Removes and returns the first Node in the list
        //
        if(isEmpty()){
            return null;
        }
        E returnElement = head.getElement();
        head = head.getNext();
        size--;
        // If size is now zero, then we need to account for the tail node
        if (size==0){
            tail=null;
        }
        return returnElement;
    }
}
