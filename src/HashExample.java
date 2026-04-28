import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HashExample {
    static class Person {
        String name; int id;
        Person(String n, int i) { name = n; id = i; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        @Override
        public String toString() { return name + "#" + id; }
    }

    public static void run() {
        System.out.println("\n-- Hash (custom hashCode/equals) Example --");
        Set<Person> set = new HashSet<>();
        set.add(new Person("Alice", 1));
        set.add(new Person("Bob", 2));
        set.add(new Person("Alice", 1)); // duplicate based on equals/hashCode
        System.out.println("HashSet with Person: " + set);

        Map<Person, String> map = new HashMap<>();
        map.put(new Person("Alice", 1), "engineer");
        map.put(new Person("Bob", 2), "manager");
        System.out.println("HashMap with Person keys:");
        for (Map.Entry<Person, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}

