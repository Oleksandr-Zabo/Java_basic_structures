import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Демонстрація задачі про потяги та пасажирів.
// Запит A: знайти прізвища, які зустрічаються більш ніж в одному потязі.
// Запит B: за прізвищем показати, на яких потягах і на яких місцях їде пасажир.
public class TrainTaskExample {

    // Глибоке копіювання списку потягів.
    public static List<Train> deepCopy(List<Train> trains) {
        List<Train> copy = new ArrayList<>();
        for (Train train : trains) {
            copy.add(new Train(train));
        }
        return copy;
    }

    // Запит A: знайти пасажирів, які їдуть більш ніж в одному потязі.
    public static Set<String> findPassengersInMoreThanOneTrain(List<Train> trains) {
        Map<String, Set<String>> passengerToTrains = new LinkedHashMap<>();

        for (Train train : trains) {
            for (Passenger passenger : train.getPassengers()) {
                passengerToTrains
                        .computeIfAbsent(passenger.getName(), key -> new LinkedHashSet<>())
                        .add(train.getTitle());
            }
        }

        Set<String> result = new LinkedHashSet<>();
        for (Map.Entry<String, Set<String>> entry : passengerToTrains.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    // Запит B: знайти всі потяги й місця для конкретного прізвища.
    public static List<String> findPassengerLocation(List<Train> trains, String surname) {
        List<String> result = new ArrayList<>();

        for (Train train : trains) {
            Passenger passenger = train.findPassenger(surname);
            if (passenger != null) {
                result.add(train.getTitle() + " -> place " + passenger.getPlace());
            }
        }

        return result;
    }

    public static void run() {
        System.out.println("\n-- Train / Passenger Task --");

        Train train1 = new Train("InterCity-1", LocalTime.of(8, 0), LocalTime.of(10, 30));
        Train train2 = new Train("InterCity-2", LocalTime.of(9, 15), LocalTime.of(12, 0));
        Train train3 = new Train("Regional-3", LocalTime.of(13, 0), LocalTime.of(15, 20));

        // Заповнюємо потяги без введення з клавіатури.
        train1.add("Shevchenko", 5);
        train1.add("Ivanenko", 12);
        train1.add("Melnyk", 18);

        train2.add("Shevchenko", 7);
        train2.add("Petrenko", 3);
        train2.add("Ivanenko", 14);

        train3.add("Koval", 2);
        train3.add("Petrenko", 9);
        train3.add("Bondar", 11);

        List<Train> trains = Arrays.asList(train1, train2, train3);

        System.out.println("Original trains:");
        for (Train train : trains) {
            System.out.println(train);
        }

        // Demonstration of deep copy: copied list can be changed independently.
        List<Train> copiedTrains = deepCopy(trains);
        copiedTrains.get(0).add("CopiedOnly", 99);
        copiedTrains.get(1).remove("Petrenko");

        System.out.println("\nCopied trains after changes:");
        for (Train train : copiedTrains) {
            System.out.println(train);
        }

        System.out.println("\nOriginal trains stay unchanged:");
        for (Train train : trains) {
            System.out.println(train);
        }

        // Запит A.
        Set<String> duplicatedPassengers = findPassengersInMoreThanOneTrain(trains);
        System.out.println("\nQuery A: passengers on more than one train = " + duplicatedPassengers);

        // Запит B.
        String searchSurname = "Petrenko";
        List<String> locations = findPassengerLocation(trains, searchSurname);
        if (locations.isEmpty()) {
            System.out.println("Query B: passenger '" + searchSurname + "' is not on any train.");
        } else {
            System.out.println("Query B: passenger '" + searchSurname + "' rides on:");
            for (String location : locations) {
                System.out.println("  " + location);
            }
        }

        // Ще один приклад для пасажира, який їде в кількох потягах.
        searchSurname = "Shevchenko";
        locations = findPassengerLocation(trains, searchSurname);
        System.out.println("\nQuery B example for '" + searchSurname + "':");
        for (String location : locations) {
            System.out.println("  " + location);
        }
    }
}

