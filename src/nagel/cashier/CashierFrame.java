package nagel.cashier;

import javax.swing.*;
import java.awt.*;

public class CashierFrame extends JFrame {
    private Cash customerPay = new Cash();
    private Cashier cashier;
    private Cash change;

    private JButton pennies;
    private JButton nickels;
    private JButton dimes;
    private JButton quarters;
    private JButton ones;
    private JButton fives;
    private JButton tens;
    private JButton twenties;

    private JLabel priceLabel;
    private JTextField enterPrice;
    private JButton clear;
    private JButton pay;

    private JLabel registerLabel;
    private JTextField register;
    private JLabel changeLabel;
    private JTextField moneyOwed;
    private JLabel error;

    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;

    public CashierFrame() {
        setSize(300, 400);
        setTitle("Cashier");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        pennies = new JButton("0.01");
        nickels = new JButton("0.05");
        dimes = new JButton("0.10");
        quarters = new JButton("0.25");
        ones = new JButton("1.00");
        fives = new JButton("5.00");
        tens = new JButton("10.00");
        twenties = new JButton("20.00");

        priceLabel = new JLabel("Price");
        enterPrice = new JTextField();
        clear = new JButton("Clear");
        pay = new JButton("Pay");

        registerLabel = new JLabel("Register");
        register = new JTextField();
        changeLabel = new JLabel("Change");
        moneyOwed = new JTextField();
        error = new JLabel("Error");

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        //setContentPane(topPanel);
        topPanel.add(pennies);
        topPanel.add(nickels);
        topPanel.add(dimes);
        topPanel.add(quarters);
        topPanel.add(ones);
        topPanel.add(fives);
        topPanel.add(tens);
        topPanel.add(twenties);

        middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.add(priceLabel);
        middlePanel.add(enterPrice);
        middlePanel.add(clear);
        middlePanel.add(pay);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(registerLabel);
        bottomPanel.add(register);
        bottomPanel.add(changeLabel);
        bottomPanel.add(moneyOwed);

/*        if(cashier.cashRegister.totalCash() == 0) {
            error.setBackground(Color.RED);
            bottomPanel.add(error);*/

        add(topPanel);
        add(middlePanel);
        add(bottomPanel);

        pennies.addActionListener(actionEvent -> customerPay.addPennies(1));
        nickels.addActionListener(actionEvent -> customerPay.addNickels(1));
        dimes.addActionListener(actionEvent -> customerPay.addDimes(1));
        quarters.addActionListener(actionEvent -> customerPay.addQuarters(1));
        ones.addActionListener(actionEvent -> customerPay.addOnes(1));
        fives.addActionListener(actionEvent -> customerPay.addFives(1));
        tens.addActionListener(actionEvent -> customerPay.addTens(1));
        twenties.addActionListener(actionEvent -> customerPay.addTwenties(1));

        pay.addActionListener(actionEvent -> {
            try {
                pay();
            } catch (NotEnoughChangeException exc) {
                exc.printStackTrace();
            }
        });
        clear.addActionListener(actionEvent -> enterPrice.setText(null));
    }

    private Cash pay() throws NotEnoughChangeException {
        //customerPay = new Cash();
        cashier = new Cashier();
        cashier.pay(2.49, customerPay);

        return change;
    }

    public static void main(String[] args) {
        new CashierFrame().setVisible(true);
    }
}

