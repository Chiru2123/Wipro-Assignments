import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Queue;

public class PrintManager {
    public static void main(String[] args) {
        Queue<String> printQueue = new ArrayBlockingQueue<>(3);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String job = scanner.nextLine();
            boolean added = printQueue.offer(job);
            if (!added) {
                System.out.println("Skipped: " + job);
            }
        }

        while (!printQueue.isEmpty()) {
            System.out.println("Printing: " + printQueue.poll());
        }

        scanner.close();
    }
}

