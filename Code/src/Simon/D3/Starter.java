package Simon.D3;

public class
Starter {
    public static void main(String[] args) {
        RateProvider provider = new ApiRateProvider();
        FxService service = new FxService(provider);
        new App(service).run();
    }
}
