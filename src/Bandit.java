import java.util.Objects;

// Модель бандита.
// Потрібна для збереження бандитів у списках, мапах і множинах.
public class Bandit {
    private final int id;
    private final String name;
    private String groupName;

    public Bandit(int id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

    // Копіювальний конструктор для deep copy.
    public Bandit(Bandit other) {
        this.id = other.id;
        this.name = other.name;
        this.groupName = other.groupName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bandit bandit = (Bandit) o;
        return id == bandit.id && Objects.equals(name, bandit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name + "#" + id + (groupName == null ? "" : "[" + groupName + "]");
    }
}

