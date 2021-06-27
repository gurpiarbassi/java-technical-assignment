package kata.supermarket;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeighedProductTest {

    @ParameterizedTest
    @MethodSource
    void itemFromWeighedProductHasExpectedProductSpecifics(String sku, String category, String pricePerKilo, String weightInKilos, String expectedPrice) {
        final WeighedProduct weighedProduct = new WeighedProduct(sku, new BigDecimal(pricePerKilo), category);
        final Item weighedItem = weighedProduct.weighing(new BigDecimal(weightInKilos));
        assertEquals(new BigDecimal(expectedPrice), weighedItem.price());
        assertEquals(sku, weighedItem.sku());
        assertEquals(category, weighedItem.category());

    }

    static Stream<Arguments> itemFromWeighedProductHasExpectedProductSpecifics() {
        return Stream.of(
                Arguments.of("mySku1", "cat1", "100.00", "1.00", "100.00"),
                Arguments.of("mySku2", "cat2","100.00", "0.33333", "33.33"),
                Arguments.of("mySku3", "cat3", "100.00", "0.33335", "33.34"),
                Arguments.of("mySku4", "cat4", "100.00", "0", "0.00")
        );
    }

}