/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
 * Copyright (c) 2024, sam <dasistkeinnamen@gmail.com>
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.ParamID;
import net.runelite.api.ScriptEvent;
import net.runelite.api.ScriptID;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.ItemQuantityMode;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.bank.BankSearch;
import net.runelite.client.plugins.banktags.BankTag;
import net.runelite.client.plugins.banktags.BankTagsPlugin;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.BANK_ITEMS_PER_ROW;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.BANK_ITEM_HEIGHT;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.BANK_ITEM_START_X;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.BANK_ITEM_WIDTH;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.BANK_ITEM_X_PADDING;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.BANK_ITEM_Y_PADDING;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.CONFIG_GROUP;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.TAG_LAYOUT_PREFIX;
import net.runelite.client.plugins.banktags.BankTagsService;
import static net.runelite.client.plugins.banktags.tabs.TabInterface.DUPLICATE_ITEM;
import static net.runelite.client.plugins.banktags.tabs.TabInterface.REMOVE_LAYOUT;
import net.runelite.client.util.Text;

@Slf4j
@Singleton
public class LayoutManager
{
	private final Client client;
	private final ItemManager itemManager;
	private final BankTagsPlugin plugin;
	private final ChatboxPanelManager chatboxPanelManager;
	private final BankSearch bankSearch;
	private final ChatMessageManager chatMessageManager;
	private final PotionStorage potionStorage;
	private final EventBus eventBus;
	private final ConfigManager configManager;

	private final List<PluginAutoLayout> autoLayouts = new ArrayList<>();

	@Inject
	LayoutManager(Client client, ItemManager itemManager, BankTagsPlugin plugin, ChatboxPanelManager chatboxPanelManager,
		BankSearch bankSearch, ChatMessageManager chatMessageManager,
		PotionStorage potionStorage, EventBus eventBus, ConfigManager configManager)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.plugin = plugin;
		this.chatboxPanelManager = chatboxPanelManager;
		this.bankSearch = bankSearch;
		this.chatMessageManager = chatMessageManager;
		this.potionStorage = potionStorage;
		this.eventBus = eventBus;
		this.configManager = configManager;

