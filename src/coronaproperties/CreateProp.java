package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;

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

}
