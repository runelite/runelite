/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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
import com.google.common.util.concurrent.Runnables;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.KeyCode;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.ScriptEvent;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.WidgetClosed;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.ItemQuantityMode;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.chatbox.ChatboxItemSearch;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.bank.BankSearch;
import net.runelite.client.plugins.banktags.BankTagsConfig;
import net.runelite.client.plugins.banktags.BankTagsPlugin;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.TAG_SEARCH;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.VAR_TAG_SUFFIX;
import net.runelite.client.plugins.banktags.BankTagsService;
import net.runelite.client.plugins.banktags.TagManager;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

@Singleton
@Slf4j
public class TabInterface
{
	public static final IntPredicate FILTERED_CHARS = c -> "</>:".indexOf(c) == -1;

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
	private static final String TAGTABS = "tagtabs";
	private static final String OPEN_TAB_MENU = "View tag tabs";
	static final String ENABLE_LAYOUT = "Enable layout";
	static final String DISABLE_LAYOUT = "Disable layout";
	static final String REMOVE_LAYOUT = "Remove-layout";
	static final String DUPLICATE_ITEM = "Duplicate-item";
	private static final int TAB_HEIGHT = 40;
	private static final int TAB_WIDTH = 39;
	private static final int BUTTON_HEIGHT = 20;
	private static final int MARGIN = 1;
	private static final int SCROLL_TICK = 500;
	private static final int INCINERATOR_WIDTH = 48;
	private static final int INCINERATOR_HEIGHT = 39;
	private static final int BANK_BOTTOM_OFFSET = 39; // offset from bottom of BANK_CONTENT_CONTAINER
	private static final int BANK_ITEM_WIDTH = BankTagsPlugin.BANK_ITEM_WIDTH;
	private static final int BANK_ITEM_HEIGHT = BankTagsPlugin.BANK_ITEM_HEIGHT;
	private static final int BANK_ITEM_X_PADDING = BankTagsPlugin.BANK_ITEM_X_PADDING;
	private static final int BANK_ITEM_Y_PADDING = BankTagsPlugin.BANK_ITEM_Y_PADDING;
	private static final int BANK_ITEMS_PER_ROW = BankTagsPlugin.BANK_ITEMS_PER_ROW;
	private static final int BANK_ITEM_START_X = BankTagsPlugin.BANK_ITEM_START_X;
	private static final int BANK_ITEM_START_Y = BankTagsPlugin.BANK_ITEM_START_Y;
	private static final int TAB_OP_OPEN_TAG = 1;
	private static final int TAB_OP_CHANGE_ICON = 2;
	private static final int TAB_OP_LAYOUT = 3;
	private static final int TAB_OP_EXPORT_TAB = 4;
	private static final int TAB_OP_RENAME_TAB = 5;
	private static final int TAB_OP_DELETE_TAB = 6;
	private static final int NEWTAB_OP_NEW_TAB = 1;
	private static final int NEWTAB_OP_IMPORT_TAB = 2;
	private static final int NEWTAB_OP_OPEN_TAB_MENU = 3;
	private static final int TAGTAB_CHILD_OFFSET = 4;

	private final Client client;
	private final ClientThread clientThread;
	private final BankTagsPlugin plugin;
	private final ItemManager itemManager;
	private final TagManager tagManager;
	private final TabManager tabManager;
	private final LayoutManager layoutManager;
	private final ChatboxPanelManager chatboxPanelManager;
	private final BankTagsConfig config;
	private final BankSearch bankSearch;
	private final ChatboxItemSearch searchProvider;
	private final ChatMessageManager chatMessageManager;

	private boolean enabled;
	@Getter
	private String activeTag;
	private Layout activeLayout;
	private int activeOptions;
	@Getter
	private boolean tagTabActive;
	private int tagTabFirstChildIdx = -1;
	private int tabScrollOffset;
	private Instant startScroll = Instant.now();
	private int tabCount;

	private Widget parent;
	private Widget scrollComponent;
	private Widget upButton;
	private Widget downButton;
	private Widget newTab;

