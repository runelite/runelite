/*
 * Copyright (c) 2019 Spudjb <https://github.com/spudjb>
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

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientInt;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Quest List",
	description = "Adds searching and filtering to the quest list"
)
public class QuestListPlugin extends Plugin
{
	private static final int ENTRY_PADDING = 8;
	private static final List<String> QUEST_HEADERS = ImmutableList.of("Free Quests", "Members' Quests", "Miniquests");

	private static final String MENU_OPEN = "Open";
	private static final String MENU_CLOSE = "Close";

	private static final String MENU_TOGGLE = "Toggle";

	private static final String MENU_SEARCH = "Search";
	private static final String MENU_SHOW = "Show";

	@Inject
	private Client client;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ClientThread clientThread;

	private ChatboxTextInput searchInput;
	private Widget questSearchButton;
	private Widget questHideButton;

	private EnumMap<QuestContainer, Collection<QuestWidget>> questSet;

	private QuestState currentFilterState;

	@Override
	protected void startUp()
	{
		currentFilterState = QuestState.ALL;
		clientThread.invoke(this::addQuestButtons);
	}

	@Override
	protected void shutDown()
	{
		currentFilterState = null;
		Widget header = client.getWidget(WidgetInfo.QUESTLIST_BOX);
		if (header != null)
		{
			header.deleteAllChildren();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged e)
	{
		if (e.getGameState() == GameState.LOGGING_IN)
		{
			currentFilterState = QuestState.ALL;
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() != ScriptID.QUESTLIST_PROGRESS_LIST_SHOW)
		{
			return;
		}
		addQuestButtons();
	}

	private void addQuestButtons()
	{
		Widget header = client.getWidget(WidgetInfo.QUESTLIST_BOX);
		if (header != null)
		{
			header.deleteAllChildren();

			questSearchButton = header.createChild(-1, WidgetType.GRAPHIC);
			questSearchButton.setSpriteId(SpriteID.GE_SEARCH);
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

			questHideButton = header.createChild(-1, WidgetType.GRAPHIC);
			redrawHideButton();

			questHideButton.setOriginalWidth(13);
			questHideButton.setOriginalHeight(13);
			questHideButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
			questHideButton.setOriginalX(24);
			questHideButton.setOriginalY(2);
			questHideButton.setHasListener(true);
			questHideButton.setOnOpListener((JavaScriptCallback) e -> toggleHidden());
			questHideButton.setAction(1, MENU_TOGGLE);
			questHideButton.revalidate();

			questSet = new EnumMap<>(QuestContainer.class);

			updateFilter();
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
		if (varClientIntChanged.getIndex() == VarClientInt.INVENTORY_TAB.getIndex())
		{
			if (isChatboxOpen() && !isOnQuestTab())
			{
				chatboxPanelManager.close();
			}
		}
	}

	private void toggleHidden()
	{
		QuestState[] questStates = QuestState.values();
		int nextState = (currentFilterState.ordinal() + 1) % questStates.length;
		currentFilterState = questStates[nextState];

		redrawHideButton();

		updateFilter();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void redrawHideButton()
	{
		questHideButton.setSpriteId(currentFilterState.getSpriteId());
		questHideButton.setName(MENU_SHOW + " " + currentFilterState.getName());
	}

	private boolean isOnQuestTab()
	{
		return client.getVar(Varbits.QUEST_TAB) == 0 && client.getVar(VarClientInt.INVENTORY_TAB) == 2;
	}

	private boolean isChatboxOpen()
	{
		return searchInput != null && chatboxPanelManager.getCurrentInput() == searchInput;
	}

	private void closeSearch()
	{
		updateFilter("");
		chatboxPanelManager.close();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void openSearch()
	{
		updateFilter("");
		client.playSoundEffect(SoundEffectID.UI_BOOP);
		questSearchButton.setAction(1, MENU_CLOSE);
		questSearchButton.setOnOpListener((JavaScriptCallback) e -> closeSearch());
		searchInput = chatboxPanelManager.openTextInput("Search quest list")
			.onChanged(s -> clientThread.invokeLater(() -> updateFilter(s)))
			.onDone(s -> false)
			.onClose(() ->
			{
				clientThread.invokeLater(() -> updateFilter(""));
				questSearchButton.setOnOpListener((JavaScriptCallback) e -> openSearch());
				questSearchButton.setAction(1, MENU_OPEN);
			})
			.build();
	}

	private void updateFilter()
	{
		String filter = "";
		if (isChatboxOpen())
		{
			filter = searchInput.getValue();
		}

		updateFilter(filter);
	}

	private void updateFilter(String filter)
	{
		filter = filter.toLowerCase();
		final Widget container = client.getWidget(WidgetInfo.QUESTLIST_CONTAINER);

		final Widget freeList = client.getWidget(QuestContainer.FREE_QUESTS.widgetInfo);
		final Widget memberList = client.getWidget(QuestContainer.MEMBER_QUESTS.widgetInfo);
		final Widget miniList = client.getWidget(QuestContainer.MINI_QUESTS.widgetInfo);

		if (container == null || freeList == null || memberList == null || miniList == null)
		{
			return;
		}

		updateList(QuestContainer.FREE_QUESTS, filter);
		updateList(QuestContainer.MEMBER_QUESTS, filter);
		updateList(QuestContainer.MINI_QUESTS, filter);

		memberList.setOriginalY(freeList.getOriginalY() + freeList.getOriginalHeight() + ENTRY_PADDING);
		miniList.setOriginalY(memberList.getOriginalY() + memberList.getOriginalHeight() + ENTRY_PADDING);

		// originalHeight is changed within updateList so revalidate all lists
		freeList.revalidate();
		memberList.revalidate();
		miniList.revalidate();

		int y = miniList.getRelativeY() + miniList.getHeight() + 10;

		int newHeight;
		if (container.getScrollHeight() > 0)
		{
			newHeight = (container.getScrollY() * y) / container.getScrollHeight();
		}
		else
		{
			newHeight = 0;
		}

		container.setScrollHeight(y);
		container.revalidateScroll();

		clientThread.invokeLater(() ->
			client.runScript(
				ScriptID.UPDATE_SCROLLBAR,
				WidgetInfo.QUESTLIST_SCROLLBAR.getId(),
				WidgetInfo.QUESTLIST_CONTAINER.getId(),
				newHeight
			));
	}

	private void updateList(QuestContainer questContainer, String filter)
	{
		Widget list = client.getWidget(questContainer.widgetInfo);
		if (list == null)
		{
			return;
		}

		Collection<QuestWidget> quests = questSet.get(questContainer);

		if (quests != null)
		{
			// Check to make sure the list hasn't been rebuild since we were last her
			// Do this by making sure the list's dynamic children are the same as when we last saw them
			if (quests.stream().noneMatch(w ->
			{
				Widget codeWidget = w.getQuest();
				if (codeWidget == null)
				{
					return false;
				}
				return list.getChild(codeWidget.getIndex()) == codeWidget;
			}))
			{
				quests = null;
			}
		}

		if (quests == null)
		{
			// Find all of the widgets that we care about, sorting by their Y value
			quests = Arrays.stream(list.getDynamicChildren())
				.sorted(Comparator.comparingInt(Widget::getRelativeY))
				.filter(w -> !QUEST_HEADERS.contains(w.getText()))
				.map(w -> new QuestWidget(w, Text.removeTags(w.getText()).toLowerCase()))
				.collect(Collectors.toList());
			questSet.put(questContainer, quests);
		}

		// offset because of header
		int y = 20;
		for (QuestWidget questInfo : quests)
		{
			Widget quest = questInfo.getQuest();
			QuestState questState = QuestState.getByColor(quest.getTextColor());

			boolean hidden;
			if (!filter.isEmpty())
			{
				// If searching, show result regardless of filtered state
				hidden = !questInfo.getTitle().contains(filter);
			}
			else
			{
				// Otherwise hide if it doesn't match the filter state
				if (currentFilterState == QuestState.NOT_COMPLETED)
				{
					hidden = questState == QuestState.COMPLETE;
				}
				else
				{
					hidden = currentFilterState != QuestState.ALL && questState != currentFilterState;
				}
			}

			quest.setHidden(hidden);
			quest.setOriginalY(y);
			quest.revalidate();

			if (!hidden)
			{
				y += quest.getHeight();
			}
		}

		list.setOriginalHeight(y);
	}

	@AllArgsConstructor
	@Getter
	private enum QuestContainer
	{
		FREE_QUESTS(WidgetInfo.QUESTLIST_FREE_CONTAINER),
		MEMBER_QUESTS(WidgetInfo.QUESTLIST_MEMBERS_CONTAINER),
		MINI_QUESTS(WidgetInfo.QUESTLIST_MINIQUEST_CONTAINER);

		private final WidgetInfo widgetInfo;
	}

	@AllArgsConstructor
	@Getter
	private enum QuestState
	{
		NOT_STARTED(0xff0000, "Not started", SpriteID.MINIMAP_ORB_HITPOINTS),
		IN_PROGRESS(0xffff00, "In progress", SpriteID.MINIMAP_ORB_HITPOINTS_DISEASE),
		COMPLETE(0xdc10d, "Completed", SpriteID.MINIMAP_ORB_HITPOINTS_POISON),
		ALL(0, "All", SpriteID.MINIMAP_ORB_PRAYER),
		NOT_COMPLETED(0, "Not Completed", SpriteID.MINIMAP_ORB_RUN);

		private final int color;
		private final String name;
		private final int spriteId;

		static QuestState getByColor(int color)
		{
			for (QuestState value : values())
			{
				if (value.getColor() == color)
				{
					return value;
				}
			}

			return null;
		}
	}

	@Data
	@AllArgsConstructor
	private static class QuestWidget
	{
		private Widget quest;
		private String title;
	}
}
