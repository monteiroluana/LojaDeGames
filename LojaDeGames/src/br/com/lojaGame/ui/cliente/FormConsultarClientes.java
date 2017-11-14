package br.com.lojaGame.ui.cliente;

import br.com.lojaGame.exceptions.ClientesException;
import br.com.lojaGame.model.cliente.Cliente;
import br.com.lojaGame.service.cliente.ServicoCliente;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormConsultarClientes extends javax.swing.JInternalFrame {
    
    //Instância do form de edição de clientes
    FormEditarCliente formEditarCliente = new FormEditarCliente();
    
    String ultimaPesquisa = null;

    /**
     * Creates new form FormConsultarClientes
     */
    public FormConsultarClientes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDado = new javax.swing.JLabel();
        txtDado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableConsultaCliente = new javax.swing.JTable();
        buttonRetornarTodos = new javax.swing.JButton();
        buttonBuscar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta de Clientes");

        lblDado.setText("Pesquisar");

        tableConsultaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "RG", "Endereço", "Telefone", "E-mail", "Sexo", "Estado Civil", "Data de Nasc."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableConsultaCliente);

        buttonRetornarTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonRetornarTodos.setText("Retornar todos");
        buttonRetornarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetornarTodosActionPerformed(evt);
            }
        });

        buttonBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        buttonEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRetornarTodos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDado, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDado)
                    .addComponent(txtDado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscar))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonExcluir)
                    .addComponent(buttonEditar)
                    .addComponent(buttonRetornarTodos))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        //Inicializa o sucesso da pesquisa com valor negativo, indicando que
        //a pesquisa de clientes não obteve resultados (situação padrão)
        boolean resultSearch = false;

        //Grava o campo de pesquisa como a última pesquisa válida. O valor
        //de última pesquisa válida é utilizado na atualização da lista
        ultimaPesquisa = txtDado.getText();

        try {
            //Solicita a atualização da lista com o novo critério
            //de pesquisa (ultimaPesquisa)
            resultSearch = refreshList();
        } catch (Exception e) {
            //Exibe mensagens de erro na fonte de dados e para o listener
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Exibe mensagem de erro caso a pesquisa não tenha resultados
        if (!resultSearch) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ",
                    "Sem resultados", JOptionPane.ERROR_MESSAGE);
        }
        
        //faz com que a coluna do ID não seja mostrada ao usuário
        tableConsultaCliente.getColumnModel().getColumn(0).setMinWidth(0);
        tableConsultaCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        tableConsultaCliente.getColumnModel().getColumn(0).setWidth(0);
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        //Verifica se há itens selecionados para exclusão.
        //Caso negativo, ignora o comando
        if (tableConsultaCliente.getSelectedRow() >= 0) {

            //Obtém a linha do item selecionado
            final int row = tableConsultaCliente.getSelectedRow();
            //Obtém o nome do cliente da linha indicada para exibição
            //de mensagem de confirmação de exclusão utilizando seu nome
            String nome = (String) tableConsultaCliente.getValueAt(row, 1);
            //Mostra o diálogo de confirmação de exclusão
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                    "Excluir o cliente \"" + nome + "\"?",
                    "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            //Se o valor de resposta for "Sim" para a exclusão
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    //Obtém o ID do cliente
                    Integer id = (Integer) tableConsultaCliente.getValueAt(row, 0);
                    //Solicita ao serviço a inativação do cliente com o ID
                    ServicoCliente.excluirCliente(id);
                    //Atualiza a lista após a "exclusão"
                    this.refreshList();
                } catch (Exception e) {
                    //Se ocorrer algum erro técnico, mostra-o no console,
                    //mas esconde-o do usuário
                    e.printStackTrace();
                    //Exibe uma mensagem de erro genérica ao usuário
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                            "Falha na Exclusão", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonRetornarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetornarTodosActionPerformed
        boolean resultSearch = false;
        
        try {
            //Solicita a atualização da lista com o novo critério
            //de pesquisa (ultimaPesquisa)
            resultSearch = refreshList();
        } catch (Exception e) {
            //Exibe mensagens de erro na fonte de dados e para o listener
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //faz com que a coluna do ID não seja mostrada ao usuário
        tableConsultaCliente.getColumnModel().getColumn(0).setMinWidth(0);
        tableConsultaCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        tableConsultaCliente.getColumnModel().getColumn(0).setWidth(0);
    }//GEN-LAST:event_buttonRetornarTodosActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        try {
                //Obtém a linha selecionada da tabela de resultados
                final int row = tableConsultaCliente.getSelectedRow();
                //Obtém o valor do ID da coluna "ID" da tabela de resultados
                Integer id = (Integer) tableConsultaCliente.getValueAt(row, 0);

                //Com o ID da coluna, chama o serviço de cliente para
                //obter o cliente com dados atualizados do mock
                Cliente cliente = ServicoCliente.obterCliente(id);
                
                //Cria uma nova instância da tela de edição,
                //configura o cliente selecionado como elemento a
                //ser editado e mostra a tela de edição.
                //Para exibir a tela, é necessário adicioná-la ao
                //componente de desktop, o "pai" da janela corrente
                formEditarCliente.dispose();
                formEditarCliente = new FormEditarCliente();
                formEditarCliente.setCliente(cliente);
                formEditarCliente.setTitle(cliente.getNome());
                this.getParent().add(formEditarCliente);
                this.openFrameInCenter(formEditarCliente);                
                formEditarCliente.toFront();

            } catch (Exception e) {
                //Se ocorrer algum erro técnico, mostra-o no console,
                //mas esconde-o do usuário
                e.printStackTrace();
                //Exibe uma mensagem de erro genérica ao usuário
                JOptionPane.showMessageDialog(rootPane, "Não é possível "
                        + "exibir os detalhes deste cliente.",
                        "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_buttonEditarActionPerformed

    //Atualiza a lista de clientes. Pode ser chamado por outras telas
    public boolean refreshList() throws ClientesException, Exception {
        //Realiza a pesquisa de clientes com o último valor de pesquisa
        //para atualizar a lista
        List<Cliente> resultado = ServicoCliente.procurarCliente(ultimaPesquisa);

        //Obtém o elemento representante do conteúdo da tabela na tela
        DefaultTableModel model = (DefaultTableModel) tableConsultaCliente.getModel();
        //Indica que a tabela deve excluir todos seus elementos
        //Isto limpará a lista, mesmo que a pesquisa não tenha sucesso
        model.setRowCount(0);

        //Verifica se não existiram resultados. Caso afirmativo, encerra a
        //atualização e indica ao elemento acionador o não sucesso da pesquisa
        if (resultado == null || resultado.size() <= 0) {
            return false;
        }

        //Percorre a lista de resultados e os adiciona na tabela
        for (int i = 0; i < resultado.size(); i++) {
            Cliente cliente = resultado.get(i);
            if (cliente != null) {
                Object[] row = new Object[15];
                row[0] = cliente.getIdCliente();
                row[1] = cliente.getNome();
                row[2] = cliente.getCPF();
                row[3] = cliente.getRG();
                row[4] = cliente.getLogradouro();
                row[5] = cliente.getTelefone();
                row[6] = cliente.getEmail();
                row[7] = cliente.getSexo();
                row[8] = cliente.getEstadoCivil();
                row[9] = cliente.getDataNasc();
                model.addRow(row);
            }
        }

        //Se chegamos até aqui, a pesquisa teve sucesso, então
        //retornamos "true" para o elemento acionante, indicando
        //que não devem ser exibidas mensagens de erro
        return true;
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
            java.util.logging.Logger.getLogger(FormConsultarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConsultarClientes().setVisible(true);
            }
        });
    }
    
    //Abre um internal frame centralizado na tela
    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = this.getParent().getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonRetornarTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDado;
    private javax.swing.JTable tableConsultaCliente;
    private javax.swing.JTextField txtDado;
    // End of variables declaration//GEN-END:variables
}
