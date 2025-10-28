package Simon.Q3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportRepository {
    private final List<Airport> airports = new ArrayList<>();

    public void loadFromCsv(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    String code = parts[0].trim();
                    String name = parts[1].trim();
                    airports.add(new Airport(code, name));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Airport> getAll() {
        return new ArrayList<>(airports);
    }
}