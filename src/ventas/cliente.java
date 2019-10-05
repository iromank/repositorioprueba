/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
public class cliente extends javax.swing.JFrame {

       Connection con;
    ResultSet rs;
    Statement  stmt;
    String co,no,dni,ap,apm,di,cre,es;
    DefaultTableModel  baca =new DefaultTableModel();
    
    public cliente() {
        initComponents();
        baca.addColumn("codigo");
       baca.addColumn("nombre");
//       baca.addColumn("dni");
       baca.addColumn("apellido");
       baca.addColumn("apellido materno");
       baca.addColumn("direccion");
       baca.addColumn("limite credito");
       baca.addColumn("estado");
       this.cliente.setModel(baca);
       setSize(650,550);
       setLocation(600,100);
       conectar();
       mostrar();
   }
    
    void limpiaTabla(){
        try{
          baca = (DefaultTableModel) cliente.getModel();
            int a =baca.getRowCount()-0;
            for(int i=0; i<a; i++)
                baca.removeRow(0); 
        }catch(Exception e){
            System.out.println(e);
        }
         }
   
        public void conectar()
    {
    
    String url="jdbc:sqlserver://localhost; databaseName=baca;user=sa; password=123456";
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

    
        public void llenar()
                {
                     if (txtco.getText().equals(""))  {
            JOptionPane.showMessageDialog(this, "Ingrese cod");
            
        }
     
         if (txtno.getText().equals("")){
             
         
             JOptionPane.showMessageDialog(this,"ingresa  nombre");
             }
          
         if(txtap.getText().equals("")){
                         JOptionPane.showMessageDialog(this, "ingrese apellido");
                     }
          if (txtapm.getText().equals(""))  {
            JOptionPane.showMessageDialog(this, "Ingrese apellido materno");
            
        }
     
         if (txtdi.getText().equals("")){
             
         
             JOptionPane.showMessageDialog(this,"ingresa dni");
             }
         if(txtcre.getText().equals("")){
                         JOptionPane.showMessageDialog(this, "ingrese credito");
                     }
               if(txtes.getText().equals("")){
                         JOptionPane.showMessageDialog(this, "ingrese estado");
                     }
         
    co=txtco.getText();
    no=txtno.getText();
//    dni=txtdni.getText();
    ap=txtap.getText();
    apm=txtapm.getText();
    di=txtdi.getText();
    cre=txtcre.getText();
    es=txtes.getText();
    
    
    }
        public void registrar(){
                
                 try {
                     llenar();
                   String  sql="insert into cliente values( '"+co+"','"+no+"','"+ap+"','"+apm+"','"+di+"','"+cre+"','"+es+"')";
                     stmt=con.createStatement();
                     stmt.execute(sql);
                   
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(rootPane,ex.getMessage());
               
                       }
                   }
         public void limpiar ()
             {
                 
         }
         public void nuevo ()
             {
                 txtco.setText("");
                 txtno.setText("");
//                  txtdni.setText("");
                 txtap.setText("");
                 txtapm.setText("");
                 txtcre.setText("");
                 txtdi.setText("");
                 txtes.setText("");
                 txtco.requestFocus();
         }
                  public void mostrar(){
     String sql;
        try {
            
             sql="SELECT*FROM CLIENTE ";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
          }
                 
                      
                   public void eliminar(){
        String   valor2,valor=txtco.getText();
                 
     String  sql;
        try {
            
             sql="delete FROM CLIENTE where id_clie='"+valor+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
            
        }
          }
                               public void eliminarape(){
        String   
                  valor2=txtap.getText();
     String  sql;
        try {
            
             sql="delete FROM CLIENTE where ape_pat='"+valor2+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
            
        }
          }
                   public void eliminardireccion(){
        String   valor3=txtdi.getText();
     String  sql;
        try {
            
             sql="delete FROM CLIENTE where direccion='"+valor3+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
            
        }
          }
                 
                            public void modificarnom(){
        String valor5, valor4=txtap.getText();
        valor5=txtco.getText();
        
     String  sql;
        try {
            
             sql="update cliente set ape_pat='"+valor4+"' WHERE id_clie='"+valor5+"'";

            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
            
        }
          }       
                      
                public void modificarnape(){
        String  valor7=txtapm.getText();
        String valor6=txtco.getText();
        
     String  sql;
        try {
            
             sql="update cliente set ape_mat='"+valor7+"' WHERE id_clie='"+valor6+"'";

            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
            
        }
          }       
                
                 public void modificarnombre(){
        String  valor8=txtno.getText();
        String valor9=txtco.getText();
        
     String  sql;
        try {
            
             sql="update cliente set nom_clie='"+valor8+"' WHERE id_clie='"+valor9+"'";

            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
            
        }
          }       
                             
                 
        public void modificardire(){
        String  valor10=txtdi.getText();
        String valor11=txtco.getText();
        
     String  sql;
        try {
            
             sql="update cliente set direccion='"+valor10+"' WHERE id_clie='"+valor11+"'";

            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
            
        }
          }       
                             
         public void modificarlimte(){
        String  valor12=txtcre.getText();
        String valor13=txtco.getText();
        
     String  sql;
        try {
            
             sql="update cliente set lim_credito='"+valor12+"' WHERE id_clie='"+valor13+"'";

            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
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
            
        }
          }       
                                public void modificar(){
        String  valor12=txtcre.getText();
        String valor13=txtco.getText();
        
     String  sql;
        try {
            
             sql="update cliente set nom_clie='"+no+"',ape_pat='"+ap+"',ape_mat='"+apm+"',direccion='"+di+"',lim_credito='"+cre+"',estado='"+es+"' WHERE id_clie='"+co+"'";

            stmt=con.createStatement();
            stmt.execute(sql);//obtener una respuesta
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtco = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtap = new javax.swing.JTextField();
        txtapm = new javax.swing.JTextField();
        txtdi = new javax.swing.JTextField();
        txtcre = new javax.swing.JTextField();
        txtes = new javax.swing.JTextField();
        btnuevo = new javax.swing.JButton();
        btguardar = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cliente = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel2.setText("nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel3.setText("ape pat");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jLabel4.setText("ape mat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        jLabel5.setText("direccion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel6.setText("limite credito");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jLabel7.setText("estado");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 211, -1, -1));
        getContentPane().add(txtco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 70, -1));
        getContentPane().add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, -1));
        getContentPane().add(txtap, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 110, -1));
        getContentPane().add(txtapm, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 120, -1));

        txtdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiActionPerformed(evt);
            }
        });
        getContentPane().add(txtdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 120, -1));
        getContentPane().add(txtcre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 100, -1));
        getContentPane().add(txtes, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 208, 120, -1));

        btnuevo.setText("nuevo");
        btnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        btguardar.setText("grabar");
        btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 70, -1));

        btmodificar.setText("modificar");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, 20));

        jButton4.setText("salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 70, -1));

        cliente.setBackground(new java.awt.Color(51, 255, 102));
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
        cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, 230));

        jButton5.setText(" mostar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("registrar cliente de la tienda don pepe");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jButton6.setText("limpiar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        bteliminar.setText("eliminar");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });
        getContentPane().add(bteliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));

        jButton1.setText("actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiActionPerformed

    private void btguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguardarActionPerformed
       llenar();
        int x;
                 String sql;
                 x=JOptionPane.showConfirmDialog(rootPane,"deseas gravar","registro de vendedor",
                         JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                 if (x==0){
                       
                         registrar();
                 }
                 nuevo();
                 limpiaTabla();
      mostrar();
    }//GEN-LAST:event_btguardarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           limpiaTabla();
        mostrar()  ; 
 // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevoActionPerformed
       nuevo();
       bteliminar.setEnabled(false);
        btmodificar.setEnabled(false);
        btguardar.setEnabled(true);
       
       
    }//GEN-LAST:event_btnuevoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       dispose();
       new bmenu (). setVisible( true);
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      limpiaTabla();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
        eliminar();
        eliminarape();
        eliminardireccion();
        nuevo();
        limpiaTabla();
        mostrar();
    }//GEN-LAST:event_bteliminarActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
      modificarnom();
      modificarnape();
      modificarnombre();
      modificardire();
   modificarlimte();
        limpiaTabla();
        nuevo();
          mostrar();
        
    }//GEN-LAST:event_btmodificarActionPerformed

    private void clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteMouseClicked
