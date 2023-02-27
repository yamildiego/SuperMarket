package Models;

import java.util.Date;
import java.util.List;

public class Sale {

    private List<Line> lines;
    private Date date;

    public Sale() {
    }

    public Sale(Date date, List<Line> listLines) {
        this.date = date;
        this.lines = listLines;
    }

    public double total() {
        double total = 0;
        for (Line o : lines) {
            total = total + o.subTotal();
        }
        return total;
    }

    void addLine(Product product, int qty) {
        Line line = new Line(product, qty);
        lines.add(line);
    }

    public Date getDate() {
        return date;
    }

    public Product getMaximumSubtotal() {
        double max = 0;
        Product aux = null;
        for (Line a : this.lines) {
            if (a.subTotal() > max) {
                max = max + a.subTotal();
                aux = a.getProduct();
            }
        }
        return aux;
    }

    public double getMaximumSubtotal(Product product) {
        double max = 0;
        for (Line a : this.lines) {
            if (a.getProduct().equals(product)) {
                max = max + a.subTotal();
            }
        }
        return max;
    }

    public int getQuantityProduct(Product product) {
        int max = 0;
        for (Line a : this.lines) {
            if (a.getProduct().equals(product)) {
                max = max + a.getQuantity();
            }
        }
        return max;
    }
}
