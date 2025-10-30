package Simon.D3;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRateProvider implements RateProvider {
    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public BigDecimal rate(String from, String to) throws FxException {
        try {
            String apiKey = "732b023c989008624de4fc4f";
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + from;
            HttpRequest req = HttpRequest.newBuilder(URI.create(url)).GET().build();
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            String body = res.body();
            String search = "\"" + to.toUpperCase() + "\":";
            int i = body.indexOf(search);
            if (i < 0) throw new RateUnavailableException(from + "->" + to);
            int s = i + search.length();
            int e = s;
            while (e < body.length() && "0123456789.eE-".indexOf(body.charAt(e)) >= 0) e++;
            String num = body.substring(s, e).trim();
            if (num.isEmpty()) throw new RateUnavailableException(from + "->" + to);
            return new BigDecimal(num);
        } catch (FxException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RateUnavailableException(from + "->" + to);
        }
    }
}
