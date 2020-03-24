package nagel.cashier;

import javax.swing.*;
import java.awt.*;

public class CashierFrame extends JFrame {
    private Cash customerPay = new Cash();
    private Cash cashRegister = new Cash();
    private Cashier cashier;
   // private Cash change;

    private JPanel cashierPanel;
    private JLabel totalPayment;
    private JButton pennies;
    private JButton nickels;
    private JButton dimes;
    private JButton quarters;
    private JButton ones;
    private JButton fives;
    private JButton tens;
    private JButton twenties;

    private JLabel priceLabel;
    private JTextField price;
    private JButton clear;
    private JButton pay;

    private JLabel registerLabel;
    private JLabel register;
    private JLabel changeLabel;
    private JLabel change;
    //private JTextField moneyOwed;
    private JLabel error;

    private JPanel payPanel;
    private JPanel pricePanel;
    private JPanel registerPanel;
    private JPanel changePanel;

    public CashierFrame() {
        setSize(600, 300);
        setTitle("Cashier");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cashierPanel = new JPanel();
        cashierPanel.setLayout(new BoxLayout(cashierPanel, BoxLayout.PAGE_AXIS));

        payPanel = new JPanel();
        payPanel.setLayout(new FlowLayout());
        totalPayment = new JLabel("\n Total Customer Payment: $0.00");
        pennies = new JButton("0.01");
        nickels = new JButton("0.05");
        dimes = new JButton("0.10");
        quarters = new JButton("0.25");
        ones = new JButton("1.00");
        fives = new JButton("5.00");
        tens = new JButton("10.00");
        twenties = new JButton("20.00");
        payPanel.add(pennies);
        payPanel.add(nickels);
        payPanel.add(dimes);
        payPanel.add(quarters);
        payPanel.add(ones);
        payPanel.add(fives);
        payPanel.add(tens);
        payPanel.add(twenties);
        payPanel.add(totalPayment);

        pricePanel = new JPanel();
        pricePanel.setLayout(new FlowLayout());
        priceLabel = new JLabel("Price: ");
        price = new JTextField();
        price.setColumns(10);
        clear = new JButton("Clear");
        pay = new JButton("Pay");
        pricePanel.add(priceLabel);
        pricePanel.add(price);
        pricePanel.add(pay);
        pricePanel.add(clear);

        registerPanel = new JPanel();
        registerPanel.setLayout(new FlowLayout());
        registerLabel = new JLabel("Register: ");
        fillRegister();
        register = new JLabel(String.format("$%.2f", cashRegister.getTotalCash()));
        registerPanel.add(registerLabel);
        registerPanel.add(register);

        changePanel = new JPanel();
        changePanel.setLayout(new FlowLayout());
        changeLabel = new JLabel("Change: ");
        change = new JLabel();
        changePanel.add(changeLabel);
        changePanel.add(change);

        error = new JLabel();
        error.setAlignmentX(CENTER_ALIGNMENT);

        cashierPanel.add(payPanel);
        cashierPanel.add(pricePanel);
        cashierPanel.add(registerPanel);
        cashierPanel.add(changePanel);
        cashierPanel.add(error);

        add(cashierPanel);


        pennies.addActionListener(actionEvent -> addPennies());
        nickels.addActionListener(actionEvent -> addNickels());
        dimes.addActionListener(actionEvent -> addDimes());
        quarters.addActionListener(actionEvent -> addQuarters());
        ones.addActionListener(actionEvent -> addOnes());
        fives.addActionListener(actionEvent -> addFives());
        tens.addActionListener(actionEvent -> addTens());
        twenties.addActionListener(actionEvent -> addTwenties());
        pay.addActionListener(actionEvent -> payCashier());
        clear.addActionListener(actionEvent -> clearFrame());
    }

    private void fillRegister() {
        cashRegister.setQuarterAmt(100);
        cashRegister.setPennyAmt(0);
    }

    private void payCashier() {
        cashier = new Cashier();
        cashier.cashRegister = this.cashRegister;
        double displayPrice = Double.parseDouble(price.getText());
        Cash changeDue = new Cash();
        try {
           changeDue = cashier.pay(displayPrice, customerPay);
        }
        catch (NotEnoughChangeException e) {
            error.setText("Error!");
        }
        change.setText(String.format("$%.2f", changeDue.getTotalCash()));
        register.setText(String.format("$%.2f" , cashRegister.getTotalCash()));
        error.setText("");
    }

    private void clearFrame() {
        customerPay.setPennyAmt(0);
        customerPay.setNickelAmt(0);
        customerPay.setDimeAmt(0);
        customerPay.setQuarterAmt(0);
        customerPay.setOnesAmt(0);
        customerPay.setFivesAmt(0);
        customerPay.setTensAmt(0);
        customerPay.setTwentiesAmt(0);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
        price.setText("");
        change.setText("");
        error.setText("");
    }

    private void addPennies() {
        customerPay.addPennies(1);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
    }

    private void addNickels() {
        customerPay.addNickels(1);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
    }

    private void addDimes() {
        customerPay.addDimes(1);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
    }

    private void addQuarters() {
        customerPay.addQuarters(1);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
    }

    private void addOnes() {
        customerPay.addOnes(1);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
    }

    private void addFives() {
        customerPay.addFives(1);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
    }

    private void addTens() {
        customerPay.addTens(1);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
    }

    private void addTwenties() {
        customerPay.addTwenties(1);
        totalPayment.setText(String.format("\nTotal Customer Payment: $%.2f", customerPay.getTotalCash()));
    }

    public static void main(String[] args) {
        new CashierFrame().setVisible(true);
    }
}

