package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class UpdateProp {
    public static boolean updateSomeProp = false;
    UpdateProp() {
//        updateNode();
//        displayData();
        updateSome();
    }

    private static boolean updateSome() {
        updateSomeProp = true;

        CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate();
        aUpdatePropMenu.setTitle("Update Property");
        aUpdatePropMenu.setOpacity((float) 0.9);
        aUpdatePropMenu.setBackground(new Color(0, 0, 0, 0));
        aUpdatePropMenu.setIconImage(Toolkit.getDefaultToolkit().
                getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
        aUpdatePropMenu.setLocationRelativeTo(null);
        aUpdatePropMenu.setVisible(true);
        System.gc();

        return updateSomeProp;
    }

    private static boolean updateNode() {

        boolean updated = false;

        try {
            String searchKey = JOptionPane.showInputDialog("Enter property primary key to  a property: ");

            if (!checkBefore(searchKey)) {
                JOptionPane.showMessageDialog(null, "Property number does NOT exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
            // Open menu
            MainMenu menu = new MainMenu();

            menu.setTitle("Corona Main Menu");
            menu.setOpacity((float) 0.9);
            menu.setBackground(new Color(0, 0, 0, 0));
            menu.setIconImage(Toolkit.getDefaultToolkit()
                    .getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
        }

        return updated;
    }

    private static boolean checkBefore(String searchKey) {
        boolean exists = false;
        ResultSet rs = null;

        String sql = "SELECT * FROM property "
                + "WHERE propertyPrimaryKey = ?";

        //Connecting using MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, searchKey);
            //Executing query
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //propertyPrimaryKey is found
                exists = true;

//                rs = pstmt.executeQuery();
//                while (rs.next()) {
//                String propertyPrimaryKey = rs.getString("propertyPrimaryKey");
//                String propertyType = rs.getString("propertyType");
//                String addressNum = rs.getString("addressNum");
//                String addressStreet = rs.getString("addressStreet");
//                String addressCity = rs.getString("addressCity");
//                String addressCode = rs.getString("addressCode");
//                double value = rs.getDouble("value");
//                String constructionStatus = rs.getString("constructionStatus");
//                String useOfProperty = rs.getString("useOfProperty");
//                int room = rs.getInt("room");
//                int garage = rs.getInt("garage");
//                int bath = rs.getInt("bath");
//                double floorArea = rs.getDouble("floorArea");
//                double landArea = rs.getDouble("landArea");
//                double rates = rs.getDouble("rates");
//                String description = rs.getString("description");
//                String telephone = rs.getString("telephone");
//                String email = rs.getString("email");
//                CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate(rs.getString("propertyPrimaryKey"), rs.getString("propertyType"), rs.getString("addressNum"), rs.getString("addressStreet"), rs.getString("addressCity"), rs.getString("addressCode"), rs.getDouble("value"), rs.getString("constructionStatus"), rs.getString("useOfProperty"), rs.getInt("room"), rs.getInt("garage"), rs.getInt("bath"), rs.getDouble("floorArea"), rs.getDouble("landArea"), rs.getDouble("rates"), rs.getString("description"), rs.getString("telephone"), rs.getString("email"));
//                CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate(propertyPrimaryKey, propertyType, addressNum, addressStreet, addressCity, addressCode, value, constructionStatus, useOfProperty, room, garage, bath, floorArea, landArea, rates, description, telephone, email);
//                CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate();
//                aUpdatePropMenu.setTitle("Update Property");
//                aUpdatePropMenu.setOpacity((float) 0.9);
//                aUpdatePropMenu.setBackground(new Color(0, 0, 0, 0));
//                aUpdatePropMenu.setIconImage(Toolkit.getDefaultToolkit().
//                        getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
//                aUpdatePropMenu.setLocationRelativeTo(null);
//                aUpdatePropMenu.setVisible(true);
                System.gc();
//                }

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
        return exists;
    }

    private static void displayData() {
        ResultSet rs = null;

//        String output;
        String sql = "SELECT * FROM property ";

        //Connecting using MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection();
                //Creating query
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //Executing query
            rs = pstmt.executeQuery();

            while (rs.next()) {
//                CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate(rs.getString("propertyPrimaryKey"), rs.getString("propertyType"), rs.getString("addressNum"), rs.getString("addressStreet"), rs.getString("addressCity"), rs.getString("addressCode"), rs.getDouble("value"), rs.getString("constructionStatus"), rs.getString("useOfProperty"), rs.getInt("room"), rs.getInt("garage"), rs.getInt("bath"), rs.getDouble("floorArea"), rs.getDouble("landArea"), rs.getDouble("rates"), rs.getString("description"), rs.getString("telephone"), rs.getString("email"));

                String propertyPrimaryKey = rs.getString("propertyPrimaryKey");
                String propertyType = rs.getString("propertyType");
                String addressNum = rs.getString("addressNum");
                String addressStreet = rs.getString("addressStreet");
                String addressCity = rs.getString("addressCity");
                String addressCode = rs.getString("addressCode");
                double value = rs.getDouble("value");
                String constructionStatus = rs.getString("constructionStatus");
                String useOfProperty = rs.getString("useOfProperty");
                int room = rs.getInt("room");
                int garage = rs.getInt("garage");
                int bath = rs.getInt("bath");
                double floorArea = rs.getDouble("floorArea");
                double landArea = rs.getDouble("landArea");
                double rates = rs.getDouble("rates");
                String description = rs.getString("description");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");

//                CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate(propertyPrimaryKey, propertyType, addressNum, addressStreet, addressCity, addressCode, value, constructionStatus, useOfProperty, room, garage, bath, floorArea, landArea, rates, description, telephone, email);
//                CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate();
//                JOptionPane.showMessageDialog(null, output);
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
