package homework.ls_09_Exceptions.task1_Enums;

public class WrongInputConsoleParametersException extends RuntimeException {

    public WrongInputConsoleParametersException() { }

    public WrongInputConsoleParametersException(String msg) {
        super(msg);
    }

}
