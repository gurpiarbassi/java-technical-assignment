package kata.supermarket.discount;

import static java.math.RoundingMode.HALF_UP;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static kata.supermarket.TestFixtures.aPackOfDigestives;
import static kata.supermarket.TestFixtures.aPintOfMilk;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuyOneGetOneFreeTest {

  private static final BigDecimal NO_DISCOUNT = new BigDecimal("0.00");

  private BuyOneGetOneFree classUnderTest;

  @BeforeEach
  void setup () {
    classUnderTest = new BuyOneGetOneFree(aPintOfMilk().sku());
  }

  @Test
  void shouldReturnZeroWhenNoItems() {
    assertThat(classUnderTest.getDiscount(emptyList()), is(NO_DISCOUNT));
  }

  @Test
  void shouldReturnZeroWhenNoQualifyingItemsItems() {
    assertThat(classUnderTest.getDiscount(singletonList(aPackOfDigestives())), is(NO_DISCOUNT));
  }

  @Test
  void shouldReturnZeroWhenOnlyOneQualifyingItem() {
    assertThat(classUnderTest.getDiscount(singletonList(aPintOfMilk())), is(NO_DISCOUNT));
  }

  @Test
  void shouldReturnDiscountWhenTwoItemsQualify() {
    assertThat(classUnderTest.getDiscount(asList(aPintOfMilk(), aPintOfMilk())), is(aPintOfMilk().price()));
  }

  @Test
  void shouldReturnDiscountWhenFourItemsQualify() {
    BigDecimal expectedDiscountAmount = aPintOfMilk().price()
                                                     .multiply(new BigDecimal("2"))
                                                     .setScale(2, HALF_UP);

    assertThat(classUnderTest.getDiscount(asList(aPintOfMilk(), aPintOfMilk(), aPintOfMilk(), aPintOfMilk())), is(expectedDiscountAmount));
  }

  @Test
  void shouldOnlyApplyDiscountForMatchingPairsOfItems() {
    assertThat(classUnderTest.getDiscount(asList(aPintOfMilk(), aPintOfMilk(), aPintOfMilk())), is(aPintOfMilk().price()));
  }

}