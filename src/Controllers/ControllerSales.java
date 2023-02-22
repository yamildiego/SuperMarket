package Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Line;
import Model.Product;
import Model.Sale;
import Model.Tax;

public class ControllerSales {

    private static ControllerSales instance;
    private List<Sale> listSales = new ArrayList<Sale>();

    public static ControllerSales getInstance() {

        if (ControllerSales.instance == null) {
            ControllerSales.instance = new ControllerSales();
        }
        return (ControllerSales.instance);
    }

    public void addSale(Date date, List<Line> listLineas) {
        Sale sale = new Sale(date, listLineas);
        this.listSales.add(sale);
    }

    public Line newLine(Product product, int quantity) {
        Line line = new Line(product, quantity);
        return line;
    }

    public double getTotal(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        double total = 0;
        for (Sale o : listSales) {
            if (format.format(o.getDate()).equals(format.format(date))) {
                total = total + o.total();
            }
        }
        return total;

    }

    void loadSales() {
        List<Tax> list = new ArrayList<Tax>();
        Product sugar = new Product(10, "Sugar", 5.9, 20, 25, 200, list);
        Product tea = new Product(11, "Tea", 4.2, 50, 40, 300, list);
        Line line_1 = new Line(sugar, 10);
        Line line_2 = new Line(tea, 100);
        List<Line> listLineas = new ArrayList<Line>();
        List<Line> listLineas2 = new ArrayList<Line>();
        listLineas.add(line_1);
        listLineas.add(line_2);
        listLineas2.add(line_2);
        this.addSale(new Date(), listLineas);
        this.addSale(new Date(), listLineas2);
    }

    public double getTotal(Date desde, Date hasta) {
        double total = 0;
        for (Sale o : listSales) {
            if ((o.getDate().getTime() >= desde.getTime()) && (o.getDate().getTime() <= hasta.getTime())) {
                total = total + o.total();
            }
        }
        return total;
    }

    public Product getIncomeByProduct(Date date) {
        Product aux = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        double max = 0;
        for (Sale o : listSales) {
            if (o != null) {
                if (format.format(o.getDate()).equals(format.format(date))) {
                    if ((o.getMaximumSubtotal(o.getMaximumSubtotal())) > max) {
                        aux = o.getMaximumSubtotal();
                        max = o.getMaximumSubtotal(aux);
                    }
                }
            }
        }
        return aux;
    }

    public void cancelSale(List<Line> listLineas) {
        for (Line i : listLineas) {
            ControllerProducts.getInstance().updateStock(i.getProduct(), i.getQuantity());
        }
    }

    public double getTotalIncomeByProduct(Date date) {
        Product aux = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        double max = 0;
        for (Sale o : listSales) {
            if (o != null) {
                if (format.format(o.getDate()).equals(format.format(date))) {
                    if ((o.getMaximumSubtotal(o.getMaximumSubtotal())) > max) {
                        aux = o.getMaximumSubtotal();
                        max = o.getMaximumSubtotal(aux);
                    }
                }
            }
        }
        return max;
    }

    public double getQuantityDeProduct(Date date) {
        Product productMaximum = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        double max = 0;
        for (Sale o : listSales) {
            if (o != null) {
                if (format.format(o.getDate()).equals(format.format(date))) {
                    if ((o.getMaximumSubtotal(o.getMaximumSubtotal())) > max) {
                        productMaximum = o.getMaximumSubtotal();
                        max = o.getQuantityProduct(productMaximum);
                    }
                }
            }
        }
        return max;
    }
}
