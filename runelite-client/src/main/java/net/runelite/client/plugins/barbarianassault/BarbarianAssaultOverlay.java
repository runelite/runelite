/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;

class BarbarianAssaultOverlay extends Overlay
{
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
			roleText.setText(String.format("00:%02d", currentRound.getTimeToChange()));
			Rectangle spriteBounds = roleSprite.getBounds();
			roleSprite.setHidden(true);
			graphics.drawImage(plugin.getClockImage(), spriteBounds.x, spriteBounds.y, null);
		}

		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (config.highlightItems() && inventory != null && !inventory.isHidden() && (role == Role.DEFENDER || role == Role.HEALER))
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

		return null;
	}
}
