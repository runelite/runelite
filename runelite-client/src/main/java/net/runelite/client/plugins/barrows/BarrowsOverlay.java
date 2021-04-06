/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class BarrowsOverlay extends Overlay
{
	private final Client client;
	private final BarrowsPlugin plugin;
	private final BarrowsConfig config;

	@Inject
	private BarrowsOverlay(Client client, BarrowsPlugin plugin, BarrowsConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget puzzleAnswer = plugin.getPuzzleAnswer();

		if (config.showBrotherLoc())
		{
			renderBarrowsBrothers(graphics);
		}

		if (puzzleAnswer != null && config.showPuzzleAnswer() && !puzzleAnswer.isHidden())
		{
			Rectangle answerRect = puzzleAnswer.getBounds();
			graphics.setColor(Color.GREEN);
			graphics.draw(answerRect);
		}

		return null;
	}

	private void renderBarrowsBrothers(Graphics2D graphics)
	{
		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			LocalPoint localLocation = LocalPoint.fromWorld(client, brother.getLocation());

			if (localLocation == null)
			{
				continue;
			}

			String brotherLetter = Character.toString(brother.getName().charAt(0));
			net.runelite.api.Point minimapText = Perspective.getCanvasTextMiniMapLocation(client, graphics,
				localLocation, brotherLetter);

			if (minimapText != null)
			{
				graphics.setColor(Color.black);
				graphics.drawString(brotherLetter, minimapText.getX() + 1, minimapText.getY() + 1);

				if (client.getVar(brother.getKilledVarbit()) > 0)
				{
					graphics.setColor(config.deadBrotherLocColor());
				}
				else
				{
					graphics.setColor(config.brotherLocColor());
				}

				graphics.drawString(brotherLetter, minimapText.getX(), minimapText.getY());
			}
		}
	}
}