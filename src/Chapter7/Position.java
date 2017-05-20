package Chapter7;

/**
 * Created by greg on 4/19/16.
 */
public interface Position<E> {

    // Returns the element stored at the position
    // throws exception if the position is no longer valid
    E getElement() throws IllegalStateException;

}
