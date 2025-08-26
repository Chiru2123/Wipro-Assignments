public class GreetingsPrinter {
    public static void main(String[] args) {
        MessagePrinter printer = message -> System.out.println("Greeting: " + message);
        greetUser("Welcome to Wipro!", printer);
    }

    @FunctionalInterface
    interface MessagePrinter {
        void print(String message);
    }

    public static void greetUser(String message, MessagePrinter printer) {
        printer.print(message);
    }
}

