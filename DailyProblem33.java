/*
 *  B Cutten
    May 6, 2019
    This problem was asked by Microsoft.

    Compute the running median of a sequence of numbers. 
    That is, given a stream of numbers, print out the median of the 
    list so far on each new element.

    Recall that the median of an even-numbered list is the average 
    of the two middle numbers.

    For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

    2
    1.5
    2
    3.5
    2
    2
    2
 */

package dailyproblem33;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DailyProblem33 {
   
    public static void main(String[] args) {
        
        ArrayList<Integer> nums = new ArrayList(); //the list
        int n; //the number to add
        try{ //to read the stream of numbers from a file
            File f = new File("src\\file.txt");
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                n = Integer.parseInt(s.nextLine());
                //add this number to the sorted list
                addSorted(nums, n);
                //print the current median
                System.out.println(getMedian(nums));
            }
        }catch(FileNotFoundException e){
            System.out.println("Error" + e);
        }
    }

    /**
     * Add a number to a list of Integers, maintaining a sorted order
     * @param nums - the list to add to
     * @param n - the number to add
     */
    private static void addSorted(ArrayList<Integer> nums, int n) {
        int loc = -1; //the location to add the number to
        //loop through the list
        for (int i = 0; i < nums.size(); i++) {
            //is the current value larger than the one we're adding?            
            if(nums.get(i) > n){
                //this is the place we want to insert the number
                loc = i;
                //stop looping
                i = nums.size();
            }
        }
        //if we didn't find a place to insert the number, then it goes at the end
        if(loc == -1){
            nums.add(n);
        }else{
            nums.add(loc, n);
        }
        
    }

    /**
     * Returns the median (middle number) of a list of numbers
     * A list with an even number of items will return the average of the middle two
     * @param nums - the list of numbers
     * @return the median of the input list
     */
    private static double getMedian(ArrayList<Integer> nums) {
        int size = nums.size();
        double median;
        //is this list odd length or even length?
        if(size % 2 == 1){ //there's exactly one middle element
            median = nums.get(size / 2);
        }else{//there are two middle numbers
            median = (nums.get(size/2) + nums.get(size/2 - 1)) / 2.0;
        }
        return median;
    }

}
