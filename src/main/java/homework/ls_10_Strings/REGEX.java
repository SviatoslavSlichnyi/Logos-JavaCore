package homework.ls_10_Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REGEX {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^([\\w\\.]*)");
        Matcher matcher = pattern.matcher("tommy.jack.soierce@gmail.com");

        while (matcher.find()) {
            System.out.println(matcher.start() + " " + matcher.group());
        }

        //1?[\s-]?\(?(\d{3})\)?[\s-]?\d{3}[\s-]?\d{4}
        Pattern pat = Pattern.compile("1?[\\s-]?\\(?(\\d{3})\\)?[\\s-]?\\d{3}[\\s-]?\\d{4}");
        Matcher mat = pattern.matcher("(416)555-3456");

        while (mat.find()) {
            System.out.println(mat.start() + " " + mat.group());
        }

        System.out.println("tommy@gmail.com".matches("^(\\w+\\.?)+@\\w+(\\.\\w+)+$"));
    }
}
