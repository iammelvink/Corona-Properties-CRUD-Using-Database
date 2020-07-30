package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class CreateProp {
    public static boolean createSomeProp = false;
    CreateProp() {
        createSome();
    }

    private static boolean createSome() {

        createSomeProp = true;

        CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate();
        aUpdatePropMenu.setTitle("Add New Property");
        aUpdatePropMenu.setOpacity((float) 0.9);
        aUpdatePropMenu.setBackground(new Color(0, 0, 0, 0));
        aUpdatePropMenu.setIconImage(Toolkit.getDefaultToolkit().
                getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
        aUpdatePropMenu.setLocationRelativeTo(null);
        aUpdatePropMenu.setVisible(true);
        System.gc();

        return createSomeProp;
    }

    private static boolean writeData(String propertyType, String addressNum, String addressStreet,
            String addressCity, String addressCode, double value, String constructionStatus, String useOfProperty,
            int room, int garage, int bath, double floorArea, double landArea, double rates, String description,
            String telephone, String email) {
        boolean written = false;

        ResultSet rs = null;
        int housePKey = 0;

        String sql = "INSERT INTO property(propertyType,addressNum,addressStreet,addressCity,addressCode,value,constructionStatus,useOfProperty,room,garage,bath,floorArea,landArea,rates,description,telephone,email) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //Connecting using MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            // set parameters for statement
            pstmt.setString(1, propertyType);
            pstmt.setString(2, addressNum);
            pstmt.setString(3, addressStreet);
            pstmt.setString(4, addressCity);
            pstmt.setString(5, addressCode);
            pstmt.setDouble(6, value);
            pstmt.setString(7, constructionStatus);
            pstmt.setString(8, useOfProperty);
            pstmt.setInt(9, room);
            pstmt.setInt(10, garage);
            pstmt.setDouble(11, bath);
            pstmt.setDouble(12, floorArea);
            pstmt.setDouble(13, landArea);
            pstmt.setDouble(14, rates);
            pstmt.setString(15, description);
            pstmt.setString(16, telephone);
            pstmt.setString(17, email);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                // get housePKey id
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    housePKey = rs.getInt(1);
                }

            }

            written = true;

            JOptionPane.showMessageDialog(null, "A new Property with Property Primary Key " + housePKey + " has been inserted.");

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

        return written;
    }

}
