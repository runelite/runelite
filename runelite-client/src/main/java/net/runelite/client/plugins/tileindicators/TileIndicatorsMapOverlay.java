package net.runelite.client.plugins.tileindicators;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Stroke;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;

public class TileIndicatorsMapOverlay extends Overlay
{
	private final Client client;
	private final TileIndicatorsConfig config;

	@Inject
	private WorldMapOverlay worldMapOverlay;

	@Inject
	private TileIndicatorsMapOverlay(Client client, TileIndicatorsConfig config)
	{
		this.client = client;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.MANUAL);
		setPriority(PRIORITY_MED);
		drawAfterLayer(ComponentID.WORLD_MAP_MAPVIEW);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showOnWorldMap())
		{
			return null;
		}

		Widget worldMapView = client.getWidget(ComponentID.WORLD_MAP_MAPVIEW);
		if (worldMapView == null)
		{
			return null;
		}
		Rectangle bounds = worldMapView.getBounds();
		if (bounds == null)
		{
			return null;
		}
		graphics.setClip(worldMapOverlay.getWorldMapClipArea(bounds));

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

		WorldPoint location = WorldPoint.fromLocal(client, point);

		Point start = worldMapOverlay.mapWorldPointToGraphicsPoint(location);
		Point end = worldMapOverlay.mapWorldPointToGraphicsPoint(location.dx(1).dy(1));

		int offset = ((int) client.getWorldMap().getWorldMapZoom()) / 2;

		Polygon poly = new Polygon();
		poly.addPoint(start.getX() - offset, start.getY() + offset);
		poly.addPoint(start.getX() - offset, end.getY() + offset);
		poly.addPoint(end.getX() - offset, end.getY() + offset);
		poly.addPoint(end.getX() - offset, start.getY() + offset);

		Stroke stroke = new BasicStroke(1f);
		graphics.setStroke(stroke);
		graphics.setColor(color);
		graphics.drawPolygon(poly);
		graphics.setColor(fillColor);
		graphics.fillPolygon(poly);
	}
}
