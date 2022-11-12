package iv.order.loyalty;

import iv.order.Order;
import iv.products.*;
import iv.receipt.ReceiptPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyStrategyImplTest {

    private LoyaltyStrategyImpl uat;
    private final Order orderMock = new Order() {
        private List<Product> products = new ArrayList<>();
        private int numberOfStamps = 0;
        private int maxStamps = 3;

        @Override
        public void add(Product item) {
            this.products.add(item);
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
        public void process() {
        }

        @Override
        public BigDecimal getTotalPrice() {
            return BigDecimal.ZERO;
        }

        @Override
        public void print(ReceiptPrinter printer) {
        }
    };

    @BeforeEach
    void beforeEach() {
        uat = new LoyaltyStrategyImpl();
    }

    @Test
    void testFreeBeverage() {
        orderMock.add(new Coffee(CoffeeSize.SMALL, BigDecimal.ONE));
        orderMock.add(new Coffee(CoffeeSize.SMALL, BigDecimal.ONE));
        orderMock.add(new Coffee(CoffeeSize.SMALL, BigDecimal.ONE));
        orderMock.add(new Coffee(CoffeeSize.SMALL, BigDecimal.ONE));
        uat.process(orderMock);
        assertEquals(4, orderMock.getProducts().size());
        assertEquals(BigDecimal.ONE, orderMock.getProducts().get(0).getPrice());
        assertEquals(BigDecimal.ONE, orderMock.getProducts().get(1).getPrice());
        assertEquals(BigDecimal.ZERO, orderMock.getProducts().get(2).getPrice());
        assertEquals(BigDecimal.ONE, orderMock.getProducts().get(3).getPrice());
        assertEquals(1, orderMock.getNumberOfStamps());
    }

    @Test
    void testFreeExtraWithSnack() {
        orderMock.add(new Coffee(CoffeeSize.SMALL, BigDecimal.ONE));
        orderMock.add(new FoamedMilk(BigDecimal.ONE));
        orderMock.add(new BaconRoll(BigDecimal.ONE));
        uat.process(orderMock);
        assertEquals(3, orderMock.getProducts().size());
        assertEquals(new FoamedMilk(BigDecimal.ZERO), orderMock.getProducts().get(1));
    }
}