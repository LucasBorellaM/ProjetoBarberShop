package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import conexao.Conexao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class AgendamentosDao {
    private Conexao conexao;
    private Connection con;
    private PreparedStatement ps;

    public AgendamentosDao() {
        this.conexao = new Conexao();
        this.con = this.conexao.getConection();
    }

     /**
     * método de inserir dados no banco de dados por um objeto do tipo Agendamentos passado como parâmetro
     * @param agend 
     * @return status
     */
    public int salvar(Agendamentos agend){
        int status;
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ps = this.con.prepareStatement("INSERT INTO agendamentos VALUES(default,?,?,?,?,?)");
            
            ps.setString(1, agend.getDataAgendamento());
            ps.setInt(2, agend.getServico().getId());
            ps.setInt(3, agend.getFuncionario().getId());
            ps.setInt(4, agend.getCliente().getId());
            ps.setString(5, agend.getTipoPagamento());
            
            status = ps.executeUpdate();
            return status;
            
        }catch(SQLException e){
            System.out.println("Falha ao salvar dados: "+ e.getMessage());
            return e.getErrorCode();
        }
    }
    
    /**
     * Método que realiza uma consulta no banco de dados e busca os dados do agendamento com base no id específico passado
     * pelo usuário por parametro
     * @param id
     * @return agend
     */    
    public Agendamentos getAgendamentos(int id){
        try{
            ps = this.con.prepareStatement("SELECT * FROM agendamentos WHERE id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Agendamentos agend = new Agendamentos();
            rs.next();
            agend.setId(id);
            agend.setDataAgendamento(rs.getString("dataAgendamento"));
            
            int servicoId = rs.getInt("servico_id");
            int funcionarioId = rs.getInt("funcionario_id");
            int clienteId = rs.getInt("cliente_id");
            
            Servicos serv = new Servicos();
            serv.setId(servicoId);
            Funcionarios func = new Funcionarios();
            func.setId(funcionarioId);
            Clientes cli = new Clientes();
            cli.setId(clienteId);

            agend.setServico(serv) ;
            agend.setFuncionario(func);
            agend.setCliente(cli);
            agend.setTipoPagamento(rs.getString("tipoPagamento"));
            
            return agend;
            
        }catch(SQLException e){
            System.out.println("Falha ao buscar agendamento: "+ e.getMessage());
            return null;
        }
    }
    
    /**
     * Método atualiza dados já cadastrados no banco de dados, alterando informações com base no id no id informado pelo usuário
     * @param agend   
     */    
    public void atualizar(Agendamentos agend){
        try{
            ps = this.con.prepareStatement("UPDATE agendamentos SET dataAgendamento =?, servico_id =?, funcionario_id =?, cliente_id =?, tipoPagamento =? WHERE id =?",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ps.setString(1, agend.getDataAgendamento());
            ps.setInt(2, agend.getServico().getId());
            ps.setInt(3, agend.getFuncionario().getId());
            ps.setInt(4, agend.getCliente().getId());
            ps.setString(5, agend.getTipoPagamento());
            ps.setInt(6, agend.getId());
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Falha ao atualizar agendamento: "+ e.getMessage());
        }
    }
    
    /**
     * Método exlui dados do banco de dados com base no id informado pelo usuário
     * @param id
     */    
    public void excluir(int id){
        try{
            ps = this.con.prepareStatement("DELETE FROM agendamentos WHERE id =?");
            
            ps.setInt(1, id);
            ps.execute();
            
        }catch(SQLException e){
            System.out.println("Falha ao excluir agendamento: "+ e.getMessage());
        }
    }
    
    /**
     * Método pega todos os dados da tabela Agendamentos do banco de dados e retorna em uma lista
     * @return agendamentosLista
     */    
    public List<Agendamentos> listaAgendamentos(){
        try{
            ps = this.con.prepareStatement("SELECT * FROM agendamentos");
            ResultSet rs = ps.executeQuery();
            
            List<Agendamentos> agendamentosLista = new ArrayList<>();
            
            while(rs.next()){
                Agendamentos agend = new Agendamentos();
                
                agend.setId(rs.getInt("id"));
                agend.setDataAgendamento(rs.getString("dataAgendamento"));
                int servicoId = rs.getInt("servico_id");
                int funcionarioId = rs.getInt("funcionario_id");
                int clienteId = rs.getInt("cliente_id");

                ServicosDao servDao = new ServicosDao();
                Servicos serv = servDao.buscaServicoPorId(servicoId);

                FuncionariosDao funcDao = new FuncionariosDao();
                Funcionarios func = funcDao.buscaFuncionarioPorId(funcionarioId);

                ClientesDao cliDao = new ClientesDao();
                Clientes cli = cliDao.buscaClientePorId(clienteId);

                agend.setServico(serv);
                agend.setCliente(cli);
                agend.setFuncionario(func);
                agend.setTipoPagamento(rs.getString("tipoPagamento"));
                agendamentosLista.add(agend);
            }
            return agendamentosLista;
            
        }catch(SQLException e){
            System.out.println("Falha ao listar agendamentos: "+ e.getMessage());
            return null;
        }
    }
    
}
