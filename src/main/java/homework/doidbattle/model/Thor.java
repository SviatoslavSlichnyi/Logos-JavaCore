package homework.doidbattle.model;

public class Thor extends Droid {
    private static int number = 1;
    private int health = 500;
    private int damage = 50;

    public Thor() {
        setName("Thor #" + number);
        number++;
        setHealth(health);
        setMaxDamage(damage);
    }
    public Thor(String name) {
        setName(name);
        setHealth(health);
        setMaxDamage(damage);
    }

}
