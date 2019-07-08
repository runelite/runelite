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
import java.awt.Rectangle;
import java.util.ConcurrentModificationException;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
class PrayAgainstPlayerOverlayPrayerTab extends Overlay
{

	private final PrayAgainstPlayerPlugin plugin;
	private final Client client;

	@Inject
	private PrayAgainstPlayerOverlayPrayerTab(final PrayAgainstPlayerPlugin plugin, final Client client)
	{
		super(plugin);
		this.plugin = plugin;
		this.client = client;

		setPosition(OverlayPosition.DETACHED);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		setPriority(OverlayPriority.MED);
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getPlayersAttackingMe() == null || !plugin.getPlayersAttackingMe().isEmpty())
		{
			try
			{
				if (plugin.getPlayersAttackingMe() != null)
				{
					for (PlayerContainer container : plugin.getPlayersAttackingMe())
					{
						if (plugin.getPlayersAttackingMe() != null && plugin.getPlayersAttackingMe().size() == 1 &&
							plugin.isDrawTargetPrayAgainstPrayerTab())
						{
							renderPrayerToClick(graphics, container.getPlayer());
						}
					}
				}
			}
			catch (ConcurrentModificationException ignored)
			{
			}
		}
		return null;
	}

	private void renderPrayerToClick(Graphics2D graphics, Player player)
	{
		Widget PROTECT_FROM_MAGIC = client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MAGIC);
		Widget PROTECT_FROM_RANGED = client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MISSILES);
		Widget PROTECT_FROM_MELEE = client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MELEE);
		Color color = Color.RED;
		if (PROTECT_FROM_MELEE.isHidden())
		{
			return;
		}
		switch (WeaponType.checkWeaponOnPlayer(client, player))
		{
			case WEAPON_MAGIC:
				OverlayUtil.renderPolygon(graphics, rectangleToPolygon(PROTECT_FROM_MAGIC.getBounds()), color);
				break;
			case WEAPON_MELEE:
				OverlayUtil.renderPolygon(graphics, rectangleToPolygon(PROTECT_FROM_MELEE.getBounds()), color);
				break;
			case WEAPON_RANGED:
				OverlayUtil.renderPolygon(graphics, rectangleToPolygon(PROTECT_FROM_RANGED.getBounds()), color);
				break;
			default:
				break;
		}
	}

	private static Polygon rectangleToPolygon(Rectangle rect)
	{
		int[] xpoints = {rect.x, rect.x + rect.width, rect.x + rect.width, rect.x};
		int[] ypoints = {rect.y, rect.y, rect.y + rect.height, rect.y + rect.height};

		return new Polygon(xpoints, ypoints, 4);
	}

}
