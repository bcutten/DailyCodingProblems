/**
 * This problem was asked by Palantir.
 * Write a program that checks whether an integer is a palindrome. 
 * For example, 121 is a palindrome, as well as 888. 678 is not a palindrome. 
 * Do not convert the integer into a string.
 * Created 22-Oct-2019 on 2:27:59 PM
 * @author B. Cutten
 */
package dailycodingproblem202;

public class DailyCodingProblem202 {

   
    public static void main(String[] args) {
        int num = 8008;
        System.out.println(isPal(num));
    }

    private static boolean isPal(int num) {
        if(num < 10){ 
            return true; // a one digit number is a palindrome
        }else{
            //compare the first and last digits in the number
            int first =  getFirstDigit(num);
            int last = num % 10;
            if (first != last){ //if they're different than it's not a palindrome
                return false;
            }else{
                //the digits were the same, so it might be a palindrome
                //remove them and check again
                num = removeFirstAndLast(num);
                return isPal(num);
            }
        }
    }

    private static int getFirstDigit(int num) {
        //keep dividing by 10 until it's a 1 digit number
        while(num > 10){
            num = num / 10;
        }
        return num;
    }

    private static int removeFirstAndLast(int num) {
        //determine the size of the number (i.e. the largest number column it occupies)
        int first = num;
        int numZeros = 0;
        //count how many times we remove a number column until we get to the ones column
        while(first > 10){
            first = first / 10;
            numZeros++;
        }
        //now remove that number column
        num = num - (int)(first * Math.pow(10, numZeros));
        //now just remove the ones column
        num = num /10;
        return num;
    }

}
