package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {

    private final BigDecimal pricePerKilo;

    private final String sku;

    private final String category;

    public WeighedProduct(final String sku, final BigDecimal pricePerKilo, String category) {
        this.pricePerKilo = pricePerKilo;
        this.sku = sku;
        this.category = category;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    String sku() {
        return sku;
    }

    String category() {
        return category;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
