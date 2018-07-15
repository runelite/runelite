package net.runelite.client.plugins.grotesqueguardians;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Grotesque Guardians",
	description = "Configure settings for Grotesque Guardians",
	tags = {"grotesque", "guardians", "gargoyle", "garg"},
	enabledByDefault = true
)
public class GrotesqueGuardiansPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private GrotesqueGuardiansOverlay overlay;

	@Provides
	GrotesqueGuardiansConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GrotesqueGuardiansConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}
}
