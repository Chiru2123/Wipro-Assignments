import java.util.*;
import java.util.stream.Collectors;

public class PrettyJoiner {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Delhi", "Hyderabad", "Nagpur", "Kolkata");

        String result = cities.stream()
                              .collect(Collectors.joining(", "));

        System.out.println("Cities: " + result);
    }
}
