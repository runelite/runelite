package net.runelite.client.plugins.farmingprofit;

import net.runelite.api.ItemComposition;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.StackFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FarmingProfitBox extends JPanel {

    FarmingProfitBox(ItemManager itemManager, final int product, final int seed, final int amount)
    {
        setLayout(new BorderLayout(0, 1));
        setBorder(new EmptyBorder(5, 0, 0, 0));

        final JPanel logTitle = new JPanel();
        logTitle.setLayout(new GridLayout(3, 1));
        logTitle.setBorder(new EmptyBorder(7, 7, 7, 7));
        logTitle.setBackground(ColorScheme.DARKER_GRAY_COLOR);

        // TODO correct name
        final ItemComposition itemComposition = itemManager.getItemComposition(product);
        String itemName = itemComposition.getName();
        final JLabel titleLabel = new JLabel(itemName);
        titleLabel.setFont(FontManager.getRunescapeSmallFont());
        titleLabel.setForeground(Color.WHITE);
        logTitle.add(titleLabel, BorderLayout.CENTER);

        final JPanel slotContainer = new JPanel();
        slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        final JLabel imageLabel = new JLabel();
        // TODO correct name
        imageLabel.setToolTipText(itemName);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemManager.getImage(product, 1, false).addTo(imageLabel);
        slotContainer.add(imageLabel);
        logTitle.add(slotContainer, BorderLayout.WEST);

        // TODO calculate profit
        int profit = 100000;

        if (profit > 0)
        {
            final JLabel profitLabel = new JLabel("Profit: " + StackFormatter.quantityToStackSize(profit) + " gp");
            profitLabel.setFont(FontManager.getRunescapeSmallFont());
            profitLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
            logTitle.add(profitLabel, BorderLayout.EAST);
        }

        if (amount > 0)
        {
            final JLabel amountLabel = new JLabel("Amount: " + StackFormatter.quantityToStackSize(amount) + "x");
            amountLabel.setFont(FontManager.getRunescapeSmallFont());
            amountLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
            logTitle.add(amountLabel, BorderLayout.EAST);
        }



//        // Calculates how many rows need to be display to fit all items
//        final int rowSize = ((items.length % ITEMS_PER_ROW == 0) ? 0 : 1) + items.length / ITEMS_PER_ROW;
//        final JPanel itemContainer = new JPanel(new GridLayout(rowSize, ITEMS_PER_ROW, 1, 1));
//
//        for (int i = 0; i < rowSize * ITEMS_PER_ROW; i++)
//        {
//            final JPanel slotContainer = new JPanel();
//            slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
//
//            if (i < items.length)
//            {
//                final LootTrackerItemEntry item = items[i];
//                final JLabel imageLabel = new JLabel();
//                imageLabel.setToolTipText(buildToolTip(item));
//                imageLabel.setVerticalAlignment(SwingConstants.CENTER);
//                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
//                itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 1).addTo(imageLabel);
//                slotContainer.add(imageLabel);
//            }
//
//            itemContainer.add(slotContainer);
//        }

        add(logTitle, BorderLayout.NORTH);
//        add(itemContainer, BorderLayout.CENTER);
    }

}
