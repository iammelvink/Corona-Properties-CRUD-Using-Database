package coronaproperties;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Melvin K
 */
public class ComputeAppreBySearch {
    private static String output = "";
    private static DecimalFormat df = new DecimalFormat("R ###,###,###,###,###,###.00");
    static String computeAppre(double currentValue, double r, int t) {
        double appreciation = (currentValue * r / 100 * t);
        double valueAfterAppre = currentValue + appreciation;

        output = "";

        output = "This property no longer has any worth";

        output = "Old value: " + df.format(currentValue)
                + "\n\nAfter an appreciation rate of " + r + "% for " + t + " years"
                + "\n\nThe property is now worth: "
                + df.format(valueAfterAppre);

        return output;
    }

    static void displayData() {
        JOptionPane.showMessageDialog(null, output);
    }

}
