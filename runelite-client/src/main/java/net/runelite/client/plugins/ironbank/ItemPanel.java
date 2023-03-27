package net.runelite.client.plugins.ironbank;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class ItemPanel extends JPanel {
    private final JLabel iconLabel;
    private final JLabel descriptionLabel;

    public ItemPanel(BufferedImage image, String description) {
        setLayout(new BorderLayout());
        iconLabel = new JLabel(new ImageIcon(image));
        descriptionLabel = new JLabel(description);
        add(iconLabel, BorderLayout.CENTER);
        add(descriptionLabel, BorderLayout.SOUTH);
    }
}