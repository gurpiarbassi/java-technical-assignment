package kata.supermarket.discount;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;
import static java.util.stream.Collectors.toList;


import java.math.BigDecimal;
import java.util.List;
import kata.supermarket.Item;

public class BuyOneGetOneFree implements PricingDiscount {

  private final String sku;

  public BuyOneGetOneFree(String sku) {
    this.sku = sku;
  }

  @Override
  public BigDecimal getDiscount(List<Item> items) {
    List<Item> itemsMatchingSku = items.stream()
                                        .filter(item -> item.sku().equals(sku))
                                        .collect(toList());

    if (itemsMatchingSku.size() <= 1) {
      return ZERO.setScale(2);
    }

    int numberOfQualifyingItems = itemsMatchingSku.size() / 2;
    return BigDecimal.valueOf(numberOfQualifyingItems)
                     .multiply(itemsMatchingSku.get(0).price())
                     .setScale(2, HALF_UP);
  }
}
