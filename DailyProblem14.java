/*
 * This problem was asked by Google.

    The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

    Hint: The basic equation of a circle is x2 + y2 = r2.
 */

package dailyproblem14;

import java.util.Random;

/**
 * 
 * Created 17-Apr-2019 on 1:35:31 PM
 * @author B. Cutten
 * Special thanks to https://www.geeksforgeeks.org/estimating-value-pi-using-monte-carlo/
 * "The idea is to simulate random (x, y) points in a 2-D plane with domain as a 
 * square of side 1 unit. Imagine a circle inside the same domain with same diameter 
 * and inscribed into the square. We then calculate the ratio of number points that 
 * lied inside the circle and total number of generated points." 
 */
public class DailyProblem14 {

   
    public static void main(String[] args) {
        //TIL about the Monte Carlo method
        //Pi esitmate = 4 * (pointsInCircle / pointsInSquare)
        //keep generating points until we're within 0.001 of PI
        double x;
        double y;
        double guessPi = 0;
        double distance = 1;
        double numInSquare = 0;
        double numInCircle = 0;
        Random r = new Random();
        while(distance > 0.001){
            //generate an xy coordinate
            //within -1 to 1
            x = r.nextDouble() * 2 - 1;
            y = r.nextDouble() * 2 - 1;
            //check if it lies within the circle
            //uses x^2 + y^2 = r^2     
            if((x*x + y*y) <= 1){
                numInCircle++;
            }
            numInSquare++; //all points are within the square
            
            //make an estimate for PI
            guessPi = 4 * (numInCircle/numInSquare);            
            //see how close we are to being correct
            distance = Math.abs(guessPi - Math.PI);
        }
        //print accurate to three decimal places
        System.out.println(Math.round(guessPi*1000)/1000.0);
    }

}
