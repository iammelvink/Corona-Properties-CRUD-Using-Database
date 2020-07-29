package corona_properties_crud_using_database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Melvin K
 */
public class Driver {
    public static void main(String[] args) {

        // create a new connection from MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            // print out a message
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        InitFunction sc = new InitFunction();
    }

}
