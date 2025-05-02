package connect_database;

import javax.swing.*;

public class Bai__1 extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JPanel inputPanel;

    public Bai__1() {
        // Set up the JFrame
        setTitle("Bai 1");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the UI components
//        $$$setupUI$$$();
        inputPanel = new JPanel();

        // Set the content pane
        setContentPane(inputPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai__1();
    }

    private void createUIComponents() {
        // Custom component creation (if needed)
    }
}