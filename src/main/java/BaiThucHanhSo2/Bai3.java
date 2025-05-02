package BaiThucHanhSo2;
import javax.swing.*;
import java.awt.*;

public class Bai3 extends JFrame {
    private JButton btnRed, btnGreen, btnBlue, btnExit;
    private JPanel mainPanel;

    public Bai3() {
        setTitle("Doi Mau Nen");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.GREEN);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);

        btnRed = new JButton("RED");
        btnGreen = new JButton("GREEN");
        btnBlue = new JButton("BLUE");
        btnExit = new JButton("Thoát");

        buttonPanel.add(btnRed);
        buttonPanel.add(btnGreen);
        buttonPanel.add(btnBlue);
        buttonPanel.add(btnExit);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);

        btnRed.addActionListener(e -> mainPanel.setBackground(Color.RED));
        btnGreen.addActionListener(e -> mainPanel.setBackground(Color.GREEN));
        btnBlue.addActionListener(e -> mainPanel.setBackground(Color.BLUE));
        btnExit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3().setVisible(true));
    }
}
