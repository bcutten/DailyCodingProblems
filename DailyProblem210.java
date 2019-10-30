package dailyproblem210;

/**
 * This problem was asked by Apple.
 *
 * A Collatz sequence in mathematics can be defined as follows. Starting with
 * any positive integer:
 *
 * if n is even, the next number in the sequence is n / 2 if n is odd, the next
 * number in the sequence is 3n + 1 It is conjectured that every such sequence
 * eventually reaches the number 1. Test this conjecture.
 *
 * Bonus: What input n <= 1000000 gives the longest sequence? Created
 * 30-Oct-2019 on 12:32:43 PM @author B. Cutten
 */
public class DailyProblem210 {

    //static int[] lengths = new int[20000000];

    public static void main(String[] args) {
        int n = 12;
        //n of 12 is length 10
        System.out.println(collatzLength(n));
        
        //now check which number has the longest sequence
        int max = 0;
        int len;
        int longestSequence = -1;
        //this for loop takes too long to run
        //need to use some dynamic programming?
        //nope, turns out the sequence overflows an int, changed to long
        for (int i = 1; i <= 1000000; i++) { //test all values in the range
            len = collatzLength(i);            
            if (len > max) { //did this value have the longest length?
                max = len;
                longestSequence = i;
            }
        }
        System.out.println(longestSequence);
        

    }

    /**
     * This method calculates the length of the Collatz sequence for the given number
     * @param n - the number to get the length for (needs to be a long for bigger numbers (>113382)
     * @return the length of the sequence
     */
    private static int collatzLength(long n) {
        int count = 1; //start with the original value
        //int startN = n;
        while (n != 1) { //keep going until we reach 1
            
            if (n % 2 == 0) { //is it even?
                n = n / 2;
            } else { //it's odd
                n = 3 * n + 1;
            }
            count++;
            //check if we've already calculated the new n
            /*if (lengths[n] != 0 || n == 1) {
                lengths[startN] = lengths[n] + count;
                n = 1;//stop the loop
            }*/

        }
        //return lengths[startN];
        return count;
    }

}
