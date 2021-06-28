package kata.supermarket;

import static kata.supermarket.TestFixtures.aSingleItemPricedByWeight;
import static kata.supermarket.TestFixtures.aSingleItemPricedPerUnit;
import static kata.supermarket.TestFixtures.multipleItemsPricedByWeight;
import static kata.supermarket.TestFixtures.multipleItemsPricedPerUnit;
import static kata.supermarket.TestFixtures.noItems;
import static kata.supermarket.TestFixtures.twoPintsOfMilkQualifyingForBuyOneGetOneFree;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertThat(basket.total(), is(new BigDecimal(expectedTotal)));
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                twoPintsOfMilkQualifyingForBuyOneGetOneFree()
        );
    }
}