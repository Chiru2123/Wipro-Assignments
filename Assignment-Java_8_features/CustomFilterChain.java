import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomFilterChain {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anita", "Amelia", "Arun", "Sita", "Ramya", "Asha", "Rama");

        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> endsWithA = name -> name.endsWith("a");

        List<String> filteredNames = names.stream()
            .filter(startsWithA.and(endsWithA))
            .collect(Collectors.toList());

        System.out.println(filteredNames);
    }
}
