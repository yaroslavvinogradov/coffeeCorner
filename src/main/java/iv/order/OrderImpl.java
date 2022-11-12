package iv.order;

import iv.order.loyalty.LoyaltyStrategy;
import iv.products.Product;
import iv.receipt.ReceiptPrinter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements Order {
    private int maxStamps;

    private List<Product> products;
    private int numberOfStamps;
    private BigDecimal totalPrice;
    private boolean processed;
    private final LoyaltyStrategy loyaltyStrategy;

    public OrderImpl(LoyaltyStrategy loyaltyStrategy) {
        this.maxStamps = 0;
        this.numberOfStamps = 0;
        this.products = new ArrayList<>();
        this.processed = false;
        this.totalPrice = BigDecimal.ZERO;
        this.loyaltyStrategy = loyaltyStrategy;
    }

    @Override
    public void addLoyaltyCard(int numberOfStamps, int maxStamps) {
        this.numberOfStamps = numberOfStamps;
        this.maxStamps = maxStamps;
    }

    @Override
    public int getNumberOfStamps() {
        return numberOfStamps;
    }

    @Override
    public void setNumberOfStamps(int numberOfStamps) {
        this.numberOfStamps = numberOfStamps;
    }

    @Override
    public int getMaxStamps() {
        return maxStamps;
    }

    @Override
    public void add(Product item) {
        products.add(item);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void process() {
        if (processed) {
            return;
        }
        processed = true;
        if (loyaltyStrategy != null) {
            loyaltyStrategy.process(this);
        }
        this.products.forEach(item -> this.totalPrice = this.totalPrice.add(item.getPrice()));
    }

    @Override
    public void print(ReceiptPrinter printer) {
        if (!processed) {
            process();
        }
        this.products.forEach(item -> printer.printLine(item.getName() + " " + item.getPrice().toPlainString() + " CHF"));
        printer.printLine("Total " + getTotalPrice().toPlainString() + " CHF");
        printer.printLine("Loyalty card with " + numberOfStamps + " stamp returned");
    }
}
