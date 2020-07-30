package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Valid {
    Valid(String emailString, String passString) {

        //If Valid passes
        //We Authenticate the user
        if (isEmail(emailString) && validatePassword(passString)) {
            Auth auth = new Auth(emailString, passString);
        } else {
            Login loginScreen = new Login();

            loginScreen.setTitle("Login");
            loginScreen.setOpacity((float) 0.9);
            loginScreen.setBackground(new Color(0, 0, 0, 0));
            loginScreen.setIconImage(Toolkit.getDefaultToolkit().
                    getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
            loginScreen.setLocationRelativeTo(null);
            loginScreen.setVisible(true);

            JOptionPane.showMessageDialog(null, "Email or Password does NOT meet minimum requirements!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    public boolean isWord(String text) {
//        return Pattern.matches("[a-zA-Z]+", text);
//    }
//
//    public boolean isPassword(String password) {
//        if (password.length() > 7) {
//            if (validatePassword(password)) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//
//            return false;
//        }
//    }
    private static boolean validatePassword(String password) {
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

    private static boolean isEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }

}
