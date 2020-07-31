package coronaproperties;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class ComputeDepBySearch {
    private static String output = "";
    private static DecimalFormat df = new DecimalFormat("R ###,###,###,###,###,###.00");
    static String computeDep(double currentValue, double r, int t) {
        double depreciation = (currentValue * r / 100 * t);
        double valueAfterDep = currentValue - depreciation;

        output = "";

        if (valueAfterDep < depreciation) {
            output = "This property no longer has any worth";
        } else {
            output = "Old value: " + df.format(currentValue)
                    + "\n\nAfter a depreciation rate of " + r + "% for " + t + " years"
                    + "\n\nThe property is now worth: "
                    + df.format(valueAfterDep);
        }
        return output;
    }

    static void displayData() {
        JOptionPane.showMessageDialog(null, output);
    }

}
