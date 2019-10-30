
package dailyproblem61;



/**
 * This problem was asked by Google.

 * Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

 * Do this faster than the naive method of repeated multiplication.

 * For example, pow(2, 10) should return 1024.
 * Created 30-Oct-2019
 * on 1:30:22 PM
 *
 * @author B. Cutten
 */
public class DailyProblem61 {

   
    public static void main(String[] args) {
        System.out.println(pow(2,10));
    }

   
    /**
     * A power method, uses "Exponentiation by squaring" observation rather than repeated multiplication
     * Thanks to: https://eli.thegreenplace.net/2009/03/21/efficient-integer-exponentiation-algorithms
     * @param b - the base
     * @param e - the exponent
     * @return the result of raising the base to the exponent
     */
    private static int pow(int b, int e) {
        //base case, anything raised to the power of zero is one
        if(e == 0){
            return 1;
        }else if(e % 2 == 1){ //an odd exponent 
            return b * pow(b, e - 1); //recursive call so it's even next time
        }else{
            //remember when you learned that b^e = b^e/2 * b^e/2?
            int squarePower = pow(b, e / 2); 
            return squarePower * squarePower;
        }
    }

}
