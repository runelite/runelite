package net.runelite.client.ui.overlay;

import java.awt.image.BufferedImage;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;

public class OverlayRenderer
{
	public void render(BufferedImage clientBuffer)
	{
		TopDownRenderer td = new TopDownRenderer();

		for (Plugin plugin : RuneLite.getRunelite().getPluginManager().getPlugins())
		{
			Overlay overlay = plugin.getOverlay();

			if (overlay.getPosition() == OverlayPosition.TOP_LEFT)
				td.add(overlay);
		}

		td.render(clientBuffer);
	}
}
