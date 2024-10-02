package online.mizak.mcms.util;

import java.util.regex.Pattern;

abstract public class EmailValidator {

    private final String pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public static boolean validate(String emailAddress) {
        return Pattern.compile(emailAddress).matcher(emailAddress).matches();
    }

}
