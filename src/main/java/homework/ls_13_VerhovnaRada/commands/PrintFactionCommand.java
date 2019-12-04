package homework.ls_13_VerhovnaRada.commands;

import homework.ls_13_VerhovnaRada.controllers.Menu;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

public class PrintFactionCommand implements Command {

    private VerhovnaRada verhovnaRada;

    public PrintFactionCommand(VerhovnaRada verhovnaRada) {
        this.verhovnaRada = verhovnaRada;
    }

    @Override
    public void execute() {
        String name = Menu.readFactionName();

        System.out.println(verhovnaRada.getFaction(name));
    }
}
