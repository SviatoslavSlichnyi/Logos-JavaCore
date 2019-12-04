package homework.ls_15_Map_ZooClub.zooclub;

import java.util.*;

public class ZooClub {

    private Map<Person, List<Animal>> map;

    public ZooClub() {
        map = new HashMap<>();
    }

    public Set<Person> getPersons() {
        return map.keySet();
    }

    public List<Animal> getAnimalsFromPerson(Person person) {
        return map.get(person);
    }

    public void addPerson(Person person) {
        map.put(person, new LinkedList<>());
    }

    public void addAnimalToPerson(Animal animal, Person person) {
        map.get(person).add(animal);
    }

    public void removeAnimalFromPerson(Animal animal, Person person) {
        map.get(person).remove(animal);
    }

    public void removePerson(Person person) {
        map.remove(person);
    }

    public void removeAnimalFromAllPersons(Animal animal) {
        for (Map.Entry<Person, List<Animal>> entry: map.entrySet()) {
            entry.getValue().remove(animal);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ZooClub{");
        sb.append("map=").append(map);
        sb.append('}');
        return sb.toString();
    }
}
