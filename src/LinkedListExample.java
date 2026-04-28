import java.util.LinkedList;

public class LinkedListExample {
    public static void run() {
        System.out.println("\n-- LinkedList Example --");
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.addFirst(5);
        ll.addLast(40);
        System.out.println("List: " + ll);

        System.out.println("Poll (remove head): " + ll.poll());
        System.out.println("Peek (head without remove): " + ll.peek());
        System.out.println("After operations: " + ll);
    }
}

