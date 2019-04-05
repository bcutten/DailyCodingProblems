/*
 * This problem was recently asked by Google.

    Given a list of numbers and a number k, return whether any two numbers 
    from the list add up to k.

    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

    Bonus: Can you do this in one pass?
 */

package dailyproblem1;

/**
 * Created 5-Apr-2019 on 1:53:06 PM
 * @author B. Cutten
 */
public class DailyProblem1 {

   
    public static void main(String[] args) {
        int k = 17;
        int a[] = {10, 15, 3, 7};
        int size = a.length;
        boolean found = false; //assume no matching pair
        //for each element
        for (int i = 0; i < size; i++) {
            //check if any of the other elements sum with this one to the special k
            for (int j = 0; j < size; j++) {
                if(i != j){ //assuming we can't sum the element with itself
                    if(a[i] + a[j] == k){ //does the sum match?
                        found = true;
                        //stop looking
                        i = size;
                        j = size;
                    }
                }
            }
        }
        System.out.println(found);
        //apparantly this one can be done in one pass using a hashmap
        
    }

}
