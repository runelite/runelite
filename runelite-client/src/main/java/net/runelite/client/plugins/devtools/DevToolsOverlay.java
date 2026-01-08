/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.devtools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.Arrays;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Animation;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.DecorativeObject;
import net.runelite.api.DynamicObject;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.ItemLayer;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Node;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileObject;
import net.runelite.api.WorldEntity;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

@Singleton
class DevToolsOverlay extends Overlay
{
	private static final Font FONT = FontManager.getRunescapeFont().deriveFont(Font.BOLD, 16);
	private static final Color RED = new Color(221, 44, 0);
	private static final Color GREEN = new Color(0, 200, 83);
	private static final Color ORANGE = new Color(255, 109, 0);
	private static final Color YELLOW = new Color(255, 214, 0);
	private static final Color CYAN = new Color(0, 184, 212);
	private static final Color BLUE = new Color(41, 98, 255);
	private static final Color DEEP_PURPLE = new Color(98, 0, 234);
	private static final Color PURPLE = new Color(170, 0, 255);
	private static final Color GRAY = new Color(158, 158, 158);

	private final Client client;
	private final DevToolsPlugin plugin;
	private final TooltipManager toolTipManager;

	@Inject
	private DevToolsOverlay(Client client, DevToolsPlugin plugin, TooltipManager toolTipManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(PRIORITY_HIGHEST);
		this.client = client;
		this.plugin = plugin;
		this.toolTipManager = toolTipManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		WorldView tlwv = client.getTopLevelWorldView();
		WorldView playerWv = client.getLocalPlayer().getWorldView();

		graphics.setFont(FONT);

		if (plugin.getPlayers().isActive())
		{
			renderPlayers(tlwv, graphics);
			if (playerWv != tlwv)
			{
				renderPlayers(playerWv, graphics);
			}
		}

		if (plugin.getNpcs().isActive())
		{
			renderNpcs(tlwv, graphics);
			if (playerWv != tlwv)
			{
				renderNpcs(playerWv, graphics);
			}
		}

		if (plugin.getGroundItems().isActive() || plugin.getGroundObjects().isActive() || plugin.getGameObjects().isActive() || plugin.getWalls().isActive() || plugin.getDecorations().isActive() || plugin.getTileLocation().isActive() || plugin.getMovementFlags().isActive())
		{
			renderTileObjects(tlwv, graphics);
			if (playerWv != tlwv)
			{
				renderTileObjects(playerWv, graphics);
			}
		}

		if (plugin.getProjectiles().isActive())
		{
			// projectiles are not partitioned by worldview
			renderProjectiles(graphics);
		}

		if (plugin.getGraphicsObjects().isActive())
		{
			renderGraphicsObjects(tlwv, graphics);
			if (playerWv != tlwv)
			{
				renderGraphicsObjects(playerWv, graphics);
			}
		}

		if (plugin.getTileFlags().isActive())
		{
			renderTileFlags(tlwv, graphics);
			if (playerWv != tlwv)
			{
				renderTileFlags(playerWv, graphics);
			}
		}

		if (plugin.getWorldEntities().isActive())
		{
			renderWorldEntities(graphics);
		}

		return null;
	}

	private void renderTileFlags(WorldView wv, Graphics2D graphics)
	{
		byte[][][] settings = wv.getTileSettings();
		int z = wv.getPlane();

		for (int x = 0; x < Constants.SCENE_SIZE; ++x)
		{
			for (int y = 0; y < Constants.SCENE_SIZE; ++y)
			{
				boolean isbridge = (settings[1][x][y] & Constants.TILE_FLAG_BRIDGE) != 0;
				int flag = settings[z][x][y];
				boolean isvisbelow = (flag & Constants.TILE_FLAG_VIS_BELOW) != 0;
				boolean hasroof = (flag & Constants.TILE_FLAG_UNDER_ROOF) != 0;
				if (!isbridge && !isvisbelow && !hasroof)
				{
					continue;
				}

				String s = "";
				if (isbridge)
				{
					s += "B";
				}
				if (isvisbelow)
				{
					s += "V";
				}
				if (hasroof)
				{
					s += "R";
				}

				LocalPoint lp = new LocalPoint(x << Perspective.LOCAL_COORD_BITS, y << Perspective.LOCAL_COORD_BITS, wv);
				Point loc = Perspective.getCanvasTextLocation(client, graphics, lp, s, z);
				if (loc == null)
				{
					continue;
				}

				OverlayUtil.renderTextLocation(graphics, loc, s, Color.RED);
			}
		}
	}

