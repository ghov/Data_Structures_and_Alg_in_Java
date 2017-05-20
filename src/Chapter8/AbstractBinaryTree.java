package Chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by greg on 4/16/16.
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    // Returns the sibling of the given position
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException{
        Position<E> parent = parent(p);
        if(parent==null)return null;
        if(p==left(parent)) {
            return right(parent);
        }else{
            return left(parent);
        }
    }

    public int numChildren(Position<E> p){
        int count = 0;
        if (left(p)!=null){
            count++;
        }
        if (right(p)!=null){
            count++;
        }
        return count;
    }

    public Iterable<Position<E>> children(Position<E> p){
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p)!=null){
            snapshot.add(left(p));
        }
        if (right(p)!=null){
            snapshot.add(right(p));
        }
        return snapshot;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> list){
        if(left(p)!=null){
            inorderSubtree(left(p), list);
        }
        list.add(p);
        if(right(p) != null){
            inorderSubtree(right(p), list);
        }
    }

    public Iterable<Position<E>> inorder(){
        List<Position<E>> list = new ArrayList<>();
        if(!isEmpty()){
            inorderSubtree(root(), list);
        }

        return list;
    }

    @Override
    public Iterable<Position<E>> positions(){
        return inorder();
    }

}
