import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GroceryLineShuffle {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String name = scanner.nextLine();
            if (name.length() % 2 == 0) {
                queue.addFirst(name);
            } else {
                queue.addLast(name);
            }
        }

        for (String customer : queue) {
            System.out.println(customer);
        }

        scanner.close();
    }
}
