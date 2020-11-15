package ru.shop.model;

public class Buy {
    private final Customer customer;
    private final Product product;
    private final double finalPrice;


    private static double calcFinalPrice(Customer customer, Product product, Sale sale) {
        double price = product.getPrice();
        if (sale == Sale.BLACK_FRIDAY)
            price = price * 0.5;
        else if (customer.isRegular())
            price = price * 0.8;
        return price;
    }

    public Buy(Customer customer, Product product, Sale sale) {
        this.customer = customer;
        this.product = product;

        this.finalPrice = calcFinalPrice(customer, product, sale);

        customer.setMoney(customer.getMoney() - finalPrice);
    }


    @Override
    public String toString() {
        return customer.getName() +
                " купил товар " + product.getName() +
                " по цене " + product.getPrice();
    }
}
