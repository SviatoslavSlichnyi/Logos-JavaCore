package homework.ls_13_VerhovnaRada.models;

import java.util.LinkedList;
import java.util.List;

public class Faction {

    private List<Deputy> deputies;

    public Faction() {
        deputies = new LinkedList<>();
    }

    public boolean addDeputy(Deputy deputy) {
        return deputies.add(deputy);
    }

    public void removeDeputy(int id) {
        deputies.remove(id);
    }

    public List<Deputy> getAllDeputies() {
        return deputies;
    }

    public List<Deputy> getAllGrafters() {
        List<Deputy> grafters = new LinkedList<>();

        for (Deputy deputy: deputies) {
            if (deputy.getGrafter().equals(Grafter.YES)) {
                grafters.add(deputy);
            }
        }

        return grafters;
    }

    public Deputy getBiggestGrafter() {
        Deputy biggestShit = null;

        for (Deputy deputy: deputies) {
            if (deputy.getGrafter().equals(Grafter.YES)) {
                if (biggestShit == null) {
                    biggestShit = deputy;
                }
                else if (biggestShit.bribe() > deputy.bribe()) {
                    biggestShit = deputy;
                }
            }
        }

        return biggestShit;
    }

    public void clear() {
        deputies.clear();
    }

    @Override
    public String toString() {
        if (deputies.size() == 0) {
            System.out.println("There are nobody was added to this faction.");
        }

        final StringBuilder sb = new StringBuilder();
        for (Deputy deputy: deputies) {
            sb.append("\t").append(deputy).append('\n');
        }
        return sb.toString();
    }
}
