package homework.ls_12_Lists.ls_11_Auto.auto;

public class Engine {

    private int amountOfCylinder;

    public Engine(int amountOfCylinder) {
        this.amountOfCylinder = amountOfCylinder;
    }

    public int getAmountOfCylinder() {
        return amountOfCylinder;
    }

    public void setAmountOfCylinder(int amountOfCylinder) {
        this.amountOfCylinder = amountOfCylinder;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Engine{");
        sb.append("amountOfCylinder=").append(amountOfCylinder);
        sb.append('}');
        return sb.toString();
    }
}
