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

	boolean tick = true;

	private boolean shouldDisplayOverlay = false;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.enableVisualCue()) return null;

		Player p = client.getLocalPlayer();
		Shape playerShape = p.getConvexHull();

		if (!tick) graphics.setColor(Color.red);
		else graphics.setColor(Color.green);

		graphics.draw(playerShape);

		return null;
    }
}
