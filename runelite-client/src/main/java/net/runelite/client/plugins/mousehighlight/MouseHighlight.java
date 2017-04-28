package net.runelite.client.plugins.mousehighlight;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

/**
 * Created by aria on 4/27/17.
 */
public class MouseHighlight extends Plugin
{
	private final Overlay overlay = new MouseHighlightOverlay();

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	protected void startUp() throws Exception
	{

	}

	@Override
	protected void shutDown() throws Exception
	{

	}
}
