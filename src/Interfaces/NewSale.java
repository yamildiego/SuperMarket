package Interfaces;

import Controllers.ControllerProducts;
import Controllers.ControllerSales;
import Models.Line;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class NewSale extends javax.swing.JDialog {

    private ModelTableSale modelo;
    private double totalTotal = 0;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    public NewSale(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.modelo = new ModelTableSale();
        initComponents();
        String patron = "dd/MM/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(patron);
        this.date.setText(format.format(new Date()));
        this.total.setText(String.valueOf(this.totalTotal));
        this.tablaLines.getTableHeader().setReorderingAllowed(false);
        this.setLocationRelativeTo(parent);

        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(NewSale.this, "Are you sure you want to cancel the sale?",
                        "Attention", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (JOptionPane.YES_OPTION == opcion) {
                    ControllerSales.getInstance().cancelSale(NewSale.this.modelo.devolverLista());
                    doClose(RET_CANCEL);
                }
            }
        });
    }

    private void actualizartotal(double valor) {
        this.totalTotal += valor;
        this.total.setText(String.valueOf(this.totalTotal));
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    private void initComponents() {

        btnAccept = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        labelDate = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        panel = new javax.swing.JScrollPane();
        tablaLines = new javax.swing.JTable();
        labelTotal = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("New Sale");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        labelDate.setText("Date");

        date.setEditable(false);
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tablaLines.setModel(this.modelo);
        panel.setViewportView(tablaLines);

        labelTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTotal.setText("Total:");

        total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panel)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelDate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(labelTotal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        175, Short.MAX_VALUE)
                                                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancel)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd)
                                        .addComponent(btnDelete)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelDate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelTotal)))
                                .addContainerGap()));

        getRootPane().setDefaultButton(btnAccept);

        pack();
    }

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {
        ControllerSales.getInstance().addSale(new Date(), this.modelo.devolverLista());
        doClose(RET_OK);
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel the sale?", "Attention",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.YES_OPTION == opcion) {
            ControllerSales.getInstance().cancelSale(this.modelo.devolverLista());
            doClose(RET_CANCEL);
        }
    }

    private void closeDialog(java.awt.event.WindowEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel the sale?", "Attention",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.YES_OPTION == opcion) {
            ControllerSales.getInstance().cancelSale(this.modelo.devolverLista());
            doClose(RET_CANCEL);
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        AddProduct btnAddProduct = new AddProduct(this, true);
        btnAddProduct.setVisible(true);
        Line line = btnAddProduct.getLine();
        if (line != null) {
            this.modelo.add(line);
            ControllerProducts.getInstance().updateStock(line.getProduct(), line.getQuantity() * -1);
            this.actualizartotal(line.subTotal());
        }
        btnAddProduct.dispose();
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.tablaLines.getSelectedRow() != -1) {
            int opcion = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove the product?",
                    "Attention",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (JOptionPane.YES_OPTION == opcion) {
                Line line = (Line) this.modelo.get(this.tablaLines.getSelectedRow());
                this.modelo.remove(line);
                ControllerProducts.getInstance().updateStock(line.getProduct(), line.getQuantity());
                this.actualizartotal(line.subTotal() * -1);
            }
        }
    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField date;
    private javax.swing.JLabel total;
    private javax.swing.JScrollPane panel;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tablaLines;
    private int returnStatus = RET_CANCEL;
}
