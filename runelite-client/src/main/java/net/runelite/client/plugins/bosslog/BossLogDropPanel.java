package net.runelite.client.plugins.bosslog;

import net.runelite.api.ItemComposition;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class BossLogDropPanel extends TabContentPanel
{
    JPanel uniqueContainer = new JPanel();
    JPanel logContainer = new JPanel();

    JLabel logLabelGP;
    JLabel logLabelKC;

    Boss panelBoss;

    BossLogDropPanel(ItemManager itemManager, Boss boss)
    {
        panelBoss = boss;
        setLayout(new DynamicGridLayout(0, 1, 0, 5));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setBorder(new EmptyBorder(5, 0, 5, 0));

        JPanel uniqueTextContainer = new JPanel();
        uniqueTextContainer.setBorder(new EmptyBorder(4,4,4,4));
        uniqueTextContainer.setBackground(new Color(24, 24, 24));
        uniqueTextContainer.setLayout(new BorderLayout());

        JLabel uniqueLabel = new JLabel();
        uniqueLabel.setForeground(Color.WHITE);
        uniqueLabel.setFont(FontManager.getRunescapeFont());
        uniqueLabel.setText("Uniques");
        uniqueTextContainer.add(uniqueLabel, BorderLayout.WEST);

        JPanel uniqueMainContainer = new JPanel();
        uniqueMainContainer.setLayout(new DynamicGridLayout(0, 1, 2, 2));
        add(uniqueMainContainer);
        uniqueMainContainer.add(uniqueTextContainer);

        uniqueContainer.setLayout(new GridLayout(0, 5, 2, 2));
        uniqueMainContainer.add(uniqueContainer);

        for(int id : boss.getBoss().getUniques()) {
            boolean added = false;
            for(Item i : boss.getDrops()) {
                if(id == i.getId()) {
                    uniqueContainer.add(new BossLogUniqueBox(itemManager, i));
                    added = true;
                }
            }
            if(!added) {
                uniqueContainer.add(new BossLogUniqueBox(itemManager, new Item(id, 0, "", 0)));
            }
        }

        JPanel dropLogMainContainer = new JPanel();
        dropLogMainContainer.setLayout(new DynamicGridLayout(0, 1, 0, 2));
        add(dropLogMainContainer);

        JPanel logTextContainer = new JPanel();
        logTextContainer.setLayout(new BorderLayout());
        logTextContainer.setBorder(new EmptyBorder(4,4,4,4));
        logTextContainer.setBackground(new Color(24, 24, 24));
        dropLogMainContainer.add(logTextContainer);

        JLabel logLabel = new JLabel();
        logLabel.setForeground(Color.WHITE);
        logLabel.setFont(FontManager.getRunescapeFont());
        logLabel.setText("Drop Log");
        logTextContainer.add(logLabel, BorderLayout.WEST);

        logLabelKC = new JLabel();
        logLabelKC.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
        logLabelKC.setFont(FontManager.getRunescapeSmallFont());
        logLabelKC.setText("  (" + boss.getKC() + " KC)");
        logTextContainer.add(logLabelKC, BorderLayout.CENTER);

        logLabelGP = new JLabel();
        logLabelGP.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
        logLabelGP.setFont(FontManager.getRunescapeSmallFont());
        logLabelGP.setText("0 gp");
        logTextContainer.add(logLabelGP, BorderLayout.EAST);

        logContainer.setLayout(new GridLayout(0, 5, 2, 2));
        dropLogMainContainer.add(logContainer);

        for(Item i : boss.getDrops())
            logContainer.add(new BossLogDropBox( itemManager, i));
    }

    @Override
    public int getUpdateInterval()
    {
        return 50;
    }

    @Override
    public void update()
    {
        logLabelGP.setText(panelBoss.getProfit() + " gp");
    }
}
