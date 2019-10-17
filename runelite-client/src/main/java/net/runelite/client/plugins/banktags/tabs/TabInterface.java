/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.plugins.banktags.tabs;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Runnables;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemDefinition;
import net.runelite.api.MenuOpcode;
import net.runelite.api.MenuEntry;
import net.runelite.api.Point;
import net.runelite.api.ScriptEvent;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.vars.InputType;
import net.runelite.api.widgets.ItemQuantityMode;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.chatbox.ChatboxItemSearch;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.banktags.BankTagsConfig;
import net.runelite.client.plugins.banktags.BankTagsPlugin;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.TAG_SEARCH;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.VAR_TAG_SUFFIX;
import net.runelite.client.plugins.banktags.TagManager;
import static net.runelite.client.plugins.banktags.tabs.MenuIndexes.NewTab;
import static net.runelite.client.plugins.banktags.tabs.MenuIndexes.Tab;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;
import net.runelite.api.util.Text;

@Singleton
public class TabInterface
{
	public static final IntPredicate FILTERED_CHARS = c -> "</>".indexOf(c) == -1;

	private static final Color HILIGHT_COLOR = JagexColors.MENU_TARGET;
	private static final String SCROLL_UP = "Scroll up";
	private static final String SCROLL_DOWN = "Scroll down";
	private static final String NEW_TAB = "New tag tab";
	private static final String REMOVE_TAB = "Delete tag tab";
	private static final String EXPORT_TAB = "Export tag tab";
	private static final String IMPORT_TAB = "Import tag tab";
	private static final String VIEW_TAB = "View tag tab";
	private static final String RENAME_TAB = "Rename tag tab";
	private static final String CHANGE_ICON = "Change icon";
	private static final String REMOVE_TAG = "Remove-tag";
	private static final String TAG_GEAR = "Tag-equipment";
	private static final String TAG_INVENTORY = "Tag-inventory";
	private static final int TAB_HEIGHT = 40;
	private static final int TAB_WIDTH = 39;
	private static final int BUTTON_HEIGHT = 20;
	private static final int MARGIN = 1;
	private static final int SCROLL_TICK = 500;
	private static final int INCINERATOR_WIDTH = 48;
	private static final int INCINERATOR_HEIGHT = 39;
	private static TagTab iconToSet;

	private final Client client;
	private final ClientThread clientThread;
	private final ItemManager itemManager;
	private final TagManager tagManager;
	private final TabManager tabManager;
	private final ChatboxPanelManager chatboxPanelManager;
	private final BankTagsConfig config;
	private final Notifier notifier;
	private final BankSearch bankSearch;
	private final Rectangle bounds = new Rectangle();
	private final Rectangle canvasBounds = new Rectangle();

	private ChatboxItemSearch searchProvider;
	private TagTab activeTab;
	private int maxTabs;
	private int currentTabIndex;
	private Instant startScroll = Instant.now();
	private String rememberedSearch;
	private boolean waitSearchTick;

	@Getter
	private Widget upButton;

	@Getter
	private Widget downButton;

	@Getter
	private Widget newTab;

	@Getter
	private Widget parent;

