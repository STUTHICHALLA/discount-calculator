import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiscountApp extends JFrame {

    private JTextField nameField, priceField, discountField;
    private JLabel resultLabel;

    public DiscountApp() {
        setTitle("🛍️ Smart Discount Calculator");
        setSize(420, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(30, 30, 30)); // Dark theme

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        // Title
        JLabel title = new JLabel("Discount Calculator", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Product Name
        addLabel(panel, "Product Name:", gbc, 1);
        nameField = createField(font);
        addField(panel, nameField, gbc, 1);

        // Price
        addLabel(panel, "Price (₹):", gbc, 2);
        priceField = createField(font);
        addField(panel, priceField, gbc, 2);

        // Discount
        addLabel(panel, "Discount (%):", gbc, 3);
        discountField = createField(font);
        addField(panel, discountField, gbc, 3);

        // Buttons
        JButton calcBtn = new JButton("Calculate");
        JButton clearBtn = new JButton("Clear");

        styleButton(calcBtn, new Color(0, 153, 76));
        styleButton(clearBtn, new Color(204, 0, 0));

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(calcBtn, gbc);

        gbc.gridx = 1;
        panel.add(clearBtn, gbc);

        // Result
        resultLabel = new JLabel("Final Price: ₹0");
        resultLabel.setForeground(Color.YELLOW);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(resultLabel, gbc);

        // Button Actions
        calcBtn.addActionListener(e -> calculate());
        clearBtn.addActionListener(e -> clearFields());

        add(panel);
        setVisible(true);
    }

    private void calculate() {
        try {
            String name = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText());
            double discount = Double.parseDouble(discountField.getText());

            if (price < 0 || discount < 0) {
                throw new NumberFormatException();
            }

            double finalPrice = price - (price * discount / 100);

            resultLabel.setText("Final Price of " + name + " = ₹" + String.format("%.2f", finalPrice));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "⚠️ Enter valid details!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        priceField.setText("");
        discountField.setText("");
        resultLabel.setText("Final Price: ₹0");
    }

    private JTextField createField(Font font) {
        JTextField field = new JTextField();
        field.setFont(font);
        field.setBackground(new Color(50, 50, 50));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        return field;
    }

    private void addLabel(JPanel panel, String text, GridBagConstraints gbc, int y) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.LIGHT_GRAY);
        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(label, gbc);
    }

    private void addField(JPanel panel, JTextField field, GridBagConstraints gbc, int y) {
        gbc.gridx = 1;
        gbc.gridy = y;
        panel.add(field, gbc);
    }

    private void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
    }

    public static void main(String[] args) {
        new DiscountApp();
    }
}