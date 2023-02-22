package Model;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int code;
    private String name;
    private double price;
    private int stock;
    private int stockMin;
    private int stockMax;
    private List<Tax> listTax = new ArrayList<Tax>();

    public Product(int code, String name, double price, int stock, int stockMin, int stockMax,
            List<Tax> listTax) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.listTax = listTax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void updateStock(int stock) {
        this.stock = this.stock + stock;
    }

    public void setStockMin(int stock) {
        this.stockMin = stock;
    }

    public void setStockMax(int stock) {
        this.stockMax = stock;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        if (this.listTax == null) {
            return this.price;
        } else {
            double totalTax = 0;
            for (Tax i : this.listTax) {
                if (i != null) {
                    totalTax = totalTax + i.value(this.price);
                }
            }
            double total = this.price + totalTax;
            return total;
        }
    }

    public int getStock() {
        return this.stock;
    }

    public int getStockMin() {
        return this.stockMin;
    }

    public int getStockMax() {
        return this.stockMax;
    }

    public int getCode() {
        return this.code;
    }
}
