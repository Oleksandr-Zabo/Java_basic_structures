import java.util.ArrayList;
import java.util.List;

// Демонстрація списку бандитів і глибокого копіювання.
public class BanditListExample {
    public static List<Bandit> deepCopy(List<Bandit> source) {
        List<Bandit> copy = new ArrayList<>();
        for (Bandit bandit : source) {
            copy.add(new Bandit(bandit));
        }
        return copy;
    }

    public static void run() {
        System.out.println("\n-- Bandit List + Deep Copy Example --");

        List<Bandit> original = new ArrayList<>();
        original.add(new Bandit(1, "Viktor", "Alpha"));
        original.add(new Bandit(2, "Oleh", "Alpha"));
        original.add(new Bandit(3, "Ihor", "Alpha"));
        System.out.println("Original list: " + original);

        List<Bandit> copied = deepCopy(original);
        copied.get(0).setGroupName("Copied-Group");
        copied.add(new Bandit(4, "Andrii", "Copied-Group"));

        // Показуємо, що змінена копія не вплинула на оригінал.
        System.out.println("Copied list:   " + copied);
        System.out.println("Original still: " + original);
    }
}

