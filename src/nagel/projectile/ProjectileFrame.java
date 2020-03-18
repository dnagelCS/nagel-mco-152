package nagel.projectile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ProjectileFrame extends JFrame {
    private Projectile projectile;

    private JTextArea projectileCoordinates;
    private JTextField velocity;
    private JTextField angle;
    private JButton calculateButton;
    private JLabel velocityLabel;
    private JLabel angleLabel;

    private JPanel leftPanel;

    public ProjectileFrame() {
        setSize(300, 400);
        setTitle("Projectile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        projectileCoordinates = new JTextArea();
        velocity = new JTextField();
        angle = new JTextField();
        calculateButton = new JButton("Calculate");
        velocityLabel = new JLabel("Velocity");
        angleLabel = new JLabel("Angle (degrees)");

        calculateButton.addActionListener(actionEvent -> calculate());

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 2));
        leftPanel.add(velocityLabel);
        leftPanel.add(velocity);
        leftPanel.add(angleLabel);
        leftPanel.add(angle);
        leftPanel.add(calculateButton);

        add(projectileCoordinates, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.PAGE_START);
    }

    private void calculate() {

        projectile = new Projectile(Double.parseDouble(angle.getText()), Double.parseDouble(velocity.getText()));

        for (int time = 0; time < 30; time++) {
            projectileCoordinates.append(projectile.toString() + "\n");

            System.out.println(projectile.toString());
            projectile.increaseTime(1);
        }
    }

    public static void main(String[] args) {
        new ProjectileFrame().setVisible(true);
    }
}
