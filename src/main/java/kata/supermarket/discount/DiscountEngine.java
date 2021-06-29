package kata.supermarket.discount;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import kata.supermarket.Item;

public class DiscountEngine {

  private final List<PricingDiscount> pricingDiscounts;

  public DiscountEngine() {
    this.pricingDiscounts = new ArrayList<>();
  }

  public void addDiscount(PricingDiscount pricingDiscount) {
    pricingDiscounts.add(pricingDiscount);
  }

  public BigDecimal calculateDiscount(List<Item> items) {
    return pricingDiscounts.stream()
                           .map(pricingDiscount -> pricingDiscount.getDiscount(items))
                           .reduce(BigDecimal::add)
                           .orElse(ZERO)
                           .setScale(2, HALF_UP);
  }


}
