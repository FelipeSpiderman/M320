package Simon.D2;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private final String name;
    private final List<Student> students = new ArrayList<>();

    public SchoolClass(String name) {
        this.name = name;
    }

    public void addStudent(Student s) {
        if (students.size() < 20) students.add(s);
    }

    public float getAverage() {
        if (students.isEmpty()) return 0;
        float sum = 0;
        for (Student s : students) sum += s.getNotenschnitt();
        return sum / students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }
}
