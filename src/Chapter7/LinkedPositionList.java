package Chapter7;

import javax.swing.text.ElementIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by greg on 4/19/16.
 */
public class LinkedPositionList<E> implements PositionalList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedPositionList(){
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        return position(head.getNext());
    }

    @Override
    public Position<E> last() {
        return position(tail.getPrevious());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> n = validate(p);
        return n.getPrevious();
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> n = validate(p);
        return n.getNext();
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, head, head.next);
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, tail.getPrevious(), tail);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> n = validate(p);
        return addBetween(e, n.getPrevious(), n);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> n = validate(p);
        return addBetween(e, n, n.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> n = validate(p);
        E temp = n.getElement();
        n.setElement(e);
        return temp;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> n = validate(p);
        E temp = n.getElement();
        n.getPrevious().setNext(n.getNext());
        n.getNext().setPrevious(n.getPrevious());
        n = null;
        n.setElement(null);
        n.setNext(null);
        n.setPrevious(null);
        size--;
        return temp;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException{
        // Check if the value is bad
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("Invalid p");
        }

        Node<E> n = (Node<E>) p;
        if(n.getNext() == null){
            throw new IllegalArgumentException("This position is no longer valid");
        }

        return n;
    }

    private Position<E> position(Node<E> n){
        if(n == head || n == tail){
            return null;
        }
        return n;
    }

    private Node<E> addBetween(E e, Node<E> prev, Node<E> next){
        Node<E> newest = new Node<E>(e, prev, next);
        prev.setNext(newest);
        next.setPrevious(newest);
        size++;
        return newest;
    }


    // Start of the inner Node class
    private class Node<E> implements Position<E>{

        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            previous = p;
            next = n;
        }

        @Override
        public E getElement() throws IllegalStateException {
            // If the node is flagged as "bad" then raise exception
            if(next == null){
                throw new IllegalStateException("Bad position object");
            }

            return element;
        }

        public Node<E> getNext(){
            return next;
        }

        public Node<E> getPrevious(){
            return previous;
        }

        public void setPrevious(Node<E> n){
            previous = n;
        }

        public void setNext(Node<E> n){
            next = n;
        }

        public void setElement(E e){
            element = e;
        }
    }

    // End of the Node private inner class

    // Start of Position iterator private class
    private class PositionIterator implements Iterator<Position<E>>{

        // Need variables to keep track of the active position
        private Position<E> cursor = first();
        private Position<E> recent = null;

        @Override
        public boolean hasNext() {
            return cursor!=null;
        }

        @Override
        public Position<E> next() throws NoSuchElementException{
            if(cursor == null){
                throw new NoSuchElementException("No more elements left");
            }
            recent = cursor;
            if(after(cursor) == tail){
                cursor = null;
            }else{
                cursor = after(cursor);
            }

            return recent;
        }

        // Throws error if the position cannot be removed(has already been removed)
        @Override
        public void remove() throws IllegalStateException{
            if(recent == null){
                throw new IllegalStateException("Cannot remove");
            }

            LinkedPositionList.this.remove(recent);

            // Set recent to null so we know it was removed
            recent = null;
        }


    }

    private class PositionIterable implements Iterable<Position<E>>{

        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    public Iterable<Position<E>> positions(){
        return new PositionIterable();
    }

    public Iterator<E> iterator(){
        return new ElementIterator();
    }

    private class ElementIterator implements Iterator<E>{

        Iterator<Position<E>> positions = new PositionIterator();

        @Override
        public boolean hasNext() {
            return positions.hasNext();
        }

        @Override
        public E next() {
            return positions.next().getElement();
        }

        @Override
        public void remove() {
            positions.remove();
        }
    }


}
