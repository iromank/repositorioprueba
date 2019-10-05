

package ventas;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
public class cosultaproducto extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    Statement  stmt;
    
    String 
    co,pro;
     int st,sm,smx;
    double p;
     DefaultTableModel  baca =new DefaultTableModel();
    public cosultaproducto() {
        initComponents();
         setSize(830,500);
        setLocation(340,100);
         baca.addColumn("codigo");
       baca.addColumn("producto");
       baca.addColumn("stock actual");
       baca.addColumn("stock minimo");
       baca.addColumn("stock maximo");
       baca.addColumn("precio de venta");

        this.producto.setModel(baca);
        conectarJDBC();
    }
 public void conectarJDBC()
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
         String sql="select * from producto where desc_prod='"+valor+"'";
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);//obtenemos la respuesta del sql
         while(rs.next())
         {
             
              String dato[]=new String [6];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                dato[5]=rs.getString(6);
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
         String sql="select * from producto where prec_venta='"+valor+"'";
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);//obtenemos la respuesta del sql
         while(rs.next())
         {
             
             String dato[]=new String [6];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                dato[5]=rs.getString(6);
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
     
         if (txtpro.getText().equals("")){
             
         
             JOptionPane.showMessageDialog(this,"ingresa  producto");
             }
          
         if(txtst.getText().equals("")){
                         JOptionPane.showMessageDialog(this, "ingrese estoc actual");
                     }
          if (txtsm.getText().equals(""))  {
            JOptionPane.showMessageDialog(this, "Ingrese stoxc minimo");
            
        }
     
         if (txtmx.getText().equals("")){
             
         
             JOptionPane.showMessageDialog(this,"ingresa stock maximo");
             }  
                   
          if (txtp.getText().equals("")){
             
         
             JOptionPane.showMessageDialog(this,"ingresa stock maximo");
             }  
         
    co=txtco.getText();
    pro=txtpro.getText();
     st=Integer.parseInt(txtst.getText());
    sm=Integer.parseInt(txtsm.getText());
    smx=Integer.parseInt(txtmx.getText());
  
   p=Double.parseDouble(txtp.getText());

    
    
    }
             public void registrar(){
                
                 try {
                     llenar();
                   String  sql="insert into producto values( '"+co+"','"+pro+"','"+st+"','"+sm+"','"+smx+"','"+p+"')";
                     stmt=con.createStatement();
                     stmt.execute(sql);
                   
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(rootPane,ex.getMessage());
               
                       }
                   }
             public void modificar(){
        
     String  sql;
        try {
            
             sql="update producto set desc_prod='"+pro+"',stock_actual='"+st+"',stock_min='"+sm+"'"
                     + ",stock_max='"+smx+"',prec_venta="+p+" WHERE id_prod='"+co+"'";

            stmt=con.createStatement();
            stmt.execute(sql);//obtener una respuesta
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
            JOptionPane.showMessageDialog(this,"con sulta falla");
        }
          }   
              public void mostratodo(){
     String sql;
        try {
            
             sql="SELECT*FROM producto ";
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
               
               void limpiaTabla(){
        try{
          baca = (DefaultTableModel) producto.getModel();
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
                 txtpro.setText("");
//                  txtdni.setText("");
                 txtst.setText("");
                 txtsm.setText("");
                 txtmx.setText("");
                 txtp.setText("");
                 txtco.requestFocus();
                 txtda.setText("");
         }
                 public void eliminar(){
        
     String  sql;
        try {
            
             sql="delete from producto where  id_prod='"+co+"'";

            stmt=con.createStatement();
            stmt.execute(sql);//obtener una respuesta
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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtp = new javax.swing.JTextField();
        txtst = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtsm = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmx = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtpro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rbno = new javax.swing.JRadioButton();
        btbus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        producto = new javax.swing.JTable();
        rbape = new javax.swing.JRadioButton();
        txtda = new javax.swing.JTextField();
        btsalir = new javax.swing.JButton();
        btnuev = new javax.swing.JButton();
        btguardar = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txttota = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("precio venta");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        jPanel2.add(txtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 70, -1));
        jPanel2.add(txtst, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 70, -1));

        jLabel3.setText("stock actual");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));
        jPanel2.add(txtsm, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 70, -1));

        jLabel4.setText("stoc minimo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        jPanel2.add(txtmx, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 70, -1));

        jLabel5.setText("stock maximo");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));
        jPanel2.add(txtpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 110, 20));

        jLabel2.setText("producto");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        jPanel2.add(txtco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 80, -1));

        jLabel1.setText("codigo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 210, 240));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("consulatr los  producto ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 15, 230, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("datos del producto");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        buttonGroup1.add(rbno);
        rbno.setText("descripcion");
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
        getContentPane().add(btbus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        producto.setBackground(new java.awt.Color(0, 204, 204));
        producto.setModel(new javax.swing.table.DefaultTableModel(
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
        producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(producto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 120));

        buttonGroup1.add(rbape);
        rbape.setText("precio");
        rbape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbapeActionPerformed(evt);
            }
        });
        getContentPane().add(rbape, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));
        getContentPane().add(txtda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 280, -1));

        btsalir.setText("salir");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        btnuev.setText("nuevo");
        btnuev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevActionPerformed(evt);
            }
        });
        getContentPane().add(btnuev, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        btguardar.setText("grabar");
        btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        btmodificar.setText("modificar");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

        bteliminar.setText("eliminar");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });
        getContentPane().add(bteliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        jLabel9.setText("estado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jButton1.setText("mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel10.setText("TOTAL DE REGISTROS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));
        getContentPane().add(txttota, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 80, 30));

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
        nuevo();
        total=baca.getRowCount();
        txttota.setText(String.valueOf(total));
        txtda.requestFocus();

    }//GEN-LAST:event_btbusActionPerformed

    private void productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productoMouseClicked
        // TODO add your handling code here:
        btguardar.setEnabled(false);
        btmodificar.setEnabled(true);
        bteliminar.setEnabled(true);
        int fila=producto.getSelectedRow();
        txtco.setText(producto.getValueAt(fila,0).toString());
        txtpro.setText(producto.getValueAt(fila,1).toString());
        txtst.setText(producto.getValueAt(fila,2).toString());
        txtsm.setText(producto.getValueAt(fila,3).toString());
        txtmx.setText(producto.getValueAt(fila,4).toString());
        txtp.setText(producto.getValueAt(fila,4).toString());


    }//GEN-LAST:event_productoMouseClicked

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mostratodo();
        int total;
        total=baca.getRowCount();
        txttota.setText(String.valueOf(total));
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
            java.util.logging.Logger.getLogger(cosultaproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cosultaproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cosultaproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cosultaproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cosultaproducto().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable producto;
    private javax.swing.JRadioButton rbape;
    private javax.swing.JRadioButton rbno;
    private javax.swing.JTextField txtco;
    private javax.swing.JTextField txtda;
    private javax.swing.JTextField txtmx;
    private javax.swing.JTextField txtp;
    private javax.swing.JTextField txtpro;
    private javax.swing.JTextField txtsm;
    private javax.swing.JTextField txtst;
    private javax.swing.JTextField txttota;
    // End of variables declaration//GEN-END:variables
}
