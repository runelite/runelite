/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2024, PhraZier <https://github.com/phrazier>
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
package net.runelite.client.plugins.bank;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuEntry;
import net.runelite.api.ScriptID;
import net.runelite.api.annotations.Component;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuShouldLeftClick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.QuantityFormatter;

@PluginDescriptor(
	name = "Bank",
	description = "Modifications to the banking interface",
	tags = {"grand", "exchange", "high", "alchemy", "prices", "deposit", "pin"}
)
@Slf4j
public class BankPlugin extends Plugin
{
	private static final String DEPOSIT_WORN = "Deposit worn items";
	private static final String DEPOSIT_INVENTORY = "Deposit inventory";
	private static final String EMPTY_CONTAINERS = "Empty containers";
	private static final String TOGGLE_PLACEHOLDERS = "Always set placeholders";
	private static final String SEED_VAULT_TITLE = "Seed Vault";
	private static final int POTION_STORE_TAB = 15;

	private static final String NUMBER_REGEX = "[0-9]+(\\.[0-9]+)?[kmb]?";
	private static final Pattern VALUE_SEARCH_PATTERN = Pattern.compile("^(?<mode>qty|ge|ha|alch)?" +
		" *(?<individual>i|iv|individual|per)?" +
		" *(((?<op>[<>=]|>=|<=) *(?<num>" + NUMBER_REGEX + "))|" +
		"((?<num1>" + NUMBER_REGEX + ") *- *(?<num2>" + NUMBER_REGEX + ")))$", Pattern.CASE_INSENSITIVE);

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ItemManager itemManager;

	@Inject
	private BankConfig config;

	@Inject
	private BankSearch bankSearch;

	@Inject
	private KeyManager keyManager;

	private boolean forceRightClickFlag;
	private Multiset<Integer> itemQuantities; // bank item quantities for bank value search
	private String searchString;
	private ContainerPrices prices;

	private final KeyListener searchHotkeyListener = new KeyListener()
	{
		@Override
		public void keyTyped(KeyEvent e)
		{
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			Keybind keybind = config.searchKeybind();
			if (keybind.matches(e))
			{
				Widget bankContainer = client.getWidget(InterfaceID.Bankmain.ITEMS);
				if (bankContainer != null && !bankContainer.isSelfHidden())
				{
					log.debug("Search hotkey pressed");
					bankSearch.initSearch();
					e.consume();
				}

				Widget groupStorageSearchButton = client.getWidget(InterfaceID.SharedBank.SEARCH);
				if (groupStorageSearchButton != null)
				{
					log.debug("Search hotkey pressed");
					clientThread.invoke(() ->
					{
						Widget searchButton = client.getWidget(InterfaceID.SharedBank.SEARCH);
						if (searchButton == null || searchButton.isHidden())
						{
							return;
						}

						Object[] searchToggleArgs = searchButton.getOnOpListener();
						if (searchToggleArgs == null)
						{
							return;
						}

						client.createScriptEvent(searchToggleArgs) // [clientscript,shared_bank_search_toggle]
							.setOp(1)
							.run();
					});
					e.consume();
				}

				Widget seedVaultSearchButton = client.getWidget(InterfaceID.SeedVault.SEARCH);
				if (seedVaultSearchButton != null)
				{
					log.debug("Search hotkey pressed");
					clientThread.invoke(() ->
					{
						Widget searchButton = client.getWidget(InterfaceID.SeedVault.SEARCH);
						if (searchButton == null || searchButton.isHidden())
						{
							return;
						}
						client.runScript(searchButton.getOnOpListener());
					});
					e.consume();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
		}
	};

	@Provides
	BankConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankConfig.class);
	}

	@Override
	protected void startUp()
	{
		keyManager.registerKeyListener(searchHotkeyListener);
	}

	@Override
	protected void shutDown()
	{
		keyManager.unregisterKeyListener(searchHotkeyListener);
		clientThread.invokeLater(() -> bankSearch.reset(false));
		forceRightClickFlag = false;
		itemQuantities = null;
		searchString = null;
	}

