package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.controllers.Menu;
import homework.ls_13_VerhovnaRada.models.Deputy;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

public class AddDeputyToFactionCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public AddDeputyToFactionCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        System.out.println("\t\tAdding Deputy");

        String nameOfFaction = Menu.selectFaction(verhovnaRada.getAllFactions().keySet());
        Deputy deputy = Menu.readDeputy();
        verhovnaRada.addDeputyToFaction(nameOfFaction, deputy);
    }
}
