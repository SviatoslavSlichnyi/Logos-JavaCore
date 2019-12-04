package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.controllers.Menu;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

public class ClearFactionCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public ClearFactionCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        System.out.println("Clear Faction");

        String nameOfFaction = Menu.readFactionName();
        verhovnaRada.getFaction(nameOfFaction).clear();
    }
}
