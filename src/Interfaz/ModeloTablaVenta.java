/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import Model.Line;

/**
 *
 * @author Yamil
 */
public class ModeloTablaVenta extends AbstractTableModel {

    private String[] columnas = { "Code", "Name", "Quantity", "Price" };
    private ArrayList<Line> rows = new ArrayList<Line>();

    public ModeloTablaVenta(ArrayList<Line> list) {
        this.rows.addAll(list);
        fireTableDataChanged();
    }

    public ModeloTablaVenta() {
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
                return double.class;
            default:
                return Object.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Line line = (Line) this.rows.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return line.getProduct().getCode();
            case 1:
                return line.getProduct().getName();
            case 2:
                return line.getQuantity();
            case 3:
                return line.subTotal();
        }
        return line;
    }

    public void agregar(Line line) {
        this.rows.add(line);
        fireTableDataChanged();
    }

    public void quitar(Line line) {
        this.rows.remove(line);
        fireTableDataChanged();
    }

    public Object devolver(int rowIndex) {
        return this.rows.get(rowIndex);
    }

    public ArrayList<Line> devolverLista() {
        return this.rows;
    }

    public void modificar(Line oldLine, Line newLine) {
        this.rows.remove(oldLine);
        this.rows.add(newLine);
        fireTableDataChanged();
    }
}
