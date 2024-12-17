package magazin;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class magazin1 {
	 private String[] products = {"Хлеб", "Молоко", "Яблоки"};
	    private String[] expiryDates = {"2023-10-01", "2023-10-10", "2023-10-15"};
	    private double[] prices = {50, 60, 30}; // цена каждого продукта

    public static void main(String[] args) {
        new magazin1().createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame("Магазин продуктов");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Имя:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel productLabel = new JLabel("Продукт:");
        productLabel.setBounds(10, 50, 80, 25);
        panel.add(productLabel);

        JComboBox<String> productList = new JComboBox<>(products);
        productList.setBounds(100, 50, 165, 25);
        panel.add(productList);

        JLabel expiryDateLabel = new JLabel("Срок годности:");
        expiryDateLabel.setBounds(10, 80, 120, 25);
        panel.add(expiryDateLabel);

        JComboBox<String> expiryDateList = new JComboBox<>(expiryDates);
        expiryDateList.setBounds(140, 80, 125, 25);
        panel.add(expiryDateList);

        JLabel quantityLabel = new JLabel("Количество:");
        quantityLabel.setBounds(10, 110, 80, 25);
        panel.add(quantityLabel);

        JTextField quantityText = new JTextField(20);
        quantityText.setBounds(100, 110, 165, 25);
        panel.add(quantityText);

        JButton calculateButton = new JButton("Результат");
        calculateButton.setBounds(10, 140, 150, 25);
        panel.add(calculateButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 170, 350, 100);
        panel.add(resultArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String product = (String) productList.getSelectedItem();
                String expiryDate = (String) expiryDateList.getSelectedItem();
                int quantity = Integer.parseInt(quantityText.getText());

                double price = prices[productList.getSelectedIndex()];
                double totalCost = quantity * price;

                String result = "Здравствуйте, " + name + "!\n" +
                        "Продукт: " + product + "\n" +
                        "Срок годности: " + expiryDate + "\n" +
                        "Количество: " + quantity + "\n" +
                        "Цена за единицу: " + price + "₽\n" +
                        "Общая стоимость: " + totalCost + "₽";

                resultArea.setText(result);
            }
        });
    }

}