package Simon.D3;

import java.math.BigDecimal;

public interface RateProvider {
    BigDecimal rate(String from, String to) throws FxException;
}
