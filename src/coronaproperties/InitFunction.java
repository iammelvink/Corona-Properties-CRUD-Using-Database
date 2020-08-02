/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaproperties;

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
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(spl);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(20);
                spl.lblHouse.setText(Integer.toString(i) + "%");
                spl.bar.setValue(i);

                if (i == 100) {

                    // Close SplashScreen screen
                    spl.dispose();

                    // Open Login Screen
                    Login loginScreen = new Login();
                    loginScreen.whatAction();

                    loginScreen.setTitle("Login");
                    setJFrameIcon = new SetJFrameIcon(loginScreen);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
