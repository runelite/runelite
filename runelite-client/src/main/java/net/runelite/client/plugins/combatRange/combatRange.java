package net.runelite.client.plugins.combatRange;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;


@PluginDescriptor(
	name = "Combat Range",
	description = "Shows the combat range that can attack you in the wilderness.",
	tags = {"wildy", "wilderness", "combat", "level"},
	enabledByDefault = true
)

public class combatRange extends Plugin
{

	@Inject
	private combatRangeOverlay combatRangeOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Provides
	combatRangeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(combatRangeConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(combatRangeOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(combatRangeOverlay);
	}


}