	private void renderPlayers(WorldView wv, Graphics2D graphics)
	{
		Player local = client.getLocalPlayer();

		for (Player p : wv.players())
		{
			if (p != local)
			{
				String text = p.getName() + " (A: " + p.getAnimation() + ") (P: " + p.getPoseAnimation() + ") (G: " + p.getGraphic() + ")";
				OverlayUtil.renderActorOverlay(graphics, p, text, BLUE);
			}
		}

		String text = local.getName() + " (A: " + local.getAnimation() + ") (P: " + local.getPoseAnimation() + ") (G: " + local.getGraphic() + ")";
		OverlayUtil.renderActorOverlay(graphics, local, text, CYAN);
	}

	private void renderNpcs(WorldView wv, Graphics2D graphics)
	{
		for (NPC npc : wv.npcs())
		{
			NPCComposition composition = npc.getComposition();
			Color color = composition.getCombatLevel() > 1 ? YELLOW : ORANGE;
			if (composition.getConfigs() != null)
			{
				NPCComposition transformedComposition = composition.transform();
				if (transformedComposition == null)
				{
					color = GRAY;
				}
				else
				{
					composition = transformedComposition;
				}
			}

			String text = composition.getName() + " (ID:" + composition.getId() + ")" +
				" (A: " + npc.getAnimation() + ") (P: " + npc.getPoseAnimation() + ") (G: " + npc.getGraphic() + ")";
			if (npc.getModelOverrides() != null)
			{
				var mo = npc.getModelOverrides();
				if (mo.getModelIds() != null)
				{
					text += " (M: " + Arrays.toString(mo.getModelIds()) + ")";
				}
				if (mo.getColorToReplaceWith() != null)
				{
					text += " (C: " + Arrays.toString(mo.getColorToReplaceWith()) + ")";
				}
				if (mo.getTextureToReplaceWith() != null)
				{
					text += " (T: " + Arrays.toString(mo.getTextureToReplaceWith()) + ")";
				}
				if (mo.useLocalPlayer())
				{
					text += " (LocalPlayer)";
				}
			}
			OverlayUtil.renderActorOverlay(graphics, npc, text, color);
		}
	}

	private void renderTileObjects(WorldView wv, Graphics2D graphics)
	{
		Scene scene = wv.getScene();
		Tile[][][] tiles = scene.getTiles();

		int z = wv.getPlane();

		for (int x = 0; x < tiles[z].length; ++x)
		{
			for (int y = 0; y < tiles[z][x].length; ++y)
			{
				Tile tile = tiles[z][x][y];

				if (tile == null)
				{
					continue;
				}

				if (plugin.getGroundItems().isActive())
				{
					renderGroundItems(graphics, tile);
				}

				if (plugin.getGroundObjects().isActive())
				{
					renderTileObject(graphics, tile.getGroundObject(), PURPLE);
				}

				if (plugin.getGameObjects().isActive())
				{
					renderGameObjects(graphics, tile);
				}

				if (plugin.getWalls().isActive())
				{
					renderTileObject(graphics, tile.getWallObject(), GRAY);
				}

				if (plugin.getDecorations().isActive())
				{
					renderDecorObject(graphics, tile);
				}

				if (plugin.getTileLocation().isActive())
				{
					renderTileTooltip(graphics, tile);
				}

				if (plugin.getMovementFlags().isActive())
				{
					renderMovementInfo(graphics, tile);
				}
			}
		}
	}

