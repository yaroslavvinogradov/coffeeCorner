package iv.products;

import java.math.BigDecimal;
import java.util.Objects;

public class OrangeJuice implements Product {
    private static final String NAME = "Freshly squeezed orange juice";

    private final BigDecimal price;

    public OrangeJuice(BigDecimal price) {
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
        return false;
    }

    @Override
    public boolean isBeverage() {
        return false;
    }

    @Override
    public boolean isSnack() {
        return true;
    }

    @Override
    public Product makeFree() {
        return new OrangeJuice(BigDecimal.ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrangeJuice that = (OrangeJuice) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
