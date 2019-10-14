/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.banktags;

import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.plugins.banktags.tabs.TabInterface;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.components.TextComponent;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class BankTagOverlay extends WidgetItemOverlay
{
	private static final Color TEXT_COLOUR = new Color(0, 180, 230);

	private final TabInterface tabInterface;
	private final TagManager tagManager;

	@Inject
	private BankTagOverlay(TabInterface tabInterface, TagManager tagManager)
	{
		this.tabInterface = tabInterface;
		this.tagManager = tagManager;
		showOnBank();
	}

	public void renderItemOverlay(Graphics2D graphics, int itemID, WidgetItem widget)
	{
		String activeTag = tabInterface.getActiveTag();
		if (activeTag == null)
		{
			return;
		}

		final String text = tagManager.getItemText(itemID, activeTag);
		if (text == null)
		{
			return;
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());
		final TextComponent textComponent = new TextComponent();
		final Rectangle bounds = widget.getCanvasBounds();

		textComponent.setText(text);
		textComponent.setColor(TEXT_COLOUR);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		textComponent.setPosition(new Point(bounds.x + bounds.width - 4 - fontMetrics.stringWidth(text), bounds.y + bounds.height));
		textComponent.render(graphics);
	}
}