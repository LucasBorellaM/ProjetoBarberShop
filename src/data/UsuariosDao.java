package data;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class UsuariosDao {
    private final Conexao conexao;
    private final Connection con;
    private PreparedStatement ps;

    public UsuariosDao() {
        this.conexao = new Conexao();
        this.con = this.conexao.getConection();
      }

    /**
    * Método que fará uma consulta no banco de dados que confirmará a validação do acesso de usuário ao sistema
    * @param usuario 
    * @return usuarioEncontrado
    */
    public static Usuarios validaUsuario(Connection con, Usuarios usu){
        Usuarios usuarioEncontrado = null;
        
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE login = ? AND senha = ?")) {
            ps.setString(1, usu.getLogin());
            ps.setString(2, usu.getSenha());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                usuarioEncontrado = new Usuarios();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));

            }
        }catch(SQLException se){
            System.out.println("Sintaxe de comando invalida "+ se.getMessage());
        }
        return usuarioEncontrado;
    }
    
}