	private void renderTileTooltip(Graphics2D graphics, Tile tile)
	{
		final LocalPoint tileLocalLocation = tile.getLocalLocation();
		Polygon poly = Perspective.getCanvasTilePoly(client, tileLocalLocation);
		if (poly != null && poly.contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY()))
		{
			WorldPoint worldLocation = WorldPoint.fromLocalInstance(client, tileLocalLocation);
			byte flags = client.getTileSettings()[tile.getRenderLevel()][tile.getSceneLocation().getX()][tile.getSceneLocation().getY()];
			String tooltip = String.format("World location: %d, %d, %d<br>" +
					"Region ID: %d location: %d, %d<br>" +
					"Flags: %d",
				worldLocation.getX(), worldLocation.getY(), worldLocation.getPlane(),
				worldLocation.getRegionID(), worldLocation.getRegionX(), worldLocation.getRegionY(),
				flags);
			toolTipManager.add(new Tooltip(tooltip));
			OverlayUtil.renderPolygon(graphics, poly, GREEN);
		}
	}

	private void renderMovementInfo(Graphics2D graphics, Tile tile)
	{
		Polygon poly = Perspective.getCanvasTilePoly(client, tile.getLocalLocation());

		if (poly == null || !poly.contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY()))
		{
			return;
		}

		if (client.getCollisionMaps() != null)
		{
			int[][] flags = client.getCollisionMaps()[client.getPlane()].getFlags();
			int data = flags[tile.getSceneLocation().getX()][tile.getSceneLocation().getY()];

			Set<MovementFlag> movementFlags = MovementFlag.getSetFlags(data);

			if (movementFlags.isEmpty())
			{
				toolTipManager.add(new Tooltip("No movement flags"));
			}
			else
			{
				movementFlags.forEach(flag -> toolTipManager.add(new Tooltip(flag.toString())));
			}

			OverlayUtil.renderPolygon(graphics, poly, GREEN);
		}
	}

	private void renderGroundItems(Graphics2D graphics, Tile tile)
	{
		ItemLayer itemLayer = tile.getItemLayer();
		if (itemLayer != null)
		{
			Node current = itemLayer.getTop();
			while (current instanceof TileItem)
			{
				TileItem item = (TileItem) current;
				OverlayUtil.renderTileOverlay(graphics, itemLayer, "ID: " + item.getId() + " Qty:" + item.getQuantity(), RED);
				current = current.getNext();
			}
		}
	}

	private void renderGameObjects(Graphics2D graphics, Tile tile)
	{
		GameObject[] gameObjects = tile.getGameObjects();
		if (gameObjects != null)
		{
			for (GameObject gameObject : gameObjects)
			{
				if (gameObject != null && gameObject.getSceneMinLocation().equals(tile.getSceneLocation()))
				{
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("ID: ").append(gameObject.getId());
					if (gameObject.getRenderable() instanceof DynamicObject)
					{
						Animation animation = ((DynamicObject) gameObject.getRenderable()).getAnimation();
						if (animation != null)
						{
							stringBuilder.append(" A: ").append(animation.getId());
						}
					}

					OverlayUtil.renderTileOverlay(graphics, gameObject, stringBuilder.toString(), GREEN);
				}
			}
		}
	}

	private void renderTileObject(Graphics2D graphics, TileObject tileObject, Color color)
	{
		if (tileObject != null)
		{
			OverlayUtil.renderTileOverlay(graphics, tileObject, "ID: " + tileObject.getId(), color);
		}
	}

	private void renderDecorObject(Graphics2D graphics, Tile tile)
	{
		DecorativeObject decorObject = tile.getDecorativeObject();
		if (decorObject != null)
		{
			OverlayUtil.renderTileOverlay(graphics, decorObject, "ID: " + decorObject.getId(), DEEP_PURPLE);

			Shape p = decorObject.getConvexHull();
			if (p != null)
			{
				graphics.draw(p);
			}

			p = decorObject.getConvexHull2();
			if (p != null)
			{
				graphics.draw(p);
			}
		}
	}

	private void renderProjectiles(Graphics2D graphics)
	{
		for (Projectile projectile : client.getProjectiles())
		{
			int projectileId = projectile.getId();
			String text = "(ID: " + projectileId + ")";
			int x = (int) projectile.getX();
			int y = (int) projectile.getY();
			LocalPoint projectilePoint = new LocalPoint(x, y);
			Point textLocation = Perspective.getCanvasTextLocation(client, graphics, projectilePoint, text, 0);
			if (textLocation != null)
			{
				OverlayUtil.renderTextLocation(graphics, textLocation, text, Color.RED);
			}
		}
	}

	private void renderGraphicsObjects(WorldView wv, Graphics2D graphics)
	{
		for (GraphicsObject graphicsObject : wv.getGraphicsObjects())
		{
			LocalPoint lp = graphicsObject.getLocation();
			Polygon poly = Perspective.getCanvasTilePoly(client, lp);

			if (poly != null)
			{
				OverlayUtil.renderPolygon(graphics, poly, Color.MAGENTA);
			}

			String infoString = "(ID: " + graphicsObject.getId() + ")";
			Point textLocation = Perspective.getCanvasTextLocation(
				client, graphics, lp, infoString, 0);
			if (textLocation != null)
			{
				OverlayUtil.renderTextLocation(graphics, textLocation, infoString, Color.WHITE);
			}
		}
	}

	private void renderWorldEntities(Graphics2D graphics)
	{
		WorldView toplevel = client.getTopLevelWorldView();
		for (WorldEntity we : toplevel.worldEntities())
		{
			if (we.isHiddenForOverlap())
			{
				continue;
			}

			LocalPoint location = we.getLocalLocation();
			String text = "ID: " + we.getWorldView().getId() + " Type: " + we.getConfig().getId();
			Point p = Perspective.getCanvasTextLocation(client, graphics, location, text, 0);
			if (p != null)
			{
				OverlayUtil.renderTextLocation(graphics, p, text, Color.BLUE);
			}
		}
	}
}
