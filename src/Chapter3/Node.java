package Chapter3;

/**
 * Created by greg on 4/18/16.
 */
public class Node<E> implements BasicNodeInterface<E>{

    private E element;
    private Node<E> next;

    public Node(E e, Node<E> n){
        element = e;
        next = n;
    }

    public E getElement(){
        return element;
    }

    public Node<E> getNext(){
        return next;
    }

    public void setNext(Node<E> n){
        next = n;
    }

}
