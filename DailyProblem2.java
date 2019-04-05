/*
 * This problem was asked by Uber.

    Given an array of integers, return a new array such that each element at index i 
    of the new array is the product of all the numbers in the original array except 
    the one at i.

    For example, if our input was [1, 2, 3, 4, 5], the expected output would be 
    [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output 
    would be [2, 3, 6].

    Follow-up: what if you can't use division?
 */

package dailyproblem2;

/**
 * Created 5-Apr-2019 on 1:39:51 PM
 * @author B. Cutten
 */
public class DailyProblem2 {

   
    public static void main(String[] args) {
        int a[] = {3,2,1};
        int size = a.length;
        int b[] = new int[size];
        int prod;
        //for each element in the array
        for (int i = 0; i < size; i++) {
            prod = 1;
            //loop through each element again
            for (int j = 0; j < size; j++) {
                //only mulitply if it's not the orginal number
                if(i != j){
                    prod *= a[j];
                }
            }
            //store the prod in the new array
            b[i] = prod;
        }
        //print the new array
        for (int i = 0; i < size; i++) {
            System.out.println(b[i]);
        }
        
                
    }

}
