package iv.order.builder;

import iv.order.Order;
import iv.pricelist.PriceList;
import iv.products.CoffeeSize;

public class OrderBuilderImpl implements OrderBuilder {
    private final PriceList priceList;

    private final Order order;

    public OrderBuilderImpl(PriceList priceList, Order emptyOrder) {
        this.priceList = priceList;
        this.order = emptyOrder;
    }

    @Override
    public OrderBuilder addCoffee(CoffeeSize size) {
        order.add(priceList.getCoffee(size));
        return this;
    }

    @Override
    public OrderBuilder addCoffeeWithExtraMilk(CoffeeSize size) {
        order.add(priceList.getCoffee(size));
        order.add(priceList.getExtraMilk());
        return this;
    }

    @Override
    public OrderBuilder addCoffeeWithFoamedMilk(CoffeeSize size) {
        order.add(priceList.getCoffee(size));
        order.add(priceList.getFoamedMilk());
        return this;
    }

    @Override
    public OrderBuilder addSpecialRoastCoffee(CoffeeSize size) {
        order.add(priceList.getCoffee(size));
        order.add(priceList.getSpecialRoastCoffee());
        return this;
    }

    @Override
    public OrderBuilder addBaconRoll() {
        order.add(priceList.getBaconRoll());
        return this;
    }

    @Override
    public OrderBuilder addOrangeJuice() {
        order.add(priceList.getOrangeJuice());
        return this;
    }

    @Override
    public Order build() {
        return order;
    }
}
