package view;

import controller.UsuarioController;
import model.UsuarioModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BuscarUsuario extends JFrame {
    private JTextField pesquisar;
    private JButton buscarButton;
    private JTable tabela;
    private JButton removerButton;
    private JPanel painel;
    private UsuarioController usuarioController;

    public BuscarUsuario() {
        this.setTitle("Buscar Usuários");
        this.setSize(840, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        usuarioController = new UsuarioController();

        painel = new JPanel();
        tabela = new JTable(new UsuarioTabela());
        JScrollPane scrollPane = new JScrollPane(tabela);
        painel.add(scrollPane);

        this.setContentPane(painel);

        buscarButton = new JButton("Buscar");
        removerButton = new JButton("Remover");

        painel.add(buscarButton);
        painel.add(removerButton);

        buscarButton.addActionListener(e -> atualizarTabela());
        removerButton.addActionListener(e -> removerUsuarioSelecionado());

        this.setVisible(true);
    }

    private void atualizarTabela() {
        tabela.setModel(new UsuarioTabela());
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

        public UsuarioTabela() {
            try {
                usuarios = usuarioController.buscarUsuarios();
            } catch (Exception e) {
                usuarios = List.of();
            }
        }

        @Override
        public int getRowCount() {
            return usuarios.size();
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
            UsuarioModel usuario = usuarios.get(rowIndex);
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
