/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.EmoteClue;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class ClueScrollEmoteOverlay extends Overlay
{
	private final ClueScrollPlugin plugin;
	private final Client client;

	private boolean hasScrolled;

	@Inject
	private ClueScrollEmoteOverlay(ClueScrollPlugin plugin, Client client)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ClueScroll clue = plugin.getClue();

		if (!(clue instanceof EmoteClue))
		{
			hasScrolled = false;
			return null;
		}

		EmoteClue emoteClue = (EmoteClue) clue;

		if (!emoteClue.getFirstEmote().hasSprite())
		{
			return null;
		}

		Widget emoteContainer = client.getWidget(WidgetInfo.EMOTE_CONTAINER);

		if (emoteContainer == null || emoteContainer.isHidden())
		{
			return null;
		}

		Widget emoteWindow = client.getWidget(WidgetInfo.EMOTE_WINDOW);

		if (emoteWindow == null)
		{
			return null;
		}

		Widget firstEmoteWidget = null;
		Widget secondEmoteWidget = null;

		for (Widget emoteWidget : emoteContainer.getDynamicChildren())
		{
			if (emoteWidget.getSpriteId() == emoteClue.getFirstEmote().getSpriteId())
			{
				firstEmoteWidget = emoteWidget;
				plugin.highlightWidget(graphics, emoteWidget, emoteWindow, null,
					emoteClue.getSecondEmote() != null ? "1st" : null);
			}
			else if (emoteClue.getSecondEmote() != null
				&& emoteWidget.getSpriteId() == emoteClue.getSecondEmote().getSpriteId())
			{
				secondEmoteWidget = emoteWidget;
				plugin.highlightWidget(graphics, emoteWidget, emoteWindow, null, "2nd");
			}
		}
		if (!hasScrolled)
		{
			hasScrolled = true;
			plugin.scrollToWidget(WidgetInfo.EMOTE_CONTAINER, WidgetInfo.EMOTE_SCROLLBAR, firstEmoteWidget, secondEmoteWidget);
		}

		return null;
	}
}
