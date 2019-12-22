package lessons.ls_18_Generics;

public class Main {
    public static void main(String[] args) {

        Creature creature = new Creature();
        Human human = new Human();
        Person person = new Person();
        Jobs jobs = new Jobs();

        Cell<Creature> creatureCell = new Cell<>();
        Cell<Human> humanCell = new Cell<>();
        Cell<Person> personCell = new Cell<>();
        Cell<Jobs> jobsCell = new Cell<>();


        /*
            extends for getting (reading)
         */
//        Cell<? extends Human> creatureExCell = creatureCell; - Error
        Cell<? extends Human> humanExCell = humanCell;
        Cell<? extends Human> personExCell = personCell;
        Cell<? extends Human> jobsExCell = jobsCell;

        Human value = humanExCell.getValue();


        /*
          super - for setting (writing)
         */
        Cell<? super Human> creatureSuperCells = creatureCell;
        Cell<? super Human> humanSuperCells = humanCell;
        Cell<? super Human> personSuperCells = creatureCell;
        Cell<? super Human> jobsSuperCells = creatureCell;

//        creatureSuperCells.setValue(creature); - Error
        creatureSuperCells.setValue(human);
        creatureSuperCells.setValue(person);
        creatureSuperCells.setValue(jobs);

    }
}

class Cell<T> {

    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "value=" + value +
                '}';
    }
}

class Creature {}
class Human extends Creature {}
class Person extends Human {}
class Jobs extends Person {}