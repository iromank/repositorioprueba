/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
public class consultavendedor extends javax.swing.JFrame {
 Connection con;
    ResultSet rs;
    Statement  stmt;
    String c,n,apa,apm,su;
   DefaultTableModel  baca =new DefaultTableModel();
   
    public consultavendedor() {
        initComponents();
         baca.addColumn("codigo");
       baca.addColumn("nombre");
       baca.addColumn("apelli partno");
       baca.addColumn("apelli materno");
       baca.addColumn("salario");
       vend.setModel(baca);
       conectar();
    }
   public void conectar()
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


     private void mostrar (){ 
         
         String valor=txtda.getText();//segundo paso crear la variable
         
         
         try {
         String sql="select * from vendedor where nom_vend='"+valor+"'";
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);//obtenemos la respuesta del sql
         while(rs.next())
         {
             
              String dato[]=new String [5];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                baca.addRow(dato);    
         }
           //con.close();
           //stmt.close();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(rootPane,ex.getMessage());      
         }
         
     }
     private void mostrar2 (){ 
         
         String valor=txtda.getText();//segundo paso crear la variable
         
         
         try {
         String sql="select * from vendedor where ape_pat='"+valor+"'";
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);//obtenemos la respuesta del sql
         while(rs.next())
         {
             
             String dato[]=new String [5];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                baca.addRow(dato);   
         }
         
           //con.close();
           //stmt.close();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(rootPane,ex.getMessage());      
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
     
         if (txtsu.getText().equals("")){
             
         
             JOptionPane.showMessageDialog(this,"ingresa dni");
             }  
                    
         
    c=txtco.getText();
    n=txtno.getText();
//    dni=txtdni.getText();
    apa=txtap.getText();
    apm=txtapm.getText();
    su=txtsu.getText();

    
    
    }
               public void registrar(){
                
                 try {
                     llenar();
                   String  sql="insert into vendedor values( '"+c+"','"+n+"','"+apa+"','"+apm+"','"+su+"')";
                     stmt=con.createStatement();
                     stmt.execute(sql);
                   
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(rootPane,ex.getMessage());
               
                       }
                   }
                 public void modificar(){
        
     String  sql;
        try {
            
             sql="update Vendedor set nom_vend='"+n+"',ape_pat='"+apa+"',ape_mat='"+apm+"',salario='"+su+"' where id_vend='"+c+"'";

            stmt=con.createStatement();
            stmt.execute(sql);//obtener una respuesta
            while(rs.next()){
                String dato[]=new String [5];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                
                 
                baca.addRow(dato);
                
            }
           
            
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"con sulta falla");
        }
          }       
                             
               public void mostratodo(){
     String sql;
        try {
            
             sql="SELECT*FROM vendedor ";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);//obtener una respuesta
            while(rs.next()){
                String dato[]=new String [5];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                
                 
                baca.addRow(dato);
                
            }
           
            
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"nooooo","con sulta no valida",JOptionPane.ERROR_MESSAGE);
        }
          }
               
               void limpiaTabla(){
        try{
          baca = (DefaultTableModel) vend.getModel();
            int a =baca.getRowCount()-0;
            for(int i=0; i<a; i++)
                baca.removeRow(0); 
        }catch(Exception e){
            System.out.println(e);
        }
         }
                public void nuevo ()
             {
                 txtco.setText("");
                 txtno.setText("");
//                  txtdni.setText("");
                 txtap.setText("");
                 txtapm.setText("");
                 txtsu.setText("");
                 txtco.requestFocus();
         }
                 public void eliminar(){
        
     String  sql;
        try {
            
             sql="delete from Vendedor where  id_vend='"+c+"'";

            stmt=con.createStatement();
            stmt.execute(sql);//obtener una respuesta
            while(rs.next()){
                String dato[]=new String [5];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                
                 
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbno = new javax.swing.JRadioButton();
        btbus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vend = new javax.swing.JTable();
        rbape = new javax.swing.JRadioButton();
        txtda = new javax.swing.JTextField();
        btsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnuev = new javax.swing.JButton();
        btguardar = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtco = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtap = new javax.swing.JTextField();
        txtapm = new javax.swing.JTextField();
        txtsu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbno);
        rbno.setText("nombre");
        rbno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnoActionPerformed(evt);
            }
        });
        getContentPane().add(rbno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        btbus.setText("buscar");
        btbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbusActionPerformed(evt);
            }
        });
        getContentPane().add(btbus, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        vend.setBackground(new java.awt.Color(0, 204, 204));
        vend.setModel(new javax.swing.table.DefaultTableModel(
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
        vend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vendMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(vend);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 120));

        buttonGroup1.add(rbape);
        rbape.setText("apellidos");
        rbape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbapeActionPerformed(evt);
            }
        });
        getContentPane().add(rbape, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));
        getContentPane().add(txtda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 280, -1));

        btsalir.setText("salir");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("consular por nombre y apellidos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btnuev.setText("nuevo");
        btnuev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevActionPerformed(evt);
            }
        });
        getContentPane().add(btnuev, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        btguardar.setText("grabar");
        btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        btmodificar.setText("modificar");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        bteliminar.setText("eliminar");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });
        getContentPane().add(bteliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        jLabel3.setText("codigo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        jLabel4.setText("nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        jLabel5.setText("ape pat");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jLabel6.setText("ape mat");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        jLabel7.setText("salario");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        jLabel9.setText("estado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));
        getContentPane().add(txtco, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 70, -1));
        getContentPane().add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 100, -1));
        getContentPane().add(txtap, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 110, -1));
        getContentPane().add(txtapm, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 120, -1));

        txtsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsuActionPerformed(evt);
            }
        });
        getContentPane().add(txtsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 120, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("datos del vendedor");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 240, 270));

        jButton1.setText("mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 70, -1));

        jLabel2.setText("TOTAL DE REGISTRO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 324, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnoActionPerformed
        txtda.setText("");

    }//GEN-LAST:event_rbnoActionPerformed

    private void btbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbusActionPerformed
        // TODO add your handling code here:
        int total;
        limpiaTabla();
        if(rbno.isSelected())
        mostrar();
        if(rbape.isSelected())
        mostrar2();
        btguardar.setEnabled(false);
         total=baca.getRowCount();
     txttotal.setText(String.valueOf(total));
        

    }//GEN-LAST:event_btbusActionPerformed

    private void vendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vendMouseClicked
        // TODO add your handling code here:
        btguardar.setEnabled(false);
        btmodificar.setEnabled(true);
        bteliminar.setEnabled(true);
        int fila=vend.getSelectedRow();
        txtco.setText(vend.getValueAt(fila,0).toString());
        txtno.setText(vend.getValueAt(fila,1).toString());
        txtap.setText(vend.getValueAt(fila,2).toString());
        txtapm.setText(vend.getValueAt(fila,3).toString());
        txtsu.setText(vend.getValueAt(fila,4).toString());
       
    }//GEN-LAST:event_vendMouseClicked

    private void rbapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbapeActionPerformed
        txtda.setText("");
    }//GEN-LAST:event_rbapeActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        // TODO add your handling code here:
        dispose();
        new bmenu (). setVisible (true);
    }//GEN-LAST:event_btsalirActionPerformed

    private void btnuevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevActionPerformed
        nuevo ();
        bteliminar.setEnabled(false);
        btmodificar.setEnabled(false);
        btguardar.setEnabled(true);
        btsalir.setEnabled(false);
        limpiaTabla();

    }//GEN-LAST:event_btnuevActionPerformed

    private void btguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguardarActionPerformed
        int x;
        String sql;
        x=JOptionPane.showConfirmDialog(rootPane,"deseas gravar","registro de vendedor",
            JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if (x==0){
            btsalir.setEnabled(true);
            registrar();
            limpiaTabla();
            nuevo();
            mostrar();
            mostrar2();
            mostratodo() ;

        }

    }//GEN-LAST:event_btguardarActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
         limpiaTabla();
        llenar();
        modificar();
       nuevo();
        mostratodo();

    }//GEN-LAST:event_btmodificarActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed

        llenar();
        eliminar();
        limpiaTabla();
        nuevo();
        mostrar();
        mostrar2();
        mostratodo();

    }//GEN-LAST:event_bteliminarActionPerformed

    private void txtsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       mostratodo();
       int total;
           total=baca.getRowCount();
     txttotal.setText(String.valueOf(total));
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
            java.util.logging.Logger.getLogger(consultavendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultavendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultavendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultavendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultavendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbus;
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton btguardar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JButton btnuev;
    private javax.swing.JButton btsalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbape;
    private javax.swing.JRadioButton rbno;
    private javax.swing.JTextField txtap;
    private javax.swing.JTextField txtapm;
    private javax.swing.JTextField txtco;
    private javax.swing.JTextField txtda;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtsu;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTable vend;
    // End of variables declaration//GEN-END:variables
}
