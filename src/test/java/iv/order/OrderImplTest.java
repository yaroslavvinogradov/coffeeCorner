package iv.order;

import iv.order.loyalty.LoyaltyStrategy;
import iv.products.BaconRoll;
import iv.products.Coffee;
import iv.products.CoffeeSize;
import iv.products.Product;
import iv.receipt.ReceiptPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderImplTest {
    private Order uat;
    private boolean strategyCalled;
    private final Product coffeeMock = new Coffee(CoffeeSize.SMALL, new BigDecimal("1.0"));

    private LoyaltyStrategy getLoyaltyMock() {
        return order -> strategyCalled = true;
    }

    @BeforeEach
    void setUp() {
        strategyCalled = false;
        uat = new OrderImpl(getLoyaltyMock());

    }

    @Test
    void testLoyaltyStrategyAndProcess() {
        uat.add(coffeeMock);
        uat.addLoyaltyCard(2, 3);
        assertEquals(2, uat.getNumberOfStamps());
        assertEquals(3, uat.getMaxStamps());
        uat.process();
        assertTrue(strategyCalled);
        assertEquals(new BigDecimal("1.0").toPlainString(), uat.getTotalPrice().toPlainString());
    }

    @Test
    void testAddingProducts() {
        uat.add(coffeeMock);
        uat.add(coffeeMock.makeFree());
        List<Product> productList = uat.getProducts();
        assertEquals(2, productList.size());
        assertEquals(coffeeMock, productList.get(0));
        assertEquals(coffeeMock.makeFree(), productList.get(1));
    }

    @Test
    void testGetTotalPrice() {
        Product p1 = new Coffee(CoffeeSize.SMALL, new BigDecimal("1.2"));
        Product p2 = new Coffee(CoffeeSize.SMALL, new BigDecimal("2.1"));
        uat.add(p1);
        uat.add(p2);
        uat.process();

        BigDecimal total = uat.getTotalPrice();
        assertEquals(new BigDecimal("3.3").toPlainString(), total.toPlainString());
    }

    @Test
    void testPrinting() {
        List<String> lines = new ArrayList<>();
        ReceiptPrinter printer = line -> lines.add(line);

        Product p1 = new Coffee(CoffeeSize.SMALL, new BigDecimal("2.20"));
        Product p2 = new BaconRoll(new BigDecimal("3.50"));
        uat.add(p1);
        uat.add(p2);

        uat.print(printer);

        assertEquals(4, lines.size());
        assertEquals("Small Coffee 2.20 CHF", lines.get(0));
        assertEquals("Bacon Roll 3.50 CHF", lines.get(1));
        assertEquals("Total 5.70 CHF", lines.get(2));
        assertEquals("Loyalty card with 0 stamp returned", lines.get(3));

    }
}