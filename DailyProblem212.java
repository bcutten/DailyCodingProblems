
package dailyproblem212;

/**
 * This problem was asked by Dropbox.

 * Spreadsheets often use this alphabetical encoding for its columns:
 * "A", "B", "C", ..., "AA", "AB", ..., "ZZ", "AAA", "AAB", ....
 * "Z" = 26, AZ = 52, BA = 53, BB = 78, BC = 104, 
 * AZ = (1 * 26) + 26 = 52
 * BA = (2 * 26) + 1  = 53
 * BB = (2 * 26) + 2  = 54
 * BC = (2 * 26) + 3  = 55
 * BZ = (2 * 26) + 26 = 78
 * 
 * CA = (3 * 26) + 1  = 79
 * 
 * ZZ = (26 * 26) + 26 = 702
 * ZZZ = (26 * 26 * 26) + (26 * 26) + 26 = (18278)
 * 
 * Given a column number, return its alphabetical column id. 
 * For example, given 1, return "A". Given 27, return "AA".
 * Created 1-Nov-2019 on 12:15:52 PM
 * @author B. Cutten
 */
public class DailyProblem212 {

   
    public static void main(String[] args) {
        int colNum = 18278;
        String alphaID = "";
        int letterNum;
        char letter;
        //we're done when the column number is zero
        while(colNum > 0){
            //determine the rightmost letter value
            //divide by 26 and see what's left over
            //1 = A, 2 = B... 25 = Y, 0 = Z
            letterNum = colNum % 26;
            if(letterNum == 0){ //Z is the special case
                letter = 'Z';
                colNum--; //decrement the value so that we reach zero eventually
            }else{
                //use the ASCII values to determine which letter to add
                //add 64 (difference between 1 and 65)
                letter = (char)(letterNum + 64);
            }
            //add this letter to the output, right to left
            alphaID = letter + alphaID;
            //remove this "number column" from the original value
            colNum /= 26;          
        }
        System.out.println(alphaID);
    }

}
