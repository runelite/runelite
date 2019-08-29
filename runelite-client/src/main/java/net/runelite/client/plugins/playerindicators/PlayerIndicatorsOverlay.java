/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.playerindicators;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.kit.KitType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;

@Slf4j
@Singleton
public class PlayerIndicatorsOverlay extends Overlay
{
	private static final int ACTOR_OVERHEAD_TEXT_MARGIN = 40;
	private static final int ACTOR_HORIZONTAL_TEXT_MARGIN = 10;
	private final BufferedImage agilityIcon = ImageUtil.getResourceStreamFromClass(PlayerIndicatorsPlugin.class,
		"agility.png");
	private final BufferedImage noAgilityIcon = ImageUtil.getResourceStreamFromClass(PlayerIndicatorsPlugin.class,
		"no-agility.png");
	private final BufferedImage skullIcon = ImageUtil.getResourceStreamFromClass(PlayerIndicatorsPlugin.class,
		"skull.png");
	private PlayerIndicatorsPlugin plugin;
	private PlayerIndicatorsService playerIndicatorsService;
	@Inject
	private Client client;

	@Inject
	public PlayerIndicatorsOverlay(PlayerIndicatorsPlugin plugin, PlayerIndicatorsService playerIndicatorsService)
	{
		this.plugin = plugin;
		this.playerIndicatorsService = playerIndicatorsService;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		playerIndicatorsService.forEachPlayer((player, playerRelation) -> drawSceneOverlays(graphics, player, playerRelation));
		return null;
	}

	private void drawSceneOverlays(Graphics2D graphics, Player actor, PlayerRelation relation)
	{
		if (!plugin.getLocationHashMap().containsKey(relation))
		{
			return;
		}
		final List indicationLocations = Arrays.asList(plugin.getLocationHashMap().get(relation));
		final Color color = plugin.getRelationColorHashMap().get(relation);

		if (indicationLocations.contains(PlayerIndicationLocation.ABOVE_HEAD))
		{
			String name = actor.getName();
			final boolean skulls = plugin.isPlayerSkull();
			final int zOffset = actor.getLogicalHeight() + ACTOR_OVERHEAD_TEXT_MARGIN;
			final Point textLocation = actor.getCanvasTextLocation(graphics, name, zOffset);

			if (plugin.isShowCombatLevel())
			{
				name = name + " (" + actor.getCombatLevel() + ")";
			}

			if (plugin.isUnchargedGlory())
			{
				if (actor.getPlayerAppearance().getEquipmentId(KitType.AMULET) == ItemID.AMULET_OF_GLORY)
				{
					name += " (glory)";
				}
			}

			if (plugin.isPlayerSkull() && actor.getSkullIcon() != null)
			{
				int x = graphics.getFontMetrics().stringWidth(name);
				int y = graphics.getFontMetrics().getHeight();
				OverlayUtil.renderActorTextAndImage(graphics, actor, name, color,
					ImageUtil.resizeImage(skullIcon, y, y), 0, x);
			}

			else
			{
				OverlayUtil.renderActorTextOverlay(graphics, actor, name, color);
			}
		}
		if (Arrays.asList(plugin.getLocationHashMap().get(relation)).contains(PlayerIndicationLocation.HULL))
		{
			if (actor.getConvexHull() == null)
			{
				return;
			}
			OverlayUtil.renderPolygon(graphics, actor.getConvexHull(), color);
		}

		if (Arrays.asList(plugin.getLocationHashMap().get(relation)).contains(PlayerIndicationLocation.TILE))
		{
			final Polygon poly = actor.getCanvasTilePoly();
			if (poly != null)
			{
				OverlayUtil.renderPolygon(graphics, poly, color);
			}
		}
	}

	private boolean checkWildy()
	{
		return client.getVar(Varbits.IN_WILDERNESS) == 1 || WorldType.isAllPvpWorld(client.getWorldType());
	}


}
