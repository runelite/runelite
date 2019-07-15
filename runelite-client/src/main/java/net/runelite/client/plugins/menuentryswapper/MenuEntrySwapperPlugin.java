/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Kamiel
 * Copyright (c) 2019, alanbaumgartner <https://github.com/alanbaumgartner>
 * Copyright (c) 2019, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2019, lucouswin <https://github.com/lucouswin>
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
package net.runelite.client.plugins.menuentryswapper;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemDefinition;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
import static net.runelite.api.MenuAction.WALK;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import static net.runelite.api.Varbits.BUILDING_MODE;

import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.PostItemDefinition;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.ComparableEntry;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.menuentryswapper.util.BurningAmuletMode;
import net.runelite.client.plugins.menuentryswapper.util.CombatBraceletMode;
import net.runelite.client.plugins.menuentryswapper.util.DigsitePendantMode;
import net.runelite.client.plugins.menuentryswapper.util.DuelingRingMode;
import net.runelite.client.plugins.menuentryswapper.util.FairyRingMode;
import net.runelite.client.plugins.menuentryswapper.util.GamesNecklaceMode;
import net.runelite.client.plugins.menuentryswapper.util.GloryMode;
import net.runelite.client.plugins.menuentryswapper.util.HouseMode;
import net.runelite.client.plugins.menuentryswapper.util.MaxCapeMode;
import net.runelite.client.plugins.menuentryswapper.util.NecklaceOfPassageMode;
import net.runelite.client.plugins.menuentryswapper.util.ObeliskMode;
import net.runelite.client.plugins.menuentryswapper.util.OccultAltarMode;
import net.runelite.client.plugins.menuentryswapper.util.CharterOption;
import net.runelite.client.plugins.menuentryswapper.util.QuestCapeMode;
import net.runelite.client.plugins.menuentryswapper.util.RingOfWealthMode;
import net.runelite.client.plugins.menuentryswapper.util.SkillsNecklaceMode;
import net.runelite.client.plugins.menuentryswapper.util.SlayerRingMode;
import net.runelite.client.plugins.menuentryswapper.util.XericsTalismanMode;
import net.runelite.client.plugins.menuentryswapper.util.teleEquippedMode;
import static net.runelite.client.util.MenuUtil.swap;

