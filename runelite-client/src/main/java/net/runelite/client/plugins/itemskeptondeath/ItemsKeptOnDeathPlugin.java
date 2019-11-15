/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemskeptondeath;

import com.google.common.annotations.VisibleForTesting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.FontID;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.api.ScriptID;
import net.runelite.api.SkullIcon;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemMapping;
import net.runelite.client.game.ItemReclaimCost;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.QuantityFormatter;

@PluginDescriptor(
	name = "Items Kept on Death",
	description = "Updates the Items Kept on Death interface to be more accurate",
	enabledByDefault = false
)
@Slf4j
@Singleton
public class ItemsKeptOnDeathPlugin extends Plugin
{
	private static final int DEEP_WILDY = 20;
	private static final Pattern WILDERNESS_LEVEL_PATTERN = Pattern.compile("^Level: (\\d+).*");

	@AllArgsConstructor
	@Getter
	@VisibleForTesting
	static class DeathItems
	{
		private final List<ItemStack> keptItems;
		private final List<ItemStack> lostItems;
		private final boolean hasAlwaysLost;
	}

	// Item Container helpers
	private static final int MAX_ROW_ITEMS = 8;
	private static final int ITEM_X_OFFSET = 5;
	private static final int ITEM_Y_OFFSET = 25;
	private static final int ITEM_X_STRIDE = 38;
	private static final int ITEM_Y_STRIDE = 38;
	private static final int ORIGINAL_LOST_HEIGHT = 209;
	private static final int ORIGINAL_LOST_Y = 107;

	// Information panel text helpers
	private static final String LINE_BREAK = "<br>";
	private static final int INFORMATION_CONTAINER_HEIGHT = 183;
	private static final int FONT_COLOR = 0xFF981F;

	// Button Images
	private static final int PROTECT_ITEM_SPRITE_ID = SpriteID.PRAYER_PROTECT_ITEM;
	private static final int SKULL_SPRITE_ID = SpriteID.PLAYER_KILLER_SKULL_523;
	private static final int SWORD_SPRITE_ID = SpriteID.MULTI_COMBAT_ZONE_CROSSED_SWORDS;
	private static final int SKULL_2_SPRITE_ID = SpriteID.FIGHT_PITS_WINNER_SKULL_RED;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private EventBus eventBus;

	private WidgetButton deepWildyButton;
	private WidgetButton lowWildyButton;

	@VisibleForTesting
	boolean isSkulled;
	@VisibleForTesting
	boolean protectingItem;
	@VisibleForTesting
	int wildyLevel;

	@Override
	protected void startUp() throws Exception
	{
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (event.getEventName().equals("itemsKeptOnDeath"))
		{
			// The script in charge of building the Items Kept on Death interface has finished running.
			// Make all necessary changes now.

			// Players inside Safe Areas (POH/Clan Wars) or playing DMM see the default interface
			if (isInSafeArea() || client.getWorldType().contains(WorldType.DEADMAN))
			{
				return;
			}

			syncSettings();
			createWidgetButtons();
			rebuildItemsKeptOnDeathInterface();

			final Widget keptText = client.getWidget(WidgetInfo.ITEMS_KEPT_ON_DEATH_TEXT);
			keptText.setText("Items you will keep on death:");

			final Widget lostText = client.getWidget(WidgetInfo.ITEMS_LOST_ON_DEATH_TEXT);
			lostText.setText("Items you will lose on death:");
		}
	}

	// Sync user settings
	private void syncSettings()
	{
		final SkullIcon s = client.getLocalPlayer().getSkullIcon();
		// Ultimate iron men deaths are treated like they are always skulled
		isSkulled = s == SkullIcon.SKULL || isUltimateIronman();
		protectingItem = client.getVar(Varbits.PRAYER_PROTECT_ITEM) == 1;
		syncWildernessLevel();
	}

