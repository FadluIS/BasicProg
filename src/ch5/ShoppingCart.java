package ch5;

import java.util.Vector;

public class ShoppingCart {
    Vector<Article> cart = new Vector<>();

    public static void main(String[] args) {
        ShoppingCart test = new ShoppingCart();

        test.add(new Article(1, 15, 2));
        test.add(new Article(2, 2.1, 10));
        test.add(new Article(4, 2, 2));
        test.add(new Article(2, 2.1, 10));

        System.out.println("Expected total: " + (30 + 21 + 4 + 21.0));
        System.out.println("Actual total: " + test.orderValue());
    }

    public ShoppingCart() {
    }

    public void add(Article article) {
        cart.add(article);
    }

    public double orderValue() {
        double total = 0.0;
        for (Article article: cart) {
            total += article.getPrice() * article.getQuantity();
        }

        return total;
    }
}
