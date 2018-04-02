/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.menuentryswapper;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;

public class ShiftClickConfigurationOverlay extends Overlay
{
	@Inject
	private Client client;

	@Inject
	private MenuEntrySwapperPlugin plugin;

	@Inject
	public ShiftClickConfigurationOverlay()
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isConfiguringShiftClick() || client.isMenuOpen() || client.getWidget(WidgetInfo.INVENTORY).isHidden())
		{
			return null;
		}

		Font font = FontManager.getRunescapeSmallFont();
		graphics.setFont(font);

		net.runelite.api.Point mouseCanvasPosition = client.getMouseCanvasPosition();
		Point mousePoint = new Point(mouseCanvasPosition.getX(), mouseCanvasPosition.getY());

		for (WidgetItem item : plugin.getInventoryItems())
		{
			final Rectangle bounds = item.getCanvasBounds();

			if (!bounds.contains(mousePoint))
			{
				continue;
			}

			ItemComposition itemComposition = client.getItemDefinition(item.getId());
			String[] actions = itemComposition.getInventoryActions();
			int index = itemComposition.getShiftClickActionIndex();

			if (index >= 0 && actions[index] == null)
			{
				continue;
			}

			String action = index == -1 ? "Use" : actions[index];
			int textWidth = graphics.getFontMetrics().stringWidth(action);
			int textLocationX = (int) (bounds.x + bounds.getWidth() / 2 - textWidth / 2);
			int textLocationY = bounds.y + 28;
			final TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(textLocationX, textLocationY));
			textComponent.setText(action);
			textComponent.render(graphics);
		}

		return null;
	}
}
