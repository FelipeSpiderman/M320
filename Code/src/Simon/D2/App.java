package Simon.D2;

import java.util.Scanner;

public class App {
    private final Scanner sc = new Scanner(System.in);
    private final SchoolClass schoolClass;

    public App(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void run() {
        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Add test to student");
            System.out.println("3. Show averages");
            System.out.println("4. Exit");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> addStudent();
                case "2" -> addTest();
                case "3" -> showAverages();
                case "4" -> { return; }
            }
        }
    }

    private void addStudent() {
        System.out.print("Student name: ");
        String name = sc.nextLine();
        schoolClass.addStudent(new Student(name));
    }

    private void addTest() {
        if (schoolClass.getStudents().isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        System.out.println("Choose student index:");
        for (int i = 0; i < schoolClass.getStudents().size(); i++) {
            System.out.println(i + ": " + schoolClass.getStudents().get(i).getName());
        }
        int idx = Integer.parseInt(sc.nextLine());
        Student s = schoolClass.getStudents().get(idx);

        System.out.print("Points: ");
        int points = Integer.parseInt(sc.nextLine());
        System.out.print("Total points: ");
        int total = Integer.parseInt(sc.nextLine());
        s.addTest(new Test(points, total));
    }

    private void showAverages() {
        for (Student s : schoolClass.getStudents()) {
            System.out.println(s.getName() + ": " + s.getGrades());
        }
        System.out.println("Class average: " + schoolClass.getAverage());
    }
}
