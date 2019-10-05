import javax.swing.*;
public class baca extends javax.swing.JFrame {
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
      String a,a1="usuario",b,b1="contraseña";
      int g,h,j=3,r=0;
      while(j!=0)
          {
              j--;
              r++;
              JOptionPane.showMessageDialog(null," intente N°:"+r);
             a=JOptionPane.showInputDialog(" ingresa usuario");
              b=JOptionPane.showInputDialog(" ingresa contraseña");
             
        if(a==""&&b=="")
                   {
                           JOptionPane.showMessageDialog(null," ingresa usuario y contraseña");    

                   }
              
            
            }

        }
      
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
