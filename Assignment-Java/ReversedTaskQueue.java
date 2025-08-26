import java.util.LinkedList;
import java.util.Scanner;

public class ReversedTaskQueue {
    public static void main(String[] args) {
        LinkedList<String> tasks = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 4 tasks:");

        for (int i = 0; i < 4; i++) {
            String task = scanner.nextLine();
            if (task.endsWith("!")) {
                tasks.addFirst(task);
            } else {
                tasks.addLast(task);
            }
        }

        System.out.println("Reversed Task List:");
        for (int i = tasks.size() - 1; i >= 0; i--) {
            System.out.println(tasks.get(i));
        }

        scanner.close();
    }
}

