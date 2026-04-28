import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExamples {
    public static void run() {
        System.out.println("\n-- Queue Examples --");
        Queue<String> q = new LinkedList<>();
        q.add("one");
        q.add("two");
        q.offer("three");
        System.out.println("Queue (FIFO): " + q);
        System.out.println("Poll: " + q.poll());
        System.out.println("Peek: " + q.peek());
        System.out.println("Remaining: " + q);

        PriorityQueue<PersonPQ> pq = new PriorityQueue<>();
        pq.add(new PersonPQ("Bob", 30));
        pq.add(new PersonPQ("Alice", 25));
        pq.add(new PersonPQ("Eve", 35));
        System.out.println("PriorityQueue (by age, smallest first):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static class PersonPQ implements Comparable<PersonPQ> {
        String name;
        int age;

        PersonPQ(String n, int a) {
            name = n;
            age = a;
        }

        @Override
        public int compareTo(PersonPQ o) {
            return Integer.compare(this.age, o.age);
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}

