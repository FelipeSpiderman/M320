package Simon.Q3;

import java.util.List;
import java.util.Scanner;

public class SearchApp {
    public static void main(String[] args) {
        AirportRepository repo = new AirportRepository();
        repo.loadFromCsv("src/Simon/Q3/airports.csv");
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.print("Wie willst du suchen? c = Code, n = Name, q = Beenden:");
            String choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "q":
                    break label;
                case "c":
                    System.out.print("Code eingeben: ");
                    String codeInput = scanner.nextLine().trim();
                    if (codeInput.length() == 1) {
                        List<Airport> list = AirportSearch.searchByCodePrefix(repo.getAll(), codeInput);
                        if (!list.isEmpty()) {
                            for (Airport a : list) System.out.println(a);
                        } else {
                            System.out.println("Keine Treffer.");
                        }
                    } else {
                        Airport byCode = AirportSearch.searchByCode(repo.getAll(), codeInput);
                        if (byCode != null) {
                            System.out.println("Gefunden: " + byCode);
                        } else {
                            System.out.println("Kein Flughafen mit diesem Code gefunden.");
                        }
                    }
                    break;
                case "n":
                    System.out.print("Name eingeben: ");
                    String nameInput = scanner.nextLine().trim();
                    if (nameInput.length() == 1) {
                        List<Airport> list = AirportSearch.searchByNamePrefix(repo.getAll(), nameInput);
                        if (!list.isEmpty()) {
                            for (Airport a : list) System.out.println(a);
                        } else {
                            System.out.println("Keine Treffer.");
                        }
                    } else {
                        List<Airport> byName = AirportSearch.searchByName(repo.getAll(), nameInput);
                        if (!byName.isEmpty()) {
                            for (Airport a : byName) System.out.println(a);
                        } else {
                            System.out.println("Keine Treffer für diesen Namen.");
                        }
                    }
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
                    break;
            }
        }
        scanner.close();
    }
}