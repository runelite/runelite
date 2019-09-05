/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/kyleeld>
 * Copyright (c) 2019, pklite <https://github.com/pklite/pklite>
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
package net.runelite.client.plugins.freezetimers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;
import static java.awt.Color.WHITE;

@Singleton
public class FreezeTimersOverlay extends Overlay
{
	private final FreezeTimersPlugin plugin;
	private final Client client;
	private final Font timerFont = FontManager.getRunescapeBoldFont().deriveFont(14.0f);
	private final BufferedImage FREEZE_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "freeze.png");
	private final BufferedImage FREEZE_IMMUNE_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "freezeimmune.png");
	private final BufferedImage TB_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "teleblock.png");
	private final BufferedImage TB_IMMUNE_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "teleblockimmune.png");
	private final BufferedImage VENG_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "veng.png");
	private final Timers timers;


	@Inject
	public FreezeTimersOverlay(final FreezeTimersPlugin plugin, final Client client, final Timers timers)
	{
		this.plugin = plugin;
		this.client = client;
		this.timers = timers;
		setPriority(OverlayPriority.HIGHEST);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isShowPlayers())
		{
			client.getPlayers().forEach((p) -> renderOverlayFor(graphics, p));
		}
		if (plugin.isShowNpcs())
		{
			client.getNpcs().forEach((npc) -> renderOverlayFor(graphics, npc));
		}
		return null;
	}

	private void renderOverlayFor(Graphics2D g, Actor actor)
	{
		if (timers.areAllTimersZero(actor))
		{
			return;
		}

		int overlaysDrawn = 0;

		if (drawFreezeOverlay(g, actor, overlaysDrawn) && plugin.isFreezeTimers())
		{
			overlaysDrawn++;
		}
		if (drawTBOverlay(g, actor, overlaysDrawn) && plugin.isTB())
		{
			overlaysDrawn++;
		}
		if (drawVengOverlay(g, actor, overlaysDrawn) && plugin.isVeng())
		{
			overlaysDrawn++;
		}
	}

	private boolean drawFreezeOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		final long currentTick = System.currentTimeMillis();
		if (timers.getTimerReApply(actor, TimerType.FREEZE) <= currentTick)
		{
			return false;
		}

		long finishedAt;
		BufferedImage image;
		if (timers.getTimerEnd(actor, TimerType.FREEZE) > currentTick)
		{
			finishedAt = timers.getTimerEnd(actor, TimerType.FREEZE);
			image = FREEZE_IMAGE;
		}
		else
		{
			finishedAt = timers.getTimerReApply(actor, TimerType.FREEZE);
			image = FREEZE_IMMUNE_IMAGE;
		}

		final String text = processTickCounter(finishedAt);
		final Point poi = actor.getCanvasTextLocation(g, text, 0);

		if (poi == null)
		{
			return false;
		}

		final Point fixedPoint = new Point(poi.getX(), poi.getY());

		if (plugin.isNoImage())
		{
			if (image == FREEZE_IMAGE)
			{
				OverlayUtil.renderTextLocation(g, text, plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.WHITE, fixedPoint, false, 0);
			}
			else
			{
				OverlayUtil.renderTextLocation(g, text, plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.YELLOW, fixedPoint, false, 0);
			}
		}
		else
		{
			renderActorText(g, actor, text, overlaysDrawn, image);
		}
		return true;
	}

	private boolean drawTBOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		final long currentTick = System.currentTimeMillis();
		if (!plugin.isTB())
		{
			return false;
		}
		if (timers.getTimerReApply(actor, TimerType.TELEBLOCK) <= currentTick)
		{
			return false;
		}

		long finishedAt;
		BufferedImage image;
		if (timers.getTimerEnd(actor, TimerType.TELEBLOCK) > currentTick)
		{
			finishedAt = timers.getTimerEnd(actor, TimerType.TELEBLOCK);
			image = TB_IMAGE;
		}
		else
		{
			finishedAt = timers.getTimerReApply(actor, TimerType.TELEBLOCK);
			image = TB_IMMUNE_IMAGE;
		}

		final String text = processTickCounter(finishedAt);
		final Point poi = actor.getCanvasTextLocation(g, text, 0);

		if (poi == null)
		{
			return false;
		}

		final Point fixedPoint = new Point(poi.getX() + 20, poi.getY());

		if (plugin.isNoImage())
		{
			if (timers.getTimerReApply(actor, TimerType.FREEZE) <= currentTick)
			{
				OverlayUtil.renderTextLocation(g, text, plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.CYAN, poi, false, 0);
			}
			else
			{
				OverlayUtil.renderTextLocation(g, " | " + text, plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.CYAN, fixedPoint, false, 0);
			}

			if (timers.getTimerReApply(actor, TimerType.VENG) >= currentTick)
			{
				OverlayUtil.renderTextLocation(g, " | " + text, plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.CYAN, fixedPoint, false, 0);
			}
		}
		else
		{
			renderActorText(g, actor, text, overlaysDrawn, image);
		}
		return true;
	}

	private boolean drawVengOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		final long currentTick = System.currentTimeMillis();
		if (!plugin.isVeng())
		{
			return false;
		}
		if (timers.getTimerEnd(actor, TimerType.VENG) <= currentTick)
		{
			return false;
		}
		final long finishedAt = timers.getTimerEnd(actor, TimerType.VENG);

		final String text = processTickCounter(finishedAt);
		final Point poi = actor.getCanvasTextLocation(g, text, 0);

		if (poi == null)
		{
			return false;
		}

		final Point fixedPoint = new Point(poi.getX() - 20, poi.getY());
		if (plugin.isNoImage())
		{
			if (timers.getTimerEnd(actor, TimerType.FREEZE) <= currentTick)
			{
				OverlayUtil.renderTextLocation(g, text, plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.RED, poi, false, 0);
			}
			if (timers.getTimerEnd(actor, TimerType.FREEZE) >= currentTick)
			{
				OverlayUtil.renderTextLocation(g, text + " | ", plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.RED, fixedPoint, false, 0);
			}
			if (timers.getTimerEnd(actor, TimerType.TELEBLOCK) >= currentTick)
			{
				OverlayUtil.renderTextLocation(g, text + " | ", plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.RED, fixedPoint, false, 0);
			}
		}
		else
		{
			renderActorText(g, actor, text, overlaysDrawn, VENG_IMAGE);
		}
		return true;
	}

	private void renderActorText(Graphics2D g, Actor actor, String text, int overlaysDrawn, BufferedImage image)
	{
		final int yOffset = (overlaysDrawn * 18);
		g.setFont(timerFont);
		g.setColor(WHITE);
		final int xOffset = plugin.getOffset();
		renderActorTextAndImage(g, actor, text, Color.WHITE, image, yOffset,
				xOffset);
	}

	private void renderImageLocation(Graphics2D graphics, Point imgLoc, BufferedImage image)
	{
		final int x = imgLoc.getX();
		final int y = imgLoc.getY();

		graphics.drawImage(image, x, y, null);
	}

	private void renderActorTextAndImage(Graphics2D graphics, Actor actor, String text, Color color, BufferedImage image, int yOffset, int xOffset)
	{
		Point textLocation = new Point(actor.getCanvasImageLocation(image, 0).getX() + xOffset, actor.getCanvasImageLocation(image, 0).getY() + yOffset);
		renderImageLocation(graphics, textLocation, image);
		xOffset = image.getWidth() + 1;
		yOffset = (image.getHeight() - (int) graphics.getFontMetrics().getStringBounds(text, graphics).getHeight());
		textLocation = new Point(textLocation.getX() + xOffset, textLocation.getY() + image.getHeight() - yOffset);
		OverlayUtil.renderTextLocation(graphics, textLocation, text, color);
	}

	private String processTickCounter(long finishedAt)
	{
		final long currentTick = System.currentTimeMillis();
		final long tickDifference = finishedAt - currentTick;
		long seconds = tickDifference / 1000;
		seconds++;
		final int minutes = (int) (seconds / 60);
		seconds = seconds % 60;
		String text = seconds > 9 ? seconds + "" : "0" + seconds;
		if (minutes > 0)
		{
			text = minutes + ":" + text;
		}
		return text + "";
	}
}
