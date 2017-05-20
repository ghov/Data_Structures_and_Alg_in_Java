package Chapter10;

import java.util.Iterator;

/**
 * Created by greg on 9/6/16.
 */
public class ChainHashMapTester {

    public static void main(String[] args){

        ProbeHashMap<Integer, Character> map = new ProbeHashMap<>();

        map.put(3, 'd');
        map.put(0, 'a');
        map.put(1, 'b');
        map.put(2, 'c');

        Iterator<Integer> i= map.keySet().iterator();
        Iterator<Character> j = map.values().iterator();


        while(i.hasNext()){
            System.out.println("The key is: " + i.next());
        }

        while(j.hasNext()){
            System.out.println("The value is: " + j.next());
        }

    }


}
