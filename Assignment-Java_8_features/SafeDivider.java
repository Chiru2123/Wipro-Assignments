import java.util.Optional;

public class SafeDivider {
    public static void main(String[] args) {
        Optional<Integer> result = divide(10, 0);
        System.out.println(result.map(String::valueOf).orElse("Not Allowed"));
    }

    public static Optional<Integer> divide(int a, int b) {
        if (b == 0) {
            return Optional.empty();
        }
        return Optional.of(a / b);
    }
}
