package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.controllers.Menu;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

public class RemoveDeputyFromFactionCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public RemoveDeputyFromFactionCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        System.out.println("\t\tRemove Deputy");

        String nameOfFaction = Menu.readFactionName();
        int deputyId = Menu.readDeputyIdInFaction(verhovnaRada.getFaction(nameOfFaction));

        verhovnaRada.removeDeputyFromFaction(nameOfFaction, deputyId);
    }

}
