package net.runelite.client.plugins.antidrag;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class AntiDragOverlay extends Overlay
{
	private static final int RADIUS = 20;

	private Client client;
	private AntiDragConfig config;

	@Inject
	private AntiDragOverlay(Client client, AntiDragConfig config)
	{
		this.config = config;
		this.client = client;
		setPosition(OverlayPosition.TOOLTIP);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		final Color color = config.color();
		g.setColor(color);

		final net.runelite.api.Point mouseCanvasPosition = client.getMouseCanvasPosition();
		final Point mousePosition = new Point(mouseCanvasPosition.getX() - RADIUS, mouseCanvasPosition.getY() - RADIUS);
		final Rectangle bounds = new Rectangle(mousePosition.x, mousePosition.y, 2 * RADIUS, 2 * RADIUS);
		g.fillOval(bounds.x, bounds.y, bounds.height, bounds.width);

		return bounds.getSize();
	}
}
