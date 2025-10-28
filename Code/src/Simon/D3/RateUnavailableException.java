package Simon.D3;

public class RateUnavailableException extends FxException {
    public RateUnavailableException(String pair) { super("rate unavailable: " + pair); }
}
