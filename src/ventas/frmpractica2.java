
package ventas;

import java.sql.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;
public class frmpractica2 extends javax.swing.JFrame {

     DefaultTableModel baca= new  DefaultTableModel ();
    Connection con;
    Statement stmt;
    ResultSet rs;
    public frmpractica2() {
        
        initComponents();
           
         baca.addColumn("codigo");
       baca.addColumn("nombre");
       baca.addColumn("apellido");
       baca.addColumn("apellido materno");
       baca.addColumn("direccion");
       baca.addColumn("limite credito");
       baca.addColumn("estado");
       this.clie.setModel(baca);
       
        
    }
       public void conectarJDB()
               
     {
    
    String url="jdbc:sqlserver://localhost; databaseName=baca;user=sa; password=123456;";
    try
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con=DriverManager.getConnection(url);
        
    }
    catch(Exception ex)
    {
                JOptionPane.showMessageDialog(rootPane, "Noooooooo", "Conectar", JOptionPane.ERROR_MESSAGE);

    }
    
    }
        void limpiaTabla(){
        try{
          baca = (DefaultTableModel) clie.getModel();
            int a =baca.getRowCount()-0;
            for(int i=0; i<a; i++)
                baca.removeRow(0); 
        }catch(Exception e){
            System.out.println(e);
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
        txtde = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        clie = new javax.swing.JTable();
        btmostra = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));
        getContentPane().add(txtde, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 120, 20));

        clie.setBackground(new java.awt.Color(102, 255, 204));
        clie.setForeground(new java.awt.Color(51, 51, 255));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 360, 170));

        btmostra.setBackground(new java.awt.Color(255, 0, 0));
        btmostra.setForeground(new java.awt.Color(0, 204, 153));
        btmostra.setText("mostra");
        btmostra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmostraActionPerformed(evt);
            }
        });
        getContentPane().add(btmostra, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 90, -1));

        jButton1.setText("salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btmostraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmostraActionPerformed
        // TODO add your handling code here:
        conectarJDB();
        limpiaTabla();
      String valor1,comparacion,valor=txtde.getText(); 
//para ser una programacion y mostrar mensaje
      
        try {
           
                
          
            String PRE="select * from Cliente where nom_clie like '"+ valor+"%'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(PRE);//obtener una respuesta
          
            while(rs.next()){
                String dato[]=new String [7];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                dato[5]=rs.getString(6);
                 dato[6]=rs.getString(7);
                
                baca.addRow(dato);
                        
            }
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","con sulta no valida",JOptionPane.ERROR_MESSAGE);
        }
         
        
        
    }//GEN-LAST:event_btmostraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
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
            java.util.logging.Logger.getLogger(frmpractica2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpractica2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpractica2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpractica2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpractica2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmostra;
    private javax.swing.JTable clie;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtde;
    // End of variables declaration//GEN-END:variables
}
