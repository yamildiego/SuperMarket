package Controllers;

import java.util.ArrayList;
import java.util.List;

import Model.Product;
import Model.Tax;

public class ControllerProducts {

    private static ControllerProducts instance;
    private List<Product> listProducts = new ArrayList<Product>();

    public static ControllerProducts getInstance() {

        if (ControllerProducts.instance == null)
            ControllerProducts.instance = new ControllerProducts();

        return ControllerProducts.instance;
    }

    public ControllerProducts() {
    }

    public Product findProduct(int code) {
        Product aux = null;
        for (Product i : this.listProducts) {
            if (i != null) {
                if (i.getCode() == code) {
                    aux = i;
                }
            }
        }
        return aux;
    }

    public List<Product> listProducts() {
        return listProducts;
    }

    public List<Product> listProductsStockLowMinimum() {
        List<Product> listStockLowMin = new ArrayList<Product>();
        for (Product i : this.listProducts) {
            if (i != null) {
                if (i.getStock() <= i.getStockMin()) {
                    listStockLowMin.add(i);
                }
            }
        }
        return listStockLowMin;
    }

    public void loadProducts() {
        List<Tax> list = new ArrayList<Tax>();
        this.addProduct(10, "Sugar", 5.9, 20, 10, 200, list);
        this.addProduct(11, "Tea", 4.2, 50, 40, 300, list);
        this.addProduct(12, "Juice", 1.2, 1200, 1000, 5000, list);
        this.addProduct(13, "Biscuit", 8.6, 20, 60, 500, list);
        this.addProduct(14, "Milk", 6.6, 60, 40, 140, list);
        this.addProduct(15, "Coca Coca", 10, 100, 200, 400, list);
        this.addProduct(16, "Ginger Beer", 12, 100, 250, 800, list);

    }

    public void updateProduct(int code, int stockTotal) {
        for (Product i : this.listProducts) {
            if (i != null) {
                if (i.getCode() == code) {
                    i.setStock(stockTotal);
                }
            }
        }
    }

    public void updateStock(Product product, int quantity) {
        int indice = this.listProducts.indexOf(product);
        product.updateStock(quantity);
        this.listProducts.set(indice, product);
    }

    public void addProduct(int code, String name, double price, int stock, int stockMin, int stockMax,
            List<Tax> listTax) {
        Product product = new Product(code, name, price, stock, stockMin, stockMax, listTax);
        this.listProducts.add(product);
    }
}
