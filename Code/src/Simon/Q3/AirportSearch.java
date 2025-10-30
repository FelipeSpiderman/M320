package Simon.Q3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AirportSearch {
    public static Airport searchByCode(List<Airport> airports, String code) {
        if (code == null) return null;
        String key = code.trim().toUpperCase();
        for (Airport a : airports) {
            if (a.getCode().equals(key)) return a;
        }
        return null;
    }

    public static List<Airport> searchByName(List<Airport> airports, String name) {
        List<Airport> results = new ArrayList<>();
        if (name == null) return results;
        String key = name.trim().toUpperCase();
        for (Airport a : airports) {
            if (a.getName().contains(key)) results.add(a);
        }
        return results;
    }

    public static List<Airport> searchByCodePrefix(List<Airport> airports, String prefix) {
        List<Airport> results = new ArrayList<>();
        if (prefix == null) return results;
        String key = prefix.trim().toUpperCase();
        for (Airport a : airports) {
            if (a.getCode().startsWith(key)) results.add(a);
        }
        results.sort(Comparator.comparing(Airport::getCode));
        return results;
    }

    public static List<Airport> searchByNamePrefix(List<Airport> airports, String prefix) {
        List<Airport> results = new ArrayList<>();
        if (prefix == null) return results;
        String key = prefix.trim().toUpperCase();
        for (Airport a : airports) {
            if (a.getName().startsWith(key)) results.add(a);
        }
        results.sort(Comparator.comparing(Airport::getName));
        return results;
    }
}