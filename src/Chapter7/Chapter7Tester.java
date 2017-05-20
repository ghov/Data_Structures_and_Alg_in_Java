package Chapter7;

import java.util.Iterator;
import java.lang.Iterable;

/**
 * Created by greg on 4/27/16.
 */
public class Chapter7Tester {

    public static void main(String[] args){


        LinkedPositionList<Integer> list = new LinkedPositionList<>();

        for(int i = 0; i<1000; i++){
            list.addFirst(i);
        }

        Iterator<Integer> iter = list.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        /*
        Iterable<Position<Integer>> pos = list.positions();

        Iterator<Position<Integer>> iter = pos.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next().getElement());
        }

        /*

        System.out.println(list.isEmpty());
        System.out.println(list.size());

        list.addFirst(0);
        list.addLast(1);

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        System.out.println(list.first().getElement());
        System.out.println(list.last().getElement());
        */


        /*
        ArrayList<Integer> list = new ArrayList<>();

        // System.out.println(list.isEmpty()); // true
        // System.out.println(list.size()); // 0

        // list.add(0, 0);
        // list.add(0, 50);
        // list.add(0, 2);

        // System.out.println(list.get(0)); // 0
        // System.out.println(list.set(0,1)); // 0
        // System.out.println(list.remove(0)); // 1
        // System.out.println(list.get(0));

        // list.set(1,5);

        // System.out.println(list.size()); // 1
        // System.out.println(list.isEmpty());

        for(int i = 0; i<1000; i++) {
            list.add(i, i);
        }

        Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        // System.out.println(list.size());
        */

    }

}
