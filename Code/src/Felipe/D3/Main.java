package Felipe.D3;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        BookInitialize.initialize(library);

        LibraryConsole console = new LibraryConsole(library);
        console.start();
    }
}