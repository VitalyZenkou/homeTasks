package collections.second.textApp;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class TextUtil {

    private static final char[] regEx = {',', '.', '-', '!', '?', ':', ';'};

    private TextUtil() {
    }

    public static void countUniqueWords(Text text) {
        TreeMap<String, Integer> uniqueWords = new TreeMap<>();
        Arrays.asList(text.getText().split(" ")).forEach(word -> {
            word = cleanWord(word);
            if (uniqueWords.isEmpty()) {
                uniqueWords.put(word, 1);
            } else {
                if (uniqueWords.containsKey(word)) {
                    int amount = uniqueWords.get(word);
                    amount++;
                    uniqueWords.put(word, amount);
                } else {
                    uniqueWords.put(word, 1);
                }
            }
        });
        print(uniqueWords);
    }

    private static String cleanWord(String word) {
        StringBuilder cleanedWord = new StringBuilder(word);
        for (char ch : regEx) {
            if (word.charAt(word.length() - 1) == ch) {
                cleanedWord = new StringBuilder();
                for (int j = 0; j < word.length() - 1; j++) {
                    cleanedWord.append(Character.toString(word.charAt(j)));
                }
            }
        }
        return cleanedWord.toString();
    }

    private static void print(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
