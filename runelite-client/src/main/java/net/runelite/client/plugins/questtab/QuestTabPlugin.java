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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.ScriptID;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.ArrayUtils;

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

	@Inject
	private ConfigManager configManager;

	@Provides
	QuestTabConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(QuestTabConfig.class);
	}

	// Ways the quest list can be sorted
	private enum SortType
	{
		ALPHABETICAL,
		DIFFICULTY,
		LENGTH
	}

	public enum QuestStatus
	{
		COMPLETE,
		IN_PROGRESS,
		NOT_STARTED
	}

	@Getter
	private HashMap<Quest, QuestStatus> questStatus = new HashMap<>();

	private LinkedHashMap<Quest, Widget> freeWidgets = new LinkedHashMap<>();
	private LinkedHashMap<Quest, Widget> membersWidgets = new LinkedHashMap<>();
	private LinkedHashMap<Quest, Widget> miniquestWidgets = new LinkedHashMap<>();

	private static final String CONFIG_GROUP = "questtab";
	private static final int QUEST_LIST_TITLE_SPACE = 20;
	private static final int QUEST_LIST_ITEM_SPACE = 15;

	private static final String SHOW_FREE = "Show Free";
	private static final String SHOW_MEMBERS = "Show Members";
	private static final String SHOW_MINIQUESTS = "Show Miniquests";
	private static final String SHOW_COMPLETE = "Show Complete";
	private static final String SHOW_IN_PROGRESS = "Show In-Progress";
	private static final String SHOW_NOT_STARTED = "Show Not-Started";
	private static final String SHOW_CANT_DO = "Show Can't-Do";
	private static final String SHOW_DIFFICULTY = "Show Difficulty";
	private static final String SORT_BY_DIFFICULTY = "Sort by Difficulty";
	private static final String SHOW_LENGTH = "Show Length";
	private static final String SORT_BY_LENGTH = "Sort by Length";
	private static final String HIDE_FREE = "Hide Free";
	private static final String HIDE_MEMBERS = "Hide Members";
	private static final String HIDE_MINIQUESTS = "Hide Miniquests";
	private static final String HIDE_COMPLETE = "Hide Complete";
	private static final String HIDE_IN_PROGRESS = "Hide In-Progress";
	private static final String HIDE_NOT_STARTED = "Hide Not-Started";
	private static final String HIDE_CANT_DO = "Hide Can't-Do";
	private static final String HIDE_DIFFICULTY = "Hide Difficulty";
	private static final String UNSORT_BY_DIFFICULTY = "Unsort by Difficulty";
	private static final String HIDE_LENGTH = "Hide Length";
	private static final String UNSORT_BY_LENGTH = "Unsort by Length";
	private static final String RESET = "Reset";

	@Subscribe
	public void onConfigChanged(ConfigChanged e)
	{
		if (e.getGroup().equals(CONFIG_GROUP))
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
			clientThread.invokeLater(this::processQuestList);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.QUEST_LIST_GROUP_ID)
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
			clientThread.invokeLater(this::processQuestList);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getWidgetId() == WidgetInfo.FIXED_VIEWPORT_QUESTS_TAB.getId() ||
			event.getWidgetId() == WidgetInfo.RESIZABLE_VIEWPORT_QUESTS_TAB.getId() ||
			event.getWidgetId() == WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_QUEST_TAB.getId())
		{
			clientThread.invokeLater(this::processQuestList);
		}
	}

	private void processQuestList()
	{
		freeWidgets.clear();
		processQuestSection(WidgetInfo.QUEST_LIST_FREE, freeWidgets);

		membersWidgets.clear();
		processQuestSection(WidgetInfo.QUEST_LIST_MEMBERS, membersWidgets);

		miniquestWidgets.clear();
		processQuestSection(WidgetInfo.QUEST_LIST_MINIQUESTS, miniquestWidgets);
	}

	private void processQuestSection(WidgetInfo wi, LinkedHashMap<Quest, Widget> widgetList)
	{
		if (client.getWidget(wi) != null && client.getWidget(wi).getChildren() != null)
		{
			for (Widget w : client.getWidget(wi).getChildren())
			{
				if (w.isHidden())
				{
					continue;
				}

				Quest q = Quest.getQuest(w.getText());

				if (q != null)
				{
					widgetList.put(q, w);

					if (config.showLength() || config.showDifficulty())
					{
						updateText(q, w);
					}
				}
				// in case a new quest is added but it is not yet recognized by the Quest class
				// !w.getName().equals("") prevents quest list titles (Free, Members', Miniquests) from getting through
				// !w.getText().startsWith("<") prevents quests which have already been processed by updateText() from getting through
				else if (!w.getName().equals("") && !w.getText().startsWith("<"))
				{
					// declare the quest as an unknown quest and continue with the processing
					widgetList.put(Quest.UNKNOWN, w);

					if (config.showLength() || config.showDifficulty())
					{
						updateText(Quest.UNKNOWN, w);
					}
				}
			}
		}

		// alphabetical is natural quest list sort order
		// sorting alphabetically first will keep quest list order natural with respect to any other sorts
		widgetList = sortQuest(widgetList, SortType.ALPHABETICAL);

		if (config.sortLength())
		{
			widgetList = sortQuest(widgetList, SortType.LENGTH);
			rearrangeWidgets(widgetList);
		}

		if (config.sortDifficulty())
		{
			widgetList = sortQuest(widgetList, SortType.DIFFICULTY);
			rearrangeWidgets(widgetList);
		}

	}

	private void updateText(Quest q, Widget w)
	{
		StringBuilder s = new StringBuilder(w.getText());

		if (config.showLength())
		{
			// put a colored letter at the beginning of the quest list item text to signify quest length
			// S - Green - short
			// M - Yellow - medium
			// L - Orange - long
			// V - Red - very long
			switch (q.getQuestLength())
			{
				case SHORT:
					s.insert(0, "<col=DC10D>S</col> ");
					break;
				case MEDIUM:
					s.insert(0, "<col=FFFF00>M</col> ");
					break;
				case LONG:
					s.insert(0, "<col=FF8C00>L</col> ");
					break;
				case VERY_LONG:
					s.insert(0, "<col=FF0000>V</col> ");
					break;
			}
		}

		if (config.showDifficulty())
		{
			// put a colored letter at the beginning of the quest list item text to signify quest difficulty
			// N - Green - novice
			// I - Yellow-Green - intermediate
			// E - Yellow - experienced
			// M - Orange - master
			// G - Red - grandmaster
			switch (q.getQuestDifficulty())
			{
				case NOVICE:
					s.insert(0, "<col=DC10D>N</col> ");
					break;
				case INTERMEDIATE:
					s.insert(0, "<col=9ACD32>I</col> ");
					break;
				case EXPERIENCED:
					s.insert(0, "<col=FFFF00>E</col> ");
					break;
				case MASTER:
					s.insert(0, "<col=FF8C00>M</col> ");
					break;
				case GRANDMASTER:
					s.insert(0, "<col=FF0000>G</col> ");
					break;
			}
		}

		w.setText(s.toString());
	}

	private void rearrangeWidgets(LinkedHashMap<Quest, Widget> l)
	{
		int yPos = QUEST_LIST_TITLE_SPACE;

		for (Widget w : l.values())
		{
			w.setRelativeY(yPos);
			w.setOriginalY(yPos);
			yPos += QUEST_LIST_ITEM_SPACE;
		}
	}

	private static LinkedHashMap<Quest, Widget> sortQuest(HashMap<Quest, Widget> unsortedQuest, SortType s)
	{
		List<HashMap.Entry<Quest, Widget>> list = new ArrayList<>(unsortedQuest.entrySet());

		switch (s)
		{
			case ALPHABETICAL:
				// natural order is alphabetical, so sorting by relative y preserves natural/alphabetical order
				list.sort(Comparator.comparing(a -> a.getValue().getRelativeY()));
				break;
			case DIFFICULTY:
				list.sort(Comparator.comparing(a -> a.getKey().getQuestDifficulty()));
				break;
			case LENGTH:
				list.sort(Comparator.comparing(a -> a.getKey().getQuestLength()));
				break;
		}

		LinkedHashMap<Quest, Widget> result = new LinkedHashMap<>();

		for (HashMap.Entry<Quest, Widget> entry : list)
		{
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!config.menuOption())
		{
			return;
		}

		int groupId = event.getActionParam1();
		String option = event.getOption();

		if (groupId == WidgetInfo.FIXED_VIEWPORT_QUESTS_TAB.getId() ||
			groupId == WidgetInfo.RESIZABLE_VIEWPORT_QUESTS_TAB.getId() ||
			groupId == WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_QUEST_TAB.getId())
		{
			insertMenuEntry(event, RESET);
			if (config.sortLength()) insertMenuEntry(event, UNSORT_BY_LENGTH);
			else insertMenuEntry(event, SORT_BY_LENGTH);
			if (config.showLength()) insertMenuEntry(event, HIDE_LENGTH);
			else insertMenuEntry(event, SHOW_LENGTH);
			if (config.sortDifficulty()) insertMenuEntry(event, UNSORT_BY_DIFFICULTY);
			else insertMenuEntry(event, SORT_BY_DIFFICULTY);
			if (config.showDifficulty()) insertMenuEntry(event, HIDE_DIFFICULTY);
			else insertMenuEntry(event, SHOW_DIFFICULTY);
			if (config.hideCantDo()) insertMenuEntry(event, SHOW_CANT_DO);
			else insertMenuEntry(event, HIDE_CANT_DO);
			if (config.hideNotStarted()) insertMenuEntry(event, SHOW_NOT_STARTED);
			else insertMenuEntry(event, HIDE_NOT_STARTED);
			if (config.hideInProgress()) insertMenuEntry(event, SHOW_IN_PROGRESS);
			else insertMenuEntry(event, HIDE_IN_PROGRESS);
			if (config.hideCompleted()) insertMenuEntry(event, SHOW_COMPLETE);
			else insertMenuEntry(event, HIDE_COMPLETE);
			if (config.hideMiniquests()) insertMenuEntry(event, SHOW_MINIQUESTS);
			else insertMenuEntry(event, HIDE_MINIQUESTS);
			if (config.hideMembers()) insertMenuEntry(event, SHOW_MEMBERS);
			else insertMenuEntry(event, HIDE_MEMBERS);
			if (config.hideFree()) insertMenuEntry(event, SHOW_FREE);
			else insertMenuEntry(event, HIDE_FREE);
		}
	}

	private void insertMenuEntry(MenuEntryAdded event, String newEntryOption)
	{
		MenuEntry[] options = client.getMenuEntries();

		for (MenuEntry option : options)
		{
			if (option.getOption().equals(newEntryOption))
			{
				return;
			}
		}

		final MenuEntry entry = new MenuEntry();
		entry.setOption(newEntryOption);
		entry.setTarget(event.getTarget());
		entry.setType(MenuAction.RUNELITE.getId());
		entry.setParam0(event.getActionParam0());
		entry.setParam1(event.getActionParam1());

		options = Arrays.copyOf(options, options.length + 1);
		options[options.length - 1] = entry;
		// keep cancel as the last option
		ArrayUtils.swap(options, options.length - 1, options.length - 2);
		client.setMenuEntries(options);
	}

	@Subscribe
	public void onFilterMenuClicked(PlayerMenuOptionClicked event)
	{
		switch (event.getMenuOption())
		{
			case SHOW_FREE:
				configManager.setConfiguration(CONFIG_GROUP, "hideFree", false);
				break;
			case SHOW_MEMBERS:
				configManager.setConfiguration(CONFIG_GROUP, "hideMembers", false);
				break;
			case SHOW_MINIQUESTS:
				configManager.setConfiguration(CONFIG_GROUP, "hideMiniquests", false);
				break;
			case SHOW_COMPLETE:
				configManager.setConfiguration(CONFIG_GROUP, "hideCompleted", false);
				break;
			case SHOW_IN_PROGRESS:
				configManager.setConfiguration(CONFIG_GROUP, "hideInProgress", false);
				break;
			case SHOW_NOT_STARTED:
				configManager.setConfiguration(CONFIG_GROUP, "hideNotStarted", false);
				break;
			case SHOW_CANT_DO:
				configManager.setConfiguration(CONFIG_GROUP, "hideCantDo", false);
				break;
			case HIDE_DIFFICULTY:
				configManager.setConfiguration(CONFIG_GROUP, "showDifficulty", false);
				break;
			case UNSORT_BY_DIFFICULTY:
				configManager.setConfiguration(CONFIG_GROUP, "sortDifficulty", false);
				break;
			case HIDE_LENGTH:
				configManager.setConfiguration(CONFIG_GROUP, "showLength", false);
				break;
			case UNSORT_BY_LENGTH:
				configManager.setConfiguration(CONFIG_GROUP, "sortLength", false);
				break;
			case HIDE_FREE:
				configManager.setConfiguration(CONFIG_GROUP, "hideFree", true);
				break;
			case HIDE_MEMBERS:
				configManager.setConfiguration(CONFIG_GROUP, "hideMembers", true);
				break;
			case HIDE_MINIQUESTS:
				configManager.setConfiguration(CONFIG_GROUP, "hideMiniquests", true);
				break;
			case HIDE_COMPLETE:
				configManager.setConfiguration(CONFIG_GROUP, "hideCompleted", true);
				break;
			case HIDE_IN_PROGRESS:
				configManager.setConfiguration(CONFIG_GROUP, "hideInProgress", true);
				break;
			case HIDE_NOT_STARTED:
				configManager.setConfiguration(CONFIG_GROUP, "hideNotStarted", true);
				break;
			case HIDE_CANT_DO:
				configManager.setConfiguration(CONFIG_GROUP, "hideCantDo", true);
				break;
			case SHOW_DIFFICULTY:
				configManager.setConfiguration(CONFIG_GROUP, "showDifficulty", true);
				break;
			case SORT_BY_DIFFICULTY:
				configManager.setConfiguration(CONFIG_GROUP, "sortDifficulty", true);
				break;
			case SHOW_LENGTH:
				configManager.setConfiguration(CONFIG_GROUP, "showLength", true);
				break;
			case SORT_BY_LENGTH:
				configManager.setConfiguration(CONFIG_GROUP, "sortLength", true);
				break;
			case RESET:
				configManager.setDefaultConfiguration(config, true);
				break;
		}
	}

	@Subscribe
	public void onScriptEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();
		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();
		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();

		switch (eventName)
		{
			case "questListFilter":

				if (intStackSize < 3)
				{
					break;
				}

				String questName = null;
				Quest quest = null;

				if (stringStackSize > 0)
				{
					questName = stringStack[stringStackSize - 1];
					quest = Quest.getQuest(questName);
				}

				// order matters for these calls as filterOnProgress initializes a return value
				// and the following calls maintain or update the value that was set
				filterOnProgress(quest, questName, intStack, intStackSize);
				filterOnQuestType(intStack, intStackSize);
				filterOnQuestReqsMet(quest, questName, intStack, intStackSize);

				// the second value on the int stack will be used as (true) once the script continues
				intStack[intStackSize - 2] = 1;
				break;
			case "questListSetupDone":
				filterList(intStack, intStackSize);
				break;
		}
	}

	private void filterOnProgress(Quest quest, String questName, int[] intStack, int intStackSize)
	{
		int progress = intStack[intStackSize - 3];

		// progress == 2 means completed
		if (progress == 2)
		{
			if (questName != null)
			{
				questStatus.put(quest, QuestStatus.COMPLETE);
			}

			intStack[intStackSize - 1] = config.hideCompleted() ? 1 : 0;
		}
		// progress == 0 means in progress
		else if (progress == 0)
		{
			if (questName != null)
			{
				questStatus.put(quest, QuestStatus.IN_PROGRESS);
			}

			intStack[intStackSize - 1] = config.hideInProgress() ? 1 : 0;
		}
		// progress == 1 means not started
		else if (progress == 1)
		{
			if (questName != null)
			{
				questStatus.put(quest, QuestStatus.NOT_STARTED);
			}

			intStack[intStackSize - 1] = config.hideNotStarted() ? 1 : 0;
		}
	}

	private void filterOnQuestType(int[] intStack, int intStackSize)
	{
		int questListWidgetId = intStack[intStackSize - 2];

		if (questListWidgetId == WidgetInfo.QUEST_LIST_FREE.getId())
		{
			intStack[intStackSize - 1] = config.hideFree() ? 1 : intStack[intStackSize - 1];
		}
		else if (questListWidgetId == WidgetInfo.QUEST_LIST_MEMBERS.getId())
		{
			intStack[intStackSize - 1] = config.hideMembers() ? 1 : intStack[intStackSize - 1];
		}
		else if (questListWidgetId == WidgetInfo.QUEST_LIST_MINIQUESTS.getId())
		{
			intStack[intStackSize - 1] = config.hideMiniquests() ? 1 : intStack[intStackSize - 1];
		}
	}

	private void filterOnQuestReqsMet(Quest quest, String questName, int[] intStack, int intStackSize)
	{
		if (config.hideCantDo() && questName != null && !questStatus.get(quest).equals(QuestStatus.COMPLETE))
		{
			intStack[intStackSize - 1] = !quest.getQuestRequirement().isMet(this, client) ? 1 : intStack[intStackSize - 1];
		}
	}

	private void filterList(int[] intStack, int intStackSize)
	{
		int questListWidgetId = intStack[intStackSize - 1];

		if (questListWidgetId == WidgetInfo.QUEST_LIST_FREE.getId())
		{
			intStack[intStackSize - 1] = config.hideFree() ? 1 : intStack[intStackSize - 1];
			intStack[intStackSize - 3] = -8;
		}
		else if (questListWidgetId == WidgetInfo.QUEST_LIST_MEMBERS.getId())
		{
			intStack[intStackSize - 1] = config.hideMembers() ? 1 : intStack[intStackSize - 1];
			intStack[intStackSize - 3] = -8;
		}
		else if (questListWidgetId == WidgetInfo.QUEST_LIST_MINIQUESTS.getId())
		{
			intStack[intStackSize - 1] = config.hideMiniquests() ? 1 : intStack[intStackSize - 1];
			intStack[intStackSize - 3] = 0;
		}
	}

}
