
package dailyproblem211;

import java.util.ArrayList;

/**
 * This problem was asked by Microsoft.

 * Given a string and a pattern, find the starting indices of all occurrences 
 * of the pattern in the string. For example, given the string "abracadabra" 
 * and the pattern "abr", you should return [0, 7]. 
 * Created 31-Oct-2019 on 1:10:57 PM
 * @author B. Cutten
 */
public class DailyProblem211 {

   
    public static void main(String[] args) {
        ArrayList<Integer> occurrences = findOccurrences("abracadabra", "abr");
        System.out.println(occurrences);
    }

    private static ArrayList<Integer> findOccurrences(String s, String pattern) {
        int sLen = s.length();
        int pLen = pattern.length();
        ArrayList<Integer> list = new ArrayList();
        boolean found;
        //loop through each char in the String
        //stop when we're at the length of the pattern from the end
        for (int i = 0; i < (sLen - pLen); i++) {
            found = true; //assume the pattern is located at this index
            //test our hypothesis by comparing each char in the orginal String
            //to the char in the pattern
            for (int j = 0; j < pLen; j++) {
                //if they don't match then the pattern isn't found
                if(s.charAt(i + j) != pattern.charAt(j)){
                    found = false;
                    j = pLen;//stop looking
                }
            }
            //if we found the pattern then add the index to the list
            if(found){
                list.add(i);
            }
            
        }
        return list;
    }

}
