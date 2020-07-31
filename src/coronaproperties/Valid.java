package coronaproperties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid {
    static boolean isEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }

    static boolean isPass(String password) {
        if (password.length() > 6) {
            if (validatePass(password)) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }
    }

    private static boolean validatePass(String password) {
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        char c;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasNum = true;
            } else if (Character.isUpperCase(c)) {
                hasCap = true;
            } else if (Character.isLowerCase(c)) {
                hasLow = true;
            }
            for (char currentChar : password.toCharArray()) {
                if (Character.isWhitespace(currentChar)) {
                    return true;
                }
            }
            if (hasNum && hasCap && hasLow) {
                return true;
            }
        }
        return false;
    }

    static boolean isWord(String text) {
        return Pattern.matches("[a-zA-Z]+", text);
    }

}
