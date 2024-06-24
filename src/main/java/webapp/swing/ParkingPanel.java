package webapp.swing;

import com.br.parking.model.ParkingSpot;
import com.br.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Component
public class ParkingPanel extends JPanel {

    @Autowired
    private ParkingService parkingService;

    private JTable parkingTable;
    private JButton addButton, updateButton, deleteButton;
    private ParkingTableModel parkingTableModel;

    public ParkingPanel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Number", "Location", "Status", "Vehicle Type"};
        parkingTableModel = new ParkingTableModel(columnNames);
        parkingTable = new JTable(parkingTableModel);

        JScrollPane scrollPane = new JScrollPane(parkingTable);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open dialog to input new parking spot details
                String number = JOptionPane.showInputDialog("Enter Parking Spot Number:");
                String location = JOptionPane.showInputDialog("Enter Location:");
                String status = JOptionPane.showInputDialog("Enter Status:");
                String vehicleType = JOptionPane.showInputDialog("Enter Vehicle Type:");

                // Create and save new parking spot
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setNumber(number);
                parkingSpot.setLocation(location);
                parkingSpot.setStatus(status);
                parkingSpot.setVehicleType(vehicleType);

                parkingService.createParkingSpot(parkingSpot);
                refreshParkingTable();
            }
        });

        // Implement other action listeners for update and delete buttons...
    }

    private void refreshParkingTable() {
        List<ParkingSpot> parkingSpots = parkingService.getAllParkingSpots();
        parkingTableModel.setParkingSpots(parkingSpots);
    }
}