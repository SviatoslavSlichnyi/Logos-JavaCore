package homework.doidbattle.controller;

import homework.doidbattle.model.Droid;

import java.util.List;
import java.util.Scanner;

public class BattleArena {

    private List<Droid> player1;
    private List<Droid> player2;
    private int currentRound = 0;
    private byte currentPlayer;

    public BattleArena(List<Droid> player1, List<Droid> player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = 1;
    }

    public void fight() {
        do {
            swapOpponents();
            nextRound();
        } while (player2.size() != 0);

        printWinnerInfo();
    }

    private void nextRound() {
        currentRound++;
        System.out.println();

        if(currentRound%2 == 1)
            System.out.println("Player #1 turn");
        else
            System.out.println("Player #2 turn");

        Scanner in = new Scanner(System.in);
        int attN;
        do {
            System.out.print("Choose droids for attack: ");
            attN = in.nextInt();
        } while (!(player1.size() <= attN && attN <= player1.size()) );
        attN--;
        Droid att = player1.get(attN);
        Integer damage = att.getDamage();

        int defN;
        do {
            System.out.print("Choose the enemy droid to atteck: ");
            defN = in.nextInt();
        }while( !(player2.size() <= defN && defN <= player2.size()) );
        defN--;
        Droid def = player2.get(defN);
        def.getHit(damage);
        if(!def.isAlive())
            player2.remove(def);

        printRoundInfo(att, def, damage);
    }

    private void swapOpponents() {
        List<Droid> newDefender = player1;
        List<Droid> newAttacker = player2;
        player2 = newDefender;
        player1 = newAttacker;
    }

    private void printRoundInfo(Droid att, Droid def, Integer damage) {
        printSeparator();
        System.out.println("Round " + currentRound);

        System.out.println(att.getName() + " was hit by " + def.getName()
                + " with damage " + damage);

        printListOfDroids();
    }

    private void printListOfDroids() {
        System.out.println("\tPlayer #1:");
        for(Droid droid: player1)
            System.out.println(droid);

        System.out.println("\n\tPlayer #2:");
        for(Droid droid: player2)
            System.out.println(droid);

    }

    private void printWinnerInfo() {
        printSeparator();
        System.out.print("The winner is ");
        if(player1.size() == 0) {
            System.out.println("player #1");
        } else {
            System.out.println("player #2");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("--------------------------------------------");
    }
}
