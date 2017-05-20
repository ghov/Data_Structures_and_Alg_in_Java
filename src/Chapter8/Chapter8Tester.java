package Chapter8;

import Chapter7.List;
import Chapter6.LinkedQueue;

import java.util.Iterator;

/**
 * Created by greg on 4/28/16.
 */
public class Chapter8Tester {

    public static void main(String[] args){


        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.addRoot(5);
        // System.out.println(tree.size());
        // System.out.println(tree.isEmpty());
        // System.out.println(tree.addRoot(0).getElement());
        tree.addLeft(tree.root(), 15);
        tree.addRight(tree.root(), 10);


        Iterator<Integer> list = tree.iterator();

        while(list.hasNext()){
            System.out.println(list.next());
        }


        // System.out.println(tree.size());
        // System.out.println(tree.isEmpty());
        // System.out.println(tree.root().getElement());
        // System.out.println(tree.left(tree.root()).getElement());
        // System.out.println(tree.right(tree.root()).getElement());
        // System.out.println(tree.parent(tree.root()));




        // System.out.println(tree.)





    }
}
