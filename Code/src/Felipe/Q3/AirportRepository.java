package Felipe.Q3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AirportRepository {
    private Map<String, Airport> airportMap = new HashMap<>();

    public void loadFromCsv(String filePath) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy, 2);
                if (data.length == 2) {
                    String code = data[0].trim();
                    String name = data[1].trim();
                    airportMap.put(code, new Airport(code, name));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Airport getByCode(String code) {
        return airportMap.get(code);
    }

    public Airport getByName(String name) {
        for (Airport airport : airportMap.values()) {
            if (airport.getName().equalsIgnoreCase(name)) {
                return airport;
            }
        }
        return null;
    }

    public Collection<Airport> getAirports() {
        return airportMap.values();
    }
}
