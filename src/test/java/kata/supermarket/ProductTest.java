package kata.supermarket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertThat(new Product("foo", price, "bar").oneOf().price(), is(price));
    }

    @Test
    void singleItemHasExpectedSkuAndCategoryFromProduct() {
        final String sku = "foo";
        final String category = "bar";
        final BigDecimal price = new BigDecimal("2.49");
        Item item = new Product(sku, price, category).oneOf();

        assertThat(item.sku(), is(sku));
        assertThat(item.category(), is(category));
    }
}