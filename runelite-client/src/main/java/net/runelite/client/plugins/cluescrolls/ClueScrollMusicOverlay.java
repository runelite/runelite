/*
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
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
import java.awt.Rectangle;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.MusicClue;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
class ClueScrollMusicOverlay extends Overlay
{
	private static final Rectangle PADDING = new Rectangle(2, 1, 0, 1);

	private final ClueScrollPlugin plugin;
	private final Client client;

	private boolean hasScrolled;

	@Inject
	private ClueScrollMusicOverlay(final ClueScrollPlugin plugin, final Client client)
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

		if (!(clue instanceof MusicClue))
		{
			hasScrolled = false;
			return null;
		}

		MusicClue musicClue = (MusicClue) clue;

		Widget musicContainer = client.getWidget(WidgetInfo.MUSIC_WINDOW);

		if (musicContainer == null || musicContainer.isHidden())
		{
			return null;
		}

		Widget trackList = client.getWidget(WidgetInfo.MUSIC_TRACK_LIST);
		String trackToFind = musicClue.getSong();
		Widget found = null;

		if (trackList == null)
		{
			return null;
		}

		for (Widget track : trackList.getDynamicChildren())
		{
			if (track.getText().equals(trackToFind))
			{
				found = track;
				break;
			}
		}

		if (found == null)
		{
			return null;
		}

		if (!hasScrolled)
		{
			hasScrolled = true;
			plugin.scrollToWidget(WidgetInfo.MUSIC_TRACK_LIST, WidgetInfo.MUSIC_TRACK_SCROLLBAR, found);
		}
		plugin.highlightWidget(graphics, found, trackList, PADDING, null);

		return null;
	}
}
