package iv.order.builder;

import iv.order.Order;
import iv.pricelist.PriceList;
import iv.products.*;
import iv.receipt.ReceiptPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderBuilderImplTest {

    private OrderBuilder uat;
    private List<Product> productsMock;

    private final Product coffeeMock = new Coffee(CoffeeSize.SMALL, new BigDecimal("1.0"));
    private final Product baconRollMock = new BaconRoll(new BigDecimal("1.0"));
    private final Product extraMilkMock = new ExtraMilk(new BigDecimal("1.0"));
    private final Product foamedMilkMock = new FoamedMilk(new BigDecimal("1.0"));
    private final Product orangeJuiceMock = new OrangeJuice(new BigDecimal("1.0"));
    private final Product specialRoastCoffeeMock = new SpecialRoastCoffee(new BigDecimal("1.0"));

    private final PriceList priceListMock = new PriceList() {
        @Override
        public Product getCoffee(CoffeeSize size) {
            return coffeeMock;
        }

        @Override
        public Product getBaconRoll() {
            return baconRollMock;
        }

        @Override
        public Product getExtraMilk() {
            return extraMilkMock;
        }

        @Override
        public Product getFoamedMilk() {
            return foamedMilkMock;
        }

        @Override
        public Product getOrangeJuice() {
            return orangeJuiceMock;
        }

        @Override
        public Product getSpecialRoastCoffee() {
            return specialRoastCoffeeMock;
        }
    };

    private final Order orderMock = new Order() {
        @Override
        public void add(Product item) {
            productsMock.add(item);
        }

        @Override
        public List<Product> getProducts() {
            return productsMock;
        }

        @Override
        public void setProducts(List<Product> products) {

        }

        @Override
        public void addLoyaltyCard(int numberOfStamps, int maxStamps) {

        }

        @Override
        public int getNumberOfStamps() {
            return 0;
        }

        @Override
        public void setNumberOfStamps(int numberOfStamps) {}

        @Override
        public int getMaxStamps() {
            return 0;
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
    void setUp() {
        productsMock = new ArrayList<>();
        uat = new OrderBuilderImpl(priceListMock, orderMock);
    }

    @Test
    void testAddCoffee() {
        Order result = uat.addCoffee(CoffeeSize.SMALL).build();
        assertEquals(orderMock, result);
        assertEquals(1, productsMock.size());
        assertEquals(coffeeMock, productsMock.get(0));
    }

    @Test
    void testAddCoffeeWithExtraMilk() {
        Order result = uat.addCoffeeWithExtraMilk(CoffeeSize.SMALL).build();
        assertEquals(orderMock, result);
        assertEquals(2, productsMock.size());
        assertEquals(coffeeMock, productsMock.get(0));
        assertEquals(extraMilkMock, productsMock.get(1));
    }

    @Test
    void testAddCoffeeWithFoamedMilk() {
        Order result = uat.addCoffeeWithFoamedMilk(CoffeeSize.SMALL).build();
        assertEquals(orderMock, result);
        assertEquals(2, productsMock.size());
        assertEquals(coffeeMock, productsMock.get(0));
        assertEquals(foamedMilkMock, productsMock.get(1));
    }

    @Test
    void testAddSpecialRoastCoffee() {
        Order result = uat.addSpecialRoastCoffee(CoffeeSize.SMALL).build();
        assertEquals(orderMock, result);
        assertEquals(2, productsMock.size());
        assertEquals(coffeeMock, productsMock.get(0));
        assertEquals(specialRoastCoffeeMock, productsMock.get(1));
    }

    @Test
    void testAddBaconRoll() {
        Order result = uat.addBaconRoll().build();
        assertEquals(orderMock, result);
        assertEquals(1, productsMock.size());
        assertEquals(baconRollMock, productsMock.get(0));
    }

    @Test
    void testAddOrangeJuice() {
        Order result = uat.addOrangeJuice().build();
        assertEquals(orderMock, result);
        assertEquals(1, productsMock.size());
        assertEquals(orangeJuiceMock, productsMock.get(0));
    }

}