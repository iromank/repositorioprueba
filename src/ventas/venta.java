//baca vargas nilson eduardo
package ventas;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class venta extends javax.swing.JFrame {
 Connection con;
    ResultSet rs;
    Statement  stmt;
    String co,fe,tv,cliente,vendedor,st;
      DefaultTableModel  baca =new DefaultTableModel();
 
    public venta() {
        initComponents();
        setSize(630,500);
        setLocation(340,100);
         baca.addColumn("codigo");
       baca.addColumn("fecha venta");
       baca.addColumn("tipo venta");
       baca.addColumn("codi cliente");
       baca.addColumn("codi venta");
       baca.addColumn("estado");
//       baca.addColumn("estado");

        this.ventas.setModel(baca);
       conectarJDBC();
       cliente();
       vendedor();
       tipo();
    }
    public void conectarJDBC()
               
     {
    
    String url="jdbc:sqlserver://localhost; databaseName=baca;user=sa; password=123456;";
    try
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con=DriverManager.getConnection(url);
       JOptionPane.showMessageDialog(rootPane, "siiiiiiiiiii", "Conectar", JOptionPane.ERROR_MESSAGE);
    }
    catch(Exception ex)
    {
                JOptionPane.showMessageDialog(rootPane, "Noooooooo", "Conectar", JOptionPane.ERROR_MESSAGE);

    }
    }
//     private  void llenar()
//               
//     {
////         cod=Integer.parseInt(txtco.getText()); combertir de string a entero
//    co=txtco.getText();
//    fe=txtfecha.getText();
//   
////    p=Double.parseDouble(txtp.getText());
//
//    }
     private void cliente() {
             
        try {
            String pre="select distinct  id_clie from cliente";
            stmt=con.createStatement();
            rs=stmt.executeQuery(pre);//obtener una respuesta
            while(rs.next()){
                cbococli.addItem(rs.getString(1));
           
                 }
            con.createStatement();
            stmt.executeQuery(pre);
            
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","no es",JOptionPane.ERROR_MESSAGE);

        
         }
         
             
    }          
  private void vendedor() {
             
        try {
            String pre="select  id_vend from vendedor";
            stmt=con.createStatement();
            rs=stmt.executeQuery(pre);//obtener una respuesta
            while(rs.next()){
                cbovendedor.addItem(rs.getString(1));
           
                 }
            
           con.createStatement();
            stmt.executeQuery(pre);
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","no es",JOptionPane.ERROR_MESSAGE);

        
         }
         
             
    }   
  private void tipo() {
             
        try {
            String pre="select distinct  tip_venta from tipoventa";
            stmt=con.createStatement();
            rs=stmt.executeQuery(pre);//obtener una respuesta
            while(rs.next()){
                cbotipo.addItem(rs.getString(1));
           
                 }
            
             con.createStatement();
            stmt.executeQuery(pre);
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","no es",JOptionPane.ERROR_MESSAGE);

        
         }
         
             
    }          
           private void mostrar(){
     String sql;
        try {
           
             sql="select * from venta";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
            while(rs.next()){
                String dato[]=new String [6];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                 dato[5]=rs.getString(6);
               
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
//             public void registrar(){
//                 int rpt;
//                 String sql;
//                 rpt=JOptionPane.showConfirmDialog(rootPane,"deseas gravar","gravar",
//                         JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
//                  
//                  
//                  
//                 try {
//                     llenar();
//                    sql="insert into venta values( '"+co+"','"+fe+"','"+tv+"','"+cclie+"','"+cvend+"','"+st+"')";
//                     
//                    stmt=con.createStatement();
//                     stmt.executeQuery(sql);
//                     con.close();
//                     stmt.close();
//                    
//                     
//                     
//                 } catch (Exception ex) {
//                     JOptionPane.showMessageDialog(this,"herrror en cosulta");
//                 }
//                 
//                      
//                         
//                 
//             }
             public void llena()
                {
    co=txtco.getText();
    fe=txtfecha.getText();
    tv=(String)cbotipo.getSelectedItem();
    cliente=(String)cbococli.getSelectedItem();
    vendedor=(String)cbovendedor.getSelectedItem();
    st=txtes.getText();

    
    }
               public void registrar(){
                
                 try {
                     llena();
                   String  sql="insert into Venta values( '"+co+"','"+fe+"','"+tv+"','"+cliente+"','"+vendedor+"','"+st+"')";
                     stmt=con.createStatement();
                     stmt.execute(sql);
                   
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(rootPane,ex.getMessage());
               
                       }
                   }
    public void nuevo ()
             {
                 txtco.setText("");
                 txtfecha.setText("");
                 txtes.setText("");
                 txtco.requestFocus();
         }
    void limpiaTabla(){
        try{
          baca = (DefaultTableModel) ventas.getModel();
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
        txtco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ventas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        cbococli = new javax.swing.JComboBox<>();
        cbovendedor = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        txtmos = new javax.swing.JTextField();
        txttipo = new javax.swing.JTextField();
        txtven = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        getContentPane().add(txtco, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 40, -1));

        jLabel2.setText("fecha venta ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));
        getContentPane().add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 120, -1));

        jLabel3.setText("tipo venta");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, -1));

        jLabel4.setText("codigo cliente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jLabel5.setText(" codigo vendedor");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jLabel6.setText("estado");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));
        getContentPane().add(txtes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 80, -1));

        ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 230));

        jButton1.setText("nuevo");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        jButton2.setText("grabar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jButton3.setText("modificar");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        jButton4.setText("eliminar");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, -1));

        jButton5.setText("salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("registro de ventas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 150, -1));

        getContentPane().add(cbotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 100, 80, -1));

        getContentPane().add(cbococli, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 90, -1));

        cbovendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbovendedorActionPerformed(evt);
            }
        });
        getContentPane().add(cbovendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 80, -1));

        jButton6.setText("mostrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));
        getContentPane().add(txtmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 60, -1));
        getContentPane().add(txttipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 70, -1));
        getContentPane().add(txtven, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llena();
        registrar();
        
        limpiaTabla();
      mostrar();
      txtmos.setText(cliente);
      txtven.setText(vendedor);
      txttipo.setText(tv);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        new  consultaventas(). setVisible (true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbovendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbovendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbovendedorActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        mostrar();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbococli;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.JComboBox<String> cbovendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtco;
    private javax.swing.JTextField txtes;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtmos;
    private javax.swing.JTextField txttipo;
    private javax.swing.JTextField txtven;
    private javax.swing.JTable ventas;
    // End of variables declaration//GEN-END:variables
}
