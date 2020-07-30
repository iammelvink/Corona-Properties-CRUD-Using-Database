/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaproperties;

import java.awt.Color;
import java.awt.Toolkit;

/**
 *
 * @author MightyBeatz
 */
public class InitFunction {
    InitFunction() {
        splash();
    }

    private static void splash() {
        SplashScreen spl = new SplashScreen();

        spl.setTitle("Corona Properties");
        spl.setOpacity((float) 0.9);
        spl.setBackground(new Color(0, 0, 0, 0));
        spl.setIconImage(Toolkit.getDefaultToolkit()
                .getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
        spl.setLocationRelativeTo(null);
        spl.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(30);
                spl.lblHouse.setText(Integer.toString(i) + "%");
                spl.bar.setValue(i);

                if (i == 100) {

                    // Close SplashScreen screen
                    spl.dispose();
                    System.gc();

                    // Open Login Screen
                    Login loginScreen = new Login();

                    loginScreen.setTitle("Login");
                    loginScreen.setOpacity((float) 0.9);
                    loginScreen.setBackground(new Color(0, 0, 0, 0));
                    loginScreen.setIconImage(Toolkit.getDefaultToolkit()
                            .getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
                    loginScreen.setLocationRelativeTo(null);
                    loginScreen.setVisible(true);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
