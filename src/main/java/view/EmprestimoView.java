package view;

import controller.LivroController;
import model.LivroModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class EmprestimoView extends JFrame {
    private JTable tabela;
    private JTextField usuarioField;
    private JButton emprestarButton;
    private LivroController livroController;
    private LivroTableModel tableModel;

    public EmprestimoView() {
        this.setTitle("Emprestar Livro");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        livroController = new LivroController();
        JPanel painel = new JPanel(new BorderLayout());

        // tabela de livros
        try {
            tableModel = new LivroTableModel();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela);
        painel.add(scrollPane, BorderLayout.CENTER);

        // painel de emprestimo
        JPanel painelEmprestimo = new JPanel();
        usuarioField = new JTextField(20);
        emprestarButton = new JButton("Emprestar");
        painelEmprestimo.add(new JLabel("Usuário:"));
        painelEmprestimo.add(usuarioField);
        painelEmprestimo.add(emprestarButton);
        painel.add(painelEmprestimo, BorderLayout.SOUTH);

        this.setContentPane(painel);

        // evento de emprestimo
        emprestarButton.addActionListener(e -> emprestarLivro());

        this.setVisible(true);
    }

    private void emprestarLivro() {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um livro para emprestar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String usuario = usuarioField.getText().trim();
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do usuário.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LivroModel livroSelecionado = tableModel.getLivroAt(selectedRow);
        //String de controle
        String sucesso = "Erro!";
        try {
            //se entrar aq eh pq deu certo o emprestimo de livro
            sucesso = livroController.emprestarLivro(livroSelecionado, usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JOptionPane.showMessageDialog(this, sucesso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    }

    class LivroTableModel extends AbstractTableModel {
        private final String[] colunas = {"ID", "Título", "Autor", "Ano", "Quantidade"};
        private List<LivroModel> livros;

        public LivroTableModel() throws SQLException {
            livros = livroController.listarDisponiveis();
        }

        public LivroModel getLivroAt(int rowIndex) {
            return livros.get(rowIndex);
        }

        public void removerLivro(int rowIndex) {
            livros.remove(rowIndex);
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return livros.size();
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
            LivroModel livro = livros.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> livro.getIdLivro();
                case 1 -> livro.getTitulo();
                case 2 -> livro.getAutor();
                case 3 -> livro.getDataPublicacao();
                case 4 -> livro.getQuantidade();
                default -> "-";
            };
        }
    }
}