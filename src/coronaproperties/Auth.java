package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class Auth {
    Auth(String emailString, String passString) {
        if (authenticate(emailString, passString)) {
            closeLoginScreen();
            openMenu();
        } else {
            Login loginScreen = new Login();

            loginScreen.setTitle("Login");
            loginScreen.setOpacity((float) 0.9);
            loginScreen.setBackground(new Color(0, 0, 0, 0));
            loginScreen.setIconImage(Toolkit.getDefaultToolkit()
                    .getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
            loginScreen.setLocationRelativeTo(null);
            loginScreen.setVisible(true);

            JOptionPane.showMessageDialog(null, "Email or Password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean authenticate(String emailString, String passString) {
        boolean correct = false;
        ResultSet rs = null;

        String sql = "SELECT email, password FROM user "
                + "WHERE email = ? AND password = ?";

        //Connecting using MySQLJDBCUtil
        //using resources
        ///so that connection to db closes automatically
        try (Connection conn = MySQLJDBCUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emailString);
            pstmt.setString(2, passString);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                // Authenticating
                correct = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return correct;
    }

    private static void closeLoginScreen() {
        // Close Login screen
        Login loginScreen = new Login();
        loginScreen.setVisible(false);
        loginScreen.dispose();
        System.gc();
    }

    private static void openMenu() {
        // Open menu
        MainMenu menu = new MainMenu();

        menu.setTitle("Corona Properties Main Menu");
        menu.setOpacity((float) 0.9);
        menu.setBackground(new Color(0, 0, 0, 0));
        menu.setIconImage(Toolkit.getDefaultToolkit()
                .getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}
