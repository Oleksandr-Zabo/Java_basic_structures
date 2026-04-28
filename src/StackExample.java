import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackExample {
    public static void run() {
        System.out.println("\n-- Stack Example --");
        // Preferred: Deque as a stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack top: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }

        // Legacy Stack
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        System.out.println("Legacy Stack pop: " + s.pop());
    }
}

