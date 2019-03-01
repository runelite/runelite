package net.runelite.client.plugins.massdigger;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.geometry.Geometry;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class MassDiggerOverlay extends Overlay
{
	private final Client client;
	private final MassDiggerConfig config;
	private final MassDiggerPlugin plugin;

	@Inject
	private MassDiggerOverlay(Client client, MassDiggerConfig config, MassDiggerPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.LOW);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showDigLocations())
		{
			renderDigLocations(graphics);
		}
		if (config.showDugAreas())
		{
			renderDugArea(graphics);
		}

		return null;
	}

	private int getAlpha()
	{
		return Math.min(255, Math.max(0, config.alpha()));
	}

	private void renderDigLocations(Graphics2D graphics)
	{
		for (WorldPointMarker wpm : plugin.getSceneDigMarkers())
		{
			LocalPoint lp = LocalPoint.fromWorld(client, new WorldPoint(wpm.getX(), wpm.getY(), wpm.getZ()));
			if (lp == null)
			{
				continue;
			}

			Polygon poly = Perspective.getCanvasTilePoly(client, lp);
			if (poly == null)
			{
				continue;
			}

			Color color = new Color(wpm.getColor());
			color = new Color(color.getRed(), color.getGreen(), color.getBlue(), getAlpha());
			OverlayUtil.renderPolygon(graphics, poly, color);
		}
	}

	private void renderDugArea(Graphics2D graphics)
	{
		GeneralPath path = plugin.getDugPath();
		if (path == null)
		{
			return;
		}

		path = Geometry.transformPath(path, coords ->
		{
			coords[0] = (coords[0] - client.getBaseX()) * Perspective.LOCAL_TILE_SIZE;
			coords[1] = (coords[1] - client.getBaseY()) * Perspective.LOCAL_TILE_SIZE;
		});
		path = Geometry.splitIntoSegments(path, 1);
		path = Geometry.filterPath(path, (p1, p2) ->
			Perspective.localToCanvas(client, new LocalPoint((int)p1[0], (int)p1[1]), client.getPlane()) != null &&
				Perspective.localToCanvas(client, new LocalPoint((int)p2[0], (int)p2[1]), client.getPlane()) != null);
		path = Geometry.transformPath(path, coords ->
		{
			Point point = Perspective.localToCanvas(client, new LocalPoint((int)coords[0], (int)coords[1]), client.getPlane());
			coords[0] = point.getX();
			coords[1] = point.getY();
		});

		graphics.setStroke(new BasicStroke(4));
		graphics.setColor(new Color(255, 0, 255, getAlpha()));
		graphics.draw(path);
	}
}
