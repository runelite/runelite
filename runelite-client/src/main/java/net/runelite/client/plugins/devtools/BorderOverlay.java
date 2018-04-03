package net.runelite.client.plugins.devtools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class BorderOverlay extends Overlay
{
	private static final Color GREEN = Color.GREEN;
	private static final Color BLUE = Color.BLUE;

	private final Client client;
	private final DevToolsPlugin plugin;

	@Inject
	public BorderOverlay(Client client, DevToolsPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isToggleChunkBorders())
		{
			renderChunkBorders(graphics);
		}

		if (plugin.isToggleMapSquares())
		{
			renderMapSquares(graphics);
		}

		return null;
	}

	private void renderChunkBorders(Graphics2D graphics)
	{
		final int LOCAL_TILE_SIZE = Perspective.LOCAL_TILE_SIZE;
		final int CHUNK_SIZE = 8;
		final int CULL_RANGE = 16;
		final int STROKE_WIDTH = 4;

		WorldPoint wp = client.getLocalPlayer().getWorldLocation();
		int startX = (wp.getX() - CULL_RANGE + CHUNK_SIZE - 1) / CHUNK_SIZE * CHUNK_SIZE;
		int startY = (wp.getY() - CULL_RANGE + CHUNK_SIZE - 1) / CHUNK_SIZE * CHUNK_SIZE;
		int endX = (wp.getX() + CULL_RANGE) / CHUNK_SIZE * CHUNK_SIZE;
		int endY = (wp.getY() + CULL_RANGE) / CHUNK_SIZE * CHUNK_SIZE;

		graphics.setStroke(new BasicStroke(STROKE_WIDTH));
		graphics.setColor(BLUE);

		GeneralPath path = new GeneralPath();
		for (int x = startX; x <= endX; x += CHUNK_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, x, wp.getY() - CULL_RANGE);
			LocalPoint lp2 = LocalPoint.fromWorld(client, x, wp.getY() + CULL_RANGE);

			boolean first = true;
			for (int y = lp1.getY(); y <= lp2.getY(); y += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.worldToCanvas(client,
					lp1.getX() - LOCAL_TILE_SIZE / 2,
					y - LOCAL_TILE_SIZE / 2,
					client.getPlane());
				if (p != null)
				{
					if (first)
					{
						path.moveTo(p.getX(), p.getY());
						first = false;
					}
					else
					{
						path.lineTo(p.getX(), p.getY());
					}
				}
			}
		}
		for (int y = startY; y <= endY; y += CHUNK_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, wp.getX() - CULL_RANGE, y);
			LocalPoint lp2 = LocalPoint.fromWorld(client, wp.getX() + CULL_RANGE, y);

			boolean first = true;
			for (int x = lp1.getX(); x <= lp2.getX(); x += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.worldToCanvas(client,
					x - LOCAL_TILE_SIZE / 2,
					lp1.getY() - LOCAL_TILE_SIZE / 2,
					client.getPlane());
				if (p != null)
				{
					if (first)
					{
						path.moveTo(p.getX(), p.getY());
						first = false;
					}
					else
					{
						path.lineTo(p.getX(), p.getY());
					}
				}
			}
		}
		graphics.draw(path);
	}

	private void renderMapSquares(Graphics2D graphics)
	{
		final int LOCAL_TILE_SIZE = Perspective.LOCAL_TILE_SIZE;
		final int MAP_SQUARE_SIZE = 64;
		final int CULL_RANGE = 16;
		final int STROKE_WIDTH = 4;

		WorldPoint wp = client.getLocalPlayer().getWorldLocation();
		int startX = (wp.getX() - CULL_RANGE + MAP_SQUARE_SIZE - 1) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int startY = (wp.getY() - CULL_RANGE + MAP_SQUARE_SIZE - 1) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int endX = (wp.getX() + CULL_RANGE) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int endY = (wp.getY() + CULL_RANGE) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;

		graphics.setStroke(new BasicStroke(STROKE_WIDTH));
		graphics.setColor(GREEN);

		GeneralPath path = new GeneralPath();
		for (int x = startX; x <= endX; x += MAP_SQUARE_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, x, wp.getY() - CULL_RANGE);
			LocalPoint lp2 = LocalPoint.fromWorld(client, x, wp.getY() + CULL_RANGE);

			boolean first = true;
			for (int y = lp1.getY(); y <= lp2.getY(); y += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.worldToCanvas(client,
					lp1.getX() - LOCAL_TILE_SIZE / 2,
					y - LOCAL_TILE_SIZE / 2,
					client.getPlane());
				if (p != null)
				{
					if (first)
					{
						path.moveTo(p.getX(), p.getY());
						first = false;
					}
					else
					{
						path.lineTo(p.getX(), p.getY());
					}
				}
			}
		}
		for (int y = startY; y <= endY; y += MAP_SQUARE_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, wp.getX() - CULL_RANGE, y);
			LocalPoint lp2 = LocalPoint.fromWorld(client, wp.getX() + CULL_RANGE, y);

			boolean first = true;
			for (int x = lp1.getX(); x <= lp2.getX(); x += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.worldToCanvas(client,
					x - LOCAL_TILE_SIZE / 2,
					lp1.getY() - LOCAL_TILE_SIZE / 2,
					client.getPlane());
				if (p != null)
				{
					if (first)
					{
						path.moveTo(p.getX(), p.getY());
						first = false;
					}
					else
					{
						path.lineTo(p.getX(), p.getY());
					}
				}
			}
		}
		graphics.draw(path);
	}

}
