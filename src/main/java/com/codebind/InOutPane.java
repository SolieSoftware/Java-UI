package com.codebind;

import org.w3c.dom.css.Rect;

import java.awt.*;

public class InOutPane extends TransitionTabbedPane{
    public void paintTransition(Graphics2D g2, int state, Rectangle size, Image prev) {
        int length = getAnimationLength();
        int half = length/2;

        double scale = size.getHeight()/length;
        int offset = 0;
        if (state >= 0 && state < half) {
            if (prev != null) {
                g2.drawImage(prev, (int)size.getX(), (int)size.getY(),null);
            }
            offset = (int)((10-state)*scale);
        }
        if (state >= half && state < length) {
            g2.setColor(Color.WHITE);
            offset = (int)((state-10)*scale);
        }
        g2.setColor(Color.WHITE);
        Rectangle area = new Rectangle((int)(size.getX()+offset),
        (int)(size.getY()+offset),
                (int)(size.getWidth()-offset*2),
                (int)(size.getHeight()-offset*2));
        g2.fill(area);
    }
}
