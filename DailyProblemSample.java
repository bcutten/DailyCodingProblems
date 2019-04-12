/*
 * There's a staircase with N steps, and you can climb 1 or 2 steps at a time. 
Given N, write a function that returns the number of unique ways you can climb 
the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, 
you could climb any number from a set of positive integers X? 
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. 
Generalize your function to take in X.
 */

package dailyproblemsample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created 10-Apr-2019 on 3:12:43 PM
 * Finished April 12th
 * @author B. Cutten
 */
public class DailyProblemSample {

   
    public static void main(String[] args) {
        System.out.println(countWays(4)); 
        //general solution...appears to work
        ArrayList<Integer> x = new ArrayList();
        x.add(1);
        x.add(2);  
        x.add(3);
        System.out.println(countWaysQ(4,x));
        
    }
    
    //generalized solution 
    //this method worked the first time I ran it!!!!!! (after thinking about it overnight)
    //based on this pseudo code:
    //use queue and while loop
        //for each x
            //subtract from N and add to q if >=0
                //count the zeros
    public static int countWaysQ(int n, ArrayList<Integer> x){
        Queue<Integer> q = new LinkedList();
        int ways = 0;
        int step;
        q.add(n); //start by adding our original number of steps to the q
        while(!q.isEmpty()){
            step = q.poll(); //remove the front element
            if(step == 0){ //did we make it to the top of the stairs?
                ways++;
            }else{ //go up x number of steps
                for (Integer size : x) { //gettin fancy with the for loop
                    if(step - size >= 0){ //is this step possible?
                        q.add(step - size);
                    }
                }
            }
        }
        return ways;
    }
    
    
    
    //attempt at generalizing the recursive method...
    //unsuccessful :(
    /*
    public static int countWays(int n, ArrayList<Integer> x){
        System.out.println(n + "    " + x);
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 1;
        }else{
            System.out.println("Recursive call");
            int sum = 0;
            int step;
            for (int i = 0; i < x.size(); i++) {
                
                step = x.remove(0);
                System.out.println("Step:" + step);
                sum += countWays(n-step, new ArrayList(x));
            }
            return sum;
        }
    }
    */
    
   //specific recursive solution to the base problem   
   public static int countWays(int n){       
        if(n < 0){  //a negative value means this sequence is not possible
            return 0;
        }else if(n == 0){ //zero means we reached the end of steps exactly
            return 1;
        }else{ //any other positive number means we need to continue going up the steps             
            return countWays(n - 1) + countWays(n - 2);
        }
    }

}
