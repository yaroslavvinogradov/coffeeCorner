package iv.products;

import java.math.BigDecimal;
import java.util.Objects;

public class ExtraMilk implements Product {
    private static final  String NAME = "Extra Milk";

    private final BigDecimal price;

    public ExtraMilk(BigDecimal price) {
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
        return new ExtraMilk(BigDecimal.ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraMilk extraMilk = (ExtraMilk) o;
        return Objects.equals(price, extraMilk.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
