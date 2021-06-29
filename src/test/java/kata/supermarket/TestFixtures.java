package kata.supermarket;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;


import java.math.BigDecimal;
import java.util.List;
import kata.supermarket.discount.BuyOneGetOneFree;
import org.junit.jupiter.params.provider.Arguments;

public class TestFixtures {

  private static final List<Item> NO_ITEMS = emptyList();
  private static final List<Item> NO_DISCOUNTS = emptyList();

  public static Arguments aSingleItemPricedByWeight() {
    return Arguments.of("a single weighed item", "1.25", singleton(twoFiftyGramsOfAmericanSweets()), NO_DISCOUNTS);
  }

  public static Arguments multipleItemsPricedByWeight() {
    return Arguments.of("multiple weighed items", "1.85", asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix()), NO_DISCOUNTS);
  }

  public static Arguments multipleItemsPricedPerUnit() {
    return Arguments.of("multiple items priced per unit", "2.04", asList(aPackOfDigestives(), aPintOfMilk()), NO_DISCOUNTS);
  }

  public static Arguments twoPintsOfMilkQualifyingForBuyOneGetOneFree() {
    Item pintOfMilk = aPintOfMilk();
    return Arguments.of("Two pints of milk qualifying for buy one get one free", "0.49", asList(pintOfMilk, pintOfMilk), singletonList(new BuyOneGetOneFree(pintOfMilk.sku())));
  }

  public static Arguments aSingleItemPricedPerUnit() {
    return Arguments.of("a single item priced per unit", "0.49", singleton(aPintOfMilk()), NO_DISCOUNTS);
  }

  public static Arguments noItems() {
    return Arguments.of("no items", "0.00", NO_ITEMS, NO_DISCOUNTS);
  }

  public static Item aPintOfMilk() {
    return new Product("pintOfMilk", new BigDecimal("0.49"), "dairy").oneOf();
  }

  public static Item aPackOfDigestives() {
    return new Product("packOfDigestives", new BigDecimal("1.55"), "biscuits").oneOf();
  }

  public static WeighedProduct aKiloOfAmericanSweets() {
    return new WeighedProduct("kiloOfAmericanSweets", new BigDecimal("4.99"), "sweets");
  }

  public static Item twoFiftyGramsOfAmericanSweets() {
    return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
  }

  public static WeighedProduct aKiloOfPickAndMix() {
    return new WeighedProduct("kiloOfPickAndMix", new BigDecimal("2.99"), "sweets");
  }

  public static Item twoHundredGramsOfPickAndMix() {
    return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
  }

}
