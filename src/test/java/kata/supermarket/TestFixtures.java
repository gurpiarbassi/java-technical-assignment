package kata.supermarket;

import static java.util.Arrays.asList;


import java.math.BigDecimal;
import java.util.Collections;
import org.junit.jupiter.params.provider.Arguments;

public class TestFixtures {

  public static Arguments aSingleItemPricedByWeight() {
    return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
  }

  public static Arguments multipleItemsPricedByWeight() {
    return Arguments.of("multiple weighed items", "1.85",
      asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
    );
  }

  public static Arguments multipleItemsPricedPerUnit() {
    return Arguments.of("multiple items priced per unit", "2.04",
      asList(aPackOfDigestives(), aPintOfMilk()));
  }

  public static Arguments aSingleItemPricedPerUnit() {
    return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
  }

  public static Arguments noItems() {
    return Arguments.of("no items", "0.00", Collections.emptyList());
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

  public static Arguments twoPintsOfMilkQualifyingForBuyOneGetOneFree() {
    return Arguments.of("Two pints of milk qualifying for buy one get one free", "0.49", asList(aPintOfMilk(), aPintOfMilk()));
  }
}