import net.runelite.client.plugins.pvptools.PvpToolsConfig;
import net.runelite.client.plugins.pvptools.PvpToolsPlugin;
import net.runelite.client.util.MiscUtils;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Menu Entry Swapper",
	description = "Change the default option that is displayed when hovering over objects",
	tags = {"npcs", "inventory", "items", "objects"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
@PluginDependency(PvpToolsPlugin.class)
public class MenuEntrySwapperPlugin extends Plugin
{
	private static final String CONFIGURE = "Configure";
	private static final String SAVE = "Save";
	private static final String RESET = "Reset";
	private static final String MENU_TARGET = "Shift-click";
	private List<String> bankItemNames = new ArrayList<>();
	private static final String CONFIG_GROUP = "shiftclick";
	private static final String ITEM_KEY_PREFIX = "item_";
	private static final int PURO_PURO_REGION_ID = 10307;


	private MenuEntry[] entries;
	private final Set<String> leftClickConstructionItems = new HashSet<>();
	private boolean buildingMode;
	private boolean inTobRaid = false;
	private boolean inCoxRaid = false;

	private static final WidgetMenuOption FIXED_INVENTORY_TAB_CONFIGURE = new WidgetMenuOption(CONFIGURE,
		MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB);

	private static final WidgetMenuOption FIXED_INVENTORY_TAB_SAVE = new WidgetMenuOption(SAVE,
		MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB);

	private static final WidgetMenuOption RESIZABLE_INVENTORY_TAB_CONFIGURE = new WidgetMenuOption(CONFIGURE,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB);

	private static final WidgetMenuOption RESIZABLE_INVENTORY_TAB_SAVE = new WidgetMenuOption(SAVE,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB);

	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE = new WidgetMenuOption(CONFIGURE,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB);

	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE = new WidgetMenuOption(SAVE,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB);

	private static final Set<MenuAction> NPC_MENU_TYPES = ImmutableSet.of(
		MenuAction.NPC_FIRST_OPTION,
		MenuAction.NPC_SECOND_OPTION,
		MenuAction.NPC_THIRD_OPTION,
		MenuAction.NPC_FOURTH_OPTION,
		MenuAction.NPC_FIFTH_OPTION,
		MenuAction.EXAMINE_NPC);

	private static final Splitter NEWLINE_SPLITTER = Splitter
		.on("\n")
		.omitEmptyStrings()
		.trimResults();

	private final Map<ComparableEntry, ComparableEntry> customSwaps = new HashMap<>();

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private MenuEntrySwapperConfig config;

	@Inject
	private ShiftClickInputListener inputListener;

	@Inject
	private ConfigManager configManager;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private MenuManager menuManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private PvpToolsPlugin pvpTools;

	@Inject
	private PvpToolsConfig pvpToolsConfig;

	@Getter(AccessLevel.PACKAGE)
	private boolean configuringShiftClick = false;

	@Setter(AccessLevel.PACKAGE)
	private boolean shiftModifier = false;
	
	private boolean getWithdrawOne;
	private String getWithdrawOneItems;
	private boolean getWithdrawFive;
	private String getWithdrawFiveItems;
	private boolean getWithdrawTen;
	private String getWithdrawTenItems;
	private boolean getWithdrawX;
	private String getWithdrawXAmount;
	private String getWithdrawXItems;
	private boolean getWithdrawAll;
	private String getWithdrawAllItems;
	private boolean swapMax;
	private boolean teleEquippedCape;
	private teleEquippedMode telecapeMode;
	private MaxCapeMode maxMode;
	private boolean getSwapArdougneCape;
	private boolean getSwapConstructionCape;
	private boolean getSwapCraftingCape;
	private boolean getSwapMagicCape;
	private boolean getSwapExplorersRing;
	private boolean swapAdmire;
	private boolean swapQuestCape;
	private QuestCapeMode questCapeMode;
	private String configCustomSwaps;
	private boolean shiftClickCustomization;
	private boolean swapCoalBag;
	private boolean swapBirdhouseEmpty;
	private boolean swapBones;
	private boolean swapChase;
	private boolean swapHarpoon;
	private OccultAltarMode swapOccultMode;
	private HouseMode swapHomePortalMode;
	private boolean swapPrivate;
	private boolean swapPick;
	private boolean swapQuick;
	private boolean swapBoxTrap;
	private boolean rockCake;
	private boolean swapRogueschests;
	private boolean swapClimbUpDown;
	private boolean swapStun;
	private boolean swapSearch;
	private boolean swapHardWoodGrove;
	private boolean getRemoveObjects;
	private String getRemovedObjects;
	private boolean swapImps;
	private CharterOption charterOption;
	private boolean getSwapBuyOne;
	private String getBuyOneItems;
	private boolean getSwapBuyFive;
	private String getBuyFiveItems;
	private boolean getSwapBuyTen;
	private String getBuyTenItems;
	private boolean getSwapBuyFifty;
	private String getBuyFiftyItems;
	private boolean getSwapSellOne;
	private String getSellOneItems;
	private boolean getSwapSellFive;
	private String getSellFiveItems;
	private boolean getSwapSellTen;
	private String getSellTenItems;
	private boolean getSwapSellFifty;
	private String getSellFiftyItems;
	private boolean getEasyConstruction;
	private String getEasyConstructionItems;
	private boolean getSwapSmithing;
	private boolean getSwapTanning;
	private boolean getSwapSawmill;
	private boolean getSwapSawmillPlanks;
	private boolean getSwapPuro;
	private boolean swapAssignment;
	private boolean swapBankExchange;
	private boolean swapContract;
	private boolean swapInteract;
	private boolean swapPickpocket;
	private boolean swapPay;
	private boolean swapAbyssTeleport;
	private boolean swapTrade;
	private boolean swapTravel;
	private boolean swapMinigame;
	private boolean swapPlank;
	private boolean swapMetamorphosis;
	private boolean swapEnchant;
	private FairyRingMode swapFairyRingMode;
	private ObeliskMode swapObeliskMode;
	private boolean swapTeleportItem;
	private boolean swapWildernessLever;
	private boolean swapNexus;
	private boolean getGamesNecklace;
	private GamesNecklaceMode getGamesNecklaceMode;
	private boolean getDuelingRing;
	private DuelingRingMode getDuelingRingMode;
	private boolean getGlory;
	private GloryMode getGloryMode;
	private boolean getSkillsNecklace;
	private SkillsNecklaceMode getSkillsNecklaceMode;
	private boolean getNecklaceofPassage;
	private NecklaceOfPassageMode getNecklaceofPassageMode;
	private boolean getDigsitePendant;
	private DigsitePendantMode getDigsitePendantMode;
	private boolean getCombatBracelet;
	private CombatBraceletMode getCombatBraceletMode;
	private boolean getBurningAmulet;
	private BurningAmuletMode getBurningAmuletMode;
	private boolean getXericsTalisman;
	private XericsTalismanMode getXericsTalismanMode;
	private boolean getRingofWealth;
	private RingOfWealthMode getRingofWealthMode;
	private boolean getSlayerRing;
	private SlayerRingMode getSlayerRingMode;
	private boolean hideExamine;
	private boolean hideTradeWith;
	private boolean hideReport;
	private boolean hideLookup;
	private boolean hideNet;
	private boolean hideBait;
	private boolean hideDestroyRunepouch;
	private boolean hideDestroyCoalbag;
	private boolean hideDestroyHerbsack;
	private boolean hideDestroyBoltpouch;
	private boolean hideDestroyGembag;
	private boolean hideDropRunecraftingPouch;
	private boolean hideCastToB;
	private Set<String> hideCastIgnoredToB;
	private boolean hideCastCoX;
	private Set<String> hideCastIgnoredCoX;

	@Provides
	MenuEntrySwapperConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MenuEntrySwapperConfig.class);
	}

	@Override
	public void startUp()
	{
		updateConfig();
		addSwaps();
		loadConstructionItems(config.getEasyConstructionItems());

		if (config.shiftClickCustomization())
		{
			enableCustomization();
		}

		loadCustomSwaps(config.customSwaps());

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			setCastOptions(true);
		}
	}

	@Override
	public void shutDown()
	{
		disableCustomization();
		loadConstructionItems("");
		loadCustomSwaps(""); // Removes all custom swaps
		removeSwaps();

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			resetCastOptions();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!"menuentryswapper".equals(event.getGroup()))
		{
			return;
		}

		updateConfig();

		loadConstructionItems(this.getEasyConstructionItems);
		removeSwaps();
		addSwaps();

		if (!CONFIG_GROUP.equals(event.getGroup()))
		{
			if (event.getKey().equals("customSwaps"))
			{
				loadCustomSwaps(this.configCustomSwaps);
			}
		}

		if (event.getKey().equals("shiftClickCustomization"))
		{
			if (this.shiftClickCustomization)
			{
				enableCustomization();
			}
			else
			{
				disableCustomization();
			}
		}
		else if (event.getKey().startsWith(ITEM_KEY_PREFIX))
		{
			clientThread.invoke(this::resetItemDefinitionCache);
		}

		else if ((event.getKey().equals("hideCastToB") || event.getKey().equals("hideCastIgnoredToB")))
		{
			if (this.hideCastToB)
			{
				setCastOptions(true);
			}
			else
			{
				resetCastOptions();
			}
		}

		else if ((event.getKey().equals("hideCastCoX") || event.getKey().equals("hideCastIgnoredCoX")))
		{
			if (this.hideCastCoX)
			{
				setCastOptions(true);
			}
			else
			{
				resetCastOptions();
			}
		}
	}

	private void resetItemDefinitionCache()
	{
		itemManager.invalidateItemDefinitionCache();
		client.getItemDefinitionCache().reset();
	}

	private Integer getSwapConfig(int itemId)
	{
		itemId = ItemVariationMapping.map(itemId);
		String config = configManager.getConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
		if (config == null || config.isEmpty())
		{
			return null;
		}

		return Integer.parseInt(config);
	}

	private void setSwapConfig(int itemId, int index)
	{
		itemId = ItemVariationMapping.map(itemId);
		configManager.setConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId, index);
	}

	private void unsetSwapConfig(int itemId)
	{
		itemId = ItemVariationMapping.map(itemId);
		configManager.unsetConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
	}

	private void enableCustomization()
	{
		keyManager.registerKeyListener(inputListener);
		refreshShiftClickCustomizationMenus();
		clientThread.invoke(this::resetItemDefinitionCache);
	}

	private void disableCustomization()
	{
		keyManager.unregisterKeyListener(inputListener);
		removeShiftClickCustomizationMenus();
		configuringShiftClick = false;
		clientThread.invoke(this::resetItemDefinitionCache);
	}

	@Subscribe
	public void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
	{
		if (event.getWidget() == WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB
			|| event.getWidget() == WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB
			|| event.getWidget() == WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB)
		{
			configuringShiftClick = event.getMenuOption().equals(CONFIGURE) && Text.removeTags(event.getMenuTarget()).equals(MENU_TARGET);
			refreshShiftClickCustomizationMenus();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		loadConstructionItems(this.getEasyConstructionItems);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		buildingMode = client.getVar(BUILDING_MODE) == 1;

		setCastOptions(false);
	}

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		Player localPlayer = client.getLocalPlayer();

		if (localPlayer == null)
		{
			return;
		}

		if (!(MiscUtils.getWildernessLevelFrom(client, localPlayer.getWorldLocation()) >= 0))
		{
			return;
		}

		List<MenuEntry> menu_entries = new ArrayList<>();

		for (MenuEntry entry : event.getMenuEntries())
		{
			String option = Text.removeTags(entry.getOption()).toLowerCase();

			if (option.contains("trade with") && this.hideTradeWith)
			{
				continue;
			}

			if (option.contains("lookup") && this.hideLookup)
			{
				continue;
			}

			if (option.contains("report") && this.hideReport)
			{
				continue;
			}

			if (option.contains("examine") && this.hideExamine)
			{
				continue;
			}

			if (option.contains("net") && this.hideNet)
			{
				continue;
			}

			if (option.contains("bait") && this.hideBait)
			{
				continue;
			}

			if (option.contains("destroy"))
			{
				if (this.hideDestroyRunepouch && entry.getTarget().contains("Rune pouch"))
				{
					continue;
				}
				if (this.hideDestroyCoalbag && entry.getTarget().contains("Coal bag"))
				{
					continue;
				}
				if (this.hideDestroyHerbsack && entry.getTarget().contains("Herb sack"))
				{
					continue;
				}
				if (this.hideDestroyBoltpouch && entry.getTarget().contains("Bolt pouch"))
				{
					continue;
				}
				if (this.hideDestroyGembag && entry.getTarget().contains("Gem bag"))
				{
					continue;
				}
			}

			if (option.contains("drop"))
			{
				if (this.hideDropRunecraftingPouch && (
					entry.getTarget().contains("Small pouch")
								|| entry.getTarget().contains("Medium pouch")
								|| entry.getTarget().contains("Large pouch")
								|| entry.getTarget().contains("Giant pouch")))
				{
					continue;
				}
			}

			menu_entries.add(entry);
		}

		MenuEntry[] updated_menu_entries = new MenuEntry[menu_entries.size()];
		updated_menu_entries = menu_entries.toArray(updated_menu_entries);

		client.setMenuEntries(updated_menu_entries);

		if (!configuringShiftClick)
		{
			return;
		}

		MenuEntry firstEntry = event.getFirstEntry();
		if (firstEntry == null)
		{
			return;
		}

		int widgetId = firstEntry.getParam1();
		if (widgetId != WidgetInfo.INVENTORY.getId())
		{
			return;
		}

		int itemId = firstEntry.getIdentifier();
		if (itemId == -1)
		{
			return;
		}

		ItemDefinition itemComposition = client.getItemDefinition(itemId);
		String itemName = itemComposition.getName();
		String option = "Use";
		int shiftClickActionindex = itemComposition.getShiftClickActionIndex();
		String[] inventoryActions = itemComposition.getInventoryActions();

		if (shiftClickActionindex >= 0 && shiftClickActionindex < inventoryActions.length)
		{
			option = inventoryActions[shiftClickActionindex];
		}

		MenuEntry[] entries = event.getMenuEntries();

		for (MenuEntry entry : entries)
		{
			if (itemName.equals(Text.removeTags(entry.getTarget())))
			{
				entry.setType(MenuAction.RUNELITE.getId());

				if (option.equals(entry.getOption()))
				{
					entry.setOption("* " + option);
				}
			}
		}

		final MenuEntry resetShiftClickEntry = new MenuEntry();
		resetShiftClickEntry.setOption(RESET);
		resetShiftClickEntry.setTarget(MENU_TARGET);
		resetShiftClickEntry.setIdentifier(itemId);
		resetShiftClickEntry.setParam1(widgetId);
		resetShiftClickEntry.setType(MenuAction.RUNELITE.getId());
		client.setMenuEntries(ArrayUtils.addAll(entries, resetShiftClickEntry));
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuAction() != MenuAction.RUNELITE || event.getActionParam1() != WidgetInfo.INVENTORY.getId())
		{
			return;
		}

		int itemId = event.getIdentifier();

		if (itemId == -1)
		{
			return;
		}

		String option = event.getOption();
		String target = event.getTarget();
		ItemDefinition itemComposition = client.getItemDefinition(itemId);

		if (option.equals(RESET) && target.equals(MENU_TARGET))
		{
			unsetSwapConfig(itemId);
			return;
		}

		if (!itemComposition.getName().equals(Text.removeTags(target)))
		{
			return;
		}

		int index = -1;
		boolean valid = false;

		if (option.equals("Use")) //because "Use" is not in inventoryActions
		{
			valid = true;
		}
		else
		{
			String[] inventoryActions = itemComposition.getInventoryActions();

			for (index = 0; index < inventoryActions.length; index++)
			{
				if (option.equals(inventoryActions[index]))
				{
					valid = true;
					break;
				}
			}
		}

		if (valid)
		{
			setSwapConfig(itemId, index);
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final String pOptionToReplace = Text.removeTags(event.getOption()).toUpperCase();
		final int eventId = event.getIdentifier();
		final String option = Text.standardize(event.getOption());
		final String target = Text.standardize(event.getTarget());
		final NPC hintArrowNpc = client.getHintArrowNpc();
		entries = client.getMenuEntries();

		if (option.contains("withdraw") || option.contains("deposit"))
		{
			if (this.getWithdrawOne)
			{
				for (String item : Text.fromCSV(this.getWithdrawOneItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-1", option, target);
						swap(client, "Deposit-1", option, target);
					}
				}
			}

			if (this.getWithdrawFive)
			{
				for (String item : Text.fromCSV(this.getWithdrawFiveItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-5", option, target);
						swap(client, "Deposit-5", option, target);
					}
				}
			}

			if (this.getWithdrawTen)
			{
				for (String item : Text.fromCSV(this.getWithdrawTenItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-10", option, target);
						swap(client, "Deposit-10", option, target);
					}
				}
			}

			if (this.getWithdrawX)
			{
				for (String item : Text.fromCSV(this.getWithdrawXItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-" + this.getWithdrawXAmount, option, target);
						swap(client, "Deposit-" + this.getWithdrawXAmount, option, target);
					}
				}
			}

			if (this.getWithdrawAll)
			{
				for (String item : Text.fromCSV(this.getWithdrawAllItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-All", option, target);
						swap(client, "Deposit-All", option, target);
					}
				}
			}
		}

		if ((option.contains("buy") || option.contains("value")) && Arrays.stream(entries).anyMatch(menuEntry ->
			menuEntry.getOption().toLowerCase().contains("buy")))
		{
			if (this.getSwapBuyOne && !this.getBuyOneItems.equals(""))
			{
				for (String item : Text.fromCSV(this.getBuyOneItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Buy 1", option, target);
					}
				}
			}

			if (this.getSwapBuyFive && !this.getBuyFiveItems.equals(""))
			{
				for (String item : Text.fromCSV(this.getBuyFiveItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Buy 5", option, target);
					}
				}
			}

			if (this.getSwapBuyTen && !this.getBuyTenItems.equals(""))
			{
				for (String item : Text.fromCSV(this.getBuyTenItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Buy 10", option, target);
					}
				}
			}

			if (this.getSwapBuyFifty && !this.getBuyFiftyItems.equals(""))
			{
				for (String item : Text.fromCSV(this.getBuyFiftyItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Buy 50", option, target);
					}
				}
			}
		}
		else if ((option.contains("sell") || option.contains("value")) && Arrays.stream(entries).anyMatch(menuEntry ->
			menuEntry.getOption().toLowerCase().contains("sell")))
		{
			if (this.getSwapSellOne && !this.getSellOneItems.equals(""))
			{
				for (String item : Text.fromCSV(this.getSellOneItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Sell 1", option, target);
					}
				}
			}

			if (this.getSwapSellFive && !Strings.isNullOrEmpty(this.getSellFiveItems))
			{
				for (String item : Text.fromCSV(this.getSellFiveItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Sell 5", option, target);
					}
				}
			}

			if (this.getSwapSellTen && !Strings.isNullOrEmpty(this.getSellTenItems))
			{
				for (String item : Text.fromCSV(this.getSellTenItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Sell 10", option, target);
					}
				}
			}

			if (this.getSwapSellFifty && !Strings.isNullOrEmpty(this.getSellFiftyItems))
			{
				for (String item : Text.fromCSV(this.getSellFiftyItems))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Sell 50", option, target);
					}
				}
			}
		}

		if (this.getRemoveObjects && !this.getRemovedObjects.equals(""))
		{
			for (String removed : Text.fromCSV(this.getRemovedObjects))
			{
				removed = Text.standardize(removed);
				if (target.contains("(") && target.split(" \\(")[0].equals(removed))
				{
					delete(event.getIdentifier());
				}
				else if (target.contains("->"))
				{
					String trimmed = target.split("->")[1].trim();
					if (trimmed.length() >= removed.length() && trimmed.substring(0, removed.length()).equalsIgnoreCase(removed))
					{
						delete(event.getIdentifier());
						break;
					}
				}
				else if (target.length() >= removed.length() && target.substring(0, removed.length()).equalsIgnoreCase(removed))
				{
					delete(event.getIdentifier());
					break;
				}
			}
		}

		if (this.getSwapPuro && isPuroPuro())
		{
			if (event.getType() == WALK.getId())
			{
				MenuEntry[] menuEntries = client.getMenuEntries();
				MenuEntry menuEntry = menuEntries[menuEntries.length - 1];
				menuEntry.setType(MenuAction.WALK.getId() + MENU_ACTION_DEPRIORITIZE_OFFSET);
				client.setMenuEntries(menuEntries);
			}
			else if (option.equalsIgnoreCase("examine"))
			{
				swap(client, "push-through", option, target);
			}
			else if (option.equalsIgnoreCase("use"))
			{
				swap(client, "escape", option, target);
			}
		}

		else if (this.getSwapSmithing && option.contains("smith"))
		{
			if (option.equalsIgnoreCase("Smith 1"))
			{
				swap(client, "Smith All", option, target);
			}
			else if (option.equalsIgnoreCase("Smith 1 Set"))
			{
				swap(client, "Smith All Sets", option, target);
			}
		}

		else if (this.getSwapTanning && option.equalsIgnoreCase("Tan 1"))
		{
			swap(client, "Tan All", option, target);
		}

		else if (this.getSwapSawmill && target.equalsIgnoreCase("Sawmill operator"))
		{
			swap(client, "Buy-plank", option, target);
		}

		else if (this.getSwapSawmillPlanks && option.equalsIgnoreCase("Buy 1"))
		{
			swap(client, "Buy All", option, target);
		}

		else if (option.equalsIgnoreCase("Clear-All") && target.equalsIgnoreCase("Bank Filler"))
		{
			swap(client, "Clear", option, target);
		}

		else if (target.contains("ardougne cloak") && this.getSwapArdougneCape)
		{
			swap(client, "Kandarin Monastery", option, target);
			swap(client, "Monastery Teleport", option, target);
		}

		else if (target.contains("crafting cape") && this.getSwapCraftingCape)
		{
			swap(client, "Teleport", option, target);
		}

		else if (target.contains("construct. cape") && this.getSwapConstructionCape)
		{
			swap(client, "Tele to poh", option, target);
		}

		else if (target.contains("magic cape") && this.getSwapMagicCape)
		{
			swap(client, "Spellbook", option, target);
		}

		else if (target.contains("explorer's ring") && this.getSwapExplorersRing)
		{
			swap(client, "Teleport", option, target);
		}

		if (hintArrowNpc != null
			&& hintArrowNpc.getIndex() == eventId
			&& NPC_MENU_TYPES.contains(MenuAction.of(event.getType())))
		{
			return;
		}

		if (this.swapImps && target.contains("impling"))
		{

			if (client.getItemContainer(InventoryID.BANK) != null)
			{
				bankItemNames = new ArrayList<>();
				for (Item i : Objects.requireNonNull(client.getItemContainer(InventoryID.BANK)).getItems())
				{
					bankItemNames.add(client.getItemDefinition((i.getId())).getName());
				}
			}
			List<String> invItemNames = new ArrayList<>();
			if (target.equals("gourmet impling jar"))
			{
				if (client.getItemContainer(InventoryID.INVENTORY) != null)
				{
					for (Item i : Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems())
					{
						invItemNames.add(client.getItemDefinition((i.getId())).getName());
					}
					if ((invItemNames.contains("Clue scroll (easy)") || bankItemNames.contains("Clue scroll (easy)")))
					{
						menuManager.addSwap("loot", target, "use");
					}
					else
					{
						menuManager.removeSwaps(target);
					}
				}
			}
			switch (target)
			{
				case "eclectic impling jar":
					if (client.getItemContainer(InventoryID.INVENTORY) != null)
					{
						for (Item i : Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems())
						{
							invItemNames.add(client.getItemDefinition((i.getId())).getName());
						}
						if ((invItemNames.contains("Clue scroll (medium)") || bankItemNames.contains("Clue scroll (medium)")))
						{
							menuManager.addSwap("loot", target, "use");
						}
						else
						{
							menuManager.removeSwaps(target);
						}
					}
					break;
				case "magpie impling jar":
				case "nature impling jar":
				case "ninja impling jar":
					if (client.getItemContainer(InventoryID.INVENTORY) != null)
					{
						for (Item i : Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems())
						{
							invItemNames.add(client.getItemDefinition((i.getId())).getName());
						}
						if ((invItemNames.contains("Clue scroll (hard)") || bankItemNames.contains("Clue scroll (hard)")))
						{
							menuManager.addSwap("loot", target, "use");
						}
						else
						{
							menuManager.removeSwaps(target);
						}
					}
					break;
				case "dragon impling jar":
					if (client.getItemContainer(InventoryID.INVENTORY) != null)
					{
						for (Item i : Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems())
						{
							invItemNames.add(client.getItemDefinition((i.getId())).getName());
						}
						if ((invItemNames.contains("Clue scroll (elite)") || bankItemNames.contains("Clue scroll (elite)")))
						{
							menuManager.addSwap("loot", target, "use");
						}
						else
						{
							menuManager.removeSwaps(target);
						}
					}
					break;
			}
		}
		
		if (option.equals("talk-to") || option.equals("attack"))
		{
			if (this.swapPickpocket)
			{
				swap(client, "pickpocket", option, target, true);
			}

		}

		if (option.equals("talk-to"))
		{

			if (this.swapHardWoodGrove && target.contains("rionasta"))
			{
				swap(client, "send-parcel", option, target, true);
			}
			if (this.swapBankExchange)
			{
				swap(client, "bank", option, target, true);
				swap(client, "exchange", option, target, true);
			}

			if (this.swapContract)
			{
				swap(client, "contract", option, target, true);
			}

			if (this.swapInteract)
			{
				swap(client, "repairs", option, target, true);
				swap(client, "claim-slime", option, target, true);
				swap(client, "decant", option, target, true);
				swap(client, "claim", option, target, true);
				swap(client, "heal", option, target, true);
				swap(client, "help", option, target, true);
			}

			// make sure assignment swap is higher priority than trade swap for slayer masters
			if (this.swapAssignment)
			{
				swap(client, "assignment", option, target, true);
			}

			if (this.swapPlank)
			{
				swap(client, "buy-plank", option, target, true);
			}

			if (this.swapTrade && (!(target.equals("trader crewmember") || target.equals("trader stan")) || this.charterOption.equals(CharterOption.TRADE)))
			{
				swap(client, "trade", option, target, true);
				swap(client, "trade-with", option, target, true);
				swap(client, "shop", option, target, true);
			}

			if (this.swapMinigame)
			{
				swap(client, "story", option, target, true);
				swap(client, "escort", option, target, true);
				swap(client, "dream", option, target, true);
				swap(client, "start-minigame", option, target, true);
			}

			if (this.swapTravel)
			{
				swap(client, "travel", option, target, true);
				swap(client, "pay-fare", option, target, true);
				swap(client, "charter", option, target, true);
				swap(client, "take-boat", option, target, true);
				swap(client, "fly", option, target, true);
				swap(client, "jatizso", option, target, true);
				swap(client, "neitiznot", option, target, true);
				swap(client, "rellekka", option, target, true);
				swap(client, "follow", option, target, true);
				swap(client, "transport", option, target, true);

				if (this.swapAbyssTeleport && target.contains("mage of zamorak"))
				{
					swap(client, "teleport", option, target, true);
				}

				if (!(target.equals("trader crewmember") || target.equals("trader stan")) || this.charterOption.equals(CharterOption.CHARTER))
				{
					swap(client, "charter", option, target, true);
				}
			}

			if (this.swapPay)
			{
				swap(client, "pay", option, target, true);
				swap(client, "pay (", option, target, false);
			}

			if (this.swapQuick)
			{
				swap(client, "quick-travel", option, target, true);
			}

			if (this.swapEnchant)
			{
				swap(client, "enchant", option, target, true);
			}

		}

		else if (this.swapWildernessLever && target.equals("lever") && option.equals("ardougne"))
		{
			swap(client, "edgeville", option, target, true);
		}

		else if (this.swapMetamorphosis && target.contains("baby chinchompa"))
		{
			swap(client, "metamorphosis", option, target, true);
		}

		else if (this.swapStun && target.contains("hoop snake"))
		{
			swap(client, "stun", option, target, true);
		}

		else if (this.swapTravel && option.equals("pass") && target.equals("energy barrier"))
		{
			swap(client, "pay-toll(2-ecto)", option, target, true);
		}

		else if (this.swapTravel && option.equals("open") && target.equals("gate"))
		{
			swap(client, "pay-toll(10gp)", option, target, true);
		}
		
		else if (this.swapHardWoodGrove && option.equals("open") && target.equals("hardwood grove doors"))
		{
			swap(client, "quick-pay(100)", option, target, true);
		}
		
		else if (this.swapTravel && option.equals("inspect") && target.equals("trapdoor"))
		{
			swap(client, "travel", option, target, true);
		}

		else if (this.swapHarpoon && option.equals("cage"))
		{
			swap(client, "harpoon", option, target, true);
		}

		else if (this.swapHarpoon && (option.equals("big net") || option.equals("net")))
		{
			swap(client, "harpoon", option, target, true);
		}

		else if (this.swapOccultMode != OccultAltarMode.VENERATE && option.equals("venerate"))
		{
			switch (this.swapOccultMode)
			{
				case VENERATE:
					swap(client, "Venerate", option, target, true);
					break;
				case ANCIENT:
					swap(client, "Ancient", option, target, true);
					break;
				case LUNAR:
					swap(client, "Lunar", option, target, true);
					break;
				case ARCEUUS:
					swap(client, "Arceuus", option, target, true);
			}

		}

		else if (this.swapObeliskMode != ObeliskMode.ACTIVATE && option.equals("activate"))
		{
			switch (this.swapObeliskMode)
			{
				case ACTIVATE:
					swap(client, "activate", option, target, true);
					break;
				case SET_DESTINATION:
					swap(client, "set destination", option, target, true);
					break;
				case TELEPORT_TO_DESTINATION:
					swap(client, "teleport to destination", option, target, true);
					break;
			}
		}

		else if (this.swapHomePortalMode != HouseMode.ENTER && option.equals("enter"))
		{
			switch (this.swapHomePortalMode)
			{
				case HOME:
					swap(client, "home", option, target, true);
					break;
				case BUILD_MODE:
					swap(client, "build mode", option, target, true);
					break;
				case FRIENDS_HOUSE:
					swap(client, "friend's house", option, target, true);
					break;
			}
		}
		else if (this.swapFairyRingMode != FairyRingMode.OFF && this.swapFairyRingMode != FairyRingMode.ZANARIS
			&& (option.equals("zanaris") || option.equals("configure") || option.equals("tree")))
		{
			if (this.swapFairyRingMode == FairyRingMode.LAST_DESTINATION)
			{
				swap(client, "last-destination", option, target, false);
			}
			else if (this.swapFairyRingMode == FairyRingMode.CONFIGURE)
			{
				swap(client, "configure", option, target, false);
			}
		}

		else if (this.swapFairyRingMode == FairyRingMode.ZANARIS && option.equals("tree"))
		{
			swap(client, "zanaris", option, target, false);
		}

		else if (this.swapBoxTrap && (option.equals("check") || option.equals("dismantle")))
		{
			swap(client, "reset", option, target, true);
		}

		else if (this.swapBoxTrap && option.equals("take"))
		{
			swap(client, "lay", option, target, true);
			swap(client, "activate", option, target, true);
		}

		else if (this.swapChase && option.equals("pick-up"))
		{
			swap(client, "chase", option, target, true);
		}

		else if (this.swapBirdhouseEmpty && option.equals("interact") && target.contains("birdhouse"))
		{
			swap(client, "empty", option, target, true);
		}

		else if (this.swapQuick && option.equals("enter"))
		{
			swap(client, "quick-enter", option, target, true);
		}
		else if (this.swapQuick && option.equals("ring"))
		{
			swap(client, "quick-start", option, target, true);
		}

		else if (this.swapQuick && option.equals("pass"))
		{
			swap(client, "quick-pass", option, target, true);
		}

		else if (this.swapQuick && option.equals("open"))
		{
			swap(client, "quick-open", option, target, true);
		}
		else if (this.swapQuick && option.equals("enter"))
		{
			swap(client, "quick-enter", option, target, true);
		}
		else if (this.swapQuick && option.equals("leave tomb"))
		{
			swap(client, "quick-leave", option, target, true);
		}
		else if (this.swapAdmire && option.equals("admire"))
		{
			swap(client, "teleport", option, target, true);
			swap(client, "spellbook", option, target, true);
			swap(client, "perks", option, target, true);
		}

		else if (this.swapPrivate && option.equals("shared"))
		{
			swap(client, "private", option, target, true);
		}

		else if (this.swapPick && option.equals("pick"))
		{
			swap(client, "pick-lots", option, target, true);
		}

		else if (this.swapSearch && (option.equals("close") || option.equals("shut")))
		{
			swap(client, "search", option, target, true);
		}

		else if (this.swapRogueschests && target.contains("chest"))
		{
			swap(client, "search for traps", option, target, true);
		}

		else if (this.rockCake && option.equals("eat"))
		{
			swap(client, "guzzle", option, target, true);
		}


		else if (this.shiftClickCustomization && shiftModifier && !option.equals("use"))
		{
			Integer customOption = getSwapConfig(eventId);

			if (customOption != null && customOption == -1)
			{
				swap(client, "use", option, target, true);
			}
		}

		// Put all item-related swapping after shift-click
		else if (this.swapTeleportItem && (option.equals("wear") || option.equals("wield")))
		{
			swap(client, "rub", option, target, true);
			swap(client, "teleport", option, target, true);
		}
		else if (this.swapCoalBag && option.contains("deposit") && target.equals("coal bag"))
		{
			swap(client, "empty", option, target, true);
		}
		else if (this.swapBones && option.equals("bury"))
		{
			swap(client, "use", option, target, true);
		}
		else if (this.swapNexus && target.contains("portal nexus"))
		{
			swap(client, "teleport menu", option, target, true);
		}
	}

	@Subscribe
	public void onPostItemDefinition(PostItemDefinition event)
	{
		ItemDefinition itemComposition = event.getItemDefinition();
		Integer option = getSwapConfig(itemComposition.getId());

		if (option != null)
		{
			itemComposition.setShiftClickActionIndex(option);
		}
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			shiftModifier = false;
		}
	}

	private void removeShiftClickCustomizationMenus()
	{
		menuManager.removeManagedCustomMenu(FIXED_INVENTORY_TAB_CONFIGURE);
		menuManager.removeManagedCustomMenu(FIXED_INVENTORY_TAB_SAVE);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE);
		menuManager.removeManagedCustomMenu(RESIZABLE_INVENTORY_TAB_CONFIGURE);
		menuManager.removeManagedCustomMenu(RESIZABLE_INVENTORY_TAB_SAVE);
	}

	private void refreshShiftClickCustomizationMenus()
	{
		removeShiftClickCustomizationMenus();
		if (configuringShiftClick)
		{
			menuManager.addManagedCustomMenu(FIXED_INVENTORY_TAB_SAVE);
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE);
			menuManager.addManagedCustomMenu(RESIZABLE_INVENTORY_TAB_SAVE);
		}
		else
		{
			menuManager.addManagedCustomMenu(FIXED_INVENTORY_TAB_CONFIGURE);
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE);
			menuManager.addManagedCustomMenu(RESIZABLE_INVENTORY_TAB_CONFIGURE);
		}
	}

	private void loadCustomSwaps(String config)
	{
		Map<ComparableEntry, ComparableEntry> tmp = new HashMap<>();

		if (!Strings.isNullOrEmpty(config))
		{
			StringBuilder sb = new StringBuilder();

			for (String str : config.split("\n"))
			{
				if (!str.startsWith("//"))
				{
					sb.append(str).append("\n");
				}
			}

			Map<String, String> split = NEWLINE_SPLITTER.withKeyValueSeparator(':').split(sb);

			for (Map.Entry<String, String> entry : split.entrySet())
			{
				String from = entry.getKey();
				String to = entry.getValue();
				String[] splitFrom = Text.standardize(from).split(",");
				String optionFrom = splitFrom[0].trim();
				String targetFrom;
				if (splitFrom.length == 1)
				{
					targetFrom = "";
				}
				else
				{
					targetFrom = splitFrom[1].trim();
				}

				ComparableEntry fromEntry = new ComparableEntry(optionFrom, targetFrom);

				String[] splitTo = Text.standardize(to).split(",");
				String optionTo = splitTo[0].trim();
				String targetTo;
				if (splitTo.length == 1)
				{
					targetTo = "";
				}
				else
				{
					targetTo = splitTo[1].trim();
				}

				ComparableEntry toEntry = new ComparableEntry(optionTo, targetTo);

				tmp.put(fromEntry, toEntry);
			}
		}

		for (Map.Entry<ComparableEntry, ComparableEntry> e : customSwaps.entrySet())
		{
			ComparableEntry key = e.getKey();
			ComparableEntry value = e.getValue();
			menuManager.removeSwap(key, value);
		}

		customSwaps.clear();
		customSwaps.putAll(tmp);

		for (Map.Entry<ComparableEntry, ComparableEntry> entry : customSwaps.entrySet())
		{
			ComparableEntry a1 = entry.getKey();
			ComparableEntry a2 = entry.getValue();
			menuManager.addSwap(a1, a2);
		}
	}

	private void addSwaps()
	{
		if (this.getBurningAmulet)
		{
			menuManager.addSwap("remove", "burning amulet", this.getBurningAmuletMode.toString());
		}

		if (this.teleEquippedCape)
		{
			menuManager.addSwap("remove", "tele to poh", this.telecapeMode.toString());
			menuManager.addSwap("remove", "teleport", this.telecapeMode.toString());
		}

		if (this.getCombatBracelet)
		{
			menuManager.addSwap("remove", "combat bracelet", this.getCombatBraceletMode.toString());
		}

		if (this.getGamesNecklace)
		{
			menuManager.addSwap("remove", "games necklace", this.getGamesNecklaceMode.toString());
		}

		if (this.getDuelingRing)
		{
			menuManager.addSwap("remove", "ring of dueling", this.getDuelingRingMode.toString());
		}

		if (this.getGlory)
		{
			menuManager.addSwap("remove", "amulet of glory", this.getGloryMode.toString());
			menuManager.addSwap("remove", "amulet of eternal glory", this.getGloryMode.toString());
		}

		if (this.getSkillsNecklace)
		{
			menuManager.addSwap("remove", "skills necklace", this.getSkillsNecklaceMode.toString());
		}

		if (this.getNecklaceofPassage)
		{
			menuManager.addSwap("remove", "necklace of passage", this.getNecklaceofPassageMode.toString());
		}

		if (this.getDigsitePendant)
		{
			menuManager.addSwap("remove", "digsite pendant", this.getDigsitePendantMode.toString());
		}

		if (this.getSlayerRing)
		{
			menuManager.addSwap("remove", "slayer ring", this.getSlayerRingMode.toString());
			menuManager.addSwap("remove", "slayer ring (eternal)", this.getSlayerRingMode.toString());
		}

		if (this.getXericsTalisman)
		{
			menuManager.addSwap("remove", "xeric's talisman", this.getXericsTalismanMode.toString());
		}

		if (this.getRingofWealth)
		{
			menuManager.addSwap("remove", "ring of wealth", this.getRingofWealthMode.toString());
		}

		if (this.swapMax)
		{
			menuManager.addSwap("remove", "max cape", this.maxMode.toString());
		}
		if (this.swapQuestCape)
		{
			menuManager.addSwap("remove", "quest point cape", this.questCapeMode.toString());
		}
	}

	private void removeSwaps()
	{
		menuManager.removeSwaps("burning amulet");
		menuManager.removeSwaps("combat bracelet");
		menuManager.removeSwaps("games necklace");
		menuManager.removeSwaps("ring of dueling");
		menuManager.removeSwaps("amulet of glory");
		menuManager.removeSwaps("amulet of eternal glory");
		menuManager.removeSwaps("skills necklace");
		menuManager.removeSwaps("necklace of passage");
		menuManager.removeSwaps("digsite pendant");
		menuManager.removeSwaps("slayer ring");
		menuManager.removeSwaps("xeric's talisman");
		menuManager.removeSwaps("ring of wealth");
		menuManager.removeSwaps("max cape");
		menuManager.removeSwaps("quest point cape");
		
	}

	private void delete(int target)
	{
		for (int i = entries.length - 1; i >= 0; i--)
		{
			if (entries[i].getIdentifier() == target)
			{
				entries = ArrayUtils.remove(entries, i);
				i--;
			}
		}
		client.setMenuEntries(entries);
	}

	private boolean isPuroPuro()
	{
		Player player = client.getLocalPlayer();

		if (player == null)
		{
			return false;
		}
		else
		{
			WorldPoint location = player.getWorldLocation();
			return location.getRegionID() == PURO_PURO_REGION_ID;
		}
	}

	private void loadConstructionItems(String from)
	{
		if (client.getGameState() != GameState.LOGGED_IN
			|| Strings.isNullOrEmpty(from) && leftClickConstructionItems.isEmpty())
		{
			return;
		}

		if (!leftClickConstructionItems.isEmpty())
		{
			for (String s : leftClickConstructionItems)
			{
				menuManager.removePriorityEntry("build", s);
				menuManager.removePriorityEntry("remove", s);
			}

			leftClickConstructionItems.clear();
		}

		if (this.getEasyConstruction &&
			!Strings.isNullOrEmpty(from) &&
			buildingMode)
		{
			for (String s : Text.fromCSV(from))
			{
				if (leftClickConstructionItems.contains(s))
				{
					continue;
				}

				menuManager.addPriorityEntry("build", s);
				menuManager.addPriorityEntry("remove", s);

				leftClickConstructionItems.add(s);
			}
		}
	}

	void startShift()
	{
		if (!this.swapClimbUpDown)
		{
			return;
		}

		menuManager.addPriorityEntry("climb-up");
	}

	void stopShift()
	{
		menuManager.removePriorityEntry("climb-up");
	}

	void startControl()
	{
		if (!this.swapClimbUpDown)
		{
			return;
		}

		menuManager.addPriorityEntry("climb-down");
	}

	void stopControl()
	{
		menuManager.removePriorityEntry("climb-down");
	}

	private void setCastOptions(boolean force)
	{
		clientThread.invoke(() ->
		{
			boolean tmpInCoxRaid = client.getVar(Varbits.IN_RAID) == 1;
			if (tmpInCoxRaid != inCoxRaid || force)
			{
				if (tmpInCoxRaid && this.hideCastCoX)
				{
					client.setHideFriendCastOptions(true);
					client.setHideClanmateCastOptions(true);
					client.setUnhiddenCasts(this.hideCastIgnoredCoX);
				}

				inCoxRaid = tmpInCoxRaid;
			}

			boolean tmpInTobRaid = client.getVar(Varbits.THEATRE_OF_BLOOD) == 2;
			if (tmpInTobRaid != inTobRaid || force)
			{
				if (tmpInTobRaid && this.hideCastToB)
				{
					client.setHideFriendCastOptions(true);
					client.setHideClanmateCastOptions(true);
					client.setUnhiddenCasts(this.hideCastIgnoredToB);
				}

				inTobRaid = tmpInTobRaid;
			}

			if (!inCoxRaid && !inTobRaid)
			{
				resetCastOptions();
			}
		});
	}

	private void resetCastOptions()
	{
		clientThread.invoke(() ->
		{
			if (client.getVar(Varbits.IN_WILDERNESS) == 1 || WorldType.isAllPvpWorld(client.getWorldType()) && pluginManager.isPluginEnabled(pvpTools) && pvpToolsConfig.hideCast())
			{
				pvpTools.setCastOptions();
			}
			else
			{
				client.setHideFriendCastOptions(false);
				client.setHideClanmateCastOptions(false);
			}
		});
	}

	private void updateConfig()
	{
		this.getWithdrawOne = config.getWithdrawOne();
		this.getWithdrawOneItems = config.getWithdrawOneItems();
		this.getWithdrawFive = config.getWithdrawFive();
		this.getWithdrawFiveItems = config.getWithdrawFiveItems();
		this.getWithdrawTen = config.getWithdrawTen();
		this.getWithdrawTenItems = config.getWithdrawTenItems();
		this.getWithdrawX = config.getWithdrawX();
		this.getWithdrawXAmount = config.getWithdrawXAmount();
		this.getWithdrawXItems = config.getWithdrawXItems();
		this.getWithdrawAll = config.getWithdrawAll();
		this.getWithdrawAllItems = config.getWithdrawAllItems();
		this.swapMax = config.swapMax();
		this.teleEquippedCape = config.teleEquippedCape();
		this.telecapeMode = config.telecapeMode();
		this.maxMode = config.maxMode();
		this.getSwapArdougneCape = config.getSwapArdougneCape();
		this.getSwapConstructionCape = config.getSwapConstructionCape();
		this.getSwapCraftingCape = config.getSwapCraftingCape();
		this.getSwapMagicCape = config.getSwapMagicCape();
		this.getSwapExplorersRing = config.getSwapExplorersRing();
		this.swapAdmire = config.swapAdmire();
		this.swapQuestCape = config.swapQuestCape();
		this.questCapeMode = config.questCapeMode();
		this.configCustomSwaps = config.customSwaps();
		this.shiftClickCustomization = config.shiftClickCustomization();
		this.swapCoalBag = config.swapCoalBag();
		this.swapBirdhouseEmpty = config.swapBirdhouseEmpty();
		this.swapBones = config.swapBones();
		this.swapChase = config.swapChase();
		this.swapHarpoon = config.swapHarpoon();
		this.swapOccultMode = config.swapOccultMode();
		this.swapHomePortalMode = config.swapHomePortalMode();
		this.swapPrivate = config.swapPrivate();
		this.swapPick = config.swapPick();
		this.swapQuick = config.swapQuick();
		this.swapBoxTrap = config.swapBoxTrap();
		this.rockCake = config.rockCake();
		this.swapRogueschests = config.swapRogueschests();
		this.swapClimbUpDown = config.swapClimbUpDown();
		this.swapStun = config.swapStun();
		this.swapSearch = config.swapSearch();
		this.swapHardWoodGrove = config.swapHardWoodGrove();
		this.getRemoveObjects = config.getRemoveObjects();
		this.getRemovedObjects = config.getRemovedObjects();
		this.swapImps = config.swapImps();
		this.charterOption = config.charterOption();
		this.getSwapBuyOne = config.getSwapBuyOne();
		this.getBuyOneItems = config.getBuyOneItems();
		this.getSwapBuyFive = config.getSwapBuyFive();
		this.getBuyFiveItems = config.getBuyFiveItems();
		this.getSwapBuyTen = config.getSwapBuyTen();
		this.getBuyTenItems = config.getBuyTenItems();
		this.getSwapBuyFifty = config.getSwapBuyFifty();
		this.getBuyFiftyItems = config.getBuyFiftyItems();
		this.getSwapSellOne = config.getSwapSellOne();
		this.getSellOneItems = config.getSellOneItems();
		this.getSwapSellFive = config.getSwapSellFive();
		this.getSellFiveItems = config.getSellFiveItems();
		this.getSwapSellTen = config.getSwapSellTen();
		this.getSellTenItems = config.getSellTenItems();
		this.getSwapSellFifty = config.getSwapSellFifty();
		this.getSellFiftyItems = config.getSellFiftyItems();
		this.getEasyConstruction = config.getEasyConstruction();
		this.getEasyConstructionItems = config.getEasyConstructionItems();
		this.getSwapSmithing = config.getSwapSmithing();
		this.getSwapTanning = config.getSwapTanning();
		this.getSwapSawmill = config.getSwapSawmill();
		this.getSwapSawmillPlanks = config.getSwapSawmillPlanks();
		this.getSwapPuro = config.getSwapPuro();
		this.swapAssignment = config.swapAssignment();
		this.swapBankExchange = config.swapBankExchange();
		this.swapContract = config.swapContract();
		this.swapInteract = config.swapInteract();
		this.swapPickpocket = config.swapPickpocket();
		this.swapPay = config.swapPay();
		this.swapAbyssTeleport = config.swapAbyssTeleport();
		this.swapTrade = config.swapTrade();
		this.swapTravel = config.swapTravel();
		this.swapMinigame = config.swapMinigame();
		this.swapPlank = config.swapPlank();
		this.swapMetamorphosis = config.swapMetamorphosis();
		this.swapEnchant = config.swapEnchant();
		this.swapFairyRingMode = config.swapFairyRingMode();
		this.swapObeliskMode = config.swapObeliskMode();
		this.swapTeleportItem = config.swapTeleportItem();
		this.swapWildernessLever = config.swapWildernessLever();
		this.swapNexus = config.swapNexus();
		this.getGamesNecklace = config.getGamesNecklace();
		this.getGamesNecklaceMode = config.getGamesNecklaceMode();
		this.getDuelingRing = config.getDuelingRing();
		this.getDuelingRingMode = config.getDuelingRingMode();
		this.getGlory = config.getGlory();
		this.getGloryMode = config.getGloryMode();
		this.getSkillsNecklace = config.getSkillsNecklace();
		this.getSkillsNecklaceMode = config.getSkillsNecklaceMode();
		this.getNecklaceofPassage = config.getNecklaceofPassage();
		this.getNecklaceofPassageMode = config.getNecklaceofPassageMode();
		this.getDigsitePendant = config.getDigsitePendant();
		this.getDigsitePendantMode = config.getDigsitePendantMode();
		this.getCombatBracelet = config.getCombatBracelet();
		this.getCombatBraceletMode = config.getCombatBraceletMode();
		this.getBurningAmulet = config.getBurningAmulet();
		this.getBurningAmuletMode = config.getBurningAmuletMode();
		this.getXericsTalisman = config.getXericsTalisman();
		this.getXericsTalismanMode = config.getXericsTalismanMode();
		this.getRingofWealth = config.getRingofWealth();
		this.getRingofWealthMode = config.getRingofWealthMode();
		this.getSlayerRing = config.getSlayerRing();
		this.getSlayerRingMode = config.getSlayerRingMode();
		this.hideExamine = config.hideExamine();
		this.hideTradeWith = config.hideTradeWith();
		this.hideReport = config.hideReport();
		this.hideLookup = config.hideLookup();
		this.hideNet = config.hideNet();
		this.hideBait = config.hideBait();
		this.hideDestroyRunepouch = config.hideDestroyRunepouch();
		this.hideDestroyCoalbag = config.hideDestroyCoalbag();
		this.hideDestroyHerbsack = config.hideDestroyHerbsack();
		this.hideDestroyBoltpouch = config.hideDestroyBoltpouch();
		this.hideDestroyGembag = config.hideDestroyGembag();
		this.hideDropRunecraftingPouch = config.hideDropRunecraftingPouch();
		this.hideCastToB = config.hideCastToB();
		this.hideCastIgnoredToB = Sets.newHashSet(Text.fromCSV(config.hideCastIgnoredToB().toLowerCase()));
		this.hideCastCoX = config.hideCastCoX();
		this.hideCastIgnoredCoX = Sets.newHashSet(Text.fromCSV(config.hideCastIgnoredCoX().toLowerCase()));
	}
}
