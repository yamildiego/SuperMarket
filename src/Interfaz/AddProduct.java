package Interfaz;

import Controllers.ControllerProducts;
import Controllers.ControllerSales;
import Model.Line;
import Model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class AddProduct extends javax.swing.JDialog {

    private Product product;
    private Line line;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    public AddProduct(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);

        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();

        actionMap.put(cancelName,
                new AbstractAction() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        doClose(RET_CANCEL);
                    }
                });
    }

    public Line getLine() {
        return this.line;
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        labelCode = new javax.swing.JLabel();
        labelQuantity = new javax.swing.JLabel();
        labelProduct = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();

        setTitle("Add product");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        labelCode.setText("Code");

        labelQuantity.setText("Quantity");

        labelProduct.setText("Product");

        error.setForeground(new java.awt.Color(255, 0, 0));

        code.setDocument(new LimitadorCaracteres());
        code.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codeFocusLost(evt);
            }
        });

        name.setEditable(false);
        name.setFocusable(false);

        quantity.setDocument(new LimitadorCaracteres());
        quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 228, Short.MAX_VALUE)
                                                .addComponent(btnAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(labelQuantity,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelProduct,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelCode,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(code)
                                                        .addComponent(name)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(quantity,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelCode)
                                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelProduct)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelQuantity)
                                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancel)
                                        .addComponent(btnAdd))
                                .addContainerGap()));

        getRootPane().setDefaultButton(btnAdd);

        pack();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String quantityText = this.quantity.getText();
        if (((this.product.getStock()) - (Integer.parseInt(quantityText))) < 0) {
            this.error.setText("Insufficient stock.");
        } else {
            this.error.setText(null);
            this.btnAdd.setEnabled(true);
            this.line = ControllerSales.getInstancia().newLine(this.product,
                    Integer.parseInt(this.quantity.getText()));
            this.doClose(RET_OK);
        }
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        doClose(RET_CANCEL);
    }

    private void closeDialog(java.awt.event.WindowEvent evt) {
        doClose(RET_CANCEL);
    }

    private void codeFocusLost(java.awt.event.FocusEvent evt) {
        if (this.code.getText() == null || this.code.getText().equals("")) {
            this.name.setText(null);
            this.error.setText("The code field is required.");
            this.btnAdd.setEnabled(false);
            return;
        }
        this.product = ControllerProducts.getInstancia().findProduct(Integer.parseInt(this.code.getText()));
        if (this.product == null) {
            this.name.setText(null);
            this.error.setText("No product found with the code entered.");
            this.btnAdd.setEnabled(false);
        } else {
            this.name.setText(product.getName());
            this.error.setText(null);
            this.btnAdd.setEnabled(true);
        }
    }

    private void quantityFocusLost(java.awt.event.FocusEvent evt) {
        if (this.quantity.getText() == null || this.quantity.getText().equals("")) {
            this.name.setText(null);
            this.error.setText("The quantity field is required.");
            this.error.setText(null);
            this.btnAdd.setEnabled(false);
            return;
        }
        this.btnAdd.setEnabled(true);

    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField code;
    private javax.swing.JLabel error;
    private javax.swing.JLabel labelQuantity;
    private javax.swing.JLabel labelCode;
    private javax.swing.JLabel labelProduct;
    private javax.swing.JTextField name;
    private int returnStatus = RET_CANCEL;
}
