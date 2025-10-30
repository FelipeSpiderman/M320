package Simon.Q3;

public class Airport {
    private final String code;
    private final String name;

    public Airport(String code, String name) {
        this.code = code == null ? "" : code.toUpperCase();
        this.name = name == null ? "" : name.toUpperCase();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}