		registerAutoLayout(plugin, "Default", new DefaultLayout());
	}

	public void register()
	{
		eventBus.register(this);
		eventBus.register(potionStorage);
	}

	public void unregister()
	{
		eventBus.unregister(this);
		eventBus.unregister(potionStorage);
	}

	@Nullable
	public Layout loadLayout(String tag)
	{
		String layoutStr = configManager.getConfiguration(CONFIG_GROUP, TAG_LAYOUT_PREFIX + Text.standardize(tag));
		if (layoutStr != null)
		{
			List<String> layoutList = Text.fromCSV(layoutStr);
			int[] layout = new int[layoutList.size()];
			for (int i = 0; i < layoutList.size(); ++i)
			{
				layout[i] = Integer.parseInt(layoutList.get(i));
			}

			return new Layout(tag, layout);
		}
		return null;
	}

	public void saveLayout(Layout layout)
	{
		String tag = layout.getTag();
		int[] l = layout.getLayout();
		StringBuilder sb = new StringBuilder(l.length * 5);
		for (int i = 0; i < l.length; ++i)
		{
			if (i > 0)
			{
				sb.append(',');
			}
			sb.append(l[i]);
		}
		configManager.setConfiguration(CONFIG_GROUP, TAG_LAYOUT_PREFIX + Text.standardize(tag), sb.toString());
	}

	public void removeLayout(String tag)
	{
		configManager.unsetConfiguration(CONFIG_GROUP, TAG_LAYOUT_PREFIX + Text.standardize(tag));
	}

	private void layout(Layout l)
	{
		ItemContainer bank = client.getItemContainer(InventoryID.BANK);
		Widget itemContainer = client.getWidget(InterfaceID.Bankmain.ITEMS);

		// Hide all of the existing items first
		Set<Integer> bankItems = new LinkedHashSet<>();
		for (int i = 0; i < bank.size(); ++i)
		{
			Widget c = itemContainer.getChild(i);
			// ~bankmain_drawitem uses 6512 for empty item slots
			if (!c.isSelfHidden() && c.getItemId() > -1 && c.getItemId() != ItemID.BLANKOBJECT)
			{
				bankItems.add(c.getItemId());
				if (log.isDebugEnabled())
				{
					var def = itemManager.getItemComposition(c.getItemId());
					log.debug("Bank contains {}{}", def.getName(), def.getPlaceholderId() > -1 && def.getPlaceholderTemplateId() > -1 ? " (placeholder)" : "");
				}
				c.setHidden(true);
			}
		}

		// Map each item the layout 1:1 with an item in the bank, using the item matches below in order of
		// preference. Unmatched items in the layout then get made placeholders, and unmatched items in the
		// bank get added to the layout.

		int[] layout = l.getLayout();

		ItemMatcher[] matchers = {
			this::matchExact,
			this::matchPlaceholder,
			this::matchesVariant,
			potionStorage::matches
		};

		Map<Integer, Integer> layoutToBank = new HashMap<>();

		for (ItemMatcher matcher : matchers)
		{
			// tagged item id
			for (int itemId : layout)
			{
				if (itemId == -1 || layoutToBank.containsKey(itemId))
				{
					continue;
				}

				int matchedId = matcher.match(bankItems, itemId); // bank item id
				if (matchedId != -1)
				{
					layoutToBank.put(itemId, matchedId);
					bankItems.remove(matchedId);

					// Items with objvars can have both the item and the placeholder in the bank at the same time.
					// Remove both from bankItems so that it won't get added later as an unlayouted tagged item.
					ItemComposition matchedItemDef = client.getItemDefinition(matchedId);
					boolean removedPlaceholder = bankItems.remove(matchedItemDef.getPlaceholderId());

					if (log.isDebugEnabled())
					{
						ItemComposition from = itemManager.getItemComposition(itemId);
						ItemComposition to = matchedItemDef;
						log.debug("Matched {}{} -> {}{} removed placeholder: {}",
							from.getName(), from.getPlaceholderId() > -1 && from.getPlaceholderTemplateId() > -1 ? " (placeholder)" : "",
							to.getName(), to.getPlaceholderId() > -1 && to.getPlaceholderTemplateId() > -1 ? " (placeholder)" : "",
							removedPlaceholder
						);
					}
				}
			}
		}

		// Items from the layout
		for (int pos = 0; pos < layout.length; ++pos)
		{
			int itemId = layout[pos]; // tagged item id
			if (itemId == -1)
			{
				continue;
			}

			Integer bankItemId = layoutToBank.get(itemId);
			if (bankItemId == null)
			{
				// Item is in the layout but doesn't match an item in the bank.
				if (log.isDebugEnabled())
				{
					ItemComposition def = itemManager.getItemComposition(itemId);
					log.debug("Layout contains {}{} with no matching item", def.getName(), def.getPlaceholderTemplateId() > -1 && def.getPlaceholderId() > -1 ? " (placeholder)" : "");
				}

				bankItemId = itemId;
			}

			Widget c = itemContainer.getChild(pos);
			drawItem(l, c, bank, bankItemId, pos);
		}

		int lastEmptySlot = -1;
		boolean modified = false;
		// Items from the bank but not in the layout.
		for (int itemId : bankItems)
		{
			do
			{
				++lastEmptySlot;
			}
			while (lastEmptySlot < layout.length && layout[lastEmptySlot] > -1);

			Widget c = itemContainer.getChild(lastEmptySlot);
			if (c == null || c.getOriginalHeight() != BANK_ITEM_HEIGHT) // check for tabs
			{
				break;
			}

			drawItem(l, c, bank, itemId, lastEmptySlot);

			if (log.isDebugEnabled())
			{
				ItemComposition def = itemManager.getItemComposition(itemId);
				log.debug("Bank contains {}{} but is not in the layout",
					def.getName(),
					def.getPlaceholderTemplateId() > -1 && def.getPlaceholderId() > -1 ? " (placeholder)" : "");
			}

			int layoutItemId = itemManager.canonicalize(itemId);
			l.addItem(layoutItemId);
			modified = true;
		}

		// Fill the remaining slots with -1 so that items can be dragged to them
		while (true)
		{
			do
			{
				++lastEmptySlot;
			}
			while (lastEmptySlot < layout.length && layout[lastEmptySlot] > -1);

			Widget c = itemContainer.getChild(lastEmptySlot);
			if (c == null || c.getOriginalHeight() != BANK_ITEM_HEIGHT)  // check for tabs
			{
				break;
			}

			drawItem(l, c, bank, -1, lastEmptySlot);
		}

		if (modified)
		{
			saveLayout(l);
		}
	}

	// mostly from ~bankmain_drawitem
	private void drawItem(Layout l, Widget c, ItemContainer bank, int item, int idx)
	{
		if (item > -1 && item != ItemID.BANK_FILLER)
		{
			ItemComposition def = client.getItemDefinition(item);

			int bankCount = bank.count(item);
			int qty = bankCount > 0 ? bankCount : potionStorage.count(item);

			boolean isPotStorage = bankCount <= 0 && qty > 0;

			c.setItemId(item);
			c.setItemQuantity(qty);
			c.setItemQuantityMode(ItemQuantityMode.STACKABLE);

			c.setName("<col=ff9040>" + def.getName() + "</col>");
			c.clearActions();

			// Jagex Placeholder
			if (def.getPlaceholderTemplateId() >= 0 && def.getPlaceholderId() >= 0)
			{
				c.setItemQuantity(qty);
				c.setOpacity(120);
				c.setAction(8 - 1, "Release");
				c.setAction(10 - 1, "Examine");
			}
			// Layout placeholder
			else if (qty == 0)
			{
				c.setOpacity(120);
				c.setItemQuantity(Integer.MAX_VALUE);
				c.setItemQuantityMode(ItemQuantityMode.NEVER);

				if ((plugin.getOptions() & BankTagsService.OPTION_ALLOW_MODIFICATIONS) != 0)
				{
					// TabInterface rewrites these to RUNELITE types and adds handlers
					c.setAction(7 - 1, DUPLICATE_ITEM);
					c.setAction(8 - 1, REMOVE_LAYOUT);
				}
			}
			else
			{
				int quantityType = client.getVarbitValue(VarbitID.BANK_QUANTITY_TYPE);
				int requestQty = client.getVarbitValue(VarbitID.BANK_REQUESTEDQUANTITY);

				String suffix;
				switch (quantityType)
				{
					default:
						suffix = "1";
						break;
					case 1:
						suffix = "5";
						break;
					case 2:
						suffix = "10";
						break;
					case 3:
						suffix = Integer.toString(Math.max(1, requestQty));
						break;
					case 4:
						suffix = "All";
						break;
				}

				// ~script669
				int opIdx = 0;
				c.setAction(opIdx++, "Withdraw-" + suffix);
				if (quantityType != 0)
				{
					c.setAction(opIdx++, "Withdraw-1");
				}
				if (quantityType != 1)
				{
					c.setAction(opIdx++, "Withdraw-5");
				}
				if (quantityType != 2)
				{
					c.setAction(opIdx++, "Withdraw-10");
				}
				if (quantityType != 3 && requestQty > 0)
				{
					c.setAction(opIdx++, "Withdraw-" + requestQty);
				}
				c.setAction(opIdx++, "Withdraw-X");
				if (quantityType != 4)
				{
					c.setAction(opIdx++, "Withdraw-All");
				}
				c.setAction(opIdx++, "Withdraw-All-but-1");
				if (!isPotStorage && client.getVarbitValue(VarbitID.BANK_BANKOPS_TOGGLE_ON) == 1 && def.getIntValue(ParamID.BANK_AUTOCHARGE) != -1)
				{
					c.setAction(opIdx++, "Configure-Charges");
				}
				if (!isPotStorage && client.getVarbitValue(VarbitID.BANK_LEAVEPLACEHOLDERS) == 0)
				{
					c.setAction(opIdx++, "Placeholder");
				}
				if (!isPotStorage)
				{
					c.setAction(9, "Examine");
				}
				c.setOpacity(0);
			}

			c.setOnDragListener(ScriptID.BANKMAIN_DRAGSCROLL, ScriptEvent.WIDGET_ID, ScriptEvent.WIDGET_INDEX, ScriptEvent.MOUSE_X, ScriptEvent.MOUSE_Y, InterfaceID.Bankmain.SCROLLBAR, 0);
			c.setOnDragCompleteListener((JavaScriptCallback) ev -> dragCompleteHandler(l, ev));
		}
		else
		{
			// pad size to not leave a gap between items
			c.setOriginalWidth(BANK_ITEM_WIDTH + BANK_ITEM_X_PADDING);
			c.setOriginalHeight(BANK_ITEM_HEIGHT + BANK_ITEM_Y_PADDING);
			c.clearActions();
			c.setItemId(-1);
			c.setItemQuantity(0);
			c.setOnDragListener((Object[]) null);
			c.setOnDragCompleteListener((Object[]) null);
		}

		int posX = (idx % BANK_ITEMS_PER_ROW) * (BANK_ITEM_WIDTH + BANK_ITEM_X_PADDING) + BANK_ITEM_START_X;
		int posY = (idx / BANK_ITEMS_PER_ROW) * (BANK_ITEM_HEIGHT + BANK_ITEM_Y_PADDING);

		c.setHidden(false);
		c.setOriginalX(posX);
		c.setOriginalY(posY);
		c.revalidate();
	}

	private void dragCompleteHandler(Layout l, ScriptEvent ev)
	{
		// always block the drag
		client.setDraggedOnWidget(null);

		Widget source = ev.getSource();
		Widget target = ev.getTarget();

		if (target == null)
		{
			return;
		}

		if (source.getId() != InterfaceID.Bankmain.ITEMS || target.getId() != InterfaceID.Bankmain.ITEMS)
		{
			return;
		}

		int sidx = source.getIndex();
		int tidx = target.getIndex();

		boolean swap = client.getVarbitValue(VarbitID.BANK_INSERTMODE) == 0;

		if (sidx >= l.size() || tidx >= l.size())
		{
			l.resize(Math.max(sidx, tidx) + 1);
		}

		if (swap)
		{
			log.debug("Swap {} <-> {}", sidx, tidx);
			l.swap(sidx, tidx);
		}
		else
		{
			log.debug("Insert {} -> {}", sidx, tidx);
			l.insert(sidx, tidx);
		}

		saveLayout(l);
		bankSearch.layoutBank();
	}

	@FunctionalInterface
	interface ItemMatcher
	{
		int match(Set<Integer> bank, int itemId);
	}

	private int matchExact(Set<Integer> bank, int itemId)
	{
		return bank.contains(itemId) ? itemId : -1;
	}

	private int matchPlaceholder(Set<Integer> bank, int itemId)
	{
		ItemComposition config = itemManager.getItemComposition(itemId);
		int placeholderId = config.getPlaceholderId();
		if (placeholderId != -1 && bank.contains(placeholderId))
		{
			return placeholderId;
		}
		return -1;
	}

	private int matchesVariant(Set<Integer> bank, int itemId)
	{
		int baseId = ItemVariationMapping.map(itemId);
		if (baseId != itemId)
		{
			for (int variationId : ItemVariationMapping.getVariations(baseId))
			{
				if (bank.contains(variationId))
				{
					return variationId;
				}

				ItemComposition config = itemManager.getItemComposition(variationId);
				int placeholderId = config.getPlaceholderId();
				if (placeholderId != -1 && bank.contains(placeholderId))
				{
					return placeholderId;
				}

			}
		}
		return -1;
	}

	@Value
	private static class PluginAutoLayout
	{
		Plugin plugin;
		String name;
		AutoLayout autoLayout;
	}

	/**
	 * Register an auto layout
	 *
	 * @param plugin the plugin registering the layout
	 * @param name   the layout name
	 * @param al     the layout
	 * @see #unregisterAutoLayout(String)
	 */
	public synchronized void registerAutoLayout(@Nonnull Plugin plugin, @NonNull String name, @NonNull AutoLayout al)
	{
		for (PluginAutoLayout pluginAutoLayout : autoLayouts)
		{
			if (pluginAutoLayout.getName().equals(name))
			{
				throw new IllegalArgumentException("Auto layout " + name + " is already registered");
			}
		}
		autoLayouts.add(new PluginAutoLayout(plugin, name, al));
	}

	/**
	 * Unregister an auto layout
	 *
	 * @param name the layout name
	 */
	public synchronized void unregisterAutoLayout(String name)
	{
		for (PluginAutoLayout pluginAutoLayout : autoLayouts)
		{
			if (pluginAutoLayout.getName().equals(name))
			{
				autoLayouts.remove(pluginAutoLayout);
				return;
			}
		}
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired event)
	{
		if (event.getScriptId() == ScriptID.BANKMAIN_FINISHBUILDING)
		{
			resetWidgets();

			// Since the script vm isn't reentrant, we can't call into POTIONSTORE_DOSES/POTIONSTORE_WITHDRAW_DOSES
			// from bankmain_finishbuilding for the layout. Instead, we record all of the potions on client tick,
			// which is after this is run, but before the var/inv transmit listeners run, so that we will have
			// them by the time the inv transmit listener runs.
			potionStorage.cachePotions = true;

			BankTag activeTag = plugin.getActiveBankTag();
			if (activeTag != null)
			{
				Layout layout = plugin.getActiveLayout();
				if (layout != null)
				{
					layout(layout);
					scrollLayout(layout);
				}
			}
		}
	}

	private void resetWidgets()
	{
		// We adjust the bank item container children's sizes in layouts,
		// however they are only initially set when the bank is opened,
		// so we have to reset them each time the bank is built.
		Widget w = client.getWidget(InterfaceID.Bankmain.ITEMS);

		for (Widget c : w.getChildren())
		{
			if (c.getOriginalHeight() < BANK_ITEM_HEIGHT)
			{
				break;
			}

			if (c.getOriginalWidth() != BANK_ITEM_WIDTH || c.getOriginalHeight() != BANK_ITEM_HEIGHT)
			{
				c.setOriginalWidth(BANK_ITEM_WIDTH);
				c.setOriginalHeight(BANK_ITEM_HEIGHT);
				c.revalidate();
			}
		}
	}

	void onMenuEntryAdded(MenuEntryAdded event, TabInterface tabInterface)
	{
		if (event.getActionParam1() == InterfaceID.Bankmain.ITEMS_CONTAINER && event.getOption().equals(TabInterface.DISABLE_LAYOUT))
		{
			int idx = -1;
			for (PluginAutoLayout autoLayout : autoLayouts)
			{
				client.createMenuEntry(--idx)
					.setOption("Auto layout: " + autoLayout.getName())
					.setTarget(event.getTarget())
					.setType(MenuAction.RUNELITE_HIGH_PRIORITY)
					.onClick(e ->
					{
						String tag = Text.standardize(e.getTarget());
						if (!tag.equals(tabInterface.getActiveTag()))
						{
							chatMessageManager.queue(QueuedMessage.builder()
								.type(ChatMessageType.CONSOLE)
								.runeLiteFormattedMessage("The tag tab must be open first before performing an auto layout.")
								.build());
							return;
						}

						Layout old = plugin.getActiveLayout();
						Layout new_ = autoLayout.autoLayout.generateLayout(old);
						plugin.openTag(tag, new_);

						chatboxPanelManager.openTextMenuInput("Tab laid out using the '" + autoLayout.getName() + "' layout.")
							.option("1. Keep", () ->
								saveLayout(new_))
							.option("2. Undo", () ->
								plugin.openTag(tag, old))
							.onClose(bankSearch::layoutBank)
							.build();
					});
			}
		}
	}

	void onMenuOptionClicked(MenuOptionClicked event)
	{
		// Update widget index of the menu so withdraws work in laid out tabs.
		if (event.getParam1() == InterfaceID.Bankmain.ITEMS && plugin.getActiveLayout() != null)
		{
			MenuEntry menu = event.getMenuEntry();
			Widget w = menu.getWidget();
			if (w != null && w.getItemId() > -1)
			{
				ItemContainer bank = client.getItemContainer(InventoryID.BANK);
				int idx = bank.find(w.getItemId());
				if (idx > -1 && menu.getParam0() != idx)
				{
					menu.setParam0(idx);
					return;
				}

				idx = potionStorage.getIdx(w.getItemId());
				if (idx > -1)
				{
					potionStorage.prepareWidgets();
					menu.setIdentifier(mungeBankToPotionStore(menu.getIdentifier()));
					menu.setParam1(InterfaceID.Bankmain.POTIONSTORE_ITEMS);
					menu.setParam0(idx);
				}
			}
		}
	}

	private int mungeBankToPotionStore(int ident)
	{
		// bank and potion store use different ops for different things,
		// so we convert here for consistency for both users & menu entry swapper
		int delta = ident;
		int exclude = client.getVarbitValue(VarbitID.BANK_QUANTITY_TYPE);
		if (delta == 1)
		{
			// Withdraw-<1|5|10|X|All>
			return 1;
		}
		if (exclude != 0)
		{
			// Withdraw-1
			if (--delta == 1)
			{
				return 2;
			}
		}
		if (exclude != 1)
		{
			// Withdraw-5
			if (--delta == 1)
			{
				return 3;
			}
		}
		if (exclude != 2)
		{
			// Withdraw-10
			if (--delta == 1)
			{
				return 4;
			}
		}
		if (exclude != 3 && client.getVarbitValue(VarbitID.BANK_REQUESTEDQUANTITY) > 0)
		{
			// Withdraw-<>
			if (--delta == 1)
			{
				return 5;
			}
		}
		// Withdraw-X
		if (--delta == 1)
		{
			return 6;
		}
		if (exclude != 4)
		{
			// Withdraw-All
			if (--delta == 1)
			{
				return 7;
			}
		}
		// Withdraw-All-but-1
		if (--delta == 1)
		{
			return 8;
		}

		return ident;
	}

	// adjust the bank scroll position so that some items are always in view
	private void scrollLayout(Layout l)
	{
		int pos = l.size() - 1;
		while (pos >= 0 && l.getItemAtPos(pos) == -1)
		{
			--pos;
		}

		int rows = (pos + BANK_ITEMS_PER_ROW - 1) / BANK_ITEMS_PER_ROW;
		int scrollY = rows * (BANK_ITEM_HEIGHT + BANK_ITEM_Y_PADDING);

		Widget w = client.getWidget(InterfaceID.Bankmain.ITEMS);
		if (scrollY < w.getScrollY())
		{
			int bankHeight = w.getHeight() / (BANK_ITEM_HEIGHT + BANK_ITEM_Y_PADDING);
			rows -= bankHeight;
			if (rows < 0)
			{
				rows = 0;
			}
			scrollY = rows * (BANK_ITEM_HEIGHT + BANK_ITEM_Y_PADDING);

			log.debug("Adjusting tab scroll to {} from {}", scrollY, w.getScrollY());
			w.setScrollY(scrollY);
			client.setVarcIntValue(VarClientID.BANK_SCROLLPOS, scrollY);
		}
	}

	private class DefaultLayout implements AutoLayout
	{
		@Override
		public Layout generateLayout(Layout previous)
		{
			Layout l = new Layout(previous);
			List<Integer> removed = new ArrayList<>();

			// Equipment
			ItemContainer e = client.getItemContainer(InventoryID.WORN);
			if (e != null)
			{
				int[] format = {
					-1, EquipmentInventorySlot.HEAD.getSlotIdx(), -1,
					EquipmentInventorySlot.CAPE.getSlotIdx(), EquipmentInventorySlot.AMULET.getSlotIdx(), EquipmentInventorySlot.AMMO.getSlotIdx(),
					EquipmentInventorySlot.WEAPON.getSlotIdx(), EquipmentInventorySlot.BODY.getSlotIdx(), EquipmentInventorySlot.SHIELD.getSlotIdx(),
					-1, EquipmentInventorySlot.LEGS.getSlotIdx(), -1,
					EquipmentInventorySlot.GLOVES.getSlotIdx(), EquipmentInventorySlot.BOOTS.getSlotIdx(), EquipmentInventorySlot.RING.getSlotIdx()
				};
				for (int pos = 0, base = 0; pos < format.length; ++pos)
				{
					if (pos > 0 && pos % 3 == 0)
					{
						base += 8;
					}

					int lpos = base + (pos % 3);
					int old = l.getItemAtPos(lpos);
					if (old != -1)
					{
						if (log.isDebugEnabled())
						{
							log.debug("Moving {}", itemManager.getItemComposition(old).getName());
						}
						removed.add(old);
					}

					Item item = e.getItem(format[pos]);
					if (item != null)
					{
						l.setItemAtPos(itemManager.canonicalize(item.getId()), lpos);
					}
					else
					{
						l.setItemAtPos(-1, lpos);
					}
				}
			}

			// Inventory
			ItemContainer i = client.getItemContainer(InventoryID.INV);
			if (i != null)
			{
				for (int pos = 0, base = 4; pos < i.size(); ++pos)
				{
					if (pos > 0 && pos % 4 == 0)
					{
						base += 8;
					}

					int lpos = base + (pos % 4);
					int old = l.getItemAtPos(lpos);
					if (old != -1)
					{
						removed.add(old);
					}

					Item item = i.getItem(pos);
					if (item != null)
					{
						l.setItemAtPos(itemManager.canonicalize(item.getId()), lpos);
					}
					else
					{
						l.setItemAtPos(-1, lpos);
					}
				}
			}

			// Rune pouch
			if (i != null && hasRunePouch(i))
			{
				final int[] RUNEPOUCH_RUNES = {
					VarbitID.RUNE_POUCH_TYPE_1, VarbitID.RUNE_POUCH_TYPE_2, VarbitID.RUNE_POUCH_TYPE_3, VarbitID.RUNE_POUCH_TYPE_4
				};
				final EnumComposition runepouchEnum = client.getEnum(EnumID.RUNEPOUCH_RUNE);

				int lpos = 40;
				for (int idx = 0; idx < RUNEPOUCH_RUNES.length; ++idx, ++lpos)
				{
					int runeId = client.getVarbitValue(RUNEPOUCH_RUNES[idx]);
					if (runeId > 0)
					{
						int itemId = runepouchEnum.getIntValue(runeId);

						int old = l.getItemAtPos(lpos);
						if (old != -1)
						{
							removed.add(old);
						}

						l.setItemAtPos(itemId, lpos);
					}
				}
			}

			// Middle column
			for (int j = 0; j < 5; ++j)
			{
				int idx = j * 8 + 3;

				int old = l.getItemAtPos(idx);
				if (old != -1)
				{
					removed.add(old);
					l.setItemAtPos(-1, idx);
				}
			}

			int pos = 56;
			for (int itemId : removed)
			{
				if (l.count(itemId) == 0)
				{
					if (log.isDebugEnabled())
					{
						log.debug("Adding {} at {}", itemManager.getItemComposition(itemId).getName(), pos);
					}
					l.addItemAfter(itemId, pos++);
				}
			}

			return l;
		}

		private boolean hasRunePouch(ItemContainer inv)
		{
			Collection<Integer> runePouchVariations = ItemVariationMapping.getVariations(ItemID.BH_RUNE_POUCH);
			Collection<Integer> divineRunePouchVariations = ItemVariationMapping.getVariations(ItemID.DIVINE_RUNE_POUCH);
			return runePouchVariations.stream().anyMatch(inv::contains) || divineRunePouchVariations.stream().anyMatch(inv::contains);
		}
	}
}
