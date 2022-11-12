package iv.products;

import java.math.BigDecimal;
import java.util.Objects;

public class BaconRoll implements Product {
    private static final String NAME = "Bacon Roll";

    private final BigDecimal price;

    public BaconRoll(BigDecimal price) {
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
        return new BaconRoll(BigDecimal.ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaconRoll baconRoll = (BaconRoll) o;
        return Objects.equals(price, baconRoll.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
