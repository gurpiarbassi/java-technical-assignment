package kata.supermarket;

import java.math.BigDecimal;

public class Product {

    private final BigDecimal pricePerUnit;

    private final String sku;

    public Product(String sku, final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.sku = sku;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }


    String sku() {
        return sku;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

}
