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


public class BossLogDropBox extends JPanel
{
    BossLogDropBox(ItemManager itemManager, Item item)
    {
        setBackground(ColorScheme.DARKER_GRAY_COLOR);

        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon());
        AsyncBufferedImage icon = itemManager.getImage(item.getId(), item.getQuantity(), true);
        Runnable resize = () ->
        {
            BufferedImage subIcon = icon;
            iconLabel.setIcon(new ImageIcon(subIcon.getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING)));
        };
        icon.onChanged(resize);
        resize.run();
        add(iconLabel, BorderLayout.WEST);
    }
}
