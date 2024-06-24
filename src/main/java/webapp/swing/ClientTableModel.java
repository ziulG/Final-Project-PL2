package webapp.swing;

import com.br.parking.model.Client;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class ClientTableModel extends AbstractTableModel {

    private String[] columnNames;
    private List<Client> clients;

    public ClientTableModel(String[] columnNames) {
        this.columnNames = columnNames;
        this.clients = new ArrayList<>();
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.getId();
            case 1:
                return client.getName();
            case 2:
                return client.getPhone();
            case 3:
                return client.getEmail();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}