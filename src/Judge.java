import java.util.Objects;

// Модель судді.
// Саме цей об'єкт буде ключем у Map або елементом Set.
public class Judge {
    private final int id;
    private final String name;

    public Judge(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Judge judge = (Judge) o;
        return id == judge.id && Objects.equals(name, judge.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name + "#" + id;
    }
}

