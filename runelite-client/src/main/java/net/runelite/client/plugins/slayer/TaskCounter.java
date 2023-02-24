/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.plugins.slayer;

import joptsimple.internal.Strings;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.util.ColorUtil;
import java.awt.Color;
import java.awt.image.BufferedImage;

class TaskCounter extends Counter
{
	TaskCounter(BufferedImage img, Plugin plugin, int amount)
	{
		super(img, plugin, amount);
	}

	public void setTooltip(Task task, int initialAmount, int points, int normalStreak, int wildernessStreak)
	{
		if (task == null || !task.isValid())
		{
			return;
		}

		final String location = task.getLocation().getName();

		String taskTooltip = ColorUtil.wrapWithColorTag("%s", new Color(255, 119, 0)) + "</br>";

		if (!Strings.isNullOrEmpty(location))
		{
			taskTooltip += location + "</br>";
		}

		taskTooltip += ColorUtil.wrapWithColorTag("Pts:", Color.YELLOW)
				+ " %s</br>"
				+ ColorUtil.wrapWithColorTag("Streak:", Color.YELLOW)
				+ " %s";

		if (initialAmount > 0)
		{
			taskTooltip += "</br>"
					+ ColorUtil.wrapWithColorTag("Start:", Color.YELLOW)
					+ " " + initialAmount;
		}

		final int streak = task.getMaster() == SlayerMaster.KRYSTILIA
				? wildernessStreak
				: normalStreak;

		super.setTooltip(String.format(taskTooltip, capsString(task.getName()), points, streak == -1 ? "unknown" : streak));
	}

	private String capsString(String str)
	{
		return Strings.isNullOrEmpty(str) ? "" : str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
