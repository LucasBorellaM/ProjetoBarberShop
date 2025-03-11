package data;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author lucas
 */
public class ClientesDao {
    private Conexao conexao;
    private Connection con;
    private PreparedStatement ps;

    public ClientesDao() {
        this.conexao = new Conexao();
        this.con = this.conexao.getConection();
      }
    
    
    /**
     * método de inserir dados no banco de dados por um objeto do tipo Clientes passado como parâmetro
     * @param clie
     * @return status
     */
    public int salvar(Clientes clie){
        int status;
        try{
            ps = this.con.prepareStatement("INSERT INTO clientes VALUES (default,?,?,?,?)");
            ps.setString(1, clie.getNome());
            ps.setString(2, clie.getCpf());
            ps.setString(3, clie.getDataNascimento());
            ps.setString(4, clie.getTelefone());
            
            status = ps.executeUpdate();
            return status;
        }catch(SQLException e){
            System.out.println("Falha ao salvar cliente: "+ e.getMessage());
            return e.getErrorCode();
        }
    }
    
    /**
     * Método que realiza uma consulta no banco de dados e busca os dados do cliente com base no id específico passado
     * pelo usuário por parametro
     * @param id
     * @return cliente
     */
    public Clientes getClientes(int id){
        try{
            ps = this.con.prepareStatement("SELECT * FROM clientes WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Clientes cliente = new Clientes();
            rs.next();
            cliente.setId(id);
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setDataNascimento(rs.getString("dataNascimento"));
            cliente.setTelefone(rs.getString("telefone"));
            
            return cliente;
            
        }catch(SQLException e){
            System.out.println("Falha ao buscar cliente: "+ e.getMessage());
            return null;
        }
    }
    
    /**
     * Método atualiza dados já cadastrados no banco de dados, alterando informações com base no id no id informado pelo usuário
     * @param clie 
     */
    public void atualizar(Clientes clie){
        try{
            ps = this.con.prepareStatement("UPDATE clientes SET nome =?, cpf =?, dataNascimento =?, telefone =? WHERE id =?", ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            
            ps.setString(1, clie.getNome());
            ps.setString(2, clie.getCpf());
            ps.setString(3, clie.getDataNascimento());
            ps.setString(4, clie.getTelefone());
            ps.setInt(5, clie.getId());
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Falha ao atualizar cliente: "+ e.getMessage());
        }
    }
    
    /**
     * Método exlui dados do banco de dados com base no id informado pelo usuário
     * @param id 
     */
    public void excluir(int id){
        try{
            ps = this.con.prepareStatement("DELETE FROM clientes WHERE id =?");
            
            ps.setInt(1, id);
            ps.execute();
            
        }catch(SQLException e){
            System.out.println("Falha ao deletar cliente: "+ e.getMessage());
        }
    }
    
    /**
     * Método pega todos os dados da tabela clientes do banco de dados e retorna em uma lista
     * @return clientesLista
     */
    public List<Clientes> listaClientes(){
        try{
            ps = this.con.prepareStatement("SELECT * FROM clientes");
            ResultSet rs = ps.executeQuery();
            
            List<Clientes> clientesLista = new ArrayList<>();
            while(rs.next()){
                Clientes cliente = new Clientes();
                
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setDataNascimento(rs.getString("dataNascimento"));
            cliente.setTelefone(rs.getString("telefone"));
            clientesLista.add(cliente);
            }
            return clientesLista;
            
        }catch(SQLException e){
            System.out.println("Falha ao listar clientes: "+ e.getMessage());
            return null;
        }
    }
    
    /**
     * Método busca todos dados ta tabela clientes com base no id informado pelo usuário
     * @param id
     * @return clie
     */    
    public Clientes buscaClientePorId(int id){
        try{
            ps = con.prepareStatement("SELECT * FROM clientes WHERE id =?");
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Clientes clie = new Clientes();
                
                clie.setId(rs.getInt("id"));
                clie.setNome(rs.getString("nome"));
                clie.setCpf(rs.getString("cpf"));
                clie.setDataNascimento(rs.getString("dataNascimento"));
                clie.setTelefone(rs.getString("telefone"));
                return clie;
            }
        }catch(SQLException e){
            System.out.println("Erro ao buscar Cliente pelo ID: "+ e.getMessage());
        }
        return null;
    }
    
    public List<Clientes> buscaClientePorNome(String nome) {
        List<Clientes> listaClientes = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM clientes WHERE nome LIKE ?");

            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clientes clie = new Clientes();

                clie.setId(rs.getInt("id"));
                clie.setNome(rs.getString("nome"));
                clie.setCpf(rs.getString("cpf"));
                clie.setDataNascimento(rs.getString("dataNascimento"));
                clie.setTelefone(rs.getString("telefone"));

                listaClientes.add(clie);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Cliente pelo nome: " + e.getMessage());
        }

        return listaClientes;
    }
    
    
}
