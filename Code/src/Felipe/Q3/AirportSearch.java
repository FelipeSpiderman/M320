package Felipe.Q3;

import java.util.ArrayList;
import java.util.List;

public class AirportSearch {

    public static Airport searchByCode(AirportRepository repo, String code) {
        return repo.getByCode(code.toUpperCase());
    }

    public static List<Airport> searchByName(AirportRepository repo, String input) {
        List<Airport> results = new ArrayList<>();
        String search = input.toUpperCase();

        for (Airport airport : repo.getAirports()) {
            if (airport.getName().contains(search)) {
                results.add(airport);
            }
        }
        return results;
    }
}
