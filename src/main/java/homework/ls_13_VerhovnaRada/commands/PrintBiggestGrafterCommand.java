package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.models.Deputy;
import homework.ls_13_VerhovnaRada.models.Faction;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

import java.util.Map;

public class PrintBiggestGrafterCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public PrintBiggestGrafterCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        System.out.println("\t\tBiggest Grafter");

        Map.Entry<String, Faction> biggestGrafter = null;
        int maxBride = -1;

        for (Map.Entry<String, Faction> grafter: verhovnaRada.getAllFactions().entrySet()) {
            Deputy g = grafter.getValue().getBiggestGrafter();
            if (biggestGrafter == null) {
                biggestGrafter = grafter;
            }
            else if (maxBride < g.bribe()) {
                biggestGrafter = grafter;
            }
        }

        if (biggestGrafter == null) {
            System.out.println("The biggest grafter was NOT found.");
            return;
        }

        System.out.println("\tThe biggest grafter in verhovna rada");
        System.out.println("Faction: " + biggestGrafter.getKey());
        System.out.println("Deputy: " + biggestGrafter.getValue());

    }
}
