package br.com.senac.etapa4piuc015.forms;



public class Menu extends javax.swing.JFrame {
    
   private String tipoUsuario;
   
    public Menu() {
        initComponents();
    }
    
    public Menu(String tipoUsuario) {
        initComponents();
        this.tipoUsuario = tipoUsuario;
        setTitle("AdLocadora");
        Permissoes(tipoUsuario);
      
    }
    
   
    private void Permissoes(String tipoUsuario) {
        // Normaliza a entrada para evitar problemas de maiúsculas/minúsculas
        tipoUsuario = tipoUsuario.trim().toLowerCase();

        if (tipoUsuario.equals("gerente")) {
            // Gerente pode acessar tudo
            BtnCadastroCliente.setEnabled(true);
            BtnCadastroVeículo.setEnabled(true);
            BtnClientesCadastrados.setEnabled(true);
            BtnVeiculosCadastrados.setEnabled(true);
        } else if (tipoUsuario.equals("atendente")) {
            // Atendente pode cadastrar clientes e veículos e visualizar listas
            BtnCadastroCliente.setEnabled(true);
            BtnCadastroVeículo.setEnabled(true);
            BtnClientesCadastrados.setEnabled(true);
            BtnVeiculosCadastrados.setEnabled(true);
        } else if (tipoUsuario.equals("setor financeiro")) {
            // Setor financeiro pode acessar apenas a lista de veículos
            BtnCadastroCliente.setEnabled(false);
            BtnCadastroVeículo.setEnabled(false);
            BtnClientesCadastrados.setEnabled(true);
            BtnVeiculosCadastrados.setEnabled(true);
        } else {
            // Qualquer outro usuário sem permissões
            BtnCadastroCliente.setEnabled(false);
            BtnCadastroVeículo.setEnabled(false);
            BtnClientesCadastrados.setEnabled(true);
            BtnVeiculosCadastrados.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        BtnCadastroCliente = new javax.swing.JButton();
        BtnCadastroVeículo = new javax.swing.JButton();
        BtnVeiculosCadastrados = new javax.swing.JButton();
        BtnClientesCadastrados = new javax.swing.JButton();
        BtnSair1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 36))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("ESCOLHA UMA DAS OPÇÕES");

        BtnCadastroCliente.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BtnCadastroCliente.setText("CADASTRO DE CLIENTES");
        BtnCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastroClienteActionPerformed(evt);
            }
        });

        BtnCadastroVeículo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BtnCadastroVeículo.setText("CADASTRO DE VEÍCULOS");
        BtnCadastroVeículo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastroVeículoActionPerformed(evt);
            }
        });

        BtnVeiculosCadastrados.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BtnVeiculosCadastrados.setText("VEÍCULOS CADASTRADOS");
        BtnVeiculosCadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVeiculosCadastradosActionPerformed(evt);
            }
        });

        BtnClientesCadastrados.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BtnClientesCadastrados.setText("CLIENTES CADASTRADOS");
        BtnClientesCadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientesCadastradosActionPerformed(evt);
            }
        });

        BtnSair1.setBackground(new java.awt.Color(255, 0, 0));
        BtnSair1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BtnSair1.setForeground(new java.awt.Color(255, 255, 255));
        BtnSair1.setText("SAIR");
        BtnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSair1ActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(BtnCadastroCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(BtnCadastroVeículo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(BtnVeiculosCadastrados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(BtnClientesCadastrados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(BtnSair1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnClientesCadastrados)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnCadastroCliente)
                                    .addComponent(BtnCadastroVeículo)))
                            .addComponent(BtnVeiculosCadastrados)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(BtnSair1)))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(BtnCadastroCliente)
                .addGap(18, 18, 18)
                .addComponent(BtnCadastroVeículo)
                .addGap(18, 18, 18)
                .addComponent(BtnClientesCadastrados)
                .addGap(18, 18, 18)
                .addComponent(BtnVeiculosCadastrados)
                .addGap(26, 26, 26)
                .addComponent(BtnSair1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastroClienteActionPerformed
        CadastroClientes cadastro = new CadastroClientes(tipoUsuario);
        cadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCadastroClienteActionPerformed

    private void BtnCadastroVeículoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastroVeículoActionPerformed
        CadastroVeiculos cadastroveiculo = new CadastroVeiculos();
        cadastroveiculo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCadastroVeículoActionPerformed

    private void BtnVeiculosCadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVeiculosCadastradosActionPerformed
        VeiculosCadastrados estoque = new VeiculosCadastrados();
        estoque.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVeiculosCadastradosActionPerformed

    private void BtnClientesCadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientesCadastradosActionPerformed
        ClientesCadastrados clientescadastrados = new ClientesCadastrados();
        clientescadastrados.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnClientesCadastradosActionPerformed

    private void BtnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSair1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnSair1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastroCliente;
    private javax.swing.JButton BtnCadastroVeículo;
    private javax.swing.JButton BtnClientesCadastrados;
    private javax.swing.JButton BtnSair1;
    private javax.swing.JButton BtnVeiculosCadastrados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
