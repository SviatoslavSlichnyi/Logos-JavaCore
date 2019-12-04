package homework.ls_15_Map_ZooClub;

import homework.ls_15_Map_ZooClub.zooclub.Animal;
import homework.ls_15_Map_ZooClub.zooclub.Breed;
import homework.ls_15_Map_ZooClub.zooclub.Person;
import homework.ls_15_Map_ZooClub.zooclub.ZooClub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ZooClub zooClub = new ZooClub();

        Person person;
        Animal animal;

        while (true) {
            printMenu();
            System.out.print("choice: ");
            int ch = in.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("\tAdd person");
                    person = readPerson();

                    zooClub.addPerson(person);
                    break;
                case 2:
                    System.out.println("\tAdd add Animal");
                    animal = readAnimal();
                    person = choosePerson(zooClub);

                    zooClub.addAnimalToPerson(animal, person);
                    break;
                case 3:
                    System.out.println("\tRemove animal from Person");
                    person = choosePerson(zooClub);
                    animal = chooseAnimal(zooClub, person);

                    zooClub.removeAnimalFromPerson(animal, person);
                    break;
                case 4:
                    System.out.println("\tRemove person from club");
                    person = choosePerson(zooClub);

                    zooClub.addPerson(person);
                    break;
                case 5:
                    System.out.println("\tZoo Club clients");

                    System.out.println(zooClub);
                    break;

                default:
                    System.out.println("The program were finished.");
                    System.exit(0);
            }
        }


    }

    private static void printMenu() {
        System.out.println();
        System.out.println("\t\tMenu");
        System.out.println("1. Add person");
        System.out.println("2. Add add Animal");
        System.out.println("3. Remove animal from Person");
        System.out.println("4. Remove person from club");
        System.out.println("5. Print Zoo Club clients");
        System.out.println("else - exit");

    }

    private static Person readPerson() {
        System.out.print("person name: ");
        String name = in.next();

        System.out.print("person age: ");
        int age = in.nextInt();

        return new Person(name, age);
    }

    private static Person choosePerson(ZooClub zooClub) {
        List<Person> persons = new ArrayList<>(zooClub.getPersons());

        System.out.println("\tList of persons");
        int i = 0;
        for (Person p : persons) {
            System.out.println((i++) + ". " + p.getName());
        }
        System.out.print("choice: ");
        int index = in.nextInt();

        return persons.get(index);
    }

    private static Animal readAnimal() {

        System.out.print("name: ");
        String name = in.next();

        System.out.println("\tList of breed");
        for (Breed b : Breed.values()) {
            System.out.println(b);
        }

        System.out.print("choice: ");
        Breed breed = Breed.valueOf(in.next().toUpperCase());

        return new Animal(name, breed);
    }

    private static Animal chooseAnimal(ZooClub zooClub, Person person) {
        List<Animal> animals = zooClub.getAnimalsFromPerson(person);

        System.out.println("\tList of animals from person \"" + person.getName() + "\"");
        int i = 0;
        for (Animal a : animals) {
            System.out.println((i++) + ". " + a.getName());
        }

        System.out.print("choice: ");
        int index = in.nextInt();

        return animals.get(index);
    }

}
