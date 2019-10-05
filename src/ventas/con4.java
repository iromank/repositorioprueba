//baca
package ventas;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.util.Scanner.*;
public class con4 extends javax.swing.JFrame {

    DefaultTableModel baca = new DefaultTableModel();
    Connection con;
    Statement stmt;
    ResultSet rs;

    public con4() {
        initComponents();
         conectarJDBC();
         baca.addColumn("codigo");
       baca.addColumn("nombre");
       baca.addColumn("apellido");
       baca.addColumn("apellido materno");
       baca.addColumn("direccion");
       baca.addColumn("limite credito");
       baca.addColumn("estado");
       this.cliente.setModel(baca);
        codi();
    }
       void limpiaTabla(){
        try{
          baca = (DefaultTableModel) cliente.getModel();
            int a =baca.getRowCount()-0;
            for(int i=0; i<a; i++)
                baca.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
        }catch(Exception e){
            System.out.println(e);
        }
         }
    private void conectarJDBC() {

        String url = "jdbc:sqlserver://localhost; databaseName=baca;user=sa; password=123456;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Noooooooo", "Conectar", JOptionPane.ERROR_MESSAGE);

        }
         }
    
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cliente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbopedidos = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cliente.setBackground(new java.awt.Color(51, 255, 153));
        cliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(cliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 375, 120));

        jButton1.setText("mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("direccion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        cbopedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbopedidosActionPerformed(evt);
            }
        });
        getContentPane().add(cbopedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 90, -1));

        jButton2.setText("salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 80, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("consulat selecionando la direcion de los clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 520, -1));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbopedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbopedidosActionPerformed
        
    }//GEN-LAST:event_cbopedidosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
////conectarJDBC();
     
    limpiaTabla();
       String valor=(String)cbopedidos.getSelectedItem();
        try {
            
            String pre="select * from cliente where direccion='"+valor+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(pre);//obtener una respuesta
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
                int total;
                total=cliente.getRowCount();
                txttotal.setText(String.valueOf(total));
//                con.close();
//                stmt.close();
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
                cbopedidos.addItem(rs.getString(1));
           
                 }
            con.createStatement();
            stmt.executeQuery(pre);
            int total;
                total=cliente.getRowCount();
                txttotal.setText(String.valueOf(total));
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","no es",JOptionPane.ERROR_MESSAGE);

    
         
         }
        
        String valor = "Este es el mensaje: ";
System.out.println(valor+ " Hola");
         
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    dispose();
    new frmpractica8 (). setVisible (true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(con4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(con4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(con4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(con4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new con4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbopedidos;
    private javax.swing.JTable cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
