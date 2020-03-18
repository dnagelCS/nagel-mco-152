package nagel.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int centerX = width/2;
        int centerY = height/2;

        int xpoints[] = {centerX, centerX+50, centerX, centerX-50, centerX};
        int ypoints[] = {centerY};

        g.drawLine(50,50,250,50);
        g.drawLine(250,50,100,100);
        g.drawLine(100,100,50,50);
    }
}
