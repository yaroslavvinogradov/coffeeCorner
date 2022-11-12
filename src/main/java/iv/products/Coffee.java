package iv.products;

import java.math.BigDecimal;
import java.util.Objects;

public class Coffee implements Product {
    private static final String NAME = "Coffee";
    private final CoffeeSize size;
    private final BigDecimal price;

    public Coffee(CoffeeSize size, BigDecimal price) {
        this.size = size;
        this.price = price;
    }

    @Override
    public String getName() {
        return size.getName() + " " + NAME;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean isExtra() {
        return false;
    }

    @Override
    public boolean isBeverage() {
        return true;
    }

    @Override
    public boolean isSnack() {
        return false;
    }

    @Override
    public Product makeFree() {
        return new Coffee(this.size, BigDecimal.ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return size == coffee.size && Objects.equals(price, coffee.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, price);
    }
}
