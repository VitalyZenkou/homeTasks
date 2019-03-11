package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Util {

    private Java8Util() {
    }

    public static Optional<String> getMaxString(List<String> words) {
        return words.stream().max(Comparator.comparingInt(word -> word.replaceAll("[A-Z]", "").length()));
    }

    public static Map<String, Integer> getWordsAmount(Stream<String> words) {
        return words.collect(Collectors.toMap(word -> word, word -> 1, (a, b) -> a + b));
    }
}
