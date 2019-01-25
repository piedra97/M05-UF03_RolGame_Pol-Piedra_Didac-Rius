package Models;

import java.util.List;

public class Merchant extends NPC {
    private List<ProductToSell> products;

    public Merchant(String name) {
        super(name);
    }

    @Override
    public String appear() {
        return null;
    }

    public boolean isBuyable(ProductToSell product) {
        for (ProductToSell n: products) {
            if (n.equals(product)) return true;
        }
        return false;
    }
}
