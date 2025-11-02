package net.runelite.client.plugins.bankwatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BankItemPanel extends JPanel
{
    public BankItemPanel(BankItem item, BufferedImage icon)
    {
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

        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 13f));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel infoLabel = new JLabel(String.format(
                "    GE: %,d | Qty: %,d | Total: %,d",
                item.getGePrice(), item.getQuantity(), item.getTotalPrice()
        ));
        infoLabel.setFont(infoLabel.getFont().deriveFont(14f));
        infoLabel.setForeground(Color.LIGHT_GRAY);
        infoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

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
            prefix = "="; // or "—" if you prefer
            deltaColor = Color.LIGHT_GRAY;
        }

        JLabel deltaLabel = new JLabel(String.format("    Change: %s%,d", prefix, Math.abs(deltaValue)));
        deltaLabel.setFont(deltaLabel.getFont().deriveFont(16f));
        deltaLabel.setForeground(deltaColor);
        deltaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        deltaLabel.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));


        textPanel.add(nameLabel);
        textPanel.add(infoLabel);
        textPanel.add(deltaLabel);

        add(textPanel, BorderLayout.CENTER);
    }
}
