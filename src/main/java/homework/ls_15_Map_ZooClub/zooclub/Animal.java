package homework.ls_15_Map_ZooClub.zooclub;

public class Animal {

    private String name;
    private Breed breed;

    public Animal(String name, Breed breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public Breed getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("name='").append(name).append('\'');
        sb.append(", breed=").append(breed);
        sb.append('}');
        return sb.toString();
    }

}
