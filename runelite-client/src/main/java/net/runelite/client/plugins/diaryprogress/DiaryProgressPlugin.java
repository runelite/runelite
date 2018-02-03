/*
 * Copyright (c) 2018, oplosthee <https://github.com/oplosthee>
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
package net.runelite.client.plugins.diaryprogress;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Diary Progress plugin"
)
public class DiaryProgressPlugin extends Plugin
{
	private static final String STAGE_FINISHED_STRING = "<col=00ff00>X</col>";
	private static final String STAGE_UNFINISHED_STRING = "<col=ffff00>_</col>";

	@Inject
	private Client client;

	@Inject
	private DiaryProgressConfig config;

	@Provides
	DiaryProgressConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DiaryProgressConfig.class);
	}

	@Subscribe
	public void updateDiaryStatus(GameTick event)
	{
		Widget diaryWidget = client.getWidget(WidgetInfo.DIARY_LIST);

		if (diaryWidget == null)
		{
			return;
		}

		for (DiaryEntry entry : DiaryEntry.values())
		{
			Widget child = diaryWidget.getChild(entry.getIndex());
			StringBuilder progress = new StringBuilder();

			if (config.enabled())
			{
				for (Varbits varbits : entry.getVarbits())
				{
					int value = client.getSetting(varbits);
					if ((entry != DiaryEntry.KARAMJA && value == 1) || value == 2)
					{
						progress.append(STAGE_FINISHED_STRING);
					}
					else
					{
						progress.append(STAGE_UNFINISHED_STRING);
					}
				}

				progress.append("</col> ").append(entry.getName());
			}
			else
			{
				progress.append(entry.getName());
			}

			child.setText(progress.toString());
		}
	}
}
