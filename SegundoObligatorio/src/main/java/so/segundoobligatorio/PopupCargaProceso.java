package so.segundoobligatorio;

import java.io.BufferedReader;
import java.io.FileReader;
import static javax.swing.JOptionPane.*;

public class PopupCargaProceso extends javax.swing.JFrame {

    private Planificador planificador;

    public PopupCargaProceso(Planificador planificador) {
        this.planificador = planificador;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTTotalEjecucion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTTotalEjecucion1 = new javax.swing.JLabel();
        lblTRealizaES = new javax.swing.JLabel();
        lblTEsperaES = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblPrioridad = new javax.swing.JLabel();
        ES = new javax.swing.JTextField();
        ejecucion = new javax.swing.JTextField();
        espera = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        txttipo = new javax.swing.JComboBox<>();
        txtprioridad = new javax.swing.JSpinner();

        lblTTotalEjecucion.setText("Tiempo total de ejecución:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Carga de Proceso");

        lblTTotalEjecucion1.setText("Tiempo total de ejecución:");

        lblTRealizaES.setText("Tiempo en que realiza una E/S:");

        lblTEsperaES.setText("Tiempo de espera por E/S:");

        lblTipo.setText("Tipo:");

        lblPrioridad.setText("Prioridad:");

        ES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ESActionPerformed(evt);
            }
        });

        ejecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecucionActionPerformed(evt);
            }
        });

        espera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esperaActionPerformed(evt);
            }
        });

        jLabel2.setText("ms");

        jLabel3.setText("ms");

        jLabel4.setText("ms");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        txttipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SO", "Usuario" }));
        txttipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttipoActionPerformed(evt);
            }
        });

        txtprioridad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        txtprioridad.setValue(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPrioridad)
                    .addComponent(lblTipo)
                    .addComponent(lblTEsperaES)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTRealizaES)
                        .addComponent(lblTTotalEjecucion1, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txttipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtprioridad)
                        .addComponent(espera))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ES, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addComponent(ejecucion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOK)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTTotalEjecucion1)
                    .addComponent(ejecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTRealizaES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTEsperaES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(espera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtprioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnOK)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ESActionPerformed

    private void ejecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ejecucionActionPerformed

    private void esperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esperaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esperaActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        double tiempoEnCPU = Double.valueOf(ejecucion.getText());
        double periodoES = Double.valueOf(ES.getText());
        double esperaES = Double.valueOf(espera.getText());
        short prioridad = (short) (Short.valueOf(String.valueOf(txtprioridad.getValue())) - 1);
        Proceso.Tipo tipo = Proceso.Tipo.USUARIO;
        if (String.valueOf(txttipo.getSelectedItem()).equals("SO")) {
            tipo = Proceso.Tipo.SO;
        }
        if ((prioridad >= 0 && prioridad <= 50 && String.valueOf(txttipo.getSelectedItem()).equals("SO")) || (prioridad >= 51 && prioridad <= 100 && String.valueOf(txttipo.getSelectedItem()).toUpperCase().equals("USUARIO"))) {
            this.planificador.insertarProceso(tiempoEnCPU, periodoES, esperaES, prioridad, tipo);
             
        } else {
            showMessageDialog(null, "La prioridad debe ser un número entre 0 y 50 para el tipo SO\n o entre 51 y 100 para tipo Usuario", "Error", ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void txttipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ES;
    private javax.swing.JButton btnOK;
    private javax.swing.JTextField ejecucion;
    private javax.swing.JTextField espera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblPrioridad;
    private javax.swing.JLabel lblTEsperaES;
    private javax.swing.JLabel lblTRealizaES;
    private javax.swing.JLabel lblTTotalEjecucion;
    private javax.swing.JLabel lblTTotalEjecucion1;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JSpinner txtprioridad;
    private javax.swing.JComboBox<String> txttipo;
    // End of variables declaration//GEN-END:variables
}