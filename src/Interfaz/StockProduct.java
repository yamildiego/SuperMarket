package Interfaz;

import Controllers.ControllerProducts;
import Model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class StockProduct extends javax.swing.JDialog {

    Product product = null;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    public StockProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    private void initComponents() {
        btnAccept = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        code = new javax.swing.JTextField();
        nombreProduct = new javax.swing.JTextField();
        stockActual = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        labelError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Actualizar stock");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btnAccept.setText("Aceptar");
        btnAccept.setEnabled(false);
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

        code.setDocument(new CharacterLimiter());
        code.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codeFocusLost(evt);
            }
        });

        nombreProduct.setEditable(false);
        nombreProduct.setEnabled(false);
        nombreProduct.setFocusable(false);
        nombreProduct.setRequestFocusEnabled(false);

        stockActual.setEditable(false);
        stockActual.setEnabled(false);
        stockActual.setFocusable(false);
        stockActual.setRequestFocusEnabled(false);

        stock.setDocument(new CharacterLimiter());

        labelError.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setText("Código de barras");

        jLabel2.setText("Stock actual");

        jLabel3.setText("Stock entrante");

        jLabel4.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnAccept)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancel))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(code))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3))
                                                .addGap(29, 29, 29)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(stock,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                100, Short.MAX_VALUE)
                                                                        .addComponent(stockActual))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(nombreProduct)))
                                        .addComponent(labelError, javax.swing.GroupLayout.DEFAULT_SIZE, 380,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(nombreProduct, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(stockActual,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 45, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnCancel)
                                                        .addComponent(btnAccept))
                                                .addContainerGap()))));

        getRootPane().setDefaultButton(btnAccept);
        btnAccept.getAccessibleContext().setAccessibleDescription("");

        pack();
    }

    private void closeDialog(java.awt.event.WindowEvent evt) {
        doClose(RET_CANCEL);
    }

    private void codeFocusLost(java.awt.event.FocusEvent evt) {
        if (this.code.getText() == null || this.code.getText().equals("")) {
            this.nombreProduct.setText(null);
            this.labelError.setText("El campo código es requerido.");
            this.btnAccept.setEnabled(false);
            return;
        }
        String codeText = this.code.getText();
        if (codeText.equals("")) {
            this.labelError.setText("El campo Codigo es requerido");
            this.btnAccept.setEnabled(false);
            return;
        }
        int code = Integer.parseInt(codeText);
        this.product = ControllerProducts.getInstance().findProduct(code);
        if ((this.product == null)) {
            this.labelError.setText("No se encontro un Product con el code indicado.");
            this.btnAccept.setEnabled(false);
            return;
        } else {
            this.btnAccept.setEnabled(true);
            this.stockActual.setText(this.product.getStock() + "");
            this.nombreProduct.setText(this.product.getName());
        }
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        doClose(RET_CANCEL);
    }

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String codeText = this.code.getText();
            String stockText = this.stock.getText();
            String stockActualText = this.stockActual.getText();
            int code = Integer.parseInt(codeText);
            int stock = Integer.parseInt(stockText);
            int stockActual = Integer.parseInt(stockActualText);
            this.product = ControllerProducts.getInstance().findProduct(code);
            if ((this.product == null)) {
                this.labelError.setText("No se encontro un Product con el code indicado.");
            } else {
                if (stock <= 0) {
                    this.labelError.setText("El campo Stock Entrante debe ser mayor a 0.");
                    return;
                }
                if ((this.product.getStockMax() - stock - stockActual) < 0) {
                    this.labelError.setText("El campo Stock Entrante mas el Stock Actual superan el stock permitido.");
                    return;
                } else {
                    ControllerProducts.getInstance().updateProduct(code, stock + stockActual);
                }
                doClose(RET_CANCEL);
            }
            if (stockText.equals("")) {
                this.labelError.setText("El campo Stock Entrante es requerido");
            }
            if (codeText.equals("")) {
                this.labelError.setText("El campo Codigo es requerido");
            }
        } catch (NumberFormatException nfe) {
            this.labelError.setText("Supera el maximo permitido.");
        }

    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCancel;
    private javax.swing.JTextField code;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelError;
    private javax.swing.JTextField nombreProduct;
    private javax.swing.JTextField stock;
    private javax.swing.JTextField stockActual;
    private int returnStatus = RET_CANCEL;
}
