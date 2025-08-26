import java.util.*;

public class NameSorter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Akki", "Anu", "Ram", "Rashmitha", "Geetanjali");
        names.sort((name1, name2) -> name1.compareTo(name2));
        names.forEach(System.out::println);
    }
}
