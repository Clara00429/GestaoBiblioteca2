package view;

import controller.LivroController;
import model.LivroModel;
import repository.LivroRepository;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListarLivro extends JFrame {
    private LivroRepository livroRepository = new LivroRepository();
    private JTable tableListaLivro;
    private JPanel painel;
    private JButton remover;
    private JButton buscar;
    private JTextField pesquisar;
    private JScrollPane scrollLista;
    private LivroTableModel tableModel;
    private LivroController livroControle = new LivroController();


    public ListarLivro() {
        this.setTitle("Lista de Livros");
        List<LivroModel> livros = livroRepository.listarTodos();
        LivroTableModel livroTableModel = new LivroTableModel(livros);
        tableListaLivro.setModel(livroTableModel);
        tableListaLivro.setAutoCreateRowSorter(true);
        this.setContentPane(painel);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        remover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remover();
            }
        });
    }
    private void AtualizarTabela(){
        //tableListaLivro.setModel(new LivroTableModel());
    }

    private  void remover() {
        int linhaSelecionada = tableListaLivro.getSelectedRow();
        if (linhaSelecionada != -1){
            long idLivro = (long) tableListaLivro.getValueAt(linhaSelecionada, 0);
            try {
                String mensagem = livroControle.removerLivro(idLivro);
                JOptionPane.showMessageDialog(null, mensagem);
                AtualizarTabela();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao remover livro: " + e.getMessage());
            }
        }else {
            JOptionPane.showMessageDialog(null, "Selecione um livro para remover.");
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private class LivroTableModel extends AbstractTableModel {
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
