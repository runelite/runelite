package net.runelite.client.plugins.bosslog;

import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BossLogOverviewPanel extends TabContentPanel
{
    BossLogOverviewPanel(ItemManager itemManager) {
        setLayout(new DynamicGridLayout(0, 1, 0, 5));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setBorder(new EmptyBorder(5, 0, 5, 0));
    }

    @Override
    public int getUpdateInterval() {
        return 0;
    }

    @Override
    public void update() {

    }
}
