package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import Controllers.ControllerProducts;
import Model.Product;

public class ListProductsStockMinimum extends javax.swing.JDialog {

    private ModelTablaProduct model;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    public ListProductsStockMinimum(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.model = new ModelTablaProduct(
                (ArrayList<Product>) ControllerProducts.getInstancia().listProductsStockLowMinimum());
        initComponents();
        this.tablaProductsStockMin.getTableHeader().setReorderingAllowed(false);
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

        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductsStockMin = new javax.swing.JTable();

        setTitle("Products con stock bajo mínimo");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btnCancel.setText("Cerrar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tablaProductsStockMin.setModel(this.model);
        jScrollPane1.setViewportView(tablaProductsStockMin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnCancel))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel)
                                .addContainerGap()));

        pack();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        doClose(RET_CANCEL);
    }

    private void closeDialog(java.awt.event.WindowEvent evt) {
        doClose(RET_CANCEL);
    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    private javax.swing.JButton btnCancel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductsStockMin;
    private int returnStatus = RET_CANCEL;
}
