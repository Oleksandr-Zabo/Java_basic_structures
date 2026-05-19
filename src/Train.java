import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Потяг містить назву, час початку/кінця руху та колекцію пасажирів.
// Список пасажирів зберігається всередині потяга, а додавання/видалення
// відбувається через методи add(...) і remove(...).
public class Train {
    private final String title;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final List<Passenger> passengers;

    public Train(String title, LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.passengers = new ArrayList<>();
    }

    // Копіювальний конструктор: створює окремий список пасажирів.
    public Train(Train other) {
        this.title = other.title;
        this.startTime = other.startTime;
        this.endTime = other.endTime;
        this.passengers = new ArrayList<>();
        for (Passenger passenger : other.passengers) {
            this.passengers.add(new Passenger(passenger));
        }
    }

    public String getTitle() {
        return title;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    // Повертаємо копію списку, щоб зовнішній код не змінював внутрішній стан напряму.
    public List<Passenger> getPassengers() {
        List<Passenger> copy = new ArrayList<>();
        for (Passenger passenger : passengers) {
            copy.add(new Passenger(passenger));
        }
        return copy;
    }

    // Садить пасажира на потяг.
    // Якщо пасажир із таким прізвищем уже є, оновлюємо його місце.
    public void add(String name, int place) {
        Passenger existing = findPassenger(name);
        if (existing == null) {
            passengers.add(new Passenger(name, place));
        } else {
            existing.setPlace(place);
        }
    }

    // Висаджує пасажира з потяга.
    public boolean remove(String name) {
        return passengers.removeIf(passenger -> Objects.equals(passenger.getName(), name));
    }

    // Пошук пасажира всередині одного потяга.
    public Passenger findPassenger(String name) {
        for (Passenger passenger : passengers) {
            if (Objects.equals(passenger.getName(), name)) {
                return passenger;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return title + " [" + startTime + "-" + endTime + "] " + passengers;
    }
}

