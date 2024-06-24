package webapp.swing;

import com.br.parking.model.Payment;
import com.br.parking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Component
public class PaymentPanel extends JPanel {

    @Autowired
    private PaymentService paymentService;

    private JTable paymentTable;
    private JButton processButton;
    private PaymentTableModel paymentTableModel;

    public PaymentPanel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Client ID", "Amount", "Payment Method", "Date"};
        paymentTableModel = new PaymentTableModel(columnNames);
        paymentTable = new JTable(paymentTableModel);

        JScrollPane scrollPane = new JScrollPane(paymentTable);

        JPanel buttonPanel = new JPanel();
        processButton = new JButton("Process Payment");

        buttonPanel.add(processButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open dialog to input payment details
                String clientId = JOptionPane.showInputDialog("Enter Client ID:");
                String amount = JOptionPane.showInputDialog("Enter Amount:");
                String paymentMethod = JOptionPane.showInputDialog("Enter Payment Method:");

                // Create and process new payment
                Payment payment = new Payment();
                payment.setClientId(Long.parseLong(clientId));
                payment.setAmount(Double.parseDouble(amount));
                payment.setPaymentMethod(paymentMethod);

                paymentService.processPayment(payment);
                refreshPaymentTable();
            }
        });
    }

    private void refreshPaymentTable() {
        List<Payment> payments = paymentService.getAllPayments();
        paymentTableModel.setPayments(payments);
    }
}