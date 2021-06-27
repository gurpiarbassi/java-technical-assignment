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
    void itemFromWeighedProductHasExpectedUnitPriceAndSku(String sku, String pricePerKilo, String weightInKilos, String expectedPrice) {
        final WeighedProduct weighedProduct = new WeighedProduct(sku, new BigDecimal(pricePerKilo));
        final Item weighedItem = weighedProduct.weighing(new BigDecimal(weightInKilos));
        assertEquals(new BigDecimal(expectedPrice), weighedItem.price());
        assertEquals(sku, weighedItem.sku());

    }

    static Stream<Arguments> itemFromWeighedProductHasExpectedUnitPriceAndSku() {
        return Stream.of(
                Arguments.of("mySku1", "100.00", "1.00", "100.00"),
                Arguments.of("mySku2", "100.00", "0.33333", "33.33"),
                Arguments.of("mySku3", "100.00", "0.33335", "33.34"),
                Arguments.of("mySku4", "100.00", "0", "0.00")
        );
    }

}