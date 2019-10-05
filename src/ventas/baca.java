
package ventas;

import javax.swing.JOptionPane;
import javax.swing.table.*;
public class baca extends javax.swing.JFrame {
// DefaultTableModel baca=new DefaultTableModel();
  DefaultTableModel modelo;
  double t;
    public baca() {
         initComponents();
       modelo= new  DefaultTableModel ();
       modelo.addColumn("nombre");
      
       modelo.addColumn("apellido");
       modelo.addColumn("direccion");
       modelo.addColumn("sueldo");
       modelo.addColumn("cantidad");
       modelo.addColumn("total");
       this.tabla.setModel(modelo);
       
        
      
    }

                 private void sst(){
        Double out=0.0;
        Double p = 0.0;
        int z=modelo.getRowCount();
        for(int i=0;i<z;i++){
            p=Double.parseDouble(modelo.getValueAt(i,5).toString());
                out= out + p;
        }
        txtr.setText(String.valueOf(out));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        baca = new javax.swing.JProgressBar();
        txtn = new javax.swing.JTextField();
        txtape = new javax.swing.JTextField();
        txtdi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txts = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtca = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtr = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setText("apellido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setText("direccion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        getContentPane().add(baca, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));
        getContentPane().add(txtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 120, -1));
        getContentPane().add(txtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 120, -1));
        getContentPane().add(txtdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 110, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 250));

        jButton1.setText("egregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel4.setText("sueldo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        getContentPane().add(txts, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 110, -1));

        jLabel5.setText("cantidad");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));
        getContentPane().add(txtca, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 100, -1));

        jButton2.setText("calcular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jButton3.setText("registrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));
        getContentPane().add(txtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String  [] datos = new String[7];
        datos[0]=txtn.getText();
        datos[1]=txtape.getText();
        datos[2]=txtdi.getText();
        datos[3]=txts.getText();
        datos[4]=txtca.getText();
        datos[5]=String.valueOf(t);
        
        modelo.addRow(datos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        double s,c;
        s=Double.parseDouble(txts.getText());
        c=Double.parseDouble(txtca.getText());
        t=s*c;
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        sst();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(baca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(baca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(baca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(baca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new baca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar baca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtca;
    private javax.swing.JTextField txtdi;
    private javax.swing.JTextField txtn;
    private javax.swing.JTextField txtr;
    private javax.swing.JTextField txts;
    // End of variables declaration//GEN-END:variables
}
