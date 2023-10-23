package ch5;

import java.util.Vector;

public class ShoppingCart {
    private Vector<Article> cart;

    public static void main(String[] args) {
        var testingCart = new ShoppingCart();

//        test.add();
        testingCart.add(new Article(1, 15, 2));
        testingCart.add(new Article(2, 2.1, 10));
        testingCart.add(new Article(4, 2, 2));
        testingCart.add(new Article(2, 2.1, 10));

        System.out.println("Expected total: " + (30 + 21 + 4 + 21.0));
        System.out.println("Actual total: " + testingCart.orderValue());
    }
    public ShoppingCart() {
        this.cart  = new Vector<Article>(10);
    }

    public void add(Article article) {
        this.cart.add(article);
    }

    public double orderValue() {
        double total = 0.0;
        for (Article article: cart) {
            total += article.getPrice() * article.getQuantity();
        }

        return total;
    }
}
