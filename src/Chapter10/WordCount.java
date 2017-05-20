package Chapter10;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Created by greg on 9/5/16.
 */
public class WordCount {

    public static void main(String[] args){

        java.util.Map<String, Integer> freq= new HashMap<>();

        // Get input from doc
        Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
        while(doc.hasNext()){
            String word = doc.next().toLowerCase();
            Integer count = freq.get(word);
            if(word == "stop"){
                break;
            }
            if(count == null){
                count = 0;
            }
            freq.put(word, 1 + count);
        }

        int maxCount = 0;
        String maxWord = "no word";
        for(java.util.Map.Entry<String, Integer> entry : freq.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        System.out.print("The most frequently used word is " + maxWord);
        System.out.println(" with " + maxCount + " occurrences.");

        }
    }
}
