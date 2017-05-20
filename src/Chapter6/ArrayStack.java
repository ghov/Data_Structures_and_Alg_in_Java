package Chapter6;
/**
 * Created by greg on 4/27/16.
 */
public class ArrayStack<E> implements Stack<E> {

    // Data will be stored in an array. Need to account for position movement when we pop
    final static private int capacity = 100;
    private E[] data;
    private int position=0;

    public ArrayStack(){
        this(capacity);
    }

    public ArrayStack(int cap){
        data = (E[])new Object[cap];
    }

    @Override
    public void push(E e) throws IndexOutOfBoundsException{
        if(isFull()){
            throw new IndexOutOfBoundsException("The stack is full");
        }
        data[position++] = e;
    }

    // Throw error if empty
    @Override
    public E pop() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("The stack is empty");
        }

        E temp = data[position-1];
        position--;
        data[position] = null;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return position==0;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public E top() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("The stack is empty");
        }

        return data[position-1];
    }

    private boolean isFull(){
        return position==data.length;
    }
}
