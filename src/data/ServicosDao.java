package data;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ServicosDao {
    private Conexao conexao;
    private Connection con;
    private PreparedStatement ps;
    
    public ServicosDao(){
        this.conexao = new Conexao();
        this.con = this.conexao.getConection();
    }
    
    /**
     * método de inserir dados no banco de dados por um objeto do tipo Servicos passado como parâmetro
     * @param serv 
     * @return status
     */
    public int salvar(Servicos serv){
        int status;
        try{
            ps = this.con.prepareStatement("INSERT INTO servicos VALUES (default,?,?,?)");
            
            ps.setString(1, serv.getNome());
            ps.setDouble(2, serv.getValorCusto());
            ps.setDouble(3, serv.getValorCobrado());
            
            status = ps.executeUpdate();
            return status;
            
        }catch(SQLException e){
            System.out.println("Falha ao salvar servico: "+ e.getMessage());
            return e.getErrorCode();
        }
    }
    
    /**
     * Método que realiza uma consulta no banco de dados e busca os dados do serviço com base no id específico passado
     * pelo usuário por parametro
     * @param id
     * @return serv
     */
    public Servicos getServicos(int id){
        try{
            ps = this.con.prepareStatement("SELECT * FROM servicos WHERE id =?");
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Servicos serv = new Servicos();
            
            rs.next();
            serv.setId(id);
            serv.setNome(rs.getString("nome"));
            serv.setValorCusto(rs.getDouble("valorCusto"));
            serv.setValorCobrado(rs.getDouble("valorCobrado"));
            
            return serv;
            
        }catch(SQLException e){
            System.out.println("Falha ao buscar servico: "+ e.getMessage());
            return null;
        }
    }
    
    /**
     * Método atualiza dados já cadastrados no banco de dados, alterando informações com base no id no id informado pelo usuário
     * @param serv   
     */
    public void atualizar(Servicos serv){
        try{
            ps = this.con.prepareStatement("UPDATE servicos SET nome =?, valorCusto =?, valorCobrado =? WHERE id =?", ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
            
            ps.setString(1, serv.getNome());
            ps.setDouble(2, serv.getValorCusto());
            ps.setDouble(3, serv.getValorCobrado());
            ps.setInt(4, serv.getId());
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Falha ao atualizar servicos: "+ e.getMessage());
        }
    }
    
    /**
     * Método exlui dados do banco de dados com base no id informado pelo usuário
     * @param id
     */
    public void excluir(int id){
        try{
            ps = this.con.prepareStatement("DELETE FROM servicos WHERE id =?");
            
            ps.setInt(1, id);
            ps.execute();
            
        }catch(SQLException e){
            System.out.println("Falha ao excluir servico: "+ e.getMessage());
        }
    }
    
    /**
     * Método pega todos os dados da tabela servicos do banco de dados e retorna em uma lista
     * @return servicosLista
     */    
    public List<Servicos> listaServicos(){
        try{
            ps = this.con.prepareStatement("SELECT * FROM servicos");
            ResultSet rs = ps.executeQuery();
            
            List<Servicos> servicosLista = new ArrayList<>();
            while(rs.next()){
                Servicos serv = new Servicos();
                
                serv.setId(rs.getInt("id"));
                serv.setNome(rs.getString("nome"));
                serv.setValorCusto(rs.getDouble("valorCusto"));
                serv.setValorCobrado(rs.getDouble("valorCobrado"));
                servicosLista.add(serv);
            }
            return servicosLista;
            
        }catch(SQLException e){
            System.out.println("Falha ao listar servicos: "+ e.getMessage());
            return null;
        }
    }
    
     /**
     * Método busca todos dados ta tabela servicos com base no id informado pelo usuário
     * @param id
     * @return serv
     */ 
    public Servicos buscaServicoPorId(int id){
        try{
            ps = this.con.prepareStatement("SELECT * FROM servicos WHERE id =?");
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Servicos serv = new Servicos();
                
                serv.setId(rs.getInt("id"));
                serv.setNome(rs.getString("nome"));
                serv.setValorCusto(rs.getDouble("valorCusto"));
                serv.setValorCobrado(rs.getDouble("valorCobrado"));
                return serv;
            }
        }catch(SQLException e){
            System.out.println("Erro ao buscar servico pelo ID: "+ e.getMessage());
        }
        return null;
    }
    
}
