package homework.doidbattle.model;

public class Creep extends Droid {

    private int health = 100;
    private int damage = 40;

    public Creep() {
        setName("creep");
        setHealth(health);
        setMaxDamage(damage);
    }
    public Creep(String name) {
        setName(name);
        setHealth(health);
        setMaxDamage(damage);
    }
}
