package view;

import model.LivroModel;
import repository.LivroRepository;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ListarLivro extends JFrame {
    private LivroRepository livroRepository = new LivroRepository();
    private JTable tableListaLivro;
    private JPanel painel;
    private JScrollPane scrollLista;
    private LivroTableModel tableModel;

    public ListarLivro() {
        this.setTitle("Lista de Livros");

        painel = new JPanel();

        List<LivroModel> livros = livroRepository.listarTodos();

        tableModel = new LivroTableModel(livros);
        tableListaLivro = new JTable(tableModel);

        scrollLista = new JScrollPane(tableListaLivro);
        painel.add(scrollLista);

        this.setContentPane(painel);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    class LivroTableModel extends AbstractTableModel {
        private final List<LivroModel> livros;
        private final String[] colunas = {"ID", "Título", "Autor", "Ano"};

        public LivroTableModel(List<LivroModel> livros) {
            this.livros = livros;
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
            switch (columnIndex) {
                case 0: return livro.getIdLivro();
                case 1: return livro.getTitulo();
                case 2: return livro.getAutor();
                case 3: return livro.getDataPublicacao();
                default: return null;
            }
        }
    }
}
