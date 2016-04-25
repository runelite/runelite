package net.runelite.client.plugins.opponentinfo;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

public class OpponentInfo extends Plugin
{
	private final Overlay overlay = new OpponentInfoOverlay();

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}
}
