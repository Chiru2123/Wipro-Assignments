import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LimitedChatHistory {
    public static void main(String[] args) {
        Deque<String> chat = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            String message = scanner.nextLine();
            if (chat.size() == 4) {
                chat.removeFirst();
            }
            chat.addLast(message);
        }

        for (String msg : chat) {
            System.out.println(msg);
        }

        scanner.close();
    }
}

