package view;

import controller.LivroController;
import model.LivroModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ListarLivro extends JFrame {
    private JTextField pesquisar;
    private JButton buscarButton;
    private JButton remover;
    private JTable tabela;
    private JPanel painel;
    private LivroController livroController;
    private LivroTableModel tableModel;

    public ListarLivro() {
        this.setTitle("Lista de Livros");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        livroController = new LivroController();
        painel = new JPanel(new BorderLayout());

        // painel de busca
        JPanel painelBusca = new JPanel();
        pesquisar = new JTextField(20);
        buscarButton = new JButton("Buscar");
        remover = new JButton("Remover");
        painelBusca.add(new JLabel("Título:"));
        painelBusca.add(pesquisar);
        painelBusca.add(buscarButton);
        painelBusca.add(remover);
        painel.add(painelBusca, BorderLayout.NORTH);

        // tabela
        tableModel = new LivroTableModel();
        tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela);
        painel.add(scrollPane, BorderLayout.CENTER);

        this.setContentPane(painel);

        // evento para buscar
        buscarButton.addActionListener(e -> atualizarTabela());

        this.setVisible(true);
    }

    private void atualizarTabela() {
        String tituloPesquisa = pesquisar.getText().trim();
        tableModel.filtrarLivros(tituloPesquisa);
    }

    /*private void removerLivroSelec() {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada != -1) {
            Long idLivro = (Long) tabela.getValueAt(linhaSelecionada, 0);
            try {
                String mensagem = livroController.removerLivro(idLivro);
                JOptionPane.showMessageDialog(null, mensagem);
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao remover livro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um livro para remover.");
        }
    }*/

    // modelo da tabela livro completo
    class LivroTableModel extends AbstractTableModel {
        private final String[] colunas = {"ID", "Título", "Autor", "Ano", "Quantidade", "Tema", "ISBN"};
        private List<LivroModel> livros;
        private List<LivroModel> livrosFiltrados;

        public LivroTableModel() {
            try {
                livros = livroController.listarTodos();
                livrosFiltrados = livros;
            } catch (Exception e) {
                livros = List.of();
                livrosFiltrados = livros;
            }
        }

        public void filtrarLivros(String titulo) {
            if (titulo.isEmpty()) {
                livrosFiltrados = livros;
            } else {
                livrosFiltrados = livros.stream()
                        .filter(l -> l.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                        .collect(Collectors.toList());
            }
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return livrosFiltrados.size();
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
            LivroModel livro = livrosFiltrados.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> livro.getIdLivro();
                case 1 -> livro.getTitulo();
                case 2 -> livro.getAutor();
                case 3 -> livro.getDataPublicacao();
                case 4 -> livro.getQuantidade();
                case 5 -> livro.getTema();
                case 6 -> livro.getIsbn();
                default -> "-";
            };
        }
    }
}
