//deta venta
package ventas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class detventa extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    Statement  stmt;
    String cov,cop,can,p;
      DefaultTableModel  baca =new DefaultTableModel();
    public detventa() {
        initComponents();
         setSize(630,500);
        setLocation(340,100);
       baca.addColumn("codigo venta");
       baca.addColumn("codigo producto");
       baca.addColumn("cantiada");
       baca.addColumn("precio uni");
       dventa.setModel(baca);
       conectarJDBC();
    }
     public void conectarJDBC()
               
     {
    
    String url="jdbc:sqlserver://localhost; databaseName=baca;user=sa; password=123456;";
    try
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con=DriverManager.getConnection(url);
        JOptionPane.showMessageDialog(rootPane, "TU SI A  BACA ", "Conectar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(Exception ex)
    {
                JOptionPane.showMessageDialog(rootPane, "Noooooooo", "Conectar", JOptionPane.ERROR_MESSAGE);

    }
    }
     private  void llenar()
               
     {
//         cod=Integer.parseInt(txtco.getText()); combertir de string a entero
    cov=txtcoventa.getText();
    cop=txtcpro.getText();
    can=txtcan.getText();
    p=txtp.getText();
   
//    p=Double.parseDouble(txtp.getText());

    }
           private void mostrar(){
     String sql;
        try {
           
             sql="select * from DetVenta";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
            while(rs.next()){
                String dato[]=new String [4];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
               
                baca.addRow(dato);
             }
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","con sulta no valida",JOptionPane.ERROR_MESSAGE);
        }
        
    }
             public void limpiar()
               
     {
       
         
      
         
    }
              public void registrar(){
                 int rpt;
                 String sql;
                 rpt=JOptionPane.showConfirmDialog(rootPane,"deseas gravar","gravar",
                         JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                  
                  try {
                     llenar();
                    sql="insert into DetVenta values( '"+cov+"','"+cop+"','"+can+"','"+p+"')";
                     
                    stmt=con.createStatement();
                     stmt.executeQuery(sql);
                     con.close();
                     stmt.close();
                     } catch (Exception ex) {
                     JOptionPane.showMessageDialog(this,"herrror en cosulta");
                 }      
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
        txtcoventa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcpro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dventa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("codigo venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        getContentPane().add(txtcoventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 90, -1));

        jLabel2.setText("codigo de producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        getContentPane().add(txtcpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 90, -1));

        jLabel3.setText("cantidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));
        getContentPane().add(txtcan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 90, -1));

        jLabel4.setText("preccio unitario");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        getContentPane().add(txtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 90, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("detalle venta ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        dventa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(dventa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, 120));

        jButton1.setText("nuevo");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jButton2.setText("grabar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jButton3.setText("modificar");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        jButton4.setText("eliminar");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jButton5.setText("salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       llenar();
       registrar();
       mostrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         dispose();
        new bmenu (). setVisible (true);
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(detventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detventa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dventa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcan;
    private javax.swing.JTextField txtcoventa;
    private javax.swing.JTextField txtcpro;
    private javax.swing.JTextField txtp;
    // End of variables declaration//GEN-END:variables
}
