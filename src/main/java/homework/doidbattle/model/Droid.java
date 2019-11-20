package homework.doidbattle.model;

import java.util.Random;

public abstract class Droid {

  private String name;
  private Integer health;
  private Integer maxDamage;
  private static Random random = new Random();

  public Droid() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getHealth() {
    return health;
  }

  public void setHealth(Integer health) {
    this.health = health;
  }

  public Integer getDamage() {
    return random.nextInt(maxDamage + 1);
  }

  public void setMaxDamage(Integer maxDamage) {
    this.maxDamage = maxDamage;
  }

  public void getHit(Integer damage) {
    health -= damage;
  }

  public boolean isAlive() {
    return health > 0;
  }

  @Override
  public String toString() {
    return "Droid{" +
        "name='" + name + '\'' +
        ", health=" + health +
        ", damage=" + maxDamage +
        '}';
  }
}
