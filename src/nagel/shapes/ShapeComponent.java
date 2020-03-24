package nagel.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {

    private String shape = "";

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        g.translate(centerX, centerY);

        switch (shape) {
            case "Flower":
                drawFlower(g);
                break;
            case "Bat":
                drawBat(g);
                break;
            case "Tissue Box":
                drawTB(g);
                break;
            case "COVID19":
                drawCorona(g);
                break;
            default:
                ;
                break;
        }
    }

        private void drawFlower(Graphics g) {
            g.setColor(Color.GREEN);
            g.fillRect(-15, 5, 5, 85);

            g.setColor(Color.magenta);
            g.fillOval(-30,-60,35,35);      //N
            g.fillOval(-5,-40,35,35);      //Upper Right
            g.fillOval(-15,-10,35,35);      //Lower Right
            g.fillOval(-47,-10,35,35);      //Lower Left
            g.fillOval(-55,-40,35,35);      //Upper Left

            g.setColor(Color.yellow);
            g.fillOval(-28, -30, 32, 32);
        }

        private void drawBat(Graphics g) {
            g.setColor(Color.black);
            //g.drawArc(-120,-10,85,95,0,80);
            //g.drawArc(-110, 15, 120, 60, 0, 90);
            int[] x = {-120,-110,-100,-90,-70,-50,-20,0, 0};
            int[] y = {0,-5,-10,-20,-18,-30,-40, -50, 0};
            g.drawPolygon(x,y,9); //37
        }

        private void drawTB(Graphics g) {
            g.setColor(Color.black);
            int[] x1 = {-31, 19, 71, 41, 31, 12};
            int[] y1 = {-81, -19, -81, -61, -76, -71};
            g.fillPolygon(x1, y1, 6);
            g.setColor(Color.white);
            int[] x2 = {-30, 20, 70, 40, 30, 10};
            int[] y2 = {-80, -20, -80, -60, -75, -70};
            g.fillPolygon(x2,y2,6);
            g.setColor(Color.black);
            g.drawRect(-80,-25, 200, 100);
            g.setColor(Color.cyan);
            g.fillRect(-79,-24,199,99);
        }

        private void drawCorona(Graphics g) {
            g.setColor(Color.lightGray);
            g.fillOval(-40,-40,90,90);
            g.setColor(Color.red);
            g.fillOval(-10,-30,10,10);
            g.fillOval(-30,10,10,10);
            g.fillOval(0,0, 10,10);
            g. fillOval(-20,-10,10,10);
            g.fillOval(-5, 25, 10, 10);
            g.fillOval(20, 20, 10, 10);
            g.fillOval(10, -25, 10, 10);
            g.fillOval(30, -5, 10, 10);
            g.drawLine(-40,-40, -20, -20);
            g.drawLine(30,30,60,50);
            g.drawLine(0, -40, 0, -60);
            g.drawLine(-60, -10, -30, 0);
        }

     /*   private void drawStar(Graphics g) {
            int[] xpoints = {centerX, centerX + 50, centerX, centerX - 50, centerX};
            int[] ypoints = {centerY};

            g.drawLine(50, 50, 250, 50);
            g.drawLine(250, 50, 100, 100);
            g.drawLine(100, 100, 50, 50);
        }*/

        void setShapeFlower() {
            shape = "Flower";
            repaint();
        }

        void setShapeBat() {
            shape = "Bat";
            repaint();
        }

        void setShapeTB() {
            shape = "Tissue Box";
            repaint();
        }

        void setShapeCorona() {
            shape = "COVID19";
            repaint();
        }

        void setShapeStar() {
            shape = "Star";
            repaint();
        }
    }
