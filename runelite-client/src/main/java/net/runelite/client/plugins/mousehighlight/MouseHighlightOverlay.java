/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.mousehighlight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

class MouseHighlightOverlay extends Overlay
{
	// Grabs the colour and name from a target string
	// <col=ffffff>Player1
	private final Pattern p = Pattern.compile("<col=([^>]+)>([^<]*)");
	private final MouseHighlightConfig config;

	MouseHighlightOverlay(MouseHighlight plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.config = plugin.getConfig();
	}
	@Override
	public Dimension render(Graphics2D graphics)
	{
		Client client = RuneLite.getClient();

		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return null;
		}

		if (client.isMenuOpen())
		{
			return null;
		}

		String[] targets = client.getMenuTargets();
		String[] options = client.getMenuOptions();
		int count = client.getMenuOptionCount() - 1;

		if (count < 0 || count >= targets.length || count >= options.length)
		{
			return null;
		}

		String target = targets[count];
		String option = options[count];

		if (target.isEmpty())
		{
			return null;
		}

		// Trivial options that don't need to be highlighted, add more as they appear.
		switch (option)
		{
			case "Walk here":
			case "Cancel":
			case "Continue":
				return null;
		}

		Matcher m = p.matcher(target);

		List<String> parts = new ArrayList<>();
		List<String> colours = new ArrayList<>();

		while (m.find())
		{
			colours.add(m.group(1));
			parts.add(m.group(2));
		}

		if (parts.isEmpty())
		{
			return null;
		}

		// Remove colour text from option
		option = option.replaceAll("<col=([^>]+)>", "");

		Point mouse = client.getMouseCanvasPosition();
		int x = mouse.getX();
		int y = mouse.getY();

		FontMetrics fm = graphics.getFontMetrics();
		// Gets the widths of the various strings we will be displaying
		int option_width = fm.stringWidth(option + " ");
		int total_width = option_width;
		for (String part : parts)
		{
			total_width += fm.stringWidth(part);
		}
		int height = fm.getHeight();

		if (config.display_left())
			x -= total_width + 6; //Draw to the left of the mouse
		y -= height / 2; // Draw slightly above the mouse

		// Don't draw off of the screen (left and right)
		if (config.display_left())
		{
			if (x < 0)
			{
				x = 0;
			}
		}
		else
		{
			int canvas_width = client.getCanvas().getWidth();
			if (x + total_width + 7 > canvas_width)
			{
				x = canvas_width - total_width - 7;
			}
		}

		// Don't draw off of the screen (top)
		if (y < 0)
		{
			y = 0;
		}

		Color gray = new Color(Color.darkGray.getRed(), Color.darkGray.getGreen(), Color.darkGray.getBlue(), 190);
		graphics.setColor(gray);

		// Draws the background rect
		graphics.fillRect(x, y - (height / 2), total_width + 6, height);

		// Draws the outline of the rect
		graphics.setColor(config.borderColor());
		graphics.drawRect(x, y - (height / 2), total_width + 6, height);
		x += 3;
		y += 5;

		graphics.setColor(Color.white);
		// Draws the option (Use, Walk here, Wield)
		graphics.drawString(option + " ", x, y);
		// Write text
		int parts_width = 0;
		for (int i = 0; i < parts.size(); i++)
		{
			// Sets the string colour to the colour the game uses.
			graphics.setColor(Color.decode("#" + colours.get(i)));
			// Draws the target (Player, item)
			graphics.drawString(parts.get(i), x + option_width + parts_width, y);

			parts_width += fm.stringWidth(parts.get(i));
		}

		graphics.setColor(Color.white);

		return null;
	}
}
