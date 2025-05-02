import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    // Ô hiển thị biểu thức và kết quả
    private JTextField display;
    // Panel chứa các nút
    private JPanel buttonPanel;

    public Main() {
        setTitle("Handheld Main");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        // Tạo ô hiển thị, font lớn, căn phải
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Tạo panel nút với layout dạng lưới 5 hàng x 4 cột
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        // Danh sách các label nút, nếu "" thì nút được disable
        String[] labels = {
                "C", "(", ")", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "=", ""
        };

        for (String label : labels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            if (label.equals("")) {
                button.setEnabled(false);
            }
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            // Xóa màn hình hiển thị
            display.setText("");
        } else if (command.equals("=")) {
            try {
                String expr = display.getText();
                // Tính toán biểu thức sử dụng hàm evalExpression bên dưới
                double result = evalExpression(expr);
                // Nếu kết quả là số nguyên, hiển thị không có phần thập phân
                if(result == (int)result) {
                    display.setText(String.valueOf((int) result));
                } else {
                    display.setText(String.valueOf(result));
                }
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else {
            // Ghi nối ký tự vào ô hiển thị
            display.setText(display.getText() + command);
        }
    }

    /**
     * Phương thức tính biểu thức số học với các toán tử (+, -, *, /) và dấu ngoặc.
     * Áp dụng kỹ thuật recursive descent parsing.
     */
    public double evalExpression(String expression) {
        return new Object() {
            int pos = -1, ch;

            // Lấy ký tự kế tiếp
            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            // Ăn bỏ ký tự được chỉ định
            boolean eat(int charToEat) {
                while (ch == ' ') {
                    nextChar();
                }
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            // Phân tích biểu thức
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
                return x;
            }

            // Công thức: expression = term | expression '+' term | expression '-' term
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) {
                        x += parseTerm(); // Cộng
                    } else if (eat('-')) {
                        x -= parseTerm(); // Trừ
                    } else {
                        return x;
                    }
                }
            }

            // term = factor | term '*' factor | term '/' factor
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) {
                        x *= parseFactor();
                    } else if (eat('/')) {
                        x /= parseFactor();
                    } else {
                        return x;
                    }
                }
            }

            // factor = số, dấu ngoặc, hoặc unary +, -
            double parseFactor() {
                if (eat('+')) {
                    return parseFactor();
                }
                if (eat('-')) {
                    return -parseFactor();
                }

                double x;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') {
                    // Số
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(expression.substring(startPos, pos));
                } else if (eat('(')) {
                    // Dấu ngoặc mở, phân tích đệ quy
                    x = parseExpression();
                    if (!eat(')')) {
                        throw new RuntimeException("Missing ')'");
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
                return x;
            }
        }.parse();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main calc = new Main();
            calc.setVisible(true);
        });
    }
}
