package lessons.ls8.enumdemo;

public enum Sex {
    FEMALE("male"),
    MALE("female");

    private String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
