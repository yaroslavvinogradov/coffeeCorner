package iv.pricelist;

import iv.products.*;

public interface PriceList {
    Product getCoffee(CoffeeSize size);
    Product getBaconRoll();
    Product getExtraMilk();
    Product getFoamedMilk();
    Product getOrangeJuice();
    Product getSpecialRoastCoffee();
}
