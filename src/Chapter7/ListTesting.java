package Chapter7;

/**
 * Created by greg on 4/19/16.
 */
public class ListTesting {

    public static void main(String[] main){

        LinkedPositionList<Integer> list = new LinkedPositionList<>();

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        System.out.println(list.first());
        System.out.println(list.last());

        /*
        ArrayList<Integer> list = new ArrayList<>(1);

        System.out.println(list.isEmpty());
        System.out.println(list.size());

        list.add(0, 5);

        System.out.println(list.get(0));
        System.out.println(list.remove(0));

        list.add(0, 10);
        list.set(0, 1);

        System.out.println(list.remove(0));

        for(int i=0; i<1000; i++){
            list.add(i,i);
        }

        for(int i=0; i<100; i++){
            System.out.println(list.get(i));
        }
    */

    }
}
