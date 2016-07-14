/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.plugins.opponentinfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class OpponentInfoOverlay extends Overlay
{
	private static final int WIDTH = 140;

	private static final int TOP_BORDER = 2;
	private static final int BOTTOM_BORDER = 2;

	private static final int BAR_WIDTH = 124;
	private static final int BAR_HEIGHT = 20;

	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);

	OpponentInfoOverlay()
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.HIGH);
	}

	private Actor getOpponent()
	{
		Client client = RuneLite.getClient();

		Player player = client.getLocalPlayer();
		if (player == null)
			return null;

		return player.getInteracting();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Actor opponent = getOpponent();

		if (opponent == null)
			return null;

//		int cur = opponent.getHealth();
//		int max = opponent.getMaxHealth();
		int cur = 0, max = 0; // XXX

		FontMetrics fm = graphics.getFontMetrics();

		int height = TOP_BORDER
			+ fm.getHeight(); // opponent name
		if (max > 0)
			height += 1 // between name and hp bar
				+ BAR_HEIGHT; // bar
		height += BOTTOM_BORDER;

		graphics.setColor(BACKGROUND);
		graphics.fillRect(0, 0, WIDTH, height);

		String str = opponent.getName();

		int x = (WIDTH - fm.stringWidth(str)) / 2;
		graphics.setColor(Color.white);
		graphics.drawString(str, x, fm.getHeight() + TOP_BORDER);

		// hp bar

		if (max > 0)
		{
			float percent = (float) cur / (float) max;
			if (percent > 100f)
				percent = 100f;

			int barWidth = (int) (percent * (float) BAR_WIDTH);
			int barY = TOP_BORDER + fm.getHeight() + 1;

			graphics.setColor(HP_GREEN);
			graphics.fillRect((WIDTH - BAR_WIDTH) / 2, barY, barWidth, BAR_HEIGHT);

			graphics.setColor(HP_RED);
			graphics.fillRect(((WIDTH - BAR_WIDTH) / 2) + barWidth, barY, BAR_WIDTH - barWidth, BAR_HEIGHT);

			str = cur + " / " + max;
			x = (WIDTH - fm.stringWidth(str)) / 2;
			graphics.setColor(Color.white);
			graphics.drawString(str, x, barY + fm.getHeight());
		}

		return new Dimension(WIDTH, height);
	}
}
