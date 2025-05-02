package connect_database;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Bai___1 extends JFrame {
    private JTextField jdbcField;
    private JTextField queryField;
    private JComboBox<String> actionComboBox;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JButton submitButton, resetButton, cancelButton;

    public Bai___1() {
        initUI();
    }

    private void initUI() {
        setTitle("Database Programming");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(createInputPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        line1.add(new JLabel("Input Information: "));
        jdbcField = new JTextField(30);
        line1.add(jdbcField);
        line2.add(new JLabel("SQL Query: "));
        queryField = new JTextField(20);
        line2.add(queryField);
        actionComboBox = new JComboBox<>(new String[]{"Select", "Insert", "Update", "Delete"});
        line2.add(actionComboBox);

        inputPanel.add(line1, BorderLayout.NORTH);
        inputPanel.add(line2, BorderLayout.CENTER);
        return inputPanel;
    }

    private JScrollPane createTablePanel() {
        // Initialize the table model with column names
        String[] columnNames = {"Id", "Name", "Address", "Total"};
        tableModel = new DefaultTableModel(columnNames, 0);
        resultTable = new JTable(tableModel);
        return new JScrollPane(resultTable);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");
        cancelButton = new JButton("Cancel");

        panel.add(submitButton);
        panel.add(resetButton);
        panel.add(cancelButton);

        return panel;
    }

    public void executeQuery() {
        String jdbcUrl = jdbcField.getText().trim();
        String sqlQuery = queryField.getText().trim();
        String action = (String) actionComboBox.getSelectedItem();
        String user = "root";
        String password = "180723";
        System.out.println("Action: " + action);
        if (jdbcUrl.isEmpty() || sqlQuery.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both JDBC URL and SQL query.");
            return;
        }
        try (
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery)
        ) {

            tableModel.setRowCount(0);
            System.out.println("Connected to the database!");

            while (resultSet.next()) {
                Object[] rowData = new Object[4];
                rowData[0] = resultSet.getInt("id");
                rowData[1] = resultSet.getString("name");
                rowData[2] = resultSet.getString("address");
                rowData[3] = resultSet.getDouble("total");
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
       try{
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            Bai___1 app = new Bai___1();
            app.setVisible(true);


            app.submitButton.addActionListener(e -> {
                System.out.println("Submit button clicked");
                app.executeQuery();
            });

            app.resetButton.addActionListener(e -> {
                app.jdbcField.setText("");
                app.queryField.setText("");
                app.tableModel.setRowCount(0);
            });

            app.cancelButton.addActionListener(e -> {
                System.exit(0);
            });
        });
    }
}