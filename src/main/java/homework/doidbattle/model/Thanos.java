package homework.doidbattle.model;

public class Thanos extends Droid {

    private static int number = 1;
    private int health = 1_000;
    private int damage = 500;

    public Thanos() {
        setName("Thanos #" + number);
        number++;
        setHealth(health);
        setMaxDamage(damage);
    }
    public Thanos(String name) {
        setName(name);
        setHealth(health);
        setMaxDamage(damage);
    }

}
