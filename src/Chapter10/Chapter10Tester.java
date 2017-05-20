package Chapter10;

import java.util.Iterator;

/**
 * Created by greg on 4/30/16.
 */
public class Chapter10Tester {

    public static void main(String[] args){

        UnsortedTableMap<Integer, Character> map = new UnsortedTableMap<>();
        map.put(3, 'd');
        map.put(0, 'a');
        map.put(1, 'b');
        map.put(2, 'c');

        Iterator<Entry<Integer,Character>> iter= map.entrySet().iterator();

        while(iter.hasNext()){

            System.out.println("The current value is " + iter.next().getKey());

        }

        System.out.println();

        for(Entry<Integer,Character> i : map.entrySet()){

            System.out.println("The current value is " + i.getValue());

        }

    }
}
