package practice3;

import java.math.BigDecimal;
import java.util.List;

class PriceCalculator {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;

    PriceCalculator(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
    }

    BigDecimal getSubtract() {
        BigDecimal subtract = new BigDecimal(0);
        for (BigDecimal discount : discounts) {
            subtract = subtract.add(discount);
        }
        return subtract;
    }

    BigDecimal getTotal() {
        BigDecimal subTotal = new BigDecimal(0);
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
        return subTotal;
    }
}
