package nagel.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame {

    private ShapeComponent shapeComponent;
    private JPanel buttonPanel;
    private JButton flowerButton;
    private JButton batButton;
    private JButton tbButton;
    private JButton coronaButton;

    public ShapesFrame() {
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SPRING 2020");

        setLayout(new BorderLayout());
        shapeComponent = new ShapeComponent();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));

        flowerButton = new JButton("Flower");
        flowerButton.addActionListener(actionEvent -> shapeComponent.setShapeFlower());
        batButton = new JButton("Bat");
        batButton.addActionListener(actionEvent -> shapeComponent.setShapeBat());
        tbButton = new JButton("Tissue Box");
        tbButton.addActionListener(actionEvent -> shapeComponent.setShapeTB());
        coronaButton = new JButton("COVID19");
        coronaButton.addActionListener(actionEvent -> shapeComponent.setShapeCorona());

        add(shapeComponent, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.WEST);

        buttonPanel.add(flowerButton);
        buttonPanel.add(batButton);
        buttonPanel.add(tbButton);
        buttonPanel.add(coronaButton);
    }

    public static void main(String[] args) {
        new ShapesFrame().setVisible(true);
    }
}
