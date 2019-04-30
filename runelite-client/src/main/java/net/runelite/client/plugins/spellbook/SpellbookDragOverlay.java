package net.runelite.client.plugins.spellbook;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class SpellbookDragOverlay extends Overlay
{
	private SpellbookPlugin plugin;
	private Client client;
	private SpriteManager spriteManager;

	@Inject
	private SpellbookDragOverlay(SpellbookPlugin plugin, Client client, SpriteManager spriteManager)
	{
		this.plugin = plugin;
		this.client = client;
		this.spriteManager = spriteManager;
		setPosition(OverlayPosition.TOOLTIP);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		if (!plugin.isDragging())
		{
			return null;
		}

		final net.runelite.api.Point mouseCanvasPosition = client.getMouseCanvasPosition();
		final net.runelite.api.Point draggingLocation = plugin.getDraggingLocation();

		final int size = plugin.getDraggingWidget().getWidth();
		final int sprite = plugin.getDraggingWidget().getSpriteId();
		final BufferedImage image = spriteManager.getSprite(sprite, 0);

		final Point mousePosition = new Point(mouseCanvasPosition.getX() - draggingLocation.getX(), mouseCanvasPosition.getY() - draggingLocation.getY());
		final Rectangle bounds = new Rectangle(mousePosition.x, mousePosition.y, size, size);

		g.drawImage(image, mousePosition.x, mousePosition.y, size, size, null);

		return bounds.getSize();
	}
}
