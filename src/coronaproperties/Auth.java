package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;

/**
 *
 * @author Melvin K
 */
public class Auth {
    static boolean login(String emailString, String passString) {
        boolean correct = false;
        ResultSet rs = null;

        String sql = "SELECT email, password FROM user "
                + "WHERE email = ? AND password = ?";

        //Connecting using ConnectUtil
        //using resources
        ///so that connection to db closes automatically
        try (Connection conn = ConnectUtil.getConnection();
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

    static boolean register(String emailString, String passString) {
        boolean correct = false;
        ResultSet rs = null;

        String sql = "INSERT INTO user email, password VALUES(?,?)";

        //Connecting using ConnectUtil
        //using resources
        ///so that connection to db closes automatically
        try (Connection conn = ConnectUtil.getConnection();
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

    static void closeLoginScreen() {
        // Close Login screen
        Login loginScreen = new Login();
        loginScreen.setVisible(false);
        loginScreen.dispose();
        System.gc();
    }

    static void openMenu() {
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