	@Subscribe
	public void onMenuShouldLeftClick(MenuShouldLeftClick event)
	{
		if (!forceRightClickFlag)
		{
			return;
		}

		forceRightClickFlag = false;
		MenuEntry[] menuEntries = client.getMenuEntries();
		for (MenuEntry entry : menuEntries)
		{

			if ((entry.getOption().equals(DEPOSIT_WORN) && config.rightClickBankEquip())
				|| (entry.getOption().equals(DEPOSIT_INVENTORY) && config.rightClickBankInventory())
				|| (entry.getOption().equals(EMPTY_CONTAINERS) && config.rightClickBankLoot())
				|| (entry.getTarget().contains(TOGGLE_PLACEHOLDERS) && config.rightClickPlaceholders())
			)
			{
				event.setForceRightClick(true);
				return;
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if ((event.getOption().equals(DEPOSIT_WORN) && config.rightClickBankEquip())
			|| (event.getOption().equals(DEPOSIT_INVENTORY) && config.rightClickBankInventory())
			|| (event.getOption().equals(EMPTY_CONTAINERS) && config.rightClickBankLoot())
			|| (event.getTarget().contains(TOGGLE_PLACEHOLDERS) && config.rightClickPlaceholders()))
		{
			forceRightClickFlag = true;
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		int[] intStack = client.getIntStack();
		Object[] objectStack = client.getObjectStack();
		int intStackSize = client.getIntStackSize();
		int objectStackSize = client.getObjectStackSize();

		switch (event.getEventName())
		{
			case "bankSearchFilter":
				int itemId = intStack[intStackSize - 1];
				String search = (String) objectStack[objectStackSize - 1];

				if (valueSearch(itemId, search))
				{
					// return true
					intStack[intStackSize - 2] = 1;
				}

				break;
			case "bankpinButtonSetup":
			{
				if (!config.bankPinKeyboard())
				{
					return;
				}

				final int compId = intStack[intStackSize - 2];
				final int buttonId = intStack[intStackSize - 1];
				Widget button = client.getWidget(compId);
				Widget buttonRect = button.getChild(0);

				final Object[] onOpListener = buttonRect.getOnOpListener();
				buttonRect.setOnKeyListener((JavaScriptCallback) e ->
				{
					int typedChar = e.getTypedKeyChar() - '0';
					if (typedChar != buttonId)
					{
						return;
					}

					log.debug("Bank pin keypress");

					client.runScript(onOpListener);
					// Block the key press this tick in keypress_permit so it doesn't enter the chatbox
					client.setVarcIntValue(VarClientID.KEYBOARD_TIMEOUT, client.getGameCycle() + 1);
				});
				break;
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == InterfaceID.SEED_VAULT && config.seedVaultValue())
		{
			clientThread.invokeLater(this::updateSeedVaultTotal);
		}
	}

	@Subscribe(priority = 1) // run prior to bank tags
	public void onScriptPreFired(ScriptPreFired event)
	{
		if (event.getScriptId() == ScriptID.BANKMAIN_FINISHBUILDING)
		{
			// Potion storage is hacked into ~bankmain_build and works by building a fake bank tab 15
			// Avoid computing prices when building potion storage or else this will overwrite the previously
			// computed prices from POTIONSTORE_BUILD
			if (client.getVarbitValue(VarbitID.BANK_CURRENTTAB) != POTION_STORE_TAB)
			{
				// This is here so that it computes the tab price before bank tags layouts the tab with duplicates or placeholders.
				prices = getWidgetContainerPrices(InterfaceID.Bankmain.ITEMS, InventoryID.BANK);
			}
		}
		else if (event.getScriptId() == ScriptID.POPUP_OVERLAY_YESNO_INIT)
		{
			var text = event.getScriptEvent().getArguments()[1];
			// this is also re-used by the clear all bank fillers popup
			if (((String) text).startsWith("Want more bank space?") && config.blockJagexAccountAd())
			{
				var wn = client.getComponentTable()
					.get(InterfaceID.Bankmain.POPUP);
				clientThread.invokeAtTickEnd(() -> client.closeInterface(wn, true));
			}
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		int scriptId = event.getScriptId();
		if (scriptId == ScriptID.POTIONSTORE_BUILD || scriptId == ScriptID.POTIONSTORE_DOSE_CHANGE)
		{
			// This is called when the potion store is built and any time any of the potions change
			prices = getPotionStoragePrice();
			Widget bankTitle = client.getWidget(InterfaceID.Bankmain.TITLE);
			// The title is not overwritten by this script (but instead bankmain_build, which is only called at setup)
			// so we can't append the price, and instead reset the whole title.
			bankTitle.setText("Potion store " + createValueText(prices.getGePrice(), prices.getHighAlchPrice()));
		}
		else if (scriptId == ScriptID.BANKMAIN_FINISHBUILDING)
		{
			if (prices != null)
			{
				Widget bankTitle = client.getWidget(InterfaceID.Bankmain.TITLE);
				bankTitle.setText(bankTitle.getText() + createValueText(prices.getGePrice(), prices.getHighAlchPrice()));
			}
		}
		else if (scriptId == ScriptID.BANKMAIN_SEARCH_REFRESH)
		{
			// vanilla only lays out the bank every 40 client ticks, so if the search input has changed,
			// and the bank wasn't laid out this tick, lay it out early
			final String inputText = client.getVarcStrValue(VarClientID.MESLAYERINPUT);
			if (searchString != inputText && client.getGameCycle() % 40 != 0)
			{
				clientThread.invokeLater(bankSearch::layoutBank);
				searchString = inputText;
			}
		}
		else if (scriptId == ScriptID.GROUP_IRONMAN_STORAGE_BUILD)
		{
			ContainerPrices price = getWidgetContainerPrices(InterfaceID.SharedBank.ITEMS, InventoryID.INV_GROUP_TEMP);
			if (price == null)
			{
				return;
			}

			Widget bankTitle = client.getWidget(InterfaceID.SharedBank.FRAME).getChild(1);
			bankTitle.setText(bankTitle.getText() + createValueText(price.getGePrice(), price.getHighAlchPrice()));
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		int containerId = event.getContainerId();

		if (containerId == InventoryID.BANK)
		{
			itemQuantities = null;
		}
		else if (containerId == InventoryID.SEED_VAULT && config.seedVaultValue())
		{
			updateSeedVaultTotal();
		}
	}

	private String createValueText(long gePrice, long haPrice)
	{
		StringBuilder stringBuilder = new StringBuilder();
		if (config.showGE() && gePrice != 0)
		{
			stringBuilder.append(" (");

			if (config.showHA())
			{
				stringBuilder.append("GE: ");
			}

			if (config.showExact())
			{
				stringBuilder.append(QuantityFormatter.formatNumber(gePrice));
			}
			else
			{
				stringBuilder.append(QuantityFormatter.quantityToStackSize(gePrice));
			}
			stringBuilder.append(')');
		}

		if (config.showHA() && haPrice != 0)
		{
			stringBuilder.append(" (");

			if (config.showGE())
			{
				stringBuilder.append("HA: ");
			}

			if (config.showExact())
			{
				stringBuilder.append(QuantityFormatter.formatNumber(haPrice));
			}
			else
			{
				stringBuilder.append(QuantityFormatter.quantityToStackSize(haPrice));
			}
			stringBuilder.append(')');
		}

		return stringBuilder.toString();
	}

	private void updateSeedVaultTotal()
	{
		final Widget titleContainer = client.getWidget(InterfaceID.SeedVault.FRAME);
		if (titleContainer == null)
		{
			return;
		}

		final Widget title = titleContainer.getChild(1);
		if (title == null)
		{
			return;
		}

		final ContainerPrices prices = calculate(getSeedVaultItems());
		if (prices == null)
		{
			return;
		}

		final String titleText = createValueText(prices.getGePrice(), prices.getHighAlchPrice());
		title.setText(SEED_VAULT_TITLE + titleText);
	}

	private Item[] getSeedVaultItems()
	{
		final ItemContainer itemContainer = client.getItemContainer(InventoryID.SEED_VAULT);
		if (itemContainer == null)
		{
			return null;
		}

		return itemContainer.getItems();
	}


	@VisibleForTesting
	boolean valueSearch(final int itemId, final String str)
	{
		final Matcher matcher = VALUE_SEARCH_PATTERN.matcher(str);
		if (!matcher.matches())
		{
			return false;
		}

		// Count bank items and remember it for determining item quantity
		if (itemQuantities == null)
		{
			itemQuantities = getBankItemSet();
		}

		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		final int qty = matcher.group("individual") != null ? 1 : itemQuantities.count(itemId);
		final long gePrice = (long) itemManager.getItemPrice(itemId) * qty;
		final long haPrice = (long) itemComposition.getHaPrice() * qty;
		final boolean isPlaceholder = itemComposition.getPlaceholderTemplateId() != -1;

		long value = Math.max(gePrice, haPrice);

		final String mode = matcher.group("mode");
		if (mode != null)
		{
			switch (mode.toLowerCase())
			{
				case "qty":
					value = isPlaceholder ? 0 : qty;
					break;
				case "ge":
					value = gePrice;
					break;
				case "ha":
				case "alch":
					value = haPrice;
					break;
			}
		}

		final String op = matcher.group("op");
		if (op != null)
		{
			long compare;
			try
			{
				compare = QuantityFormatter.parseQuantity(matcher.group("num"));
			}
			catch (ParseException e)
			{
				return false;
			}

			switch (op)
			{
				case ">":
					return value > compare;
				case "<":
					return value < compare;
				case "=":
					return value == compare;
				case ">=":
					return value >= compare;
				case "<=":
					return value <= compare;
			}
		}

		final String num1 = matcher.group("num1");
		final String num2 = matcher.group("num2");
		if (num1 != null && num2 != null)
		{
			long compare1, compare2;
			try
			{
				compare1 = QuantityFormatter.parseQuantity(num1);
				compare2 = QuantityFormatter.parseQuantity(num2);
			}
			catch (ParseException e)
			{
				return false;
			}

			return compare1 <= value && compare2 >= value;
		}

		return false;
	}

	private Multiset<Integer> getBankItemSet()
	{
		ItemContainer itemContainer = client.getItemContainer(InventoryID.BANK);
		if (itemContainer == null)
		{
			return HashMultiset.create();
		}

		Multiset<Integer> set = HashMultiset.create();
		for (Item item : itemContainer.getItems())
		{
			if (item.getId() != ItemID.BANK_FILLER)
			{
				set.add(item.getId(), item.getQuantity());
			}
		}
		return set;
	}

	@Nullable
	ContainerPrices calculate(@Nullable Item[] items)
	{
		if (items == null)
		{
			return null;
		}

		long ge = 0;
		long alch = 0;

		for (final Item item : items)
		{
			final int qty = item.getQuantity();
			final int id = item.getId();

			if (id <= 0 || qty == 0)
			{
				continue;
			}

			alch += (long) getHaPrice(id) * qty;
			ge += (long) itemManager.getItemPrice(id) * qty;
		}

		return new ContainerPrices(ge, alch);
	}

	private int getHaPrice(int itemId)
	{
		switch (itemId)
		{
			case ItemID.COINS:
				return 1;
			case ItemID.PLATINUM:
				return 1000;
			default:
				return itemManager.getItemComposition(itemId).getHaPrice();
		}
	}

	private ContainerPrices getWidgetContainerPrices(@Component int componentId, int inventoryID)
	{
		final Widget widget = client.getWidget(componentId);
		final ItemContainer itemContainer = client.getItemContainer(inventoryID);
		final Widget[] children = widget.getChildren();
		ContainerPrices prices = null;

		if (itemContainer != null && children != null)
		{
			long geTotal = 0, haTotal = 0;
			log.debug("Computing bank price of {} items", itemContainer.size());

			// In the bank, the first components are the bank items, followed by tabs etc. There are always enough
			// components for the max bank regardless of the bank size, but we only need to check up to the bank size.
			for (int i = 0; i < itemContainer.size(); ++i)
			{
				Widget child = children[i];
				if (child != null && !child.isSelfHidden() && child.getItemId() > -1)
				{
					final int alchPrice = getHaPrice(child.getItemId());
					geTotal += (long) itemManager.getItemPrice(child.getItemId()) * child.getItemQuantity();
					haTotal += (long) alchPrice * child.getItemQuantity();
				}
			}

			prices = new ContainerPrices(geTotal, haTotal);
		}

		return prices;
	}

	private ContainerPrices getPotionStoragePrice()
	{
		var potionMap = new HashMap<Integer, EnumComposition>();

		var potionStorePotions = client.getEnum(EnumID.POTIONSTORE_POTIONS);
		for (int potionEnumId : potionStorePotions.getIntVals())
		{
			var potionEnum = client.getEnum(potionEnumId);

			for (int doses = 1; doses <= 4; ++doses)
			{
				int itemId = potionEnum.getIntValue(doses);
				if (itemId > -1)
				{
					potionMap.put(itemId, potionEnum);
				}
			}
		}

		potionStorePotions = client.getEnum(EnumID.POTIONSTORE_UNFINISHED_POTIONS);
		for (int potionEnumId : potionStorePotions.getIntVals())
		{
			var potionEnum = client.getEnum(potionEnumId);
			int itemId = potionEnum.getIntValue(1);
			potionMap.put(itemId, potionEnum);
		}

		Widget w = client.getWidget(InterfaceID.Bankmain.POTIONSTORE_ITEMS);
		Widget[] children = w.getDynamicChildren();
		long geTotal = 0, haTotal = 0;

		for (int i = 0; i + 4 < children.length; i += 5)
		{
			Widget wItem = children[i + 1];
			Widget wDoses = children[i + 3];

			if (wItem.getItemId() == -1 || Strings.isNullOrEmpty(wDoses.getText()))
			{
				continue;
			}

			int itemId = wItem.getItemId();
			// Doses: 1234 or Quantity: 1234
			int doses = Integer.parseInt(wDoses.getText().split(": ")[1].replace(",", ""));
			var potionEnum = potionMap.get(itemId);
			if (potionEnum == null)
			{
				continue;
			}

			int withdrawDoses;
			for (withdrawDoses = 1; withdrawDoses < 4; ++withdrawDoses)
			{
				if (potionEnum.getIntValue(withdrawDoses) == itemId)
				{
					break;
				}
			}

			int qty = doses / withdrawDoses;

			log.debug("Potion store has {} of {} (doses={}, withdrawDoses={})", qty, itemId, doses, withdrawDoses);

			geTotal += (long) itemManager.getItemPrice(itemId) * qty;
			haTotal += (long) getHaPrice(itemId) * qty;
		}

		return new ContainerPrices(geTotal, haTotal);
	}
}
