/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaproperties;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Melvin K
 */
public class SetJFrame_Icon extends JFrame {
    SetJFrame_Icon() {

        setTitle("JFrame Icon");
        setBounds(200, 200, 300, 300);

        setIconImage(Toolkit.getDefaultToolkit().
                getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));

    }

    public static void main(String[] args) {
        SetJFrame_Icon fic = new SetJFrame_Icon();
        fic.setVisible(true);

    }

}
