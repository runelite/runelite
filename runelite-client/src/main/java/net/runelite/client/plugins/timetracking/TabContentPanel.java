/*
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
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
package net.runelite.client.plugins.timetracking;

import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import javax.swing.JPanel;

public abstract class TabContentPanel extends JPanel
{
	/**
	 * Gets the update interval of this panel, in units of 200 milliseconds
	 * (the plugin panel checks if its contents should be updated every 200 ms;
	 * this can be considered its "tick rate").
	 */
	public abstract int getUpdateInterval();

	public abstract void update();

	@Override
	public Dimension getPreferredSize()
	{
		return super.getPreferredSize();
	}

	protected static String getFormattedEstimate(long remainingSeconds, boolean useRelativeTime)
	{
		if (useRelativeTime)
		{
			StringBuilder sb = new StringBuilder("in ");
			long duration = (remainingSeconds + 59) / 60;
			long minutes = duration % 60;
			long hours = (duration / 60) % 24;
			long days = duration / (60 * 24);
			if (days > 0)
			{
				sb.append(days).append("d ");
			}
			if (hours > 0)
			{
				sb.append(hours).append("h ");
			}
			if (minutes > 0)
			{
				sb.append(minutes).append("m ");
			}
			return sb.toString();
		}
		else
		{
			StringBuilder sb = new StringBuilder();
			LocalDateTime endTime = LocalDateTime.now().plus(remainingSeconds, ChronoUnit.SECONDS);
			LocalDateTime currentTime = LocalDateTime.now();
			if (endTime.getDayOfWeek() != currentTime.getDayOfWeek())
			{
				sb.append(endTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault())).append(" ");
			}
			sb.append(String.format("at %d:%02d", endTime.getHour(), endTime.getMinute()));
			return sb.toString();
		}
	}
}
