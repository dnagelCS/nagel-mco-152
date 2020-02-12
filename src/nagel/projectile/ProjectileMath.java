package nagel.projectile;

import java.util.ArrayList;
import java.util.Random;

public class ProjectileMath {

    public static final int NUM_PROJECTILES = 5;

    public static void main(String[] args) {
        //create instance of Random class
        Random rand = new Random();

        ArrayList<Projectile> list = new ArrayList<>();
        for (int i = 0; i < NUM_PROJECTILES; i++) {
            list.add(new Projectile(rand.nextDouble() * 180, rand.nextDouble() * 100));
        }

        for (Projectile projectile : list) {    //'for each' loop allows to go through all projectiles and add list to each
            for (double j = 0; j < 5; j++) {
                System.out.println(projectile.toString());
                projectile.increaseTime(1);     //increase time by 1 for each projectile
            }
        }
    }
}
