package Simon.D2;

public class Starter {
    public static void main(String[] args) {
        SchoolClass exampleClass = new SchoolClass("Ap24b");
        App app = new App(exampleClass);
        app.run();
    }
}