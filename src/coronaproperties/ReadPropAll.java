package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class ReadPropAll {
    public static boolean readPropAll = false;
    ReadPropAll() {
//        displayData();
        readAll();
    }

    private static boolean readAll() {

        readPropAll = true;

        CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate();
        aUpdatePropMenu.setTitle("View All Property");
        aUpdatePropMenu.setOpacity((float) 0.9);
        aUpdatePropMenu.setBackground(new Color(0, 0, 0, 0));
        aUpdatePropMenu.setIconImage(Toolkit.getDefaultToolkit().
                getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
        aUpdatePropMenu.setLocationRelativeTo(null);
        aUpdatePropMenu.setVisible(true);
        System.gc();

        return readPropAll;
    }

    private static void displayData() {
        DecimalFormat df = new DecimalFormat("R ###,###,###,###,###,###.00");
        ResultSet rs = null;

        String output;

        String sql = "SELECT * FROM property ";

        //Connecting using MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //Executing query
            rs = pstmt.executeQuery();

            while (rs.next()) {
                output = "\npropertyPrimaryKey: " + rs.getString("propertyPrimaryKey") + "\npropertyType: "
                        + rs.getString("propertyType") + "\naddressNum: "
                        + rs.getString("addressNum") + "\naddressStreet: "
                        + rs.getString("addressStreet") + "\naddressCity: "
                        + rs.getString("addressCity") + "\naddressCode: "
                        + rs.getString("addressCode") + "\nvalue: "
                        + df.format(rs.getDouble("value")) + "\nconstructionStatus: "
                        + rs.getString("constructionStatus") + "\nuseOfProperty: "
                        + rs.getString("useOfProperty") + "\nroom: "
                        + rs.getInt("room") + "\ngarage: "
                        + rs.getInt("garage") + "\nbath: "
                        + rs.getInt("bath") + "\nfloorArea: "
                        + rs.getDouble("floorArea") + "\nlandArea: "
                        + rs.getDouble("landArea") + "\nrates: "
                        + df.format(rs.getDouble("rates")) + "\ndescription: "
                        + rs.getString("description") + "\ntelephone: "
                        + rs.getString("telephone") + "\nemail: "
                        + rs.getString("email") + "\n\n";

                JOptionPane.showMessageDialog(null, output);
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
    }

}
