package net.runelite.client.plugins.dailytaskindicators.infoboxes;

import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.dailytaskindicators.DailyTasksConfig;
import net.runelite.client.plugins.dailytaskindicators.DailyTasksPlugin;

public class Sand extends DailyInfoBox
{
	public Sand(final int itemId, final String tooltip, final ItemManager itemManager, final DailyTasksConfig config, final DailyTasksPlugin plugin)
	{
		super(itemId, tooltip, itemManager, config, plugin);
	}

	@Override
	public boolean render()
	{
		return plugin.sandAvailable();
	}
}
