import java.util.Stack;

public class UndoStack {
    public static void main(String[] args) {
        Stack<String> commandStack = new Stack<>();

        commandStack.push("Open");
        commandStack.push("Edit");
        commandStack.push("Save");

        String undone = commandStack.pop();
        String reversed = new StringBuilder(undone).reverse().toString();

        commandStack.push(reversed);

        for (String command : commandStack) {
            System.out.println(command);
        }
    }
}
