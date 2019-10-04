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
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.DecorativeObject;
import net.runelite.api.DynamicObject;
import net.runelite.api.Entity;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.GroundObject;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.Node;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileItemPile;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

@Singleton
class DevToolsOverlay extends Overlay
{
	private static final int ITEM_EMPTY = 6512;
	private static final int ITEM_FILLED = 20594;

	private static final Font FONT = FontManager.getRunescapeFont().deriveFont(Font.BOLD, 16);
	private static final Color RED = new Color(221, 44, 0);
	private static final Color GREEN = new Color(0, 200, 83);
	private static final Color TURQOISE = new Color(0, 200, 157);
	private static final Color ORANGE = new Color(255, 109, 0);
	private static final Color YELLOW = new Color(255, 214, 0);
	private static final Color CYAN = new Color(0, 184, 212);
	private static final Color BLUE = new Color(41, 98, 255);
	private static final Color DEEP_PURPLE = new Color(98, 0, 234);
	private static final Color PURPLE = new Color(170, 0, 255);
	private static final Color GRAY = new Color(158, 158, 158);

	private static final int MAX_DISTANCE = 2400;

	private final Client client;
	private final DevToolsPlugin plugin;
	private final TooltipManager toolTipManager;

	@Setter
	@Getter
	private Widget widget;

	@Setter
	private int itemIndex = -1;

	@Inject
	private DevToolsOverlay(Client client, DevToolsPlugin plugin, TooltipManager toolTipManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGHEST);
		this.client = client;
		this.plugin = plugin;
		this.toolTipManager = toolTipManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		graphics.setFont(FONT);

		if (plugin.getPlayers().isActive())
		{
			renderPlayers(graphics);
		}

		if (plugin.getNpcs().isActive())
		{
			renderNpcs(graphics);
		}

		if (plugin.getGroundItems().isActive() || plugin.getGroundObjects().isActive() || plugin.getGameObjects().isActive() || plugin.getWalls().isActive() || plugin.getDecorations().isActive() || plugin.getTileLocation().isActive())
		{
			renderTileObjects(graphics);
		}

		if (plugin.getInventory().isActive())
		{
			renderInventory(graphics);
		}

		if (plugin.getProjectiles().isActive())
		{
			renderProjectiles(graphics);
		}

		if (plugin.getGraphicsObjects().isActive())
		{
			renderGraphicsObjects(graphics);
		}

		if (plugin.getCursorPos().isActive())
		{
			renderCursorTooltip(graphics);
		}

		renderWidgets(graphics);

