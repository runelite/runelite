/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package net.runelite.client.plugins.attackindicator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

public class AttackIndicatorOverlay extends Overlay
{
	private static final int ANCHOR_X = -4;
	private static final int ANCHOR_Y = -1;
	private static final int BORDER_SIZE = 2;
	private static final Color BACKGROUND_COLOR = new Color(56, 48, 35, 100);
	private static final Color OUTSIDE_STROKE_COLOR = new Color(56, 48, 35, 255);
	private static final Color INSIDE_STROKE_COLOR = new Color(90, 82, 69, 255);

	@Inject
	@Nullable
	Client client;

	private final AttackIndicatorConfig config;
	private final AttackIndicatorPlugin plugin;

	@Inject
	public AttackIndicatorOverlay(AttackIndicatorPlugin plugin, AttackIndicatorConfig config)
	{
		super(OverlayPosition.DYNAMIC);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.enabled() || client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		Rectangle chatbox = getChatboxBounds();
		if (chatbox == null)
		{
			return null;
		}

		// Setup string
		graphics.setFont(FontManager.getRunescapeFont());
		FontMetrics fm = graphics.getFontMetrics();
		String attackStyleString = plugin.getAttackStyle().getName();

		// Create anchor point
		Point anchor = new Point(chatbox.x + chatbox.width + ANCHOR_X, chatbox.y + ANCHOR_Y);

		// Calculate size of background
		Rectangle background = fm.getStringBounds(attackStyleString, graphics).getBounds();
		background.setBounds(background.x, background.y, background.width + BORDER_SIZE, background.height + BORDER_SIZE);

		// Render background
		graphics.setColor(BACKGROUND_COLOR);
		graphics.fillRect(anchor.x - background.width, anchor.y - background.height, background.width, background.height);

		// Render outside stroke
		graphics.setColor(OUTSIDE_STROKE_COLOR);
		graphics.drawRect(anchor.x - background.width, anchor.y - background.height, background.width + BORDER_SIZE / 2, background.height + BORDER_SIZE / 2);

		// Render inside stroke
		graphics.setColor(INSIDE_STROKE_COLOR);
		graphics.drawRect(anchor.x - background.width + BORDER_SIZE / 2, anchor.y - background.height + BORDER_SIZE / 2, background.width - BORDER_SIZE / 2, background.height - BORDER_SIZE / 2);

		// Render text with shadow
		graphics.setColor(Color.BLACK);
		graphics.drawString(attackStyleString, anchor.x - background.width + 3, anchor.y);
		graphics.setColor(Color.WHITE);
		graphics.drawString(attackStyleString, anchor.x - background.width + 2, anchor.y - 1);

		return null;
	}

	private Rectangle getChatboxBounds()
	{
		Widget chatbox = client.getWidget(WidgetInfo.CHATBOX);
		return chatbox != null ? chatbox.getBounds() : null;
	}
}
