package homework.ls_13_VerhovnaRada.models;

import homework.ls_13_VerhovnaRada.models.gentlemansets.GentlemanSet;

import java.util.List;

public class Deputy extends Human {

    private String name;
    private String surname;
    private int age;
    private Grafter grafter;
    private int bribe;

    public Deputy(int weight, int height, List<GentlemanSet> gentlemanSets, String name, String surname, int age, Grafter grafter) {
        super(weight, height, gentlemanSets);
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.grafter = grafter;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Grafter getGrafter() {
        return grafter;
    }

    public int bribe() {
        if (grafter.equals(Grafter.NO)) {
            return 0;
        }
        else {
            return bribe;
        }
    }

    public void setBribe(int bribe) {
        this.bribe = bribe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Deputy{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", grafter=").append(grafter);
        sb.append(", bribe=").append(bribe);
        sb.append('}');
        return sb.toString();
    }

}
