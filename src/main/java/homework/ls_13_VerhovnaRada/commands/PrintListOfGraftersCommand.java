package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.models.Deputy;
import homework.ls_13_VerhovnaRada.models.Faction;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

import java.util.Map;

public class PrintListOfGraftersCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public PrintListOfGraftersCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        System.out.println("\t\tList of Grafters");

        for (Map.Entry<String, Faction> grafter: verhovnaRada.getAllFactions().entrySet()) {
            Faction faction = grafter.getValue();

            if (faction.getAllGrafters().size() == 0) {
                continue;
            }

            System.out.println("__________________________________");
            System.out.println("Faction: " + grafter.getKey());
            printGrafterInFaction(faction);
        }
    }

    private void printGrafterInFaction(Faction faction) {
        for(Deputy g: faction.getAllGrafters()) {
            System.out.println("\t" + g);
        }
    }
}
