/*
 * Copyright (c) 2019 Spudjb <https://github.com/spudjb>
 * Copyright (c) 2022 Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.questlist;

import com.google.common.base.Strings;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.DBTableID;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.SpriteID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Quest List",
	description = "Adds a search filter to the quest list"
)
public class QuestListPlugin extends Plugin
{
	private static final String MENU_OPEN = "Open";
	private static final String MENU_CLOSE = "Close";
	private static final String MENU_SEARCH = "Search";

	@Inject
	private Client client;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ClientThread clientThread;

	private ChatboxTextInput searchInput;
	private Widget questSearchButton;

	@Override
	protected void startUp()
	{
		clientThread.invoke(this::addQuestButtons);
	}

	@Override
	protected void shutDown()
	{
		Widget header = client.getWidget(InterfaceID.Questlist.UNIVERSE);
		if (header != null)
		{
			header.deleteAllChildren();
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.QUESTLIST_INIT)
		{
			addQuestButtons();
		}
	}

	private void addQuestButtons()
	{
		Widget header = client.getWidget(InterfaceID.Questlist.UNIVERSE);
		if (header != null)
		{
			header.deleteAllChildren();

			questSearchButton = header.createChild(-1, WidgetType.GRAPHIC);
			questSearchButton.setSpriteId(SpriteID.GeSmallicons.SEARCH);
			questSearchButton.setOriginalWidth(18);
			questSearchButton.setOriginalHeight(17);
			questSearchButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
			questSearchButton.setOriginalX(5);
			questSearchButton.setOriginalY(0);
			questSearchButton.setHasListener(true);
			questSearchButton.setAction(1, MENU_OPEN);
			questSearchButton.setOnOpListener((JavaScriptCallback) e -> openSearch());
			questSearchButton.setName(MENU_SEARCH);
			questSearchButton.revalidate();
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		if (isChatboxOpen() && !isOnQuestTab())
		{
			chatboxPanelManager.close();
		}
	}

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged varClientIntChanged)
	{
		if (varClientIntChanged.getIndex() == VarClientID.TOPLEVEL_PANEL)
		{
			if (isChatboxOpen() && !isOnQuestTab())
			{
				chatboxPanelManager.close();
			}
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		if (!"questFilter".equals(scriptCallbackEvent.getEventName()) || !isChatboxOpen())
		{
			return;
		}

		final String filter = searchInput.getValue();
		if (Strings.isNullOrEmpty(filter))
		{
			return;
		}

		final int[] intStack = client.getIntStack();
		final int intStackSize = client.getIntStackSize();

		final int row = intStack[intStackSize - 1];
		final String questName = (String) client.getDBTableField(row, DBTableID.Quest.COL_DISPLAYNAME, 0)[0];

		intStack[intStackSize - 2] = questName.toLowerCase().contains(filter.toLowerCase()) ? 0 : 1;
	}

	private boolean isOnQuestTab()
	{
		return client.getVarbitValue(VarbitID.SIDE_JOURNAL_TAB) == 1 && client.getVarcIntValue(VarClientID.TOPLEVEL_PANEL) == 2;
	}

	private boolean isChatboxOpen()
	{
		return searchInput != null && chatboxPanelManager.getCurrentInput() == searchInput;
	}

	private void closeSearch()
	{
		chatboxPanelManager.close();
		redrawQuests();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void openSearch()
	{
		client.playSoundEffect(SoundEffectID.UI_BOOP);
		questSearchButton.setAction(1, MENU_CLOSE);
		questSearchButton.setOnOpListener((JavaScriptCallback) e -> closeSearch());
		searchInput = chatboxPanelManager.openTextInput("Search quest list")
			.onChanged(s -> redrawQuests())
			.onDone(s -> false)
			.onClose(() ->
			{
				redrawQuests();
				questSearchButton.setOnOpListener((JavaScriptCallback) e -> openSearch());
				questSearchButton.setAction(1, MENU_OPEN);
			})
			.build();
	}

	private void redrawQuests()
	{
		Widget w = client.getWidget(InterfaceID.Questlist.CONTAINER);
		if (w == null)
		{
			return;
		}

		Object[] onVarTransmitListener = w.getOnVarTransmitListener();
		if (onVarTransmitListener == null)
		{
			return;
		}

		clientThread.invokeLater(() ->
			client.runScript(onVarTransmitListener));
	}
}
