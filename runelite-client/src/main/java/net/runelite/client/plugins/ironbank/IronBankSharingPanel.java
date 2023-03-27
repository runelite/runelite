package net.runelite.client.plugins.ironbank;

import java.util.List;

import net.runelite.api.*;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.Collectors;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class IronBankSharingPanel extends PluginPanel {
    private final JPanel itemContainer = new JPanel();
    private final ItemManager itemManager;
    private final JTextField searchBar = new JTextField();
    private List<Item> allItems;

    private final Client client;


    public IronBankSharingPanel(ItemManager itemManager, Client client) {
        this.itemManager = itemManager;
        this.client = client;
        setLayout(new BorderLayout());
        itemContainer.setLayout(new GridLayout(0, 1, 5, 5));

        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFilteredItems();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFilteredItems();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFilteredItems();
            }
        });
        searchBar.setPreferredSize(new Dimension(0, 30));

        JScrollPane scrollPane = new JScrollPane(itemContainer);
        add(searchBar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void updateFilteredItems() {
        String searchText = searchBar.getText().toLowerCase();
        List<Item> filteredItems = allItems.stream()
                .filter(item -> client.getItemDefinition(item.getId()).getName().toLowerCase().contains(searchText))
                .collect(Collectors.toList());
        updateItems(client, filteredItems);
    }


    public void updateItems(Client client, List<Item> items) {
        if (items == null) {
            return;
        }

        if (allItems == null) {
            allItems = items;
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