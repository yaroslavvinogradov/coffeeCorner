package iv.pricelist;

import iv.products.CoffeeSize;
import iv.products.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PriceListImplTest {
    private PriceList uat;

    @BeforeEach
    void beforeEach() {
        uat = new PriceListImpl();
    }

    @Test
    void testCoffees() {
        Product coffee;

        coffee = uat.getCoffee(CoffeeSize.SMALL);
        assertEquals("Small Coffee", coffee.getName());
        assertEquals(new BigDecimal("2.50"), coffee.getPrice());
        assertTrue(coffee.isBeverage());
        assertFalse(coffee.isExtra());
        assertFalse(coffee.isSnack());

        coffee = uat.getCoffee(CoffeeSize.MEDIUM);
        assertEquals("Medium Coffee", coffee.getName());
        assertEquals(new BigDecimal("3.00"), coffee.getPrice());
        assertTrue(coffee.isBeverage());
        assertFalse(coffee.isExtra());
        assertFalse(coffee.isSnack());

        coffee = uat.getCoffee(CoffeeSize.LARGE);
        assertEquals("Large Coffee", coffee.getName());
        assertEquals(new BigDecimal("3.50"), coffee.getPrice());
        assertTrue(coffee.isBeverage());
        assertFalse(coffee.isExtra());
        assertFalse(coffee.isSnack());

        coffee = coffee.makeFree();
        assertEquals("Large Coffee", coffee.getName());
        assertEquals(BigDecimal.ZERO, coffee.getPrice());
        assertTrue(coffee.isBeverage());
        assertFalse(coffee.isExtra());
        assertFalse(coffee.isSnack());
    }

    @Test
    void testBaconRoll() {
        Product product = uat.getBaconRoll();

        assertEquals("Bacon Roll", product.getName());
        assertEquals(new BigDecimal("4.50"), product.getPrice());
        assertFalse(product.isBeverage());
        assertFalse(product.isExtra());
        assertTrue(product.isSnack());
    }

    @Test
    void testExtraMilk() {
        Product product = uat.getExtraMilk();

        assertEquals("Extra Milk", product.getName());
        assertEquals(new BigDecimal("0.30"), product.getPrice());
        assertFalse(product.isBeverage());
        assertTrue(product.isExtra());
        assertFalse(product.isSnack());

        product = product.makeFree();
        assertEquals("Extra Milk", product.getName());
        assertEquals(BigDecimal.ZERO, product.getPrice());
        assertFalse(product.isBeverage());
        assertTrue(product.isExtra());
        assertFalse(product.isSnack());

    }

    @Test
    void testFoamedMilk() {
        Product product = uat.getFoamedMilk();

        assertEquals("Foamed Milk", product.getName());
        assertEquals(new BigDecimal("0.50"), product.getPrice());
        assertFalse(product.isBeverage());
        assertTrue(product.isExtra());
        assertFalse(product.isSnack());

        product = product.makeFree();
        assertEquals("Foamed Milk", product.getName());
        assertEquals(BigDecimal.ZERO, product.getPrice());
        assertFalse(product.isBeverage());
        assertTrue(product.isExtra());
        assertFalse(product.isSnack());
    }

    @Test
    void testOrangeJuice() {
        Product product = uat.getOrangeJuice();

        assertEquals("Freshly squeezed orange juice", product.getName());
        assertEquals(new BigDecimal("3.95"), product.getPrice());
        assertFalse(product.isBeverage());
        assertFalse(product.isExtra());
        assertTrue(product.isSnack());

    }

    @Test
    void testSpecialRoastCoffee() {
        Product product = uat.getSpecialRoastCoffee();

        assertEquals("Special Roast Coffee", product.getName());
        assertEquals(new BigDecimal("0.90"), product.getPrice());
        assertFalse(product.isBeverage());
        assertTrue(product.isExtra());
        assertFalse(product.isSnack());

        product = product.makeFree();
        assertEquals("Special Roast Coffee", product.getName());
        assertEquals(BigDecimal.ZERO, product.getPrice());
        assertFalse(product.isBeverage());
        assertTrue(product.isExtra());
        assertFalse(product.isSnack());
    }
}