package iv.products;

import java.math.BigDecimal;

public interface Product {
    String getName();
    BigDecimal getPrice();
    boolean isExtra();
    boolean isBeverage();
    boolean isSnack();
    Product makeFree();
}

