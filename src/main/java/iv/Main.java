package iv;

import iv.order.builder.OrderBuilder;
import iv.order.builder.OrderBuilderImpl;
import iv.order.loyalty.LoyaltyStrategy;
import iv.order.loyalty.LoyaltyStrategyImpl;
import iv.pricelist.PriceList;
import iv.pricelist.PriceListImpl;
import iv.products.CoffeeSize;
import iv.order.*;
import iv.receipt.ReceiptPrinter;
import iv.receipt.ReceiptPrinterImpl;

public class Main {
    public static void main(String[] args) {
        ReceiptPrinter printer = new ReceiptPrinterImpl();
        PriceList priceList = new PriceListImpl();
        LoyaltyStrategy loyaltyStrategy = new LoyaltyStrategyImpl();
        OrderBuilder builder = new OrderBuilderImpl(priceList, new OrderImpl(loyaltyStrategy));

        Order order = builder.addCoffee(CoffeeSize.LARGE)
            .addCoffee(CoffeeSize.SMALL)
            .addCoffeeWithExtraMilk(CoffeeSize.MEDIUM)
            .addOrangeJuice()
            .addBaconRoll().build();

        order.addLoyaltyCard(0, 5);

        order.process();
        order.print(printer);
    }
}