/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.questtab;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Quest List Filtering"
)
public class QuestTabPlugin extends Plugin
{
	@Inject
	private ClientThread clientThread;

	@Inject
	private Client client;

	@Inject
	private QuestTabConfig config;

	@Provides
	QuestTabConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(QuestTabConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged e)
	{
		clientThread.invokeLater(() -> client.runScript(
			ScriptID.QUEST_LIST_INIT,
			WidgetInfo.QUEST_LIST_CONTROL.getId(),
			WidgetInfo.QUEST_LIST_LISTS.getId(),
			WidgetInfo.QUEST_LIST_SCROLLBAR.getId(),
			WidgetInfo.QUEST_LIST_QP.getId(),
			WidgetInfo.QUEST_LIST_FREE.getId(),
			WidgetInfo.QUEST_LIST_MEMBERS.getId(),
			WidgetInfo.QUEST_LIST_MINIQUESTS.getId()
		));
	}

	@Subscribe
	public void onScriptEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();
		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();

		switch (eventName)
		{
			case "questListTypeFilter":

				if (intStack[intStackSize - 3] == WidgetInfo.QUEST_LIST_FREE.getId())
				{
					intStack[intStackSize - 1] = config.hideFree() ? 1 : 0;
					// -8 will be the return value of QuestListItemInit.rs2asm
					// this effectively nullifies the gap added after the free quest list section
					intStack[intStackSize - 3] = -8;
				}
				else if (intStack[intStackSize - 3] == WidgetInfo.QUEST_LIST_MEMBERS.getId())
				{
					intStack[intStackSize - 1] = config.hideMembers() ? 1 : 0;
					// -8 will be the return value of QuestListItemInit.rs2asm
					// this effectively nullifies the gap added after the members quest list section
					intStack[intStackSize - 3] = -8;
				}
				else if (intStack[intStackSize - 3] == WidgetInfo.QUEST_LIST_MINIQUESTS.getId())
				{
					intStack[intStackSize - 1] = config.hideMiniquests() ? 1 : 0;
					// 0 will be the return value of QuestListItemInit.rs2asm
					// the gap normally at the bottom of the quest list will remain the same, no matter what is filtered
					intStack[intStackSize - 3] = 0;
				}

				break;
			case "questListProgressFilter":

				// progress == 2 means completed
				if (intStack[intStackSize - 3] == 2)
				{
					intStack[intStackSize - 1] = config.hideCompleted() ? 1 : 0;
				}
				// progress == 0 means in progress
				else if (intStack[intStackSize - 3] == 0)
				{
					intStack[intStackSize - 1] = config.hideInProgress() ? 1 : 0;
				}
				// progress == 1 means not started
				else if (intStack[intStackSize - 3] == 1)
				{
					intStack[intStackSize - 1] = config.hideNotStarted() ? 1 : 0;
				}

				break;
		}
	}

}
