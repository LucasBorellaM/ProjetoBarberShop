package views;

import conexao.Conexao;
import data.Servicos;
import data.ServicosDao;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;


/**
 *
 * @author lucas
 */
public class TelaServicos extends javax.swing.JFrame {
    
     private void preencheTabela(){
         ServicosDao servDao = new ServicosDao();
        
        List<Servicos> listaServicos = servDao.listaServicos();
        DefaultTableModel tableServicos = (DefaultTableModel) TblServicos.getModel();
        tableServicos.setNumRows(0);
        
        for(Servicos s: listaServicos){
            Object[] obj = new Object[]{
                s.getId(),
                s.getNome(),
                s.getValorCusto(),
                s.getValorCobrado(),
                
            };
            tableServicos.addRow(obj);
            servDao.listaServicos();
        }
    }


    /**
     * Creates new form TelaServicos
     */
    public TelaServicos() {
        initComponents();
        this.setTitle("SERVIÇOS");
        this.setLocationRelativeTo(null);
        Color corFundo = new Color(24, 9, 0);
        jPanel1.setBackground(corFundo);
        txtID.setEnabled(false);
        preencheTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNome1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorCusto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        txtValorCobrado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblServicos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscaNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botaoBuscar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(810, 630));

        jPanel1.setPreferredSize(new java.awt.Dimension(810, 630));
        jPanel1.setLayout(null);
        jPanel1.add(txtNome1);
        txtNome1.setBounds(20, 110, 160, 30);
        txtNome1.getAccessibleContext().setAccessibleName("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valor Custo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(210, 80, 90, 21);
        jPanel1.add(txtValorCusto);
        txtValorCusto.setBounds(210, 110, 160, 30);
        txtValorCusto.getAccessibleContext().setAccessibleName("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 80, 70, 21);

        botaoCadastrar.setBackground(new java.awt.Color(172, 137, 82));
        botaoCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botaoCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoCadastrar);
        botaoCadastrar.setBounds(210, 150, 160, 30);
        jPanel1.add(txtValorCobrado);
        txtValorCobrado.setBounds(410, 110, 160, 30);
        txtValorCobrado.getAccessibleContext().setAccessibleName("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Valor Cobrado:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(410, 80, 120, 21);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar Serviços");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 10, 810, 41);

        TblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor Custo", "Valor Cobrado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblServicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblServicos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 280, 760, 300);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Serviços");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 240, 91, 34);
        jPanel1.add(txtBuscaNome);
        txtBuscaNome.setBounds(450, 240, 160, 30);
        txtBuscaNome.getAccessibleContext().setAccessibleName("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar por nome:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 240, 160, 21);

        botaoBuscar.setBackground(new java.awt.Color(172, 137, 82));
        botaoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botaoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botaoBuscar.setText("Buscar");
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoBuscar);
        botaoBuscar.setBounds(620, 240, 160, 30);

        botaoAtualizar.setBackground(new java.awt.Color(172, 137, 82));
        botaoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        botaoAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoAtualizar);
        botaoAtualizar.setBounds(410, 150, 160, 30);

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtID.setMinimumSize(new java.awt.Dimension(64, 25));
        txtID.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txtID);
        txtID.setBounds(40, 150, 50, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 150, 54, 27);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TblServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblServicosMouseClicked
        txtID.setText(TblServicos.getValueAt(TblServicos.getSelectedRow(), 0).toString());
        txtNome1.setText(TblServicos.getValueAt(TblServicos.getSelectedRow(), 1).toString());
        txtValorCusto.setText(TblServicos.getValueAt(TblServicos.getSelectedRow(), 2).toString());
        txtValorCobrado.setText(TblServicos.getValueAt(TblServicos.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_TblServicosMouseClicked

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        Servicos serv = new Servicos();
        ServicosDao servDao = new ServicosDao();
        Conexao con = new Conexao();
        int resposta;
        
        if(valida()){
            if(!emptyFields()){
                serv = getServicos();
                con.getConection();
                try{
                    if(con.getConection().isClosed()){
                        JOptionPane.showMessageDialog(this, "Falha ao conectar ao banco de dados");
                    }else{
                        resposta = servDao.salvar(serv);
                        
                        if(resposta == 1){
                            JOptionPane.showMessageDialog(this, "Dados inseridos com sucesso.");
                            txtNome1.setText("");
                            txtValorCusto.setText("");
                            txtValorCobrado.setText("");
                        }else if(resposta == 1062){
                            JOptionPane.showMessageDialog(this, "Dados já cadastrados");
                        }else{
                            JOptionPane.showMessageDialog(this, "Falha ao cadastrar");
                        }
                        con.desconnect();
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "SQL ERRO: "+ e);
                }
            }
        }
        preencheTabela();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        try{
            int id = Integer.parseInt(txtID.getText());
            String nome = txtNome1.getText();
            Double valorCusto = Double.parseDouble(txtValorCusto.getText());
            Double valorCobrado = Double.parseDouble(txtValorCobrado.getText());
            
            Servicos serv = new Servicos();
            
            serv.setId(id);
            serv.setNome(nome);
            serv.setValorCusto(valorCusto);
            serv.setValorCobrado(valorCobrado);
            
            ServicosDao servDao = new ServicosDao();
            servDao.atualizar(serv);
            JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso.");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Falha ao alterar dados: "+ e);
        }
        txtID.setText("");
        txtValorCusto.setText("");
        txtNome1.setText("");
        txtValorCobrado.setText("");
        preencheTabela();
        
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed
        String nomeBuscado = txtBuscaNome.getText().trim();
        try{
            if(nomeBuscado.isEmpty()){
                DefaultTableModel tableServicos = (DefaultTableModel) TblServicos.getModel();
                tableServicos.setNumRows(0);
            }
            
            ServicosDao servDao = new ServicosDao();
            List<Servicos> servicoEncontrado = servDao.buscaServicoPorNome(nomeBuscado);
            if(servicoEncontrado.isEmpty()){
                JOptionPane.showMessageDialog(this, "Nenhum servico encontrado com esse nome.");
            }else{
                DefaultTableModel tableServicos = (DefaultTableModel) TblServicos.getModel();
                tableServicos.setNumRows(0);
                
                for(Servicos s: servicoEncontrado){
                    tableServicos.addRow(new Object[]{s.getId(),
                        s.getNome(),
                        s.getValorCusto(),
                        s.getValorCobrado()});
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "ERRO: "+ e);
        }
    }//GEN-LAST:event_botaoBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblServicos;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscaNome;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtValorCobrado;
    private javax.swing.JTextField txtValorCusto;
    // End of variables declaration//GEN-END:variables

    public boolean emptyFields(){
        boolean isEmpty = true;
        if(txtValorCusto.getText().trim().isEmpty() || txtValorCobrado.getText().trim().isEmpty() || txtNome1.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor preencha todos os campos");
        }else{
            isEmpty = false;
        }
        return isEmpty;
    }

    public boolean valida(){
        boolean valido = true;
        
        String valorCobrado = txtValorCobrado.getText();
        String valorCusto = txtNome1.getText();
        
        boolean validaValorCobrado = valorCobrado.matches("[0-9]{2}[.][0-9]{2}");
        boolean validaValorCusto = valorCobrado.matches("[0-9]{2}[.][0-9]{2}");
        
        if(validaValorCobrado == false || validaValorCusto == false){
            JOptionPane.showMessageDialog(this, "Valores inválidos \nFormato (xx.xx)");
            valido = false;
        }else if(validaValorCobrado == true && validaValorCusto == false){
            JOptionPane.showMessageDialog(this, "Valor de custo inválido \nFormato (xx.xx)");
            valido = false;
        }else if(validaValorCobrado == false && validaValorCusto == true){
            JOptionPane.showMessageDialog(this, "Valor cobrado inválido \nFormato (xx.xx)");
            valido = false;
        }
        return valido;
    }

    public Servicos getServicos(){
        String nome = txtNome1.getText();
        Double valorCusto = Double.parseDouble(txtValorCusto.getText());
        Double valorCobrado = Double.parseDouble(txtValorCobrado.getText());
        
        Servicos serv = new Servicos(WIDTH, nome, valorCusto, valorCobrado);
        return serv;
    }
    
    public boolean emptyId(){
        boolean isEmpty = true;
        if(txtBuscaNome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Digite o ID antes de atualizar");
        }else{
            isEmpty = false;
        }
        return isEmpty;
    }

}
