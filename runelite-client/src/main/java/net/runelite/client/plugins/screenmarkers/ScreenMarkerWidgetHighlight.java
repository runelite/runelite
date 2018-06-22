package net.runelite.client.plugins.screenmarkers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class ScreenMarkerWidgetHighlight extends Overlay
{

	private ScreenMarkerPlugin plugin;
	private Client client;

	@Inject
	private ScreenMarkerWidgetHighlight(final ScreenMarkerPlugin plugin, final Client client)
	{
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DETACHED);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isCreatingScreenMarker())
		{
			Point converted = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());
			WidgetItem hoverItem = plugin.findItemSlotContaining(converted);
			if (hoverItem != null)
			{
				graphics.setColor(Color.GREEN);
				graphics.draw(hoverItem.getCanvasBounds());
			}
			else
			{
				Widget hover = plugin.findSmallestWidgetContaining(converted);
				if (hover != null)
				{
					graphics.setColor(Color.GREEN);
					graphics.draw(hover.getBounds());
				}
			}
		}
		return null;
	}
}
