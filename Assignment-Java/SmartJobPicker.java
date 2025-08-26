import java.util.PriorityQueue;
import java.util.Scanner;

class Job {
    String name;
    int urgency;

    Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    public String toString() {
        return name + " (" + urgency + ")";
    }
}

public class SmartJobPicker {
    public static void main(String[] args) {
        PriorityQueue<Job> jobs = new PriorityQueue<>((a, b) -> {
            if (a.urgency != b.urgency) {
                return Integer.compare(a.urgency, b.urgency);
            } else {
                return Integer.compare(a.name.length(), b.name.length());
            }
        });

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String name = scanner.next();
            int urgency = scanner.nextInt();
            jobs.offer(new Job(name, urgency));
        }

        while (!jobs.isEmpty()) {
            System.out.println(jobs.poll());
        }

        scanner.close();
    }
}

