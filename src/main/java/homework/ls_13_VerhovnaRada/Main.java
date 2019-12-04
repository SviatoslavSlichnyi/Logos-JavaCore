package homework.ls_13_VerhovnaRada;

import homework.ls_13_VerhovnaRada.commands.*;
import homework.ls_13_VerhovnaRada.controllers.Menu;
import homework.ls_13_VerhovnaRada.models.Grafter;
import homework.ls_13_VerhovnaRada.models.VerhovnaRada;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static void init(Map<String, Command> commands, VerhovnaRada verhovnaRada) {
        commands.put("add-faction", new AddFactionCommand(verhovnaRada));
        commands.put("remove-faction", new RemoveFactionCommand(verhovnaRada));
        commands.put("print-factions", new PrintAllFactionsCommand(verhovnaRada));
        commands.put("clear-faction", new ClearFactionCommand(verhovnaRada));
        commands.put("print-faction", new PrintFactionCommand(verhovnaRada));

        commands.put("add-deputy", new AddDeputyToFactionCommand(verhovnaRada));
        commands.put("remove-deputy", new RemoveDeputyFromFactionCommand(verhovnaRada));
        commands.put("print-grafters", new PrintListOfGraftersCommand(verhovnaRada));
        commands.put("print-the-biggest-grafter", new PrintBiggestGrafterCommand(verhovnaRada));

        commands.put("exit", new ExitCommand());
    }

    public static void main(String[] args) {

        VerhovnaRada verhovnaRada = VerhovnaRada.getInstance();
        Map<String, Command> commands = new LinkedHashMap<>();
        init(commands, verhovnaRada);

        while(true) {
            Menu.printMainMenu(commands);
            String action = Menu.readCommand(commands);

            Command command = commands.get(action);
            command.execute();
        }

    }

}
