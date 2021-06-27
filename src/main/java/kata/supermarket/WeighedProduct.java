package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {

    private final BigDecimal pricePerKilo;

    private final String sku;

    public WeighedProduct(final String sku, final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
        this.sku = sku;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    String sku() {
        return sku;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
