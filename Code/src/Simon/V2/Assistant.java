package Simon.V2;

public class Assistant extends Person {
    private final String role;

    public Assistant(String name) {
        super(name);
        this.role = "Assistent";
    }

    @Override
    public String role() { return role + " " + getName(); }
}
