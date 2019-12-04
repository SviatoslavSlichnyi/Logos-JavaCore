package homework.ls_13_VerhovnaRada.controllers;

import homework.ls_13_VerhovnaRada.commands.Command;
import homework.ls_13_VerhovnaRada.models.Deputy;
import homework.ls_13_VerhovnaRada.models.Faction;
import homework.ls_13_VerhovnaRada.models.Grafter;
import homework.ls_13_VerhovnaRada.models.gentlemansets.GentlemanSet;

import java.util.*;

public class Menu {

    private static Scanner in = new Scanner(System.in);

    public static void printMainMenu(Map<String, Command> commands) {
        System.out.println();

        System.out.println("\tPossible commands:");
        for (String key: commands.keySet()) {
            System.out.println(key);
        }

        System.out.println();
    }

    public static String readCommand(Map<String, Command> commands) {
        String action;
        do {
            System.out.print("command: ");
            action = in.next();
            in.nextLine();//clear buffer
        } while(!commands.containsKey(action));

        return action;
    }

    public static String readFactionName() {
        System.out.println("\tAdding Faction");
        System.out.print("name: ");
        String name = in.next();
        return name;
    }

    public static Integer readDeputyIdInFaction(Faction faction) {
        printListOfDeputy(faction);

        System.out.print("select: ");
        int id = in.nextInt();
        --id;

        return id;
    }

    private static void printListOfDeputy(Faction faction) {
        int i = 1;
        for (Deputy d: faction.getAllDeputies()) {
            System.out.println(i++ + ". " + d);
        }
    }

    public static String selectFaction(Set<String> names) {
        printListOfFactions(names);

        String action;
        do {
            System.out.print("select: ");
            action = in.next();
            in.nextLine();//clear buffer
        } while(!names.contains(action));

        return action;
    }

    private static void printListOfFactions(Set<String> names) {
        System.out.println();
        System.out.println("List of Factions: ");
        for (String name: names) {
            System.out.println(name);
        }
    }

    public static Deputy readDeputy() {
        System.out.print("name: ");
        String name = in.next();

        System.out.print("surname: ");
        String surname = in.next();

        System.out.print("age: ");
        int age = in.nextInt();

        System.out.print("weight: ");
        int weight = in.nextInt();

        System.out.print("height: ");
        int height = in.nextInt();


        List<GentlemanSet> gentlemanSets = readGentlemanSet();


        System.out.print("Is grafter (\"yes\" or \"no\"): ");
        String choice = in.next().toUpperCase();
        Grafter grafter = Grafter.valueOf(choice);

        Deputy deputy = new Deputy(weight, height, gentlemanSets, name, surname, age, grafter);

        if (grafter.equals(Grafter.YES)) {
            System.out.print("bribe: ");
            int bribe = in.nextInt();
            deputy.setBribe(bribe);
        }



        return deputy;
    }

    private static List<GentlemanSet> readGentlemanSet() {

        printListOfGentlemanSets();
        List<GentlemanSet> gentlemanSet = new LinkedList<>();

        System.out.print("select: ");
        int selected = in.nextInt();

        GentlemanSet gs = GentlemanSet.values()[selected-1];
        gentlemanSet.add(gs);

        return gentlemanSet;
    }

    private static void printListOfGentlemanSets() {
        System.out.println("\tGentleman set");

        GentlemanSet[] gentlemanSets = GentlemanSet.values();
        for (int i = 0; i < gentlemanSets.length; i++) {
            System.out.println((i+1) + " " + gentlemanSets[i].toString().toLowerCase());
        }
    }

}
