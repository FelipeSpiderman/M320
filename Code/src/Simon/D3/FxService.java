package Simon.D3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FxService {
    private final RateProvider provider;

    public FxService(RateProvider provider) {
        this.provider = provider;
    }

    private void validate(String c) throws CurrencyNotSupportedException {
        if (c == null || c.length() != 3) throw new CurrencyNotSupportedException(String.valueOf(c));
        for (int i = 0; i < 3; i++) {
            char ch = c.charAt(i);
            if (ch < 'A' || ch > 'Z') throw new CurrencyNotSupportedException(c);
        }
    }

    public BigDecimal rate(String from, String to) throws FxException {
        String f = from.toUpperCase();
        String t = to.toUpperCase();
        validate(f);
        validate(t);
        return provider.rate(f, t);
    }

    public BigDecimal convert(BigDecimal amount, String from, String to) throws FxException {
        if (amount == null || amount.signum() < 0) throw new FxException("amount must be >= 0");
        BigDecimal r = rate(from, to);
        return amount.multiply(r).setScale(2, RoundingMode.HALF_UP);
    }
}
