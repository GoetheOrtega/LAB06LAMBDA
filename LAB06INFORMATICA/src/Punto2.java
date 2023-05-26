import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Punto2 {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList(
                "Lorem ipsum dolor sit amet",
                "Consectetur adipiscing elit",
                "Sed do eiusmod tempor incididunt",
                "Labore et dolore magna aliqua",
                "Ut enim ad minim veniam");

        analyzeLines(lines);
    }

    public static void analyzeLines(List<String> lines) {
        // a)
        Predicate<String> fiveLetterPredicate = word -> word.length() == 5;
        int numberOfFiveLetterWords = countWords(lines, fiveLetterPredicate);
        System.out.println("Number of five-letter words: " + numberOfFiveLetterWords);

        // b)
        Predicate<String> palindromePredicate = Punto2::isPalindrome;
        int numberOfPalindromes = countWords(lines, palindromePredicate);
        System.out.println("Number of palindromes: " + numberOfPalindromes);

        // c)
        Predicate<String> letterWPredicate = word -> word.contains("W");
        List<String> wordsWithLetterW = getWords(lines, letterWPredicate);
        System.out.println("Words with the letter 'W': " + wordsWithLetterW);
    }

    public static int countWords(List<String> lines, Predicate<String> predicate) {
        int count = 0;
        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (predicate.test(word)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static List<String> getWords(List<String> lines, Predicate<String> predicate) {
        List<String> foundWords = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (predicate.test(word)) {
                    foundWords.add(word);
                }
            }
        }
        return foundWords;
    }

    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
