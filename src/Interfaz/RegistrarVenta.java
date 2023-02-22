package Interfaz;

import Controllers.ControllerProducts;
import Controllers.ControllerSales;
import Model.Line;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class RegistrarVenta extends javax.swing.JDialog {

    private ModeloTablaVenta modelo;
    private double importeTotal = 0;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    public RegistrarVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.modelo = new ModeloTablaVenta();
        initComponents();
        String patron = "dd/MM/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(patron);
        this.date.setText(format.format(new Date()));
        this.importe.setText(String.valueOf(this.importeTotal));
        this.tablaLines.getTableHeader().setReorderingAllowed(false);
        this.setLocationRelativeTo(parent);

        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(RegistrarVenta.this, "¿Seguro desea btnCancel la sale?",
                        "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (JOptionPane.YES_OPTION == opcion) {
                    ControllerSales.getInstancia().cancelSale(RegistrarVenta.this.modelo.devolverLista());
                    doClose(RET_CANCEL);
                }
            }
        });
    }

    private void actualizarImporte(double valor) {
        this.importeTotal += valor;
        this.importe.setText(String.valueOf(this.importeTotal));
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    private void initComponents() {

        aceptar = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        labelFecha = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLines = new javax.swing.JTable();
        labelImporte = new javax.swing.JLabel();
        importe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registrar sale");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        agregar.setText("Add");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        labelFecha.setText("Fecha de caja");

        date.setEditable(false);
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tablaLines.setModel(this.modelo);
        jScrollPane1.setViewportView(tablaLines);

        labelImporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelImporte.setText("Importe total:");

        importe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(agregar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(eliminar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelFecha)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(labelImporte)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(importe, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        175, Short.MAX_VALUE)
                                                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancel)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(agregar)
                                        .addComponent(eliminar)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(importe, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelImporte)))
                                .addContainerGap()));

        getRootPane().setDefaultButton(aceptar);

        pack();
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
        ControllerSales.getInstancia().addSale(new Date(), this.modelo.devolverLista());
        doClose(RET_OK);
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro desea btnCancel la sale?", "Advertencia",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.YES_OPTION == opcion) {
            ControllerSales.getInstancia().cancelSale(this.modelo.devolverLista());
            doClose(RET_CANCEL);
        }
    }

    private void closeDialog(java.awt.event.WindowEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro desea btnCancel la sale?", "Advertencia",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.YES_OPTION == opcion) {
            ControllerSales.getInstancia().cancelSale(this.modelo.devolverLista());
            doClose(RET_CANCEL);
        }
    }

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {
        AddProduct agregarProduct = new AddProduct(this, true);
        agregarProduct.setVisible(true);
        Line line = agregarProduct.getLine();
        if (line != null) {
            this.modelo.agregar(line);
            ControllerProducts.getInstancia().updateStock(line.getProduct(), line.getQuantity() * -1);
            this.actualizarImporte(line.subTotal());
        }
        agregarProduct.dispose();
    }

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.tablaLines.getSelectedRow() != -1) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro desea quitar el product?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (JOptionPane.YES_OPTION == opcion) {
                Line line = (Line) this.modelo.devolver(this.tablaLines.getSelectedRow());
                this.modelo.quitar(line);
                ControllerProducts.getInstancia().updateStock(line.getProduct(), line.getQuantity());
                this.actualizarImporte(line.subTotal() * -1);
            }
        }
    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    private javax.swing.JButton aceptar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField date;
    private javax.swing.JLabel importe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelImporte;
    private javax.swing.JTable tablaLines;
    private int returnStatus = RET_CANCEL;
}
