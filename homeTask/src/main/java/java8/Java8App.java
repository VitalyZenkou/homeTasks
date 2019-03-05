package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Java8App {

    private static List<String> words = Arrays.asList("Wasasasa","WWWWWW","RRRqqawqwqwASSASA");
    private static Stream<String> stream = Stream.of("Piere","Piere","Vasia","Gena");

    public static void main(String[] args) {
        Optional<String> optional = Java8Util.getMaxString(words);
        optional.ifPresent(System.out::println);
        System.out.println(Java8Util.getWordsAmount(stream));
    }
}