		return null;
	}

	private void renderPlayers(Graphics2D graphics)
	{
		List<Player> players = client.getPlayers();
		Player local = client.getLocalPlayer();

		for (Player p : players)
		{
			if (!p.equals(local))
			{
				String text = p.getName() + " (A: " + p.getAnimation() + ") (G: " + p.getSpotAnimation() + ")";
				OverlayUtil.renderActorOverlay(graphics, p, text, BLUE);
			}
		}

		String text = local.getName() + " (A: " + local.getAnimation() + ") (G: " + local.getSpotAnimation() + ")";
		OverlayUtil.renderActorOverlay(graphics, local, text, CYAN);
		renderPlayerWireframe(graphics, local, CYAN);
	}

	private void renderNpcs(Graphics2D graphics)
	{
		List<NPC> npcs = client.getNpcs();
		for (NPC npc : npcs)
		{
			NPCDefinition composition = npc.getDefinition();
			Color color = composition.getCombatLevel() > 1 ? YELLOW : ORANGE;
			if (composition.getConfigs() != null)
			{
				NPCDefinition transformedComposition = composition.transform();
				if (transformedComposition == null)
				{
					color = GRAY;
				}
				else
				{
					composition = transformedComposition;
				}
			}

			String text = String.format("%s (ID: %d) (A: %d) (G: %d)",
				composition.getName(),
				composition.getId(),
				npc.getAnimation(),
				npc.getSpotAnimation());

			OverlayUtil.renderActorOverlay(graphics, npc, text, color);
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

				if (plugin.getGroundItems().isActive())
				{
					renderGroundItems(graphics, tile, player);
				}

				if (plugin.getGroundObjects().isActive())
				{
					renderGroundObject(graphics, tile, player);
				}

				if (plugin.getGameObjects().isActive())
				{
					renderGameObjects(graphics, tile, player);

				}

				if (plugin.getWalls().isActive())
				{
					renderWallObject(graphics, tile, player);
				}

				if (plugin.getDecorations().isActive())
				{
					renderDecorObject(graphics, tile, player);
				}

				if (plugin.getTileLocation().isActive())
				{
					renderTileTooltip(graphics, tile);
				}
			}
		}
	}

	private void renderCursorTooltip(Graphics2D graphics)
	{
		if (client.getMouseCanvasPosition().getX() >= 0 && client.getMouseCanvasPosition().getY() >= 0)
		{
			toolTipManager.add(new Tooltip("Cursor Point: " + client.getMouseCanvasPosition().getX() + ", " + client.getMouseCanvasPosition().getY()));
		}
	}

	private void renderTileTooltip(Graphics2D graphics, Tile tile)
	{
		Polygon poly = Perspective.getCanvasTilePoly(client, tile.getLocalLocation());
		if (poly != null && poly.contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY()))
		{
			toolTipManager.add(new Tooltip("World Location: " + tile.getWorldLocation().getX() + ", " + tile.getWorldLocation().getY() + ", " + client.getPlane()));
			OverlayUtil.renderPolygon(graphics, poly, GREEN);
		}
	}

	private void renderGroundItems(Graphics2D graphics, Tile tile, Player player)
	{
		TileItemPile tileItemPile = tile.getItemLayer();
		if (tileItemPile != null)
		{
			if (player.getLocalLocation().distanceTo(tileItemPile.getLocalLocation()) <= MAX_DISTANCE)
			{
				Node current = tileItemPile.getBottom();
				while (current instanceof TileItem)
				{
					TileItem item = (TileItem) current;
					OverlayUtil.renderTileOverlay(graphics, tileItemPile, "ID: " + item.getId() + " Qty:" + item.getQuantity(), RED);
					current = current.getNext();
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
				if (gameObject != null)
				{
					if (player.getLocalLocation().distanceTo(gameObject.getLocalLocation()) <= MAX_DISTANCE)
					{
						Entity entity = gameObject.getEntity();
						if (entity instanceof DynamicObject)
						{
							OverlayUtil.renderTileOverlay(graphics, gameObject, "ID: " + gameObject.getId() + " Anim: " + ((DynamicObject) entity).getAnimationID(), TURQOISE);
						}
						else
						{
							OverlayUtil.renderTileOverlay(graphics, gameObject, "ID: " + gameObject.getId(), GREEN);
						}
					}

					// Draw a polygon around the convex hull
					// of the model vertices
					Shape p = gameObject.getConvexHull();
					if (p != null)
					{
						graphics.draw(p);
					}
					// This is incredibly taxing to run, only uncomment if you know what you're doing.
					/*renderGameObjectWireframe(graphics, gameObject, Color.CYAN);*/
				}
			}
		}
	}

	private void renderGroundObject(Graphics2D graphics, Tile tile, Player player)
	{
		GroundObject groundObject = tile.getGroundObject();
		if (groundObject != null)
		{
			if (player.getLocalLocation().distanceTo(groundObject.getLocalLocation()) <= MAX_DISTANCE)
			{
				OverlayUtil.renderTileOverlay(graphics, groundObject, "ID: " + groundObject.getId(), PURPLE);
			}
		}
	}

	private void renderWallObject(Graphics2D graphics, Tile tile, Player player)
	{
		WallObject wallObject = tile.getWallObject();
		if (wallObject != null)
		{
			if (player.getLocalLocation().distanceTo(wallObject.getLocalLocation()) <= MAX_DISTANCE)
			{
				OverlayUtil.renderTileOverlay(graphics, wallObject, "ID: " + wallObject.getId(), GRAY);
			}
		}
	}

	private void renderDecorObject(Graphics2D graphics, Tile tile, Player player)
	{
		DecorativeObject decorObject = tile.getDecorativeObject();
		if (decorObject != null)
		{
			if (player.getLocalLocation().distanceTo(decorObject.getLocalLocation()) <= MAX_DISTANCE)
			{
				OverlayUtil.renderTileOverlay(graphics, decorObject, "ID: " + decorObject.getId(), DEEP_PURPLE);
			}

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

	private void renderInventory(Graphics2D graphics)
	{
		Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
		if (inventoryWidget == null || inventoryWidget.isHidden())
		{
			return;
		}

		for (WidgetItem item : inventoryWidget.getWidgetItems())
		{
			Rectangle slotBounds = item.getCanvasBounds();

			String idText = "" + item.getId();
			FontMetrics fm = graphics.getFontMetrics();
			Rectangle2D textBounds = fm.getStringBounds(idText, graphics);

			int textX = (int) (slotBounds.getX() + (slotBounds.getWidth() / 2) - (textBounds.getWidth() / 2));
			int textY = (int) (slotBounds.getY() + (slotBounds.getHeight() / 2) + (textBounds.getHeight() / 2));

			graphics.setColor(new Color(255, 255, 255, 65));
			graphics.fill(slotBounds);

			graphics.setColor(Color.BLACK);
			graphics.drawString(idText, textX + 1, textY + 1);
			graphics.setColor(YELLOW);
			graphics.drawString(idText, textX, textY);
		}
	}

	private void renderProjectiles(Graphics2D graphics)
	{
		List<Projectile> projectiles = client.getProjectiles();

		for (Projectile projectile : projectiles)
		{
			int originX = projectile.getX1();
			int originY = projectile.getY1();

			LocalPoint tilePoint = new LocalPoint(originX, originY);
			Polygon poly = Perspective.getCanvasTilePoly(client, tilePoint);

			if (poly != null)
			{
				OverlayUtil.renderPolygon(graphics, poly, Color.RED);
			}

			int projectileId = projectile.getId();
			Actor projectileInteracting = projectile.getInteracting();

			String infoString = "";

			if (projectileInteracting == null)
			{
				infoString += "AoE";
			}
			else
			{
				infoString += "Targeted (T: " + projectileInteracting.getName() + ")";
			}

			infoString += " (ID: " + projectileId + ")";

			if (projectileInteracting != null)
			{
				OverlayUtil.renderActorOverlay(graphics, projectile.getInteracting(), infoString, Color.RED);
			}
			else
			{
				LocalPoint projectilePoint = new LocalPoint((int) projectile.getX(), (int) projectile.getY());
				Point textLocation = Perspective.getCanvasTextLocation(client, graphics, projectilePoint, infoString, 0);

				if (textLocation != null)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, infoString, Color.RED);
				}
			}
		}
	}

	private void renderGraphicsObjects(Graphics2D graphics)
	{
		List<GraphicsObject> graphicsObjects = client.getGraphicsObjects();

		for (GraphicsObject graphicsObject : graphicsObjects)
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

	private void renderWidgets(Graphics2D graphics)
	{
		if (widget == null || widget.isHidden())
		{
			return;
		}

		Rectangle childBounds = widget.getBounds();
		graphics.setColor(CYAN);
		graphics.draw(childBounds);

		if (itemIndex == -1)
		{
			return;
		}

		if (widget.getItemId() != ITEM_EMPTY
			&& widget.getItemId() != ITEM_FILLED)
		{
			Rectangle componentBounds = widget.getBounds();

			graphics.setColor(ORANGE);
			graphics.draw(componentBounds);

			renderWidgetText(graphics, componentBounds, widget.getItemId(), YELLOW);
		}

		WidgetItem widgetItem = widget.getWidgetItem(itemIndex);
		if (widgetItem == null
			|| widgetItem.getId() < 0
			|| widgetItem.getId() == ITEM_EMPTY
			|| widgetItem.getId() == ITEM_FILLED)
		{
			return;
		}

		Rectangle itemBounds = widgetItem.getCanvasBounds();

		graphics.setColor(ORANGE);
		graphics.draw(itemBounds);

		renderWidgetText(graphics, itemBounds, widgetItem.getId(), YELLOW);
	}

	private void renderWidgetText(Graphics2D graphics, Rectangle bounds, int itemId, Color color)
	{
		if (itemId == -1)
		{
			return;
		}

		String text = itemId + "";
		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(text, graphics);

		int textX = (int) (bounds.getX() + (bounds.getWidth() / 2) - (textBounds.getWidth() / 2));
		int textY = (int) (bounds.getY() + (bounds.getHeight() / 2) + (textBounds.getHeight() / 2));

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, textX + 1, textY + 1);
		graphics.setColor(color);
		graphics.drawString(text, textX, textY);
	}

	private void renderPlayerWireframe(Graphics2D graphics, Player player, Color color)
	{
		Polygon[] polys = player.getPolygons();

		if (polys == null)
		{
			return;
		}

		graphics.setColor(color);

		for (Polygon p : polys)
		{
			graphics.drawPolygon(p);
		}
	}

}
