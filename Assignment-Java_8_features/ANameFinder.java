import java.util.*;
import java.util.stream.*;

public class ANameFinder {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anu", "Bhanu", "Charitha", "Shyam", "Arjun");

        List<String> aNames = names.stream()
                                   .filter(name -> name.startsWith("A"))
                                   .collect(Collectors.toList());

        aNames.forEach(System.out::println);
    }
}
