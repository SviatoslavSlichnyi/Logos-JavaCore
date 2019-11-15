package homework.ls_07_SOLID;

import homework.ls_07_SOLID.fetures.ExpandedPossibilities;

public class Su27 extends Plane implements ExpandedPossibilities {

    public Su27(int length, int width, int weight, int maxSpeed) {
        super(length, width, weight, maxSpeed);
    }

    @Override
    public void nuclearAttack() {

        int numberOfWarheads = randomNumber(1, 10);

        System.out.println("Nuclear attack");
        System.out.println(numberOfWarheads + " was released.");

        System.out.println();
    }

    @Override
    public void stealth() {

        int time = randomNumber(20, 40);

        System.out.println("Stealth technology was activated.");
        System.out.println("The plane are not visible for " + time + " min");

        System.out.println();
    }

    @Override
    public void turbo() {

        int turbo = randomNumber(1, 100);

        System.out.println("Turbo was activated.");
        System.out.println("MAX Speed: " + getMaxSpeed() + "km/h");
        System.out.println("Speed: " + (getMaxSpeed()+turbo) + "km/h");

        System.out.println();
    }

}
