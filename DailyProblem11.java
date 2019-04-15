/*
 * This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of 
all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], 
return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to 
speed up queries.
 */

package dailyproblem11;

import java.util.ArrayList;

/**
 * 
 * Created 15-Apr-2019 on 8:46:00 AM
 * @author B. Cutten
 */
public class DailyProblem11 {

   
    public static void main(String[] args) {
        String prefix = "de";
        ArrayList<String> words = new ArrayList();
        words.add("dog");
        words.add("deer");
        words.add("deal");
        System.out.println(autoComplete(prefix, words));
    }
    /**
     * An autocomplete system. Given a query string s and a set of 
     * all possible query strings, return all strings in the set that have s as a prefix.
     * @param s - the prefix to look for
     * @param words - the set of words
     * @return - a new list with the matching words
     */
    public static ArrayList<String> autoComplete(String s, ArrayList<String> words){
        ArrayList<String> matches = new ArrayList();
        //loop through the set of possible words
        for (int i = 0; i < words.size(); i++) {
            //check if the current word starts with the desired prefix
            if(words.get(i).startsWith(s)){
                //add it to the new list
                matches.add(words.get(i));
            }
        }
        return matches;
    }

}
