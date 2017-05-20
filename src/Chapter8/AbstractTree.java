package Chapter8;

import Chapter6.LinkedQueue;
import Chapter6.Queue;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by greg on 4/16/16.
 */
public abstract class AbstractTree<E> implements Tree<E> {

    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty(Position<E> p) {
        return size() == 0;
    }

    // User a recursive definition based on the root
    // Calculates how deep the position is, with root being 0
    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    public int heightBad() {
        int h = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p)) {
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    // The height of this subtree is the number of levels of children that it has.
    // If it is an external node, then height is zero
    // Since a position may have many children, we need to get the maximum height of the children
    public int height(Position<E> p) {
        int h = 0;

        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }

        return h;
    }

    private void preorderSubtree(Position<E> position, List<Position<E>> list){
        list.add(position);
        for(Position<E> c : children(position)){
            preorderSubtree(c, list);
        }
    }

    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            preorderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    private void postorderSubtree(Position<E> position, List<Position<E>> list){
        for(Position<E> c : children(position)){
            postorderSubtree(c, list);
        }
        list.add(position);
    }

    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            postorderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> list = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> queue = new LinkedQueue<>();
            queue.enqueue(root());
            while (!queue.isEmpty()) {
                Position<E> p = queue.dequeue();
                list.add(p);
                for (Position<E> c : children(p)) {
                    queue.enqueue(c);
                }
            }
        }
        return list;
    }

    public Iterable<Position<E>> positions(){
        return breadthfirst();
    }

    private class ElementIterator implements Iterator<E>{

        private Iterator<Position<E>> iter = positions().iterator();

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public E next() {
            return iter.next().getElement();
        }

        @Override
        public void remove() {
            iter.remove();
        }
    }


    public Iterator<E> iterator(){
        return new ElementIterator();
    }

}
