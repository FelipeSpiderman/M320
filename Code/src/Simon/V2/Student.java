package Simon.V2;

public class Student extends Person {
    private final int semester;
    private final String role;

    public Student(String name, int semester) {
        super(name);
        this.semester = semester;
        this.role = "Student";
    }

    @Override
    public String role() { return role + " " + getName() + " (Semester: " + semester + ")"; }
}