//        JOptionPane.showMessageDialog(null,"prueva","seleciono una fila",JOptionPane.INFORMATION_MESSAGE);
        btguardar.setEnabled(false);
        btmodificar.setEnabled(true);
        bteliminar.setEnabled(true);
        
int fila=cliente.getSelectedRow();
        txtco.setText(cliente.getValueAt(fila,0).toString());
        txtno.setText(cliente.getValueAt(fila,1).toString());
        txtap.setText(cliente.getValueAt(fila,2).toString());
        txtapm.setText(cliente.getValueAt(fila,3).toString());
        txtdi.setText(cliente.getValueAt(fila,4).toString());
        txtcre.setText(cliente.getValueAt(fila,5).toString());
        txtes.setText(cliente.getValueAt(fila,6).toString());
        
    }//GEN-LAST:event_clienteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         llenar();
        modificar();
        limpiaTabla();
        mostrar();
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
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton btguardar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JButton btnuevo;
    private javax.swing.JTable cliente;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtap;
    private javax.swing.JTextField txtapm;
    private javax.swing.JTextField txtco;
    private javax.swing.JTextField txtcre;
    private javax.swing.JTextField txtdi;
    private javax.swing.JTextField txtes;
    private javax.swing.JTextField txtno;
    // End of variables declaration//GEN-END:variables
}
