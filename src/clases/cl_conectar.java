
package clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BACA VARGAS
 */
public class cl_conectar  implements I_conectar{
    Connection con=null;
    public boolean  conexion(){
        boolean si=false;
        String servidor="jdbc:mysql://"+ur+":3306/"+bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(servidor,usuario, pass);
            si=true;
        } catch (Exception e) {
        }
        return si;
    }
    
}