	private void syncWildernessLevel()
	{
		if (client.getVar(Varbits.IN_WILDERNESS) != 1)
		{
			// if they are in a PvP world and not in a safe zone act like in lvl 1 wildy
			if (isInPvpWorld() && !isInPvPSafeZone())
			{
				wildyLevel = 1;
				return;
			}
			wildyLevel = -1;
			return;
		}

		final Widget wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL);
		if (wildernessLevelWidget == null)
		{
			wildyLevel = -1;
			return;
		}

		final String wildernessLevelText = wildernessLevelWidget.getText();
		final Matcher m = WILDERNESS_LEVEL_PATTERN.matcher(wildernessLevelText);
		if (!m.matches())
		{
			wildyLevel = -1;
			return;
		}

		wildyLevel = Integer.parseInt(m.group(1));
	}

	private boolean isInPvpWorld()
	{
		final EnumSet<WorldType> world = client.getWorldType();
		return world.contains(WorldType.PVP);
	}

	private boolean isProtectItemAllowed()
	{
		return !client.getWorldType().contains(WorldType.HIGH_RISK)
			&& !isUltimateIronman();
	}

	private boolean isInPvPSafeZone()
	{
		final Widget w = client.getWidget(WidgetInfo.PVP_WORLD_SAFE_ZONE);
		return w != null && !w.isHidden();
	}

	private boolean isInSafeArea()
	{
		final Widget w = client.getWidget(WidgetInfo.ITEMS_KEPT_SAFE_ZONE_CONTAINER);
		return w != null && !w.isHidden();
	}

	private boolean isUltimateIronman()
	{
		return client.getAccountType() == AccountType.ULTIMATE_IRONMAN;
	}

	private int getDefaultItemsKept()
	{
		final int count = isSkulled ? 0 : 3;
		return count + (protectingItem ? 1 : 0);
	}

	private void rebuildItemsKeptOnDeathInterface()
	{
		final Widget lost = client.getWidget(WidgetInfo.ITEMS_LOST_ON_DEATH_CONTAINER);
		final Widget kept = client.getWidget(WidgetInfo.ITEMS_KEPT_ON_DEATH_CONTAINER);
		if (lost == null || kept == null)
		{
			return;
		}

		lost.deleteAllChildren();
		kept.deleteAllChildren();

		// Grab all items on player
		final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		final Item[] inv = inventory == null ? new Item[0] : inventory.getItems();
		final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		final Item[] equip = equipment == null ? new Item[0] : equipment.getItems();

		final DeathItems deathItems = calculateKeptLostItems(inv, equip);

		final List<Widget> keptItems = deathItems.getKeptItems().stream()
			.map(item -> createItemWidget(kept, item, true)).collect(Collectors.toList());
		final List<Widget> lostItems = deathItems.getLostItems().stream()
			.map(item -> createItemWidget(lost, item, false)).collect(Collectors.toList());

		int rows = (keptItems.size() + MAX_ROW_ITEMS - 1) / MAX_ROW_ITEMS;
		// Show an empty row if there isn't anything
		if (rows > 0)
		{
			// ORIGINAL_LOST_Y/HEIGHT includes a row already
			rows--;
		}
		// Adjust items lost container position if new rows were added to kept items container
		lost.setOriginalY(ORIGINAL_LOST_Y + (rows * ITEM_Y_STRIDE));
		lost.setOriginalHeight(ORIGINAL_LOST_HEIGHT - (rows * ITEM_Y_STRIDE));
		positionWidgetItems(kept, keptItems);
		positionWidgetItems(lost, lostItems);

		updateKeptWidgetInfoText(deathItems.isHasAlwaysLost(), keptItems, lostItems);
	}

	/**
	 * Calculates which items will be kept/lost. first list is kept items, second is lost.
	 *
	 * @param inv   players inventory
	 * @param equip players equipement
	 * @return list of items kept followed by a list of items lost
	 */
	@VisibleForTesting
	DeathItems calculateKeptLostItems(final Item[] inv, final Item[] equip)
	{
		final List<Item> items = new ArrayList<>();
		Collections.addAll(items, inv);
		Collections.addAll(items, equip);

		// Sort by item price
		items.sort(Comparator.comparing(this::getDeathPrice).reversed());

		boolean hasClueBox = false;
		boolean hasAlwaysLost = false;
		int keepCount = getDefaultItemsKept();

		final List<ItemStack> keptItems = new ArrayList<>();
		final List<ItemStack> lostItems = new ArrayList<>();

		for (final Item i : items)
		{
			final int id = i.getId();
			int qty = i.getQuantity();
			if (id == -1)
			{
				continue;
			}

			// Bonds are always kept and do not count towards the limit.
			if (id == ItemID.OLD_SCHOOL_BOND || id == ItemID.OLD_SCHOOL_BOND_UNTRADEABLE)
			{
				keptItems.add(new ItemStack(id, qty));
				continue;
			}

			final AlwaysLostItem alwaysLostItem = AlwaysLostItem.getByItemID(id);
			if (alwaysLostItem != null && (!alwaysLostItem.isKeptOutsideOfWilderness() || wildyLevel > 0))
			{
				hasAlwaysLost = true;
				hasClueBox = hasClueBox || id == ItemID.CLUE_BOX;
				lostItems.add(new ItemStack(id, qty));
				continue;
			}

			if (keepCount > 0)
			{
				// Keep most valuable items regardless of trade-ability.
				if (i.getQuantity() > keepCount)
				{
					keptItems.add(new ItemStack(id, keepCount));
					qty -= keepCount;
					keepCount = 0;
					// Fall through to determine if the rest of the stack should drop
				}
				else
				{
					keptItems.add(new ItemStack(id, qty));
					keepCount -= qty;
					continue;
				}
			}

			// Items are kept if:
			// 1) is not tradeable
			// 2) is under the deep wilderness line
			// 3) is outside of the wilderness, or item has a broken form
			if (!Pets.isPet(id)
				&& !LostIfNotProtected.isLostIfNotProtected(id)
				&& !isTradeable(itemManager.getItemDefinition(id)) && wildyLevel <= DEEP_WILDY
				&& (wildyLevel <= 0 || ItemReclaimCost.of(id) != null))
			{
				keptItems.add(new ItemStack(id, qty));
			}
			else
			{
				// Otherwise, the item is lost
				lostItems.add(new ItemStack(id, qty));
			}
		}

		if (hasClueBox)
		{
			boolean alreadyProtectingClue = false;
			for (final ItemStack item : keptItems)
			{
				if (isClueBoxable(item.getId()))
				{
					alreadyProtectingClue = true;
					break;
				}
			}

			if (!alreadyProtectingClue)
			{
				int clueId = -1;
				// Clue box protects the last clue in your inventory so loop over the players inv
				for (final Item i : inv)
				{
					final int id = i.getId();
					if (id != -1 && isClueBoxable(id))
					{
						clueId = id;
					}
				}

				if (clueId != -1)
				{
					// Move the boxed item to the kept items container and remove it from the lost items container
					for (final ItemStack boxableItem : lostItems)
					{
						if (boxableItem.getId() == clueId)
						{
							if (boxableItem.getQty() > 1)
							{
								boxableItem.setQty(boxableItem.getQty() - 1);
								keptItems.add(new ItemStack(clueId, 1));
							}
							else
							{
								lostItems.remove(boxableItem);
								keptItems.add(boxableItem);
							}
							break;
						}
					}
				}
			}
		}

		return new DeathItems(keptItems, lostItems, hasAlwaysLost);
	}

	@VisibleForTesting
	boolean isClueBoxable(final int itemID)
	{
		final String name = itemManager.getItemDefinition(itemID).getName();
		return name.contains("Clue scroll (") || name.contains("Reward casket (");
	}

	/**
	 * Get the price of an item
	 *
	 * @param item
	 * @return
	 */
	@VisibleForTesting
	int getDeathPrice(Item item)
	{
		// 1) Check if the death price is dynamically calculated, if so return that value
		// 2) If death price is based off another item default to that price, otherwise apply normal ItemMapping GE price
		// 3) If still no price, default to store price
		// 4) Apply fixed price offset if applicable

		int itemId = item.getId();
		// Unnote/unplaceholder item
		int canonicalizedItemId = itemManager.canonicalize(itemId);
		int exchangePrice = 0;

		final DynamicPriceItem dynamicPrice = DynamicPriceItem.find(canonicalizedItemId);
		if (dynamicPrice != null)
		{
			final int basePrice = itemManager.getItemPrice(dynamicPrice.getChargedId(), true);
			return dynamicPrice.calculateDeathPrice(basePrice);
		}

		// Some items have artificially offset death prices - such as ring imbues
		// which are +2k over the non imbues. Check if the item has a fixed price offset
		final FixedPriceItem fixedPrice = FixedPriceItem.find(canonicalizedItemId);
		if (fixedPrice != null && fixedPrice.getBaseId() != -1)
		{
			// Grab base item price
			exchangePrice = itemManager.getItemPrice(fixedPrice.getBaseId(), true);
		}

		// Jagex uses the repair price when determining which items are kept on death.
		final ItemReclaimCost repairPrice = ItemReclaimCost.of(canonicalizedItemId);
		if (repairPrice != null)
		{
			exchangePrice = repairPrice.getValue();
		}

		if (exchangePrice == 0)
		{
			// Account for items whose death value comes from their tradeable variant (barrows) or components (ornate kits)
			// ItemMapping.map will always return a collection with at least the passed ID
			for (final int mappedID : ItemMapping.map(canonicalizedItemId))
			{
				exchangePrice += itemManager.getItemPrice(mappedID, true);
			}

			// If for some reason it still has no price default to the items store price
			if (exchangePrice == 0)
			{
				final ItemDefinition c1 = itemManager.getItemDefinition(canonicalizedItemId);
				exchangePrice = c1.getPrice();
			}
		}

		// Apply fixed price offset
		exchangePrice += fixedPrice == null ? 0 : fixedPrice.getOffset();

		return exchangePrice;
	}

	/**
	 * Position a list of widget items in the parent container
	 */
	private static void positionWidgetItems(final Widget parent, final List<Widget> widgets)
	{
		int startingIndex = 0;
		for (final Widget w : widgets)
		{
			final int originalX = ITEM_X_OFFSET + ((startingIndex % MAX_ROW_ITEMS) * ITEM_X_STRIDE);
			final int originalY = ITEM_Y_OFFSET + ((startingIndex / MAX_ROW_ITEMS) * ITEM_Y_STRIDE);

			w.setOriginalX(originalX);
			w.setOriginalY(originalY);
			w.revalidate();

			++startingIndex;
		}

		parent.revalidate();
	}

	/**
	 * Creates the text to be displayed in the right side of the interface based on current selections
	 */
	private String getInfoText(final boolean hasAlwaysLost)
	{
		final StringBuilder sb = new StringBuilder();
		if (isUltimateIronman())
		{
			sb.append("You are an <col=FFFFFF>UIM<col=FF981F> which means <col=FFFFFF>0<col=FF981F> items are protected by default");
		}
		else
		{
			sb.append("<col=FFFFFF>3<col=FF981F> items protected by default");

			if (isSkulled)
			{
				sb.append(LINE_BREAK)
					.append("<col=ff3333>PK skull<col=ff981f> -3");
			}

			if (protectingItem)
			{
				sb.append(LINE_BREAK)
					.append("<col=ff3333>Protect Item prayer<col=ff981f> +1");
			}

			sb.append(LINE_BREAK)
				.append(String.format("Actually protecting <col=FFFFFF>%s<col=FF981F> items", getDefaultItemsKept()));
		}


		if (wildyLevel < 1)
		{
			sb.append(LINE_BREAK)
				.append(LINE_BREAK)
				.append("You will have 1 hour to retrieve your lost items.");
		}

		if (hasAlwaysLost)
		{
			sb.append(LINE_BREAK)
				.append(LINE_BREAK)
				.append("Items with a <col=ffffff>white outline<col=ff981f> will always be lost.");
		}

		sb.append(LINE_BREAK)
			.append(LINE_BREAK)
			.append("Untradeable items are kept on death in non-pvp scenarios.");

		return sb.toString();
	}

	/**
	 * Updates the information panel based on the item containers
	 */
	private void updateKeptWidgetInfoText(final boolean hasAlwaysLost, final List<Widget> keptItems, final List<Widget> lostItems)
	{
		// Add Information text widget
		final Widget textWidget = findOrCreateInfoText();
		textWidget.setText(getInfoText(hasAlwaysLost));
		textWidget.revalidate();

		// Update Items lost total value
		long theyGet = 0;
		long youLose = 0;

		for (final Widget w : lostItems)
		{
			final int cid = itemManager.canonicalize(w.getItemId());
			final TrueItemValue trueItemValue = TrueItemValue.map(cid);
			final Collection<Integer> mapping = ItemMapping.map(cid);
			final int breakValue = itemManager.getRepairValue(cid);

			if (breakValue != 0)
			{
				youLose -= breakValue;
				theyGet += breakValue;
			}

			if (trueItemValue != null)
			{
				int truePrice = 0;

				for (int id : trueItemValue.getDeconstructedItem())
				{
					if (mapping.contains(id))
					{
						continue;
					}
					truePrice += itemManager.getItemPrice(id);
				}

				youLose += truePrice;
			}

			int price = itemManager.getItemPrice(cid);

			if (price == 0 && breakValue == 0)
			{
				// Default to alch price
				price = (int) (itemManager.getItemDefinition(cid).getPrice() * Constants.HIGH_ALCHEMY_MULTIPLIER);
			}

			theyGet += (long) price * w.getItemQuantity();
		}
		final Widget lostValue = client.getWidget(WidgetInfo.ITEMS_LOST_VALUE);
		lostValue.setText("They get: " + QuantityFormatter.quantityToStackSize(theyGet) +
			"<br>You lose: " + ColorUtil.prependColorTag("(" + QuantityFormatter.quantityToStackSize(theyGet + youLose) + ")", Color.red));

		// Update Max items kept
		final Widget max = client.getWidget(WidgetInfo.ITEMS_KEPT_MAX);
		final int keptQty = keptItems.stream().mapToInt(Widget::getItemQuantity).sum();
		max.setText(String.format("<col=ffcc33>Max items kept on death:<br><br><col=ffcc33>~ %d ~", keptQty));
	}

	/**
	 * Check if an item is tradeable to another player
	 *
	 * @param c The item
	 * @return
	 */
	private static boolean isTradeable(final ItemDefinition c)
	{
		// ItemDefinition:: isTradeable checks if they are traded on the grand exchange, some items are trade-able but not via GE
		if (c.getNote() != -1
			|| c.getLinkedNoteId() != -1
			|| c.isTradeable())
		{
			return true;
		}

		final int id = c.getId();
		switch (id)
		{
			case ItemID.COINS_995:
			case ItemID.PLATINUM_TOKEN:
				return true;
			default:
				return false;
		}
	}

	private Widget findOrCreateInfoText()
	{
		// The text was on the ITEMS_KEPT_INFORMATION_CONTAINER widget - but now that it is a layer,
		// we need to create a child widget to hold the text
		final Widget parent = client.getWidget(WidgetInfo.ITEMS_KEPT_INFORMATION_CONTAINER);

		// Use the text TEXT widget if it already exists. It should be the last child of the parent
		final Widget[] children = parent.getChildren();
		if (children != null && children.length > 0)
		{
			final Widget w = parent.getChild(children.length - 1);
			if (w != null && w.getType() == WidgetType.TEXT)
			{
				log.debug("Reusing old text widget");
				return w;
			}
		}

		log.debug("Creating new text widget");

		final Widget w = parent.createChild(-1, WidgetType.TEXT);
		// Position under buttons taking remaining space
		w.setOriginalWidth(parent.getOriginalWidth());
		w.setOriginalHeight(INFORMATION_CONTAINER_HEIGHT - parent.getOriginalHeight());
		w.setOriginalY(parent.getOriginalHeight());

		w.setFontId(FontID.PLAIN_11);
		w.setTextShadowed(true);
		w.setTextColor(FONT_COLOR);

		// Need to adjust parent height so text is visible
		parent.setOriginalHeight(INFORMATION_CONTAINER_HEIGHT);
		parent.revalidate();

		return w;
	}

	private void createWidgetButtons()
	{
		final Widget parent = client.getWidget(WidgetInfo.ITEMS_KEPT_INFORMATION_CONTAINER);
		// Change the information container from a text widget to a layer
		parent.setType(WidgetType.LAYER);
		parent.deleteAllChildren();

		// Ultimate Iron men are always skulled and can't use the protect item prayer
		WidgetButton protectItemButton = isProtectItemAllowed()
			? new WidgetButton(parent, "Protect Item Prayer", PROTECT_ITEM_SPRITE_ID, protectingItem, selected ->
		{
			protectingItem = selected;
			rebuildItemsKeptOnDeathInterface();
		}) : null;

		WidgetButton skulledButton = !isUltimateIronman()
			? new WidgetButton(parent, "Skulled", SKULL_SPRITE_ID, isSkulled, selected ->
		{
			isSkulled = selected;
			rebuildItemsKeptOnDeathInterface();
		}) : null;

		lowWildyButton = new WidgetButton(parent, "Low Wildy (1-20)", SWORD_SPRITE_ID, wildyLevel > 0 && wildyLevel <= DEEP_WILDY, selected ->
		{
			if (!selected)
			{
				syncWildernessLevel();
			}
			else
			{
				wildyLevel = 1;
				deepWildyButton.setSelected(false);
			}

			rebuildItemsKeptOnDeathInterface();
		});

		deepWildyButton = new WidgetButton(parent, "Deep Wildy (21+)", SKULL_2_SPRITE_ID, wildyLevel > DEEP_WILDY, selected ->
		{
			if (!selected)
			{
				syncWildernessLevel();
			}
			else
			{
				wildyLevel = DEEP_WILDY + 1;
				lowWildyButton.setSelected(false);
			}

			rebuildItemsKeptOnDeathInterface();
		});

		parent.revalidate();
		WidgetButton.layoutButtonsToContainer(parent, protectItemButton, skulledButton, lowWildyButton, deepWildyButton);
	}

	/**
	 * Creates an Item Widget for use inside the Kept on Death Interface
	 *
	 * @param parent Widget to add element too as a child
	 * @param item   the TempItem representing the item
	 * @param kept   is the item being shown in the kept items container
	 * @return the Widget that was added to the `parent`
	 */
	private Widget createItemWidget(final Widget parent, final ItemStack item, boolean kept)
	{
		final int id = item.getId();
		final int qty = item.getQty();
		final ItemDefinition c = itemManager.getItemDefinition(id);

		final Widget itemWidget = parent.createChild(-1, WidgetType.GRAPHIC);
		itemWidget.setOriginalWidth(Constants.ITEM_SPRITE_WIDTH);
		itemWidget.setOriginalHeight(Constants.ITEM_SPRITE_HEIGHT);
		itemWidget.setItemId(id);
		itemWidget.setItemQuantity(qty);
		itemWidget.setAction(1, String.format("Item: <col=ff981f>%s", c.getName()));
		itemWidget.setOnOpListener(ScriptID.DEATH_KEEP_ITEM_EXAMINE, kept ? 1 : 0, qty, c.getName());
		itemWidget.setHasListener(true);

		final AlwaysLostItem alwaysLostItem = AlwaysLostItem.getByItemID(id);
		final boolean whiteBorder = alwaysLostItem != null && (!alwaysLostItem.isKeptOutsideOfWilderness() || wildyLevel > 0);
		itemWidget.setBorderType(whiteBorder ? 2 : 1);

		return itemWidget;
	}
}