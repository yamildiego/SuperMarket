package Interfaz;

import Controllers.ControllerProducts;
import Model.Tax;
import Model.TaxNational;
import Model.TaxState;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CreateProduct extends javax.swing.JDialog {

        public static final int RET_CANCEL = 0;
        public static final int RET_OK = 1;

        public CreateProduct(java.awt.Frame parent, boolean modal) {
                super(parent, modal);
                initComponents();

                getRootPane().setDefaultButton(btnAdd);
                this.setLocationRelativeTo(parent);

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

                buttonGroup = new javax.swing.ButtonGroup();
                labelCode = new javax.swing.JLabel();
                labelName = new javax.swing.JLabel();
                labelPrice = new javax.swing.JLabel();
                labelStock = new javax.swing.JLabel();
                labelStockMin = new javax.swing.JLabel();
                labelStockMax = new javax.swing.JLabel();
                error = new javax.swing.JLabel();
                code = new javax.swing.JTextField();
                name = new javax.swing.JTextField();
                price = new javax.swing.JFormattedTextField();
                stock = new javax.swing.JTextField();
                stockMin = new javax.swing.JTextField();
                stockMax = new javax.swing.JTextField();
                btnCancel = new javax.swing.JButton();
                btnAdd = new javax.swing.JButton();
                radioTaxHight = new javax.swing.JRadioButton();
                radioTaxLow = new javax.swing.JRadioButton();
                radioNoTax = new javax.swing.JRadioButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Add product");
                setMinimumSize(new java.awt.Dimension(380, 300));
                setModal(true);
                setResizable(false);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                closeDialog(evt);
                        }
                });

                labelCode.setText("Código de barras");

                labelName.setText("Nombre");

                labelPrice.setText("price");

                labelStock.setText("Stock actual");

                labelStockMin.setText("Stock mínimo");

                labelStockMax.setText("Stock máximo");

                error.setForeground(new java.awt.Color(255, 0, 0));

                code.setDocument(new CharacterLimiter());

                name.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                nameActionPerformed(evt);
                        }
                });

                price.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.##"))));

                stock.setDocument(new CharacterLimiter());

                stockMin.setDocument(new CharacterLimiter());

                stockMax.setDocument(new CharacterLimiter());

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

                buttonGroup.add(radioTaxHight);
                radioTaxHight.setText("Tax alto");

                buttonGroup.add(radioTaxLow);
                radioTaxLow.setText("Tax bajo");

                buttonGroup.add(radioNoTax);
                radioNoTax.setSelected(true);
                radioNoTax.setText("Sin Tax");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(labelName)
                                                                                                                .addComponent(labelPrice)
                                                                                                                .addComponent(labelStock)
                                                                                                                .addComponent(labelCode)
                                                                                                                .addComponent(labelStockMin)
                                                                                                                .addComponent(labelStockMax))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(code)
                                                                                                                                                .addComponent(name)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addComponent(stock,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addGap(0, 160, Short.MAX_VALUE)))
                                                                                                                                .addGap(10, 10, 10))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                false)
                                                                                                                                                                .addComponent(stockMax,
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(stockMin,
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING))
                                                                                                                                                .addComponent(price,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                100,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addContainerGap())))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(radioTaxHight)
                                                                                                                .addComponent(radioTaxLow)
                                                                                                                .addComponent(radioNoTax))
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(error,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                                .addComponent(btnAdd)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(btnCancel)))
                                                                                                .addContainerGap()))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labelCode)
                                                                                .addComponent(code,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labelName)
                                                                                .addComponent(name,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labelPrice)
                                                                                .addComponent(price,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(stock,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labelStock))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(stockMin,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labelStockMin))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(stockMax,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labelStockMax))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                13,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(radioTaxHight)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioTaxLow)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioNoTax)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(error,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                15,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnCancel)
                                                                                .addComponent(btnAdd))
                                                                .addContainerGap()));

                pack();
        }

        private void closeDialog(java.awt.event.WindowEvent evt) {
                doClose(RET_CANCEL);
        }

        private void nameActionPerformed(java.awt.event.ActionEvent evt) {
                // // TODO add your handling code here:
        }

        private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
                if (this.code.getText() == null || this.code.getText().equals("")) {
                        this.error.setText("The code field is required.");
                        return;
                }
                if (ControllerProducts.getInstancia().findProduct(Integer.parseInt(this.code.getText())) != null) {
                        this.error.setText("Ya existe un product con el código ingresado.");
                        return;
                }
                if (this.name.getText() == null || this.name.getText().equals("")) {
                        this.error.setText("The name field is required.");
                        return;
                }
                if (this.price.getText() == null || this.price.getText().equals("")) {
                        this.error.setText("The price field is required.");
                        return;
                }
                if (this.stock.getText() == null || this.stock.getText().equals("")) {
                        this.error.setText("The current stock field is required.");
                        return;
                }
                if (this.stockMin.getText() == null || this.stockMin.getText().equals("")) {
                        this.error.setText("The minimun stock field is required.");
                        return;
                }
                if (this.stockMax.getText() == null || this.stockMax.getText().equals("")) {
                        this.error.setText("The maximun stock field is required.");
                        return;
                }

                int code = Integer.parseInt(this.code.getText());
                String priceText = this.price.getText().replace(',', '.');
                double price = Double.parseDouble(priceText);
                int stock = Integer.parseInt(this.stock.getText());
                int stockMin = Integer.parseInt(this.stockMin.getText());
                int stockMax = Integer.parseInt(this.stockMax.getText());
                List<Tax> listTax = new ArrayList<Tax>();

                if (stockMax < stockMin) {
                        this.error.setText(
                                        "The maximum stock field must contain a value greater than the minimum stock field.");
                        return;
                }

                if (this.radioTaxLow.isSelected()) {
                        Tax radioTaxLowNacional = new TaxNational(5, 0.25, "Tax National", Tax.Type.LOW);
                        Tax radioTaxLowProvincial = new TaxState(10, 0.10, "Tax State", Tax.Type.LOW);
                        listTax.add(radioTaxLowNacional);
                        listTax.add(radioTaxLowProvincial);
                }

                if (this.radioTaxHight.isSelected()) {
                        Tax radioTaxHightNational = new TaxNational(10, 0.5, "Tax National", Tax.Type.HIGH);
                        Tax radioTaxHightState = new TaxState(15, 0.5, "Tax State", Tax.Type.HIGH);
                        listTax.add(radioTaxHightNational);
                        listTax.add(radioTaxHightState);
                }
                if (this.radioNoTax.isSelected()) {
                        listTax = null;
                }

                ControllerProducts.getInstancia().addProduct(code, this.name.getText(), price, stock, stockMin,
                                stockMax,
                                listTax);
                doClose(RET_OK);
        }

        private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
                doClose(RET_CANCEL);
        }

        private void doClose(int retStatus) {
                returnStatus = retStatus;
                setVisible(false);
                dispose();
        }

        private javax.swing.JButton btnAdd;
        private javax.swing.ButtonGroup buttonGroup;
        private javax.swing.JButton btnCancel;
        private javax.swing.JTextField code;
        private javax.swing.JLabel error;
        private javax.swing.JRadioButton radioTaxHight;
        private javax.swing.JRadioButton radioTaxLow;
        private javax.swing.JLabel labelCode;
        private javax.swing.JLabel labelName;
        private javax.swing.JLabel labelPrice;
        private javax.swing.JLabel labelStock;
        private javax.swing.JLabel labelStockMax;
        private javax.swing.JLabel labelStockMin;
        private javax.swing.JTextField name;
        private javax.swing.JFormattedTextField price;
        private javax.swing.JRadioButton radioNoTax;
        private javax.swing.JTextField stock;
        private javax.swing.JTextField stockMax;
        private javax.swing.JTextField stockMin;
        private int returnStatus = RET_CANCEL;
}
