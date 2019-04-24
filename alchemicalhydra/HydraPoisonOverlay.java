package net.runelite.client.plugins.alchemicalhydra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import static net.runelite.api.Perspective.getCanvasTileAreaPoly;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
class HydraPoisonOverlay extends Overlay
{
	private final HydraPlugin plugin;
	private final Client client;

	@Inject
	public HydraPoisonOverlay(Client client, HydraPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		this.plugin = plugin;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final HashSet<LocalPoint> initialPoints = plugin.getPoisonPoints();
		Area poisonTiles = new Area();
		for (LocalPoint point : initialPoints)
		{
			Polygon poly = getCanvasTileAreaPoly(client, point, 3);
			if (poly == null)
			{
				break;
			}

			poisonTiles.add(new Area(poly));
		}

		if (poisonTiles.isEmpty())
		{
			return null;
		}
		graphics.setPaintMode();
		graphics.setColor(new Color(255, 0, 0, 75));
		graphics.draw(poisonTiles);
		graphics.setColor(new Color(255, 0, 0, 30));
		graphics.fill(poisonTiles);

		return null;
	}
}