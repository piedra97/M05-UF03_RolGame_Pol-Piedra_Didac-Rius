package Models;

import java.util.ArrayList;
import java.util.List;

public class Merchant extends NPC {
    private List<ProductToSell> products;

    public Merchant(String name) {

        super(name);
        products = new ArrayList<>();
        for (ProductToSell product: ProductToSell.values()) {
            products.add(product);
        }
    }

    @Override
    public String appear() {

        return super.name + " has appeared!";
    }

    public boolean isBuyable(ProductToSell product) {
        for (ProductToSell n: products) {
            if (n.equals(product)) return true;
        }
        return false;
    }
}
