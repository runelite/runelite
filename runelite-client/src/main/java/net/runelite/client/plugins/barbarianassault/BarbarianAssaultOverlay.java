/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.barbarianassault;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;


class BarbarianAssaultOverlay extends Overlay
{
	private static final int MAX_EGG_DISTANCE = 2500;
	private final int HEALTH_BAR_HEIGHT = 20;
	private final Color HEALTH_BAR_COLOR = new Color(225, 35, 0, 125);
	private static final Color BACKGROUND = new Color(0, 0, 0, 150);
	private static final int OFFSET_Z = 20;

	private final Client client;
	private final ItemManager itemManager;
	private final BarbarianAssaultPlugin plugin;
	private final BarbarianAssaultConfig config;

	@Getter
	@Setter
	private Round currentRound;


	@Inject
	private BarbarianAssaultOverlay(Client client, ItemManager itemManager, BarbarianAssaultPlugin plugin, BarbarianAssaultConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.itemManager = itemManager;
		this.plugin = plugin;
		this.config = config;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "B.A. overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN || currentRound == null)
		{
			return null;
		}

		Role role = currentRound.getRoundRole();
		if (role == null)
		{
			return null;
		}

		Widget roleText = client.getWidget(role.getRoleText());
		Widget roleSprite = client.getWidget(role.getRoleSprite());

		if (config.showTimer() && roleText != null && roleSprite != null)
		{
			if (config.showEggCountOverlay() && role.equals(Role.COLLECTOR))
			{
				roleText.setText(String.format("(%d) 00:%02d", plugin.getCollectedEggCount(), currentRound.getTimeToChange()));
			}
			else if (config.showHpCountOverlay() && role.equals(Role.HEALER))
			{
				roleText.setText(String.format("(%d) 00:%02d", plugin.getHpHealed(), currentRound.getTimeToChange()));
			}
			else
			{
				roleText.setText(String.format("00:%02d", currentRound.getTimeToChange()));
			}
			Rectangle spriteBounds = roleSprite.getBounds();
			roleSprite.setHidden(true);
			graphics.drawImage(plugin.getClockImage(), spriteBounds.x, spriteBounds.y, null);
		}

		if (role == Role.COLLECTOR && config.highlightCollectorEggs())
		{
			String heardCall = plugin.getCollectorHeardCall();
			Color highlightColor = BarbarianAssaultPlugin.getEggColor(heardCall);
			Map<WorldPoint, Integer> calledEggMap = plugin.getCalledEggMap();
			Map<WorldPoint, Integer> yellowEggMap = plugin.getYellowEggs();

			if (calledEggMap != null)
			{
				renderEggLocations(graphics, calledEggMap, highlightColor);
			}

			// Always show yellow eggs
			renderEggLocations(graphics, yellowEggMap, Color.YELLOW);
		}
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (config.highlightItems() && inventory != null && !inventory.isHidden() && ((role == Role.DEFENDER || role == Role.HEALER)))
		{
			int listenItemId = plugin.getListenItemId(role.getListen());

			if (listenItemId != -1)
			{
				Color color = config.highlightColor();
				BufferedImage highlight = ImageUtil.fillImage(itemManager.getImage(listenItemId), new Color(color.getRed(), color.getGreen(), color.getBlue(), 150));

				for (WidgetItem item : inventory.getWidgetItems())
				{
					if (item.getId() == listenItemId)
					{
						OverlayUtil.renderImageLocation(graphics, item.getCanvasLocation(), highlight);
					}
				}
			}
		}

		if (role == Role.HEALER)
		{
			for (HealerTeam teammate : HealerTeam.values())
			{
				Widget widget = client.getWidget(teammate.getTeammate());
				if (widget == null)
				{
					continue;
				}

				String[] teammateHealth = widget.getText().split(" / ");
				final int curHealth = Integer.parseInt(teammateHealth[0]);
				final int maxHealth = Integer.parseInt(teammateHealth[1]);

				int width = teammate.getWidth();
				final int filledWidth = getBarWidth(maxHealth, curHealth, width);

				int offsetX = teammate.getOffset().getX();
				int offsetY = teammate.getOffset().getY();
				int x = widget.getCanvasLocation().getX() - offsetX;
				int y = widget.getCanvasLocation().getY() - offsetY;

				graphics.setColor(HEALTH_BAR_COLOR);
				graphics.fillRect(x, y, filledWidth, HEALTH_BAR_HEIGHT);
			}
		}

		return null;
	}

	private static int getBarWidth(int base, int current, int size)
	{
		final double ratio = (double) current / base;

		if (ratio >= 1)
		{
			return size;
		}

		return (int) Math.round(ratio * size);
	}

	private void renderEggLocations(Graphics2D graphics, Map<WorldPoint, Integer> eggMap, Color color)
	{
		Player player = client.getLocalPlayer();

		if (player == null)
		{
			return;
		}

		final Stroke originalStroke = graphics.getStroke();

		for (WorldPoint worldPoint : eggMap.keySet())
		{
			LocalPoint groundPoint = LocalPoint.fromWorld(client, worldPoint);

			if (groundPoint == null)
			{
				continue;
			}
			if (player.getLocalLocation().distanceTo(groundPoint) > MAX_EGG_DISTANCE)
			{
				continue;
			}

			Polygon poly = Perspective.getCanvasTilePoly(client, groundPoint);

			if (poly == null)
			{
				continue;
			}

			int quantity = eggMap.get(worldPoint);
			String quantityText = "x" + quantity;
			Point textPoint = Perspective.getCanvasTextLocation(client, graphics, groundPoint, quantityText, OFFSET_Z);
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.drawPolygon(poly);
			OverlayUtil.renderTextLocation(graphics, textPoint, quantityText, Color.WHITE);
		}

		graphics.setStroke(originalStroke);
	}
}