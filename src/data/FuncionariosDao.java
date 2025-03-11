package data;


import java.sql.PreparedStatement;
import conexao.Conexao;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lucas
 */
public class FuncionariosDao {
    private Conexao conexao;
    private Connection con;
    private PreparedStatement ps;
    
    public FuncionariosDao(){
        this.conexao = new Conexao();
        this.con = this.conexao.getConection();
    }
    
     /**
     * método de inserir dados no banco de dados por um objeto do tipo Funcionarios passado como parâmetro
     * @param func 
     * @return status
     */
    public int salvar(Funcionarios func){
        int status;
        try{
            ps = this.con.prepareStatement("INSERT INTO funcionarios VALUES (default,?,?,?,?)");
            ps.setString(1, func.getNome());
            ps.setString(2, func.getCpf());
            ps.setString(3, func.getDataNascimento());
            ps.setString(4, func.getTelefone());
            
            status = ps.executeUpdate();
            return status;
            
        }catch(SQLException e){
            System.out.println("Falha ao salvar funcionario: "+ e.getMessage());
            return e.getErrorCode();
        }
    }
    
    /**
     * Método que realiza uma consulta no banco de dados e busca os dados do funcionário com base no id específico passado
     * pelo usuário por parametro
     * @param id
     * @return func
     */
    public Funcionarios getFuncionarios(int id){
        try{
            ps = this.con.prepareStatement("SELECT * FROM funcionarios WHERE id =?");
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Funcionarios func = new Funcionarios();
            
            rs.next();
            func.setId(id);
            func.setNome(rs.getString("nome"));
            func.setCpf(rs.getString("cpf"));
            func.setDataNascimento(rs.getString("dataNascimento"));
            func.setTelefone(rs.getString("telefone"));
            
            return func;
            
        }catch(SQLException e){
            System.out.println("Falha ao buscar funcionario: "+ e.getMessage());
            return null;
        }
    }
    
    /**
     * Método atualiza dados já cadastrados no banco de dados, alterando informações com base no id no id informado pelo usuário
     * @param func  
     */
    public void atualizar(Funcionarios func){
        try{
            ps = this.con.prepareStatement("UPDATE funcionarios SET nome =?, cpf =?, dataNascimento =?, telefone =? WHERE id =?", ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            
            ps.setString(1, func.getNome());
            ps.setString(2, func.getCpf());
            ps.setString(3, func.getDataNascimento());
            ps.setString(4, func.getTelefone());
            ps.setInt(5, func.getId());
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Falha ao atualizar funcionario: "+ e.getMessage());
        }
    }
    
    /**
     * Método exlui dados do banco de dados com base no id informado pelo usuário
     * @param id
     */
    public void excluir(int id){
        try{
            ps = this.con.prepareStatement("DELETE FROM funcionarios WHERE id =?");
            
            ps.setInt(1, id);
            ps.execute();
            
        }catch(SQLException e){
            System.out.println("Falha ao excluir funcionario: "+ e.getMessage());
        }
    }
    
    /**
     * Método pega todos os dados da tabela funcionarios do banco de dados e retorna em uma lista
     * @return funcLista
     */
    public List<Funcionarios> listaFuncionarios(){
        try{
            ps = this.con.prepareStatement("SELECT * FROM funcionarios");
            ResultSet rs = ps.executeQuery();
            
            List<Funcionarios> funcLista = new ArrayList<>();
            
            while(rs.next()){
                Funcionarios func = new Funcionarios();
                
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setDataNascimento(rs.getString("dataNascimento"));
                func.setTelefone(rs.getString("telefone"));
                funcLista.add(func);
            }
            return funcLista;
 
        }catch(SQLException e){
            System.out.println("Falha ao listar funcionarios: "+ e.getMessage());
            return null;
        }
    }
    
    /**
     * Método busca todos dados ta tabela funcionarios com base no id informado pelo usuário
     * @param id
     * @return func
     */     
    public Funcionarios buscaFuncionarioPorId(int id){
        try{
            ps = con.prepareStatement("SELECT * FROM funcionarios WHERE id =?");
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Funcionarios func = new Funcionarios();
                
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setDataNascimento(rs.getString("dataNascimento"));
                func.setTelefone(rs.getString("telefone"));
                return func;
            }
        }catch(SQLException e){
            System.out.println("Erro ao buscar Funcionario pelo ID: "+ e.getMessage());
        }
        return null;
    }
    
    public List<Funcionarios> buscaFuncionarioPorNome(String nome) {
        List<Funcionarios> listaFuncionarios = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM funcionarios WHERE nome LIKE ?");

            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionarios func = new Funcionarios();

                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setDataNascimento(rs.getString("dataNascimento"));
                func.setTelefone(rs.getString("telefone"));

                listaFuncionarios.add(func);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Cliente pelo nome: " + e.getMessage());
        }

        return listaFuncionarios;
    }
         
}
