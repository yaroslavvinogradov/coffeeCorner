package iv.pricelist;

import iv.products.*;

import java.math.BigDecimal;

public class PriceListImpl implements PriceList {
    @Override
    public Product getCoffee(CoffeeSize size) {
        switch (size) {
            case SMALL:
                return new Coffee(CoffeeSize.SMALL, new BigDecimal("2.50"));
            case MEDIUM:
                return new Coffee(CoffeeSize.MEDIUM, new BigDecimal("3.00"));
            case LARGE:
                return new Coffee(CoffeeSize.LARGE, new BigDecimal("3.50"));
        }
        throw new IllegalArgumentException("Wrong coffee size");
    }

    @Override
    public Product getBaconRoll() {
        return new BaconRoll(new BigDecimal("4.50"));
    }

    @Override
    public Product getExtraMilk() {
        return new ExtraMilk(new BigDecimal("0.30"));
    }

    @Override
    public Product getFoamedMilk() {
        return new FoamedMilk(new BigDecimal("0.50"));
    }

    @Override
    public Product getOrangeJuice() {
        return new OrangeJuice(new BigDecimal("3.95"));
    }

    @Override
    public Product getSpecialRoastCoffee() {
        return new SpecialRoastCoffee(new BigDecimal("0.90"));
    }
}
