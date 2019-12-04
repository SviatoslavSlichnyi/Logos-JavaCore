package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.models.Faction;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

import java.util.Map;

public class PrintAllFactionsCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public PrintAllFactionsCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        System.out.println("\t\tPrint all factions");


        if (verhovnaRada.getAllFactions().size() == 0) {
            System.out.println("The factions list is empty!");
        }

        for (Map.Entry<String, Faction>  factionEntry: verhovnaRada.getAllFactions().entrySet()) {
            String nameOfFaction = factionEntry.getKey();
            Faction faction = factionEntry.getValue();

            System.out.println("_________________________________________");
            System.out.println("Faction: " + nameOfFaction);
            System.out.println(faction);
        }
    }
}
