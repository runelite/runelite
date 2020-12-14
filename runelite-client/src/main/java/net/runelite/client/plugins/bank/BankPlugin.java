/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
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
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientStr;
import net.runelite.api.Skill;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuShouldLeftClick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
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
	tags = {"grand", "exchange", "high", "alchemy", "prices", "deposit"}
)
@Slf4j
public class BankPlugin extends Plugin
{
	private static final String DEPOSIT_WORN = "Deposit worn items";
	private static final String DEPOSIT_INVENTORY = "Deposit inventory";
	private static final String DEPOSIT_LOOT = "Deposit loot";
	private static final String SEED_VAULT_TITLE = "Seed Vault";

	private static final String NUMBER_REGEX = "[0-9]+(\\.[0-9]+)?[kmb]?";
	private static final Pattern VALUE_SEARCH_PATTERN = Pattern.compile("^(?<mode>ge|ha|alch)?" +
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
				Widget bankContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
				if (bankContainer == null || bankContainer.isSelfHidden())
				{
					return;
				}

				log.debug("Search hotkey pressed");

				bankSearch.initSearch();
				e.consume();
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
				|| (entry.getOption().equals(DEPOSIT_LOOT) && config.rightClickBankLoot()))
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
			|| (event.getOption().equals(DEPOSIT_LOOT) && config.rightClickBankLoot()))
		{
			forceRightClickFlag = true;
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		int[] intStack = client.getIntStack();
		String[] stringStack = client.getStringStack();
		int intStackSize = client.getIntStackSize();
		int stringStackSize = client.getStringStackSize();

		switch (event.getEventName())
		{
			case "bankSearchFilter":
				int itemId = intStack[intStackSize - 1];
				String search = stringStack[stringStackSize - 1];

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

					final String input = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT);
					clientThread.invokeLater(() ->
					{
						// reset chatbox input to avoid pin going to chatbox..
						client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, input);
						client.runScript(ScriptID.CHAT_PROMPT_INIT);

						client.runScript(onOpListener);
					});
				});
				break;
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != WidgetID.SEED_VAULT_GROUP_ID || !config.seedVaultValue())
		{
			return;
		}

		updateSeedVaultTotal();
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.BANKMAIN_BUILD)
		{
			// Compute bank prices using only the shown items so that we can show bank value during searches
			final Widget bankItemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
			final ItemContainer bankContainer = client.getItemContainer(InventoryID.BANK);
			final Widget[] children = bankItemContainer.getChildren();
			long geTotal = 0, haTotal = 0, rawTotal = 0;
			int smithingLevel = client.getRealSkillLevel(Skill.SMITHING);
			int craftingLevel = client.getRealSkillLevel(Skill.CRAFTING);
			int coalQty = 0;
			int mithQty = 0;
			int addyQty = 0;
			int runeQty = 0;

			if (children != null)
			{
				log.debug("Computing bank price of {} items", bankContainer.size());

				// The first components are the bank items, followed by tabs etc. There are always 816 components regardless
				// of bank size, but we only need to check up to the bank size.
				for (int i = 0; i < bankContainer.size(); ++i)
				{
					Widget child = children[i];
					if (child != null && !child.isSelfHidden() && child.getItemId() > -1)
					{
						final int alchPrice = getHaPrice(child.getItemId());
						final int rawPrice = getRawPrice((child.getItemId()), craftingLevel, smithingLevel);
						geTotal += (long) itemManager.getItemPrice(child.getItemId()) * child.getItemQuantity();
						haTotal += (long) alchPrice * child.getItemQuantity();
						rawTotal += (long) rawPrice * child.getItemQuantity();

						//needed to capture quantity of coal, mith, addy, and rune for the getOreValue function to work properly
						switch (child.getItemId())
						{
							case ItemID.COAL:
								coalQty = child.getItemQuantity();
								break;
							case ItemID.MITHRIL_ORE:
								mithQty = child.getItemQuantity();
								break;
							case ItemID.ADAMANTITE_ORE:
								addyQty = child.getItemQuantity();
								break;
							case ItemID.RUNITE_ORE:
								runeQty = child.getItemQuantity();
								break;
							default:
								break;
						}
					}
				}



				rawTotal += (long) getOreValue(smithingLevel, coalQty, mithQty, addyQty, runeQty);
				Widget bankTitle = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
				bankTitle.setText(bankTitle.getText() + createValueText(geTotal, haTotal, rawTotal));
			}
		}
		else if (event.getScriptId() == ScriptID.BANKMAIN_SEARCH_REFRESH)
		{
			// vanilla only lays out the bank every 40 client ticks, so if the search input has changed,
			// and the bank wasn't laid out this tick, lay it out early
			final String inputText = client.getVar(VarClientStr.INPUT_TEXT);
			if (searchString != inputText && client.getGameCycle() % 40 != 0)
			{
				clientThread.invokeLater(bankSearch::layoutBank);
				searchString = inputText;
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		int containerId = event.getContainerId();

		if (containerId == InventoryID.BANK.getId())
		{
			itemQuantities = null;
		}
		else if (containerId == InventoryID.SEED_VAULT.getId() && config.seedVaultValue())
		{
			updateSeedVaultTotal();
		}
	}

	private String createValueText(long gePrice, long haPrice, long rawPrice)
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

		if (config.showRaw() && rawPrice != 0)
		{
			stringBuilder.append(" (");

			if (config.showGE() || config.showHA())
			{
				stringBuilder.append("Raw: ");
			}

			if (config.showExact())
			{
				stringBuilder.append(QuantityFormatter.formatNumber(rawPrice));
			}
			else
			{
				stringBuilder.append(QuantityFormatter.quantityToStackSize(rawPrice));
			}
			stringBuilder.append(')');
		}

		return stringBuilder.toString();
	}

	private void updateSeedVaultTotal()
	{
		final Widget titleContainer = client.getWidget(WidgetInfo.SEED_VAULT_TITLE_CONTAINER);
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

		final String titleText = createValueText(prices.getGePrice(), prices.getHighAlchPrice(), prices.getRawPrice());
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
		final int qty = itemQuantities.count(itemId);
		final long gePrice = (long) itemManager.getItemPrice(itemId) * qty;
		final long haPrice = (long) itemComposition.getHaPrice() * qty;

		long value = Math.max(gePrice, haPrice);

		final String mode = matcher.group("mode");
		if (mode != null)
		{
			value = mode.toLowerCase().equals("ge") ? gePrice : haPrice;
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
		long raw = 0;

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

		return new ContainerPrices(ge, alch, raw);
	}

	private int getHaPrice(int itemId)
	{
		switch (itemId)
		{
			case ItemID.COINS_995:
				return 1;
			case ItemID.PLATINUM_TOKEN:
				return 1000;
			default:
				return itemManager.getItemComposition(itemId).getHaPrice();
		}
	}

	//determines which items are deemed as alchables for the raw gp calculation
	private boolean isAlchable(int itemId)
	{
		switch (itemId)
		{
			case ItemID.RUNE_PLATELEGS:
			case ItemID.RUNE_PLATESKIRT:
			case ItemID.RUNE_CHAINBODY:
			case ItemID.RUNE_PLATEBODY:
			case ItemID.RUNE_MED_HELM:
			case ItemID.RUNE_FULL_HELM:
			case ItemID.RUNE_SQ_SHIELD:
			case ItemID.RUNE_KITESHIELD:
			case ItemID.RUNE_DAGGER:
			case ItemID.RUNE_DAGGERP:
			case ItemID.RUNE_SPEAR:
			case ItemID.RUNE_SPEARP:
			case ItemID.RUNE_PICKAXE:
			case ItemID.RUNE_SWORD:
			case ItemID.RUNE_LONGSWORD:
			case ItemID.RUNE_2H_SWORD:
			case ItemID.RUNE_SCIMITAR:
			case ItemID.RUNE_WARHAMMER:
			case ItemID.RUNE_AXE:
			case ItemID.RUNE_BATTLEAXE:
			case ItemID.RUNE_MACE:
			case ItemID.RUNE_HALBERD:
			case ItemID.RUNE_BOOTS:
			case ItemID.RUNE_CROSSBOW:
			case ItemID.RUNE_HASTA:
			case ItemID.RUNE_JAVELIN_HEADS:
			case ItemID.RUNITE_LIMBS:
			case ItemID.RUNITE_CROSSBOW_U:
			case ItemID.DRAGON_MED_HELM:
			case ItemID.DRAGON_DAGGER:
			case ItemID.DRAGON_DAGGERP:
			case ItemID.DRAGON_SPEAR:
			case ItemID.DRAGON_LONGSWORD:
			case ItemID.DRAGON_BATTLEAXE:
			case ItemID.DRAGON_MACE:
			case ItemID.DRAGON_HALBERD:
			case ItemID.DRAGON_PLATELEGS:
			case ItemID.DRAGON_PLATESKIRT:
			case ItemID.DRAGON_SCIMITAR:
			case ItemID.DRAGON_DAGGERP_5680:
			case ItemID.DRAGON_DAGGERP_5698:
			case ItemID.DRAGON_JAVELIN_HEADS:
			case ItemID.GREEN_DHIDE_VAMBRACES:
			case ItemID.GREEN_DHIDE_CHAPS:
			case ItemID.GREEN_DHIDE_BODY:
			case ItemID.BLUE_DHIDE_VAMBRACES:
			case ItemID.BLUE_DHIDE_CHAPS:
			case ItemID.BLUE_DHIDE_BODY:
			case ItemID.RED_DHIDE_VAMBRACES:
			case ItemID.RED_DHIDE_CHAPS:
			case ItemID.RED_DHIDE_BODY:
			case ItemID.BLACK_DHIDE_VAMBRACES:
			case ItemID.BLACK_DHIDE_CHAPS:
			case ItemID.BLACK_DHIDE_BODY:
			case ItemID.BATTLESTAFF:
			case ItemID.FIRE_BATTLESTAFF:
			case ItemID.WATER_BATTLESTAFF:
			case ItemID.AIR_BATTLESTAFF:
			case ItemID.EARTH_BATTLESTAFF:
			case ItemID.LAVA_BATTLESTAFF:
			case ItemID.ONYX_BOLTS:
			case ItemID.ONYX_BOLTS_E:
			case ItemID.MYSTIC_FIRE_STAFF:
			case ItemID.MYSTIC_WATER_STAFF:
			case ItemID.MYSTIC_AIR_STAFF:
			case ItemID.MYSTIC_EARTH_STAFF:
			case ItemID.MYSTIC_LAVA_STAFF:
			case ItemID.MYSTIC_HAT:
			case ItemID.MYSTIC_ROBE_TOP:
			case ItemID.MYSTIC_ROBE_BOTTOM:
			case ItemID.MYSTIC_GLOVES:
			case ItemID.MYSTIC_BOOTS:
			case ItemID.MYSTIC_HAT_DARK:
			case ItemID.MYSTIC_ROBE_TOP_DARK:
			case ItemID.MYSTIC_ROBE_BOTTOM_DARK:
			case ItemID.MYSTIC_GLOVES_DARK:
			case ItemID.MYSTIC_BOOTS_DARK:
			case ItemID.MYSTIC_HAT_LIGHT:
			case ItemID.MYSTIC_ROBE_TOP_LIGHT:
			case ItemID.MYSTIC_ROBE_BOTTOM_LIGHT:
			case ItemID.MYSTIC_GLOVES_LIGHT:
			case ItemID.MYSTIC_BOOTS_LIGHT:
			case ItemID.MAPLE_LONGBOW:
			case ItemID.YEW_LONGBOW:
			case ItemID.MAGIC_LONGBOW:
			case ItemID.MAPLE_LONGBOW_U:
			case ItemID.YEW_LONGBOW_U:
			case ItemID.MAGIC_LONGBOW_U:
				return true;
			default:
				return false;
		}
	}

	//determines the value of ores for the raw gp option, based on quantity of ores in bank and players smithing level
	private int getOreValue(int smithingLevel, int coalQty, int mithQty, int addyQty, int runeQty)
	{
		int totalValue = 0;

		//begin consuming coal using the best ore available, and proceed from best to worst ore until coal is gone
		if (smithingLevel >= 89)
		{
			while (coalQty >= 4 && runeQty >= 1)
			{
				coalQty = coalQty - 4;
				runeQty = runeQty - 1;
				if (smithingLevel >= 99)
				{
					totalValue += 12800;
				}
				else totalValue += 12480;
			}
		}

		if (smithingLevel >= 88)
		{
			while (coalQty >= 3 && addyQty >= 1)
			{
				coalQty = coalQty - 3;
				addyQty = addyQty - 1;
				totalValue += 1996;
			}
		}

		if (smithingLevel >= 68)
		{
			while (coalQty >= 2 && mithQty >= 1)
			{
				coalQty = coalQty - 2;
				mithQty = mithQty - 1;
				totalValue += 624;
			}
		}

		return totalValue;
	}


	private int getRawPrice(int itemId, int craftingLevel, int smithingLevel)
	{
		switch (itemId)
		{
			case ItemID.COINS_995:
				return 1;
			case ItemID.PLATINUM_TOKEN:
				return 1000;
			case ItemID.GREEN_DRAGONHIDE:
				if (craftingLevel >= 63)
				{
					return 1540;
				}
				else return 0;
			case ItemID.GREEN_DRAGON_LEATHER:
				if (craftingLevel >= 63)
				{
					return 1560;
				}
				else return 0;
			case ItemID.BLUE_DRAGONHIDE:
				if (craftingLevel >= 71)
				{
					return 1852;
				}
				else return 0;
			case ItemID.BLUE_DRAGON_LEATHER:
				if (craftingLevel >= 71)
				{
					return 1872;
				}
				else return 0;
			case ItemID.RED_DRAGONHIDE:
				if (craftingLevel >= 77)
				{
					return 2226;
				}
				else return 0;
			case ItemID.RED_DRAGON_LEATHER:
				if (craftingLevel >= 77)
				{
					return 2246;
				}
				else return 0;
			case ItemID.BLACK_DRAGONHIDE:
				if (craftingLevel >= 84)
				{
					return 2676;
				}
				else return 0;
			case ItemID.BLACK_DRAGON_LEATHER:
				if (craftingLevel >= 84)
				{
					return 2696;
				}
				else return 0;
			case ItemID.MITHRIL_BAR:
				if (smithingLevel >= 68)
				{
					return 624;
				}
				else return 0;
			case ItemID.ADAMANTITE_BAR:
				if (smithingLevel >= 88)
				{
					return 1996;
				}
				else return 0;
			case ItemID.RUNITE_BAR:
				if (smithingLevel >= 99)
				{
					return 12800;
				}
				else if (smithingLevel >= 89)
				{
					return 12480;
				}
				else return 0;
			default:
				if (isAlchable(itemId))
				{
					return itemManager.getItemComposition(itemId).getHaPrice();
				}
				else return 0;
		}

	}
}
