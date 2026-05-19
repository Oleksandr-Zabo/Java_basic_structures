import java.util.Objects;

// Пасажир потяга.
// У цій задачі 'name' трактуємо як прізвище пасажира, а 'place' — його місце.
public class Passenger {
    private final String name;
    private int place;

    public Passenger(String name, int place) {
        this.name = name;
        this.place = place;
    }

    // Копіювальний конструктор для deep copy.
    public Passenger(Passenger other) {
        this.name = other.name;
        this.place = other.place;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + "(" + place + ")";
    }
}

