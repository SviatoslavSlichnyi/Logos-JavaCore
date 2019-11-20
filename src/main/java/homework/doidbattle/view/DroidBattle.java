package homework.doidbattle.view;

import homework.doidbattle.controller.BattleArena;
import homework.doidbattle.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DroidBattle {

    Scanner in = new Scanner(System.in);
    private List<Droid> player;
    private List<Droid> bot;

    public DroidBattle() {
        this.player = new ArrayList<>();
        this.bot = new ArrayList<>();
    }

    public void startGame() {
        do {
            System.out.println("\tMenu:");
            System.out.println("1. Create Droids.");
            System.out.println("2. List of created Droids.");
            System.out.println("3. Play.");
            System.out.println("4. Exit.");

            System.out.print("Choice: ");
            int ch = in.nextInt();
            //clear buffer
            if(in.hasNextLine())
                in.nextLine();

            switch (ch) {
                case 1:
                    createDroids();
                    break;
                case 2:
                    printListOfDroids();
                    break;
                case 3:
                    new BattleArena(player, bot).fight();
                    break;
                case 4:
                    return;

                default:
                    startGame();
            }
        } while(true);

    }

    private void createDroids() {
        System.out.println();
        System.out.println("List of type of droids:");
        System.out.println("1. Thanos");
        System.out.println("2. Thor");
        System.out.println("3. Halk");
        System.out.println("4. Creep");
        System.out.println();

        while(player.size() == 0) {
            System.out.println("\nChoose droids(separate it by space) for player #1: ");

            String droids = in.nextLine();
            Scanner line = new Scanner(droids);

            while(line.hasNextInt()) {
                int ch = line.nextInt();
                if(ch == 1)
                    player.add(new Thanos());
                else if(ch == 2)
                    player.add(new Thor());
                else if(ch == 3)
                    player.add(new Halk());
                else
                    player.add(new Creep());
            }

            line.close();
        }

        while(bot.size() == 0) {
            System.out.println("\nChoose droids(separate it by space) for player #2: ");

            String droids = in.nextLine();
            Scanner line = new Scanner(droids);

            while(line.hasNextInt()) {
                int ch = line.nextInt();
                if(ch == 1)
                    bot.add(new Thanos());
                else if(ch == 2)
                    bot.add(new Thor());
                else if(ch == 3)
                    bot.add(new Halk());
                else
                    bot.add(new Creep());
            }

            line.close();
        }
    }
    private void printListOfDroids() {
        System.out.println("\tPlayer #1:");
        for(Droid droid: player)
            System.out.println(droid);

        System.out.println("\n\tPlayer #2:");
        for(Droid droid: bot)
            System.out.println(droid);

        System.out.println();
    }

}
