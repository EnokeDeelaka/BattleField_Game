package weapon;

import java.util.Scanner;

public interface Weapon {
    Scanner s = new Scanner(System.in);
    int shoot();
    int getScore();
}
