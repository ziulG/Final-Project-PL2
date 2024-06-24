package webapp.swing;

import com.br.parking.model.Payment;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class PaymentTableModel extends AbstractTableModel {

    private String[] columnNames;
    private List<Payment> payments;

    public PaymentTableModel(String[] columnNames) {
        this.columnNames = columnNames;
        this.payments = new ArrayList<>();
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return payments.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Payment payment = payments.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return payment.getId();
            case 1:
                return payment.getClientId();
            case 2:
                return payment.getAmount();
            case 3:
                return payment.getPaymentMethod();
            case 4:
                return payment.getDate();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}