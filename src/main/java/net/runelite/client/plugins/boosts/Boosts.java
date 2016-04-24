package net.runelite.client.plugins.boosts;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

public class Boosts extends Plugin
{
	private final Overlay overlay = new BoostsOverlay();

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}
}
