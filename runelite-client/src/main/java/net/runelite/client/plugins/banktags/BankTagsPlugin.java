/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.event.MouseWheelEvent;
import java.util.Arrays;
import java.util.Objects;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ChatboxInputManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.input.MouseWheelListener;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.banktags.tabs.TabInterface;
import net.runelite.client.plugins.banktags.tabs.TabSprites;

@PluginDescriptor(
	name = "Bank Tags",
	description = "Enable tagging of bank items and searching of bank tags",
	tags = {"searching", "tagging"}
)
public class BankTagsPlugin extends Plugin implements MouseWheelListener
{
	public static final Splitter SPLITTER = Splitter.on(",").omitEmptyStrings().trimResults();
	public static final Joiner JOINER = Joiner.on(",").skipNulls();
	public static final String CONFIG_GROUP = "banktags";
	public static final String TAG_SEARCH = "tag:";
	public static final String EDIT_TAGS_MENU_OPTION = "Edit-tags";
	public static final String ICON_SEARCH = "icon_";

	private static final String SEARCH_BANK_INPUT_TEXT =
		"Show items whose names or tags contain the following text:<br>" +
			"(To show only tagged items, start your search with 'tag:')";
	private static final String SEARCH_BANK_INPUT_TEXT_FOUND =
		"Show items whose names or tags contain the following text: (%d found)<br>" +
			"(To show only tagged items, start your search with 'tag:')";

	@Inject
	private ItemManager itemManager;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatboxInputManager chatboxInputManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private BankTagsConfig config;

	@Inject
	private TagManager tagManager;

	@Inject
	private TabInterface tabInterface;

	@Provides
	BankTagsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankTagsConfig.class);
	}

	@Override
	public void startUp()
	{
		mouseManager.registerMouseWheelListener(this);
		clientThread.invokeLater(tabInterface::init);
		client.getSpriteOverrides().putAll(TabSprites.toMap(client));
	}

	@Override
	public void shutDown()
	{
		mouseManager.unregisterMouseWheelListener(this);
		clientThread.invokeLater(tabInterface::destroy);

		for (TabSprites value : TabSprites.values())
		{
			client.getSpriteOverrides().remove(value.getSpriteId());
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
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
			case "setSearchBankInputTextFound":
			{
				int matches = intStack[intStackSize - 1];
				stringStack[stringStackSize - 1] = String.format(SEARCH_BANK_INPUT_TEXT_FOUND, matches);
				break;
			}
			case "bankSearchFilter":
				int itemId = itemManager.canonicalize(intStack[intStackSize - 1]);
				String itemName = stringStack[stringStackSize - 2];
				String search = stringStack[stringStackSize - 1];

				boolean tagSearch = search.startsWith(TAG_SEARCH);
				if (tagSearch)
				{
					search = search.substring(TAG_SEARCH.length()).trim();
				}

				if (tagManager.findTag(itemId, search))
				{
					// return true
					intStack[intStackSize - 2] = 1;
				}
				else if (!tagSearch)
				{
					intStack[intStackSize - 2] = itemName.contains(search) ? 1 : 0;
				}
				break;
			case "getSearchingTagTab":
				intStack[intStackSize - 1] = tabInterface.isActive() ? 1 : 0;
				break;
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		MenuEntry[] entries = client.getMenuEntries();

		if (event.getActionParam1() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getOption().equals("Examine"))
		{
			Widget container = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
			Widget item = container.getChild(event.getActionParam0());
			int itemID = itemManager.canonicalize(item.getItemId());
			String text = EDIT_TAGS_MENU_OPTION;
			int tagCount = tagManager.getTags(itemID).size();
			if (tagCount > 0)
			{
				text += " (" + tagCount + ")";
			}
			MenuEntry editTags = new MenuEntry();
			editTags.setParam0(event.getActionParam0());
			editTags.setParam1(event.getActionParam1());
			editTags.setTarget(event.getTarget());
			editTags.setOption(text);
			editTags.setType(MenuAction.RUNELITE.getId());
			editTags.setIdentifier(event.getIdentifier());
			entries = Arrays.copyOf(entries, entries.length + 1);
			entries[entries.length - 1] = editTags;
			client.setMenuEntries(entries);
		}

		tabInterface.handleAdd(event);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getWidgetId() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getMenuAction() == MenuAction.RUNELITE
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

			int itemId = itemManager.canonicalize(item.getId());
			ItemComposition itemComposition = itemManager.getItemComposition(itemId);
			String itemName = itemComposition.getName();
			String initialValue = tagManager.getTagString(itemId);

			chatboxInputManager.openInputWindow(itemName + " tags:", initialValue, (newTags) ->
			{
				if (!Objects.equals(newTags, client.getVar(VarClientStr.INPUT_TEXT)))
				{
					return;
				}

				tagManager.setTagString(itemId, newTags);
			});
		}
		else
		{
			tabInterface.handleClick(event);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("banktags") && configChanged.getKey().equals("useTabs"))
		{
			if (config.tabs())
			{
				clientThread.invokeLater(tabInterface::init);
			}
			else
			{
				clientThread.invokeLater(tabInterface::destroy);
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		tabInterface.update();
	}

	@Subscribe
	public void onDraggingWidgetChanged(DraggingWidgetChanged event)
	{
		tabInterface.handleDrag(event.isDraggingWidget());
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.BANK_GROUP_ID)
		{
			tabInterface.init();
		}
	}

	@Override
	public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
	{
		clientThread.invokeLater(() -> tabInterface.handleWheel(event));
		return event;
	}
}
