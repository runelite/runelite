package net.runelite.client.plugins.bosslog;

import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.bosslog.enums.Bosses;
import net.runelite.client.ui.ColorScheme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class BossLogOverviewPanel extends BossLogPanelView
{
	private final ItemManager itemManager;

	BossLogOverviewPanel(ItemManager itemManager, BossLogPanel bossLogPanel)
	{
		this.itemManager = itemManager;
		setLayout(new GridLayout(0, 1, 0, 5));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(5, 0, 5, 5));

		for (Bosses b : Bosses.class.getEnumConstants())
			add(new BossLogSelector(b.getTab(), itemManager, bossLogPanel));
	}

	@Override
	void update()
	{

	}
}
