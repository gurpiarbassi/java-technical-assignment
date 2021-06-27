package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new Product("foo", price).oneOf().price());
    }

    @Test
    void singleItemHasExpectedSkuFromProduct() {
        final String sku = "foo";
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(sku, new Product(sku, price).oneOf().sku());
    }
}