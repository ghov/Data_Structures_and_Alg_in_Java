package Chapter6;

/**
 * Created by greg on 4/27/16.
 */
public class Tester {

    public static void main(String[] args) {

        LinkedDeque<Integer> deque = new LinkedDeque<>();

        System.out.println(deque.size());   // 0
        System.out.println(deque.isEmpty());    // true

        deque.addFirst(0);
        deque.addLast(1);

        System.out.println(deque.first());  // 0
        System.out.println(deque.last());   // 1

        System.out.println(deque.size());   // 2
        System.out.println(deque.isEmpty());    // false

        System.out.println(deque.removeFirst());    // 0
        System.out.println(deque.removeLast());     // 1



        /*
        LinkedStack<Integer> stack = new LinkedStack<>();

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.top());
        System.out.println(stack.pop());

        stack.push(10);

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        stack.push(11);

        System.out.println(stack.top());
        System.out.println(stack.pop());

        System.out.println(stack.size());
        */


        /*
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println(queue.size()); // 0
        System.out.println(queue.isEmpty()); // true
        queue.enqueue(0);
        queue.enqueue(1);

        System.out.println(queue.size()); // 2
        System.out.println(queue.isEmpty()); // false

        System.out.println(queue.first()); // 0
        System.out.println(queue.dequeue()); // 0

        System.out.println(queue.dequeue()); // 1

        System.out.println(queue.size()); // 0
        System.out.println(queue.isEmpty()); // true

        System.out.println(queue.first()); // error
        System.out.println(queue.dequeue()); // error

        // System.out.println(queue);

        */

    }

    /*
    public static int power(int num, int pow){
        if(pow < 0){

        }



        if(pow == 0){
            return 1;
        }else if(pow == 1){
            return num;
        }else{
            return num * power(num, pow-1);
        }

    }
    */

}
