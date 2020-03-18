package nagel.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame {

    private ShapeComponent shapeComponent;

    public ShapesFrame() {
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SHAPES");

        setLayout(new BorderLayout());

        shapeComponent = new ShapeComponent();
        add(shapeComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new ShapesFrame().setVisible(true);
    }
}
