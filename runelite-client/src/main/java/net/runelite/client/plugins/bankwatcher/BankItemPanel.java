package net.runelite.client.plugins.bankwatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BankItemPanel extends JPanel
{
    public BankItemPanel(BankItem item, BufferedImage icon)
    {
        setLayout(new BorderLayout(5, 0));
        setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4)); // adds subtle padding

        JLabel iconLabel;

        if (icon != null)
        {
            iconLabel = new JLabel(new ImageIcon(icon));
        }
        else
        {
            iconLabel = new JLabel("🪙");
            iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
            iconLabel.setPreferredSize(new Dimension(45, 70));
        }

        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD));

        JLabel infoLabel = new JLabel(String.format(
                "GE: %,d | Total: %,d | Qty: %,d",
                item.getGePrice(), item.getTotalPrice(), item.getQuantity()
        ));

        nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));

        add(iconLabel, BorderLayout.WEST);
        add(nameLabel, BorderLayout.CENTER);
        add(infoLabel, BorderLayout.SOUTH);
    }
}
