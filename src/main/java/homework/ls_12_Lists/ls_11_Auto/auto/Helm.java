package homework.ls_12_Lists.ls_11_Auto.auto;

public class Helm {

    private int diameter;
    private Material material;

    public Helm(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Helm{");
        sb.append("diameter=").append(diameter);
        sb.append(", material=").append(material);
        sb.append('}');
        return sb.toString();
    }
}
