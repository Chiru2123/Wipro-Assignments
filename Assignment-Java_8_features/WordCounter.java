import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anushka", "Ravi", "Geetanjali", "Mohan", "Sita");

        long count = names.stream()
                          .filter(name -> name.length() > 5)
                          .count();

        System.out.println("Names longer than 5 characters: " + count);
    }
}
