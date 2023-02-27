package Models;

public class Line {

    private int qty;
    private Product product;

    public Line(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public double subTotal() {
        return (this.qty * product.getPrice());
    }

    public int getQuantity() {
        return this.qty;
    }

    public Product getProduct() {
        return this.product;
    }
}
