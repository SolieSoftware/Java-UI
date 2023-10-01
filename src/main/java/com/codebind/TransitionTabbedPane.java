package com.codebind;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TransitionTabbedPane extends JTabbedPane implements ChangeListener, Runnable{

    protected int animation_length = 5;
    protected int step;
    protected BufferedImage buf = null;
    protected int previous_tab = -1;

    public TransitionTabbedPane() {
        super();
        this.addChangeListener(this);
    }

    public int getAnimationLength() {
        return this.animation_length;
    }

    public void setAnimation_length(int length) {
        this.animation_length = length;
    }
    @Override
    public void run() {
        step = 0;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        new Thread(this).start();
        if (previous_tab != -1) {
            Component comp = this.getComponentAt(previous_tab);
            buf = new BufferedImage(comp.getWidth(),
                    comp.getHeight(),
                    BufferedImage.TYPE_4BYTE_ABGR);
            comp.paint(buf.getGraphics());
        }
        for (int i=0; i<animation_length; i++) {
            step=i;
            repaint();
            try {
                Thread.currentThread().sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        step=-1;
        previous_tab = this.getSelectedIndex();
        repaint();

    }

    public void paintChildren(Graphics g) {
        super.paintChildren(g);
        if (step != -1) {
            Rectangle size = this.getComponentAt(0).getBounds();
            Graphics2D g2 = (Graphics2D) g;
            paintTransition(g2, step, size, buf);


        }

    }
    public void paintTransition(Graphics2D g2, int step, Rectangle size, Image prev) {

    }
}
