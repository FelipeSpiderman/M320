package Simon.D3;

public class CurrencyNotSupportedException extends FxException {
    public CurrencyNotSupportedException(String c) { super("unsupported currency: " + c); }
}
