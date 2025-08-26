import java.util.*;

class Patient {
    String name;
    int severity;
    long timestamp;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
        this.timestamp = System.nanoTime();
    }
}

public class EmergencyPatientTracker {
    public static void main(String[] args) {
        Comparator<Patient> comparator = (a, b) -> {
            if (a.severity != b.severity) return Integer.compare(a.severity, b.severity);
            return Long.compare(a.timestamp, b.timestamp);
        };

        PriorityQueue<Patient> queue = new PriorityQueue<>(5, comparator);

        addPatient(queue, new Patient("Arun", 3));
        addPatient(queue, new Patient("Bhanu", 2));
        addPatient(queue, new Patient("Charitha", 2));
        addPatient(queue, new Patient("Dinesh", 1));
        addPatient(queue, new Patient("Eshwar", 4));
        addPatient(queue, new Patient("Fathima", 1)); // will not be added

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println("Treating: " + p.name + " (Severity: " + p.severity + ")");
        }
    }

    static void addPatient(PriorityQueue<Patient> queue, Patient patient) {
        if (queue.size() < 5) {
            queue.offer(patient);
        } else {
            System.out.println("Queue full, cannot add: " + patient.name);
        }
    }
}

