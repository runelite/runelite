package net.runelite.client.util;

import java.awt.*;


public class Utilities {

    public static void fillRect(Graphics g, int x, int y, int w, int h) {
        Color color = g.getColor();
        //Rect
        g.setColor(color);
        g.fillRect(x, y, w, h);
        //Outline
        g.setColor(color.darker());
        g.drawRect(x, y, w, h);
    }

    public static void outlineString(Graphics g, String text, int x, int y) {
        Color color = g.getColor();
        //Outline
        g.setColor(Color.BLACK);
        g.drawString(text, x + 1, y + 1);
        g.drawString(text, x - 1, y - 1);
        g.drawString(text, x + 1, y - 1);
        g.drawString(text, x - 1, y + 1);
        //String
        g.setColor(color);
        g.drawString(text, x, y);
    }
    public static void shadowString(Graphics g, String text, int x, int y) {
        Color color = g.getColor();
        //Shadow
        g.setColor(Color.BLACK);
        g.drawString(text, x + 1, y + 1);
        //String
        g.setColor(color);
        g.drawString(text, x, y);
    }

}
