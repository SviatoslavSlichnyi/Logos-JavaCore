package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.controllers.Menu;
import homework.ls_13_VerhovnaRada.models.Faction;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

public class AddFactionCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public AddFactionCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        System.out.println("\t\tAdding Faction");

        String name = Menu.readFactionName();
        verhovnaRada.addFaction(name, new Faction());
    }
}
