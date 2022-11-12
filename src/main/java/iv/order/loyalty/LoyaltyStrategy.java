package iv.order.loyalty;

import iv.order.Order;
import iv.products.Product;

import java.util.List;

public interface LoyaltyStrategy {
   void process(Order order);
}
