import java.util.concurrent.LinkedBlockingQueue;

public class ChatProcessor {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> buffer = new LinkedBlockingQueue<>(5);

        Thread writer = new Thread(() -> {
            int count = 1;
            try {
                while (count <= 10) {
                    buffer.put("Message " + count);
                    System.out.println("Added: Message " + count);
                    count++;
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread reader = new Thread(() -> {
            try {
                while (true) {
                    String msg = buffer.take();
                    System.out.println("Read: " + msg);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        writer.start();
        reader.start();
    }
}

