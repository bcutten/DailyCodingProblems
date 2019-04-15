/*
 * This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, 
and calls f after n milliseconds.
 */

package dailyproblem10;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

/**
 * Created 15-Apr-2019 on 11:44:46 AM
 * @author B. Cutten
 * Help from https://codereview.stackexchange.com/questions/186972/passing-a-generic-function-as-parameter
 * and https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
 */
public class DailyProblem10 {

   
    public static void main(String[] args) {
        //try out the scheduler with the test methods
        schedule(DailyProblem10::test1, 2000);
        schedule(DailyProblem10::test2, 4000);
        schedule(DailyProblem10::test3, 1000);
        
    }
    
       
    //the problem description doesn't mention parameters or return types, so I
    //just assumed the function accepted an Integer and has no return
    //this is probably a horrible solution
    /*
        Use Predicate when you have a boolean return type with arguments
        Use Supplier when you have a return type
        Use Consumer when you have an argument
        Use Function when you have both an argument and a return value
    */
    public static void schedule(Consumer<Integer> c, int n){
        //use a timer
        Timer t = new Timer();
        //run the function after n milliseconds
        t.schedule(new TimerTask() {
            @Override
            public void run() {
              c.accept(0);
            }
          }, n);
        
    }
    
    //define some test methods    
    public static void test1(Integer i){
        System.out.println("Test 1");
    }
    
    public static void test2(Integer i){
        System.out.println("Test 2");
    }
    
    public static void test3(Integer i){
        System.out.println("Test 3");
    }
    

}
