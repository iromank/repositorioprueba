
package ventas;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class frmpractica8 extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
String co,no,dni,ap,apm,di,cre,es;
    DefaultTableModel baca= new DefaultTableModel ();
    public frmpractica8() {
        initComponents();
        String titulos[]= {"id_clie","nom_clie","ape_pat","ape_mat","direccion","lim_credito","estado",};
        baca.setColumnIdentifiers(titulos);
        clie.setModel(baca);  
    
      
 
        setSize(835,550);
        setLocation(300,100);
        conectarJDBC();
         }
       void limpiaTabla(){
        try{
//          baca = (DefaultTableModel) clie.getModel();
            int a =baca.getRowCount()-0;
            for(int i=0; i<a; i++)
                baca.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
        }catch(Exception e){
             System.out.println(e);
        }
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
          private void mostra (){ 
         
         String valor=txtda.getText();//segundo paso crear la variable
         
         
         try {
         String sql="select * from cliente";
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);//obtenemos la respuesta del sql
         while(rs.next())
         {
             String[]datos=new String[7];
             datos[0]=rs.getString(1);
             datos[1]=rs.getString(2);
             datos[2]=rs.getString(3);
             datos[3]=rs.getString(4);
             datos[4]=rs.getString(5);
             datos[5]=rs.getString(6);
             datos[6]=rs.getString(7);
             
             baca.addRow(datos);    
         }
           //con.close();
           //stmt.close();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(rootPane,ex.getMessage());      
         }
         
     }
     private void mostrar (){ 
         
         String valor=txtda.getText();//segundo paso crear la variable
         
         
         try {
         String sql="select * from cliente where nom_clie='"+valor+"'";
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);//obtenemos la respuesta del sql
         while(rs.next())
         {
             String[]datos=new String[7];
             datos[0]=rs.getString(1);
             datos[1]=rs.getString(2);
             datos[2]=rs.getString(3);
             datos[3]=rs.getString(4);
             datos[4]=rs.getString(5);
             datos[5]=rs.getString(6);
             datos[6]=rs.getString(7);
             
             baca.addRow(datos);    
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
         String sql="select * from cliente where ape_pat='"+valor+"'";
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);//obtenemos la respuesta del sql
         while(rs.next())
         {
             String[]datos=new String[7];
             datos[0]=rs.getString(1);
             datos[1]=rs.getString(2);
             datos[2]=rs.getString(3);
             datos[3]=rs.getString(4);
             datos[4]=rs.getString(5);
             datos[5]=rs.getString(6);
             datos[6]=rs.getString(7);
             
             baca.addRow(datos);    
         }
           //con.close();
           //stmt.close();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(rootPane,ex.getMessage());      
         }
         
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
      public void modificar(){
        
     String  sql;
        try {
            
             sql="update cliente set nom_clie='"+no+"',ape_pat='"+ap+"',ape_mat='"+apm+"',direccion='"+di+"',lim_credito='"+cre+"',estado='"+es+"' WHERE id_clie='"+co+"'";

            stmt=con.createStatement();
            stmt.execute(sql);//obtener una respuesta
                
            
           
            
        } 
            catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"con sulta no valida");
        }
          }       
       public void eliminar(){
        
     String  sql;
        try {
            
             sql="delete from cliente  nom_clie='"+no+"',ape_pat='"+ap+"',ape_mat='"+apm+"',direccion='"+di+"',lim_credito='"+cre+"',estado='"+es+"' WHERE id_clie='"+co+"'";

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbno = new javax.swing.JRadioButton();
        btbus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clie = new javax.swing.JTable();
        rbape = new javax.swing.JRadioButton();
        txtda = new javax.swing.JTextField();
        btsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnuev = new javax.swing.JButton();
        btguardar = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtco = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtap = new javax.swing.JTextField();
        txtapm = new javax.swing.JTextField();
        txtdi = new javax.swing.JTextField();
        txtcre = new javax.swing.JTextField();
        txtes = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txttotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtt = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

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

        clie.setBackground(new java.awt.Color(0, 255, 204));
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
        clie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clieMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clie);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 120));

        buttonGroup1.add(rbape);
        rbape.setText("apellidos");
        rbape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbapeActionPerformed(evt);
            }
        });
        getContentPane().add(rbape, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));
        getContentPane().add(txtda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 280, -1));

        btsalir.setText("salir");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

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
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        jLabel3.setText("codigo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jLabel4.setText("nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        jLabel5.setText("ape pat");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        jLabel6.setText("ape mat");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        jLabel7.setText("direccion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        jLabel8.setText("limite credito");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        jLabel9.setText("estado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));
        getContentPane().add(txtco, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 70, -1));
        getContentPane().add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 100, -1));
        getContentPane().add(txtap, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 110, -1));
        getContentPane().add(txtapm, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 120, -1));

        txtdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiActionPerformed(evt);
            }
        });
        getContentPane().add(txtdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 120, -1));
        getContentPane().add(txtcre, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 100, -1));
        getContentPane().add(txtes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 120, -1));

        jLabel11.setText("stado");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("datos de cliente");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 280, 270));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 60, -1));

        jLabel12.setText("total de registros");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, 20));

        jButton1.setText("exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jLabel13.setText("total de columnas");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));
        getContentPane().add(txtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 60, -1));

        jMenu1.setText("busacar clientes");

        jMenuItem1.setText("salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("por codigo");

        jMenuItem2.setText("cosulta por codigo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("conulta por direccion");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("direcion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("consulta limite credito");

        jMenuItem4.setText("por credito");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setText(" total reguistrado");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbusActionPerformed
        // TODO add your handling code here:
                  limpiaTabla();
                if(rbno.isSelected())
                    mostrar();
                if(rbape.isSelected())
                    mostrar2();
                btguardar.setEnabled(false);
                txtda.setText("");
                int total,t;
                t=clie.getColumnCount();
                txtt.setText(String.valueOf(t));
                total=clie.getRowCount();
                txttotal.setText(String.valueOf(total));
                nuevo ();
                btmodificar.setEnabled(true);
                bteliminar.setEnabled(true);
                btsalir.setEnabled(true);
               
                
                      
                
         

    }//GEN-LAST:event_btbusActionPerformed

    private void rbnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnoActionPerformed
        txtda.setText("");
     
    }//GEN-LAST:event_rbnoActionPerformed

    private void rbapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbapeActionPerformed
        txtda.setText("");
    }//GEN-LAST:event_rbapeActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        // TODO add your handling code here:
        dispose();
        new bmenu (). setVisible (true);
    }//GEN-LAST:event_btsalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
       
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       direcionclie();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       crediclie();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void txtdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiActionPerformed

    private void btnuevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevActionPerformed
          nuevo ();
            bteliminar.setEnabled(false);
        btmodificar.setEnabled(false);
        btguardar.setEnabled(true);
        btsalir.setEnabled(false);
          limpiaTabla();
           int total;
                total=clie.getRowCount();
                txttotal.setText(String.valueOf(total));
            
    }//GEN-LAST:event_btnuevActionPerformed

    private void clieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clieMouseClicked
        // TODO add your handling code here:
         btguardar.setEnabled(false);
        btmodificar.setEnabled(true);
        bteliminar.setEnabled(true);
       
          int fila=clie.getSelectedRow();
        txtco.setText(clie.getValueAt(fila,0).toString());
        txtno.setText(clie.getValueAt(fila,1).toString());
        txtap.setText(clie.getValueAt(fila,2).toString());
        txtapm.setText(clie.getValueAt(fila,3).toString());
        txtdi.setText(clie.getValueAt(fila,4).toString());
        txtcre.setText(clie.getValueAt(fila,5).toString());
        txtes.setText(clie.getValueAt(fila,6).toString());
        
    
    }//GEN-LAST:event_clieMouseClicked

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
       mostra() ;   
        int total,t;
                t=clie.getColumnCount();
                txtt.setText(String.valueOf(t));
                total=clie.getRowCount();
                txttotal.setText(String.valueOf(total));
                        
                 }                                        

         
       btsalir.setEnabled(true);
    }//GEN-LAST:event_btguardarActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
        llenar();
        modificar();
        limpiaTabla();
         nuevo();
       mostrar();
       mostrar2();
       mostra();
       
            
    }//GEN-LAST:event_btmodificarActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
        
        llenar();
        eliminar();
        limpiaTabla();
        nuevo();
        mostrar();
        mostrar2();
         int total;
                total=clie.getRowCount();
                txttotal.setText(String.valueOf(total));
        
        
    }//GEN-LAST:event_bteliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
            java.util.logging.Logger.getLogger(frmpractica8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpractica8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpractica8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpractica8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpractica8().setVisible(true);
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
    public static javax.swing.JTable clie;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbape;
    private javax.swing.JRadioButton rbno;
    private javax.swing.JTextField txtap;
    private javax.swing.JTextField txtapm;
    private javax.swing.JTextField txtco;
    private javax.swing.JTextField txtcre;
    private javax.swing.JTextField txtda;
    public static javax.swing.JTextField txtdi;
    private javax.swing.JTextField txtes;
    public static javax.swing.JTextField txtno;
    private javax.swing.JTextField txtt;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

   

    private void direcionclie() {
        new con4 (). setVisible (true);
        dispose();
    }

    private void crediclie() {
         new frmpractica3 (). setVisible (true);
        dispose();
 
    }
}
