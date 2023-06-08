package net.runelite.client.plugins.groundmarkers;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;

public class GroundMarkerWorldmapOverlay extends Overlay
{
	private final Client client;
	private final GroundMarkerConfig config;
	private final GroundMarkerPlugin plugin;
	private final WorldMapOverlay worldMapOverlay;

	@Inject
	GroundMarkerWorldmapOverlay(Client client, GroundMarkerConfig config, GroundMarkerPlugin plugin, WorldMapOverlay worldMapOverlay)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		this.worldMapOverlay = worldMapOverlay;

		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.MANUAL);
		drawAfterLayer(WidgetInfo.WORLD_MAP_VIEW);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.drawTileOnWorldmap())
		{
			drawWorldMap(graphics);
		}

		return null;
	}

	private void drawWorldMap(Graphics2D graphics)
	{
		final Widget worldMapView = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
		if (worldMapView == null)
		{
			return;
		}

		final Rectangle bounds = worldMapView.getBounds();
		if (bounds == null)
		{
			return;
		}

		graphics.setClip(worldMapOverlay.getWorldMapClipArea(bounds));

		for (ColorTileMarker marker : plugin.getPoints())
		{
			drawTile(graphics, marker.getWorldPoint(), marker.getColor());
		}
	}

	private void drawTile(Graphics2D graphics, WorldPoint point, Color color)
	{
		final Point start = worldMapOverlay.mapWorldPointToGraphicsPoint(point);
		final Point end = worldMapOverlay.mapWorldPointToGraphicsPoint(point.dx(1).dy(-1));

		if (start == null || end == null)
		{
			return;
		}

		int x = start.getX();
		int y = start.getY();
		final int width = end.getX() - x;
		final int height = end.getY() - y;
		x -= width / 2;
		y -= height / 2;

		graphics.setColor(color);
		graphics.drawRect(x, y, width, height);
	}
}
