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
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.AbstractComparableEntry;
import static net.runelite.client.menus.ComparableEntries.newBankComparableEntry;
import static net.runelite.client.menus.ComparableEntries.newBaseComparableEntry;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.menuentryswapper.util.BurningAmuletMode;
import net.runelite.client.plugins.menuentryswapper.util.CharterOption;
import net.runelite.client.plugins.menuentryswapper.util.CombatBraceletMode;
import net.runelite.client.plugins.menuentryswapper.util.ConstructionCapeMode;
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
import net.runelite.client.plugins.menuentryswapper.util.QuestCapeMode;
import net.runelite.client.plugins.menuentryswapper.util.RingOfWealthMode;
import net.runelite.client.plugins.menuentryswapper.util.SkillsNecklaceMode;
import net.runelite.client.plugins.menuentryswapper.util.SlayerRingMode;
import net.runelite.client.plugins.menuentryswapper.util.XericsTalismanMode;
import net.runelite.client.plugins.pvptools.PvpToolsConfig;
import net.runelite.client.plugins.pvptools.PvpToolsPlugin;
import static net.runelite.client.util.MenuUtil.swap;
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
	private static final String CONFIG_GROUP = "shiftclick";
	private static final String ITEM_KEY_PREFIX = "item_";
	private static final int PURO_PURO_REGION_ID = 10307;
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
		MenuAction.NPC_FIRST_OPTION, MenuAction.NPC_SECOND_OPTION, MenuAction.NPC_THIRD_OPTION,
		MenuAction.NPC_FOURTH_OPTION, MenuAction.NPC_FIFTH_OPTION, MenuAction.EXAMINE_NPC
	);
	private static final Splitter NEWLINE_SPLITTER = Splitter
		.on("\n")
		.omitEmptyStrings()
		.trimResults();

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
	private EventBus eventBus;
	@Inject
	private PvpToolsPlugin pvpTools;
	@Inject
	private PvpToolsConfig pvpToolsConfig;
	private MenuEntry[] entries;
	private final Set<String> leftClickConstructionItems = new HashSet<>();
	private boolean buildingMode;
	private boolean inTobRaid = false;
	private boolean inCoxRaid = false;
	private final Map<AbstractComparableEntry, AbstractComparableEntry> customSwaps = new HashMap<>();
	private List<String> bankItemNames = new ArrayList<>();
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
	private MaxCapeMode maxMode;
	private boolean getSwapArdougneCape;
	private boolean getSwapConstructionCape;
	private ConstructionCapeMode constructionCapeMode;
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
	private boolean hideDestroyLootingBag;
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
		addSubscriptions();
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
		eventBus.unregister(this);

		disableCustomization();
		loadConstructionItems("");
		loadCustomSwaps(""); // Removes all custom swaps
		removeSwaps();

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			resetCastOptions();
		}
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(WidgetMenuOptionClicked.class, this, this::onWidgetMenuOptionClicked);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(MenuOpened.class, this, this::onMenuOpened);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(PostItemDefinition.class, this, this::onPostItemDefinition);
		eventBus.subscribe(FocusChanged.class, this, this::onFocusChanged);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!"menuentryswapper".equals(event.getGroup()))
		{
			return;
		}

		removeSwaps();
		updateConfig();
		addSwaps();
		loadConstructionItems(this.getEasyConstructionItems);

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

	private void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
	{
		if (event.getWidget() == WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB
			|| event.getWidget() == WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB
			|| event.getWidget() == WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB)
		{
			configuringShiftClick = event.getMenuOption().equals(CONFIGURE) && Text.removeTags(event.getMenuTarget()).equals(MENU_TARGET);
			refreshShiftClickCustomizationMenus();
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		loadConstructionItems(this.getEasyConstructionItems);
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		buildingMode = client.getVar(BUILDING_MODE) == 1;

		setCastOptions(false);
	}

	private void onMenuOpened(MenuOpened event)
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
				if (this.hideDestroyLootingBag && entry.getTarget().contains("Looting bag"))
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
		int shiftClickActionIndex = itemComposition.getShiftClickActionIndex();
		String[] inventoryActions = itemComposition.getInventoryActions();

		if (shiftClickActionIndex >= 0 && shiftClickActionIndex < inventoryActions.length)
		{
			option = inventoryActions[shiftClickActionIndex];
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

	private void onMenuOptionClicked(MenuOptionClicked event)
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
				case "crystal impling jar":
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

		if (this.shiftClickCustomization && shiftModifier && !option.equals("use"))
		{
			Integer customOption = getSwapConfig(eventId);

			if (customOption != null && customOption == -1)
			{
				menuManager.addPriorityEntry("Use");
			}
			else
			{
				menuManager.removePriorityEntry("Use");
			}
		}
	}

	private void onPostItemDefinition(PostItemDefinition event)
	{
		ItemDefinition itemComposition = event.getItemDefinition();
		Integer option = getSwapConfig(itemComposition.getId());

		if (option != null)
		{
			itemComposition.setShiftClickActionIndex(option);
		}
	}

	private void onFocusChanged(FocusChanged event)
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
		Map<AbstractComparableEntry, AbstractComparableEntry> tmp = new HashMap<>();

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

				AbstractComparableEntry fromEntry = newBaseComparableEntry(optionFrom, targetFrom);

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

				AbstractComparableEntry toEntry = newBaseComparableEntry(optionTo, targetTo);

				tmp.put(fromEntry, toEntry);
			}
		}

		for (Map.Entry<AbstractComparableEntry, AbstractComparableEntry> e : customSwaps.entrySet())
		{
			AbstractComparableEntry key = e.getKey();
			AbstractComparableEntry value = e.getValue();
			menuManager.removeSwap(key, value);
		}

		customSwaps.clear();
		customSwaps.putAll(tmp);

		for (Map.Entry<AbstractComparableEntry, AbstractComparableEntry> entry : customSwaps.entrySet())
		{
			AbstractComparableEntry a1 = entry.getKey();
			AbstractComparableEntry a2 = entry.getValue();
			menuManager.addSwap(a1, a2);
		}
	}

	private void addSwaps()
	{
		if (this.getBurningAmulet)
		{
			menuManager.addPriorityEntry(this.getBurningAmuletMode.toString(), "burning amulet");
		}

		if (this.getWithdrawOne)
		{
			Text.fromCSV(this.getWithdrawOneItems).forEach(item ->
			{
				menuManager.addPriorityEntry(newBankComparableEntry("Withdraw-1", item)).setPriority(10);
				menuManager.addPriorityEntry(newBankComparableEntry("Deposit-1", item)).setPriority(10);
			});
		}

		if (this.getWithdrawFive)
		{
			Text.fromCSV(this.getWithdrawFiveItems).forEach(item ->
			{
				menuManager.addPriorityEntry(newBankComparableEntry("Withdraw-5", item)).setPriority(10);
				menuManager.addPriorityEntry(newBankComparableEntry("Deposit-5", item)).setPriority(10);
			});
		}

		if (this.getWithdrawTen)
		{
			Text.fromCSV(this.getWithdrawTenItems).forEach(item ->
			{
				menuManager.addPriorityEntry(newBankComparableEntry("Withdraw-10", item)).setPriority(10);
				menuManager.addPriorityEntry(newBankComparableEntry("Deposit-10", item)).setPriority(10);
			});
		}

		if (this.getWithdrawX)
		{
			Text.fromCSV(this.getWithdrawXItems).forEach(item ->
			{
				menuManager.addPriorityEntry(newBankComparableEntry("Withdraw-" + this.getWithdrawXAmount, item)).setPriority(10);
				menuManager.addPriorityEntry(newBankComparableEntry("Deposit-" + this.getWithdrawXAmount, item)).setPriority(10);
			});
		}

		if (this.getWithdrawAll)
		{
			Text.fromCSV(this.getWithdrawAllItems).forEach(item ->
			{
				menuManager.addPriorityEntry(newBankComparableEntry("Withdraw-All", item)).setPriority(10);
				menuManager.addPriorityEntry(newBankComparableEntry("Deposit-All", item)).setPriority(10);
			});
		}

		if (this.getSwapBuyOne)
		{
			Text.fromCSV(this.getBuyOneItems).forEach(item -> menuManager.addPriorityEntry("Buy 1", item).setPriority(100));
		}

		if (this.getSwapBuyFive)
		{
			Text.fromCSV(this.getBuyFiveItems).forEach(item -> menuManager.addPriorityEntry("Buy 5", item).setPriority(100));
		}

		if (this.getSwapBuyTen)
		{
			Text.fromCSV(this.getBuyTenItems).forEach(item -> menuManager.addPriorityEntry("Buy 10", item).setPriority(100));
		}

		if (this.getSwapBuyFifty)
		{
			Text.fromCSV(this.getBuyFiftyItems).forEach(item -> menuManager.addPriorityEntry("Buy 50", item).setPriority(100));
		}

		if (this.getSwapSellOne)
		{
			Text.fromCSV(this.getSellOneItems).forEach(item -> menuManager.addPriorityEntry("Sell 1", item).setPriority(100));
		}

		if (this.getSwapSellFive)
		{
			Text.fromCSV(this.getSellFiveItems).forEach(item -> menuManager.addPriorityEntry("Sell 5", item).setPriority(100));
		}

		if (this.getSwapSellTen)
		{
			Text.fromCSV(this.getSellTenItems).forEach(item -> menuManager.addPriorityEntry("Sell 10", item).setPriority(100));
		}

		if (this.getSwapSellFifty)
		{
			Text.fromCSV(this.getSellFiftyItems).forEach(item -> menuManager.addPriorityEntry("Sell 50", item).setPriority(100));
		}

		if (this.getSwapTanning)
		{
			menuManager.addPriorityEntry("Tan All");
		}

		if (this.getSwapSawmill)
		{
			menuManager.addPriorityEntry("Buy-plank", "Sawmill operator");
		}

		if (this.getSwapSawmillPlanks)
		{
			//Not much we can do for this one, Buy all is the only thing, there is no target.
			menuManager.addPriorityEntry("Buy All").setPriority(10);
		}

		if (this.getSwapArdougneCape)
		{
			menuManager.addPriorityEntry("Kandarin Monastery");
			menuManager.addPriorityEntry("Monastery Teleport");
		}

		if (this.getSwapCraftingCape)
		{
			menuManager.addPriorityEntry("Teleport", "Crafting cape");
			menuManager.addPriorityEntry("Teleport", "Crafting cape(t)");
		}

		if (this.getSwapConstructionCape)
		{
			menuManager.addPriorityEntry(this.constructionCapeMode.toString(), "Construct. cape");
			menuManager.addPriorityEntry(this.constructionCapeMode.toString(), "Construct. cape(t)");
		}

		if (this.getSwapMagicCape)
		{
			menuManager.addPriorityEntry("Spellbook", "Magic cape");
			menuManager.addPriorityEntry("Spellbook", "Magic cape(t)");
		}

		if (this.getSwapExplorersRing)
		{
			menuManager.addPriorityEntry("Teleport", "Explorer's ring 2");
			menuManager.addPriorityEntry("Teleport", "Explorer's ring 3");
			menuManager.addPriorityEntry("Teleport", "Explorer's ring 4");
		}

		if (this.swapPickpocket)
		{
			menuManager.addPriorityEntry("Pickpocket").setPriority(1);
		}

		if (this.swapHardWoodGrove)
		{
			menuManager.addPriorityEntry("Send-parcel", "Rionasta");
		}

		if (this.swapBankExchange)
		{
			menuManager.addPriorityEntry("Bank").setPriority(1);
			menuManager.addPriorityEntry("Exchange").setPriority(10);
		}

		if (this.swapContract)
		{
			menuManager.addPriorityEntry("Contract").setPriority(10);
		}

		if (this.swapInteract)
		{
			menuManager.addPriorityEntry("Repairs").setPriority(10);
			menuManager.addPriorityEntry("Claim-slime").setPriority(10);
			menuManager.addPriorityEntry("Decant").setPriority(10);
			menuManager.addPriorityEntry("Claim").setPriority(10);
			menuManager.addPriorityEntry("Heal").setPriority(10);
			menuManager.addPriorityEntry("Help").setPriority(10);
		}

		if (this.swapAssignment)
		{
			menuManager.addPriorityEntry("Assignment");
		}

		if (this.swapPlank)
		{
			menuManager.addPriorityEntry("Buy-plank").setPriority(10);
		}

		if (this.swapTrade)
		{
			menuManager.addPriorityEntry("Trade").setPriority(1);
			menuManager.addPriorityEntry("Trade-with").setPriority(1);
			menuManager.addPriorityEntry("Shop").setPriority(1);
		}

		if (this.swapMinigame)
		{
			menuManager.addPriorityEntry("Story");
			menuManager.addPriorityEntry("Escort");
			menuManager.addPriorityEntry("Dream");
			menuManager.addPriorityEntry("Start-minigame");
		}

		if (this.swapTravel)
		{
			menuManager.addPriorityEntry("Travel");
			menuManager.addPriorityEntry("Pay-fare");
			menuManager.addPriorityEntry("Charter");
			menuManager.addPriorityEntry("Take-boat");
			menuManager.addPriorityEntry("Fly");
			menuManager.addPriorityEntry("Jatizso");
			menuManager.addPriorityEntry("Neitiznot");
			menuManager.addPriorityEntry("Rellekka");
			menuManager.addPriorityEntry("Follow", "Elkoy").setPriority(10);
			menuManager.addPriorityEntry("Transport");
			menuManager.addPriorityEntry("Teleport", "Mage of zamorak").setPriority(10);
		}

		if (this.swapPay)
		{
			menuManager.addPriorityEntry("Pay");
			menuManager.addPriorityEntry("Pay (");
		}

		if (this.swapQuick)
		{
			menuManager.addPriorityEntry("Quick-travel");
		}

		if (this.swapEnchant)
		{
			menuManager.addPriorityEntry("Enchant");
		}

		if (this.swapWildernessLever)
		{
			menuManager.addPriorityEntry("Edgeville", "Lever");
		}

		if (this.swapMetamorphosis)
		{
			menuManager.addPriorityEntry("Metamorphosis", "Baby chinchompa");
		}

		if (this.swapStun)
		{
			menuManager.addPriorityEntry("Stun", "Hoop snake");
		}

		if (this.swapTravel)
		{
			menuManager.addPriorityEntry("Pay-toll(2-ecto)", "Energy barrier");
			menuManager.addPriorityEntry("Pay-toll(10gp)", "Gate");
			menuManager.addPriorityEntry("Travel", "Trapdoor");
		}

		if (this.swapHarpoon)
		{
			menuManager.addPriorityEntry("Harpoon");
		}

		if (this.swapBoxTrap)
		{
			menuManager.addPriorityEntry("Reset", "Box trap");
			menuManager.addPriorityEntry("Lay", "Box trap");
			menuManager.addPriorityEntry("Activate", "Box trap");
		}

		if (this.swapChase)
		{
			menuManager.addPriorityEntry("Chase");
		}

		if (this.swapBirdhouseEmpty)
		{
			menuManager.addPriorityEntry("Empty", "Birdhouse");
			menuManager.addPriorityEntry("Empty", "Oak Birdhouse");
			menuManager.addPriorityEntry("Empty", "Willow Birdhouse");
			menuManager.addPriorityEntry("Empty", "Teak Birdhouse");
			menuManager.addPriorityEntry("Empty", "Maple Birdhouse");
			menuManager.addPriorityEntry("Empty", "Mahogany Birdhouse");
			menuManager.addPriorityEntry("Empty", "Yew Birdhouse");
			menuManager.addPriorityEntry("Empty", "Magic Birdhouse");
			menuManager.addPriorityEntry("Empty", "Redwood Birdhouse");
		}

		if (this.swapQuick)
		{
			menuManager.addPriorityEntry("Quick-enter");
			menuManager.addPriorityEntry("Quick-start");
			menuManager.addPriorityEntry("Quick-pass");
			menuManager.addPriorityEntry("Quick-open");
			menuManager.addPriorityEntry("Quick-leave");
		}

		if (this.swapAdmire)
		{
			menuManager.addPriorityEntry("Teleport", "Mounted Strength Cape").setPriority(10);
			menuManager.addPriorityEntry("Teleport", "Mounted Construction Cape").setPriority(10);
			menuManager.addPriorityEntry("Teleport", "Mounted Crafting Cape").setPriority(10);
			menuManager.addPriorityEntry("Teleport", "Mounted Hunter Cape").setPriority(10);
			menuManager.addPriorityEntry("Teleport", "Mounted Fishing Cape").setPriority(10);
			menuManager.addPriorityEntry("Spellbook", "Mounted Magic Cape");
			menuManager.addPriorityEntry("Perks", "Mounted Max Cape");
		}

		if (this.swapPrivate)
		{
			menuManager.addPriorityEntry("Private");
		}

		if (this.swapPick)
		{
			menuManager.addPriorityEntry("Pick-lots");
		}

		if (this.swapSearch)
		{
			menuManager.addPriorityEntry("Search");
		}

		if (this.swapRogueschests)
		{
			menuManager.addPriorityEntry("Search for traps");
		}

		if (this.rockCake)
		{
			menuManager.addPriorityEntry("Guzzle", "Dwarven rock cake");
		}

		if (this.swapTeleportItem)
		{
			menuManager.addSwap("Wear", "", "Rub");
			menuManager.addSwap("Wield", "", "Rub");
			menuManager.addSwap("Wear", "", "Teleport");
			menuManager.addSwap("Wield", "", "Teleport");
		}

		if (this.swapCoalBag)
		{
			menuManager.addPriorityEntry("Fill", "Coal bag");
			menuManager.addPriorityEntry(new BankComparableEntry("Empty", "Coal bag"));
		}

		if (this.swapBones)
		{
			menuManager.addSwap("Bury", "", "Use");
		}

		if (this.swapNexus)
		{
			menuManager.addPriorityEntry("Teleport menu", "Portal nexus");
		}

		switch (this.swapFairyRingMode)
		{
			case OFF:
			case ZANARIS:
				menuManager.removeSwaps("Fairy ring");
				menuManager.removeSwaps("Tree");
				break;
			case CONFIGURE:
				menuManager.addPriorityEntry("Configure", "Fairy ring");
				break;
			case LAST_DESTINATION:
				menuManager.addPriorityEntry("Last-destination");
				break;
		}

		switch (this.swapOccultMode)
		{
			case LUNAR:
				menuManager.addPriorityEntry("Lunar", "Altar of the Occult");
				break;
			case ANCIENT:
				menuManager.addPriorityEntry("Ancient", "Altar of the Occult");
				break;
			case ARCEUUS:
				menuManager.addPriorityEntry("Arceuus", "Altar of the Occult");
				break;
		}

		switch (this.swapObeliskMode)
		{
			case SET_DESTINATION:
				menuManager.addPriorityEntry("Set destination", "Obelisk");
				break;
			case TELEPORT_TO_DESTINATION:
				menuManager.addPriorityEntry("Teleport to destination", "Obelisk");
				break;
		}

		switch (this.swapHomePortalMode)
		{
			case HOME:
				menuManager.addPriorityEntry("Home");
				break;
			case BUILD_MODE:
				menuManager.addPriorityEntry("Build mode");
				break;
			case FRIENDS_HOUSE:
				menuManager.addPriorityEntry("Friend's house");
				break;
		}

		if (this.swapHardWoodGrove)
		{
			menuManager.addPriorityEntry("Quick-pay(100)", "Hardwood grove doors");
		}

		if (this.getCombatBracelet)
		{
			menuManager.addPriorityEntry(this.getCombatBraceletMode.toString());
		}

		if (this.getGamesNecklace)
		{
			menuManager.addPriorityEntry(this.getGamesNecklaceMode.toString());
		}

		if (this.getDuelingRing)
		{
			menuManager.addPriorityEntry(this.getDuelingRingMode.toString());
		}

		if (this.getGlory)
		{
			menuManager.addPriorityEntry(this.getGloryMode.toString());
			menuManager.addPriorityEntry(this.getGloryMode.toString());
		}

		if (this.getSkillsNecklace)
		{
			menuManager.addPriorityEntry(this.getSkillsNecklaceMode.toString());
		}

		if (this.getNecklaceofPassage)
		{
			menuManager.addPriorityEntry(this.getNecklaceofPassageMode.toString());
		}

		if (this.getDigsitePendant)
		{
			menuManager.addPriorityEntry(this.getDigsitePendantMode.toString());
		}

		if (this.getSlayerRing)
		{
			menuManager.addPriorityEntry(this.getSlayerRingMode.toString());
			menuManager.addPriorityEntry(this.getSlayerRingMode.toString());
		}

		if (this.getXericsTalisman)
		{
			menuManager.addPriorityEntry(this.getXericsTalismanMode.toString());
		}

		if (this.getRingofWealth)
		{
			menuManager.addPriorityEntry(this.getRingofWealthMode.toString());
		}

		if (this.swapMax)
		{
			menuManager.addPriorityEntry(this.maxMode.toString(), "max cape");
		}
		if (this.swapQuestCape)
		{
			menuManager.addPriorityEntry(this.questCapeMode.toString(), "quest point cape");
		}
	}

	private void removeSwaps()
	{
		Text.fromCSV(this.getWithdrawOneItems).forEach(item ->
		{
			menuManager.removePriorityEntry("Withdraw-1", item);
			menuManager.removePriorityEntry("Deposit-1", item);
		});
		Text.fromCSV(this.getWithdrawFiveItems).forEach(item ->
		{
			menuManager.removePriorityEntry("Withdraw-5", item);
			menuManager.removePriorityEntry("Deposit-5", item);
		});
		Text.fromCSV(this.getWithdrawTenItems).forEach(item ->
		{
			menuManager.removePriorityEntry("Withdraw-10", item);
			menuManager.removePriorityEntry("Deposit-10", item);
		});
		Text.fromCSV(this.getWithdrawXItems).forEach(item ->
		{
			menuManager.removePriorityEntry("Withdraw-" + this.getWithdrawXAmount, item);
			menuManager.removePriorityEntry("Deposit-" + this.getWithdrawXAmount, item);
		});
		Text.fromCSV(this.getWithdrawAllItems).forEach(item ->
		{
			menuManager.removePriorityEntry("Withdraw-All", item);
			menuManager.removePriorityEntry("Deposit-All", item);
		});
		Text.fromCSV(this.getBuyOneItems).forEach(item -> menuManager.removePriorityEntry("Buy 1", item));
		Text.fromCSV(this.getBuyFiveItems).forEach(item -> menuManager.removePriorityEntry("Buy 5", item));
		Text.fromCSV(this.getBuyTenItems).forEach(item -> menuManager.removePriorityEntry("Buy 10", item));
		Text.fromCSV(this.getBuyFiftyItems).forEach(item -> menuManager.removePriorityEntry("Buy 50", item));
		Text.fromCSV(this.getSellOneItems).forEach(item -> menuManager.removePriorityEntry("Sell 1", item));
		Text.fromCSV(this.getSellFiveItems).forEach(item -> menuManager.removePriorityEntry("Sell 5", item));
		Text.fromCSV(this.getSellTenItems).forEach(item -> menuManager.removePriorityEntry("Sell 10", item));
		Text.fromCSV(this.getSellFiftyItems).forEach(item -> menuManager.removePriorityEntry("Sell 50", item));
		menuManager.removeSwaps("Fairy ring");
		menuManager.removeSwaps("Tree");
		menuManager.removePriorityEntry(this.getGloryMode.toString());
		menuManager.removePriorityEntry(this.getGloryMode.toString());
		menuManager.removePriorityEntry(this.getSkillsNecklaceMode.toString());
		menuManager.removePriorityEntry(this.getNecklaceofPassageMode.toString());
		menuManager.removePriorityEntry(this.getDigsitePendantMode.toString());
		menuManager.removePriorityEntry(this.getSlayerRingMode.toString());
		menuManager.removePriorityEntry(this.getSlayerRingMode.toString());
		menuManager.removePriorityEntry(this.getXericsTalismanMode.toString());
		menuManager.removePriorityEntry(this.getRingofWealthMode.toString());
		menuManager.removePriorityEntry(this.maxMode.toString(), "max cape");
		menuManager.removePriorityEntry(this.questCapeMode.toString(), "quest point cape");
		menuManager.removePriorityEntry("Smith All");
		menuManager.removePriorityEntry("Smith All Sets");
		menuManager.removePriorityEntry("Tan All");
		menuManager.removePriorityEntry("Buy-plank", "Sawmill operator");
		menuManager.removePriorityEntry("Buy All");
		menuManager.removePriorityEntry("Kandarin Monastery");
		menuManager.removePriorityEntry("Monastery Teleport");
		menuManager.removePriorityEntry("Teleport", "Crafting cape");
		menuManager.removePriorityEntry("Teleport", "Crafting cape(t)");
		menuManager.removePriorityEntry("Tele to poh", "Construct. cape");
		menuManager.removePriorityEntry("Tele to poh", "Construct. cape(t)");
		menuManager.removePriorityEntry("Spellbook", "Magic cape");
		menuManager.removePriorityEntry("Spellbook", "Magic cape(t)");
		menuManager.removePriorityEntry("Teleport", "Explorer's ring 2");
		menuManager.removePriorityEntry("Teleport", "Explorer's ring 3");
		menuManager.removePriorityEntry("Teleport", "Explorer's ring 4");
		menuManager.removePriorityEntry("Pickpocket");
		menuManager.removePriorityEntry("Send-parcel", "Rionasta");
		menuManager.removePriorityEntry("Bank");
		menuManager.removePriorityEntry("Exchange");
		menuManager.removePriorityEntry("Contract");
		menuManager.removePriorityEntry("Repairs");
		menuManager.removePriorityEntry("Claim-slime");
		menuManager.removePriorityEntry("Decant");
		menuManager.removePriorityEntry("Claim");
		menuManager.removePriorityEntry("Heal");
		menuManager.removePriorityEntry("Help");
		menuManager.removePriorityEntry("Assignment");
		menuManager.removePriorityEntry("Buy-plank");
		menuManager.removePriorityEntry("Trade");
		menuManager.removePriorityEntry("Trade-with");
		menuManager.removePriorityEntry("Shop");
		menuManager.removePriorityEntry("Story");
		menuManager.removePriorityEntry("Escort");
		menuManager.removePriorityEntry("Dream");
		menuManager.removePriorityEntry("Start-minigame");
		menuManager.removePriorityEntry("Travel");
		menuManager.removePriorityEntry("Pay-fare");
		menuManager.removePriorityEntry("Charter");
		menuManager.removePriorityEntry("Take-boat");
		menuManager.removePriorityEntry("Fly");
		menuManager.removePriorityEntry("Jatizso");
		menuManager.removePriorityEntry("Neitiznot");
		menuManager.removePriorityEntry("Rellekka");
		menuManager.removePriorityEntry("Follow");
		menuManager.removePriorityEntry("Transport");
		menuManager.removePriorityEntry("Teleport", "Mage of zamorak");
		menuManager.removePriorityEntry("Pay");
		menuManager.removePriorityEntry("Pay (");
		menuManager.removePriorityEntry("Quick-travel");
		menuManager.removePriorityEntry("Enchant");
		menuManager.removePriorityEntry("Edgeville", "Lever");
		menuManager.removePriorityEntry("Metamorphosis", "Baby chinchompa");
		menuManager.removePriorityEntry("Stun", "Hoop snake");
		menuManager.removePriorityEntry("Pay-toll(2-ecto)", "Energy barrier");
		menuManager.removePriorityEntry("Pay-toll(10gp)", "Gate");
		menuManager.removePriorityEntry("Travel", "Trapdoor");
		menuManager.removePriorityEntry("Harpoon");
		menuManager.removePriorityEntry("Reset", "Box trap");
		menuManager.removePriorityEntry("Lay", "Box trap");
		menuManager.removePriorityEntry("Activate", "Box trap");
		menuManager.removePriorityEntry("Chase");
		menuManager.removePriorityEntry("Empty", "Birdhouse");
		menuManager.removePriorityEntry("Empty", "Oak Birdhouse");
		menuManager.removePriorityEntry("Empty", "Willow Birdhouse");
		menuManager.removePriorityEntry("Empty", "Teak Birdhouse");
		menuManager.removePriorityEntry("Empty", "Maple Birdhouse");
		menuManager.removePriorityEntry("Empty", "Mahogany Birdhouse");
		menuManager.removePriorityEntry("Empty", "Yew Birdhouse");
		menuManager.removePriorityEntry("Empty", "Magic Birdhouse");
		menuManager.removePriorityEntry("Empty", "Redwood Birdhouse");
		menuManager.removePriorityEntry("Quick-enter");
		menuManager.removePriorityEntry("Quick-start");
		menuManager.removePriorityEntry("Quick-pass");
		menuManager.removePriorityEntry("Quick-open");
		menuManager.removePriorityEntry("Quick-enter");
		menuManager.removePriorityEntry("Quick-leave");
		menuManager.removePriorityEntry("Teleport", "Mounted Strength Cape");
		menuManager.removePriorityEntry("Teleport", "Mounted Construction Cape");
		menuManager.removePriorityEntry("Teleport", "Mounted Crafting Cape");
		menuManager.removePriorityEntry("Teleport", "Mounted Hunter Cape");
		menuManager.removePriorityEntry("Teleport", "Mounted Fishing Cape");
		menuManager.removePriorityEntry("Spellbook", "Mounted Magic Cape");
		menuManager.removePriorityEntry("Empty", "Coal bag");
		menuManager.removePriorityEntry("Fill", "Coal bag");
		menuManager.removePriorityEntry("Perks", "Mounted Max Cape");
		menuManager.removePriorityEntry("Private");
		menuManager.removePriorityEntry("Pick-lots");
		menuManager.removePriorityEntry("Search");
		menuManager.removePriorityEntry("Search for traps");
		menuManager.removePriorityEntry("Guzzle", "Dwarven rock cake");
		menuManager.removeSwap("Wear", "", "Rub");
		menuManager.removeSwap("Wield", "", "Rub");
		menuManager.removeSwap("Wear", "", "Teleport");
		menuManager.removeSwap("Wield", "", "Teleport");

		switch (this.swapFairyRingMode)
		{
			case OFF:
			case ZANARIS:
				menuManager.removeSwaps("Fairy ring");
				menuManager.removeSwaps("Tree");
				break;
			case CONFIGURE:
				menuManager.removePriorityEntry("Configure", "Fairy ring");
				break;
			case LAST_DESTINATION:
				menuManager.removePriorityEntry("Last-destination");
				break;
		}

		switch (this.swapOccultMode)
		{
			case LUNAR:
				menuManager.removePriorityEntry("Lunar", "Altar of the Occult");
				break;
			case ANCIENT:
				menuManager.removePriorityEntry("Ancient", "Altar of the Occult");
				break;
			case ARCEUUS:
				menuManager.removePriorityEntry("Arceuus", "Altar of the Occult");
				break;
		}

		switch (this.swapObeliskMode)
		{
			case SET_DESTINATION:
				menuManager.removePriorityEntry("Set destination", "Obelisk");
				break;
			case TELEPORT_TO_DESTINATION:
				menuManager.removePriorityEntry("Teleport to destination", "Obelisk");
				break;
		}

		switch (this.swapHomePortalMode)
		{
			case HOME:
				menuManager.removePriorityEntry("Home");
				break;
			case BUILD_MODE:
				menuManager.removePriorityEntry("Build mode");
				break;
			case FRIENDS_HOUSE:
				menuManager.removePriorityEntry("Friend's house");
				break;
		}
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
			leftClickConstructionItems.forEach(item ->
			{
				menuManager.removePriorityEntry("build", item);
				menuManager.removePriorityEntry("remove", item);
			});

			leftClickConstructionItems.clear();
		}

		if (this.getEasyConstruction && !Strings.isNullOrEmpty(from) && buildingMode)
		{
			Text.fromCSV(from).forEach(item ->
			{
				if (leftClickConstructionItems.contains(item))
				{
					return;
				}

				menuManager.addPriorityEntry("build", item);
				menuManager.addPriorityEntry("remove", item);

				leftClickConstructionItems.add(item);
			});
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
		this.maxMode = config.maxMode();
		this.getSwapArdougneCape = config.getSwapArdougneCape();
		this.getSwapConstructionCape = config.getSwapConstructionCape();
		this.constructionCapeMode = config.constructionCapeMode();
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
		this.hideDestroyLootingBag = config.hideDestroyLootingBag();
		this.hideDestroyGembag = config.hideDestroyGembag();
		this.hideDropRunecraftingPouch = config.hideDropRunecraftingPouch();
		this.hideCastToB = config.hideCastToB();
		this.hideCastIgnoredToB = Sets.newHashSet(Text.fromCSV(config.hideCastIgnoredToB().toLowerCase()));
		this.hideCastCoX = config.hideCastCoX();
		this.hideCastIgnoredCoX = Sets.newHashSet(Text.fromCSV(config.hideCastIgnoredCoX().toLowerCase()));
	}
}
