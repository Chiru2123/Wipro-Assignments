import java.util.*;

public class ParallelSquarePrinter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        numbers.parallelStream()
               .forEach(n -> System.out.println("Square of " + n + " = " + (n * n)));
    }
}
