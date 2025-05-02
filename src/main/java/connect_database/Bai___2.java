package connect_database;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Bai___2 extends JFrame {
    private JTextField inputSearch;
    private JButton searchButton, resetButton, cancelButton;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JCheckBox checkId, checkName, checkDate, checkGender;
    private ButtonGroup buttonGroup;
    public Bai___2() {
        initUI();
    }
    private void initUI(){
        setTitle("Database Programming");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        add(createInputPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);



    }
    public JPanel createInputPanel(){
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        line1.add(new JLabel("Nhap noi dung: "));
        inputSearch = new JTextField(30);
        line1.add(inputSearch);
        searchButton = new JButton("Search");
        line1.add(searchButton);
        resetButton = new JButton("Reset");
        line1.add(resetButton);
        cancelButton = new JButton("Cancel");
        line1.add(cancelButton);
        line2.add(new JLabel("Tim kiem theo: "));
        checkId = new JCheckBox("Id");
        checkName = new JCheckBox("Name");
        checkDate = new JCheckBox("Date");
        checkGender = new JCheckBox("Gender");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(checkId);
        buttonGroup.add(checkName);
        buttonGroup.add(checkDate);
        buttonGroup.add(checkGender);
        line2.add(checkId);
        line2.add(checkName);
        line2.add(checkDate);
        line2.add(checkGender);
        inputPanel.add(line1, BorderLayout.NORTH);
        inputPanel.add(line2, BorderLayout.CENTER);
        return inputPanel;
    }
    private JScrollPane createTablePanel(){
        String[] columnNames = {"Ma So", "Ho va Ten", "Ngay sinh","Dia chi", "Gioi tinh"};
        tableModel = new DefaultTableModel(columnNames, 0);
        resultTable = new JTable(tableModel);
        return new JScrollPane(resultTable);
    }

    public static void main(String[] args) {

        try{
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            String url = "jdbc:mysql://localhost:3306/DATA";
            String user = "root";
            String password = "180723";
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement statement = connection.createStatement();
            System.out.println("Connected to the database!");
            // Create a table



        }
        catch (Exception e){
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            Bai___2 app = new Bai___2();
            app.setVisible(true);
            app.searchButton.addActionListener(e -> {
                String input = app.inputSearch.getText();
                String sql = "SELECT * FROM table2 WHERE ";
                if (app.checkId.isSelected()) {
                    sql += "id LIKE '%"  + input + "%'";
                } else if (app.checkName.isSelected()) {
                    sql += "name LIKE '%" + input + "%'";
                } else if (app.checkDate.isSelected()) {
                    sql += "date LIKE '%" + input + "%'";
                } else if (app.checkGender.isSelected()) {
                    sql += "gender LIKE '%" + input + "%'";
                }
                System.out.println(sql);
                try{
                    String url = "jdbc:mysql://localhost:3306/DATA";
                    String user = "root";
                    String password = "180723";
                    Connection connection = DriverManager.getConnection(url, user, password);
                    // Create a statement
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    app.tableModel.setRowCount(0);
                    while (resultSet.next()) {
                        Object[] rowData = new Object[5];
                        rowData[0] = resultSet.getInt("id");
                        rowData[1] = resultSet.getString("name");
                        rowData[2] = resultSet.getString("date");
                        rowData[3] = resultSet.getString("address");
                        rowData[4] = resultSet.getString("gender");
                        app.tableModel.addRow(rowData);
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            });
            app.resetButton.addActionListener(e -> {
                app.inputSearch.setText("");
                app.tableModel.setRowCount(0);
            });
            app.cancelButton.addActionListener(e -> {
                app.dispose();
            });
        });

    }

}
