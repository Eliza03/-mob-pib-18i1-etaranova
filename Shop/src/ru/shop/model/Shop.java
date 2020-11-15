package ru.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Product> products = new ArrayList<>();
    private final List<Buy> purchases = new ArrayList<>();
    private Sale sale = Sale.WITHOUT;

    public Shop() {
        products.add(new Product("Футболка", 500));
        products.add(new Product("Джинсы", 1600));
        products.add(new Product("Кросовки", 2500));
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Buy> getPurchases() {
        return purchases;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Buy createBuy(Customer c, Product p) {
        if (c.score == 3) {
            c.setRegular(true);
        }
        Buy buy = new Buy(c, p, sale);
        purchases.add(buy);
        c.score += 1;
        return buy;
    }

    public void watchPurschases() {
        System.out.println("\nПокупатели:");
        for (Buy buy : getPurchases()) {
            System.out.println(buy);
        }
    }
}

