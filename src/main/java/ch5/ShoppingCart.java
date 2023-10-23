package ch5;

import java.util.Vector;

public class ShoppingCart {
    private Vector<Article> cart;

    public static void main(String[] args) {

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
