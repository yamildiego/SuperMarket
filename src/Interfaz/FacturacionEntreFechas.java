package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

import Controllers.ControllerSales;

public class FacturacionEntreFechas extends javax.swing.JDialog {

        public static final int RET_CANCEL = 0;
        public static final int RET_OK = 1;

        public FacturacionEntreFechas(java.awt.Frame parent, boolean modal) {
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

                labelFechaDesde = new javax.swing.JLabel();
                labelFechaHasta = new javax.swing.JLabel();
                dateDesde = new datechooser.beans.DateChooserCombo();
                dateHasta = new datechooser.beans.DateChooserCombo();
                labelTotal = new javax.swing.JLabel();
                total = new javax.swing.JLabel();
                error = new javax.swing.JLabel();
                salir = new javax.swing.JButton();
                calcular = new javax.swing.JButton();

                setTitle("Facturación entre dates");
                setResizable(false);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                closeDialog(evt);
                        }
                });

                labelFechaDesde.setText("Fecha desde");

                labelFechaHasta.setText("Fecha hasta");

                dateDesde.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
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
                dateDesde.setFormat(2);
                dateDesde.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

                dateHasta.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
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
                dateHasta.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

                labelTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                labelTotal.setText("Total facturado: $");

                total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

                error.setForeground(java.awt.Color.red);

                salir.setText("Cerrar");
                salir.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                salirActionPerformed(evt);
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
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(error,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(labelTotal)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(total,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(dateDesde,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(labelFechaDesde))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(dateHasta,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(labelFechaHasta))
                                                                                                .addGap(0, 190, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(calcular)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(salir)))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labelFechaDesde)
                                                                                .addComponent(labelFechaHasta))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(dateDesde,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(dateHasta,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(labelTotal,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(total,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(error,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                15,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(salir)
                                                                                .addComponent(calcular))
                                                                .addContainerGap()));

                getRootPane().setDefaultButton(calcular);

                pack();
        }

        private void calcularActionPerformed(java.awt.event.ActionEvent evt) {
                if (this.dateDesde.getCurrent().getTime().getTime() > this.dateHasta.getCurrent().getTime()
                                .getTime()) {
                        this.error.setText("El campo date desde debe ser menor que el campo date hasta.");
                        return;
                }
                this.error.setText(null);
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(this.dateDesde.getCurrent().getTime());
                this.total.setText(Double.toString(ControllerSales.getInstance().getTotal(calendar.getTime(),
                                this.dateHasta.getCurrent().getTime())));
        }

        private void salirActionPerformed(java.awt.event.ActionEvent evt) {
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
        private javax.swing.JLabel error;
        private datechooser.beans.DateChooserCombo dateDesde;
        private datechooser.beans.DateChooserCombo dateHasta;
        private javax.swing.JLabel labelFechaDesde;
        private javax.swing.JLabel labelFechaHasta;
        private javax.swing.JLabel labelTotal;
        private javax.swing.JButton salir;
        private javax.swing.JLabel total;
        private int returnStatus = RET_CANCEL;
}
