package net.runelite.client.plugins.flipping;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.StackFormatter;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

@Slf4j
public class FlippingItemPanel extends JPanel {
    private static final Dimension ICON_SIZE = new Dimension(32, 32);

    FlippingItemPanel(String itemName, Icon icon, Long buyPrice, Long sellPrice) {
        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        setLayout(layout);
        setToolTipText(itemName);

        Color background = getBackground();

        setBorder(new CompoundBorder
                (
                        new LineBorder(getBackground().brighter(), 1),
                        new EmptyBorder(5, 5, 5, 5)
                ));

        JLabel itemIcon = new JLabel();
        itemIcon.setPreferredSize(ICON_SIZE);
        if (icon != null)
        {
            itemIcon.setIcon(icon);
        }
        add(itemIcon, BorderLayout.LINE_START);

        JPanel rightPanel = new JPanel(new GridLayout(3, 1));
        rightPanel.setOpaque(false);

        JLabel itemNameLabel = new JLabel();
        itemNameLabel.setText(itemName);
        rightPanel.add(itemNameLabel);

        JLabel buyPriceLabel = new JLabel();
        buyPriceLabel.setText("Buy: " + StackFormatter.formatNumber(buyPrice));
        buyPriceLabel.setForeground(Color.GREEN);
        rightPanel.add(buyPriceLabel);

        JLabel sellPriceLabel = new JLabel();
        sellPriceLabel.setText("Sell: " + StackFormatter.formatNumber(sellPrice));
        sellPriceLabel.setForeground(Color.GREEN);
        rightPanel.add(sellPriceLabel);

        add(rightPanel, BorderLayout.CENTER);
    }
}
