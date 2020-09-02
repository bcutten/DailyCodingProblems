/*
 * B Cutten
 * Sept 2, 2020
 * Removing the rust :)
 * This problem was asked by Microsoft.

    Let's represent an integer in a linked list format by having each node 
    represent a digit in the number. The nodes make up the number in reversed order.

    For example, the following linked list:

    1 -> 2 -> 3 -> 4 -> 5
    is the number 54321.

    Given two linked lists in this format, return their sum in the same linked list format.

    For example, given

    9 -> 9
    5 -> 2
    return 124 (99 + 25) as:

    4 -> 2 -> 1
 */
package dailycodingproblem452;

import java.util.LinkedList;

public class DailyCodingProblem452 {

    
    public static void main(String[] args) {
        LinkedList<Integer> num1 = new LinkedList();
        LinkedList<Integer> num2 = new LinkedList();
        LinkedList<Integer> sum;
        
        //populate lists with test data
        num1.add(9);
        num1.add(9);
        
        num2.add(5);
        num2.add(2);
        
        //add the lists in another method
        sum = addLists(num1, num2);
        
        //check if it worked!
        System.out.println(sum);
    }

    /**
     * This method adds the two reversed lists as described in the problem
     * @param num1 - the first reversed list of digits
     * @param num2 - the second reversed list of digits
     * @return a new reversed list containing the sum
     */
    private static LinkedList<Integer> addLists(LinkedList<Integer> num1, LinkedList<Integer> num2) {
        int n1, n2, sum;
        //turn the list into an actual number so we can add them
        n1 = undoList(num1);
        n2 = undoList(num2);
        //add the two numbers
        sum = n1 + n2;
        //turn the integer sum back into a list and return it
        return redoList(sum);
    }

    /**
     * Turns a list of digits into an integer (with the digits reversed)
     * @param numList - the list of digits in the backwards number
     * @return an integer with all of the digits in the list, reversed
     */
    private static int undoList(LinkedList<Integer> numList) {
        int n;
        String sN = ""; //add the digits to a String first
        //for each digit in the list
        for (int i = 0; i < numList.size() ; i++) {
            //grab the last item in the list and add it to the String
            sN += numList.get(numList.size() - i - 1);
        }
        //convert the String to an integer
        n = Integer.parseInt(sN);        
        return n;
    }

    /**
     * Take an integer and put it into list format, with the digits reversed
     * @param n - the integer
     * @return a list of digits
     */
    private static LinkedList<Integer> redoList(int n) {
        LinkedList<Integer> sumList = new LinkedList();
        //first turn the integer into a String
        String sSum = "" + n;
        //loop through each character in the String, starting at the end
        for (int i = sSum.length() - 1; i >= 0; i--) {
            //turn the character into an Integer and add it to the list
            sumList.add(Integer.parseInt(sSum.substring(i, i + 1)));
        }
        return sumList;
    }
    
}
