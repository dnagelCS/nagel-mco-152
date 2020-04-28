package nagel.projectile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectileTest {

    @Test
    public void getX() {
        //given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);

        //when
        double x = projectile.getX();

        //then
        assertEquals(245.2557, x, 0.0001);
    }

    @Test
    public void getY() {
        //given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);

        //when
        double y = projectile.getY();

        //then
        assertEquals(83.5569, y, 0.0001);
    }

    @Test
    public void getTime() {
        //given a certain projectile
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(0);

        //when
        double currTime = projectile.getTime();

        //then get time at start time 0
        assertEquals(0, currTime, 0.0001);

        //get time after time was increased by 5
        projectile.increaseTime(5);
        //update currTime
        currTime = projectile.getTime();
        assertEquals(5, currTime, 0.0001);
    }

}