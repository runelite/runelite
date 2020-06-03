package net.runelite.client.plugins.metronome;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import java.awt.*;

public class MetronomeOverlay extends Overlay
{
	@Inject
	private Client client;

	@Inject
	private MetronomePluginConfiguration config;

	@Inject
	private MetronomePlugin metr;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.enableVisualCue() || config.tickCount() == 0) return null;

		Player p = client.getLocalPlayer();
		Shape playerShape = p.getConvexHull();

		if (config.tickCount() == 1)
		{
			if (metr.getIsCurrentColorGreen())
			{
				graphics.setColor(Color.red);
			}
			else
			{
				graphics.setColor(Color.green);
			}

			graphics.draw(playerShape);

			return null;
		}

		if (metr.getTickCounter() % config.tickCount() == 0)
		{
			graphics.setColor(Color.green);
		}
		else
		{
			graphics.setColor(Color.red);
		}

		graphics.draw(playerShape);

		return null;
	}
}
