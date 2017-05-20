package Chapter8;

import java.util.Iterator;

/**
 * Created by greg on 4/19/16.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    private class Node<E> implements Position<E>{

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        // Constructor
        public Node(E e, Node<E> p, Node<E> l, Node<E> r){
            element = e;
            parent = p;
            left = l;
            right = r;
        }

        public Node<E> getParent(){
            return parent;
        }

        public Node<E> getLeft(){
            return left;
        }

        public Node<E> getRight(){
            return right;
        }

        public void setElement(E e){
            element = e;
        }

        public void setParent(Node<E> p){
            parent = p;
        }

        public void setLeft(Node<E> l){
            left = l;
        }

        public void setRight(Node<E> r){
            right = r;
        }

        @Override
        public E getElement() {
            return element;
        }
    }

    // Factory method used to create new nodes
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
        return new Node<E>(e, parent, left, right);
    }

    
    protected Node<E> root = null;
    private int size = 0;

    // Constructor
    public LinkedBinaryTree(){}

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("Not valid position type.");
        }
        Node<E> n = (Node<E>) p;
        if(n.getParent() == n){
            throw new IllegalArgumentException("This position is no longer valid.");
        }

        return n;
    }

    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> root(){
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException{
        Node<E> n = validate(p);
        return n.getParent();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException{
        Node<E> n = validate(p);
        return n.getLeft();
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException{
        Node<E> n = validate(p);
        return n.getRight();
    }

    // Creates the root of the tree. Error if the tree is not empty
    // Returns the position object of that root
    public Position<E> addRoot(E e) throws IllegalArgumentException{
        if(!isEmpty()){
            throw new IllegalStateException("The tree is not empty");
        }
        root = new Node<>(e, null, null, null);
        size=1;
        return root;
    }

    // Creates the left child of the given position p. Error if left child exists
    // Returns the position of the left node that was created
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getLeft() != null){
            throw new IllegalArgumentException("The left child already exists.");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    // Same notes as above, put for right instead of left
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getRight() != null){
            throw new IllegalArgumentException("The left child already exists.");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    // Stores the given element e into the given Position p. Error if the position does not exist
    // Returns the element previously stored at that position
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    // Attaches the both trees as the respective left and right nodes of the given position node
    // Error if the given position node is not a leaf.
    // Assigns the two trees to be empty after they have been moved
    public void attach(Position<E> p, LinkedBinaryTree<E> T1, LinkedBinaryTree<E> T2) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if(isInternal(node)){
            throw new IllegalArgumentException("The node must be a left.");
        }

        // Now we can actually link the nodes
        if(!T1.isEmpty()){
            size += T1.size;
            T1.root.setParent(node);
            node.setLeft(T1.root);
            T1.root = null;
            T1.size = 0;
        }

        if(!T2.isEmpty()){
            size += T2.size;
            T2.root.setParent(node);
            node.setRight(T2.root);
            T2.root = null;
            T2.size = 0;
        }
    }

    // Removes the given position from the Tree. Replaces it with its child.
    // Error if there is more than one child. Should be 0 or 1 child
    // Returns the element that was stored at position p
    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if(numChildren(node) == 2){
            throw new IllegalArgumentException("There must be 0 or 1 child for this node");
        }
        // Get the correct child node
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if(child != null){
            child.setParent(node.getParent());
        }
        if(node == root){
            root = child;
        }
        else{
            if(node == node.getParent().getLeft()){
                node.getParent().setLeft(child);
            }else{
                node.getParent().setRight(child);
            }
        }
        E temp = node.getElement();
        size--;
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);   // Convention used to identify a defunct node
        return temp;
    }
}
