/*
 * Copyright (c) 2020, Kyle <https://github.com/xKylee>
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
package net.runelite.client.plugins.menuentryswapperextended;

import static com.google.common.base.Predicates.alwaysTrue;
import static com.google.common.base.Predicates.equalTo;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javax.inject.Inject;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.KeyCode;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.VarClientInt;
import net.runelite.api.Varbits;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.menuentryswapperextended.util.BurningAmuletMode;
import net.runelite.client.plugins.menuentryswapperextended.util.BuyMode;
import net.runelite.client.plugins.menuentryswapperextended.util.CombatBraceletMode;
import net.runelite.client.plugins.menuentryswapperextended.util.ConstructionCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.CraftingCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.CustomSwaps;
import net.runelite.client.plugins.menuentryswapperextended.util.DiaryCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.DigsitePendantMode;
import net.runelite.client.plugins.menuentryswapperextended.util.DuelingRingMode;
import net.runelite.client.plugins.menuentryswapperextended.util.FarmCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.GamesNecklaceMode;
import net.runelite.client.plugins.menuentryswapperextended.util.GloryMode;
import net.runelite.client.plugins.menuentryswapperextended.util.MagicCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.MaxCapeEquippedMode;
import net.runelite.client.plugins.menuentryswapperextended.util.NecklaceOfPassageMode;
import net.runelite.client.plugins.menuentryswapperextended.util.QuestCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.RingOfWealthMode;
import net.runelite.client.plugins.menuentryswapperextended.util.SellMode;
import net.runelite.client.plugins.menuentryswapperextended.util.SkillsNecklaceMode;
import net.runelite.client.plugins.menuentryswapperextended.util.Swap;
import net.runelite.client.plugins.menuentryswapperextended.util.XericsTalismanMode;

@PluginDescriptor(
	name = "Menu Entry Swapper Extended",
	enabledByDefault = false,
	description = "Change the default option that is displayed when hovering over objects",
	tags = {"pickpocket", "equipped items", "inventory", "items", "equip", "construction", "custom", "swap", "extended"}
)
public class MenuEntrySwapperExtendedPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private MenuEntrySwapperExtendedConfig config;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private MenuManager menuManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	public EventBus eventBus;

	@Inject
	private CustomSwaps customSwaps;

	private static <T extends Comparable<? super T>> void sortedInsert(List<T> list, T value) // NOPMD: UnusedPrivateMethod: false positive
	{
		int idx = Collections.binarySearch(list, value);
		list.add(idx < 0 ? -idx - 1 : idx, value);
	}

	List<String> targetList;
	List<String> optionsList;

	private static final Set<MenuAction> NPC_MENU_TYPES = ImmutableSet.of(
		MenuAction.NPC_FIRST_OPTION,
		MenuAction.NPC_SECOND_OPTION,
		MenuAction.NPC_THIRD_OPTION,
		MenuAction.NPC_FOURTH_OPTION,
		MenuAction.NPC_FIFTH_OPTION,
		MenuAction.EXAMINE_NPC);

	private final Multimap<String, Swap> swaps = Multimaps
		.synchronizedSetMultimap(LinkedHashMultimap.create());
	private final ArrayListMultimap<String, Integer> optionIndexes = ArrayListMultimap.create();

	private List<String> bankItemNames = new ArrayList<>();
	private List<String> hideAttackIgnoredNPCs = new ArrayList<>();
	private List<String> hideCastIgnoredSpells = new ArrayList<>();

	private boolean atRunecraftingAltar;

	@Provides
	MenuEntrySwapperExtendedConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MenuEntrySwapperExtendedConfig.class);
	}

	@Override
	public void startUp()
	{
		parseOldFormatConfig();
		eventBus.register(customSwaps);
		customSwaps.startup();

		loadSwaps();
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(customSwaps);
		customSwaps.shutdown();
		swaps.clear();
	}

	public Swap swap(String option, String swappedOption, Supplier<Boolean> enabled)
	{
		return swap(option, alwaysTrue(), swappedOption, enabled);
	}

	public Swap swap(String option, String target, String swappedOption, Supplier<Boolean> enabled)
	{
		return swap(option, equalTo(target), swappedOption, enabled);
	}

	public Swap swap(String option, Predicate<String> targetPredicate, String swappedOption, Supplier<Boolean> enabled)
	{
		Swap swap = new Swap(alwaysTrue(), targetPredicate, swappedOption, enabled, true);
		swaps.put(option, swap);
		return swap;
	}

	public Swap swapContains(String option, Predicate<String> targetPredicate, String swappedOption, Supplier<Boolean> enabled)
	{
		Swap swap = new Swap(alwaysTrue(), targetPredicate, swappedOption, enabled, false);
		swaps.put(option, swap);
		return swap;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!"menuentryswapperextended".equals(event.getGroup()))
		{
			return;
		}

		loadSwaps();
	}

	@Subscribe
	public void onMenuEntryAdded(final MenuEntryAdded menuEntryAdded)
	{
		if (config.getEasyConstruction() &&
			(client.getVarbitValue(2176) == 1 ||
				menuEntryAdded.getType() == MenuAction.GAME_OBJECT_FIFTH_OPTION.getId()))
		{
			final MenuEntry[] menuEntries = client.getMenuEntries();
			swapConstructionMenu(menuEntries);
			return;
		}

		if (config.swapEmptyPouch() &&
			atRunecraftingAltar &&
			menuEntryAdded.getType() == MenuAction.ITEM_FIRST_OPTION.getId() &&
			menuEntryAdded.getTarget().endsWith("pouch"))
		{
			final MenuEntry[] menuEntries = client.getMenuEntries();

			final MenuEntry firstEntry = menuEntries[menuEntries.length - 1];

			menuEntries[menuEntries.length - 1] = menuEntries[menuEntries.length - 2];
			menuEntries[menuEntries.length - 2] = firstEntry;

			client.setMenuEntries(menuEntries);
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged gameStateChanged)
	{
		if (config.swapEmptyPouch() && gameStateChanged.getGameState() == GameState.LOADING)
		{
			atRunecraftingAltar = AltarRegion.IDS.contains(client.getMapRegions()[0]);
		}
	}

	private void swapMenuEntry(int index, MenuEntry menuEntry)
	{
		final int eventId = menuEntry.getIdentifier();
		final MenuAction menuAction = menuEntry.getType();
		final String option = Text.removeTags(menuEntry.getOption()).toLowerCase();
		final String target = Text.removeTags(menuEntry.getTarget()).toLowerCase();
		final NPC hintArrowNpc = client.getHintArrowNpc();

		if (hintArrowNpc != null
			&& hintArrowNpc.getIndex() == eventId
			&& NPC_MENU_TYPES.contains(menuAction))
		{
			return;
		}

		final boolean itemOp = menuEntry.isItemOp();
		// Custom shift-click item swap
		if (shiftModifier() && itemOp)
		{
			// don't perform swaps on items when shift is held; instead prefer the client menu swap, which
			// we may have overwrote
			return;
		}

		Collection<Swap> swaps = this.swaps.get(option);
		for (Swap swap : swaps)
		{
			if (swap.getTargetPredicate().test(target) && swap.getEnabled().get())
			{
				if (swap(swap.getSwappedOption(), target, index, swap.isStrict()))
				{
					break;
				}
			}
		}
	}

	@Subscribe(priority = -1)
	public void onClientTick(ClientTick clientTick)
	{
		// The menu is not rebuilt when it is open, so don't swap or else it will
		// repeatedly swap entries
		if (client.getGameState() != GameState.LOGGED_IN || client.isMenuOpen())
		{
			return;
		}

		MenuEntry[] menuEntries = client.getMenuEntries();

		// Build option map for quick lookup in findIndex
		int idx = 0;
		optionIndexes.clear();
		for (MenuEntry entry : menuEntries)
		{
			String option = Text.removeTags(entry.getOption()).toLowerCase();
			optionIndexes.put(option, idx++);
		}

		// Perform swaps
		idx = 0;
		for (MenuEntry entry : menuEntries)
		{
			swapMenuEntry(idx++, entry);
		}

		client.setMenuEntries(updateMenuEntries(client.getMenuEntries()));
	}

	private boolean swap(String option, String target, int index, boolean strict)
	{
		MenuEntry[] menuEntries = client.getMenuEntries();

		// find option to swap with
		int optionIdx = findIndex(menuEntries, index, option, target, strict);

		if (optionIdx >= 0)
		{
			swap(optionIndexes, menuEntries, optionIdx, index);
			return true;
		}

		return false;
	}

	private int findIndex(MenuEntry[] entries, int limit, String option, String target, boolean strict)
	{
		if (strict)
		{
			List<Integer> indexes = optionIndexes.get(option);

			// We want the last index which matches the target, as that is what is top-most
			// on the menu
			for (int i = indexes.size() - 1; i >= 0; --i)
			{
				int idx = indexes.get(i);
				MenuEntry entry = entries[idx];
				String entryTarget = Text.removeTags(entry.getTarget()).toLowerCase();

				// Limit to the last index which is prior to the current entry
				if (idx < limit && entryTarget.equals(target))
				{
					return idx;
				}
			}
		}
		else
		{
			// Without strict matching we have to iterate all entries up to the current limit...
			for (int i = limit - 1; i >= 0; i--)
			{
				MenuEntry entry = entries[i];
				String entryOption = Text.removeTags(entry.getOption()).toLowerCase();
				String entryTarget = Text.removeTags(entry.getTarget()).toLowerCase();

				if (entryOption.contains(option.toLowerCase()) && entryTarget.equals(target))
				{
					return i;
				}
			}

		}

		return -1;
	}

	private void swap(ArrayListMultimap<String, Integer> optionIndexes, MenuEntry[] entries, int index1, int index2)
	{
		if (index1 == index2)
		{
			return;
		}

		Widget eq = client.getWidget(WidgetInfo.EQUIPMENT);
		if (client.getVar(VarClientInt.INVENTORY_TAB) == 4 && eq != null)
		{
			MenuEntry[] clonedEntries = new MenuEntry[entries.length];
			System.arraycopy(entries, 0, clonedEntries, 0, entries.length);

			MenuEntry entry1 = entries[index1];
			MenuEntry entry2 = entries[index2];

			int temp = entry1.getType().getId();
			entry1.setType(entry2.getType());
			entry2.setType(MenuAction.of(temp));

			clonedEntries[index1] = entry2;
			clonedEntries[index2] = entry1;

			client.setMenuEntries(clonedEntries);

			String option1 = Text.removeTags(entry1.getOption()).toLowerCase(),
				option2 = Text.removeTags(entry2.getOption()).toLowerCase();

			List<Integer> list1 = optionIndexes.get(option1),
				list2 = optionIndexes.get(option2);

			list1.remove((Integer) index1);
			list2.remove((Integer) index2);

			sortedInsert(list1, index2);
			sortedInsert(list2, index1);
		}
		else
		{
			MenuEntry entry1 = entries[index1],
				entry2 = entries[index2];

			entries[index1] = entry2;
			entries[index2] = entry1;

			// Item op4 and op5 are CC_OP_LOW_PRIORITY so they get added underneath Use,
			// but this also causes them to get sorted after client tick. Change them to
			// CC_OP to avoid this.
			if (entry1.isItemOp() && entry1.getType() == MenuAction.CC_OP_LOW_PRIORITY)
			{
				entry1.setType(MenuAction.CC_OP);
			}
			if (entry2.isItemOp() && entry2.getType() == MenuAction.CC_OP_LOW_PRIORITY)
			{
				entry2.setType(MenuAction.CC_OP);
			}

			client.setMenuEntries(entries);

			// Update optionIndexes
			String option1 = Text.removeTags(entry1.getOption()).toLowerCase(),
				option2 = Text.removeTags(entry2.getOption()).toLowerCase();

			List<Integer> list1 = optionIndexes.get(option1),
				list2 = optionIndexes.get(option2);

			// call remove(Object) instead of remove(int)
			list1.remove((Integer) index1);
			list2.remove((Integer) index2);

			sortedInsert(list1, index2);
			sortedInsert(list2, index1);
		}
	}

	private boolean shiftModifier()
	{
		return client.isKeyPressed(KeyCode.KC_SHIFT);
	}

	private Predicate<String> targetSwap(String string)
	{
		return (in) -> in.toLowerCase().contains(string);
	}

	private void addSwaps()
	{
		for (String option : new String[]{"attack", "talk-to"})
		{
			swapContains(option, (s) -> true, "pickpocket", config::swapPickpocket);
		}

		swap("remove", targetSwap("burning amulet"), "chaos temple", () ->
			config.getBurningAmulet() && config.getBurningAmuletMode() == BurningAmuletMode.CHAOS_TEMPLE);
		swap("remove", targetSwap("burning amulet"), "bandit camp", () ->
			config.getBurningAmulet() && config.getBurningAmuletMode() == BurningAmuletMode.BANDIT_CAMP);
		swap("remove", targetSwap("burning amulet"), "lava maze", () ->
			config.getBurningAmulet() && config.getBurningAmuletMode() == BurningAmuletMode.LAVA_MAZE);

		swap("remove", targetSwap("combat bracelet"), "warriors' guild", () ->
			config.getCombatBracelet() && config.getCombatBraceletMode() == CombatBraceletMode.WARRIORS_GUILD);
		swap("remove", targetSwap("combat bracelet"), "champions' guild", () ->
			config.getCombatBracelet() && config.getCombatBraceletMode() == CombatBraceletMode.CHAMPIONS_GUILD);
		swap("remove", targetSwap("combat bracelet"), "edgeville monastery", () ->
			config.getCombatBracelet() && config.getCombatBraceletMode() == CombatBraceletMode.EDGEVILLE_MONASTERY);
		swap("remove", targetSwap("combat bracelet"), "ranging guild", () ->
			config.getCombatBracelet() && config.getCombatBraceletMode() == CombatBraceletMode.RANGING_GUILD);

		swap("remove", targetSwap("games necklace"), "burthorpe", () ->
			config.getGamesNecklace() && config.getGamesNecklaceMode() == GamesNecklaceMode.BURTHORPE);
		swap("remove", targetSwap("games necklace"), "barbarian outpost", () ->
			config.getGamesNecklace() && config.getGamesNecklaceMode() == GamesNecklaceMode.BARBARIAN_OUTPOST);
		swap("remove", targetSwap("games necklace"), "corporeal beast", () ->
			config.getGamesNecklace() && config.getGamesNecklaceMode() == GamesNecklaceMode.CORPOREAL_BEAST);
		swap("remove", targetSwap("games necklace"), "tears of guthix", () ->
			config.getGamesNecklace() && config.getGamesNecklaceMode() == GamesNecklaceMode.TEARS_OF_GUTHIX);
		swap("remove", targetSwap("games necklace"), "wintertodt camp", () ->
			config.getGamesNecklace() && config.getGamesNecklaceMode() == GamesNecklaceMode.WINTER);

		swap("remove", targetSwap("ring of dueling"), "duel arena", () ->
			config.getDuelingRing() && config.getDuelingRingMode() == DuelingRingMode.DUEL_ARENA);
		swap("remove", targetSwap("ring of dueling"), "castle wars", () ->
			config.getDuelingRing() && config.getDuelingRingMode() == DuelingRingMode.CASTLE_WARS);
		swap("remove", targetSwap("ring of dueling"), "ferox enclave", () ->
			config.getDuelingRing() && config.getDuelingRingMode() == DuelingRingMode.FEROX_ENCLAVE);

		swap("remove", targetSwap("amulet of glory"), "edgeville", () ->
			config.getGlory() && config.getGloryMode() == GloryMode.EDGEVILLE);
		swap("remove", targetSwap("amulet of glory"), "karamja", () ->
			config.getGlory() && config.getGloryMode() == GloryMode.KARAMJA);
		swap("remove", targetSwap("amulet of glory"), "al kharid", () ->
			config.getGlory() && config.getGloryMode() == GloryMode.AL_KHARID);
		swap("remove", targetSwap("amulet of glory"), "draynor village", () ->
			config.getGlory() && config.getGloryMode() == GloryMode.DRAYNOR_VILLAGE);
		swap("remove", targetSwap("amulet of eternal glory"), "edgeville", () ->
			config.getGlory() && config.getGloryMode() == GloryMode.EDGEVILLE);
		swap("remove", targetSwap("amulet of eternal glory"), "karamja", () ->
			config.getGlory() && config.getGloryMode() == GloryMode.KARAMJA);
		swap("remove", targetSwap("amulet of eternal glory"), "al kharid", () ->
			config.getGlory() && config.getGloryMode() == GloryMode.AL_KHARID);
		swap("remove", targetSwap("amulet of eternal glory"), "draynor village", () ->
			config.getGlory() && config.getGloryMode() == GloryMode.DRAYNOR_VILLAGE);

		swap("remove", targetSwap("skills necklace"), "fishing guild", () ->
			config.getSkillsNecklace() && config.getSkillsNecklaceMode() == SkillsNecklaceMode.FISHING_GUILD);
		swap("remove", targetSwap("skills necklace"), "mining guild", () ->
			config.getSkillsNecklace() && config.getSkillsNecklaceMode() == SkillsNecklaceMode.MINING_GUILD);
		swap("remove", targetSwap("skills necklace"), "farming guild", () ->
			config.getSkillsNecklace() && config.getSkillsNecklaceMode() == SkillsNecklaceMode.FARMING_GUILD);
		swap("remove", targetSwap("skills necklace"), "cooking guild", () ->
			config.getSkillsNecklace() && config.getSkillsNecklaceMode() == SkillsNecklaceMode.COOKING_GUILD);
		swap("remove", targetSwap("skills necklace"), "woodcutting guild", () ->
			config.getSkillsNecklace() & config.getSkillsNecklaceMode() == SkillsNecklaceMode.WOODCUTTING_GUILD);
		swap("remove", targetSwap("skills necklace"), "crafting guild", () ->
			config.getSkillsNecklace() && config.getSkillsNecklaceMode() == SkillsNecklaceMode.CRAFTING_GUILD);

		swap("remove", targetSwap("necklace of passage"), "wizards' tower", () ->
			config.getNecklaceofPassage() && config.getNecklaceofPassageMode() == NecklaceOfPassageMode.WIZARDS_TOWER);
		swap("remove", targetSwap("necklace of passage"), "the outpost", () ->
			config.getNecklaceofPassage() && config.getNecklaceofPassageMode() == NecklaceOfPassageMode.THE_OUTPOST);
		swap("remove", targetSwap("necklace of passage"), "eagles' eyrie", () ->
			config.getNecklaceofPassage() && config.getNecklaceofPassageMode() == NecklaceOfPassageMode.EAGLES_EYRIE);

		swap("remove", targetSwap("digsite pendant"), "digsite", () ->
			config.getDigsitePendant() && config.getDigsitePendantMode() == DigsitePendantMode.DIGSITE);
		swap("remove", targetSwap("digsite pendant"), "fossil island", () ->
			config.getDigsitePendant() && config.getDigsitePendantMode() == DigsitePendantMode.FOSSIL_ISLAND);
		swap("remove", targetSwap("digsite pendant"), "lithkren dungeon", () ->
			config.getDigsitePendant() && config.getDigsitePendantMode() == DigsitePendantMode.LITHKREN);

		swap("remove", targetSwap("ring of wealth"), "miscellania", () ->
			config.getRingofWealth() && config.getRingofWealthMode() == RingOfWealthMode.MISCELLANIA);
		swap("remove", targetSwap("ring of wealth"), "grand exchange", () ->
			config.getRingofWealth() && config.getRingofWealthMode() == RingOfWealthMode.GRAND_EXCHANGE);
		swap("remove", targetSwap("ring of wealth"), "falador", () ->
			config.getRingofWealth() && config.getRingofWealthMode() == RingOfWealthMode.FALADOR);
		swap("remove", targetSwap("ring of wealth"), "dondakan", () ->
			config.getRingofWealth() && config.getRingofWealthMode() == RingOfWealthMode.DONDAKAN);

		swap("remove", targetSwap("talisman"), "xeric's glade", () ->
			config.getXericsTalisman() && config.getXericsTalismanMode() == XericsTalismanMode.XERICS_GLADE);
		swap("remove", targetSwap("talisman"), "xeric's lookout", () ->
			config.getXericsTalisman() && config.getXericsTalismanMode() == XericsTalismanMode.XERICS_LOOKOUT);
		swap("remove", targetSwap("talisman"), "xeric's inferno", () ->
			config.getXericsTalisman() && config.getXericsTalismanMode() == XericsTalismanMode.XERICS_INFERNO);
		swap("remove", targetSwap("talisman"), "xeric's heart", () ->
			config.getXericsTalisman() && config.getXericsTalismanMode() == XericsTalismanMode.XERICS_HEART);
		swap("remove", targetSwap("talisman"), "xeric's honour", () ->
			config.getXericsTalisman() && config.getXericsTalismanMode() == XericsTalismanMode.XERICS_HONOUR);

		swap("wear", targetSwap("crafting cape"), "teleport", () ->
			config.getCraftingCapeMode() == CraftingCapeMode.INVENTORY || config.getCraftingCapeMode() == CraftingCapeMode.ALWAYS);
		swap("remove", targetSwap("crafting cape"), "teleport", () ->
			config.getCraftingCapeMode() == CraftingCapeMode.EQUIPPED || config.getCraftingCapeMode() == CraftingCapeMode.ALWAYS);

		swap("wear", targetSwap("construct."), "tele to poh", () ->
			config.getConstructionCapeMode() == ConstructionCapeMode.INVENTORY || config.getConstructionCapeMode() == ConstructionCapeMode.ALWAYS);
		swap("remove", targetSwap("construct."), "tele to poh", () ->
			config.getConstructionCapeMode() == ConstructionCapeMode.EQUIPPED || config.getConstructionCapeMode() == ConstructionCapeMode.ALWAYS);

		swap("wear", targetSwap("quest point cape"), "teleport", () ->
			config.getQuestCapeMode() == QuestCapeMode.INVENTORY || config.getQuestCapeMode() == QuestCapeMode.ALWAYS);
		swap("remove", targetSwap("quest point cape"), "teleport", () ->
			config.getQuestCapeMode() == QuestCapeMode.EQUIPPED || config.getQuestCapeMode() == QuestCapeMode.ALWAYS);

		swap("wear", targetSwap("achievement diary cape"), "teleport", () ->
			config.getDiaryCapeMode() == DiaryCapeMode.INVENTORY || config.getDiaryCapeMode() == DiaryCapeMode.ALWAYS);
		swap("remove", targetSwap("achievement diary cape"), "teleport", () ->
			config.getDiaryCapeMode() == DiaryCapeMode.EQUIPPED || config.getDiaryCapeMode() == DiaryCapeMode.ALWAYS);

		swap("wear", targetSwap("farming cape"), "teleport", () ->
			config.getFarmingCapeMode() == FarmCapeMode.INVENTORY || config.getFarmingCapeMode() == FarmCapeMode.ALWAYS);
		swap("remove", targetSwap("farming cape"), "teleport", () ->
			config.getFarmingCapeMode() == FarmCapeMode.EQUIPPED || config.getFarmingCapeMode() == FarmCapeMode.ALWAYS);

		swap("wear", targetSwap("magic cape"), "spellbook", () ->
			config.getMagicCapeMode() == MagicCapeMode.INVENTORY || config.getMagicCapeMode() == MagicCapeMode.ALWAYS);
		swap("remove", targetSwap("magic cape"), "spellbook", () ->
			config.getMagicCapeMode() == MagicCapeMode.EQUIPPED || config.getMagicCapeMode() == MagicCapeMode.ALWAYS);

		swap("remove", targetSwap("max cape"), "tele to poh", () ->
			config.getMaxCapeEquippedMode() == MaxCapeEquippedMode.TELE_TO_POH);
		swap("remove", targetSwap("max cape"), "crafting guild", () ->
			config.getMaxCapeEquippedMode() == MaxCapeEquippedMode.CRAFTING_GUILD);
		swap("remove", targetSwap("max cape"), "warriors' guild", () ->
			config.getMaxCapeEquippedMode() == MaxCapeEquippedMode.WARRIORS_GUILD);
		swap("remove", targetSwap("max cape"), "fishing teleports", () ->
			config.getMaxCapeEquippedMode() == MaxCapeEquippedMode.FISHING_TELEPORTS);
		swap("remove", targetSwap("max cape"), "poh portals", () ->
			config.getMaxCapeEquippedMode() == MaxCapeEquippedMode.POH_PORTRALS);
		swap("remove", targetSwap("max cape"), "other teleports", () ->
			config.getMaxCapeEquippedMode() == MaxCapeEquippedMode.OTHER_TELEPORTS);
		swap("remove", targetSwap("max cape"), "spellbook", () ->
			config.getMaxCapeEquippedMode() == MaxCapeEquippedMode.SPELLBOOK);
		swap("remove", targetSwap("max cape"), "features", () ->
			config.getMaxCapeEquippedMode() == MaxCapeEquippedMode.FEATURES);

		swap("value", "buy 1", () -> config.shopBuy() == BuyMode.BUY_1);
		swap("value", "buy 5", () -> config.shopBuy() == BuyMode.BUY_5);
		swap("value", "buy 10", () -> config.shopBuy() == BuyMode.BUY_10);
		swap("value", "buy 50", () -> config.shopBuy() == BuyMode.BUY_50);

		swap("value", "sell 1", () -> config.shopSell() == SellMode.SELL_1);
		swap("value", "sell 5", () -> config.shopSell() == SellMode.SELL_5);
		swap("value", "sell 10", () -> config.shopSell() == SellMode.SELL_10);
		swap("value", "sell 50", () -> config.shopSell() == SellMode.SELL_50);

		swap("value", "buy-1", () -> config.swapTobBuys());
	}

	private void loadSwaps()
	{
		addSwaps();
		loadConstructionItems();
		hideAttackIgnoredNPCs = Text.fromCSV(config.hideAttackIgnoredNPCs().toLowerCase().trim());
		hideCastIgnoredSpells = Text.fromCSV(config.hideCastIgnoredSpells().toLowerCase().trim());
	}

	private void loadConstructionItems()
	{
		targetList = config.getConstructionMode().getTargetList();
		optionsList = config.getConstructionMode().getOptionsList();
	}

	private void swapConstructionMenu(MenuEntry[] menuEntries)
	{
		for (MenuEntry menuEntry : menuEntries)
		{
			if (validConstructionSwap(menuEntry))
			{
				createConstructionMenu(menuEntry);
			}
		}
	}

	public boolean validConstructionSwap(MenuEntry menuEntry)
	{
		return (matchesConstructionOption(menuEntry) && matchesConstructionTarget(menuEntry));
	}

	public boolean matchesConstructionOption(MenuEntry menuEntry)
	{
		return config.getConstructionMode().getOptionsList().stream()
			.anyMatch(Text.standardize(menuEntry.getOption())::contains);
	}

	public boolean matchesConstructionTarget(MenuEntry menuEntry)
	{
		return config.getConstructionMode().getTargetList().stream()
			.anyMatch(Text.standardize(menuEntry.getTarget())::contains);
	}

	private void createConstructionMenu(MenuEntry menuEntry)
	{
		MenuEntry[] newEntries = new MenuEntry[1];

		newEntries[0] = menuEntry;

		client.setMenuEntries(newEntries);
	}

	private final Predicate<MenuEntry> filterMenuEntries = entry ->
	{
		String option = Text.removeTags(entry.getOption()).toLowerCase();
		//String target = Text.removeTags(entry.getTarget()).toLowerCase();
		String target = Text.standardize(entry.getTarget(), true);

		if (config.hideTradeWith() && option.contains("trade with"))
		{
			return false;
		}

		if (config.hideEmpty() && option.contains("empty"))
		{
			return !entry.getTarget().contains("potion") && !entry.getTarget().contains("Antidote")
				&& !entry.getTarget().contains("venom") && !entry.getTarget().contains("antifire")
				&& !entry.getTarget().contains("Antipoison") && !entry.getTarget()
				.contains("Superantipoison")
				&& !entry.getTarget().contains("Saradomin brew") && !entry.getTarget()
				.contains("Super restore")
				&& !entry.getTarget().contains("Zamorak brew") && !entry.getTarget()
				.contains("Guthix rest");
		}

		if (config.hideDestroy() && option.contains("destroy") && target.contains("rune pouch"))
		{
			return false;
		}

		if (config.hideExamine() && option.contains("examine"))
		{
			return false;
		}

		if (config.hideLootImpJars() && target.contains("impling") && option.contains("loot"))
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
			switch (target)
			{
				case "gourmet impling jar":
					if (client.getItemContainer(InventoryID.INVENTORY) != null)
					{
						for (Item i : Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems())
						{
							invItemNames.add(client.getItemDefinition((i.getId())).getName());
						}
						if ((invItemNames.contains("Clue scroll (easy)") || bankItemNames.contains("Clue scroll (easy)")))
						{
							return false;
						}
					}
					break;
				case "young impling jar":
					if (client.getItemContainer(InventoryID.INVENTORY) != null)
					{
						for (Item i : Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems())
						{
							invItemNames.add(client.getItemDefinition((i.getId())).getName());
						}
						if (invItemNames.contains("Clue scroll (beginner)") || bankItemNames.contains("Clue scroll (beginner)")
							|| (invItemNames.contains("Clue scroll (easy)") || bankItemNames.contains("Clue scroll (easy)")))
						{
							return false;
						}
					}
					break;
				case "eclectic impling jar":
					if (client.getItemContainer(InventoryID.INVENTORY) != null)
					{
						for (Item i : Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems())
						{
							invItemNames.add(client.getItemDefinition((i.getId())).getName());
						}
						if ((invItemNames.contains("Clue scroll (medium)") || bankItemNames.contains("Clue scroll (medium)")))
						{
							return false;
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
							return false;
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
							return false;
						}
					}
					break;
			}
		}

		if (config.hideAttack() && entry.getType().getId() == MenuAction.NPC_SECOND_OPTION.getId())
		{
			NPC npc = client.getCachedNPCs()[entry.getIdentifier()];
			if (npc != null && npc.getName() != null && npc.getHealthRatio() == 0 && !hideAttackIgnoredNPCs.contains(Text.standardize(npc.getName())))
			{
				return false;
			}
		}

		if (config.hideCastRaids() && (client.getVarbitValue(Varbits.IN_RAID) == 1 || client.getVarbitValue(Varbits.THEATRE_OF_BLOOD) == 2))
		{
			if (client.getSpellSelected() && !hideCastIgnoredSpells.contains(Text.standardize(client.getSelectedSpellName())) && entry.getType().getId() == MenuAction.WIDGET_TARGET_ON_PLAYER.getId())
			{
				return false;
			}
		}

		if (config.hideCastThralls() && target.contains("thrall") && entry.getType().getId() == MenuAction.WIDGET_TARGET_ON_NPC.getId())
		{
			return false;
		}

		return true;
	};

	private MenuEntry[] updateMenuEntries(MenuEntry[] menuEntries)
	{
		return Arrays.stream(menuEntries)
			.filter(filterMenuEntries).sorted((o1, o2) -> 0)
			.toArray(MenuEntry[]::new);
	}

	private void parseOldFormatConfig()
	{
		if (config.customSwapsString().trim().isEmpty())
		{
			return;
		}

		// LOAD OLD FORMAT CUSTOM SWAPS
		StringBuilder newFormatString = new StringBuilder();
		for (String oldFormat : config.customSwapsString().trim().split("\n"))
		{
			oldFormat = oldFormat.split(":")[0];
			newFormatString.append(oldFormat).append("\n");
		}

		if (newFormatString.length() > 0)
		{
			configManager.setConfiguration("menuentryswapperextended", "customSwaps", newFormatString);
		}
	}

	@RequiredArgsConstructor
	private enum AltarRegion
	{
		AIR(11082),
		COSMIC(8266),
		WATER(10570),
		EARTH(10314),
		NATURE(9290),
		FIRE(10059),
		BLOOD(12618),
		LAW(9546),
		DEATH(8522),
		CHAOS(8778),
		BODY(9802),
		ASTRAL(8508),
		MIND(10826);

		private static final Set<Integer> IDS = new HashSet<>(12 + 1, 1.0f);

		static
		{
			Arrays.stream(AltarRegion.values()).mapToInt(r -> r.id).forEach(IDS::add);
		}

		private final int id;
	}
}
