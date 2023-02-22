package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import Controllers.ControllerSales;

public class FacturacionEnFecha extends javax.swing.JDialog {

        public static final int RET_CANCEL = 0;
        public static final int RET_OK = 1;

        public FacturacionEnFecha(java.awt.Frame parent, boolean modal) {
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

                calcular = new javax.swing.JButton();
                salir = new javax.swing.JButton();
                date = new datechooser.beans.DateChooserCombo();
                total = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();

                setTitle("Facturación por date");
                setResizable(false);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                closeDialog(evt);
                        }
                });

                calcular.setText("Calculate");
                calcular.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                calcularActionPerformed(evt);
                        }
                });

                salir.setText("Cerrar");
                salir.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                salirActionPerformed(evt);
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
                date.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
                date.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

                total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

                jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                jLabel1.setText("Total facturado: $");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(calcular,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                80,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(salir))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(date,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jLabel1)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(total,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                210,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(date,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(28, 28, 28)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(total,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLabel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                72,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(salir)
                                                                                .addComponent(calcular))
                                                                .addContainerGap()));

                getRootPane().setDefaultButton(calcular);

                pack();
        }

        private void salirActionPerformed(java.awt.event.ActionEvent evt) {
                doClose(RET_CANCEL);
        }

        private void closeDialog(java.awt.event.WindowEvent evt) {
                doClose(RET_CANCEL);
        }

        private void calcularActionPerformed(java.awt.event.ActionEvent evt) {
                this.total.setText(
                                Double.toString(ControllerSales.getInstancia()
                                                .getTotal(this.date.getCurrent().getTime())));
        }

        private void doClose(int retStatus) {
                returnStatus = retStatus;
                setVisible(false);
                dispose();
        }

        private javax.swing.JButton calcular;
        private datechooser.beans.DateChooserCombo date;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JButton salir;
        private javax.swing.JLabel total;
        private int returnStatus = RET_CANCEL;
}
