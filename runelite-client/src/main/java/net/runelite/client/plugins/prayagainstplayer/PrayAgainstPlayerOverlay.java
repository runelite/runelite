/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.prayagainstplayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.kit.KitType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.api.util.Text;

@Singleton
class PrayAgainstPlayerOverlay extends Overlay
{

	private final PrayAgainstPlayerPlugin plugin;
	private final Client client;

	@Inject
	private PrayAgainstPlayerOverlay(final PrayAgainstPlayerPlugin plugin, final Client client)
	{
		super(plugin);
		this.plugin = plugin;
		this.client = client;

		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		renderPotentialPlayers(graphics);
		renderAttackingPlayers(graphics);
		return null;
	}

	private void renderPotentialPlayers(Graphics2D graphics)
	{
		if (plugin.getPotentialPlayersAttackingMe() == null || !plugin.getPotentialPlayersAttackingMe().isEmpty())
		{
			try
			{
				if (plugin.getPotentialPlayersAttackingMe() != null)
				{
					for (PlayerContainer container : plugin.getPotentialPlayersAttackingMe())
					{
						if ((System.currentTimeMillis() > (container.getWhenTheyAttackedMe() + container.getMillisToExpireHighlight())) && (container.getPlayer().getInteracting() != client.getLocalPlayer()))
						{
							plugin.removePlayerFromPotentialContainer(container);
						}
						if (plugin.isDrawPotentialTargetsName())
						{
							renderNameAboveHead(graphics, container.getPlayer(), plugin.getPotentialPlayerColor());
						}
						if (plugin.isDrawPotentialTargetHighlight())
						{
							renderHighlightedPlayer(graphics, container.getPlayer(), plugin.getPotentialPlayerColor());
						}
						if (plugin.isDrawPotentialTargetTile())
						{
							renderTileUnderPlayer(graphics, container.getPlayer(), plugin.getPotentialPlayerColor());
						}
						if (plugin.isDrawPotentialTargetPrayAgainst())
						{
							renderPrayAgainstOnPlayer(graphics, container.getPlayer(), plugin.getPotentialPlayerColor());
						}
					}
				}
			}
			catch (ConcurrentModificationException ignored)
			{
			}
		}
	}

	private void renderAttackingPlayers(Graphics2D graphics)
	{
		if (plugin.getPlayersAttackingMe() == null || !plugin.getPlayersAttackingMe().isEmpty())
		{
			try
			{
				if (plugin.getPlayersAttackingMe() != null)
				{
					for (PlayerContainer container : plugin.getPlayersAttackingMe())
					{
						if ((System.currentTimeMillis() > (container.getWhenTheyAttackedMe() + container.getMillisToExpireHighlight())) && (container.getPlayer().getInteracting() != client.getLocalPlayer()))
						{
							plugin.removePlayerFromAttackerContainer(container);
						}

						if (plugin.isDrawTargetsName())
						{
							renderNameAboveHead(graphics, container.getPlayer(), plugin.getAttackerPlayerColor());
						}
						if (plugin.isDrawTargetHighlight())
						{
							renderHighlightedPlayer(graphics, container.getPlayer(), plugin.getAttackerPlayerColor());
						}
						if (plugin.isDrawTargetTile())
						{
							renderTileUnderPlayer(graphics, container.getPlayer(), plugin.getAttackerPlayerColor());
						}
						if (plugin.isDrawTargetPrayAgainst())
						{
							renderPrayAgainstOnPlayer(graphics, container.getPlayer(), plugin.getAttackerPlayerColor());
						}
					}
				}
			}
			catch (ConcurrentModificationException ignored)
			{
			}
		}
	}

	private void renderNameAboveHead(Graphics2D graphics, Player player, Color color)
	{
		final String name = Text.sanitize(player.getName());
		final int offset = player.getLogicalHeight() + 40;
		Point textLocation = player.getCanvasTextLocation(graphics, name, offset);
		if (textLocation != null)
		{
			OverlayUtil.renderTextLocation(graphics, textLocation, name, color);
		}
	}

	private void renderHighlightedPlayer(Graphics2D graphics, Player player, Color color)
	{
		try
		{
			OverlayUtil.renderPolygon(graphics, player.getConvexHull(), color);
		}
		catch (NullPointerException ignored)
		{
		}
	}

	private void renderTileUnderPlayer(Graphics2D graphics, Player player, Color color)
	{
		Polygon poly = player.getCanvasTilePoly();
		OverlayUtil.renderPolygon(graphics, poly, color);
	}

	private void renderPrayAgainstOnPlayer(Graphics2D graphics, Player player, Color color)
	{
		final int offset = (player.getLogicalHeight() / 2) + 75;
		BufferedImage icon;

		switch (WeaponType.checkWeaponOnPlayer(client, player))
		{
			case WEAPON_MELEE:
				icon = plugin.getProtectionIcon(WeaponType.WEAPON_MELEE);
				break;
			case WEAPON_MAGIC:
				icon = plugin.getProtectionIcon(WeaponType.WEAPON_MAGIC);
				break;
			case WEAPON_RANGED:
				icon = plugin.getProtectionIcon(WeaponType.WEAPON_RANGED);
				break;
			default:
				icon = null;
				break;
		}
		try
		{
			if (icon != null)
			{
				Point point = player.getCanvasImageLocation(icon, offset);
				OverlayUtil.renderImageLocation(graphics, point, icon);
			}
			else
			{
				if (plugin.isDrawUnknownWeapons())
				{
					int itemId = player.getPlayerAppearance().getEquipmentId(KitType.WEAPON);
					ItemDefinition itemComposition = client.getItemDefinition(itemId);

					final String str = itemComposition.getName().toUpperCase();
					Point point = player.getCanvasTextLocation(graphics, str, offset);
					OverlayUtil.renderTextLocation(graphics, point, str, color);
				}
			}
		}
		catch (Exception ignored)
		{
		}
	}

}
