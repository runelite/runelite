package net.runelite.client.plugins.tileindicators;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class TileIndicatorsMinimapOverlay extends Overlay
{
	private final Client client;
	private final TileIndicatorsConfig config;

	@Inject
	private TileIndicatorsMinimapOverlay(Client client, TileIndicatorsConfig config)
	{
		this.client = client;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(PRIORITY_MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showOnMinimap())
		{
			return null;
		}

		if (config.highlightDestinationTile())
		{
			renderTile(graphics, client.getLocalDestinationLocation(), config.highlightDestinationColor(), config.destinationTileFillColor());
		}

		if (config.highlightCurrentTile())
		{
			final WorldPoint playerPos = client.getLocalPlayer().getWorldLocation();
			if (playerPos == null)
			{
				return null;
			}

			final LocalPoint playerPosLocal = LocalPoint.fromWorld(client, playerPos);
			if (playerPosLocal == null)
			{
				return null;
			}

			renderTile(graphics, playerPosLocal, config.highlightCurrentColor(), config.currentTileFillColor());
		}

		return null;
	}

	private void renderTile(Graphics2D graphics, LocalPoint point, Color color, Color fillColor)
	{
		if (point == null)
		{
			return;
		}

		int offset = Perspective.LOCAL_HALF_TILE_SIZE;
		point = point.dx(-offset).dy(-offset);

		Point mp1 = Perspective.localToMinimap(client, point);
		Point mp2 = Perspective.localToMinimap(client, point.dy(Perspective.LOCAL_TILE_SIZE));
		Point mp3 = Perspective.localToMinimap(client, point.dx(Perspective.LOCAL_TILE_SIZE).dy(Perspective.LOCAL_TILE_SIZE));
		Point mp4 = Perspective.localToMinimap(client, point.dx(Perspective.LOCAL_TILE_SIZE));

		if (mp1 == null || mp2 == null || mp3 == null || mp4 == null)
		{
			return;
		}

		Polygon poly = new Polygon();
		poly.addPoint(mp1.getX(), mp1.getY());
		poly.addPoint(mp2.getX(), mp2.getY());
		poly.addPoint(mp3.getX(), mp3.getY());
		poly.addPoint(mp4.getX(), mp4.getY());

		Stroke stroke = new BasicStroke(1f);
		graphics.setStroke(stroke);
		graphics.setColor(color);
		graphics.drawPolygon(poly);
		graphics.setColor(fillColor);
		graphics.fillPolygon(poly);
	}
}
