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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BossLogDropPanel extends TabContentPanel
{
    private JPanel uniqueContainer = new JPanel();
    private JPanel logContainer = new JPanel();

    private JLabel logLabelGP;
    private JLabel logLabelKC;

    private List<JPanel> slots = new ArrayList<>();

    private Boss panelBoss;

    private ItemManager itemManager;

    BossLogDropPanel(ItemManager itemManager, Boss boss)
    {
        panelBoss = boss;
        this.itemManager = itemManager;
        setLayout(new DynamicGridLayout(0, 1, 0, 5));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setBorder(new EmptyBorder(5, 0, 5, 0));

        //uniques
        JPanel uniqueMainContainer = new JPanel();
        uniqueMainContainer.setLayout(new BorderLayout(0, 2));
        add(uniqueMainContainer);

        JPanel uniqueTextContainer = new JPanel();
        uniqueTextContainer.setBorder(new EmptyBorder(4,4,4,4));
        uniqueTextContainer.setBackground(new Color(24, 24, 24));
        uniqueTextContainer.setLayout(new BorderLayout());

        JLabel uniqueLabel = new JLabel();
        uniqueLabel.setForeground(Color.WHITE);
        uniqueLabel.setFont(FontManager.getRunescapeFont());
        uniqueLabel.setText("Uniques");
        uniqueTextContainer.add(uniqueLabel, BorderLayout.WEST);
        uniqueMainContainer.add(uniqueTextContainer, BorderLayout.NORTH);

        uniqueContainer.setLayout(new GridLayout(0, 5, 1, 1));

        uniqueMainContainer.add(uniqueContainer, BorderLayout.CENTER);

        //regular drops
        JPanel logMainContainer = new JPanel();
        logMainContainer.setLayout(new BorderLayout(0, 2));
        add(logMainContainer);

        JPanel logTextContainer = new JPanel();
        logTextContainer.setLayout(new BorderLayout());
        logTextContainer.setBorder(new EmptyBorder(4,4,4,4));
        logTextContainer.setBackground(new Color(24, 24, 24));
        logMainContainer.add(logTextContainer, BorderLayout.NORTH);

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

        logContainer.setLayout(new GridLayout(0, 5, 1, 1));
        logContainer.setBorder(new EmptyBorder(0,0,0,0));
        logMainContainer.add(logContainer, BorderLayout.CENTER);
    }

    @Override
    public int getUpdateInterval()
    {
        return 50;
    }

    @Override
    public void update()
    {
        logLabelGP.setText(NumberFormat.getNumberInstance(Locale.US).format(panelBoss.getProfit()) + " gp");
        logLabelKC.setText("  (" + panelBoss.getKC() + " KC)");
        drawSlots();
    }

    void drawSlots() {
        //draw unique drops
        uniqueContainer.removeAll();
        for(int id : panelBoss.getBoss().getUniques())
        {
            boolean added = false;
            for(Item i : panelBoss.getDrops())
            {
                if(id == i.getId())
                {
                    uniqueContainer.add(new BossLogDropBox(itemManager, i, false));
                    added = true;
                    break;
                }
            }
            if(!added)
            {
                ItemComposition ic = itemManager.getItemComposition(id);
                uniqueContainer.add(new BossLogDropBox(itemManager, new Item(id, 0, ic.getName(), 0), true));
            }
        }

        //draw regular drops
        logContainer.removeAll();
        for(Item i : panelBoss.getDrops())
        {
            BossLogDropBox slot = new BossLogDropBox(itemManager, i, false);
            logContainer.add(slot);
            slots.add(slot);
        }
    }
}
