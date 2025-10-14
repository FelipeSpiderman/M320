package Felipe.D3;

import java.util.Scanner;


public class LibraryConsole {
    private Library library;
    private Scanner scanner;


    public LibraryConsole(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }


    public void start() {
        while (true) {
            System.out.println("\n1. Bücher anzeigen 2. Ausleihen 3. Zurückgeben 4. Beenden");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        showBooks();
                        break;
                    case "2":
                        borrowBook();
                        break;
                    case "3":
                        returnBook();
                        break;
                    case "4":
                        System.out.println("Programm beendet.");
                        return;
                    default:
                        throw new InvalidInput("Ungültige Auswahl!");
                }
            } catch (InvalidInput e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }
    }


    private void showBooks() {
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }


    private void borrowBook() throws InvalidInput {
        System.out.print("Buchtitel zum Ausleihen: ");
        String title = scanner.nextLine();
        library.borrowBook(title);
        System.out.println("Buch erfolgreich ausgeliehen!");
    }


    private void returnBook() throws InvalidInput {
        System.out.print("Buchtitel zum Zurückgeben: ");
        String title = scanner.nextLine();
        library.returnBook(title);
        System.out.println("Buch erfolgreich zurückgegeben!");
    }
}
