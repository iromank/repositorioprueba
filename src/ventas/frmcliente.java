/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class frmcliente extends javax.swing.JFrame {
    Connection con;
    ResultSet rs;
    Statement  stmt;
    String co,no,ap,di,su,corr,te,dni,se,es;
    DefaultTableModel  baca =new DefaultTableModel();
    
    public frmcliente() {
        initComponents();
         setSize(635,450);
        setLocation(400,100);
       baca.addColumn("codigo");
       baca.addColumn("nombre");
       baca.addColumn("apellido");
       baca.addColumn("sexo");
       baca.addColumn("dni");
       baca.addColumn("telefono");
       baca.addColumn("correo");
       baca.addColumn("direccion");
       baca.addColumn("credito");
       baca.addColumn("saldo");
       this.var.setModel(baca);
       conectar();
        mostrar();
        
         }
     public void conectar()
    {
    
    String url="jdbc:sqlserver://localhost; databaseName=bac;user=sa; password=123456;";
    try
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con=DriverManager.getConnection(url);
        JOptionPane.showMessageDialog(rootPane, "TU SI A ", "Conectar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(Exception ex)
    {
                JOptionPane.showMessageDialog(rootPane, "Noooooooo", "Conectar", JOptionPane.ERROR_MESSAGE);

    }
    }

 void limpiaTabla(){
        try{
          baca = (DefaultTableModel) var.getModel();
            int a =baca.getRowCount()-0;
            for(int i=0; i<a; i++)
                baca.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
        }catch(Exception e){
            System.out.println(e);
        }
         }
        //cargaTicket();
    
    
    
        public void llenar()
               
     {
         
         if (txtcod.getText().equals(""))  {
            JOptionPane.showMessageDialog(this, "Ingrese cod");
            
        }
     
         if (txtno.getText().equals("")){
             
         
             JOptionPane.showMessageDialog(this,"ingresa  nombre");
             }
         if(txtape.getText().equals("")){
                         JOptionPane.showMessageDialog(this, "ingrese apellido");
                     }
         
    co=txtcod.getText();
    no=txtno.getText();
    ap=txtape.getText();
    se=(String)cbosexo.getSelectedItem();
    dni=txtdni.getText();
    te=txtte.getText();
    corr=txtcorr.getText();
    di=txtdi.getText();
    su=txtsu.getText();
    es=txtes.getText();
    
    
    
    
    }
           public void mostrar(){
     String sql;
        try {
            
             sql="SELECT*FROM CLIENTE ";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
            while(rs.next()){
                String dato[]=new String [10];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                dato[5]=rs.getString(6);
                dato[6]=rs.getString(7);
                dato[7]=rs.getString(8);
                dato[8]=rs.getString(9);
                dato[9]=rs.getString(10);
                
                baca.addRow(dato);
               
            }
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","con sulta no valida",JOptionPane.ERROR_MESSAGE);
        }
        
    }
             public void limpiar()
               
     {
       
          int fila,total;
        fila=var.getSelectedRow();
        if(fila>=0)
            baca.removeRow(fila);
        else
         
            JOptionPane.showMessageDialog(null,"SELECCIONE UNA FILA PORFAVOR");  
        
         total=baca.getRowCount();
         
    }
             public void registrar(){
                 int rpt;
                 String sql;
                 rpt=JOptionPane.showConfirmDialog(rootPane,"deseas gravar","gravar",
                         JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                
                 try {
                     llenar();
                     sql="insert into cliente values( '"+co+"','"+no+"','"+ap+"'"
                             + ",'"+se+"','"+dni+"','"+te+"','"+corr+"','"+di+"','"+su+"','"+es+"')";
                     stmt=con.createStatement();
                     stmt.execute(sql);
                     con.close();
                     stmt.close();
                     limpiar();
                    
                     mostrar();
                     
                     
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(rootPane,ex.getMessage());
                 }
                 
                      
                         
                 
             }
//             public void modificar(){
//        
//               
//     String sql;
//        try {
//            
//             sql="delete from cliente where nombre like '%' select *from cliente";
//            stmt=con.createStatement();
//            rs=stmt.executeQuery(sql);//obtener una respuesta
//            while(rs.next()){
//                String dato[]=new String [10];
//                dato[0]=rs.getString(1);
//                dato[1]=rs.getString(2);
//                dato[2]=rs.getString(3);
//                dato[3]=rs.getString(4);
//                 dato[4]=rs.getString(5);
//                 dato[6]=rs.getString(7);
//                 dato[7]=rs.getString(8);
//                 dato[8]=rs.getString(9);
//                 dato[9]=rs.getString(10);
//                baca.addRow(dato);
//               
//                mostrar();
//                        
//            }
//        } 
//            catch (Exception ex) {
//            JOptionPane.showMessageDialog(rootPane,"nooooo","con sulta no valida",JOptionPane.ERROR_MESSAGE);
//        }
//        
//    }
   
    

   
    
   
    

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtape = new javax.swing.JTextField();
        txtdi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        var = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btgravar = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtsu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtte = new javax.swing.JTextField();
        txtcorr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        cbosexo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtes = new javax.swing.JTextField();
        btlimpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 29, -1, -1));

        jLabel2.setText(" nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel3.setText("apellidos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setText("direccion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));
        getContentPane().add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 150, -1));
        getContentPane().add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 150, -1));
        getContentPane().add(txtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 150, 20));
        getContentPane().add(txtdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, -1));

        var.setBackground(new java.awt.Color(51, 255, 153));
        var.setForeground(new java.awt.Color(204, 0, 0));
        var.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(var);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 730, 180));

        jButton1.setText("nuevo");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        btgravar.setText("grabar");
        btgravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgravarActionPerformed(evt);
            }
        });
        getContentPane().add(btgravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        btmodificar.setText("modificar");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, -1));

        jButton4.setText("eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, -1, -1));

        jLabel5.setText("sieldo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));
        getContentPane().add(txtsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 100, -1));

        jLabel6.setText("telefono");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabel7.setText("correo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));
        getContentPane().add(txtte, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 100, -1));

        txtcorr.setText(" ");
        getContentPane().add(txtcorr, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 100, -1));

        jLabel8.setText("dni");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));
        getContentPane().add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 100, -1));

        cbosexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "s", "F", "M" }));
        getContentPane().add(cbosexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        jLabel9.setText("estado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));
        getContentPane().add(txtes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 100, -1));

        btlimpiar.setText(" limpiar");
        btlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jButton2.setText("mostar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jButton3.setText(" eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jButton5.setText("modicar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 70, -1));

        jLabel10.setText("total de reguistro");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_btmodificarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       limpiar();
        
// TODO add your handling code here
//     String sql;
//        try {
//             sql="DELETE FROM cliente  HWERE id_clie='C01' select* from cliente";
//            stmt=con.createStatement();
//            rs=stmt.executeQuery(sql);//obtener una respuesta
//            while(rs.next()){
//                String dato[]=new String [4];
//                dato[0]=rs.getString(1);
//                dato[1]=rs.getString(2);
//                dato[2]=rs.getString(3);
//                dato[3]=rs.getString(4);
//                
//                
//                baca.addRow(dato);
//                        
//            }
//        } 
//            catch (Exception ex) {
//            JOptionPane.showMessageDialog(rootPane,"nooooo","con sulta no valida",JOptionPane.ERROR_MESSAGE);
//        }
//    
//    
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btgravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btgravarActionPerformed
        // TODO add your handling code here:
        registrar();
         txtcod.setText("");
    txtno.setText("");
    txtape.setText("");
 cbosexo.setSelectedItem("");
    txtdni.setText("");
    txtte.setText("");
    txtcorr.setText("");
    txtdi.setText("");
    txtsu.setText("");
    }//GEN-LAST:event_btgravarActionPerformed

    private void btlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlimpiarActionPerformed
        limpiaTabla();
    }//GEN-LAST:event_btlimpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   
     
        String sql,valor;
        valor=txtcod.getText();
        try {
               int fila,total;
        fila=var.getSelectedRow();
        if(fila>=0)
            baca.removeRow(fila);
            else
         
            JOptionPane.showMessageDialog(null,"SELECCIONE UNA FILA PORFAVOR");  
  
         total=baca.getRowCount();
           
         txttotal.setText(String.valueOf(total));
            
             sql="delete from cliente where id_clie = '"+valor+"' select *from cliente";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
            while(rs.next()){
                String dato[]=new String [10];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                 dato[4]=rs.getString(5);
                 dato[6]=rs.getString(7);
                 dato[7]=rs.getString(8);
                 dato[8]=rs.getString(9);
                 dato[9]=rs.getString(10);
                baca.addRow(dato);
               
                mostrar();
                 
                        
            }
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","con sulta no valida",JOptionPane.ERROR_MESSAGE);
        }
        
    
   
      
         
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   llenar();
   registrar();
   mostrar();
   
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
            java.util.logging.Logger.getLogger(frmcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmcliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btgravar;
    private javax.swing.JButton btlimpiar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JComboBox<String> cbosexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcorr;
    private javax.swing.JTextField txtdi;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtes;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtsu;
    private javax.swing.JTextField txtte;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTable var;
    // End of variables declaration//GEN-END:variables
}
