package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;

/**
 *
 * @author Melvin K
 */
public class DeleteProp {
    static boolean deleteSomeProp = false;
    static boolean deleteSome() {
        deleteSomeProp = true;

        CRUDViewTemplate aUpdatePropMenu = new CRUDViewTemplate();
        aUpdatePropMenu.setTitle("Delete Property");
        aUpdatePropMenu.setOpacity((float) 0.9);
        aUpdatePropMenu.setBackground(new Color(0, 0, 0, 0));
        aUpdatePropMenu.setIconImage(Toolkit.getDefaultToolkit().
                getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
        aUpdatePropMenu.setLocationRelativeTo(null);
        aUpdatePropMenu.setVisible(true);
        System.gc();

        return deleteSomeProp;
    }

}
