package br.com.senac.etapa4piuc015.forms;

import br.com.senac.etapa4piuc015.dependencies.GenericDAO;
import br.com.senac.etapa4piuc015.dependencies.Veiculo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class VeiculosCadastrados extends javax.swing.JFrame {

    public VeiculosCadastrados() {
        initComponents();
        setTitle("AdLocadora");
        carregarDados();

       // Pesquisa enquanto digita
        txtStatus.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pesquisar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pesquisar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pesquisar();
            }
        });
    }

    /**
     * Método privado para preencher a tabela de cadstro com os dados do banco
     * de dados.
     */
    public void preencherTabela(List<Veiculo> cadastro) {

        if (cadastro == null || cadastro.isEmpty()) {
            System.out.println("Nenhum veiculo encontrado.");
            return;
        }

        String colunas[] = {"id", "placa", "ano", "marcamodelo", "cor", "valordiaria", "status"};
        String dados[][] = new String[cadastro.size()][colunas.length];

        int i = 0;
        for (Veiculo v : cadastro) {
            dados[i] = new String[]{
                String.valueOf(v.getId()),
                v.getPlaca(),
                v.getAno(),
                v.getMarcamodelo(),
                v.getCor(),
                String.format("%.2f", v.getValordiaria()), // Formata o double para exibição com duas casas decimais
                v.getStatus() // Obtém o status do objeto Veiculo
            };
            i++;
        }
        DefaultTableModel tabelaModelo = new DefaultTableModel(dados, colunas);
        tblVeiculos.setModel(tabelaModelo);
        System.out.println("Total de linhas carregadas: " + tabelaModelo.getRowCount()); // Debug
    }
    // Método que recebe o preencher tabela

    public void carregarDados() {
        try {
            GenericDAO<Veiculo> dao = new GenericDAO<>(Veiculo.class);
            List<Veiculo> cadastro = dao.listarVeiculos(""); // Retorna todos os clientes
            preencherTabela(cadastro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BtnDeletar = new javax.swing.JButton();
        BtnMenu = new javax.swing.JButton();
        BtnSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Pesquisar Clientes por Nome:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "Marca/Modelo", "Ano", "Cor", "Valor Diária", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblVeiculos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("VEÍCULOS CADASTRADOS");

        BtnDeletar.setBackground(new java.awt.Color(204, 102, 0));
        BtnDeletar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnDeletar.setForeground(new java.awt.Color(255, 255, 255));
        BtnDeletar.setText("DELETAR");
        BtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeletarActionPerformed(evt);
            }
        });

        BtnMenu.setBackground(new java.awt.Color(255, 153, 0));
        BtnMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenu.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenu.setText("MENU");
        BtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMenuActionPerformed(evt);
            }
        });

        BtnSair.setBackground(new java.awt.Color(153, 51, 0));
        BtnSair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnSair.setForeground(new java.awt.Color(255, 255, 255));
        BtnSair.setText("SAIR");
        BtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSairActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Pesquisar veículos pelo status:");

        txtStatus.setToolTipText("Digiste o Status do Veíuculo.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BtnDeletar)
                                .addGap(191, 191, 191)
                                .addComponent(BtnMenu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnSair)
                                .addGap(14, 14, 14))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDeletar)
                    .addComponent(BtnMenu)
                    .addComponent(BtnSair))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnMenuActionPerformed

    private void BtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnSairActionPerformed

    private void BtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarActionPerformed
        try {
            if (tblVeiculos.getSelectedRow() >= 0) { // Verifica se há algo selecionado na tabela
                // Obtém o valor da coluna id da linha selecionada
                String idStr = (String) tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 0);
                Integer id = Integer.parseInt(idStr);  // Converte o ID de String para Integer

                // Janela de confirmação
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro com ID " + id + "?");
                if (resposta == 0) { // 0 - Sim, 1 - Não, 2 - Cancelar
                    // Buscar o cliente pelo ID antes de excluir
                    GenericDAO<Veiculo> dao = new GenericDAO<>(Veiculo.class);
                    Veiculo cliente = dao.buscarPorId(id); // Busca o cliente pelo ID

                    if (cliente != null) {
                        // Excluir o cliente usando o objeto
                        dao.excluir(cliente);

                        // Removendo a linha da tabela após a exclusão
                        DefaultTableModel model = (DefaultTableModel) tblVeiculos.getModel();
                        model.removeRow(tblVeiculos.getSelectedRow());

                        JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Veículo não encontrado para exclusão.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum veículo selecionado para exclusão.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + e.getMessage());
        }
    }//GEN-LAST:event_BtnDeletarActionPerformed
    /**
     * Método para pesquisar veículos conforme o nome digitado no campo
     * txtNomeCliente
     */
    private void pesquisar() {
      try {
        GenericDAO<Veiculo> dao = new GenericDAO<>(Veiculo.class);
        String filtro = txtStatus.getText().trim();
        System.out.println("Filtro digitado: " + filtro); // Log para verificar o filtro
        List<Veiculo> veiculos = dao.listarVeiculos(filtro);
        preencherTabela(veiculos);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar veiculos: " + ex.getMessage());
    }
}

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeiculosCadastrados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDeletar;
    private javax.swing.JButton BtnMenu;
    private javax.swing.JButton BtnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVeiculos;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
