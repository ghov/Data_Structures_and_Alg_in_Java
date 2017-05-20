package Chapter6;

/**
 * Created by greg on 4/18/16.
 */

// This needs to be implemented in a circular method for the array
// The next to be removed is f = (f+1) % N, where N is the capacity of the array. This allows circular function

public class ArrayQueue<E> implements Queue<E> {

    private E[] data;
    private int size = 0;
    private int position = 0;
    private static final int capacity = 100;

    public ArrayQueue(){
        this(capacity);
    }

    public ArrayQueue(int cap){
        data = (E[]) new Object[cap];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(E e) throws IndexOutOfBoundsException{
        if(isFull()){
            throw new IndexOutOfBoundsException("The queue is full");
        }
        data[(position + size) % data.length] = e;
        size++;
    }

    @Override
    public E first() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty");
        }

        return data[position];
    }

    @Override
    public E dequeue() throws IndexOutOfBoundsException {
        // Return the element at the current position
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        size--;
        E temp = data[position];
        data[position] = null;
        position = (position + 1) % data.length;
        return temp;
    }

    private boolean isFull(){
        return size==data.length;
    }
}
