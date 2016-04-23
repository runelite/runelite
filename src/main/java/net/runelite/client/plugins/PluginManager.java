package net.runelite.client.plugins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.runelite.client.plugins.opponentinfo.OpponentInfo;

public class PluginManager
{
	private final List<Plugin> plugins = new ArrayList<>();

	public void loadAll()
	{
		plugins.add(new OpponentInfo());
	}

	public Collection<Plugin> getPlugins()
	{
		return plugins;
	}
}
