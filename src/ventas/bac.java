/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *
 * @author BACA VARGAS
 */
public class bac extends javax.swing.JFrame {
double total;
int can;
    public bac() {
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

        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txtm = new javax.swing.JTextField();
        txtg = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtcam = new javax.swing.JTextField();
        txtdd = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 11, 116, -1));
        getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 49, 116, -1));
        getContentPane().add(txtm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 110, -1));
        getContentPane().add(txtg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 70, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));
        getContentPane().add(txtcam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, -1));
        getContentPane().add(txtdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 120, -1));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ca,p,m;
        ca=Integer.parseInt(txt1.getText());
        p=Integer.parseInt(txt2.getText());
        m=ca*p;
        total=total+m;
        txtm.setText(String.valueOf(m));
//         txtcam.setText(String.valueOf(can));
         txtg.setText(String.valueOf(total));
         int to,d=0;
           to=Integer.parseInt(txtg.getText());
           if(to>16){
               d=to - 4;
                 
           }
          txtdd.setText(String.valueOf(d));
      
        
           
            
        
        
        
                
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(bac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txtcam;
    private javax.swing.JTextField txtdd;
    private javax.swing.JTextField txtg;
    private javax.swing.JTextField txtm;
    // End of variables declaration//GEN-END:variables
}
