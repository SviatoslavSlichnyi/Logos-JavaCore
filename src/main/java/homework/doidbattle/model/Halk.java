package homework.doidbattle.model;

public class Halk extends Droid {

    private static int number = 1;
    private int health = 1_000;
    private int damage = 500;

    public Halk() {
        setName("Halk #" + number);
        number++;
        setHealth(health);
        setMaxDamage(damage);
    }
    public Halk(String name) {
        setName(name);
        setHealth(health);
        setMaxDamage(damage);
    }
}
