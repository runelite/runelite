package net.runelite.client.plugins.ironbank;

import java.util.List;

import com.google.inject.Inject;
import net.runelite.api.*;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IronBankSharingPanel extends PluginPanel {
    private final JPanel itemContainer = new JPanel();

    private final ItemManager itemManager;

    public IronBankSharingPanel(ItemManager itemManager) {
        this.itemManager = itemManager;
        setLayout(new BorderLayout());
        itemContainer.setLayout(new GridLayout(0, 1, 5, 5));
        JScrollPane scrollPane = new JScrollPane(itemContainer);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateItems(Client client, List<Item> items) {
        if (items == null) {
            return;
        }
        itemContainer.removeAll();
        for (Item item : items) {
            BufferedImage image = getImage(itemManager, item.getId());
            ItemComposition itemComposition = client.getItemDefinition(item.getId());
            String description = itemComposition.getName() + " x" + item.getQuantity();
            ItemPanel itemPanel = new ItemPanel(image, description);
            itemContainer.add(itemPanel);
        }
        itemContainer.revalidate();
        itemContainer.repaint();
    }


    private BufferedImage getImage(ItemManager itemManager, int itemId) {
        Image image = itemManager.getImage(itemId);
        if (image != null) {
            return ImageUtil.bufferedImageFromImage(image);
        }
        return null;
    }
}