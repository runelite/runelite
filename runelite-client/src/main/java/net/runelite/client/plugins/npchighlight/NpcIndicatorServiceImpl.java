package net.runelite.client.plugins.npchighlight;

import javax.inject.Inject;

public class NpcIndicatorServiceImpl implements NpcIndicatorService
{
	private final NpcIndicatorsPlugin plugin;

	@Inject
	NpcIndicatorServiceImpl(NpcIndicatorsPlugin plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public NpcIndicatorsPlugin plugin()
	{
		return plugin;
	}

	@Override
	public NpcIndicatorsConfig config()
	{
		return plugin.getConfig();
	}
}
