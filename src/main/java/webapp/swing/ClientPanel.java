package webapp.swing;

import com.br.parking.model.Client;
import com.br.parking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Component
public class ClientPanel extends JPanel {

    @Autowired
    private ClientService clientService;

    private JTable clientTable;
    private JButton addButton, updateButton, deleteButton;
    private ClientTableModel clientTableModel;

    public ClientPanel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Name", "Phone", "Email"};
        clientTableModel = new ClientTableModel(columnNames);
        clientTable = new JTable(clientTableModel);

        JScrollPane scrollPane = new JScrollPane(clientTable);

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
                // Open dialog to input new client details
                String name = JOptionPane.showInputDialog("Enter Client Name:");
                String phone = JOptionPane.showInputDialog("Enter Phone:");
                String email = JOptionPane.showInputDialog("Enter Email:");

                // Create and save new client
                Client client = new Client();
                client.setName(name);
                client.setPhone(phone);
                client.setEmail(email);

                clientService.createClient(client);
                refreshClientTable();
            }
        });

        // Implement other action listeners for update and delete buttons...
    }

    private void refreshClientTable() {
        List<Client> clients = clientService.getAllClients();
        clientTableModel.setClients(clients);
    }
}