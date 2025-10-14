package Simon.V2;

public class Person {
    private final String name;

    public Person(String name) { this.name = name; }

    protected String getName() { return name; }

    public String role() { return "Person " + name; }
}
