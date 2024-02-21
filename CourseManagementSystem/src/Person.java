public class Person {
    private final int personId;
    private final String name;
    private final String surname;
    private static int personIdCounter = 1;

    public Person(String name, String surname) {
        this.personId = personIdCounter++;
        this.name = name.trim();
        this.surname = surname.trim();
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    public String getPersonId() {
        return Integer.toString(this.personId);
    }
}
