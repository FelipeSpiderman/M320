package Simon.D2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final List<Test> tests = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addTest(Test t) {
        tests.add(t);
    }

    public float getGrades() {
        if (tests.isEmpty()) return 0;
        float sum = 0;
        for (Test t : tests) sum += t.calculateGrade();
        return sum / tests.size();
    }

    public String getName() {
        return name;
    }
}
