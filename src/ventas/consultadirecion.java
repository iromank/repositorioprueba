/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
public class consultadirecion extends javax.swing.JFrame {

    DefaultTableModel baca = new DefaultTableModel();
    Connection con;
    Statement stmt;
    ResultSet rs;
//    String valor;
    public consultadirecion() {
        initComponents();
         String titulos[]= {"id_clie","nom_clie","ape_pat","ape_mat","direccion","lim_credito","estado",};
        baca.setColumnIdentifiers(titulos);
        clie.setModel(baca); 
        conectarJDBC() ;
        codi();
        
    }
      
    private void conectarJDBC() {

        String url = "jdbc:sqlserver://localhost; databaseName=avargas;user=sa; password=123456;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(rootPane, "TU SI A  BACA ", "Conectar", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Noooooooo", "Conectar", JOptionPane.ERROR_MESSAGE);

        }
          }
            public void llenar()
                {
//    valor=(String)cbodir.getSelectedItem();

    
    
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clie = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbodir = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("consulat selecionando la direcion de los clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("direcion ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        clie.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(clie);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 190));

        jButton1.setText("consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jButton2.setText("salir");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 70, -1));

        getContentPane().add(cbodir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       String valor=(String)cbodir.getSelectedItem();
//          String valor2=txtco.getText();
        try {
            String pre="select * fromn cliente where fecha_reg='"+valor+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(pre);//obtener una respuesta
            while(rs.next()){
                String dato[]=new String [7];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                dato[6]=rs.getString(7);
                baca.addRow(dato);
                
//                con.close();
                
            }
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","con sulta no valida por favor",JOptionPane.ERROR_MESSAGE);
        }
        } 
     
         
//         
             private void codi() {
             
        try {
            String pre="select distinct direccion from cliente";
            stmt=con.createStatement();
            rs=stmt.executeQuery(pre);//obtener una respuesta
            while(rs.next()){
                cbodir.addItem(rs.getString(1));
           
                 }
            con.createStatement();
            stmt.executeQuery(pre);
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","no es",JOptionPane.ERROR_MESSAGE);

        
         }
         
        
        
        
        
        
        
        
        
        
        
        
        
        

      
     
         
         
        
                 

         
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
            java.util.logging.Logger.getLogger(consultadirecion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultadirecion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultadirecion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultadirecion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultadirecion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbodir;
    private javax.swing.JTable clie;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
