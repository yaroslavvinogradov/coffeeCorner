package iv.order.builder;

import iv.order.Order;
import iv.products.CoffeeSize;

public interface OrderBuilder {
    OrderBuilder addCoffee(CoffeeSize size);
    OrderBuilder addCoffeeWithExtraMilk(CoffeeSize size);
    OrderBuilder addCoffeeWithFoamedMilk(CoffeeSize size);
    OrderBuilder addSpecialRoastCoffee(CoffeeSize size);
    OrderBuilder addBaconRoll();
    OrderBuilder addOrangeJuice();
    Order build();
}
