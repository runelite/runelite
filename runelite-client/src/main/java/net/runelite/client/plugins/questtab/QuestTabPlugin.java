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
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Quest List Filtering"
)
public class QuestTabPlugin extends Plugin
{
	@Getter
	private boolean showApplyChangesOverlay = false;

	@Inject
	private Client client;

	@Inject
	private QuestTabConfig config;

	@Inject
	private QuestTabOverlay overlay;

	@Provides
	QuestTabConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(QuestTabConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged e)
	{
		if (e.getGroup().equals("questtab"))
		{
			showApplyChangesOverlay = true;
		}
	}

	@Subscribe
	public void onScriptEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();
		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();

		switch (eventName)
		{
			case "initFreeQuests":
				intStack[intStackSize - 1] = config.hideFree() ? 1 : 0;
				showApplyChangesOverlay = false;
				break;
			case "initMembersQuests":
				intStack[intStackSize - 1] = config.hideMembers() ? 1 : 0;
				showApplyChangesOverlay = false;
				break;
			case "initMiniquests":
				intStack[intStackSize - 1] = config.hideMiniquests() ? 1 : 0;
				showApplyChangesOverlay = false;
				break;
			case "questListFilterComplete":
				intStack[intStackSize - 1] = config.hideCompleted() ? 1 : 0;
				showApplyChangesOverlay = false;
				break;
			case "questListFilterInProgress":
				intStack[intStackSize - 1] = config.hideInProgress() ? 1 : 0;
				showApplyChangesOverlay = false;
				break;
			case "questListFilterNotStarted":
				intStack[intStackSize - 1] = config.hideNotStarted() ? 1 : 0;
				showApplyChangesOverlay = false;
				break;
		}
	}

}
