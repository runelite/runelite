/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.WidgetInfo;

public abstract class Overlay
{
	private OverlayPosition position; // where to draw it
	private OverlayPriority priority; // if multiple overlays exist in the same position, who wins
	private Rectangle bounds; //screen bounds of overlay after OverlayRenderer decides location
	private boolean drawOverLoginScreen = false;
	private boolean drawOverBankScreen = false;
	private boolean drawOverClickToPlayScreen = false;

	public Overlay(OverlayPosition position)
	{
		this(position, OverlayPriority.NONE);
	}

	public Overlay(OverlayPosition position, OverlayPriority priority)
	{
		this.position = position;
		this.priority = priority;
	}

	public OverlayPosition getPosition()
	{
		return position;
	}

	public void setPosition(OverlayPosition position)
	{
		this.position = position;
	}

	public OverlayPriority getPriority()
	{
		return priority;
	}

	public void setPriority(OverlayPriority priority)
	{
		this.priority = priority;
	}

	public abstract Dimension render(Graphics2D graphics);

	public Rectangle getBounds()
	{
		return bounds;
	}

	public void storeBounds(Rectangle bounds)
	{
		this.bounds = bounds;
	}

	public boolean shouldDraw(Client client)
	{
		if (client == null)
		{
			return false;
		}
		if (!drawOverLoginScreen && client.getGameState() != GameState.LOGGED_IN)
		{
			return false;
		}
		if (!drawOverClickToPlayScreen && client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null)
		{
			return false;
		}
		if (!drawOverBankScreen && client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER) != null)
		{
			return false;
		}
		return true;
	}

	public void setDrawOverLoginScreen(boolean drawOverLoginScreen)
	{
		this.drawOverLoginScreen = drawOverLoginScreen;
	}

	public void setDrawOverBankScreen(boolean drawOverBankScreen)
	{
		this.drawOverBankScreen = drawOverBankScreen;
	}

	public void setDrawOverClickToPlayScreen(boolean drawOverClickToPlayScreen)
	{
		this.drawOverClickToPlayScreen = drawOverClickToPlayScreen;
	}
}
