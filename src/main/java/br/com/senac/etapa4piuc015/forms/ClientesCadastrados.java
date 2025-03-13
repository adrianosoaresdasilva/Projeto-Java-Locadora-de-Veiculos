package br.com.senac.etapa4piuc015.forms;

import br.com.senac.etapa4piuc015.dependencies.Cliente;
import br.com.senac.etapa4piuc015.dependencies.GenericDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ClientesCadastrados extends javax.swing.JFrame {

    public ClientesCadastrados() {
        initComponents();
        setTitle("AdLocadora");
        carregarDados();

        // Pesquisa enquanto digita
        txtNomeCliente.getDocument().addDocumentListener(new DocumentListener() {
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
    public void preencherTabela(List<Cliente> cadastro) {

        if (cadastro == null || cadastro.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
            return;
        }

        String colunas[] = {"id", "nome", "contato", "cpf", "rg", "idade", "endereco"};
        String dados[][] = new String[cadastro.size()][colunas.length];

        int i = 0;
        for (Cliente c : cadastro) {
            dados[i] = new String[]{
                String.valueOf(c.getId()),
                c.getNome(),
                c.getContato(),
                c.getCpf(),
                c.getRg(),
                c.getIdade(),
                c.getEndereco()
            };
            i++;
        }

        DefaultTableModel tabelaModelo = new DefaultTableModel(dados, colunas);
        tblCliente.setModel(tabelaModelo);
        System.out.println("Total de linhas carregadas: " + tabelaModelo.getRowCount()); // Debug
    }

    // Método que recebe o preencher tabela
    public void carregarDados() {
        try {
            GenericDAO<Cliente> dao = new GenericDAO<>(Cliente.class);
            List<Cliente> cadastro = dao.listar(""); // Retorna todos os clientes
            preencherTabela(cadastro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Contato", "CPF", "RG", "Idade", "Endereco"
            }
        ));
        jScrollPane1.setViewportView(tblCliente);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("CLIENTES CADASTRADOS");

        btnDeletar.setBackground(new java.awt.Color(204, 102, 0));
        btnDeletar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeletar.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletar.setText("DELETAR");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(255, 153, 0));
        btnMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(153, 51, 0));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Pesquisar Clientes por Nome:");

        txtNomeCliente.setToolTipText("Digite o nome do produtor");
        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnDeletar)
                                .addGap(196, 196, 196)
                                .addComponent(btnMenu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSair)))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnSair)
                    .addComponent(btnMenu))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try {
            if (tblCliente.getSelectedRow() >= 0) { // Verifica se há algo selecionado na tabela
                // Obtém o valor da coluna id da linha selecionada
                String idStr = (String) tblCliente.getValueAt(tblCliente.getSelectedRow(), 0);
                Integer id = Integer.parseInt(idStr);  // Converte o ID de String para Integer

                // Janela de confirmação
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro com ID " + id + "?");
                if (resposta == 0) { // 0 - Sim, 1 - Não, 2 - Cancelar
                    // Buscar o cliente pelo ID antes de excluir
                    GenericDAO<Cliente> dao = new GenericDAO<>(Cliente.class);
                    Cliente cliente = dao.buscarPorId(id); // Busca o cliente pelo ID

                    if (cliente != null) {
                        // Excluir o cliente usando o objeto
                        dao.excluir(cliente);

                        // Removendo a linha da tabela após a exclusão
                        DefaultTableModel model = (DefaultTableModel) tblCliente.getModel();
                        model.removeRow(tblCliente.getSelectedRow());

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

    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        pesquisar();
    }//GEN-LAST:event_txtNomeClienteActionPerformed
    /**
     * Método para pesquisar clientes conforme o nome digitado no campo
     * txtNomeCliente
     */
    private void pesquisar() {
        try {
            GenericDAO<Cliente> dao = new GenericDAO<>(Cliente.class);
            String filtro = txtNomeCliente.getText().trim();
            List<Cliente> clientes = dao.listar(filtro);
            preencherTabela(clientes); // Atualiza a tabela com os clientes encontrados
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes: " + ex.getMessage());
        }

    }

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
            java.util.logging.Logger.getLogger(ClientesCadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesCadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesCadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesCadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesCadastrados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtNomeCliente;
    // End of variables declaration//GEN-END:variables
}
