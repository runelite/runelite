package net.runelite.client.plugins.regenmeter;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
		name = "Regeneration Meter"
)

public class RegenMeterPlugin extends Plugin
{

	@Inject
	private RegenMeterOverlay overlay;

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onTick(GameTick tick)
	{
		overlay.onTick();
	}
}
