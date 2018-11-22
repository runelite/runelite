package net.runelite.client.plugins.bosslog;

import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;

import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

class BossLogOverviewPanel extends BossLogPanelView
{
	BossLogOverviewPanel(ItemManager itemManager, BossLogPanel bossLogPanel)
	{
		setLayout(new GridLayout(0, 1, 0, 5));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(5, 0, 5, 5));

		for (Boss b : bossLogPanel.plugin.bosses)
			add(new BossLogSelector(b.getBoss().getTab(), itemManager, bossLogPanel));
	}

	@Override
	void update()
	{

	}
}
