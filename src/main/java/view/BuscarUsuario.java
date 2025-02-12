package view;

import controller.UsuarioController;
import model.UsuarioModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class BuscarUsuario extends JFrame {
    private JTextField pesquisar;
    private JButton buscarButton;
    private JTable tabela;
    private JButton removerButton;
    private JPanel painel;
    private UsuarioController usuarioController;
    private UsuarioTabela modeloTabela;

    public BuscarUsuario() {
        this.setTitle("Buscar Usuários");
        this.setSize(840, 480);//tamanho alterado para que nao oculte os botoes
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        usuarioController = new UsuarioController();

        painel = new JPanel(new BorderLayout());

        // painel de busca de usuario
        JPanel painelBusca = new JPanel();
        pesquisar = new JTextField(20);
        buscarButton = new JButton("Buscar");
        painelBusca.add(new JLabel("Nome:"));
        painelBusca.add(pesquisar);
        painelBusca.add(buscarButton);
        painel.add(painelBusca, BorderLayout.NORTH);

        // tabela
        modeloTabela = new UsuarioTabela();
        tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);
        painel.add(scrollPane, BorderLayout.CENTER);

        // btao de remocao
        JPanel painelBotoes = new JPanel();
        removerButton = new JButton("Remover");
        painelBotoes.add(removerButton);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        this.setContentPane(painel);

        // eventos
        buscarButton.addActionListener(e -> atualizarTabela());
        removerButton.addActionListener(e -> removerUsuarioSelecionado());

        this.setVisible(true);
    }

    private void atualizarTabela() {
        String nomePesquisa = pesquisar.getText().trim();
        modeloTabela.filtrarUsuarios(nomePesquisa);
    }

    private void removerUsuarioSelecionado() {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada != -1) {
            Long idUsuario = (Long) tabela.getValueAt(linhaSelecionada, 0);
            try {
                String mensagem = usuarioController.removerUsuario(idUsuario);
                JOptionPane.showMessageDialog(null, mensagem);
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao remover usuário: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para remover.");
        }
    }

    private class UsuarioTabela extends AbstractTableModel {
        private final String[] colunas = {"Id", "Nome", "E-mail", "Celular", "Sexo"};
        private List<UsuarioModel> usuarios;
        private List<UsuarioModel> usuariosFiltrados;

        public UsuarioTabela() {
            try {
                usuarios = usuarioController.buscarUsuarios();
                usuariosFiltrados = usuarios;
            } catch (Exception e) {
                usuarios = List.of();
                usuariosFiltrados = usuarios;
            }
        }

        public void filtrarUsuarios(String nome) {
            if (nome.isEmpty()) {
                usuariosFiltrados = usuarios;
            } else {
                usuariosFiltrados = usuarios.stream()
                        .filter(u -> u.getNome().toLowerCase().contains(nome.toLowerCase()))
                        .collect(Collectors.toList());
            }
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return usuariosFiltrados.size();
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return colunas[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            UsuarioModel usuario = usuariosFiltrados.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> usuario.getIdUsuario();
                case 1 -> usuario.getNome();
                case 2 -> usuario.getEmail();
                case 3 -> usuario.getNum_celular();
                case 4 -> usuario.getSexo() != null ? usuario.getSexo() : "Não informado";
                default -> "-";
            };
        }
    }
}
