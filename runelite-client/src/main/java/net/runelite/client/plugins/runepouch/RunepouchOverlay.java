/*
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
package net.runelite.client.plugins.runepouch;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import java.awt.*;
import java.awt.font.*;
import java.util.Arrays;
import java.util.Map;

public class RunepouchOverlay extends Overlay
{
	private final Client client = RuneLite.getClient();

	public RunepouchOverlay(Runepouch plugin)
	{
		super(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Font font = graphics.getFont();
		if(font.getSize() != 10){
			Map attributes = font.getAttributes();
			attributes.put(TextAttribute.SIZE, 10);
			font = Font.getFont(attributes);
			graphics.setFont(font);
		}

		if (client.getGameState() != GameState.LOGGED_IN
				|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null)
		{
			return null;
		}

		Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);

		if (inventoryWidget == null || inventoryWidget.isHidden())
		{
			return null;
		}

		for (WidgetItem item : inventoryWidget.getWidgetItems())
		{
			if(item.getId() != ItemID.RUNE_POUCH)
				continue;

			Point location = item.getCanvasLocation();
			if (location != null)
			{
				Varbits[] varbits = {Varbits.RUNE_POUCH_AMOUNT1, Varbits.RUNE_POUCH_AMOUNT2, Varbits.RUNE_POUCH_AMOUNT3};
				int[] amounts = new int[3];
				for(int i = 0; i < amounts.length; i++){
					int amount = client.getSetting(varbits[i]);
					if(amount > 0) {
						graphics.setColor(Color.black);
						graphics.drawString("" + formatNumber(amount), location.getX() + 1, location.getY() + (graphics.getFontMetrics().getHeight()-2)*i + 11);

						graphics.setColor(Color.white);
						graphics.drawString("" + formatNumber(amount), location.getX(), location.getY() + (graphics.getFontMetrics().getHeight()-2)*i + 10);

					}
				}
			}
		}
		return null;
	}

	String formatNumber(int var0) {
		return var0 < 100000 ? String.valueOf(var0) : var0 / 1000 + "K";
	}

}
