/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Lucas <https://github.com/Lucwousin>
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

import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.vars.InputType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.input.MouseWheelListener;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.banktags.tabs.BankSearch;
import net.runelite.client.plugins.banktags.tabs.TabInterface;
import net.runelite.client.plugins.banktags.tabs.TabSprites;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Bank Tags",
	description = "Enable tagging of bank items and searching of bank tags",
	tags = {"searching", "tagging"}
)
@PluginDependency(ClueScrollPlugin.class)
@Singleton
public class BankTagsPlugin extends Plugin implements MouseWheelListener, KeyListener
{
	public static final String CONFIG_GROUP = "banktags";
	public static final String TAG_SEARCH = "tag:";
	private static final String EDIT_TAGS_MENU_OPTION = "Edit-tags";
	public static final String ICON_SEARCH = "icon_";
	public static final String VAR_TAG_SUFFIX = "*";

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
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private BankTagsConfig config;

	@Inject
	private TagManager tagManager;

	@Inject
	private TabInterface tabInterface;

	@Inject
	private BankSearch bankSearch;

	@Inject
	private KeyManager keyManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private EventBus eventBus;

	private boolean shiftPressed = false;
	private int nextRowIndex = 0;

	@Provides
	BankTagsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankTagsConfig.class);
	}

	@Override
	public void startUp()
	{
		addSubscriptions();

		keyManager.registerKeyListener(this);
		mouseManager.registerMouseWheelListener(this);
		clientThread.invokeLater(tabInterface::init);
		spriteManager.addSpriteOverrides(TabSprites.values());
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		keyManager.unregisterKeyListener(this);
		mouseManager.unregisterMouseWheelListener(this);
		clientThread.invokeLater(tabInterface::destroy);
		spriteManager.removeSpriteOverrides(TabSprites.values());

		shiftPressed = false;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(DraggingWidgetChanged.class, this, this::onDraggingWidgetChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(FocusChanged.class, this, this::onFocusChanged);
	}

	private boolean isSearching()
	{
		return client.getVar(VarClientInt.INPUT_TYPE) == InputType.SEARCH.getType()
			|| (client.getVar(VarClientInt.INPUT_TYPE) <= 0
			&& client.getVar(VarClientStr.INPUT_TEXT) != null && client.getVar(VarClientStr.INPUT_TEXT).length() > 0);
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent event)
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
				int itemId = intStack[intStackSize - 1];
				String itemName = stringStack[stringStackSize - 2];
				String search = stringStack[stringStackSize - 1];

				boolean tagSearch = search.startsWith(TAG_SEARCH);
				if (tagSearch)
				{
					search = search.substring(TAG_SEARCH.length()).trim();
				}

				if (tagManager.findTag(itemId, search))
				{
					if (!config.hidePlaceholders())
					{
						// return true
						intStack[intStackSize - 2] = 1;
					}

					// not a placeholder
					else if (itemManager.getItemDefinition(itemId).getPlaceholderTemplateId() == -1)
					{
						// return true
						intStack[intStackSize - 2] = 1;
					}
					break;
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

		if (!config.removeSeparators() || !isSearching() || !tabInterface.isActive())
		{
			return;
		}

		switch (eventName)
		{
			case "lineSpace":
				// prevent Y value being incremented to account for line separators
				intStack[intStackSize - 1] = 0;
				break;
			case "tabTextSpace":
				// prevent Y value being incremented to account for "Tab x" text
				intStack[intStackSize - 1] = 0;
				break;
			case "hideLine":
			case "hideTabText":
				// hide the widget for the line separator
				// hide the widget for the "Tab x" text
				intStack[intStackSize - 1] = 1;
				break;
			case "rowIndex":
				// remember the next index in the row so we can start the next tab's items there
				nextRowIndex = intStack[intStackSize - 1];
				break;
			case "rowIndexInit":
				// set the index to our remembered value instead of 0
				intStack[intStackSize - 1] = nextRowIndex;
				break;
			case "bankLayoutInit":
				// reset the row index if the bank is rebuilt
				nextRowIndex = 0;
				break;
			case "newBankRow":
				// if we haven't filled a row when the current tab is finished building,
				// adjust the y offset to continue the next tab on the same row
				if (nextRowIndex != 0)
				{
					intStack[intStackSize - 2] = intStack[intStackSize - 2] - 32;
				}
				// if we have filled the row, adjust the y offset to maintain appropriate row spacing
				else
				{
					intStack[intStackSize - 2] = intStack[intStackSize - 2] + 4;
				}
				break;
			case "addLastRow":
				// after all tabs are finished building, add an extra row of space
				// this ensures the scrollbar is set to the correct height
				intStack[intStackSize - 1] = intStack[intStackSize - 1] + 32;
				break;
		}
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		MenuEntry[] entries = client.getMenuEntries();

		if (event.getActionParam1() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getOption().equals("Examine"))
		{
			Widget container = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
			Widget item = container.getChild(event.getActionParam0());
			int itemID = item.getItemId();
			String text = EDIT_TAGS_MENU_OPTION;
			int tagCount = tagManager.getTags(itemID, false).size() + tagManager.getTags(itemID, true).size();

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

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getActionParam1() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getMenuAction() == MenuAction.RUNELITE
			&& event.getOption().startsWith(EDIT_TAGS_MENU_OPTION))
		{
			event.consume();
			int inventoryIndex = event.getActionParam0();
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

			int itemId = item.getId();
			ItemDefinition itemDefinition = itemManager.getItemDefinition(itemId);
			String name = itemDefinition.getName();

			// Get both tags and vartags and append * to end of vartags name
			Collection<String> tags = tagManager.getTags(itemId, false);
			tagManager.getTags(itemId, true).stream()
				.map(i -> i + "*")
				.forEach(tags::add);

			boolean isSearchOpen = client.getVar(VarClientInt.INPUT_TYPE) == InputType.SEARCH.getType();
			String searchText = client.getVar(VarClientStr.INPUT_TEXT);
			String initialValue = Text.toCSV(tags);

			chatboxPanelManager.openTextInput(name + " tags:<br>(append " + VAR_TAG_SUFFIX + " for variation tag)")
				.value(initialValue)
				.onDone((newValue) ->
					clientThread.invoke(() ->
					{
						// Split inputted tags to vartags (ending with *) and regular tags
						final Collection<String> newTags = new ArrayList<>(Text.fromCSV(newValue.toLowerCase()));
						final Collection<String> newVarTags = new ArrayList<>(newTags).stream().filter(s -> s.endsWith(VAR_TAG_SUFFIX)).map(s ->
						{
							newTags.remove(s);
							return s.substring(0, s.length() - VAR_TAG_SUFFIX.length());
						}).collect(Collectors.toList());

						// And save them
						tagManager.setTagString(itemId, Text.toCSV(newTags), false);
						tagManager.setTagString(itemId, Text.toCSV(newVarTags), true);

						// Check both previous and current tags in case the tag got removed in new tags or in case
						// the tag got added in new tags
						tabInterface.updateTabIfActive(Text.fromCSV(initialValue.toLowerCase().replaceAll(Pattern.quote(VAR_TAG_SUFFIX), "")));
						tabInterface.updateTabIfActive(Text.fromCSV(newValue.toLowerCase().replaceAll(Pattern.quote(VAR_TAG_SUFFIX), "")));
					}))
				.build();

			if (isSearchOpen)
			{
				bankSearch.reset(false);
				bankSearch.search(InputType.SEARCH, searchText, false);
			}
		}
		else
		{
			tabInterface.handleClick(event);
		}
	}

	private void onConfigChanged(ConfigChanged configChanged)
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

	private void onGameTick(GameTick event)
	{
		tabInterface.update();
	}

	private void onDraggingWidgetChanged(DraggingWidgetChanged event)
	{
		tabInterface.handleDrag(event.isDraggingWidget(), shiftPressed);
	}

	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.BANK_GROUP_ID)
		{
			tabInterface.init();
		}
	}

	private void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			shiftPressed = false;
		}
	}

	@Override
	public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
	{
		tabInterface.handleWheel(event);
		return event;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			shiftPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			shiftPressed = false;
		}
	}
}
