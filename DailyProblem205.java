
package dailyproblem205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This problem was asked by IBM.
 *
 * Given an integer, find the next permutation of it in absolute order. 
 * For example, given 48975, the next permutation would be 49578.
 * Created 30-Oct-2019 on 11:25:33 AM
 * @author B. Cutten
 */
public class DailyProblem205 {

   
    public static void main(String[] args) {
        int i = 48975;
        //first turn the int into an array of character to make swapping easier
        char[] numArray = ("" + i).toCharArray();
        //make a list to store all the permutations of it
        ArrayList<Integer> pList = new ArrayList();
        //find all permuatations using recursive magic
        makePermutations(pList, numArray, 0, numArray.length - 1);
        //sort them
        Collections.sort(pList);
        //find this one
        int me = pList.indexOf(i);
        //print the next one        
        int next = pList.get(me + 1);
        System.out.println(next);
    }

    

    /**
     * This recursive method adds permutations of an array of character to a list
     * Help from: https://www.geeksforgeeks.org/java-program-to-print-all-permutations-of-a-given-string/
     * @param pList - the master list of perms
     * @param numArray - the array to permute
     * @param left - the left most index
     * @param right - the right most index
     */
    private static void makePermutations(ArrayList<Integer> pList, char[] numArray, int left, int right) {
       
        if(left == right){
             //base case, the permutation has no chars left to swap
             pList.add(makeInt(numArray));
         }else{
             //make a local copy of the array so we don't ruin things for the other recursive calls
             char[] myNumArray = numArray.clone();
             char temp;
             //swap all the chars
             for (int i = left; i <= right; i++) {
                 //swap left and i
                 temp = myNumArray[left];
                 myNumArray[left] = myNumArray[i];
                 myNumArray[i] = temp;
                 //find permutations of the next index
                 makePermutations(pList, myNumArray, left + 1, right);
                 //swap left and i again (back to original)
                 temp = myNumArray[left];
                 myNumArray[left] = myNumArray[i];
                 myNumArray[i] = temp;
             }
         }
    }

    /**
     * Turns an array of chars back into an integer
     * @param numArray - the array to collapse
     * @return an Integer
     */
    private static Integer makeInt(char[] numArray) {
        String sNum = "";
        for (int i = 0; i < numArray.length; i++) {
            sNum += numArray[i];
        }
        return Integer.parseInt(sNum);
    }
    
    

}
