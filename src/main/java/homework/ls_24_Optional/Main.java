package homework.ls_24_Optional;

import javax.print.DocFlavor;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optional = getNull();

        if (optional.isPresent()) {
            String s = optional.get();
            System.out.println(s);
        }
    }

    public static Optional<String> getNull() {
        if (false) {
            /*DO SMTH*/
        }

        return Optional.empty();
    }

}
