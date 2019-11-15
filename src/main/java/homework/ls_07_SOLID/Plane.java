package homework.ls_07_SOLID;

import java.util.Random;

public abstract class Plane {

    private int length;
    private int width;
    private int weight;
    private int maxSpeed;
    private Random rand = new Random();

    public Plane(int length, int width, int weight, int maxSpeed) {
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void goUp() {
        int pathLength = randomNumber(1, 100);
        System.out.println("go up - " + pathLength + " km");
        System.out.println();
    }

    public void goDown() {
        int pathLength = randomNumber(1, 100);
        System.out.println("go down - " + pathLength + " km");
        System.out.println();
    }

    public void goRight() {
        int pathLength = randomNumber(1, 100);
        System.out.println("go right - " + pathLength + " km");
        System.out.println();
    }

    public void goLeft() {
        int pathLength = randomNumber(1, 100);
        System.out.println("go left - " + pathLength + " km");
        System.out.println();
    }

    public void startEngine() {

        int time = randomNumber(20, 88);

        System.out.println("Engine was started.");
        System.out.print("Time to getting things done: " + time + " min");
        System.out.println();
    }

    public void takeOff() {

        int distance = randomNumber(0, 1000);

        System.out.println("The plane is taking off...");
        System.out.println("The fuel is enough for " + distance + " km.");

        System.out.println();
    }

    public void landing() {

        System.out.println("The plane go landing...");
        System.out.print("The plane dimensions: "
                + "length: " + length + ", "
                + "width: " + width + ", "
                + "weight: " + weight);

        System.out.println();
    }

    protected int randomNumber(int start, int end) {
        return ( start + (rand.nextInt(end - start + 1)) );
    }
}
