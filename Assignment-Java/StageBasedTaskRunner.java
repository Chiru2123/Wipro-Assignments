import java.util.concurrent.*;

class Task {
    int id;
    String name;

    Task(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class StageBasedTaskRunner {
    public static void main(String[] args) {
        LinkedBlockingQueue<Task> stage1 = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Task> stage2 = new LinkedBlockingQueue<>();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Task task = new Task(i, "Task-" + i);
                    stage1.put(task);
                    System.out.println("Added to Stage 1: " + task.name);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread processor = new Thread(() -> {
            try {
                while (true) {
                    Task task = stage1.take();
                    System.out.println("Processing in Stage 1: " + task.name);
                    if (task.id % 2 == 0) {
                        stage2.put(task);
                        System.out.println("Moved to Stage 2: " + task.name);
                    } else {
                        System.out.println("Discarded: " + task.name);
                    }
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        processor.start();
    }
}

