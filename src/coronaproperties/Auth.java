package coronaproperties;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class Auth {
    static boolean login(String emailString, String passString) {
        boolean success = false;
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
                success = true;
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
        return success;
    }

    static boolean register(String emailString, String passString) {
        boolean success = false;
        ResultSet rs = null;

        int userPKey = 0;

        String sql = "INSERT INTO user(email,password) "
                + "VALUES(?,?)";
        //Connecting using ConnectUtil
        //using resources
        ///so that connection to db closes automatically
        try (Connection conn = ConnectUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // set parameters for statement
            pstmt.setString(1, emailString);
            pstmt.setString(2, passString);
            int rowAffected = pstmt.executeUpdate();

            if (rowAffected == 1) {
                // get userPKey id
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    userPKey = rs.getInt(1);
                }
            }
            JOptionPane.showMessageDialog(null, "Registered successfully\nUser ID is:  " + userPKey + ".");

            //Login after register
            if (login(emailString, passString)) {
                //registered successfully
                success = true;
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
        return success;
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
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(menu);
    }

}
