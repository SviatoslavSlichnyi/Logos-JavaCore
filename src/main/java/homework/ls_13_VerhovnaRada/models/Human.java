package homework.ls_13_VerhovnaRada.models;

import homework.ls_13_VerhovnaRada.models.gentlemansets.GentlemanSet;

import java.util.List;

public class Human {

    private int weight;
    private int height;
    private List<GentlemanSet> gentlemanSets;

    public Human(int weight, int height, List<GentlemanSet> gentlemanSets) {
        this.weight = weight;
        this.height = height;
        this.gentlemanSets = gentlemanSets;
    }

    public int editWeight() {
        return weight;
    }

    public void editWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<GentlemanSet> getGentlemanSets() {
        return gentlemanSets;
    }

    public void addGentlemanSet(GentlemanSet gs) {
        gentlemanSets.add(gs);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Human{");
        sb.append("weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", gentlemanSets=").append(gentlemanSets);
        sb.append('}');
        return sb.toString();
    }
}
