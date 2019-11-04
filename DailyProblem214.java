package dailyproblem214;

/**
 * This problem was asked by Stripe.
 *
 * Given an integer n, return the length of the longest consecutive run of 1s in
 * its binary representation.
 *
 * For example, given 156, you should return 3. Created 4-Nov-2019 on 12:14:51
 * PM
 *
 * @author B. Cutten
 */
public class DailyProblem214 {

    public static void main(String[] args) {
        int n = 156;
        String binary = convertBase10to2(n);
        int run = countLength(binary);
        System.out.println(run);
    }

    /**
     * This method converts a base 10 number into a base 2 number
     *
     * @param n - the base 10 number
     * @return the base 2 number as a String
     */
    private static String convertBase10to2(int n) {
        String base2 = "";
        //once we reach zero we're done
        while (n > 0) {
            //divide by 2 and check the remainder
            //the result is the most significant bit
            if (n % 2 == 1) {
                base2 = "1" + base2;
            } else {
                base2 = "0" + base2;
            }
            //get rid of this number column
            n /= 2;
        }
        return base2;
    }

    /**
     * This method finds the longest run of 1's in the binary number
     * @param binary - the binary number as a String
     * @return - an int representing the longest run of 1's in the number
     */
    private static int countLength(String binary) {
        int count = 0;
        int maxCount = -1;
        //look at each bit, from left to right
        for (int i = 0; i < binary.length(); i++) {
            //is it a 1?
            if(binary.charAt(i) == '1'){
                count++; //add on to the length of the current run
                //is the current run the longest found?
                if(count > maxCount){
                    maxCount = count;
                }
            }else{
                //not a 1 so reset the length of the current run
                count = 0;
            }
        }
        return maxCount;
    }

}
