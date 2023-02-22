package Interfaz;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import Model.Product;

/**
 *
 * @author Yamil
 */
public class ModelTableProduct extends AbstractTableModel {

    private String[] columnas = { "Code", "Name", "Minimum stock", "Stock", "Price" };
    private ArrayList<Product> rows = new ArrayList<Product>();

    public ModelTableProduct(ArrayList<Product> list) {
        this.rows.addAll(list);
        fireTableDataChanged();
    }

    public ModelTableProduct() {
    }

    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.columnas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            case 1:
                return String.class;
            case 2:
                return int.class;
            case 3:
                return int.class;
            case 4:
                return double.class;
            default:
                return Object.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = (Product) this.rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getCode();
            case 1:
                return product.getName();
            case 2:
                return product.getStockMin();
            case 3:
                return product.getStock();
            case 4:
                return product.getPrice();
        }
        return product;
    }

    public void add(Product product) {
        this.rows.add(product);
        fireTableDataChanged();
    }

    public void remove(Product product) {
        this.rows.remove(product);
        fireTableDataChanged();
    }

    public Object get(int rowIndex) {
        return this.rows.get(rowIndex);
    }

    public void edit(Product productViejo, Product productNuevo) {
        this.rows.remove(productViejo);
        this.rows.add(productNuevo);
        fireTableDataChanged();

    }
}
