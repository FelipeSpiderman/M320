package Felipe.Q3;

public class Airport {
    private String code;
    private String name;

    public Airport(String code, String name) {
        this.code = code.toUpperCase();
        this.name = name.toUpperCase();
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

