package so.segundoobligatorio;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class PopupProceso extends javax.swing.JFrame {

    private Proceso proceso;
    private Planificador planificador;
    private long pid;
    private short prioridad;

    public PopupProceso() {
        initComponents();
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
        if (this.proceso != null) {
            this.pid = this.proceso.getId();
            this.prioridad = this.proceso.getPrioridad();
            this.txtIDPopup.setText(String.valueOf(this.pid));
            this.txtPrioridadPopup.setText(String.valueOf(this.prioridad));
        }
    }

    public void setPlanificador(Planificador planificador) {
        this.planificador = planificador;
    }

    public Proceso getProceso() {
        return this.proceso;
    }

    public long getId() {
        return this.pid;
    }

    public short getPrioridad() {
        return this.prioridad;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblIDPopup = new javax.swing.JLabel();
        lblPrioridadPopap = new javax.swing.JLabel();
        txtIDPopup = new javax.swing.JTextField();
        txtPrioridadPopup = new javax.swing.JTextField();
        btnBloquearProceso = new javax.swing.JButton();
        btnModificarPrioridad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Proceso");

        lblIDPopup.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblIDPopup.setText("Id:");

        lblPrioridadPopap.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblPrioridadPopap.setText("Prioridad:");

        txtIDPopup.setText(String.valueOf(this.pid));

        txtPrioridadPopup.setText(String.valueOf(this.prioridad));

        btnBloquearProceso.setText("Bloquear");
        btnBloquearProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloquearProcesoActionPerformed(evt);
            }
        });

        btnModificarPrioridad.setText("Modificar Prioridad");
        btnModificarPrioridad.setActionCommand("v");
        btnModificarPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPrioridadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(btnBloquearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPrioridadPopap)
                            .addComponent(lblIDPopup))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDPopup)
                            .addComponent(txtPrioridadPopup)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblIDPopup))
                    .addComponent(txtIDPopup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPrioridadPopap)
                    .addComponent(txtPrioridadPopup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBloquearProceso)
                    .addComponent(btnModificarPrioridad))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBloquearProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloquearProcesoActionPerformed
        this.pid = Long.valueOf(this.txtIDPopup.getText());
        if (this.proceso != null && this.proceso.getId() == this.pid) {
            this.proceso.bloquear();
        } else {
            for (Procesador procesador : this.planificador.getProcesadores()) {
                if (procesador.getProceso() != null && procesador.getProceso().getId() == this.pid) {
                    procesador.getProceso().bloquear();
                    return;
                }
            }
            Proceso proceso = this.planificador.getColaListos().obtenerClave(this.pid);
            if (proceso != null) {
                proceso.bloquear();
            }
        }
    }//GEN-LAST:event_btnBloquearProcesoActionPerformed

    private void btnModificarPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPrioridadActionPerformed
        this.pid = Long.valueOf(this.txtIDPopup.getText());
        this.prioridad = (short) (Short.valueOf(this.txtPrioridadPopup.getText()) - 1);
        if (this.proceso != null && this.proceso.getId() == this.pid
                && this.proceso.getPrioridad() != this.prioridad) {
            if ((this.prioridad >= 0 && this.prioridad <= 50 && this.proceso.getTipo().equals(Proceso.Tipo.SO)) || (this.prioridad >= 51 && this.prioridad <= 100 && this.proceso.getTipo().equals(Proceso.Tipo.USUARIO))) {
                if (!this.planificador.setPrioridadProceso(this.proceso, this.prioridad)) {
                    this.proceso.setPrioridad(prioridad);

                } else {
                    if (this.planificador.getProcesosBloqueadosPorId().containsKey(this.pid)) {
                        this.planificador.getProcesosBloqueadosPorId().get(this.pid).setPrioridad(this.prioridad);
                        return;
                    }

                    for (Procesador procesador : this.planificador.getProcesadores()) {
                        if (procesador.getProceso() != null && procesador.getProceso().getId() == this.pid) {
                            procesador.getProceso().setPrioridad(this.prioridad);
                            return;
                        }
                    }

                    Proceso proceso = this.planificador.getColaListos().obtenerClave(this.pid);
                    if (proceso != null && proceso.getPrioridad() != this.prioridad) {
                        this.planificador.setPrioridadProceso(proceso, this.prioridad);
                    }
                }
            } else {
                showMessageDialog(null, "La prioridad debe ser un n??mero entre 0 y 50 para el tipo SO\n o entre 51 y 100 para tipo Usuario", "Error", ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnModificarPrioridadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquearProceso;
    private javax.swing.JButton btnModificarPrioridad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIDPopup;
    private javax.swing.JLabel lblPrioridadPopap;
    private javax.swing.JTextField txtIDPopup;
    private javax.swing.JTextField txtPrioridadPopup;
    // End of variables declaration//GEN-END:variables
}
