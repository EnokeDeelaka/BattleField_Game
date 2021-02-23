package weapon;

import java.util.Random;

public class Bomb implements Weapon {
    int x;
    @Override
    public int shoot() {
        Random random = new Random();
        x = random.nextInt(10);
        return x;


    }

    @Override
    public int getScore() {
        return x;

    }
}
