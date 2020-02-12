package nagel.projectile;

import java.text.DecimalFormat;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Projectile {

    private final double ANGLE;
    private final double VELOCITY;
    private final double EARTH_GRAVITY = -9.8;
    private double time;

        //given Projectile with angle and velocity
    public Projectile(double angleInDegrees, double VELOCITY) {
        this.ANGLE = Math.toRadians(angleInDegrees);
        this.VELOCITY = VELOCITY;
    }

    public void increaseTime(double delta) {
        this.time += delta;
    }

    public double getX() {
        return VELOCITY * cos(ANGLE) * time;
    }

    public double getY() {
        return VELOCITY * sin(ANGLE) * time + (EARTH_GRAVITY * time * time);
    }

    @Override
    public String toString() {
        return "Time: " + time + " (" + String.format("%.4f", this.getX()) + ", " + String.format("%.4f", this.getY()) +")";
    }
}
