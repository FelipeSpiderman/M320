package Simon.V2;

public class Teacher extends Person {
    private final String role;

    public Teacher(String name) {
        super(name);
        this.role = "Lehrer";
    }

    @Override
    public String role() { return role + " " + getName(); }
}
