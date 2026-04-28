import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void run() {
        System.out.println("\n-- Map Example --");
        Map<String, Integer> hm = new HashMap<>();
        hm.put("Alice", 30);
        hm.put("Bob", 25);
        System.out.println("HashMap: " + hm);

        hm.computeIfAbsent("Charlie", k -> 20);
        System.out.println("After computeIfAbsent: " + hm);

        Map<String, Integer> tm = new TreeMap<>(hm);
        System.out.println("TreeMap (sorted by key): " + tm);

        System.out.println("Iterating entries:");
        for (Map.Entry<String, Integer> e : tm.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}

