import java.util.*;

public class MethodReferenceSorter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Zara", "Mohan", "Amit", "John", "Bella");

        Collections.sort(names, String::compareTo);

        System.out.println(names);
    }
}
