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
    private JButton removerbutton;
    private JPanel painel;

public buscarUsuario() {
      this.setTitle("Buscar Usuários");
      UsuarioTabela usuarioTabela = new UsuarioTabela();
      tabela.setModel(usuarioTabela);
      tabela.setAutoCreateRowSorter(true);
      this.setContentPane(painel);
      this.setSize(640, 480);
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      this.setVisible(true);
    }

    public List<UsuarioModel> buscarUsuario() {
        try {
            EntityManager entityManager = null;
            List<UsuarioModel> usuario = entityManager.createQuery("from UsuarioModel").getResultList();
            return usuario;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private class UsuarioTabela extends AbstractTableModel{
        private UsuarioRepository usuarioRepository = new UsuarioRepository();
        private final String[] COLUMNS = new String[] {"Id", "Nome", "E-mail", "Celular", "Sexo"};
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
                case 4 -> listaU.get(rowIndex).getSexo() != null ? listaU.get(rowIndex).getSexo() : "Não informado";
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


