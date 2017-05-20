package Chapter8;

/**
 * Created by greg on 4/19/16.
 */
public class TreeNode<E> implements Position<E> {

    private E element;


    @Override
    public E getElement() {
        return element;
    }
}
