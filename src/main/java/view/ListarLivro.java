package view;

import repository.LivroRepository;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ListarLivro extends JFrame implements TableModel {
    private LivroRepository livroRepository = new LivroRepository();
    private JTable tableListaLivro;
    private JPanel painel;
    private JScrollPane scrollLista;

    public ListarLivro() {
        this.setTitle("Lista de Livro");

        painel = new JPanel();

        tableListaLivro = new JTable();
        scrollLista = new JScrollPane(tableListaLivro);
        painel.add(scrollLista);

        ListarLivro listaLivro = new ListarLivro();
        tableListaLivro.setModel(listaLivro);
        tableListaLivro.setAutoCreateRowSorter(true);

        this.setContentPane(painel);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);


    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
