package kata.supermarket;

import static java.util.Collections.unmodifiableList;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import kata.supermarket.discount.DiscountEngine;

public class Basket {
    private final List<Item> items;

    private final DiscountEngine discountEngine;

    public Basket(DiscountEngine discountEngine) {
        this.items = new ArrayList<>();
        this.discountEngine = discountEngine;
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {
        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream()
                    .map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        private BigDecimal discounts() {
            return discountEngine.calculateDiscount(items);
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}
