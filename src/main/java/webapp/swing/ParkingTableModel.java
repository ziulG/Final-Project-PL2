package webapp.swing;

import com.br.parking.model.ParkingSpot;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class ParkingTableModel extends AbstractTableModel {

    private String[] columnNames;
    private List<ParkingSpot> parkingSpots;

    public ParkingTableModel(String[] columnNames) {
        this.columnNames = columnNames;
        this.parkingSpots = new ArrayList<>();
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return parkingSpots.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ParkingSpot parkingSpot = parkingSpots.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return parkingSpot.getId();
            case 1:
                return parkingSpot.getNumber();
            case 2:
                return parkingSpot.getLocation();
            case 3:
                return parkingSpot.getStatus();
            case 4:
                return parkingSpot.getVehicleType();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
