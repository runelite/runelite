package net.runelite.client.plugins.ironbank;

import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.SpritePixels;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IronBankSharingPanel extends PluginPanel {
    private final JPanel itemContainer = new JPanel();

    public IronBankSharingPanel() {
        setLayout(new BorderLayout());
        itemContainer.setLayout(new GridLayout(0, 8, 5, 5));
        JScrollPane scrollPane = new JScrollPane(itemContainer);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateItems(Client client, List<Item> items) {
        if (items == null) {
            return;
        }
        itemContainer.removeAll();
        for (Item item : items) {
            BufferedImage image = getImage(client, item.getId());
            JLabel itemLabel = new JLabel(new ImageIcon(image));
            itemContainer.add(itemLabel);
        }
        itemContainer.revalidate();
        itemContainer.repaint();
    }

    private BufferedImage getImage(Client client, int itemId) {
        ItemComposition itemComposition = client.getItemDefinition(itemId);
        SpritePixels spritePixels = client.createItemSprite(itemId, itemComposition.getInventoryModel(), itemComposition.getNote(), 1, 0, false, 0);
        return spritePixels.toBufferedImage();
    }

}