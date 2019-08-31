/*
 * Copyright (c) 2019, Adam Witkowski <https://github.com/adwitkow>
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
package net.runelite.client.plugins.hiscore;

import com.google.common.base.Strings;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import net.runelite.api.Experience;
import net.runelite.client.util.StackFormatter;
import java.util.Map;

@Value
@Builder
class Tooltip
{
	private static final String OPENING_TAGS = "<html><body style = 'padding: 5px;color:#989898'>";
	private static final String CLOSING_TAGS = "</body></html>";
	private static final String UNRANKED = "Unranked";

	private String title;
	private String skill;
	private int rank;
	@Builder.Default
	private long xp = -1;
	@Builder.Default
	private int remainingXp = -1;
	private boolean progressbar;
	@Singular
	private Map<String, String> others;

	String toHtml()
	{
		final StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append(OPENING_TAGS);

		if (!Strings.isNullOrEmpty(title))
		{
			contentBuilder.append(wrapNewLine(wrapTitle(title)));
		}

		if (!Strings.isNullOrEmpty(skill))
		{
			contentBuilder.append(wrapNewLine(wrapTitle("Skill") + skill));
		}

		final String rankTitle = wrapTitle("Rank");

		switch (rank)
		{
			case 0:
			{
				// We can assume that it has not been set, so we should not show it
				// (e.g. Combat Level has no rank row)
				break;
			}
			case -1:
			{
				contentBuilder.append(wrapNewLine(rankTitle + UNRANKED));
				break;
			}
			default:
			{
				contentBuilder.append(wrapNewLine(rankTitle + formatNumber(rank)));
				break;
			}
		}

		if (xp >= 0)
		{
			contentBuilder.append(wrapNewLine(wrapTitle("Experience") + formatNumber(xp)));
		}

		if (remainingXp >= 0)
		{
			contentBuilder.append(wrapNewLine(wrapTitle("Remaining XP") + formatNumber(remainingXp)));
		}

		if (progressbar)
		{
			if (xp >= 0)
			{
				final int currentXp = (int) xp;
				final int currentLevel = Experience.getLevelForXp(currentXp);
				final int xpForCurrentLevel = Experience.getXpForLevel(currentLevel);
				final int xpForNextLevel = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(currentLevel + 1) : -1;

				final double xpGained = currentXp - xpForCurrentLevel;
				final double xpGoal = xpForNextLevel != -1 ? xpForNextLevel - xpForCurrentLevel : 100;
				final int progress = (int) ((xpGained / xpGoal) * 100f);

				final String htmlProgress = "<div style='margin-top:3px;'>"
					+ "<div style = 'background: #070707; border: 1px solid #070707; height: 6px; width: 100%;'>"
					+ "<div style = 'height: 6px; width: " + progress + "%; background: #dc8a00;' />"
					+ "</div></div>";
				contentBuilder.append(htmlProgress);
			}
		}

		if (others.size() > 0)
		{
			{
				for (final Map.Entry<String, String> entry : others.entrySet())
				{
					contentBuilder.append(wrapNewLine(wrapTitle(entry.getKey()) + entry.getValue()));
				}
			}
		}

		contentBuilder.append(CLOSING_TAGS);
		return contentBuilder.toString();
	}

	private String wrapTitle(final String title)
	{
		return "<span style = 'color:white'>" + title + ":</span> ";
	}

	private String wrapNewLine(final String line)
	{
		return "<p>" + line + "</p>";
	}

	private String formatNumber(final int number)
	{
		return StackFormatter.formatNumber(number);
	}

	private String formatNumber(final long number)
	{
		return StackFormatter.formatNumber(number);
	}
}
