import java.util.ArrayList;

public class ArrayListExample {
    public static void run() {
        System.out.println("\n-- ArrayList Example --");
        ArrayList<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");
        System.out.println("After adds: " + list);

        list.add(1, "Diana");
        System.out.println("After insert at index 1: " + list);

        String removed = list.remove(2);
        System.out.println("Removed element at index 2: " + removed + ", now: " + list);

        System.out.println("Iterating with indices:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i = " + i + " -> " + list.get(i));
        }
    }
}

