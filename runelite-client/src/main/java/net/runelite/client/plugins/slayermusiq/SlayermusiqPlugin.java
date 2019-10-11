/*
 * Copyright (c) 2018, Jeremy Berchtold <https://github.com/i-yam-jeremy>
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


// Based off RuneLite's Wiki Plugin
/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.slayermusiq;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuOpcode;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.api.util.Text;

@PluginDescriptor(
	name = "Slayermusiq1 Guides",
	description = "Adds a right-click option to go to Slayermusiq1's guides from the quest tab",
	tags = {"quest", "guide", "slayermusiq"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class SlayermusiqPlugin extends Plugin
{

	private static final int[] QUESTLIST_WIDGET_IDS = new int[]
		{
			WidgetInfo.QUESTLIST_FREE_CONTAINER.getId(),
			WidgetInfo.QUESTLIST_MEMBERS_CONTAINER.getId(),
			WidgetInfo.QUESTLIST_MINIQUEST_CONTAINER.getId(),
		};

	private static final String MENUOP_SLAYERMUSIQ = "Slayermusiq";

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private EventBus eventBus;

	@Override
	protected void startUp() throws Exception
	{
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetID = event.getParam1();
		if (Ints.contains(QUESTLIST_WIDGET_IDS, widgetID) && "Read Journal:".equals(event.getOption()))
		{
			MenuEntry[] menuEntries = client.getMenuEntries();

			MenuEntry newMenuEntry = createSlayermusiqOptionMenuEntry(event);
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);
			menuEntries[menuEntries.length - 1] = newMenuEntry;

			client.setMenuEntries(menuEntries);
		}
	}

	private void onMenuOptionClicked(MenuOptionClicked ev)
	{
		if (ev.getMenuOpcode() == MenuOpcode.RUNELITE && ev.getOption().equals(MENUOP_SLAYERMUSIQ))
		{
			ev.consume();
			String quest = Text.removeTags(ev.getTarget());
			QuestGuideLinks.tryOpenGuide(quest, chatMessageManager);
		}
	}

	private MenuEntry createSlayermusiqOptionMenuEntry(MenuEntryAdded event)
	{
		int widgetIndex = event.getParam0();
		int widgetID = event.getParam1();

		MenuEntry menuEntry = new MenuEntry();
		menuEntry.setTarget(event.getTarget());
		menuEntry.setOption(MENUOP_SLAYERMUSIQ);
		menuEntry.setParam0(widgetIndex);
		menuEntry.setParam1(widgetID);
		menuEntry.setOpcode(MenuOpcode.RUNELITE.getId());

		return menuEntry;
	}

}