package ru.shop;

import ru.shop.model.Customer;
import ru.shop.model.Product;
import ru.shop.model.Sale;
import ru.shop.model.Shop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        System.out.println("\nСписок товаров:");
        for (Product product : shop.getProducts()) {
            System.out.println(product);
        }
        System.out.println("\nСписок покупателей:");
        Customer pavel = new Customer("Павел", 5000);
        Customer aleksey = new Customer("Алексей", 3000);
        System.out.println(pavel);
        System.out.println(aleksey);

        System.out.println("\nПокупки:");
        buy(pavel, shop.getProducts().get(2), shop);
        buy(aleksey, shop.getProducts().get(1), shop);
        shop.setSale(Sale.BLACK_FRIDAY);
        buy(aleksey, shop.getProducts().get(0), shop);
        buy(pavel, shop.getProducts().get(1), shop);
        shop.setSale(Sale.WITHOUT);
        buy(aleksey, shop.getProducts().get(0), shop);

        shop.watchPurschases();

    }

    private static void buy(Customer c, Product p, Shop shop) {
        System.out.println(shop.createBuy(c, p) + " Остаток " + c.getMoney());

    }
}
