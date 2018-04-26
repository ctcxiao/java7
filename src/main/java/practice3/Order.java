package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    BigDecimal calculate() {
        PriceCalculator priceCalculator = new PriceCalculator(orderLineItemList, discounts);

        BigDecimal subTotal = priceCalculator.getTotal();

        BigDecimal subtract = priceCalculator.getSubtract();

        subTotal = subTotal.subtract(subtract);

        return subTotal.multiply(this.tax.add(new BigDecimal(1)));
    }
}
