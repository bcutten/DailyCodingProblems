/*
 * This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */

package dailyproblem7;

/**
 * Created 10-Apr-2019 on 12:33:27 PM
 * @author B. Cutten
 */
public class DailyProblem7 {

   
    public static void main(String[] args) {
        System.out.println("Number of ways = " + count("12121"));
    }

    
    public static int count(String msg){        
        if(msg.length() <= 1){            
            //if the msg is only length 1 or 0 then it can only be decoded one way
            return 1;
        }else {
            //the message has at least two digits, so check if they can represent two 
            //different characters
            if((msg.charAt(0) == '2' || msg.charAt(0) == '1') && (msg.charAt(1) >= 48 && msg.charAt(1) <= 54)){
                //two ways to decode this message
                return count(msg.substring(1)) + count(msg.substring(2));
            }else{
                //only one way to decode this message
                return count(msg.substring(1));
            }
            
        }
    }
    
    
}
