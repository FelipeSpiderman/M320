package Simon.V2;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String title;
    private final Teacher teacher;
    private final Assistant assistant;
    private final int minSize;
    private final int maxSize;
    private final List<Student> students = new ArrayList<>();

    public Course(String title, Teacher teacher, Assistant assistant, int minSize, int maxSize) {
        this.title = title;
        this.teacher = teacher;
        this.assistant = assistant;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public void enroll(Student s) {
        if (s == null) return;
        if (students.size() >= maxSize) return;
        students.add(s);
    }

    public void enroll(Student s, boolean priority) {
        if (s == null) return;
        if (students.contains(s)) return;
        if (students.size() < maxSize) {
            students.add(s);
            return;
        }
        if (priority && students.size() == maxSize) {
            students.removeLast();
            students.add(s);
        }
    }

    public String roster() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course ").append(title).append("\n");
        sb.append(teacher.role()).append("\n");
        sb.append(assistant.role()).append("\n");
        for (Student s : students) sb.append(s.role()).append("\n");
        return sb.toString();
    }

    public int capacityLeft() { return maxSize - students.size(); }

    public boolean meetsMinimum() { return students.size() >= minSize; }
}
