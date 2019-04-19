package net.runelite.client.plugins.cox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class CoxOverlayAbove extends Overlay
{
	private final Client client;
	private final CoxPlugin plugin;
	private CoxConfig config;

	@Inject
	public CoxOverlayAbove(Client client, CoxPlugin plugin, CoxConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!client.isInInstancedRegion() && plugin.getOlm() == null) return null;

		renderGroundObject(graphics);

		renderTileObjects(graphics);

		return null;
	}

	// renders special attack ground objects
	private void renderGroundObject(Graphics2D graphics)
	{
		List<GraphicsObject> graphicsObjects = client.getGraphicsObjects();

		for (GraphicsObject graphicsObject : graphicsObjects)
		{
			if (graphicsObject.getId() == 1447 || graphicsObject.getId() == 1356)
			{
				LocalPoint lp = graphicsObject.getLocation();
				Polygon poly = Perspective.getCanvasTilePoly(client, lp);

				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, Color.RED);
				}
			}
		}
	}

	private void renderGameObjects(Graphics2D graphics, Tile tile, Player player)
	{
		GameObject[] gameObjects = tile.getGameObjects();
		if (gameObjects != null)
		{
			for (GameObject gameObject : gameObjects)
			{
				if (gameObject != null && gameObject.getId() == 30033)
				{
					if (player.getLocalLocation().distanceTo(gameObject.getLocalLocation()) <= 5)
					{
						// Draw a polygon around the convex hull
						// of the model vertices
						Polygon p = gameObject.getConvexHull();
						if (p != null)
						{
							graphics.drawPolygon(p);
						}
					}
				}
			}
		}
	}

	private void renderTileObjects(Graphics2D graphics)
	{
		Scene scene = client.getScene();
		Tile[][][] tiles = scene.getTiles();

		int z = client.getPlane();

		for (int x = 0; x < Constants.SCENE_SIZE; ++x)
		{
			for (int y = 0; y < Constants.SCENE_SIZE; ++y)
			{
				Tile tile = tiles[z][x][y];

				if (tile == null)
				{
					continue;
				}

				Player player = client.getLocalPlayer();
				if (player == null)
				{
					continue;
				}

				renderGameObjects(graphics, tile, player);
			}
		}
	}
}

