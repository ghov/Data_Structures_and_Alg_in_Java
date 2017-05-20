package Chapter7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by greg on 4/19/16.
 */
public class ArrayList<E> implements List<E>, Iterable<E> {

    private static final int capacity = 100;
    private E[] data;
    private int size = 0;

    public ArrayList(){
        this(capacity);
    }

    public ArrayList(int cap){
        data = (E[]) new Object[cap];
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
    public E get(int i) throws IndexOutOfBoundsException {
        // Check if the index is out of range
        if(isEmpty() || i < 0 || i>=size){
            throw new IndexOutOfBoundsException("Bad Index");
        }

        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if(isEmpty() || i < 0 || i>=size){
            throw new IndexOutOfBoundsException("Bad Index");
        }
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if(i < 0 || i > size){
            throw new IndexOutOfBoundsException("Bad Index");
        }

        if(size == data.length){
            resize(2*data.length);
        }

        // Move all of the elements after i and then add the new element
        for(int k=size-1; k >= i; k--){
            data[k+1] = data[k];
        }

        data[i] = e;
        size ++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if(isEmpty() || i >= data.length){
            throw new IndexOutOfBoundsException("Bad Index");
        }

        E temp = data[i];

        for(int k=i; k<size-1 ;k++){
            data[k]=data[k+1];
        }

        // Set the last index to null for garbage collection
        data[size-1] = null;
        return temp;
    }

    private void resize(int newCap){
     E[] temp = (E[]) new Object[newCap];

     for(int i= 0; i<data.length; i++){
         temp[i] = data[i];
     }

     data = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    // Start of array iterator class
    private class ArrayIterator implements Iterator<E>{

        private int counter = 0;
        private boolean removeable;

        @Override
        public boolean hasNext() {
            return counter<size;
        }

        @Override
        public E next() throws NoSuchElementException{
            if(counter == size){
                throw new NoSuchElementException("No more values");
            }
            removeable = true;
            return data[counter++];
        }

        @Override
        public void remove() throws IllegalStateException{
            if(removeable){
                ArrayList.this.remove(counter-1);
            }else{
                throw new IllegalStateException("Cannot remove");
            }
            removeable = false;
        }
    }
}
