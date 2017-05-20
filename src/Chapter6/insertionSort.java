package Chapter6;

import Chapter7.LinkedPositionList;
import Chapter7.Position;
import Chapter7.PositionalList;

/**
 * Created by greg on 4/19/16.
 */
public class insertionSort {

    public static void main(String[] args){

        LinkedPositionList<Integer> list = new LinkedPositionList<>();
        for(int i = 0; i<3; i++){
            list.addFirst(i);
        }

        System.out.println(list.first().getElement());

        insertionSort(list);

        System.out.println(list.first().getElement());

    }

    public static void insertionSort(PositionalList<Integer> list){

        Position<Integer> marker = list.first();
        while(marker != list.last())
        {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            if(value > marker.getElement()){
                marker = pivot;
            }else {
                Position<Integer> walk = marker;
                while(walk != list.first() && list.before(walk).getElement() > value){
                    walk = list.before(walk);
                }

                list.remove(pivot);
                list.addBefore(walk, value);
            }

        }
    }
}
