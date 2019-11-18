package homework.ls_10_Strings;

import java.util.HashMap;
import java.util.Map;

public class TextTools {

    public static String findPopular(String text) {

        String sentenceSeparators = "\\s*(=>|,|\\s)\\s*";
        String[] words = text.split(sentenceSeparators);

        Map<String, Integer> counter = frequencyWords(words);

        String popular = findPopularInMap(counter);

        return popular;
    }

    private static HashMap<String, Integer> frequencyWords(String[] words) {

        HashMap<String, Integer> counter = new HashMap<>();

        for(String w: words) {
            if(!counter.containsKey(w)) {
                counter.put(w, 1);
            } else {
                int currSize = counter.get(w);
                currSize++;
                counter.put(w, currSize);
            }
        }

        return counter;
    }

    private static String findPopularInMap(Map<String, Integer> counter) {

        String popular = "";
        int max = 1;

        for(String w: counter.keySet()) {
            int amount = counter.get(w);
            if(amount > max) {
                max = amount;
                popular = w;
            }
        }

        return popular;
    }

}
