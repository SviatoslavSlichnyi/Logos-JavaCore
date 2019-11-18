package homework.ls_10_Strings;

public class StringTools {

    public static final String loud = "AaEeIiOoUu";

    public static boolean isPalindrome(String word) {

        if(word.length() != 5) {
            throw new IllegalArgumentException("passed word must have 5 length");
        }

        StringBuffer wordBuff = new StringBuffer(word);
        String reversedWord =  wordBuff.reverse().toString();

        return word.equalsIgnoreCase(reversedWord);
    }

    public static String replaceLoud(String str) {

        StringBuffer alphas = new StringBuffer(str);

        for(int i = 0, n = alphas.length(); i < n; ++i) {
            char alpha = alphas.charAt(i);
            if(loud.contains(String.valueOf(alpha))) {
                alphas.replace(i, i+1, "-");
            }
        }

        return alphas.toString();
    }

}
