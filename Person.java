public class Person {
    private final String name;
    private final String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}
