package ogame.utils;

public class StringFactory {

    /**
     * PL
     * Tworzy zmienną o określonej długości.
     * EN
     * Creates variable with maxLength limit.
     * @param variable ***
     * @param maxLength Długość zmiennej.
     * @return New variable.
     */
    public static String init(String variable, int maxLength)
    {
        if(maxLength < variable.length())
            return "too tiny maxLength.";

        String s;
        if(variable == null)
           s = String.format("%-"+maxLength+"s","null");
        else
            s = String.format("%-"+maxLength+"s",variable);
        return s;
    }
    /**
     * PL
     * Sprawdza czy tekst zawiera tylko z liter lub cyfr.
     * EN
     * Checks the string contains only letters and digits
     * @param text *
     * @return True if string contains only letters and digits.
     */
    public static boolean isAlphanumeric(String text) {
        for (int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            if (!Character.isLetterOrDigit(c))
                return false;
        }
        return true;
    }
    /**
     * PL
     * Sprawdza czy tekst zawiera tylko z liter lub cyfr.
     * EN
     * Checks the string contains only letters and digits
     * @param text *
     * @return True if string contains only letters and digits.
     */
    public static boolean isDigit(String text) {
        try{
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException ignored) {

        }
        return false;
    }
    /**
     * Deletes all chars inside text.
     * @param ch Char wchich will delete.
     * @param word Text.
     * @return Edited text.
     */
    public static String deleteChars(char ch, String word) {
        char [] chars = word.toCharArray();
        StringBuilder s = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != ch)
                s.append(aChar);
        }
        return s.toString();
    }

    public static boolean  containsWhiteSpace(String s){
        return s.contains(" ");
    }

    /**
     * Example: 1000000 -> 1.000.000
     * @param digit *
     * @return Formatted digit.
     */
    public static String digitFormattedWithDots(long digit){
        StringBuilder s = new StringBuilder(String.valueOf(digit));
        int a = s.length();
        StringBuilder tmp = new StringBuilder();
        if(a%3 == 2 && a > 3) {
            for(int i = 0; i < a; i++) {
                tmp.append(s.charAt(i));
                if(i%3 == 1 && i != a-1)
                    tmp.append(".");
            }
        }
        else if(a%3 == 1 && a > 3) {
            for(int i = 0; i < a; i++) {
                tmp.append(s.charAt(i));
                if(i%3 == 0 && i != a-1)
                    tmp.append(".");
            }
        }
        else if(a%3 == 0 && a > 3) {
            for(int i = 0; i < a; i++) {
                tmp.append(s.charAt(i));
                if(i%3 == 2 && i != a-1)
                    tmp.append(".");
            }
        }
        else
            tmp = new StringBuilder(String.valueOf(digit));
        return tmp.toString();
    }
    /**
     * Example: 1000000 -> 1 000 000
     * @param digit *
     * @return Formatted digit.
     */
    public static String digitFormattedWithSpace(long digit){
        StringBuilder s = new StringBuilder(String.valueOf(digit));
        int a = s.length();
        StringBuilder tmp = new StringBuilder();
        if(a%3 == 2 && a > 3) {
            for(int i = 0; i < a; i++) {
                tmp.append(s.charAt(i));
                if(i%3 == 1 && i != a-1)
                    tmp.append(" ");
            }
        }
        else if(a%3 == 1 && a > 3) {
            for(int i = 0; i < a; i++) {
                tmp.append(s.charAt(i));
                if(i%3 == 0 && i != a-1)
                    tmp.append(" ");
            }
        }
        else if(a%3 == 0 && a > 3) {
            for(int i = 0; i < a; i++) {
                tmp.append(s.charAt(i));
                if(i%3 == 2 && i != a-1)
                    tmp.append(" ");
            }
        }
        else
            tmp = new StringBuilder(String.valueOf(digit));
        return tmp.toString();
    }
//    /**
//     * Formats digit to thousand format. [1000] -> [1.000]
//     * @param digit Digit
//     * @return Digit in format.
//     */
//    public static String thousandSeparator(String digit) {
//        DecimalFormat  decimalFormat = new DecimalFormat("#,###");
//
//        return decimalFormat.format(Integer.parseInt(digit));
//    }
//
//    /**
//     * Formats digit to thousand format. [1000] -> [1.000]
//     * @param digit Digit
//     * @return Digit in format.
//     */
//    public static String thousandSeparator(double digit) {
//        DecimalFormat  decimalFormat = new DecimalFormat("#,###.");
//
//        return decimalFormat.format(digit);
//    }
//
//    /**
//     * Formats digit to thousand format. [1000] -> [1.000]
//     * @param digit Digit
//     * @return Digit in format.
//     */
//    public static String thousandSeparator(int digit) {
//        DecimalFormat  decimalFormat = new DecimalFormat("#,###.");
//
//        return decimalFormat.format(digit);
//    }

    /**
     * Checks  text to see if it contains a string.
     * @param s checked text.
     * @param containedString String which has to text contains.
     * @return Return true if text contains a string.
     */
    public static boolean isTextContains(String s, String containedString){
        return s.contains(containedString);
    }

    /**
     * Checks  text to see if it contains a string.
     * @param s checked text.
     * @param containedStrings An array of strings that may contain text.
     * @return Return true if text contains a string.
     */
    public static boolean isTextContains(String s, String [] containedStrings){
        for(String tmp : containedStrings){
            if(s.contains(tmp))
                return true;
        }
        return false;
    }
}
