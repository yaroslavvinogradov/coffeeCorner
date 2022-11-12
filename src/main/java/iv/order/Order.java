package iv.order;

import iv.products.Product;
import iv.receipt.ReceiptPrinter;

import java.math.BigDecimal;
import java.util.List;

public interface Order {
    void add(Product item);
    List<Product> getProducts();
    void setProducts(List<Product> products);
    void addLoyaltyCard(int numberOfStamps, int maxStamps);
    int getNumberOfStamps();
    void setNumberOfStamps(int numberOfStamps);
    int getMaxStamps();
    void process();
    BigDecimal getTotalPrice();
    void print(ReceiptPrinter printer);
}
