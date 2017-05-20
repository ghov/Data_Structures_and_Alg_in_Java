package Chapter9;

import java.util.Comparator;

/**
 * Created by greg on 4/20/16.
 */
public class DefaultComparator<E> implements Comparator<E> {

    public int compare(E a, E b) throws ClassCastException{
        return ((Comparable<E>) a).compareTo(b);
    }
}
