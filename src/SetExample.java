import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void run() {
        System.out.println("\n-- Set Example --");
        Set<String> hs = new HashSet<>();
        hs.add("apple");
        hs.add("banana");
        hs.add("apple"); // duplicate ignored
        System.out.println("HashSet (unique): " + hs);

        Set<String> ts = new TreeSet<>();
        ts.add("banana");
        ts.add("apple");
        ts.add("cherry");
        System.out.println("TreeSet (sorted): " + ts);
    }
}

