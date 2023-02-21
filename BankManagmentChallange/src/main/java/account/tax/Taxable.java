package account.tax;

import java.math.BigDecimal;

public interface Taxable {

    public void tax(BigDecimal income);
}
