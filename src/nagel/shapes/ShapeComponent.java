package nagel.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {
    private int rotation = 0;
    private String shape = "";

    public ShapeComponent() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        g.translate(centerX, centerY);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.rotate(Math.toRadians(rotation));
        //rotation++;

        drawShape(g);

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
        g.fillOval(-30, -60, 35, 35);      //N
        g.fillOval(-5, -40, 35, 35);      //Upper Right
        g.fillOval(-15, -10, 35, 35);      //Lower Right
        g.fillOval(-47, -10, 35, 35);      //Lower Left
        g.fillOval(-55, -40, 35, 35);      //Upper Left

        g.setColor(Color.yellow);
        g.fillOval(-28, -30, 32, 32);
    }

    private void drawBat(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(-17,-45,26,27);      //head
        g.fillOval(-20,-30,30,45);      //body
        g.fillPolygon(new int[] {-10,20,60},new int[] {0,-30,0},3);     //right wing
        g.fillPolygon(new int[] {-70,-30,0}, new int[] {0,-30,0},3);    //left wing
        g.fillPolygon(new int[] {2,12,7}, new int[] {-40,-45,-30},3);    //right ear
        g.fillPolygon(new int[] {-15,-20,-10}, new int[] {-30,-45,-40},3);    //left ear
        //g.drawArc(-120,-10,85,95,0,80);
        //g.drawArc(-110, 15, 120, 60, 0, 90);
        //int[] x = {-120, -110, -100, -90, -70, -50, -20, 0, 0};
        //int[] y = {0, -5, -10, -20, -18, -30, -40, -50, 0};
        //g.drawPolygon(x, y, 9); //37
    }

    private void drawTB(Graphics g) {
        g.setColor(Color.black);
        int[] x1 = {-31, 19, 73, 43, 31, 12};
        int[] y1 = {-81, -18, -82, -63, -76, -71};
        g.fillPolygon(x1, y1, 6);
        g.setColor(Color.white);
        int[] x2 = {-30, 20, 70, 40, 30, 10};
        int[] y2 = {-80, -20, -80, -60, -75, -70};
        g.fillPolygon(x2, y2, 6);
        g.setColor(Color.black);
        g.drawRect(-80, -25, 200, 100);
        g.setColor(Color.cyan);
        g.fillRect(-79, -24, 199, 99);
    }

    private void drawCorona(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillOval(-40, -40, 90, 90);
        g.setColor(Color.red);
        g.fillOval(-10, -30, 10, 10);
        g.fillOval(-30, 10, 10, 10);
        g.fillOval(0, 0, 10, 10);
        g.fillOval(-20, -10, 10, 10);
        g.fillOval(-5, 25, 10, 10);
        g.fillOval(20, 20, 10, 10);
        g.fillOval(10, -25, 10, 10);
        g.fillOval(30, -5, 10, 10);
        g.fillOval(45, -10, 10, 10);        //edge circle
        g.fillOval(-38, -30, 10, 10);       //edge circle
        g.fillOval(20, 45, 10, 10);         //edge circle
        g.fillOval(45,20,10,10);            //edge circle
        g.fillOval(0, -48, 10, 10);         //edge circle
        g.fillOval(-50, 0, 10, 10);         //edge circle
        g.fillOval(-38, 30, 10, 10);        //edge circle
        g.fillOval(-10, 48, 10, 10);        //edge circle
        g.fillOval(30, -35,10,10);          //edge circle
    }

     /*   private void drawStar(Graphics g) {
         /*   int[] xpoints = {centerX, centerX + 50, centerX, centerX - 50, centerX};
            int[] ypoints = {centerY};

            g.drawLine(50, 50, 250, 50);
            g.drawLine(250, 50, 100, 100);
            g.drawLine(100, 100, 50, 50);       */ /*

            g.drawLine(-50, -50, +50, -50);
            g.drawLine(+50, -50, 0, +50);
            g.drawLine(0, +50, -50, -50);

            g.drawLine(-50, +25, +50, +25);
            g.drawLine(+50, +25, 0, -75);
            g.drawLine(0, -75, -50, +25);
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

    public void drawShape(Graphics g) {
        if (shape == null) {
            return;
        } else if (shape.equals("Flower")) {
            drawFlower(g);
        } else if (shape.equals("Bat")) {
            drawBat(g);
        } else if (shape.equals("Tissue Box")) {
            drawTB(g);
        } else if (shape.equals("COVID19")) {
            drawCorona(g);
        }

    }
}
