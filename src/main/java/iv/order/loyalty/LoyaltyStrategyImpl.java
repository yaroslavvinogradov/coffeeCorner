package iv.order.loyalty;

import iv.order.Order;
import iv.products.Product;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyStrategyImpl implements LoyaltyStrategy {

    public LoyaltyStrategyImpl() {
    }

    public void process(Order order) {
        List<Product> workItems = new ArrayList<>();
        int snacks = 0;
        boolean hasExtra = false;
        int numberOfStamps = order.getNumberOfStamps();
        int maxStamps = order.getMaxStamps();
        for (Product item: order.getProducts()) {
            if (item.isBeverage()) {
                numberOfStamps += 1;
                if (numberOfStamps == maxStamps) {
                    workItems.add(item.makeFree());
                    numberOfStamps = 0;
                } else {
                    workItems.add(item);
                }
            } else if (item.isSnack()) {
                snacks += 1;
                workItems.add(item);
            } else if (item.isExtra()) {
                hasExtra = true;
                workItems.add(item);
            } else {
                throw new IllegalArgumentException("Wrong order item");
            }
        }
        if (hasExtra) {
            workItems = processExtra(workItems, snacks);
        }
        order.setProducts(workItems);
        order.setNumberOfStamps(numberOfStamps);
    }

    public List<Product> processExtra(List<Product> items, int extras) {
        List<Product> newItems = new ArrayList<>();
        for (Product item: items) {
            if (item.isExtra() && extras > 0) {
                newItems.add(item.makeFree());
                extras -= 1;
            } else {
                newItems.add(item);
            }
        }
        return newItems;
    }
}
