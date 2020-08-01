package coronaproperties;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class Auth
{
    static boolean success = false;
    static int user_id;
    static boolean login(String emailString, String passString)
    {
        ResultSet rs = null;

        String sql = "SELECT user_id, email, password FROM user "
                + "WHERE email = ? AND password = ?";

        //Connecting using ConnectUtil
        //using resources
        ///so that connection to db closes automatically
        try (Connection conn = ConnectUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, emailString);
            pstmt.setString(2, passString);

            rs = pstmt.executeQuery();

            if (rs.next())
            {
                //Get user_id
                user_id = rs.getInt("user_id");

                //Log the login into the login_audit table
                signedIn(user_id);
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
            } catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return success;
    }

    static boolean signedIn(int user_id)
    {
        //1 means logged in
        int loggedIn = 1;

        String sql = "UPDATE user SET action = ? "
                + "WHERE user_id = ?";
        try (Connection conn = ConnectUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setInt(1, loggedIn);
            pstmt.setInt(2, user_id);

            pstmt.executeUpdate();
// Authentication complete
            success = true;
        } catch (SQLException e)
        {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println(e.getMessage());
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    static boolean register(String fNameString, String lNameString, String emailString, String passString)
    {
        ResultSet rs = null;

        int userPKey = 0;

        String sql = "INSERT INTO user(fName,lName,email,password) "
                + "VALUES(?,?,?,?)";
        //Connecting using ConnectUtil
        //using resources
        ///so that connection to db closes automatically
        try (Connection conn = ConnectUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            // set parameters for statement
            pstmt.setString(1, fNameString);
            pstmt.setString(2, lNameString);
            pstmt.setString(3, emailString);
            pstmt.setString(4, passString);
            int rowAffected = pstmt.executeUpdate();

            if (rowAffected == 1)
            {
                // get userPKey id
                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                    userPKey = rs.getInt(1);
                }
            }
            JOptionPane.showMessageDialog(null, "Registered successfully\nUser ID is:  " + userPKey + ".");

            //Login after register
            if (login(emailString, passString))
            {
                //registered successfully
                success = true;
            }

        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
            } catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return success;
    }

    static void closeLoginScreen()
    {
        // Close Login screen
        Login loginScreen = new Login();
        loginScreen.setVisible(false);
        loginScreen.dispose();
        System.gc();
    }

    static void openMenu()
    {
        // Open menu
        MainMenu menu = new MainMenu();

        menu.setTitle("Corona Properties Main Menu");
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(menu);
    }

}