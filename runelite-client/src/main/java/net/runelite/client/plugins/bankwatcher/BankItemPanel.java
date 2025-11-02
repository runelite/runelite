package net.runelite.client.plugins.bankwatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BankItemPanel extends JPanel {
    public BankItemPanel(BankItem item, BufferedImage icon) {
        setLayout(new BorderLayout(8, 0));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(4, 4, 4, 4),
                BorderFactory.createLineBorder(new Color(60, 60, 60), 1)
        ));
        setBackground(new Color(40, 40, 40));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));

        // --- Icon ---
        JLabel iconLabel = (icon != null)
                ? new JLabel(new ImageIcon(icon))
                : new JLabel("🪙", SwingConstants.CENTER);

        iconLabel.setPreferredSize(new Dimension(45, 45));
        add(iconLabel, BorderLayout.WEST);

        // --- Text Panel ---
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        // Name at the top
        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 14f));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // --- Stats Panel (stacked vertically) ---
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setOpaque(false);
        statsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Individual stat labels
        JLabel geLabel = new JLabel(String.format("GE: %,d", item.getGePrice()));
        JLabel qtyLabel = new JLabel(String.format("Qty: %,d", item.getQuantity()));
        JLabel totalLabel = new JLabel(String.format("Total: %,d", item.getTotalPrice()));

        // Apply consistent styling
        for (JLabel label : new JLabel[]{geLabel, qtyLabel, totalLabel})
        {
            label.setFont(label.getFont().deriveFont(14f));
            label.setForeground(Color.LIGHT_GRAY);
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        // Compute delta
        int deltaValue = item.getDelta();
        String prefix;
        Color deltaColor;

        if (deltaValue > 0)
        {
            prefix = "+";
            deltaColor = new Color(0, 200, 0);
        }
        else if (deltaValue < 0)
        {
            prefix = "-";
            deltaColor = new Color(230, 60, 60);
        }
        else
        {
            prefix = "=";
            deltaColor = Color.LIGHT_GRAY;
        }

        // Change label
        JLabel deltaLabel = new JLabel(String.format("Change: %s%,d", prefix, Math.abs(deltaValue)));
        deltaLabel.setFont(deltaLabel.getFont().deriveFont(14f));
        deltaLabel.setForeground(deltaColor);
        deltaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        deltaLabel.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));

        // Add labels in order
        statsPanel.add(geLabel);
        statsPanel.add(qtyLabel);
        statsPanel.add(totalLabel);
        statsPanel.add(deltaLabel);

        // Add everything to main text panel
        textPanel.add(nameLabel);
        textPanel.add(Box.createVerticalStrut(3));
        textPanel.add(statsPanel);

        add(textPanel, BorderLayout.CENTER);
    }
}