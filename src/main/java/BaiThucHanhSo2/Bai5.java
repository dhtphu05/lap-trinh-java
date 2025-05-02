package BaiThucHanhSo2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai5 extends JFrame implements ActionListener {
    JTextField display;
    JPanel buttonPanel, panelInput, panelEqual;

    public Bai5() {
        setTitle("Calculator");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel(new GridLayout(1,2,5,5));
        panelInput = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] labels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "C", "+",
        };

        for (String label : labels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            if (label.equals("")) {
                button.setEnabled(false);
            }
            button.addActionListener(this);
            panelInput.add(button);
        }
        JButton equalButton = new JButton("=");
        equalButton.setFont(new Font("Arial", Font.BOLD, 18));
        equalButton.addActionListener(this);
        panelEqual = new JPanel(new GridLayout(1, 1, 5, 5));
        panelEqual.add(equalButton);
        buttonPanel.add(panelInput);
        buttonPanel.add(panelEqual);
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            display.setText("");
        } else if (command.equals("=")) {

                String expr = display.getText();
                double result = evalExpression(expr);
                // nguyen thi kh hien thi thap phan
                if(result == (int)result) {
                    display.setText(String.valueOf((int) result));
                } else {
                    display.setText(String.valueOf(result));
                }

        } else {
            display.setText(display.getText() + command);
        }
    }
    public double evalExpression(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                if(++pos < expression.length()) {
                    ch = expression.charAt(pos);
                } else {
                    ch = -1;
                }
            }

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

            double parse() {
                nextChar();
                double x = parseExpression();
                return x;
            }
            double parseExpression() {
                double x = parseTerm();
                while (true) {
                    if (eat('+')) {
                        x += parseTerm();
                    } else if (eat('-')) {
                        x -= parseTerm();
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                while (true) {
                    if (eat('*')) {
                        x *= parseFactor();
                    } else if (eat('/')) {
                        x /= parseFactor();
                    } else {
                        return x;
                    }
                }
            }

            double parseFactor() {
                if (eat('+')) {
                    return parseFactor();
                }
                if (eat('-')) {
                    return -parseFactor();
                }

                double x = 0;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(expression.substring(startPos, pos));
                }
                return x;
            }
        }.parse();
    }

    public static void main(String[] args) {
        new Bai5();
    }
}

