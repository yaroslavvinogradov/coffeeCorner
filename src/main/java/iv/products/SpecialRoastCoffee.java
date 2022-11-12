package iv.products;

import java.math.BigDecimal;
import java.util.Objects;

public class SpecialRoastCoffee implements Product {
    private static final String NAME = "Special Roast Coffee";

    private final BigDecimal price;

    public SpecialRoastCoffee(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean isExtra() {
        return true;
    }

    @Override
    public boolean isBeverage() {
        return false;
    }

    @Override
    public boolean isSnack() {
        return false;
    }

    @Override
    public Product makeFree() {
        return new SpecialRoastCoffee(BigDecimal.ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialRoastCoffee that = (SpecialRoastCoffee) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
