/*
 * Copyright (c) 2019, 7ate9 <https://github.com/se7enAte9>
 * Copyright (c) 2019, https://openosrs.com
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

import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;

@Singleton
class AboveWidgetsOverlay extends Overlay
{
	private static final int OFFSET_X_TEXT_QUANTITY = 0;
	private static final int OFFSET_Y_TEXT_QUANTITY = 10;

	private final Client client;
	private final BarbarianAssaultPlugin game;

	@Inject
	private AboveWidgetsOverlay(final Client client, final BarbarianAssaultPlugin game)
	{
		super(game);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.game = game;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!game.isInGame() || game.getRole() == null || game.isUsingGloryHorn())
		{
			return null;
		}

		Role role = game.getRole();

		if (game.isShowTimer())
		{
			renderTimer(graphics, role);
		}

		switch (role)
		{
			case ATTACKER:
				if (game.isHighlightArrows())
				{
					renderInventoryHighlights(graphics, game.getRole().getListenItem(game.getLastListenText()), game.getHighlightArrowColor());
				}
				break;

			case DEFENDER:
				if (game.isHighlightBait())
				{
					renderInventoryHighlights(graphics, game.getRole().getListenItem(game.getLastListenText()), game.getHighlightBaitColor());
				}
				break;

			case HEALER:
				if (game.isHighlightPoison())
				{
					renderInventoryHighlights(graphics, game.getRole().getListenItem(game.getLastListenText()), game.getHighlightPoisonColor());
				}
		}
		return null;
	}

	private void renderTimer(Graphics2D graphics, Role role)
	{
		Widget roleText = client.getWidget(role.getRoleText());
		Widget roleSprite = client.getWidget(role.getRoleSprite());

		if (roleText == null || roleSprite == null)
		{
			return;
		}

		if (role == Role.COLLECTOR && game.isShowEggCountOverlay() && game.getWave() != null)
		{
			roleText.setText("(" + game.getWave().getCollectedEggCount() + ") " + formatClock());
		}
		else if (role == Role.HEALER && game.isShowHpCountOverlay() && game.getWave() != null)
		{
			roleText.setText("(" + game.getWave().getHpHealed() + ") " + formatClock());
		}
		else
		{
			roleText.setText(formatClock());
		}

		Rectangle spriteBounds = roleSprite.getBounds();
		graphics.drawImage(game.getClockImage(), spriteBounds.x, spriteBounds.y, null);
		roleSprite.setHidden(true);
	}

	private void renderInventoryHighlights(Graphics2D graphics, int itemID, Color color)
	{
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null || inventory.isHidden() || itemID == -1)
		{
			return;
		}

		Color highlight = new Color(color.getRed(), color.getGreen(), color.getBlue(), 150);
		BufferedImage image = ImageUtil.fillImage(client.createItemSprite(itemID, 300, 2, 0, 0, true, 710).toBufferedImage(), highlight);
		for (WidgetItem item : inventory.getWidgetItems())
		{
			if (item.getId() == itemID)
			{
				OverlayUtil.renderImageLocation(graphics, item.getCanvasLocation(), image);
				//The item's text quantity is rendered after the sprite's image is rendered so that the text appears on top
				if (item.getQuantity() > 1)
				{
					OverlayUtil.renderTextLocation(graphics,
						new Point(item.getCanvasLocation().getX() + OFFSET_X_TEXT_QUANTITY, item.getCanvasLocation().getY() + OFFSET_Y_TEXT_QUANTITY),
						String.valueOf(item.getQuantity()), Color.YELLOW);
				}
			}
		}
	}

	private String formatClock()
	{
		if (game.getCallTimer() == null)
		{
			return "- - -";
		}
		else
		{
			long timeLeft = game.getTimeToChange();
			if (timeLeft < 0)
			{
				return "00:00";
			}
			else
			{
				return String.format("00:%02d", timeLeft);
			}
		}
	}
}