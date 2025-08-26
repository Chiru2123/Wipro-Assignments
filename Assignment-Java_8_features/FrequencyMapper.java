import java.util.*;
import java.util.stream.Collectors;

public class FrequencyMapper {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "David", "Bob", "Alice");

        Map<String, Long> nameCountMap = names.stream()
            .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        System.out.println(nameCountMap);
    }
}
