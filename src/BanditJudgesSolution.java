import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Розв'язання задачі:
// відомо, який суддя судив якого конкретного бандита;
// потрібно знайти суддів, які судили все угрупування.
public class BanditJudgesSolution {

    // Для кожної групи беремо перетин множин суддів по всіх бандитах групи.
    public static Set<Judge> findJudgesWhoJudgedWholeGroup(List<Bandit> group,
                                                           Map<Bandit, Set<Judge>> banditToJudges) {
        Set<Judge> result = null;

        for (Bandit bandit : group) {
            Set<Judge> judgesForBandit = banditToJudges.getOrDefault(bandit, new HashSet<>());
            if (result == null) {
                result = new LinkedHashSet<>(judgesForBandit);
            } else {
                result.retainAll(judgesForBandit);
            }
        }

        return result == null ? new LinkedHashSet<>() : result;
    }

    public static void run() {
        System.out.println("\n-- Bandit / Judge Grouping Solution --");

        // Судді.
        Judge judge1 = new Judge(1, "Petrenko");
        Judge judge2 = new Judge(2, "Ivanenko");
        Judge judge3 = new Judge(3, "Shevchenko");
        Judge judge4 = new Judge(4, "Koval");
        Judge judge5 = new Judge(5, "Melnyk");

        // Бандити розбиті на групи по 3-4 людини.
        Bandit b1 = new Bandit(1, "Bandit-A", "Group-1");
        Bandit b2 = new Bandit(2, "Bandit-B", "Group-1");
        Bandit b3 = new Bandit(3, "Bandit-C", "Group-1");

        Bandit b4 = new Bandit(4, "Bandit-D", "Group-2");
        Bandit b5 = new Bandit(5, "Bandit-E", "Group-2");
        Bandit b6 = new Bandit(6, "Bandit-F", "Group-2");
        Bandit b7 = new Bandit(7, "Bandit-G", "Group-2");

        List<Bandit> group1 = Arrays.asList(b1, b2, b3);
        List<Bandit> group2 = Arrays.asList(b4, b5, b6, b7);

        // Відомо лише: який суддя судив якого бандита.
        // Map<Bandit, Set<Judge>> добре підходить, бо швидко шукаємо суддів конкретного бандита.
        Map<Bandit, Set<Judge>> banditToJudges = new LinkedHashMap<>();
        banditToJudges.put(b1, new LinkedHashSet<>(Arrays.asList(judge1, judge2, judge3)));
        banditToJudges.put(b2, new LinkedHashSet<>(Arrays.asList(judge2, judge3, judge4)));
        banditToJudges.put(b3, new LinkedHashSet<>(Arrays.asList(judge2, judge3, judge5)));

        banditToJudges.put(b4, new LinkedHashSet<>(Arrays.asList(judge1, judge2, judge4)));
        banditToJudges.put(b5, new LinkedHashSet<>(Arrays.asList(judge2, judge4, judge5)));
        banditToJudges.put(b6, new LinkedHashSet<>(Arrays.asList(judge2, judge3, judge4)));
        banditToJudges.put(b7, new LinkedHashSet<>(Arrays.asList(judge2, judge4)));

        // Шукаємо суддів, які судили всю групу.
        Set<Judge> group1Judges = findJudgesWhoJudgedWholeGroup(group1, banditToJudges);
        Set<Judge> group2Judges = findJudgesWhoJudgedWholeGroup(group2, banditToJudges);

        System.out.println("Group 1: " + group1);
        System.out.println("Judges who judged all in Group 1: " + group1Judges);

        System.out.println("Group 2: " + group2);
        System.out.println("Judges who judged all in Group 2: " + group2Judges);

        // Якщо треба отримати відповідь для всіх угрупувань одразу,
        // зберігаємо групи в Map і рахуємо перетин для кожної групи.
        Map<String, List<Bandit>> groups = new LinkedHashMap<>();
        groups.put("Group-1", group1);
        groups.put("Group-2", group2);

        System.out.println("\nSummary:");
        for (Map.Entry<String, List<Bandit>> entry : groups.entrySet()) {
            Set<Judge> judges = findJudgesWhoJudgedWholeGroup(entry.getValue(), banditToJudges);
            System.out.println(entry.getKey() + " -> " + judges);
        }
    }
}

