/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.banktags;

import com.google.common.eventbus.Subscribe;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.IntegerNode;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ChatboxInputManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Bank Tags"
)
@Slf4j
public class BankTagsPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "banktags";

	private static final String ITEM_KEY_PREFIX = "item_";

	private static final String SEARCH_BANK_INPUT_TEXT =
		"Show items whose names or tags contain the following text:<br>" +
		"(To show only tagged items, start your search with 'tag:')";

	private static final String TAG_SEARCH = "tag:";

	private static final String EDIT_TAGS_MENU_OPTION = "Edit-tags";

	private static final int EDIT_TAGS_MENU_INDEX = 8;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ChatboxInputManager chatboxInputManager;

	private String getTags(int itemId)
	{
		String config = configManager.getConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
		if (config == null)
		{
			return "";
		}
		return config;
	}

	private void setTags(int itemId, String tags)
	{
		if (tags == null || tags.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
		}
		else
		{
			configManager.setConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId, tags);
		}
	}

	private int getTagCount(int itemId)
	{
		String tags = getTags(itemId);
		if (tags.length() > 0)
		{
			return tags.split(",").length;
		}
		return 0;
	}

	@Subscribe
	public void onScriptEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();

		int[] intStack = client.getIntStack();
		String[] stringStack = client.getStringStack();
		int intStackSize = client.getIntStackSize();
		int stringStackSize = client.getStringStackSize();

		switch (eventName)
		{
			case "bankTagsActive":
				// tell the script the bank tag plugin is active
				intStack[intStackSize - 1] = 1;
				break;
			case "setSearchBankInputText":
				stringStack[stringStackSize - 1] = SEARCH_BANK_INPUT_TEXT;
				break;
			case "setBankItemMenu":
			{
				// set menu action index so the edit tags option will not be overridden
				intStack[intStackSize - 3] = EDIT_TAGS_MENU_INDEX;

				int itemId = intStack[intStackSize - 2];
				int tagCount = getTagCount(itemId);
				if (tagCount > 0)
				{
					stringStack[stringStackSize - 1] += " (" + tagCount + ")";
				}

				int index = intStack[intStackSize - 1];
				long key = (long) index + ((long) WidgetInfo.BANK_ITEM_CONTAINER.getId() << 32);
				IntegerNode flagNode = (IntegerNode) client.getWidgetFlags().get(key);
				if (flagNode != null && flagNode.getValue() != 0)
				{
					flagNode.setValue(flagNode.getValue() | WidgetConfig.SHOW_MENU_OPTION_NINE);
				}
				break;
			}
			case "bankSearchFilter":
				int itemId = intStack[intStackSize - 1];
				String itemName = stringStack[stringStackSize - 2];
				String searchInput = stringStack[stringStackSize - 1];

				ItemComposition itemComposition = itemManager.getItemComposition(itemId);
				if (itemComposition.getPlaceholderTemplateId() != -1)
				{
					// if the item is a placeholder then get the item id for the normal item
					itemId = itemComposition.getPlaceholderId();
				}

				String tagsConfig = configManager.getConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
				if (tagsConfig == null || tagsConfig.length() == 0)
				{
					intStack[intStackSize - 2] = itemName.contains(searchInput) ? 1 : 0;
					return;
				}

				boolean tagSearch = searchInput.startsWith(TAG_SEARCH);
				String search;
				if (tagSearch)
				{
					search = searchInput.substring(TAG_SEARCH.length()).trim();
				}
				else
				{
					search = searchInput;
				}

				List<String> tags = Arrays.asList(tagsConfig.toLowerCase().split(","));

				if (tags.stream().anyMatch(tag -> tag.contains(search.toLowerCase())))
				{
					// return true
					intStack[intStackSize - 2] = 1;
				}
				else if (!tagSearch)
				{
					intStack[intStackSize - 2] = itemName.contains(search) ? 1 : 0;
				}
				break;
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getWidgetId() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getMenuAction() == MenuAction.EXAMINE_ITEM_BANK_EQ
			&& event.getId() == EDIT_TAGS_MENU_INDEX
			&& event.getMenuOption().startsWith(EDIT_TAGS_MENU_OPTION))
		{
			event.consume();
			int inventoryIndex = event.getActionParam();
			ItemContainer bankContainer = client.getItemContainer(InventoryID.BANK);
			if (bankContainer == null)
			{
				return;
			}
			Item[] items = bankContainer.getItems();
			if (inventoryIndex < 0 || inventoryIndex >= items.length)
			{
				return;
			}
			Item item = bankContainer.getItems()[inventoryIndex];
			if (item == null)
			{
				return;
			}
			ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
			int itemId;
			if (itemComposition.getPlaceholderTemplateId() != -1)
			{
				// if the item is a placeholder then get the item id for the normal item
				itemId = itemComposition.getPlaceholderId();
			}
			else
			{
				itemId = item.getId();
			}

			String itemName = itemComposition.getName();

			String initialValue = getTags(itemId);

			chatboxInputManager.openInputWindow(itemName + " tags:", initialValue, (newTags) ->
			{
				if (newTags == null)
				{
					return;
				}
				setTags(itemId, newTags);
				Widget bankContainerWidget = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
				if (bankContainerWidget == null)
				{
					return;
				}
				Widget[] bankItemWidgets = bankContainerWidget.getDynamicChildren();
				if (bankItemWidgets == null || inventoryIndex >= bankItemWidgets.length)
				{
					return;
				}
				Widget bankItemWidget = bankItemWidgets[inventoryIndex];
				String[] actions = bankItemWidget.getActions();
				if (actions == null || EDIT_TAGS_MENU_INDEX - 1 >= actions.length
						|| itemId != bankItemWidget.getItemId())
				{
					return;
				}
				int tagCount = getTagCount(itemId);
				actions[EDIT_TAGS_MENU_INDEX - 1] = EDIT_TAGS_MENU_OPTION;
				if (tagCount > 0)
				{
					actions[EDIT_TAGS_MENU_INDEX - 1] += " (" + tagCount + ")";
				}
			});
		}
	}

}
