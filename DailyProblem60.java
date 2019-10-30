package dailyproblem60;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This problem was asked by Facebook.
 *
 * Given a multiset of integers, return whether it can be partitioned into two
 * subsets whose sums are the same.
 *
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return
 * true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which
 * both add up to 55.
 *
 * Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't
 * split it up into two subsets that add up to the same sum. Created 30-Oct-2019
 * on 1:04:24 PM
 *
 * @author B. Cutten
 */
public class DailyProblem60 {

    public static void main(String[] args) {
        int[] n = {15, 5, 20, 10, 35, 15, 10};
        int[] o = {15, 5, 20, 10, 35};
        System.out.println(canPartition(o));
    }

    private static boolean canPartition(int[] n) {
        //first see what half of the sum is
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        //an odd sum can't be made
        if (sum % 2 == 1) {
            return false;
        }
        //sum was even so maybe it can be made
        int halfSum = sum / 2;
        //now see if there are two ways to make the halfSum with the given numbers
        //converting to array list to make removal easier
        ArrayList<Integer> nums = new ArrayList();
        for (int i = 0; i < n.length; i++) {
            nums.add(n[i]);
        }
        //if there are two ways to get the sum then the we can partition
        return countNumWays(nums, halfSum) == 2;
    }

    private static int countNumWays(ArrayList<Integer> nums, int halfSum) {
        int target;
        int n;
        int count = 0;
        int offset;
        Collections.sort(nums); //sort the list 
        while (nums.size() > 0) { //keep trying until there are no items left in the list
            target = halfSum; //number we're trying to add to
            offset = 0; //distance from the end of the list (always start by grabbing the biggest number)
            while (target > 0) {
                System.out.println(target);
                n = nums.get(nums.size() - (1 + offset)); //biggest number in the list
                if (n == target) { //does it match the desired sum exactly
                    count++; //this is one way to do it 
                    nums.remove(nums.size() - 1); //remove from the list
                    target = 0;//stop the loop
                } else if (n < target) { //it's less than the sum
                    target -= n; //take this number out of the sum
                    nums.remove(nums.size() - 1); //remove from the list
                } else {
                    //it won't work
                    //stop the loop and try again with the next number down
                    offset++;
                }
            }
        }
        return count;
    }

}
