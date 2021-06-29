package kata.supermarket.discount;

import java.math.BigDecimal;
import java.util.List;
import kata.supermarket.Item;

public interface PricingDiscount {

  BigDecimal getDiscount(List<Item> items);
}
