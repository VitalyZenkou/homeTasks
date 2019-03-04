package io.util;

import exception.FileException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IOUtil {

    private static final String VERSE_FILE = "verse.txt";
    private static final String DEFAULT_NUMBER_FILE = "defaultNumberFiler.txt";
    private static final String SORTED_NUMBER_FILE = "sortedNumberFiler.txt";
    private static final String PATH = "homeTask\\src\\main\\resources\\";
    private static final String VERSE_REG_EX = "[а-я]";
    private static final int DEFAULT = 1;
    private static File defaultFile;
    private static File sortedFile;

    private IOUtil() {
    }

    public static void findAmountLetters() {
        try (BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(Paths.get(PATH, VERSE_FILE)))) {
            Map<Character, Integer> letters = new TreeMap<>();
            String verse = bufferedReader.lines().collect(Collectors.joining()).toLowerCase();
            for (int i = 0; i < verse.length(); i++) {
                char c = verse.charAt(i);
                if (isLetter(Character.toString(c))) {
                    if (!letters.containsKey(c)) {
                        letters.put(verse.charAt(i), DEFAULT);
                    } else {
                        int amount = letters.get(c);
                        letters.put(c, ++amount);
                    }
                }
            }
            printMap(letters);
        } catch (IOException e) {
            throw new FileException(String.format("File %s not found!", VERSE_FILE));
        }
    }

    public static void sortNumberFromFile(int capacity) {
        sortedFile = createFile(PATH, SORTED_NUMBER_FILE);
        fillFileRandomNumbers(capacity);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(sortedFile));
             BufferedReader reader = new BufferedReader(Files.newBufferedReader(Paths.get(defaultFile.getAbsolutePath())))) {
            List<String> lines = reader.lines().collect(Collectors.toList());
            List<Integer> numbers = new ArrayList<>();
            for (String line : lines) {
                numbers.add(Integer.parseInt(line));
            }
            Collections.sort(numbers);
            for (Integer i : numbers) {
                writer.printf(String.format("%d\n", i));
            }
        } catch (IOException e) {
            throw new FileException("Files not found!");
        }
    }

    private static void fillFileRandomNumbers(int capacity) {
        defaultFile = createFile(PATH, DEFAULT_NUMBER_FILE);
        Random random = new Random();
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(defaultFile))) {
            for (int i = 0; i < capacity; i++) {
                writer.printf("%d\n", random.nextInt(Integer.MAX_VALUE));
            }
        } catch (IOException e) {
            throw new FileException(String.format("The file %s doesn't exist", defaultFile.getAbsolutePath()));
        }
    }

    private static boolean isLetter(String letter) {
        Pattern pattern = Pattern.compile(VERSE_REG_EX);
        Matcher matcher = pattern.matcher(letter);
        return matcher.matches();
    }

    private static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(String.format("Letter[%s]-[%s]", entry.getKey().toString(), entry.getValue().toString()));
        }
    }

    private static File createFile(String path, String name) {
        File file;
        try {
            file = new File(path, name);
            file.createNewFile();
            return file;
        } catch (IOException e) {
            throw new FileException(String.format("File %s wasn't created!", name));
        }
    }
}
