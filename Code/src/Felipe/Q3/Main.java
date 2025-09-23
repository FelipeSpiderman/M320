package Felipe.Q3;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AirportRepository repo = new AirportRepository();
        repo.loadFromCsv("src/Felipe/Q3/airports.csv");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Gib einen Airport-Code ein: ");
            String code = scanner.nextLine();
            Airport airport = AirportSearch.searchByCode(repo, code);

            if (airport != null) {
                System.out.println("Gefunden: " + airport);
            } else {
                System.out.println("Kein Airport mit diesem Code gefunden.");
            }

            System.out.print("Gib einen Airport-Namen ein: ");
            String name = scanner.nextLine();
            List<Airport> airportsByName = AirportSearch.searchByName(repo, name);

            if (!airportsByName.isEmpty()) {
                System.out.println("Gefundene Flughäfen:");
                for (Airport a : airportsByName) {
                    System.out.println("- " + a);
                }
            } else {
                System.out.println("Keine Airports mit diesem Namen gefunden.");
            }

            while (true) {
                System.out.print("Nochmal ein Input eingeben? (j/n): ");
                String ongoing = scanner.nextLine();
                if (ongoing.equalsIgnoreCase("j")) {
                    break;
                } else if (ongoing.equalsIgnoreCase("n")) {
                    scanner.close();
                    return;
                } else {
                    System.out.println("Ungültige Eingabe. Bitte 'j' oder 'n' eingeben.");
                }
            }
        }
    }
}