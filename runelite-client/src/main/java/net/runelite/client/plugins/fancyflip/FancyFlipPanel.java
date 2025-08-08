package net.runelite.client.plugins.fancyflip.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.runelite.client.ui.PluginPanel;

public class FancyFlipPanel extends PluginPanel
{
    public FancyFlipPanel()
    {
        setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.add(new JLabel("FancyFlip Online"));
        add(top, BorderLayout.NORTH);

        JButton copyPrice = new JButton("Copy Price");
        add(copyPrice, BorderLayout.SOUTH);
    }
}
