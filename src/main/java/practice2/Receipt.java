package practice2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Receipt {

    public Receipt() {
        tax = new BigDecimal(0.1);
        tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal tax;

    public double CalculateGrandTotal(List<Product> products, List<OrderItem> items) {
        Map<Long, OrderItem> itemMap = items.stream().collect(Collectors.toMap(OrderItem::getCode, i -> i));
        BigDecimal total = calculateSubtotal(products, itemMap);
        return total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private BigDecimal ProduceReducedPrice(Product product, OrderItem curItem) {
        return product.getPrice()
                        .multiply(product.getDiscountRate())
                        .multiply(new BigDecimal(curItem.getCount()));
    }


    private BigDecimal calculateSubtotal(List<Product> products, Map<Long, OrderItem> items) {
        BigDecimal subTotal = new BigDecimal(0);
        for (Product product : products) {
            if (!items.containsKey(product.getCode())) {
                continue;
            }
            BigDecimal itemTotal = getItemNetTotal(items, product);
            subTotal = subTotal.add(itemTotal);
        }
        return subTotal.multiply(tax.add(new BigDecimal(1)));
    }

    private BigDecimal getItemNetTotal(Map<Long, OrderItem> items, Product product) {
        OrderItem item = items.get(product.getCode());
        BigDecimal itemTotal = product.getPrice().multiply(new BigDecimal(item.getCount()));
        BigDecimal reducedPrice = ProduceReducedPrice(product, item);
        return itemTotal.subtract(reducedPrice);
    }
}
