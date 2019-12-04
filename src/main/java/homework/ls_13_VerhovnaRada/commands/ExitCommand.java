package homework.ls_13_VerhovnaRada.commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("The program was finished.");

        System.exit(0);
    }
}
