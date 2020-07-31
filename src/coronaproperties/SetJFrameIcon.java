/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaproperties;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Melvin K
 */
public class SetJFrameIcon extends JFrame {
    SetJFrameIcon(JFrame ajFrame) {
        appIcon(ajFrame);
    }

    private void appIcon(JFrame ajFrame) {
        // Set some frame properties
        ajFrame.setOpacity((float) 0.9);
        ajFrame.setBackground(new Color(0, 0, 0, 0));
        ajFrame.setLocationRelativeTo(null);
        // Read the image that will be used as the application icon.
        // Using "/" in front of the image file name will locate the
        // image at the root folder of our application. If you don't
        // use a "/" then the image file should be on the same folder
        // with your class file
        try {

            URL resource = ajFrame.getClass().getResource("/icons/icons8_House_100px.png");
            BufferedImage image = ImageIO.read(resource);
            ajFrame.setIconImage(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Display the form
        ajFrame.setVisible(true);
    }

}
