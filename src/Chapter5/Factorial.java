package Chapter5;

/**
 * Created by greg on 2/15/16.
 */
public class Factorial {

    public static void main(String args[]){
        System.out.println(factorial(6));
    }

    public static int factorial(int n) throws IllegalArgumentException{
        if(n<0){
            throw new IllegalArgumentException();
        }
        else if(n==0){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
}
