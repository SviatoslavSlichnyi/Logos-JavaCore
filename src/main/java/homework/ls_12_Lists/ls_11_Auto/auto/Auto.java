package homework.ls_12_Lists.ls_11_Auto.auto;

import java.util.Comparator;

public class Auto implements Comparable<Auto> {

    private int power;
    private int dayOfFirstRegistration;
    private Engine engine;
    private Helm helm;
    private Material material;

    public Auto(int power, int dayOfFirstRegistration, Engine engine, Helm helm, Material material) {
        this.power = power;
        this.dayOfFirstRegistration = dayOfFirstRegistration;
        this.engine = engine;
        this.helm = helm;
        this.material = material;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDayOfFirstRegistration() {
        return dayOfFirstRegistration;
    }

    public void setDayOfFirstRegistration(int dayOfFirstRegistration) {
        this.dayOfFirstRegistration = dayOfFirstRegistration;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Helm getHelm() {
        return helm;
    }

    public void setHelm(Helm helm) {
        this.helm = helm;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auto{");
        sb.append("power=").append(power);
        sb.append(", dayOfFirstRegistration=").append(dayOfFirstRegistration);
        sb.append(", engine=").append(engine);
        sb.append(", helm=").append(helm);
        sb.append(", material=").append(material);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Auto auto) {
        return this.getPower() - auto.getPower();
    }

    public static Comparator<Auto> comparatorAscending = new Comparator<Auto>() {
        @Override
        public int compare(Auto auto1, Auto auto2) {
            return auto1.getPower() - auto2.getPower();
        }
    };

    public static Comparator<Auto> comparatorDescending = new Comparator<Auto>() {
        @Override
        public int compare(Auto auto1, Auto auto2) {
            return auto2.getPower() - auto1.getPower();
        }
    };

}
