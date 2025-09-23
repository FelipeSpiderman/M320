package Simon.V2;

public class Starter {
    public static void main(String[] args) {
        Teacher Teacher = new Teacher("Frau Keller");
        Assistant Assistant = new Assistant("Herr Roth");
        Course Course = new Course("Math", Teacher, Assistant, 2, 3);

        Student Student1 = new Student("Mia", 2);
        Student Student2 = new Student("Noah", 3);
        Student Student3 = new Student("Lina", 1);
        Student Student4 = new Student("Jan", 1);

        Course.enroll(Student1);
        Course.enroll(Student2);
        Course.enroll(Student3);
        Course.enroll(Student4, true);

        Person[] people = new Person[]{Teacher, Assistant, Student1, Student2, Student3};
        for (Person p : people) System.out.println(p.role());

        System.out.println("Spaces left: " + Course.capacityLeft());
        System.out.println("Meets minimum: " + Course.meetsMinimum());
        System.out.println();
        System.out.println(Course.roster());
    }
}
