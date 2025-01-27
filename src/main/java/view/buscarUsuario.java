package view;

import model.UsuarioModel;
import repository.UsuarioRepository;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class buscarUsuario extends JFrame {
    private JTextField pesquisar;
    private JButton buscarButton;
    private JTable tabela;

    public List<UsuarioModel> buscarTodos() {
        try {
            EntityManager entityManager = null;
            List<UsuarioModel> usuario = entityManager.createQuery("from UsuarioModel").getResultList();
            return usuario;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public buscarUsuario() {
        this.setTitle("Buscar Usuários");
        UsuarioTabela usuarioTabela = new UsuarioTabela();
        tabela.setModel(usuarioTabela);
        tabela.setAutoCreateRowSorter(true);
        this.setContentPane(pesquisar);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private static class UsuarioTabela extends AbstractTableModel{
        private UsuarioRepository usuarioRepository = new UsuarioRepository();
        private final String[] COLUMNS = new String[] {"Id", "Nome", "Idade", "Turma"};
        private List<UsuarioModel> listaU = UsuarioRepository.buscarUsuario();

        @Override
        public int getRowCount() {
            return listaU.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> listaU.get(rowIndex).getIdUsuario();
                case 1 -> listaU.get(rowIndex).getNome();
                case 2 -> listaU.get(rowIndex).getEmail();
                case 3 -> listaU.get(rowIndex).getNum_celular();

                case 4 -> listaU.get(rowIndex).getSexo();
                default -> "-";
            };
        }
        @Override
        public String getColumnName(int columnIndex){
            return COLUMNS[columnIndex];
        }
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0,columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }else {
                return Object.class;
            }
        }
    }
}


