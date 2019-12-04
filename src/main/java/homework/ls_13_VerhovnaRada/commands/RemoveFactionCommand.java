package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.controllers.Menu;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

public class RemoveFactionCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public RemoveFactionCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        System.out.println("\t\tRemove Faction");

        String nameOfFaction = Menu.readFactionName();
        verhovnaRada.removeFaction(nameOfFaction);
    }
}
