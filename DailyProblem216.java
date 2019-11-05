package dailyproblem216;

/**
 * This problem was asked by Facebook.
 *
 * Given a number in Roman numeral format, convert it to decimal.
 *
 * The values of Roman numerals are as follows:
 *
 * {
 * 'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1 } In
 * addition, note that the Roman numeral system uses subtractive notation for
 * numbers such as IV and XL.
 *
 * For the input XIV, for instance, you should return 14. Created 5-Nov-2019 on
 * 12:32:35 PM
 *
 * @author B. Cutten
 */
public class DailyProblem216 {

    public static void main(String[] args) {
        String roman = "XIV";
        int d = convertRoman(roman);
        System.out.println(d);
    }

    /**
     * Method to convert from a Roman Numeral into Decimal
     *
     * @param roman - the Roman numeral as a String
     * @return - an int representing the decimal value
     */
    private static int convertRoman(String roman) {
        int d = 0; //the total value in decimal
        char c;
        //loop through each character
        for (int i = 0; i < roman.length(); i++) {
            c = roman.charAt(i);
            //check if there is a next character after this one
            if (i + 1 < roman.length()) {
                //check if the next character is smaller, if so just add the value
                if (getDigitValue(c) >= getDigitValue(roman.charAt(i + 1))) {
                    d += getDigitValue(c);
                } else { //the next value is bigger, meaning we need to subtract this value from the next value
                    d += -getDigitValue(c) + getDigitValue(roman.charAt(i + 1));
                    i++; //skip the next digit since we already counted it
                }
            } else { //this is the last character so just add it to the total
                d += getDigitValue(c);
            }
        }
        return d;
    }

    /**
     * Method to convert a single Roman digit to it's decimal equivalent The
     * values of Roman numerals are as follows:
     *
     * {
     * 'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1 
     *
     * @param romanDigit - the Roman digit to convert
     * @return - an int representing the decimal value
     */
    private static int getDigitValue(char romanDigit) {
        if (romanDigit == 'I') {
            return 1;
        } else if (romanDigit == 'V') {
            return 5;
        } else if (romanDigit == 'X') {
            return 10;
        } else if (romanDigit == 'C') {
            return 50;
        } else if (romanDigit == 'L') {
            return 100;
        } else if (romanDigit == 'D') {
            return 500;
        } else if (romanDigit == 'M') {
            return 1000;
        } else {
            return -1000000;
        }
    }

}
