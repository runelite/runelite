package net.runelite.client.plugins.bosslog;

import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

public class BossLogUniqueBox extends JPanel
{
    private int alpha = 255;

    BossLogUniqueBox(ItemManager itemManager, Item item) {
        setBackground(ColorScheme.DARKER_GRAY_COLOR);

        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon());
        AsyncBufferedImage icon;
        if(item.getQuantity() > 0) {
            icon = itemManager.getImage(item.getId(), item.getQuantity(), true);
        } else {
            icon = itemManager.getImage(item.getId());
            alpha = 75;
        }
        Runnable resize = () ->
        {
            BufferedImage subIcon = setAlpha((byte) alpha, icon);
            iconLabel.setIcon(new ImageIcon(subIcon.getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING)));
        };
        icon.onChanged(resize);
        resize.run();
        add(iconLabel, BorderLayout.WEST);
    }

     private BufferedImage setAlpha(byte alpha, BufferedImage img) {
        alpha %= 0xff;
         for (int cx=0;cx<img.getWidth();cx++) {
             for (int cy=0;cy<img.getHeight();cy++) {
                 int color = img.getRGB(cx, cy);

                 int mc = (alpha << 24) | 0x00ffffff;
                 int newcolor = color & mc;
                 img.setRGB(cx, cy, newcolor);

             }

         }
        return img;
    }
}