	@Inject
	private TabInterface(
		final Client client,
		final ClientThread clientThread,
		final ItemManager itemManager,
		final TagManager tagManager,
		final TabManager tabManager,
		final ChatboxPanelManager chatboxPanelManager,
		final BankTagsConfig config,
		final Notifier notifier,
		final BankSearch bankSearch,
		final ChatboxItemSearch searchProvider)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.itemManager = itemManager;
		this.tagManager = tagManager;
		this.tabManager = tabManager;
		this.chatboxPanelManager = chatboxPanelManager;
		this.config = config;
		this.notifier = notifier;
		this.bankSearch = bankSearch;
		this.searchProvider = searchProvider;
	}

	public boolean isActive()
	{
		return activeTab != null;
	}

	public void init()
	{
		if (isHidden())
		{
			return;
		}

		currentTabIndex = config.position();
		parent = client.getWidget(WidgetInfo.BANK_CONTENT_CONTAINER);

		updateBounds();

		upButton = createGraphic("", TabSprites.UP_ARROW.getSpriteId(), -1, TAB_WIDTH, BUTTON_HEIGHT, bounds.x, 0, true);
		upButton.setAction(1, SCROLL_UP);
		int clickmask = upButton.getClickMask();
		clickmask |= WidgetConfig.DRAG;
		upButton.setClickMask(clickmask);
		upButton.setOnOpListener((JavaScriptCallback) (event) -> scrollTab(-1));

		downButton = createGraphic("", TabSprites.DOWN_ARROW.getSpriteId(), -1, TAB_WIDTH, BUTTON_HEIGHT, bounds.x, 0, true);
		downButton.setAction(1, SCROLL_DOWN);
		clickmask = downButton.getClickMask();
		clickmask |= WidgetConfig.DRAG;
		downButton.setClickMask(clickmask);
		downButton.setOnOpListener((JavaScriptCallback) (event) -> scrollTab(1));

		newTab = createGraphic("", TabSprites.NEW_TAB.getSpriteId(), -1, TAB_WIDTH, 39, bounds.x, 0, true);
		newTab.setAction(1, NEW_TAB);
		newTab.setAction(2, IMPORT_TAB);
		newTab.setOnOpListener((JavaScriptCallback) this::handleNewTab);

		tabManager.clear();
		tabManager.getAllTabs().forEach(this::loadTab);
		activateTab(null);
		scrollTab(0);

		if (config.rememberTab() && !Strings.isNullOrEmpty(config.tab()))
		{
			// the server will resync the last opened vanilla tab when the bank is opened
			client.setVarbit(Varbits.CURRENT_BANK_TAB, 0);
			openTag(config.tab());
		}
	}

	private void handleDeposit(MenuOptionClicked event, Boolean inventory)
	{
		ItemContainer container = client.getItemContainer(inventory ? InventoryID.INVENTORY : InventoryID.EQUIPMENT);

		if (container == null)
		{
			return;
		}

		List<Integer> items = Arrays.stream(container.getItems())
			.filter(Objects::nonNull)
			.map(Item::getId)
			.filter(id -> id != -1)
			.collect(Collectors.toList());

		if (!Strings.isNullOrEmpty(event.getTarget()))
		{
			if (activeTab != null && Text.removeTags(event.getTarget()).equals(activeTab.getTag()))
			{
				for (Integer item : items)
				{
					tagManager.addTag(item, activeTab.getTag(), false);
				}

				openTag(activeTab.getTag());
			}

			return;
		}

		chatboxPanelManager.openTextInput((inventory ? "Inventory " : "Equipment ") + " tags:")
			.addCharValidator(FILTERED_CHARS)
			.onDone((newTags) ->
				clientThread.invoke(() ->
				{
					final List<String> tags = Text.fromCSV(newTags.toLowerCase());

					for (Integer item : items)
					{
						tagManager.addTags(item, tags, false);
					}

					updateTabIfActive(tags);
				}))
			.build();
	}

	private void handleNewTab(ScriptEvent event)
	{
		switch (event.getOp())
		{
			case NewTab.NEW_TAB:
				chatboxPanelManager.openTextInput("Tag name")
					.addCharValidator(FILTERED_CHARS)
					.onDone((tagName) -> clientThread.invoke(() ->
					{
						if (!Strings.isNullOrEmpty(tagName))
						{
							loadTab(tagName);
							tabManager.save();
							scrollTab(0);
						}
					}))
					.build();
				break;
			case NewTab.IMPORT_TAB:
				try
				{
					final String dataString = Toolkit
						.getDefaultToolkit()
						.getSystemClipboard()
						.getData(DataFlavor.stringFlavor)
						.toString()
						.trim();

					final Iterator<String> dataIter = Text.fromCSV(dataString).iterator();
					String name = dataIter.next();
					StringBuffer sb = new StringBuffer();
					for (char c : name.toCharArray())
					{
						if (FILTERED_CHARS.test(c))
						{
							sb.append(c);
						}
					}

					if (sb.length() == 0)
					{
						notifier.notify("Failed to import tag tab from clipboard, invalid format.");
						return;
					}

					name = sb.toString();

					final String icon = dataIter.next();
					tabManager.setIcon(name, icon);

					while (dataIter.hasNext())
					{
						final int itemId = Integer.valueOf(dataIter.next());
						tagManager.addTag(itemId, name, itemId < 0);
					}

					loadTab(name);
					tabManager.save();
					scrollTab(0);

					if (activeTab != null && name.equals(activeTab.getTag()))
					{
						openTag(activeTab.getTag());
					}

					notifier.notify("Tag tab " + name + " has been imported from your clipboard!");
				}
				catch (UnsupportedFlavorException | NoSuchElementException | IOException | NumberFormatException ex)
				{
					notifier.notify("Failed to import tag tab from clipboard, invalid format.");
				}
		}
	}

	private void handleTagTab(ScriptEvent event)
	{
		switch (event.getOp())
		{
			case Tab.OPEN_TAG:
				client.setVarbit(Varbits.CURRENT_BANK_TAB, 0);
				Widget clicked = event.getSource();

				TagTab tab = tabManager.find(Text.removeTags(clicked.getName()));

				if (tab.equals(activeTab))
				{
					bankSearch.reset(true);

					clientThread.invokeLater(() -> client.runScript(ScriptID.MESSAGE_LAYER_CLOSE, 0, 0));
				}
				else
				{
					openTag(Text.removeTags(clicked.getName()));
				}

				client.playSoundEffect(SoundEffectID.UI_BOOP);
				break;
			case Tab.CHANGE_ICON:
				final String tag = Text.removeTags(event.getOpbase());
				searchProvider
					.tooltipText(CHANGE_ICON + " (" + tag + ")")
					.onItemSelected((itemId) ->
					{
						TagTab iconToSet = tabManager.find(tag);
						if (iconToSet != null)
						{
							iconToSet.setIconItemId(itemId);
							iconToSet.getIcon().setItemId(itemId);
							tabManager.setIcon(iconToSet.getTag(), itemId + "");
						}
					})
					.build();
				break;
			case Tab.DELETE_TAB:
				String target = Text.standardize(event.getOpbase());
				chatboxPanelManager.openTextMenuInput("Delete " + target)
					.option("1. Tab and tag from all items", () ->
						clientThread.invoke(() ->
						{
							tagManager.removeTag(target);
							deleteTab(target);
						})
					)
					.option("2. Only tab", () -> clientThread.invoke(() -> deleteTab(target)))
					.option("3. Cancel", Runnables::doNothing)
					.build();
				break;
			case Tab.EXPORT_TAB:
				final List<String> data = new ArrayList<>();
				final TagTab tagTab = tabManager.find(Text.removeTags(event.getOpbase()));
				data.add(tagTab.getTag());
				data.add(String.valueOf(tagTab.getIconItemId()));

				for (Integer item : tagManager.getItemsForTag(tagTab.getTag()))
				{
					data.add(String.valueOf(item));
				}

				final StringSelection stringSelection = new StringSelection(Text.toCSV(data));
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				notifier.notify("Tag tab " + tagTab.getTag() + " has been copied to your clipboard!");
				break;
			case Tab.RENAME_TAB:
				String renameTarget = Text.standardize(event.getOpbase());
				renameTab(renameTarget);
				break;
		}
	}

	public void destroy()
	{
		activeTab = null;
		currentTabIndex = 0;
		maxTabs = 0;
		parent = null;
		waitSearchTick = false;
		rememberedSearch = "";

		if (upButton != null)
		{
			upButton.setHidden(true);
			downButton.setHidden(true);
			newTab.setHidden(true);
		}

		tabManager.clear();
	}

	public void update()
	{
		if (isHidden())
		{
			parent = null;
			waitSearchTick = false;
			rememberedSearch = "";

			// If bank window was just hidden, update last active tab position
			if (currentTabIndex != config.position())
			{
				config.position(currentTabIndex);
			}

			// Do the same for last active tab
			if (config.rememberTab())
			{
				if (activeTab == null && !Strings.isNullOrEmpty(config.tab()))
				{
					config.tab("");
				}
				else if (activeTab != null && !activeTab.getTag().equals(config.tab()))
				{
					config.tab(activeTab.getTag());
				}
			}
			else if (!Strings.isNullOrEmpty(config.tab()))
			{
				config.tab("");
			}

			return;
		}

		if (activeTab != null && client.getVar(VarClientInt.INPUT_TYPE) == InputType.RUNELITE.getType())
		{
			// don't reset active tab if we are editing tags
			updateBounds();
			scrollTab(0);
			return;
		}

		String str = client.getVar(VarClientStr.INPUT_TEXT);

		if (Strings.isNullOrEmpty(str))
		{
			str = "";
		}

		Widget bankTitle = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
		if (bankTitle != null && !bankTitle.isHidden() && !str.startsWith(TAG_SEARCH))
		{
			str = bankTitle.getText().replaceFirst("Showing items: ", "");

			if (str.startsWith("Tab "))
			{
				str = "";
			}
		}

		str = Text.standardize(str);

		if (str.startsWith(BankTagsPlugin.TAG_SEARCH))
		{
			activateTab(tabManager.find(str.substring(TAG_SEARCH.length())));
		}
		else
		{
			activateTab(null);
		}

		if (!waitSearchTick
			&& activeTab == null
			&& !Strings.isNullOrEmpty(rememberedSearch)
			&& client.getVar(VarClientInt.INPUT_TYPE) == InputType.NONE.getType())
		{
			bankSearch.reset(true);
			bankSearch.search(InputType.NONE, rememberedSearch, true);
			rememberedSearch = "";
		}
		else if (waitSearchTick)
		{
			waitSearchTick = false;
		}

		updateBounds();
		scrollTab(0);
	}

	public void handleWheel(final MouseWheelEvent event)
	{
		if (parent == null || !canvasBounds.contains(event.getPoint()))
		{
			return;
		}

		event.consume();

		clientThread.invoke(() ->
		{
			if (isHidden())
			{
				return;
			}

			scrollTab(event.getWheelRotation());
		});
	}

	public void handleAdd(MenuEntryAdded event)
	{
		if (isHidden())
		{
			return;
		}

		if (activeTab != null
			&& event.getParam1() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getOption().equals("Examine"))
		{
			insertMenuEntry(event, REMOVE_TAG + " (" + activeTab.getTag() + ")", event.getTarget());
		}
		else if (event.getParam1() == WidgetInfo.BANK_DEPOSIT_INVENTORY.getId()
			&& event.getOption().equals("Deposit inventory"))
		{
			insertMenuEntry(event, TAG_INVENTORY, event.getTarget());

			if (activeTab != null)
			{
				insertMenuEntry(event, TAG_INVENTORY, ColorUtil.wrapWithColorTag(activeTab.getTag(), HILIGHT_COLOR));
			}
		}
		else if (event.getParam1() == WidgetInfo.BANK_DEPOSIT_EQUIPMENT.getId()
			&& event.getOption().equals("Deposit worn items"))
		{
			insertMenuEntry(event, TAG_GEAR, event.getTarget());

			if (activeTab != null)
			{
				insertMenuEntry(event, TAG_GEAR, ColorUtil.wrapWithColorTag(activeTab.getTag(), HILIGHT_COLOR));
			}
		}
	}

	public void handleClick(MenuOptionClicked event)
	{
		if (isHidden())
		{
			return;
		}

		if (chatboxPanelManager.getCurrentInput() != null
			&& event.getMenuOpcode() != MenuOpcode.CANCEL
			&& !event.getOption().equals(SCROLL_UP)
			&& !event.getOption().equals(SCROLL_DOWN))
		{
			chatboxPanelManager.close();
		}

		if (event.getIdentifier() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getMenuOpcode() == MenuOpcode.EXAMINE_ITEM_BANK_EQ
			&& event.getOption().equalsIgnoreCase("withdraw-x"))
		{
			waitSearchTick = true;
			rememberedSearch = client.getVar(VarClientStr.INPUT_TEXT);
			bankSearch.search(InputType.NONE, rememberedSearch, true);
		}

		if (iconToSet != null)
		{
			if (event.getOption().startsWith(CHANGE_ICON + " ("))
			{
				ItemDefinition item = getItem(event.getParam0());
				if (item != null)
				{
					int itemId = itemManager.canonicalize(item.getId());
					iconToSet.setIconItemId(itemId);
					iconToSet.getIcon().setItemId(itemId);
					tabManager.setIcon(iconToSet.getTag(), itemId + "");
					event.consume();
				}
			}

			// Reset icon selection even when we do not clicked item with icon
			iconToSet = null;
		}

		if (activeTab != null
			&& event.getOption().equals("Search")
			&& client.getWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND).getSpriteId() != SpriteID.EQUIPMENT_SLOT_SELECTED)
		{
			activateTab(null);
			// This ensures that when clicking Search when tab is selected, the search input is opened rather
			// than client trying to close it first
			client.setVar(VarClientStr.INPUT_TEXT, "");
			client.setVar(VarClientInt.INPUT_TYPE, 0);
		}
		else if (activeTab != null
			&& event.getOption().startsWith("View tab"))
		{
			activateTab(null);
		}
		else if (activeTab != null
			&& event.getParam1() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getMenuOpcode() == MenuOpcode.RUNELITE
			&& event.getOption().startsWith(REMOVE_TAG))
		{
			// Add "remove" menu entry to all items in bank while tab is selected
			event.consume();
			final ItemDefinition item = getItem(event.getParam0());
			final int itemId;
			if (item != null)
			{
				itemId = item.getId();
				tagManager.removeTag(itemId, activeTab.getTag());
				bankSearch.search(InputType.SEARCH, TAG_SEARCH + activeTab.getTag(), true);
			}
		}
		else if (event.getMenuOpcode() == MenuOpcode.RUNELITE
			&& ((event.getParam1() == WidgetInfo.BANK_DEPOSIT_INVENTORY.getId() && event.getOption().equals(TAG_INVENTORY))
			|| (event.getParam1() == WidgetInfo.BANK_DEPOSIT_EQUIPMENT.getId() && event.getOption().equals(TAG_GEAR))))
		{
			handleDeposit(event, event.getParam1() == WidgetInfo.BANK_DEPOSIT_INVENTORY.getId());
		}
	}

	public void updateTabIfActive(final Collection<String> tags)
	{
		if (activeTab != null && tags.contains(activeTab.getTag()))
		{
			openTag(activeTab.getTag());
		}
	}

	public void handleDrag(boolean isDragging, boolean shiftDown)
	{
		if (isHidden())
		{
			return;
		}

		Widget draggedOn = client.getDraggedOnWidget();
		Widget draggedWidget = client.getDraggedWidget();

		// round-about way to prevent drag reordering when in a tag tab, now that it looks like a normal tab
		// returning early from drag release and nulling out the drag release listener have no effect,
		// probably a better way to do this though
		if (draggedWidget.getId() == WidgetInfo.BANK_ITEM_CONTAINER.getId() && isActive()
			&& config.removeSeparators())
		{
			client.setDraggedOnWidget(null);
		}

		if (!isDragging || draggedOn == null)
		{
			return;
		}

		// is dragging widget and mouse button released
		if (client.getMouseCurrentButton() == 0)
		{
			if (draggedWidget.getItemId() > 0 && draggedWidget.getId() != parent.getId())
			{
				// Tag an item dragged on a tag tab
				if (draggedOn.getId() == parent.getId())
				{
					tagManager.addTag(draggedWidget.getItemId(), draggedOn.getName(), shiftDown);
					updateTabIfActive(Lists.newArrayList(Text.standardize(draggedOn.getName())));
				}
			}
			else if (parent.getId() == draggedOn.getId() && parent.getId() == draggedWidget.getId() && !Strings.isNullOrEmpty(draggedOn.getName()))
			{
				tabManager.move(draggedWidget.getName(), draggedOn.getName());
				tabManager.save();
				updateTabs();
			}
		}
		else if (draggedWidget.getItemId() > 0)
		{
			MenuEntry[] entries = client.getMenuEntries();

			if (entries.length > 0)
			{
				MenuEntry entry = entries[entries.length - 1];

				if (draggedWidget.getItemId() > 0 && entry.getOption().equals(VIEW_TAB) && draggedOn.getId() != draggedWidget.getId())
				{
					entry.setOption(TAG_SEARCH + Text.removeTags(entry.getTarget()) + (shiftDown ? VAR_TAG_SUFFIX : ""));
					entry.setTarget(draggedWidget.getName());
					client.setMenuEntries(entries);
				}

				if (entry.getOption().equals(SCROLL_UP))
				{
					scrollTick(-1);
				}
				else if (entry.getOption().equals(SCROLL_DOWN))
				{
					scrollTick(1);
				}
			}
		}
	}

	private boolean isHidden()
	{
		Widget widget = client.getWidget(WidgetInfo.BANK_CONTAINER);
		return !config.tabs() || widget == null || widget.isHidden();
	}

	private void loadTab(String tag)
	{
		TagTab tagTab = tabManager.load(tag);

		if (tagTab.getBackground() == null)
		{
			Widget btn = createGraphic(ColorUtil.wrapWithColorTag(tagTab.getTag(), HILIGHT_COLOR), TabSprites.TAB_BACKGROUND.getSpriteId(), -1, TAB_WIDTH, TAB_HEIGHT, bounds.x, 1, true);
			btn.setAction(1, VIEW_TAB);
			btn.setAction(2, CHANGE_ICON);
			btn.setAction(3, REMOVE_TAB);
			btn.setAction(4, EXPORT_TAB);
			btn.setAction(5, RENAME_TAB);
			btn.setOnOpListener((JavaScriptCallback) this::handleTagTab);
			tagTab.setBackground(btn);
		}

		if (tagTab.getIcon() == null)
		{
			Widget icon = createGraphic(
				ColorUtil.wrapWithColorTag(tagTab.getTag(), HILIGHT_COLOR),
				-1,
				tagTab.getIconItemId(),
				Constants.ITEM_SPRITE_WIDTH, Constants.ITEM_SPRITE_HEIGHT,
				bounds.x + 3, 1,
				false);
			int clickmask = icon.getClickMask();
			clickmask |= WidgetConfig.DRAG;
			clickmask |= WidgetConfig.DRAG_ON;
			icon.setClickMask(clickmask);
			icon.setDragDeadTime(5);
			icon.setDragDeadZone(5);
			icon.setItemQuantity(10000);
			icon.setItemQuantityMode(ItemQuantityMode.NEVER);
			tagTab.setIcon(icon);
		}

		tabManager.add(tagTab);
	}

	private void deleteTab(String tag)
	{
		if (activeTab != null && activeTab.getTag().equals(tag))
		{
			bankSearch.reset(true);
		}

		tabManager.remove(tag);
		tabManager.save();

		updateBounds();
		scrollTab(0);
	}

	private void renameTab(String oldTag)
	{
		chatboxPanelManager.openTextInput("Enter new tag name for tag \"" + oldTag + "\":")
			.addCharValidator(FILTERED_CHARS)
			.onDone((newTag) -> clientThread.invoke(() ->
			{
				if (!Strings.isNullOrEmpty(newTag) && !newTag.equalsIgnoreCase(oldTag))
				{
					if (tabManager.find(newTag) == null)
					{
						TagTab tagTab = tabManager.find(oldTag);
						tagTab.setTag(newTag);

						final String coloredName = ColorUtil.wrapWithColorTag(newTag, HILIGHT_COLOR);
						tagTab.getIcon().setName(coloredName);
						tagTab.getBackground().setName(coloredName);

						tabManager.removeIcon(oldTag);
						tabManager.setIcon(newTag, tagTab.getIconItemId() + "");

						tabManager.save();
						tagManager.renameTag(oldTag, newTag);

						if (activeTab != null && activeTab.equals(tagTab))
						{
							openTag(newTag);
						}
					}
					else
					{
						chatboxPanelManager.openTextMenuInput("The specified bank tag already exists.")
							.option("1. Merge into existing tag \"" + newTag + "\".", () ->
								clientThread.invoke(() ->
								{
									tagManager.renameTag(oldTag, newTag);
									final String activeTag = activeTab != null ? activeTab.getTag() : "";
									deleteTab(oldTag);

									if (activeTag.equals(oldTag))
									{
										openTag(newTag);
									}
								})
							)
							.option("2. Choose a different name.", () ->
								clientThread.invoke(() ->
									renameTab(oldTag))
							)
							.build();
					}
				}
			}))
			.build();
	}

	private void scrollTick(int direction)
	{
		// This ensures that dragging on scroll buttons do not scrolls too fast
		if (startScroll.until(Instant.now(), ChronoUnit.MILLIS) >= SCROLL_TICK)
		{
			startScroll = Instant.now();
			scrollTab(direction);
		}
	}

	private void scrollTab(int direction)
	{
		maxTabs = (bounds.height - BUTTON_HEIGHT * 2 - MARGIN * 2) / TAB_HEIGHT;

		// prevent running into the incinerator
		while (bounds.y + maxTabs * TAB_HEIGHT + MARGIN * maxTabs + BUTTON_HEIGHT * 2 + MARGIN > bounds.y + bounds.height)
		{
			--maxTabs;
		}

		if (currentTabIndex + direction >= tabManager.size() || currentTabIndex + direction < 0)
		{
			currentTabIndex = 0;
		}

		if ((tabManager.size() - (currentTabIndex + direction) >= maxTabs) && (currentTabIndex + direction > -1))
		{
			currentTabIndex += direction;
		}
		else if (maxTabs < tabManager.size() && tabManager.size() - (currentTabIndex + direction) < maxTabs)
		{
			// Edge case when only 1 tab displays instead of up to maxTabs when one is deleted at the end of the list
			currentTabIndex += direction;
			scrollTab(-1);
		}

		updateTabs();
	}

	private void activateTab(TagTab tagTab)
	{
		if (activeTab != null && activeTab.equals(tagTab))
		{
			return;
		}

		if (activeTab != null)
		{
			Widget tab = activeTab.getBackground();
			tab.setSpriteId(TabSprites.TAB_BACKGROUND.getSpriteId());
			tab.revalidate();
			activeTab = null;
		}

		if (tagTab != null)
		{
			Widget tab = tagTab.getBackground();
			tab.setSpriteId(TabSprites.TAB_BACKGROUND_ACTIVE.getSpriteId());
			tab.revalidate();
			activeTab = tagTab;
		}
	}

	private void updateBounds()
	{
		Widget itemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		if (itemContainer == null)
		{
			return;
		}

		int height = itemContainer.getHeight();

		// If player isn't using normal bank tabs
		if (itemContainer.getRelativeY() == 0)
		{
			height -= (TAB_HEIGHT + MARGIN);
		}

		bounds.setSize(TAB_WIDTH + MARGIN * 2, height);
		bounds.setLocation(MARGIN, TAB_HEIGHT + MARGIN);

		Widget incinerator = client.getWidget(WidgetInfo.BANK_INCINERATOR);

		if (incinerator != null && !incinerator.isHidden())
		{
			incinerator.setOriginalHeight(INCINERATOR_HEIGHT);
			incinerator.setOriginalWidth(INCINERATOR_WIDTH);
			incinerator.setOriginalY(INCINERATOR_HEIGHT);

			Widget child = incinerator.getDynamicChildren()[0];
			child.setOriginalHeight(INCINERATOR_HEIGHT);
			child.setOriginalWidth(INCINERATOR_WIDTH);
			child.setWidthMode(WidgetSizeMode.ABSOLUTE);
			child.setHeightMode(WidgetSizeMode.ABSOLUTE);
			child.setType(WidgetType.GRAPHIC);
			child.setSpriteId(TabSprites.INCINERATOR.getSpriteId());
			incinerator.revalidate();

			bounds.setSize(TAB_WIDTH + MARGIN * 2, height - incinerator.getHeight());
		}

		if (upButton != null)
		{
			Point p = upButton.getCanvasLocation();
			canvasBounds.setBounds(p.getX(), p.getY() + BUTTON_HEIGHT, bounds.width, maxTabs * TAB_HEIGHT + maxTabs * MARGIN);
		}
	}

	private void updateTabs()
	{
		int y = bounds.y + MARGIN + BUTTON_HEIGHT;

		if (maxTabs >= tabManager.size())
		{
			currentTabIndex = 0;
		}
		else
		{
			y -= (currentTabIndex * TAB_HEIGHT + currentTabIndex * MARGIN);
		}

		for (TagTab tab : tabManager.getTabs())
		{
			updateWidget(tab.getBackground(), y);
			updateWidget(tab.getIcon(), y + 4);

			// Edge case where item icon is 1 pixel out of bounds
			tab.getIcon().setHidden(tab.getBackground().isHidden());

			// Keep item widget shown while drag scrolling
			if (client.getDraggedWidget() == tab.getIcon())
			{
				tab.getIcon().setHidden(false);
			}

			y += TAB_HEIGHT + MARGIN;
		}

		boolean hidden = !(tabManager.size() > 0);

		upButton.setHidden(hidden);
		upButton.setOriginalY(bounds.y);
		upButton.revalidate();

		downButton.setHidden(hidden);
		downButton.setOriginalY(bounds.y + maxTabs * TAB_HEIGHT + MARGIN * maxTabs + BUTTON_HEIGHT + MARGIN);
		downButton.revalidate();
	}

	private Widget createGraphic(String name, int spriteId, int itemId, int width, int height, int x, int y, boolean hasListener)
	{
		Widget widget = parent.createChild(-1, WidgetType.GRAPHIC);
		widget.setOriginalWidth(width);
		widget.setOriginalHeight(height);
		widget.setOriginalX(x);
		widget.setOriginalY(y);

		widget.setSpriteId(spriteId);

		if (itemId > -1)
		{
			widget.setItemId(itemId);
			widget.setItemQuantity(-1);
			widget.setBorderType(1);
		}

		if (hasListener)
		{
			widget.setOnOpListener(ScriptID.NULL);
			widget.setHasListener(true);
		}

		widget.setName(name);
		widget.revalidate();

		return widget;
	}

	private void updateWidget(Widget t, int y)
	{
		t.setOriginalY(y);
		t.setHidden(y < (bounds.y + BUTTON_HEIGHT + MARGIN) || y > (bounds.y + bounds.height - TAB_HEIGHT - MARGIN - BUTTON_HEIGHT));
		t.revalidate();
	}


	private ItemDefinition getItem(int idx)
	{
		ItemContainer bankContainer = client.getItemContainer(InventoryID.BANK);
		Item item = null;
		if (bankContainer != null)
		{
			item = bankContainer.getItems()[idx];
		}
		if (item != null)
		{
			return itemManager.getItemDefinition(item.getId());
		}

		return null;
	}

	private void openTag(final String tag)
	{
		activateTab(tabManager.find(tag));
		bankSearch.search(InputType.SEARCH, TAG_SEARCH + tag, true);

		// When tab is selected with search window open, the search window closes but the search button
		// stays highlighted, this solves that issue
		Widget searchBackground = client.getWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND);
		searchBackground.setSpriteId(SpriteID.EQUIPMENT_SLOT_TILE);
	}

	private void insertMenuEntry(MenuEntryAdded event, String option, String target)
	{
		client.insertMenuItem(
			option,
			target,
			MenuOpcode.RUNELITE.getId(),
			event.getIdentifier(),
			event.getParam0(),
			event.getParam1(),
			false
		);
	}
}
