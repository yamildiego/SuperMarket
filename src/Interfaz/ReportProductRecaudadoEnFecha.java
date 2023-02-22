package Interfaz;

import Controllers.ControllerSales;
import Model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class ReportProductRecaudadoEnFecha extends javax.swing.JDialog {

        private Product product;
        public static final int RET_CANCEL = 0;
        public static final int RET_OK = 1;

        public ReportProductRecaudadoEnFecha(java.awt.Frame parent, boolean modal) {
                super(parent, modal);
                initComponents();
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

                date = new datechooser.beans.DateChooserCombo();
                totalLabel = new javax.swing.JLabel();
                labelNombre = new javax.swing.JLabel();
                total = new javax.swing.JLabel();
                nombre = new javax.swing.JLabel();
                btnCancel = new javax.swing.JButton();
                calcular = new javax.swing.JButton();

                setTitle("Product con mayor recaudación");
                setResizable(false);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                closeDialog(evt);
                        }
                });

                date.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
                                new datechooser.view.appearance.ViewAppearance("custom",
                                                new datechooser.view.appearance.swing.SwingCellAppearance(
                                                                new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                                                                new java.awt.Color(0, 0, 0),
                                                                new java.awt.Color(0, 0, 255),
                                                                false,
                                                                true,
                                                                new datechooser.view.appearance.swing.ButtonPainter()),
                                                new datechooser.view.appearance.swing.SwingCellAppearance(
                                                                new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                                                                new java.awt.Color(0, 0, 0),
                                                                new java.awt.Color(0, 0, 255),
                                                                true,
                                                                true,
                                                                new datechooser.view.appearance.swing.ButtonPainter()),
                                                new datechooser.view.appearance.swing.SwingCellAppearance(
                                                                new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                                                                new java.awt.Color(0, 0, 255),
                                                                new java.awt.Color(0, 0, 255),
                                                                false,
                                                                true,
                                                                new datechooser.view.appearance.swing.ButtonPainter()),
                                                new datechooser.view.appearance.swing.SwingCellAppearance(
                                                                new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                                                                new java.awt.Color(128, 128, 128),
                                                                new java.awt.Color(0, 0, 255),
                                                                false,
                                                                true,
                                                                new datechooser.view.appearance.swing.LabelPainter()),
                                                new datechooser.view.appearance.swing.SwingCellAppearance(
                                                                new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                                                                new java.awt.Color(0, 0, 0),
                                                                new java.awt.Color(0, 0, 255),
                                                                false,
                                                                true,
                                                                new datechooser.view.appearance.swing.LabelPainter()),
                                                new datechooser.view.appearance.swing.SwingCellAppearance(
                                                                new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                                                                new java.awt.Color(0, 0, 0),
                                                                new java.awt.Color(255, 0, 0),
                                                                false,
                                                                false,
                                                                new datechooser.view.appearance.swing.ButtonPainter()),
                                                (datechooser.view.BackRenderer) null,
                                                false,
                                                true)));
                date.setFormat(2);
                date.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

                totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                totalLabel.setText("Total recaudado: $");

                labelNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                labelNombre.setText("Product:");

                total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

                nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

                btnCancel.setText("Cancel");
                btnCancel.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelActionPerformed(evt);
                        }
                });

                calcular.setText("Calculate");
                calcular.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                calcularActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(totalLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(total,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(date,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(labelNombre)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(nombre,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addGap(0, 178, Short.MAX_VALUE)
                                                                                                                .addComponent(calcular)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(btnCancel)))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(date,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(labelNombre,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(nombre,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(10, 10, 10)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(totalLabel,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(total,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                15,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                27,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnCancel)
                                                                                .addComponent(calcular))
                                                                .addContainerGap()));

                getRootPane().setDefaultButton(calcular);

                pack();
        }

        private void calcularActionPerformed(java.awt.event.ActionEvent evt) {
                this.product = ControllerSales.getInstancia()
                                .getIncomeByProduct(this.date.getCurrent().getTime());
                if (this.product != null) {
                        this.total.setText(
                                        ControllerSales.getInstancia().getTotalIncomeByProduct(
                                                        this.date.getCurrent().getTime())
                                                        + "");
                        this.nombre.setText(this.product.getName());
                }
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

        private javax.swing.JButton calcular;
        private javax.swing.JButton btnCancel;
        private datechooser.beans.DateChooserCombo date;
        private javax.swing.JLabel labelNombre;
        private javax.swing.JLabel nombre;
        private javax.swing.JLabel total;
        private javax.swing.JLabel totalLabel;
        private int returnStatus = RET_CANCEL;
}
