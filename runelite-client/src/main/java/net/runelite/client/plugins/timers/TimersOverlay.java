/*
 *
 *  * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 *  * All rights reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are permitted provided that the following conditions are met:
 *  *
 *  * 1. Redistributions of source code must retain the above copyright notice, this
 *  *    list of conditions and the following disclaimer.
 *  * 2. Redistributions in binary form must reproduce the above copyright notice,
 *  *    this list of conditions and the following disclaimer in the documentation
 *  *    and/or other materials provided with the distribution.
 *  *
 *  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.plugins.timers;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import static net.runelite.client.plugins.timers.GameTimers.*;

public class TimersOverlay extends Overlay
{
	private int BOXSIZE = 40;

	private static final int SEPARATOR = 2;

	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);

	public static java.util.List<Timers> timers = new ArrayList<>();

	private final BufferedImage[] imgCache = new BufferedImage[GameTimers.values().length];

	private static final Logger logger = LoggerFactory.getLogger(TimersOverlay.class);

	private final TimersConfig config;
	private final TimersPlugin plugin;

	public TimersOverlay(TimersPlugin plugin)
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.LOW);
		this.config = plugin.getConfig();
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Client client = RuneLite.getClient();

		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return null;
		}

		if (timers.size() == 0)
		{
			return null;
		}

		FontMetrics metrics = graphics.getFontMetrics();

		int WIDTH = timers.size() * BOXSIZE;
		int x = 0;

		graphics.setColor(BACKGROUND);
		graphics.fillRect(0, 0, WIDTH, BOXSIZE);

		Instant now = Instant.now();
		for (Timers timer : new ArrayList<>(timers))
		{
			if (timer.getTimer().isBefore(now))
			{
				timers.remove(timer);
				continue;
			}

			// calculate time left
			Duration timeLeft = Duration.between(Instant.now(), timer.getTimer());

			BufferedImage timeIcon = getTimerImage(plugin.findTimer(timer.getName()));
			if (timeIcon != null)
			{
				graphics.drawImage(timeIcon, x + (BOXSIZE - timeIcon.getWidth()) / 2, SEPARATOR, null);
			}

			String str = formatTime(timeLeft.toMillis());

			//text shaddow
			graphics.setColor(Color.black);
			graphics.drawString(str, x + ((BOXSIZE - metrics.stringWidth(str)) / 2) + 1, BOXSIZE - SEPARATOR + 1);

			//check if timer has 10% of time left
			if (timeLeft.getSeconds() < (timer.getTime() * .10))
			{
				graphics.setColor(Color.red.brighter());
			}
			else
			{
				graphics.setColor(Color.white);
			}
			graphics.drawString(str, x + ((BOXSIZE - metrics.stringWidth(str)) / 2), BOXSIZE - SEPARATOR );

			x += BOXSIZE;
		}

		return new Dimension(WIDTH, BOXSIZE);
	}

	private BufferedImage getTimerImage(GameTimers timer)
	{
		int timerIdx = timer.ordinal();
		BufferedImage timerImage = null;

		if (imgCache[timerIdx] != null)
		{
			return imgCache[timerIdx];
		}

		try
		{
			InputStream in = TimersOverlay.class.getResourceAsStream(timer.getName() + ".png");
			timerImage = ImageIO.read(in);
			imgCache[timerIdx] = timerImage;
		}
		catch (IOException e)
		{
			logger.warn("Error Loading timer icon", e);
		}

		return timerImage;
	}

	public String formatTime(final long time)
	{
		final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
		return (m < 10 ? "0" + m : m) + ":" + (s < 10 ? "0" + s : s);
	}

	public void updateConfig()
	{
		if (!config.showStamina())
		{
			plugin.removeGameTimer(STAMINA);
		}
		if (!config.showAntiFire())
		{
			plugin.removeGameTimer(ANTIFIRE);
		}
		if (!config.showExAntiFire())
		{
			plugin.removeGameTimer(EXANTIFIRE);
		}
		if (!config.showOverload())
		{
			plugin.removeGameTimer(OVERLOAD);
		}
		if (!config.showCannon())
		{
			plugin.removeGameTimer(CANNON);
		}
		if (!config.showMagicImbue())
		{
			plugin.removeGameTimer(MAGICIMBUE);
		}
		if (!config.showAntiVenom())
		{
			plugin.removeGameTimer(SUPERANTIVENOM);
		}
		if (!config.showTeleblock())
		{
			plugin.removeGameTimer(FULLTB);
			plugin.removeGameTimer(HALFTB);
		}
	}
}
