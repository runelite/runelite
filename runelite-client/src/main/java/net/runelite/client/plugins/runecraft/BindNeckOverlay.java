/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.runecraft;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import static net.runelite.api.ItemID.BINDING_NECKLACE;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

public class BindNeckOverlay extends Overlay
{
	private final Client client = RuneLite.getClient();
	private final RunecraftConfig config;
	int bindingCharges;

	public BindNeckOverlay(Runecraft plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.config = plugin.getConfig();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN
			|| !config.showBindNeck()
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null)
		{
			return null;
		}

		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null)
		{
			return null;
		}

		if (!inventory.isHidden())
		{
			for (WidgetItem item : inventory.getWidgetItems())
			{
				if (item.getId() != BINDING_NECKLACE)
				{
					continue;
				}

				if (bindingCharges == 1)
				{
					renderBindNeck(graphics, item.getCanvasBounds(), bindingCharges, Color.red);
				}
				else
				{
					renderBindNeck(graphics, item.getCanvasBounds(), bindingCharges, Color.white);
				}
			}
		}

		Widget equipment = client.getWidget(WidgetInfo.EQUIPMENT);

		if (equipment != null)
		{
			Widget amuletSlot = client.getWidget(WidgetInfo.EQUIPMENT_AMULET).getChild(1);

			if (!amuletSlot.isHidden() && amuletSlot.getItemId() == BINDING_NECKLACE)
			{
				Rectangle widgetBounds = amuletSlot.getBounds();

				//to match inventory text
				widgetBounds.x -= 5;
				widgetBounds.y -= 1;

				if (bindingCharges == 1)
				{
					renderBindNeck(graphics, widgetBounds, bindingCharges, Color.red);
				}
				else
				{
					renderBindNeck(graphics, widgetBounds, bindingCharges, Color.white);
				}
			}
		}

		return null;
	}

	private void renderBindNeck(Graphics2D graphics, Rectangle bounds, int charges, Color color)
	{
		String text = charges <= 0 ? "?" : charges + "";
		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(text, graphics);

		int textX = (int) (bounds.getX() + bounds.getWidth() - textBounds.getWidth());
		int textY = (int) (bounds.getY() + (textBounds.getHeight()));

		//text shadow
		graphics.setColor(Color.BLACK);
		graphics.drawString(text, textX + 1, textY + 1);

		graphics.setColor(color);
		graphics.drawString(text, textX, textY);
	}
}