	@Inject
	private TabInterface(
		final Client client,
		final ClientThread clientThread,
		final BankTagsPlugin plugin,
		final ItemManager itemManager,
		final TagManager tagManager,
		final TabManager tabManager,
		final LayoutManager layoutManager,
		final ChatboxPanelManager chatboxPanelManager,
		final BankTagsConfig config,
		final BankSearch bankSearch,
		final ChatboxItemSearch searchProvider,
		final ChatMessageManager chatMessageManager
		)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.tagManager = tagManager;
		this.tabManager = tabManager;
		this.layoutManager = layoutManager;
		this.chatboxPanelManager = chatboxPanelManager;
		this.config = config;
		this.bankSearch = bankSearch;
		this.searchProvider = searchProvider;
		this.chatMessageManager = chatMessageManager;
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired event)
	{
		if (event.getScriptId() == ScriptID.BANKMAIN_INIT)
		{
			boolean tabs = config.tabs();
			if (enabled != tabs)
			{
				enabled = tabs;
				if (tabs)
				{
					init();
				}
				else
				{
					// this is probably the "Use Tag Tabs" option being toggled off when the bank is open
					deinit();
				}
			}
		}
		else if (event.getScriptId() == ScriptID.BANKMAIN_SIZE_CHECK && enabled)
		{
			// from [proc,bankmain_size_check] - resize tab layer when the bank is resized
			final int[] intStack = client.getIntStack();
			final int intStackSize = client.getIntStackSize();
			Widget w = client.getWidget(intStack[intStackSize - 5]);
			int width = intStack[intStackSize - 4];
			int height = intStack[intStackSize - 3];
			if (w.getWidth() != width || w.getHeight() != height)
			{
				log.debug("Bank resize!");
				// This is right before the bank is resized, so wait until after so the computed tab layer size is right
				clientThread.invokeLater(() ->
				{
					repositionButtons();
					layoutTabs();
				});
			}
		}
		else if (event.getScriptId() == ScriptID.BANKMAIN_SEARCH_TOGGLE)
		{
			if (activeTag != null || tagTabActive)
			{
				// close the active tab when search is pressed
				closeTag(false);
			}
		}
		else if (event.getScriptId() == ScriptID.BANKMAIN_FINISHBUILDING && enabled)
		{
			if (tagTabActive)
			{
				hideBank();
			}

			repositionButtons();
			rebuildTabs();
			int tagTabHeight = rebuildTagTabTab();

			// Apply our own title
			if (tagTabActive)
			{
				// Tag tab tab has its own title since it isn't a real tag
				Widget bankTitle = client.getWidget(InterfaceID.Bankmain.TITLE);
				bankTitle.setText("Tag tab tab");
			}
			else if (activeTag != null)
			{
				Widget bankTitle = client.getWidget(InterfaceID.Bankmain.TITLE);
				bankTitle.setText("Tag tab <col=ff0000>" + activeTag + "</col>");
			}

			// Recompute scroll size. Only required for tag tab tab since it doesn't show real items.
			if (tagTabActive)
			{
				// This is prior to bankmain_finishbuilding running, so the arguments are still on the stack. Overwrite
				// argument int13 (9 from the end) which is the height passed to if_setscrollsize
				final int[] intStack = client.getIntStack();
				final int intStackSize = client.getIntStackSize();
				intStack[intStackSize - 9] = tagTabHeight;
			}
		}
	}

	@Subscribe
	private void onScriptPostFired(ScriptPostFired ev)
	{
		if (ev.getScriptId() == ScriptID.BANKMAIN_POPUP_TAB_DRAW)
		{
			repositionButtons();
			layoutTabs();
		}
	}

	@Subscribe
	public void onWidgetClosed(WidgetClosed event)
	{
		if (event.getGroupId() == InterfaceID.BANKMAIN && event.isUnload())
		{
			enabled = false;
			upButton = downButton = newTab = scrollComponent = parent = null;
			activeTag = null;
			activeLayout = null;
			activeOptions = 0;
			plugin.openTag(null, null);
			tagTabActive = false;
			tagTabFirstChildIdx = -1;
		}
	}

	private void init()
	{
		assert parent == null; // avoid double init
		parent = client.getWidget(InterfaceID.Bankmain.ITEMS_CONTAINER);

		scrollComponent = parent.createChild(-1, WidgetType.TEXT); // not really text, but just to capture scroll
		scrollComponent.setHasListener(true);
		scrollComponent.setNoScrollThrough(true);
		scrollComponent.setOnScrollWheelListener((JavaScriptCallback) (event) -> scrollTab(event.getMouseY()));

		upButton = createGraphic(parent, "", TabSprites.UP_ARROW.getSpriteId(), -1, TAB_WIDTH, BUTTON_HEIGHT, MARGIN, 0);
		upButton.setAction(1, SCROLL_UP);
		int clickmask = upButton.getClickMask();
		clickmask |= WidgetConfig.DRAG_ON;
		upButton.setClickMask(clickmask);
		upButton.setHasListener(true);
		upButton.setOnOpListener((JavaScriptCallback) (event) -> scrollTab(-1));

		downButton = createGraphic(parent, "", TabSprites.DOWN_ARROW.getSpriteId(), -1, TAB_WIDTH, BUTTON_HEIGHT, MARGIN, 0);
		downButton.setAction(1, SCROLL_DOWN);
		clickmask = downButton.getClickMask();
		clickmask |= WidgetConfig.DRAG_ON;
		downButton.setClickMask(clickmask);
		downButton.setHasListener(true);
		downButton.setOnOpListener((JavaScriptCallback) (event) -> scrollTab(1));

		newTab = createGraphic(parent, "", TabSprites.NEW_TAB.getSpriteId(), -1, TAB_WIDTH, 39, MARGIN, 0);
		newTab.setHasListener(true);
		newTab.setAction(NEWTAB_OP_NEW_TAB, NEW_TAB);
		newTab.setAction(NEWTAB_OP_IMPORT_TAB, IMPORT_TAB);
		newTab.setAction(NEWTAB_OP_OPEN_TAB_MENU, OPEN_TAB_MENU);
		newTab.setOnOpListener((JavaScriptCallback) this::handleNewTab);

		tabManager.clear();
		tabManager.loadAllTabNames().forEach(this::loadTab);

		tabScrollOffset = config.position();
		scrollTab(0);

		if (config.rememberTab() && !Strings.isNullOrEmpty(config.tab()))
		{
			// the server will resync the last opened vanilla tab when the bank is opened
			client.setVarbit(VarbitID.BANK_CURRENTTAB, 0);
			var tab = config.tab();
			var layout = layoutManager.loadLayout(tab);
			plugin.openTag(tab, layout);
		}
	}

	public void deinit()
	{
		enabled = false;
		activeTag = null;
		activeLayout = null;
		activeOptions = 0;
		plugin.openTag(null, null);

		upButton = downButton = newTab = scrollComponent = null;

		if (parent != null)
		{
			parent.deleteAllChildren();
			parent = null;
		}

		tabManager.clear();
	}

	private void handleDeposit(MenuOptionClicked event, boolean inventory)
	{
		ItemContainer container = client.getItemContainer(inventory ? InventoryID.INV : InventoryID.WORN);

		if (container == null)
		{
			return;
		}

		List<Integer> items = Arrays.stream(container.getItems())
			.filter(Objects::nonNull)
			.map(Item::getId)
			.filter(id -> id != -1)
			.collect(Collectors.toList());

		if (!Strings.isNullOrEmpty(event.getMenuTarget()))
		{
			if (activeTag != null && Text.removeTags(event.getMenuTarget()).equals(activeTag))
			{
				for (Integer item : items)
				{
					tagManager.addTag(item, activeTag, false);
				}

				reloadActiveTab();
			}

			return;
		}

		chatboxPanelManager.openTextInput((inventory ? "Inventory" : "Equipment") + " tags:")
			.addCharValidator(FILTERED_CHARS)
			.onDone((Consumer<String>) (newTags) ->
				clientThread.invoke(() ->
				{
					final List<String> tags = Text.fromCSV(newTags.toLowerCase());

					for (Integer item : items)
					{
						tagManager.addTags(item, tags, false);
					}

					reloadActiveTab();
				}))
			.build();
	}

	private void handleNewTab(ScriptEvent event)
	{
		switch (event.getOp() - 1)
		{
			case NEWTAB_OP_NEW_TAB:
				chatboxPanelManager.openTextInput("Tag name")
					.addCharValidator(FILTERED_CHARS)
					.onDone((Consumer<String>) (tagName) -> clientThread.invoke(() ->
					{
						if (!Strings.isNullOrEmpty(tagName))
						{
							loadTab(tagName);
							tabManager.save();

							repositionButtons();
							rebuildTabs();
							rebuildTagTabTab();
						}
					}))
					.build();
				break;
			case NEWTAB_OP_IMPORT_TAB:
				try
				{
					final String dataString = Toolkit
						.getDefaultToolkit()
						.getSystemClipboard()
						.getData(DataFlavor.stringFlavor)
						.toString()
						.trim();

					final Iterator<String> dataIter = Text.fromCSV(dataString).iterator();
					TagTab tab = dataString.startsWith("banktaglayoutsplugin") ? importBtlTag(dataIter) : importTag(dataIter);
					if (tab == null)
					{
						sendChatMessage("Failed to import tag tab from clipboard, invalid format.");
						return;
					}

					tabManager.add(tab);
					tabManager.save();

					repositionButtons();
					rebuildTabs();
					rebuildTagTabTab();

					if (tab.getTag().equals(activeTag))
					{
						bankSearch.reset(true);
					}

					sendChatMessage("Tag tab '" + tab.getTag() + "' has been imported from your clipboard!");
				}
				catch (UnsupportedFlavorException | NoSuchElementException | IOException | NumberFormatException ex)
				{
					log.debug("failed to import tab", ex);
					sendChatMessage("Failed to import tag tab from clipboard, invalid format.");
				}
				break;
			case NEWTAB_OP_OPEN_TAB_MENU:
				client.setVarbit(VarbitID.BANK_CURRENTTAB, 0);
				plugin.openTag(TAGTABS, null, 0);
				break;
		}
	}

	private TagTab importTag(Iterator<String> dataIter)
	{
		String name = dataIter.next();
		if ("banktags".equals(name))
		{
			dataIter.next(); // version
			name = dataIter.next();
		}
		StringBuilder sb = new StringBuilder();
		for (char c : name.toCharArray())
		{
			if (FILTERED_CHARS.test(c))
			{
				sb.append(c);
			}
		}

		if (sb.length() == 0)
		{
			return null;
		}

		name = sb.toString();

		TagTab tab = tabManager.load(name);
		tab.setIconItemId(Integer.parseInt(dataIter.next()));

		while (dataIter.hasNext())
		{
			String token = dataIter.next();
			if ("layout".equals(token))
			{
				break;
			}

			final int itemId = Integer.parseInt(token);
			tagManager.addTag(itemId, name, itemId < 0);
		}

		if (dataIter.hasNext())
		{
			Layout l = new Layout(name);
			while (dataIter.hasNext())
			{
				final int idx = Integer.parseInt(dataIter.next());
				final int itemId = Integer.parseInt(dataIter.next());
				l.setItemAtPos(itemId, idx);
				tagManager.addTag(itemId, name, false);
			}

			layoutManager.saveLayout(l);
		}

		return tab;
	}

	private TagTab importBtlTag(Iterator<String> dataIter)
	{
		String header = dataIter.next();
		String name = header.substring("banktaglayoutsplugin:".length());

		StringBuilder sb = new StringBuilder();
		for (char c : name.toCharArray())
		{
			if (FILTERED_CHARS.test(c))
			{
				sb.append(c);
			}
		}

		if (sb.length() == 0)
		{
			return null;
		}

		name = sb.toString();

		TagTab tab = tabManager.load(name);
		Layout l = new Layout(name);

		while (dataIter.hasNext())
		{
			String token = dataIter.next();
			if (token.startsWith("banktag:"))
			{
				break;
			}

			String[] s = token.split(":");
			final int itemId = Integer.parseInt(s[0]);
			final int idx = Integer.parseInt(s[1]);
			l.setItemAtPos(itemId, idx);
		}

		tab.setIconItemId(Integer.parseInt(dataIter.next()));

		while (dataIter.hasNext())
		{
			String token = dataIter.next();
			final int itemId = Integer.parseInt(token);
			tagManager.addTag(itemId, name, itemId < 0);
		}

		layoutManager.saveLayout(l);

		return tab;
	}

	private void opTagTab(ScriptEvent event)
	{
		switch (event.getOp() - 1)
		{
			case TAB_OP_OPEN_TAG:
			{
				if (client.getVarbitValue(VarbitID.BANK_CURRENTTAB) == PotionStorage.BANKTAB_POTIONSTORE)
				{
					// Opening a tag tab with the potion store open would leave the store open in the background,
					// making deposits not work. Force close the potion store.
					log.debug("Closing potion store");
					client.menuAction(-1, InterfaceID.Bankmain.POTIONSTORE_BUTTON, MenuAction.CC_OP, 1, -1, "Potion store", "");
				}
				client.setVarbit(VarbitID.BANK_CURRENTTAB, 0);

				Widget clicked = event.getSource();

				String tag = Text.removeTags(clicked.getName());

				if (tag.equals(activeTag))
				{
					closeTag(true);
				}
				else
				{
					Layout layout = layoutManager.loadLayout(tag);
					plugin.openTag(tag, layout);
				}

				client.playSoundEffect(SoundEffectID.UI_BOOP);
				break;
			}
			case TAB_OP_CHANGE_ICON:
			{
				final String tag = Text.removeTags(event.getOpbase());
				searchProvider
					.tooltipText(CHANGE_ICON + " (" + tag + ")")
					.onItemSelected((itemId) ->
					{
						TagTab tab = tabManager.find(tag);
						if (tab != null)
						{
							tab.setIconItemId(itemId);
							tabManager.save();
							clientThread.invokeLater(() ->
							{
								rebuildTabs();
								rebuildTagTabTab();
							});
						}
					})
					.build();
				break;
			}
			case TAB_OP_LAYOUT:
			{
				String tag = Text.removeTags(event.getSource().getName());
				Layout layout = layoutManager.loadLayout(tag);

				if (layout == null)
				{
					layout = new Layout(tag);
					layoutManager.saveLayout(layout);
					sendChatMessage("Tag tab '" + tag + "' is now in layout mode. You may reorder the items without changing their order in the bank.");
				}
				else
				{
					layoutManager.removeLayout(tag);
					layout = null;
					sendChatMessage("Tag tab '" + tag + "' is no longer in layout mode");
				}

				if (tag.equals(activeTag))
				{
					plugin.openTag(tag, layout);
				}

				bankSearch.layoutBank();
				break;
			}
			case TAB_OP_DELETE_TAB:
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
					.option("3. Cancel", Runnables.doNothing())
					.build();
				break;
			case TAB_OP_EXPORT_TAB:
				final List<String> data = new ArrayList<>();
				final String tag = Text.removeTags(event.getOpbase());
				final TagTab tagTab = tabManager.find(tag);
				final Layout layout = layoutManager.loadLayout(tag);
				data.add("banktags");
				data.add("1");
				data.add(tagTab.getTag());
				data.add(String.valueOf(tagTab.getIconItemId()));

				for (Integer item : tagManager.getItemsForTag(tagTab.getTag()))
				{
					if (layout == null || layout.count(item) == 0)
					{
						data.add(String.valueOf(item));
					}
				}

				if (layout != null)
				{
					data.add("layout");
					int[] l = layout.getLayout();
					for (int idx = 0; idx < l.length; ++idx)
					{
						if (l[idx] != -1)
						{
							data.add(String.valueOf(idx));
							data.add(String.valueOf(l[idx]));
						}
					}
				}

				final StringSelection stringSelection = new StringSelection(Text.toCSV(data));
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				sendChatMessage("Tag tab '" + tagTab.getTag() + "' has been copied to your clipboard!");
				break;
			case TAB_OP_RENAME_TAB:
				String renameTarget = Text.standardize(event.getOpbase());
				renameTab(renameTarget);
				break;
		}
	}

	@Subscribe
	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if ((activeOptions & BankTagsService.OPTION_ALLOW_MODIFICATIONS) != 0
			&& event.getActionParam1() == InterfaceID.Bankmain.ITEMS
			&& (event.getOption().equals("Examine")
			// Potion storage has no Examine
			|| (event.getOption().equals("Withdraw-All-but-1") && !client.getItemContainer(InventoryID.BANK).contains(event.getItemId()))))
		{
			int index = event.getOption().equals("Examine") ? -1 : -2;
			if (activeLayout != null)
			{
				client.createMenuEntry(index)
					.setParam0(event.getActionParam0())
					.setParam1(event.getActionParam1())
					.setTarget(event.getTarget())
					.setOption(DUPLICATE_ITEM)
					.setType(MenuAction.RUNELITE)
					.setIdentifier(event.getIdentifier())
					.setItemId(event.getItemId())
					.onClick(this::opDuplicateItem);
			}

			if (activeLayout != null && activeLayout.count(itemManager.canonicalize(event.getItemId())) > 1)
			{
				client.createMenuEntry(index)
					.setParam0(event.getActionParam0())
					.setParam1(event.getActionParam1())
					.setTarget(event.getTarget())
					.setOption(REMOVE_LAYOUT)
					.setType(MenuAction.RUNELITE)
					.setIdentifier(event.getIdentifier())
					.onClick(this::opRemoveLayout);
			}
			else
			{
				boolean hidden = tagManager.isHidden(activeTag);
				client.createMenuEntry(-1)
					.setParam0(event.getActionParam0())
					.setParam1(event.getActionParam1())
					.setTarget(event.getTarget())
					.setOption(!hidden && (activeOptions & BankTagsService.OPTION_HIDE_TAG_NAME) == 0 ? REMOVE_TAG + " (" + activeTag + ")" : REMOVE_TAG)
					.setType(MenuAction.RUNELITE)
					.setIdentifier(event.getIdentifier())
					.setItemId(event.getItemId())
					.onClick(e ->
					{
						final int itemId = e.getItemId();
						if (activeLayout != null)
						{
							activeLayout.removeItem(itemId);
							layoutManager.saveLayout(activeLayout);
						}
						tagManager.removeTag(itemId, activeTag);
						bankSearch.layoutBank(); // re-layout to filter the removed item out
					});
			}
		}
		// Duplicate/Remove on layout placeholders
		else if (activeTag != null
			&& event.getActionParam1() == InterfaceID.Bankmain.ITEMS
			&& event.getOption().equals(DUPLICATE_ITEM))
		{
			// use RUNELITE_LOW_PRIORITY to avoid sending the op to the server, but also keep it right-click only
			event.getMenuEntry().setType(MenuAction.RUNELITE_LOW_PRIORITY);
			event.getMenuEntry().onClick(this::opDuplicateItem);
		}
		if (activeTag != null
			&& event.getActionParam1() == InterfaceID.Bankmain.ITEMS
			&& event.getOption().equals(REMOVE_LAYOUT))
		{
			event.getMenuEntry().setType(MenuAction.RUNELITE_LOW_PRIORITY);
			event.getMenuEntry().onClick(this::opRemoveLayout);
		}
		else if (event.getActionParam1() == InterfaceID.Bankmain.DEPOSITINV
			&& event.getOption().equals("Deposit inventory"))
		{
			createMenuEntry(event, TAG_INVENTORY, event.getTarget());

			if (activeTag != null && !tagManager.isHidden(activeTag)
				&& (activeOptions & (BankTagsService.OPTION_ALLOW_MODIFICATIONS | BankTagsService.OPTION_HIDE_TAG_NAME)) == BankTagsService.OPTION_ALLOW_MODIFICATIONS)
			{
				createMenuEntry(event, TAG_INVENTORY, ColorUtil.wrapWithColorTag(activeTag, HILIGHT_COLOR));
			}
		}
		else if (event.getActionParam1() == InterfaceID.Bankmain.DEPOSITWORN
			&& event.getOption().equals("Deposit worn items"))
		{
			createMenuEntry(event, TAG_GEAR, event.getTarget());

			if (activeTag != null && !tagManager.isHidden(activeTag)
				&& (activeOptions & (BankTagsService.OPTION_ALLOW_MODIFICATIONS | BankTagsService.OPTION_HIDE_TAG_NAME)) == BankTagsService.OPTION_ALLOW_MODIFICATIONS)
			{
				createMenuEntry(event, TAG_GEAR, ColorUtil.wrapWithColorTag(activeTag, HILIGHT_COLOR));
			}
		}

		layoutManager.onMenuEntryAdded(event, this);
	}

	private void opDuplicateItem(MenuEntry e)
	{
		int id = itemManager.canonicalize(e.getItemId());
		log.debug("Duplicate item {} at {}", itemManager.getItemComposition(id).getName(), e.getParam0());
		activeLayout.addItemAfter(id, e.getParam0());
		layoutManager.saveLayout(activeLayout);
		bankSearch.layoutBank();
	}

	private void opRemoveLayout(MenuEntry e)
	{
		activeLayout.removeItemAtPos(e.getParam0());
		layoutManager.saveLayout(activeLayout);
		bankSearch.layoutBank();
	}

	@Subscribe(priority = -1)
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		// Close the chatbox input when clicking on things in the bank, to mimic how actions like withdrawing
		// items or changing tabs close the withdraw-x input or the bank search input.
		if (chatboxPanelManager.getCurrentInput() != null
			&& event.getWidget() != null
			&& !event.getMenuOption().equals(SCROLL_UP)
			&& !event.getMenuOption().equals(SCROLL_DOWN))
		{
			int interfaceId = WidgetUtil.componentToInterface(event.getWidget().getId());
			if (interfaceId == InterfaceID.BANKMAIN || interfaceId == InterfaceID.BANKSIDE)
			{
				chatboxPanelManager.close();
			}
		}

		MenuEntry menuEntry = event.getMenuEntry();
		if (event.getMenuOption().startsWith("View tab") || event.getMenuOption().equals("View all items")
			|| (menuEntry.getType() == MenuAction.CC_OP && menuEntry.getParam1() == InterfaceID.Bankmain.POTIONSTORE_BUTTON))
		{
			closeTag(false);
		}
		else if (event.getMenuAction() == MenuAction.RUNELITE
			&& ((event.getParam1() == InterfaceID.Bankmain.DEPOSITINV && event.getMenuOption().equals(TAG_INVENTORY))
			|| (event.getParam1() == InterfaceID.Bankmain.DEPOSITWORN && event.getMenuOption().equals(TAG_GEAR))))
		{
			handleDeposit(event, event.getParam1() == InterfaceID.Bankmain.DEPOSITINV);
		}

		layoutManager.onMenuOptionClicked(event);
	}

	@Subscribe
	public void onDraggingWidgetChanged(DraggingWidgetChanged event)
	{
		if (!enabled)
		{
			return;
		}

		Widget draggedOn = client.getDraggedOnWidget();
		Widget draggedWidget = client.getDraggedWidget();

		// Returning early or nulling the drag release listener has no effect. Hence, we need to
		// null the draggedOnWidget instead.
		if (draggedWidget.getId() == InterfaceID.Bankmain.ITEMS && activeTag != null
			&& (activeLayout == null && config.preventTagTabDrags()
			|| (activeOptions & BankTagsService.OPTION_ALLOW_MODIFICATIONS) == 0))
		{
			client.setDraggedOnWidget(null);
		}

		final boolean isDragging = event.isDraggingWidget();
		final boolean shiftDown = client.isKeyPressed(KeyCode.KC_SHIFT);
		if (!isDragging || draggedOn == null)
		{
			return;
		}

		// is dragging widget and mouse button released
		if (client.getMouseCurrentButton() == 0)
		{
			if (!tagTabActive
				&& draggedWidget.getId() == InterfaceID.Bankmain.ITEMS
				&& draggedWidget.getItemId() != -1
				&& draggedOn.getParent() == parent
				&& draggedOn.getIndex() >= TAGTAB_CHILD_OFFSET) // skip buttons
			{
				// Tag an item dragged on a tag tab
				log.debug("Dragged {} to tab {}", draggedWidget.getItemId(), Text.removeTags(draggedOn.getName()));
				tagManager.addTag(draggedWidget.getItemId(), draggedOn.getName(), shiftDown);
				reloadActiveTab();
			}
			else if ((tagTabActive && draggedWidget.getId() == InterfaceID.Bankmain.ITEMS && draggedOn.getId() == InterfaceID.Bankmain.ITEMS)
				|| (draggedWidget.getParent() == parent && draggedOn.getParent() == parent && draggedWidget.getIndex() >= TAGTAB_CHILD_OFFSET && draggedOn.getIndex() >= TAGTAB_CHILD_OFFSET))
			{
				// Reorder tag tabs
				log.debug("Reorder tag tab {} <-> {}", draggedWidget, draggedOn);
				moveTagTab(draggedWidget, draggedOn);
			}
			else
			{
				// Rebuild to avoid the dragged tab being left over due to it being excluded from being hidden when layouted
				rebuildTabs();
			}
		}
		else if (draggedWidget.getItemId() != -1)
		{
			MenuEntry[] entries = client.getMenuEntries();

			if (entries.length > 0)
			{
				MenuEntry entry = entries[entries.length - 1];

				if (draggedWidget.getItemId() > 0 && entry.getOption().equals(VIEW_TAB) && draggedOn.getId() != draggedWidget.getId())
				{
					entry.setOption(TAG_SEARCH + Text.removeTags(entry.getTarget()) + (shiftDown ? VAR_TAG_SUFFIX : ""));
					entry.setTarget(draggedWidget.getName());
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

	private void moveTagTab(final Widget source, final Widget dest)
	{
		if (Strings.isNullOrEmpty(dest.getName()))
		{
			return;
		}

		if (client.getVarbitValue(VarbitID.BANK_INSERTMODE) == 0)
		{
			tabManager.swap(source.getName(), dest.getName());
		}
		else
		{
			tabManager.insert(source.getName(), dest.getName());
		}

		tabManager.save();
		rebuildTabs();
		rebuildTagTabTab();
	}

	private void addTabActions(TagTab tab, Widget w)
	{
		w.setAction(TAB_OP_OPEN_TAG, VIEW_TAB);
		w.setAction(TAB_OP_CHANGE_ICON, CHANGE_ICON);
		if (!TAGTABS.equals(tab.getTag()))
		{
			w.setAction(TAB_OP_LAYOUT, activeLayout != null ? DISABLE_LAYOUT : ENABLE_LAYOUT);
		}
		w.setAction(TAB_OP_EXPORT_TAB, EXPORT_TAB);
		w.setAction(TAB_OP_RENAME_TAB, RENAME_TAB);
		w.setAction(TAB_OP_DELETE_TAB, REMOVE_TAB);
		w.setHasListener(true);
		w.setOnOpListener((JavaScriptCallback) this::opTagTab);
	}

	private void addTabOptions(Widget w)
	{
		int clickmask = w.getClickMask();
		clickmask |= WidgetConfig.DRAG;
		clickmask |= WidgetConfig.DRAG_ON;
		w.setClickMask(clickmask);
		w.setDragDeadTime(5);
		w.setDragDeadZone(5);
		w.setItemQuantity(10000);
		w.setItemQuantityMode(ItemQuantityMode.NEVER);
	}

	private void loadTab(String tag)
	{
		TagTab tagTab = tabManager.load(tag);
		tabManager.add(tagTab);
	}

	private void deleteTab(String tag)
	{
		if (tag.equals(activeTag))
		{
			closeTag(true);
		}

		tabManager.remove(tag);
		tabManager.save();

		layoutManager.removeLayout(tag);

		repositionButtons();
		rebuildTabs();
		rebuildTagTabTab();
		scrollTab(0);
	}

	private void renameTab(String oldTag)
	{
		chatboxPanelManager.openTextInput("Enter new tag name for tag \"" + oldTag + "\":")
			.addCharValidator(FILTERED_CHARS)
			.onDone((Consumer<String>) (newTag) -> clientThread.invoke(() ->
			{
				if (!Strings.isNullOrEmpty(newTag) && !newTag.equalsIgnoreCase(oldTag))
				{
					if (tabManager.find(newTag) == null)
					{
						TagTab tagTab = tabManager.find(oldTag);
						Layout layout = layoutManager.loadLayout(oldTag);

						tabManager.remove(oldTag); // remove the icon
						layoutManager.removeLayout(oldTag); // remove the layout

						tagTab.setTag(newTag);

						tabManager.add(tagTab);
						tabManager.save();

						if (activeTag.equals(oldTag))
						{
							activeTag = newTag;
						}

						if (layout != null)
						{
							Layout newLayout = new Layout(newTag, layout.getLayout());
							layoutManager.saveLayout(newLayout);
						}

						tagManager.renameTag(oldTag, newTag); // rename tag on items

						rebuildTabs();
						rebuildTagTabTab();

						reloadActiveTab();
					}
					else
					{
						chatboxPanelManager.openTextMenuInput("The specified bank tag already exists.")
							.option("1. Merge into existing tag \"" + newTag + "\".", () ->
								clientThread.invoke(() ->
								{
									tagManager.renameTag(oldTag, newTag);
									deleteTab(oldTag);

									if (oldTag.equals(activeTag))
									{
										plugin.openBankTag(newTag);
									}
									else
									{
										reloadActiveTab();
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
		// This ensures that dragging on scroll buttons does not scroll too fast
		if (startScroll.until(Instant.now(), ChronoUnit.MILLIS) >= SCROLL_TICK)
		{
			startScroll = Instant.now();
			scrollTab(direction);
		}
	}

	private void scrollTab(int d)
	{
		tabScrollOffset += d;

		int maxScroll = tabManager.size() - tabCount;
		if (tabScrollOffset > maxScroll)
		{
			tabScrollOffset = maxScroll;
		}

		if (tabScrollOffset < 0)
		{
			tabScrollOffset = 0;
		}

		config.position(tabScrollOffset);

		layoutTabs();
	}

	public void openTag(String tag, Layout layout, int options, boolean relayout)
	{
		activeTag = tag;
		activeLayout = layout;
		activeOptions = options;
		tagTabActive = TAGTABS.equals(tag);
		config.tab(tag);

		if (relayout)
		{
			bankSearch.reset(true);
		}
	}

	public void closeTag(boolean relayout)
	{
		activeTag = null;
		activeLayout = null;
		activeOptions = 0;
		tagTabActive = false;
		plugin.openTag(null, null);
		config.tab("");

		if (relayout)
		{
			bankSearch.reset(true);
		}
	}

	public void reloadActiveTab()
	{
		if (activeTag != null)
		{
			plugin.openBankTag(activeTag);
		}
	}

	private void repositionButtons()
	{
		int height = parent.getHeight() - BANK_BOTTOM_OFFSET;

		Widget widget = client.getWidget(InterfaceID.Bankmain.INCINERATOR_TARGET);
		if (widget != null && !widget.isHidden())
		{
			height = Math.min(height, widget.getRelativeY());
		}

		widget = client.getWidget(InterfaceID.Bankmain.POPUP_BUTTON_OUT);
		if (widget != null && !widget.isHidden())
		{
			height = Math.min(height, widget.getRelativeY());
		}

		Widget popupTab = client.getWidget(InterfaceID.Bankmain.STORAGE_POPUP_TAB);
		if (popupTab != null && !popupTab.isHidden())
		{
			widget = client.getWidget(InterfaceID.Bankmain.GIM_STORAGE);
			if (widget != null && !widget.isHidden())
			{
				height = Math.min(height, popupTab.getRelativeY() + widget.getRelativeY());
			}

			widget = client.getWidget(InterfaceID.Bankmain.POTIONSTORE_BUTTON);
			if (widget != null && !widget.isHidden())
			{
				height = Math.min(height, popupTab.getRelativeY() + widget.getRelativeY());
			}
		}

		scrollComponent.setOriginalY(41 + BUTTON_HEIGHT);
		scrollComponent.setOriginalWidth(TAB_WIDTH + MARGIN * 2);

		// Keep the tab layer height a multiple of the tab heights
		int tabLayerHeight = height
			- scrollComponent.getOriginalY()
			- BUTTON_HEIGHT; // the bottom button
		tabCount = tabLayerHeight / (TAB_HEIGHT + MARGIN);
		scrollComponent.setOriginalHeight(tabCount * (TAB_HEIGHT + MARGIN));

		scrollComponent.revalidate();

		upButton.setOriginalY(41);
		upButton.revalidate();

		downButton.setOriginalY(41 + BUTTON_HEIGHT + tabCount * (TAB_HEIGHT + MARGIN) + MARGIN);
		downButton.revalidate();
	}

	private void rebuildTabs()
	{
		// remove the tag tabs but keep the buttons and scroll component
		parent.setChildren(Arrays.copyOf(parent.getChildren(), TAGTAB_CHILD_OFFSET));

		var tabs = tabManager.getTabs();
		for (TagTab tab : tabs)
		{
			Widget background = createGraphic(parent, ColorUtil.wrapWithColorTag(tab.getTag(), HILIGHT_COLOR),
				(tab.getTag().equals(activeTag) ? TabSprites.TAB_BACKGROUND_ACTIVE : TabSprites.TAB_BACKGROUND).getSpriteId(),
				-1, TAB_WIDTH, TAB_HEIGHT, MARGIN, -1);
			addTabActions(tab, background);

			Widget icon = createGraphic(
				parent,
				ColorUtil.wrapWithColorTag(tab.getTag(), HILIGHT_COLOR),
				-1,
				tab.getIconItemId(),
				Constants.ITEM_SPRITE_WIDTH, Constants.ITEM_SPRITE_HEIGHT,
				MARGIN + 3, -1);
			addTabOptions(icon);
		}

		layoutTabs();
	}

	// layout the tabs for their position due to scroll or window resize
	private void layoutTabs()
	{
		Widget[] children = parent.getChildren();
		Widget draggedWidget = client.getDraggedWidget();
		for (int i = TAGTAB_CHILD_OFFSET; i < children.length; ++i)
		{
			Widget child = children[i];
			// avoid hiding dragged widget if scrolling from drag
			if (draggedWidget != child)
			{
				child.setHidden(true);
			}
		}

		int y = scrollComponent.getOriginalY();
		y += MARGIN;

		for (int i = tabScrollOffset;
			i < tabScrollOffset + tabCount && i * 2 + 1 < children.length - TAGTAB_CHILD_OFFSET && children[TAGTAB_CHILD_OFFSET + i * 2] != null;
			++i)
		{
			Widget background = children[TAGTAB_CHILD_OFFSET + i * 2];
			background.setOriginalY(y);
			background.setHidden(false);
			background.revalidate();

			Widget icon = children[TAGTAB_CHILD_OFFSET + i * 2 + 1];
			icon.setOriginalY(y + 4);
			icon.setHidden(false);
			icon.revalidate();

			y += TAB_HEIGHT + MARGIN;
		}
	}

	private int rebuildTagTabTab()
	{
		int itemX = BANK_ITEM_START_X;
		int itemY = BANK_ITEM_START_Y;
		int rowIndex = 0;

		// tabs are stored at the end of the item container to avoid interfering with the real items,
		// this is easier than making a layer for them because the bank scrollbar has to be adjusted
		// otherwise for the new layer
		Widget parent = client.getWidget(InterfaceID.Bankmain.ITEMS);
		if (tagTabFirstChildIdx == -1)
		{
			tagTabFirstChildIdx = parent.getChildren().length;
		}

		int idx = tagTabFirstChildIdx;
		Widget w;
		while ((w = parent.getChild(idx++)) != null)
		{
			w.setHidden(true);
		}

		if (!tagTabActive)
		{
			return 0;
		}

		idx = tagTabFirstChildIdx;
		for (TagTab tagTab : tabManager.getTabs())
		{
			Widget menu = parent.getChild(idx++);
			if (menu == null)
			{
				menu = parent.createChild(-1, WidgetType.GRAPHIC);
				menu.setOriginalWidth(BANK_ITEM_WIDTH);
				menu.setOriginalHeight(BANK_ITEM_HEIGHT);
			}
			menu.setHidden(false);
			menu.setOriginalX(itemX);
			menu.setOriginalY(itemY);
			menu.setName(ColorUtil.wrapWithColorTag(tagTab.getTag(), HILIGHT_COLOR));
			menu.setItemId(tagTab.getIconItemId());
			menu.setItemQuantity(-1);
			menu.setBorderType(1);
			addTabActions(tagTab, menu);
			addTabOptions(menu);
			menu.revalidate();

			rowIndex++;
			if (rowIndex == BANK_ITEMS_PER_ROW)
			{
				itemX = BANK_ITEM_START_X;
				itemY += BANK_ITEM_Y_PADDING + BANK_ITEM_HEIGHT;
				rowIndex = 0;
			}
			else
			{
				itemX += BANK_ITEM_X_PADDING + BANK_ITEM_WIDTH;
			}
		}

		return itemY + BANK_ITEM_HEIGHT;
	}

	private void hideBank()
	{
		// hide the items & the separators
		Widget parent = client.getWidget(InterfaceID.Bankmain.ITEMS);
		for (Widget w : parent.getChildren())
		{
			w.setHidden(true);
		}
	}

	private Widget createGraphic(Widget container, String name, int spriteId, int itemId, int width, int height, int x, int y)
	{
		Widget widget = container.createChild(-1, WidgetType.GRAPHIC);
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

		widget.setName(name);
		widget.revalidate();

		return widget;
	}

	private void createMenuEntry(MenuEntryAdded event, String option, String target)
	{
		client.createMenuEntry(-1)
			.setParam0(event.getActionParam0())
			.setParam1(event.getActionParam1())
			.setTarget(target)
			.setOption(option)
			.setType(MenuAction.RUNELITE)
			.setIdentifier(event.getIdentifier());
	}

	private void sendChatMessage(final String message)
	{
		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(message)
			.build());
	}
}
