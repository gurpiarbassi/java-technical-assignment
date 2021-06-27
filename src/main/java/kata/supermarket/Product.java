package kata.supermarket;

import java.math.BigDecimal;

public class Product {

    private final BigDecimal pricePerUnit;

    private final String sku;

    private final String category;

    public Product(String sku, final BigDecimal pricePerUnit, String category) {
        this.pricePerUnit = pricePerUnit;
        this.sku = sku;
        this.category = category;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }


    String sku() {
        return sku;
    }

    String category() {
        return category;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

}
