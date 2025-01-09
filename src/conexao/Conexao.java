package conexao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class Conexao {
    Connection conn;
    
    public Connection getConection(){
        String url = "jdbc:mysql://127.0.0.1:3306/BarberShop";
        String user = "root";
        String password = "12345";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;
            
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Falha ao conectar ao banco de dados: "+ e.getMessage());
            return null;
        }
    }
    
    public void desconnect(){
        try{
            conn.close();
        }catch(SQLException e){
            System.out.println("Falha ao desconectar do banco de dados: "+ e.getMessage());
        }
    }

    
    
}
