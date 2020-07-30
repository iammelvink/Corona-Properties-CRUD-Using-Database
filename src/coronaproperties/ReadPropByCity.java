package coronaproperties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class ReadPropByCity {
    private static class Property {
        // fields
        private String propertyPrimaryKey;
        private String propertyType;
        private String addressNum;
        private String addressStreet;
        private String addressCity;
        private String addressCode;
        private double value;
        private String constructionStatus;
        private String useOfProperty;
        private int room;
        private int garage;
        private int bath;
        private double floorArea;
        private double landArea;
        private double rates;
        private String description;
        private String telephone;
        private String email;
    }

    private static Property propertyInfo;
    private static DecimalFormat df = new DecimalFormat("R ###,###,###,###,###,###.00");

    ReadPropByCity(String addressCity) {
        if (!addressCity.isEmpty()) {
            displayData(addressCity);
        } else {
            JOptionPane.showMessageDialog(null, "You did not enter anything!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void displayData(String addressCity) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("CoronaProperties.txt"));
            String rec = reader.readLine();
            String remain = "";
            String output = "";

            while (rec != null) {
                propertyInfo = new Property();

                propertyInfo.propertyPrimaryKey = rec.substring(0, rec.indexOf("#"));
                remain = rec.substring(rec.indexOf("#") + 1, rec.length());

                propertyInfo.propertyType = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.addressNum = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.addressStreet = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.addressCity = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.addressCode = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.value = Double.parseDouble(remain.substring(0, remain.indexOf("#")));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.constructionStatus = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.useOfProperty = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.room = Integer.parseInt(remain.substring(0, remain.indexOf("#")));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.garage = Integer.parseInt(remain.substring(0, remain.indexOf("#")));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.bath = Integer.parseInt(remain.substring(0, remain.indexOf("#")));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.floorArea = Double.parseDouble(remain.substring(0, remain.indexOf("#")));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.landArea = Double.parseDouble(remain.substring(0, remain.indexOf("#")));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.rates = Double.parseDouble(remain.substring(0, remain.indexOf("#")));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.description = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.telephone = remain.substring(0, remain.indexOf("#"));
                remain = remain.substring(remain.indexOf("#") + 1, remain.length());

                propertyInfo.email = remain;

                // Case insensitive search: by making both search string and source string lower
                // case
                if (propertyInfo.addressCity.toLowerCase().contains(addressCity.toLowerCase())) {
                    output += "\n" + propertyInfo.propertyPrimaryKey + "\n" + propertyInfo.propertyType + "\n"
                            + propertyInfo.addressNum + "\n" + propertyInfo.addressStreet + "\n"
                            + propertyInfo.addressCity + "\n" + propertyInfo.addressCode + "\n"
                            + df.format(propertyInfo.value) + "\n" + propertyInfo.constructionStatus + "\n"
                            + propertyInfo.useOfProperty + "\n" + propertyInfo.room + "\n" + propertyInfo.garage + "\n"
                            + propertyInfo.bath + "\n" + propertyInfo.floorArea + "\n" + propertyInfo.landArea + "\n"
                            + df.format(propertyInfo.rates) + "\n" + propertyInfo.description + "\n"
                            + propertyInfo.telephone + "\n" + propertyInfo.email + "\n\n";
                }
                rec = reader.readLine();
            }
            reader.close();
            JOptionPane.showMessageDialog(null, output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
