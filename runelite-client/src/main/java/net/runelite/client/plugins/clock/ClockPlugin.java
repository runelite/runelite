package net.runelite.client.plugins.clock;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Clock",
	description = "Displays a real-time clock",
	tags = {"clock", "time"}
)
public class ClockPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ClockConfig config;

	@Inject
	private ClockOverlay overlay;

	@Provides
	ClockConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClockConfig.class);
	}

	@Override
	public void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	public void shutDown()
	{
		overlayManager.remove(overlay);
	}
}