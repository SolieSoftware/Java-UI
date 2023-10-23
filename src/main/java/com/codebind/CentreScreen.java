package com.codebind;

import javax.swing.*;
import java.awt.*;

public class CentreScreen extends JFrame {


    void setUpFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centreX = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int centreY = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(centreX, centreY);
    }
}
