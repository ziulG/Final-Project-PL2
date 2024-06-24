package webapp.swing;

import com.br.parking.ParkingManagementSystemApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

public class MainFrame extends JFrame {

    private static ApplicationContext context;

    public MainFrame() {
        setTitle("Parking Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Parking Spots", context.getBean(ParkingPanel.class));
        tabbedPane.addTab("Clients", context.getBean(ClientPanel.class));
        tabbedPane.addTab("Payments", context.getBean(PaymentPanel.class));

        add(tabbedPane);

        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    public static void main(String[] args) {
        context = SpringApplication.run(ParkingManagementSystemApplication.class, args);
        new MainFrame();
    }
}
