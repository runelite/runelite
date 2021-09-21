package net.runelite.client.plugins.dailytaskindicators.infoboxes;

import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.dailytaskindicators.DailyTasksConfig;
import net.runelite.client.plugins.dailytaskindicators.DailyTasksPlugin;
import net.runelite.client.ui.overlay.infobox.InfoBox;

import java.awt.*;

public abstract class DailyInfoBox extends InfoBox
{
	protected DailyTasksPlugin plugin;
	protected DailyTasksConfig config;

	public DailyInfoBox(final int itemId, final String tooltip, final ItemManager itemManager, final DailyTasksConfig config, final DailyTasksPlugin plugin)
	{
		super(itemManager.getImage(itemId), plugin);
		this.plugin = plugin;
		this.config = config;
		setTooltip(tooltip);
	}

	@Override
	public String getText()
	{
		return null;
	}

	@Override
	public Color getTextColor()
	{
		return null;
	}

	@Override
	public abstract boolean render();
}
