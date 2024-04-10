/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Kamiel
 * Copyright (c) 2019, Rami <https://github.com/Rami-J>
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

import com.google.common.annotations.VisibleForTesting;
import static com.google.common.base.Predicates.alwaysTrue;
import static com.google.common.base.Predicates.equalTo;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.KeyCode;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.ParamID;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.PostItemComposition;
import net.runelite.api.events.PostMenuSort;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.game.NpcUtil;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperConfig.ArdougneCloakMode;
import static net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperConfig.DesertAmuletMode;
import static net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperConfig.KaramjaGlovesMode;
import static net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperConfig.MorytaniaLegsMode;
import static net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperConfig.RadasBlessingMode;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Menu Entry Swapper",
	description = "Change the default option that is displayed when hovering over objects",
	tags = {"npcs", "inventory", "items", "objects"},
	enabledByDefault = false
)
@Slf4j
public class MenuEntrySwapperPlugin extends Plugin
{
	private static final String SHIFTCLICK_CONFIG_GROUP = "shiftclick";
	private static final String ITEM_KEY_PREFIX = "item_";
	private static final String OBJECT_KEY_PREFIX = "object_";
	private static final String OBJECT_SHIFT_KEY_PREFIX = "object_shift_";
	private static final String NPC_KEY_PREFIX = "npc_";
	private static final String NPC_SHIFT_KEY_PREFIX = "npc_shift_";
	private static final String WORN_ITEM_KEY_PREFIX = "wornitem_";
	private static final String WORN_ITEM_SHIFT_KEY_PREFIX = "wornitem_shift_";
	private static final String UI_KEY_PREFIX = "ui_";
	private static final String UI_SHIFT_KEY_PREFIX = "ui_shift_";

	private static final List<MenuAction> NPC_MENU_TYPES = ImmutableList.of(
		MenuAction.NPC_FIRST_OPTION,
		MenuAction.NPC_SECOND_OPTION,
		MenuAction.NPC_THIRD_OPTION,
		MenuAction.NPC_FOURTH_OPTION,
		MenuAction.NPC_FIFTH_OPTION
	);

	private static final List<MenuAction> OBJECT_MENU_TYPES = ImmutableList.of(
		MenuAction.GAME_OBJECT_FIRST_OPTION,
		MenuAction.GAME_OBJECT_SECOND_OPTION,
		MenuAction.GAME_OBJECT_THIRD_OPTION,
		MenuAction.GAME_OBJECT_FOURTH_OPTION,
		MenuAction.GAME_OBJECT_FIFTH_OPTION
	);

	private static final Set<String> ESSENCE_MINE_NPCS = ImmutableSet.of(
		"aubury",
		"archmage sedridor",
		"wizard distentor",
		"wizard cromperty",
		"brimstail"
	);

	private static final Set<String> TEMPOROSS_NPCS = ImmutableSet.of(
		"captain dudi",
		"captain pudi",
		"first mate deri",
		"first mate peri"
	);

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private MenuEntrySwapperConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private NpcUtil npcUtil;

	private final Multimap<String, Swap> swaps = LinkedHashMultimap.create();
	private final ArrayListMultimap<String, Integer> optionIndexes = ArrayListMultimap.create();

	@Provides
	MenuEntrySwapperConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MenuEntrySwapperConfig.class);
	}

	@Override
	public void startUp()
	{
		setupSwaps();
		removeOldSwaps();
	}

	@Override
	public void shutDown()
	{
		swaps.clear();
	}

	@VisibleForTesting
	void setupSwaps()
	{
		swap("talk-to", "mage of zamorak", "teleport", config::swapAbyssTeleport);
		swap("talk-to", "bank", config::swapBank);
		swap("talk-to", "exchange", config::swapExchange);
		swap("talk-to", "help", config::swapHelp);
		// make sure assignment swap is higher priority than trade swap for slayer masters
		swap("talk-to", "assignment", config::swapAssignment);
		swap("talk-to", "trade", config::swapTrade);
		swap("talk-to", "trade-with", config::swapTrade);
		swap("talk-to", "shop", config::swapTrade);
		swap("talk-to", "travel", config::swapTravel);
		swap("talk-to", "pay-fare", config::swapTravel);
		swap("talk-to", "charter", config::swapTravel);
		swap("talk-to", "take-boat", config::swapTravel);
		swap("talk-to", "fly", config::swapTravel);
		swap("talk-to", "jatizso", config::swapTravel);
		swap("talk-to", "neitiznot", config::swapTravel);
		swap("talk-to", "rellekka", config::swapTravel);
		swap("talk-to", "ungael", config::swapTravel);
		swap("talk-to", "pirate's cove", config::swapTravel);
		swap("talk-to", "waterbirth island", config::swapTravel);
		swap("talk-to", "island of stone", config::swapTravel);
		swap("talk-to", "miscellania", config::swapTravel);
		swap("talk-to", "follow", config::swapTravel);
		swap("talk-to", "transport", config::swapTravel);
		swap("talk-to", "pay", config::swapPay);
		swapContains("talk-to", alwaysTrue(), "pay (", config::swapPay);
		swap("talk-to", "quick-travel", config::swapQuick);
		swap("talk-to", ESSENCE_MINE_NPCS::contains, "teleport", config::swapEssenceMineTeleport);
		swap("talk-to", "deposit-items", config::swapDepositItems);
		swap("talk-to", TEMPOROSS_NPCS::contains, "leave", config::swapTemporossLeave);

		swap("pass", "energy barrier", "pay-toll(2-ecto)", config::swapTravel);
		swap("open", "gate", "pay-toll(10gp)", config::swapTravel);

		swap("inspect", "trapdoor", "travel", config::swapTravel);
		swap("board", "travel cart", "pay-fare", config::swapTravel);

		swap("board", "sacrificial boat", "quick-board", config::swapQuick);

		swap("cage", "harpoon", config::swapHarpoon);
		swap("big net", "harpoon", config::swapHarpoon);
		swap("net", "harpoon", config::swapHarpoon);

		swap("lure", "bait", config::swapBait);
		swap("net", "bait", config::swapBait);
		swap("small net", "bait", config::swapBait);

		swap("enter", "portal", "home", () -> config.swapHomePortal() == HouseMode.HOME);
		swap("enter", "portal", "build mode", () -> config.swapHomePortal() == HouseMode.BUILD_MODE);
		swap("enter", "portal", "friend's house", () -> config.swapHomePortal() == HouseMode.FRIENDS_HOUSE);

		for (String option : new String[]{"zanaris", "tree"})
		{
			swapContains(option, alwaysTrue(), "last-destination", () -> config.swapFairyRing() == FairyRingMode.LAST_DESTINATION);
			swapContains(option, alwaysTrue(), "configure", () -> config.swapFairyRing() == FairyRingMode.CONFIGURE);
		}

		swapContains("configure", alwaysTrue(), "last-destination", () ->
			config.swapFairyRing() == FairyRingMode.LAST_DESTINATION || config.swapFairyRing() == FairyRingMode.ZANARIS);
		swapContains("tree", alwaysTrue(), "zanaris", () -> config.swapFairyRing() == FairyRingMode.ZANARIS);

		swap("check", "reset", config::swapBoxTrap);
		swap("dismantle", "reset", config::swapBoxTrap);
		swap("take", "lay", config::swapBoxTrap);

		swap("pick-up", "chase", config::swapChase);

		swap("interact", target -> target.endsWith("birdhouse"), "empty", config::swapBirdhouseEmpty);

		swap("enter", "quick-enter", config::swapQuick);
		swap("enter-crypt", "quick-enter", config::swapQuick);
		swap("ring", "quick-start", config::swapQuick);
		swap("pass", "quick-pass", config::swapQuick);
		swap("pass", "quick pass", config::swapQuick);
		swap("open", "quick-open", config::swapQuick);
		swap("climb-down", "quick-start", config::swapQuick);
		swap("climb-down", "pay", config::swapQuick);

		swap("admire", "teleport", config::swapAdmire);
		swap("admire", "spellbook", config::swapAdmire);
		swap("admire", "perks", config::swapAdmire);

		swap("teleport menu", "pvp arena", config::swapJewelleryBox);
		swap("teleport menu", "castle wars", config::swapJewelleryBox);
		swap("teleport menu", "ferox enclave", config::swapJewelleryBox);
		swap("teleport menu", "fortis colosseum", config::swapJewelleryBox);
		swap("teleport menu", "burthorpe", config::swapJewelleryBox);
		swap("teleport menu", "barbarian outpost", config::swapJewelleryBox);
		swap("teleport menu", "corporeal beast", config::swapJewelleryBox);
		swap("teleport menu", "tears of guthix", config::swapJewelleryBox);
		swap("teleport menu", "wintertodt camp", config::swapJewelleryBox);
		swap("teleport menu", "warriors' guild", config::swapJewelleryBox);
		swap("teleport menu", "champions' guild", config::swapJewelleryBox);
		swap("teleport menu", "monastery", config::swapJewelleryBox);
		swap("teleport menu", "ranging guild", config::swapJewelleryBox);
		swap("teleport menu", "fishing guild", config::swapJewelleryBox);
		swap("teleport menu", "mining guild", config::swapJewelleryBox);
		swap("teleport menu", "crafting guild", config::swapJewelleryBox);
		swap("teleport menu", "cooking guild", config::swapJewelleryBox);
		swap("teleport menu", "woodcutting guild", config::swapJewelleryBox);
		swap("teleport menu", "farming guild", config::swapJewelleryBox);
		swap("teleport menu", "miscellania", config::swapJewelleryBox);
		swap("teleport menu", "grand exchange", config::swapJewelleryBox);
		swap("teleport menu", "falador park", config::swapJewelleryBox);
		swap("teleport menu", "dondakan's rock", config::swapJewelleryBox);
		swap("teleport menu", "edgeville", config::swapJewelleryBox);
		swap("teleport menu", "karamja", config::swapJewelleryBox);
		swap("teleport menu", "draynor village", config::swapJewelleryBox);
		swap("teleport menu", "al kharid", config::swapJewelleryBox);

		Arrays.asList(
			"annakarl", "ape atoll dungeon", "ardougne", "barrows", "battlefront", "camelot", "carrallanger",
			"catherby", "cemetery", "draynor manor", "falador", "fenkenstrain's castle", "fishing guild", "ghorrock",
			"grand exchange", "great kourend", "harmony island", "kharyrll", "lumbridge", "arceuus library",
			"lunar isle", "marim", "mind altar", "salve graveyard", "seers' village", "senntisten", "troll stronghold",
			"varrock", "watchtower", "waterbirth island", "weiss", "west ardougne", "yanille"
		).forEach(location -> swap(location, "portal nexus", "teleport menu", config::swapPortalNexus));

		swap("shared", "private", config::swapPrivate);

		swap("pick", "pick-lots", config::swapPick);

		swap("view offer", "abort offer", () -> shiftModifier() && config.swapGEAbort());

		swap("value", "buy 1", () -> shiftModifier() && config.shopBuy() == BuyMode.BUY_1);
		swap("value", "buy 5", () -> shiftModifier() && config.shopBuy() == BuyMode.BUY_5);
		swap("value", "buy 10", () -> shiftModifier() && config.shopBuy() == BuyMode.BUY_10);
		swap("value", "buy 50", () -> shiftModifier() && config.shopBuy() == BuyMode.BUY_50);

		swap("value", "sell 1", () -> shiftModifier() && config.shopSell() == SellMode.SELL_1);
		swap("value", "sell 5", () -> shiftModifier() && config.shopSell() == SellMode.SELL_5);
		swap("value", "sell 10", () -> shiftModifier() && config.shopSell() == SellMode.SELL_10);
		swap("value", "sell 50", () -> shiftModifier() && config.shopSell() == SellMode.SELL_50);

		swap("wear", "tele to poh", config::swapTeleToPoh);

		swap("wear", "rub", config::swapTeleportItem);
		swap("wear", "teleport", config::swapTeleportItem);
		swap("wield", "teleport", config::swapTeleportItem);
		swap("wield", "invoke", config::swapTeleportItem);
		swap("wear", "teleports", config::swapTeleportItem);

		swap("wear", "farm teleport", () -> config.swapArdougneCloakMode() == ArdougneCloakMode.FARM);
		swap("wear", "monastery teleport", () -> config.swapArdougneCloakMode() == ArdougneCloakMode.MONASTERY);

		swap("wear", "gem mine", () -> config.swapKaramjaGlovesMode() == KaramjaGlovesMode.GEM_MINE);
		swap("wear", "duradel", () -> config.swapKaramjaGlovesMode() == KaramjaGlovesMode.DURADEL);

		swap("equip", "kourend woodland", () -> config.swapRadasBlessingMode() == RadasBlessingMode.KOUREND_WOODLAND);
		swap("equip", "mount karuulm", () -> config.swapRadasBlessingMode() == RadasBlessingMode.MOUNT_KARUULM);

		swap("wear", "ecto teleport", () -> config.swapMorytaniaLegsMode() == MorytaniaLegsMode.ECTOFUNTUS);
		swap("wear", "burgh teleport", () -> config.swapMorytaniaLegsMode() == MorytaniaLegsMode.BURGH_DE_ROTT);

		swap("wear", "nardah", () -> config.swapDesertAmuletMode() == DesertAmuletMode.NARDAH);
		swap("wear", "kalphite cave", () -> config.swapDesertAmuletMode() == DesertAmuletMode.KALPHITE_CAVE);

		swap("bury", "use", config::swapBones);

		swap("clean", "use", config::swapHerbs);

		swap("collect-note", "collect-item", () -> config.swapGEItemCollect() == GEItemCollectMode.ITEMS);
		swap("collect-notes", "collect-items", () -> config.swapGEItemCollect() == GEItemCollectMode.ITEMS);

		swap("collect-item", "collect-note", () -> config.swapGEItemCollect() == GEItemCollectMode.NOTES);
		swap("collect-items", "collect-notes", () -> config.swapGEItemCollect() == GEItemCollectMode.NOTES);

		swap("collect to inventory", "collect to bank", () -> config.swapGEItemCollect() == GEItemCollectMode.BANK);
		swap("collect", "bank", () -> config.swapGEItemCollect() == GEItemCollectMode.BANK);
		swap("collect-note", "bank", () -> config.swapGEItemCollect() == GEItemCollectMode.BANK);
		swap("collect-notes", "bank", () -> config.swapGEItemCollect() == GEItemCollectMode.BANK);
		swap("collect-item", "bank", () -> config.swapGEItemCollect() == GEItemCollectMode.BANK);
		swap("collect-items", "bank", () -> config.swapGEItemCollect() == GEItemCollectMode.BANK);

		swap("tan 1", "tan all", config::swapTan);

		swap("climb", "climb-up", () -> (shiftModifier() ? config.swapStairsShiftClick() : config.swapStairsLeftClick()) == MenuEntrySwapperConfig.StairsMode.CLIMB_UP);
		swap("climb", "climb-down", () -> (shiftModifier() ? config.swapStairsShiftClick() : config.swapStairsLeftClick()) == MenuEntrySwapperConfig.StairsMode.CLIMB_DOWN);
	}

	private void removeOldSwaps()
	{
		String[] keys = {
			"swapBattlestaves",
			"swapPrayerBook",
			"swapContract",
			"claimSlime",
			"swapDarkMage",
			"swapCaptainKhaled",
			"swapDecant",
			"swapHardWoodGrove",
			"swapHardWoodGroveParcel",
			"swapHouseAdvertisement",
			"swapEnchant",
			"swapHouseTeleportSpell",
			"swapTeleportSpell",
			"swapStartMinigame",
			"swapQuickleave",
			"swapNpcContact",
			"swapNets",
			"swapGauntlet",
			"swapCollectMiscellania",
			"swapRockCake",
			"swapRowboatDive"
		};
		for (String key : keys)
		{
			configManager.unsetConfiguration(MenuEntrySwapperConfig.GROUP, key);
		}
	}

	private void swap(String option, String swappedOption, Supplier<Boolean> enabled)
	{
		swap(option, alwaysTrue(), swappedOption, enabled);
	}

	private void swap(String option, String target, String swappedOption, Supplier<Boolean> enabled)
	{
		swap(option, equalTo(target), swappedOption, enabled);
	}

	private void swap(String option, Predicate<String> targetPredicate, String swappedOption, Supplier<Boolean> enabled)
	{
		swaps.put(option, new Swap(alwaysTrue(), targetPredicate, swappedOption, enabled, true));
	}

	private void swapContains(String option, Predicate<String> targetPredicate, String swappedOption, Supplier<Boolean> enabled)
	{
		swaps.put(option, new Swap(alwaysTrue(), targetPredicate, swappedOption, enabled, false));
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(MenuEntrySwapperConfig.GROUP) && event.getKey().equals("shiftClickCustomization"))
		{
			clientThread.invoke(this::resetItemCompositionCache);
		}
		else if (event.getGroup().equals(SHIFTCLICK_CONFIG_GROUP) && event.getKey().startsWith(ITEM_KEY_PREFIX))
		{
			clientThread.invoke(this::resetItemCompositionCache);
		}
	}

	private void resetItemCompositionCache()
	{
		client.getItemCompositionCache().reset();
	}

	private Integer getItemSwapConfig(boolean shift, int itemId)
	{
		itemId = ItemVariationMapping.map(itemId);
		String config = configManager.getConfiguration(shift ? SHIFTCLICK_CONFIG_GROUP : MenuEntrySwapperConfig.GROUP, ITEM_KEY_PREFIX + itemId);
		if (config == null || config.isEmpty())
		{
			return null;
		}

		return Integer.parseInt(config);
	}

	private void setItemSwapConfig(boolean shift, int itemId, int index)
	{
		itemId = ItemVariationMapping.map(itemId);
		configManager.setConfiguration(shift ? SHIFTCLICK_CONFIG_GROUP : MenuEntrySwapperConfig.GROUP, ITEM_KEY_PREFIX + itemId, index);
	}

	private void unsetItemSwapConfig(boolean shift, int itemId)
	{
		itemId = ItemVariationMapping.map(itemId);
		configManager.unsetConfiguration(shift ? SHIFTCLICK_CONFIG_GROUP : MenuEntrySwapperConfig.GROUP, ITEM_KEY_PREFIX + itemId);
	}

	private Integer getWornItemSwapConfig(boolean shift, int itemId)
	{
		itemId = ItemVariationMapping.map(itemId);
		String config = configManager.getConfiguration(MenuEntrySwapperConfig.GROUP,
			(shift ? WORN_ITEM_SHIFT_KEY_PREFIX : WORN_ITEM_KEY_PREFIX) + itemId);
		if (config == null || config.isEmpty())
		{
			return null;
		}

		return Integer.parseInt(config);
	}

	private void setWornItemSwapConfig(boolean shift, int itemId, int index)
	{
		itemId = ItemVariationMapping.map(itemId);
		configManager.setConfiguration(MenuEntrySwapperConfig.GROUP,
			(shift ? WORN_ITEM_SHIFT_KEY_PREFIX : WORN_ITEM_KEY_PREFIX) + itemId, index);
	}

	private void unsetWornItemSwapConfig(boolean shift, int itemId)
	{
		itemId = ItemVariationMapping.map(itemId);
		configManager.unsetConfiguration(MenuEntrySwapperConfig.GROUP,
			(shift ? WORN_ITEM_SHIFT_KEY_PREFIX : WORN_ITEM_KEY_PREFIX) + itemId);
	}

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		configureObjectClick(event);
		configureNpcClick(event);
		configureWornItems(event);
		configureItems(event);
		configureUiSwap(event);
	}

	private void configureObjectClick(MenuOpened event)
	{
		if (!shiftModifier() || !config.objectCustomization())
		{
			return;
		}

		MenuEntry[] entries = event.getMenuEntries();
		for (int idx = entries.length - 1; idx >= 0; --idx)
		{
			MenuEntry entry = entries[idx];
			if (entry.getType() == MenuAction.EXAMINE_OBJECT)
			{
				final ObjectComposition composition = client.getObjectDefinition(entry.getIdentifier());
				final String[] actions = composition.getActions();

				final Integer swapConfig = getObjectSwapConfig(false, composition.getId());
				final MenuAction currentAction = swapConfig == null ? defaultAction(composition) :
					(swapConfig == -1 ? MenuAction.WALK : OBJECT_MENU_TYPES.get(swapConfig));

				final Integer shiftSwapConfig = getObjectSwapConfig(true, composition.getId());
				final MenuAction currentShiftAction = shiftSwapConfig == null ? defaultAction(composition) :
					(shiftSwapConfig == -1 ? MenuAction.WALK : OBJECT_MENU_TYPES.get(shiftSwapConfig));

				List<MenuEntry> leftClickMenus = new ArrayList<>(actions.length + 2);
				List<MenuEntry> shiftClickMenus = new ArrayList<>(actions.length + 2);

				for (int actionIdx = 0; actionIdx < OBJECT_MENU_TYPES.size(); ++actionIdx)
				{
					if (Strings.isNullOrEmpty(actions[actionIdx]))
					{
						continue;
					}

					if ("Build".equals(actions[actionIdx])
						|| "Remove".equals(actions[actionIdx]))
					{
						// https://secure.runescape.com/m=news/third-party-client-guidelines?oldschool=1
						continue;
					}

					final MenuAction menuAction = OBJECT_MENU_TYPES.get(actionIdx);
					if (menuAction != currentAction)
					{
						leftClickMenus.add(client.createMenuEntry(idx)
							.setOption(actions[actionIdx])
							.setType(MenuAction.RUNELITE)
							.onClick(objectConsumer(composition, actions, actionIdx, menuAction, false)));
					}

					if (menuAction != currentShiftAction && menuAction != currentAction)
					{
						shiftClickMenus.add(client.createMenuEntry(idx)
							.setOption(actions[actionIdx])
							.setType(MenuAction.RUNELITE)
							.onClick(objectConsumer(composition, actions, actionIdx, menuAction, true)));
					}
				}

				// Walk here
				if (currentAction != MenuAction.WALK)
				{
					leftClickMenus.add(client.createMenuEntry(idx)
						.setOption("Walk here")
						.setType(MenuAction.RUNELITE)
						.onClick(walkHereConsumer(false, composition)));
				}

				if (currentShiftAction != MenuAction.WALK)
				{
					shiftClickMenus.add(client.createMenuEntry(idx)
						.setOption("Walk here")
						.setType(MenuAction.RUNELITE)
						.onClick(walkHereConsumer(true, composition)));
				}

				// Reset
				if (swapConfig != null)
				{
					leftClickMenus.add(client.createMenuEntry(idx)
						.setOption("Reset")
						.setType(MenuAction.RUNELITE)
						.onClick(objectResetConsumer(composition, false)));
				}

				if (shiftSwapConfig != null)
				{
					shiftClickMenus.add(client.createMenuEntry(idx)
						.setOption("Reset")
						.setType(MenuAction.RUNELITE)
						.onClick(objectResetConsumer(composition, true)));
				}

				if (!leftClickMenus.isEmpty())
				{
					MenuEntry sub = client.createMenuEntry(idx)
						.setOption("Swap left click")
						.setTarget(entry.getTarget())
						.setType(MenuAction.RUNELITE_SUBMENU);
					leftClickMenus.forEach(menu -> menu.setParent(sub));
				}

				if (!shiftClickMenus.isEmpty())
				{
					MenuEntry sub = client.createMenuEntry(idx)
						.setOption("Swap shift click")
						.setTarget(entry.getTarget())
						.setType(MenuAction.RUNELITE_SUBMENU);
					shiftClickMenus.forEach(menu -> menu.setParent(sub));
				}
			}
		}
	}

	private Consumer<MenuEntry> objectConsumer(ObjectComposition composition, String[] actions, int menuIdx,
		MenuAction menuAction, boolean shift)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(composition.getName())).append("' ")
				.append("has been set to '").append(actions[menuIdx]).append("'.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Set object swap for {} to {}", composition.getId(), menuAction);

			setObjectSwapConfig(shift, composition.getId(), menuIdx);
		};
	}

	private Consumer<MenuEntry> objectResetConsumer(ObjectComposition composition, boolean shift)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(composition.getName())).append("' ")
				.append("has been reset.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Unset object {} swap for {}", shift ? "shift" : "left", composition.getId());
			unsetObjectSwapConfig(shift, composition.getId());
		};
	}

	private Consumer<MenuEntry> walkHereConsumer(boolean shift, ObjectComposition composition)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(composition.getName())).append("' ")
				.append("has been set to Walk here.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Set object {} click swap for {} to Walk here", shift ? "shift" : "left", composition.getId());
			setObjectSwapConfig(shift, composition.getId(), -1);
		};
	}

	private Consumer<MenuEntry> walkHereConsumer(boolean shift, NPCComposition composition)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(composition.getName())).append("' ")
				.append("has been set to Walk here.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Set npc {} click swap for {} to Walk here", shift ? "shift" : "left", composition.getId());

			setNpcSwapConfig(shift, composition.getId(), -1);
		};
	}

	private void configureNpcClick(MenuOpened event)
	{
		if (!shiftModifier() || !config.npcCustomization())
		{
			return;
		}

		MenuEntry[] entries = event.getMenuEntries();
		for (int idx = entries.length - 1; idx >= 0; --idx)
		{
			final MenuEntry entry = entries[idx];
			final MenuAction type = entry.getType();

			if (type == MenuAction.EXAMINE_NPC)
			{
				final NPC npc = entry.getNpc();
				assert npc != null;
				final NPCComposition composition = npc.getTransformedComposition();
				assert composition != null;
				final String[] actions = composition.getActions();

				final Integer swapConfig = getNpcSwapConfig(false, composition.getId());
				final Integer shiftSwapConfig = getNpcSwapConfig(true, composition.getId());
				final boolean hasAttack = Arrays.stream(composition.getActions()).anyMatch("Attack"::equalsIgnoreCase);
				final MenuAction currentAction = swapConfig == null ?
					// Attackable NPCs always have Attack as the first, last (deprioritized), or when hidden, no, option.
					// Due to this the default action would be either Attack or the first non-Attack option, based on
					// the game settings. Since it may be valid to swap an option up to override Attack, even when Attack
					// is left-click, we cannot assume any default currentAction on attackable NPCs.
					// Non-attackable NPCS have a predictable default action which we can prevent a swap to if no swap
					// config is set, which just avoids showing a Swap option on a 1-op NPC, which looks odd.
					(hasAttack ? null : defaultAction(composition)) :
					(swapConfig == -1 ? MenuAction.WALK : NPC_MENU_TYPES.get(swapConfig));
				final MenuAction currentShiftAction = shiftSwapConfig == null ?
					(hasAttack ? null : defaultAction(composition)) :
					(shiftSwapConfig == -1 ? MenuAction.WALK : NPC_MENU_TYPES.get(shiftSwapConfig));

				List<MenuEntry> leftClickMenus = new ArrayList<>(actions.length + 2);
				List<MenuEntry> shiftClickMenus = new ArrayList<>(actions.length + 2);

				for (int actionIdx = 0; actionIdx < NPC_MENU_TYPES.size(); ++actionIdx)
				{
					// Attack can be swapped with the in-game settings, and this becomes very confusing if we try
					// to swap Attack and the game also tries to swap it (by deprioritizing), so just use the in-game
					// setting.
					if (Strings.isNullOrEmpty(actions[actionIdx]) || "Attack".equalsIgnoreCase(actions[actionIdx]))
					{
						continue;
					}

					if ("Knock-Out".equals(actions[actionIdx])
						|| "Lure".equals(actions[actionIdx]))
					{
						// https://secure.runescape.com/m=news/third-party-client-guidelines?oldschool=1
						continue;
					}

					final MenuAction menuAction = NPC_MENU_TYPES.get(actionIdx);
					if (menuAction != currentAction)
					{
						leftClickMenus.add(client.createMenuEntry(idx)
							.setOption(actions[actionIdx])
							.setType(MenuAction.RUNELITE)
							.onClick(npcConsumer(composition, actions, actionIdx, menuAction, false)));
					}

					if (menuAction != currentShiftAction)
					{
						shiftClickMenus.add(client.createMenuEntry(idx)
							.setOption(actions[actionIdx])
							.setType(MenuAction.RUNELITE)
							.onClick(npcConsumer(composition, actions, actionIdx, menuAction, true)));
					}
				}

				// Walk here swap
				leftClickMenus.add(client.createMenuEntry(idx)
					.setOption("Walk here")
					.setType(MenuAction.RUNELITE)
					.onClick(walkHereConsumer(false, composition)));

				shiftClickMenus.add(client.createMenuEntry(idx)
					.setOption("Walk here")
					.setType(MenuAction.RUNELITE)
					.onClick(walkHereConsumer(true, composition)));

				if (getNpcSwapConfig(false, composition.getId()) != null)
				{
					leftClickMenus.add(client.createMenuEntry(idx)
						.setOption("Reset")
						.setType(MenuAction.RUNELITE)
						.onClick(npcResetConsumer(composition, false)));
				}

				if (getNpcSwapConfig(true, composition.getId()) != null)
				{
					shiftClickMenus.add(client.createMenuEntry(idx)
						.setOption("Reset")
						.setType(MenuAction.RUNELITE)
						.onClick(npcResetConsumer(composition, true)));
				}

				if (!leftClickMenus.isEmpty())
				{
					MenuEntry sub = client.createMenuEntry(idx)
						.setOption("Swap left click")
						.setTarget(entry.getTarget())
						.setType(MenuAction.RUNELITE_SUBMENU);
					leftClickMenus.forEach(menu -> menu.setParent(sub));
				}

				if (!shiftClickMenus.isEmpty())
				{
					MenuEntry sub = client.createMenuEntry(idx)
						.setOption("Swap shift click")
						.setTarget(entry.getTarget())
						.setType(MenuAction.RUNELITE_SUBMENU);
					shiftClickMenus.forEach(menu -> menu.setParent(sub));
				}
			}
		}
	}

	private Consumer<MenuEntry> npcConsumer(NPCComposition composition, String[] actions, int menuIdx,
		MenuAction menuAction, boolean shift)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(composition.getName())).append("' ")
				.append("has been set to '").append(actions[menuIdx]).append("'.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Set npc {} swap for {} to {}", shift ? "shift" : "left", composition.getId(), menuAction);

			setNpcSwapConfig(shift, composition.getId(), menuIdx);
		};
	}

	private Consumer<MenuEntry> npcResetConsumer(NPCComposition composition, boolean shift)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(composition.getName())).append("' ")
				.append("has been reset.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Unset npc {} swap for {}", shift ? "shift" : "left", composition.getId());
			unsetNpcSwapConfig(shift, composition.getId());
		};
	}

	private void configureWornItems(MenuOpened event)
	{
		if (!shiftModifier())
		{
			return;
		}

		final MenuEntry[] entries = event.getMenuEntries();
		for (int idx = entries.length - 1; idx >= 0; --idx)
		{
			final MenuEntry entry = entries[idx];
			Widget w = entry.getWidget();

			if (w != null && WidgetUtil.componentToInterface(w.getId()) == InterfaceID.EQUIPMENT
				&& "Examine".equals(entry.getOption()) && entry.getIdentifier() == 10)
			{
				w = w.getChild(1);
				if (w != null && w.getItemId() > -1)
				{
					final ItemComposition itemComposition = itemManager.getItemComposition(w.getItemId());
					final Integer leftClickOp = getWornItemSwapConfig(false, itemComposition.getId());
					final Integer shiftClickOp = getWornItemSwapConfig(true, itemComposition.getId());

					List<MenuEntry> leftClickMenus = new ArrayList<>();
					List<MenuEntry> shiftClickMenus = new ArrayList<>();

					for (int paramId = ParamID.OC_ITEM_OP1, opId = 2; paramId <= ParamID.OC_ITEM_OP8; ++paramId, ++opId)
					{
						final String opName = itemComposition.getStringValue(paramId);
						if (!Strings.isNullOrEmpty(opName))
						{
							if (leftClickOp == null || leftClickOp != opId)
							{
								leftClickMenus.add(client.createMenuEntry(idx)
									.setOption(opName)
									.setType(MenuAction.RUNELITE)
									.onClick(wornItemConsumer(itemComposition, opName, opId, false)));
							}
							if (shiftClickOp == null || shiftClickOp != opId)
							{
								shiftClickMenus.add(client.createMenuEntry(idx)
									.setOption(opName)
									.setType(MenuAction.RUNELITE)
									.onClick(wornItemConsumer(itemComposition, opName, opId, true)));
							}
						}
					}

					if (leftClickOp != null)
					{
						leftClickMenus.add(client.createMenuEntry(idx)
							.setOption("Reset")
							.setType(MenuAction.RUNELITE)
							.onClick(e ->
							{
								final String message = new ChatMessageBuilder()
									.append("The default worn left click option for '").append(itemComposition.getMembersName()).append("' ")
									.append("has been reset.")
									.build();

								chatMessageManager.queue(QueuedMessage.builder()
									.type(ChatMessageType.CONSOLE)
									.runeLiteFormattedMessage(message)
									.build());

								log.debug("Unset worn item left swap for {}", itemComposition.getMembersName());
								unsetWornItemSwapConfig(false, itemComposition.getId());
							}));
					}
					if (shiftClickOp != null)
					{
						shiftClickMenus.add(client.createMenuEntry(idx)
							.setOption("Reset")
							.setType(MenuAction.RUNELITE)
							.onClick(e ->
							{
								final String message = new ChatMessageBuilder()
									.append("The default worn shift click option for '").append(itemComposition.getMembersName()).append("' ")
									.append("has been reset.")
									.build();

								chatMessageManager.queue(QueuedMessage.builder()
									.type(ChatMessageType.CONSOLE)
									.runeLiteFormattedMessage(message)
									.build());

								log.debug("Unset worn item shift swap for {}", itemComposition.getMembersName());
								unsetWornItemSwapConfig(true, itemComposition.getId());
							}));
					}

					if (!leftClickMenus.isEmpty())
					{
						MenuEntry sub = client.createMenuEntry(idx)
							.setOption("Swap left click")
							.setTarget(entry.getTarget())
							.setType(MenuAction.RUNELITE_SUBMENU);
						leftClickMenus.forEach(menu -> menu.setParent(sub));
					}

					if (!shiftClickMenus.isEmpty())
					{
						MenuEntry sub = client.createMenuEntry(idx)
							.setOption("Swap shift click")
							.setTarget(entry.getTarget())
							.setType(MenuAction.RUNELITE_SUBMENU);
						shiftClickMenus.forEach(menu -> menu.setParent(sub));
					}
				}
				break;
			}
		}
	}

	private Consumer<MenuEntry> wornItemConsumer(ItemComposition itemComposition, String opName, int opIdx, boolean shift)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default worn ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(itemComposition.getMembersName())).append("' ")
				.append("has been set to '").append(opName).append("'.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Set worn item {} swap for {} to {}", shift ? "shift" : "left", itemComposition.getMembersName(), opIdx);
			setWornItemSwapConfig(shift, itemComposition.getId(), opIdx);
		};
	}

	private void configureItems(MenuOpened event)
	{
		if (!shiftModifier())
		{
			return;
		}

		final MenuEntry[] entries = event.getMenuEntries();
		for (int idx = entries.length - 1; idx >= 0; --idx)
		{
			final MenuEntry entry = entries[idx];
			final Widget w = entry.getWidget();

			if (w != null && WidgetUtil.componentToInterface(w.getId()) == InterfaceID.INVENTORY
				&& "Examine".equals(entry.getOption()) && entry.getIdentifier() == 10)
			{
				final ItemComposition itemComposition = itemManager.getItemComposition(entry.getItemId());
				final String[] actions = itemComposition.getInventoryActions();
				final Integer leftClickOp = getItemSwapConfig(false, itemComposition.getId());
				final Integer shiftClickOp = getItemSwapConfig(true, itemComposition.getId());
				final int defaultLeftClickOp = defaultOp(itemComposition, false);
				final int defaultShiftClickOp = defaultOp(itemComposition, true);

				List<MenuEntry> leftClickMenus = new ArrayList<>(actions.length + 2);
				List<MenuEntry> shiftClickMenus = new ArrayList<>(actions.length + 2);

				for (int actionIdx = 0; actionIdx < actions.length; ++actionIdx)
				{
					final String opName = actions[actionIdx];
					if (!Strings.isNullOrEmpty(opName))
					{
						if (config.leftClickCustomization())
						{
							if (defaultLeftClickOp != actionIdx && (leftClickOp == null || leftClickOp != actionIdx))
							{
								leftClickMenus.add(client.createMenuEntry(idx)
									.setOption(opName)
									.setType(MenuAction.RUNELITE)
									.onClick(heldItemConsumer(itemComposition, opName, actionIdx, false)));
							}
						}
						if (config.shiftClickCustomization())
						{
							if (defaultShiftClickOp != actionIdx && (shiftClickOp == null || shiftClickOp != actionIdx))
							{
								shiftClickMenus.add(client.createMenuEntry(idx)
									.setOption(opName)
									.setType(MenuAction.RUNELITE)
									.onClick(heldItemConsumer(itemComposition, opName, actionIdx, true)));
							}
						}
					}

					if (actionIdx == 2)
					{
						// Use
						if (defaultLeftClickOp != -1 && config.leftClickCustomization())
						{
							leftClickMenus.add(client.createMenuEntry(idx)
								.setOption("Use")
								.setType(MenuAction.RUNELITE)
								.onClick(heldItemConsumer(itemComposition, "Use", -1, false)));
						}
						if (defaultShiftClickOp != -1 && config.shiftClickCustomization())
						{
							shiftClickMenus.add(client.createMenuEntry(idx)
								.setOption("Use")
								.setType(MenuAction.RUNELITE)
								.onClick(heldItemConsumer(itemComposition, "Use", -1, true)));
						}
					}
				}

				if (leftClickOp != null && config.leftClickCustomization())
				{
					leftClickMenus.add(client.createMenuEntry(idx)
						.setOption("Reset")
						.setType(MenuAction.RUNELITE)
						.onClick(e ->
						{
							final String message = new ChatMessageBuilder()
								.append("The default held left click option for '").append(itemComposition.getMembersName()).append("' ")
								.append("has been reset.")
								.build();

							chatMessageManager.queue(QueuedMessage.builder()
								.type(ChatMessageType.CONSOLE)
								.runeLiteFormattedMessage(message)
								.build());

							log.debug("Unset held item left swap for {}", itemComposition.getMembersName());
							unsetItemSwapConfig(false, itemComposition.getId());
						}));
				}
				if (shiftClickOp != null && config.shiftClickCustomization())
				{
					shiftClickMenus.add(client.createMenuEntry(idx)
						.setOption("Reset")
						.setType(MenuAction.RUNELITE)
						.onClick(e ->
						{
							final String message = new ChatMessageBuilder()
								.append("The default held shift click option for '").append(itemComposition.getMembersName()).append("' ")
								.append("has been reset.")
								.build();

							chatMessageManager.queue(QueuedMessage.builder()
								.type(ChatMessageType.CONSOLE)
								.runeLiteFormattedMessage(message)
								.build());

							log.debug("Unset held item shift swap for {}", itemComposition.getMembersName());
							unsetItemSwapConfig(true, itemComposition.getId());
						}));
				}

				if (!leftClickMenus.isEmpty())
				{
					MenuEntry sub = client.createMenuEntry(idx)
						.setOption("Swap left click")
						.setTarget(entry.getTarget())
						.setType(MenuAction.RUNELITE_SUBMENU);
					leftClickMenus.forEach(menu -> menu.setParent(sub));
				}

				if (!shiftClickMenus.isEmpty())
				{
					MenuEntry sub = client.createMenuEntry(idx)
						.setOption("Swap shift click")
						.setTarget(entry.getTarget())
						.setType(MenuAction.RUNELITE_SUBMENU);
					shiftClickMenus.forEach(menu -> menu.setParent(sub));
				}
				break;
			}
		}
	}

	private Consumer<MenuEntry> heldItemConsumer(ItemComposition itemComposition, String opName, int opIdx, boolean shift)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default held ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(itemComposition.getMembersName())).append("' ")
				.append("has been set to '").append(opName).append("'.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Set held item {} swap for {} to {}", shift ? "shift" : "left", itemComposition.getMembersName(), opIdx);
			setItemSwapConfig(shift, itemComposition.getId(), opIdx);
		};
	}

	private void configureUiSwap(MenuOpened event)
	{
		if (!shiftModifier())
		{
			return;
		}

		final MenuEntry[] entries = event.getMenuEntries();

		List<MenuEntry> leftClickMenus = new ArrayList<>();
		List<MenuEntry> shiftClickMenus = new ArrayList<>();

		for (int idx = entries.length - 1; idx >= 0; --idx)
		{
			final MenuEntry entry = entries[idx];
			if (entry.getType() == MenuAction.CC_OP || entry.getType() == MenuAction.CC_OP_LOW_PRIORITY
				|| entry.getType() == MenuAction.WIDGET_TARGET)
			{
				final Widget w = entry.getWidget();
				if (w == null || w.getActions() == null)
				{
					continue;
				}

				final int interId = WidgetUtil.componentToInterface(w.getId());
				if (interId == InterfaceID.INVENTORY || interId == InterfaceID.EQUIPMENT)
				{
					// inventory and worn items have their own swap systems
					continue;
				}

				// ui swap either:
				// 1) static components
				// 2) dynamic components with items
				if (w.getIndex() == -1 || w.getItemId() != -1)
				{
					final int componentId = w.getId(); // on dynamic components, this is the parent layer id
					final int itemId = w.getIndex() == -1 ? -1 : ItemVariationMapping.map(w.getItemId());
					final int identifier = entry.getIdentifier();
					final Integer leftClick = getUiSwapConfig(false, componentId, itemId);
					final Integer shiftClick = getUiSwapConfig(true, componentId, itemId);

					// find lowest op from the widget actions, to prevent setting a swap to the default left click
					// action regardless of what is swapped.
					final int lowestOp = findLowestOp(w);

					// find highest op from the current menu, post any existing swaps, for inserting Reset
					int highestOp = 10;
					for (int i = idx; i >= 0; --i)
					{
						final MenuEntry opEntry = entries[i];
						if (opEntry.getWidget() != w)
						{
							continue;
						}

						highestOp = opEntry.getIdentifier();
					}

					if (identifier != lowestOp && (leftClick == null || leftClick != identifier))
					{
						leftClickMenus.add(client.createMenuEntry(1)
							.setOption(entry.getOption())
							.setType(MenuAction.RUNELITE)
							.onClick(uiConsumer(entry.getOption(), entry.getTarget(), false, componentId, itemId, identifier)));
					}

					if (identifier != lowestOp && (shiftClick == null || shiftClick != identifier))
					{
						shiftClickMenus.add(client.createMenuEntry(1)
							.setOption(entry.getOption())
							.setType(MenuAction.RUNELITE)
							.onClick(uiConsumer(entry.getOption(), entry.getTarget(), true, componentId, itemId, identifier)));
					}

					if (identifier == highestOp)
					{
						if (leftClick != null)
						{
							leftClickMenus.add(client.createMenuEntry(1)
								.setOption("Reset")
								.setType(MenuAction.RUNELITE)
								.onClick(menuEntry ->
								{
									final String message = new ChatMessageBuilder()
										.append("The default left click option for '").append(Text.removeTags(entry.getTarget())).append("' ")
										.append("has been reset.")
										.build();

									chatMessageManager.queue(QueuedMessage.builder()
										.type(ChatMessageType.CONSOLE)
										.runeLiteFormattedMessage(message)
										.build());

									log.debug("Unset ui left swap for {}/{}", componentId, menuEntry.getTarget());

									unsetUiSwapConfig(false, componentId, itemId);
								}));
						}

						if (shiftClick != null)
						{
							shiftClickMenus.add(client.createMenuEntry(1)
								.setOption("Reset")
								.setType(MenuAction.RUNELITE)
								.onClick(menuEntry ->
								{
									final String message = new ChatMessageBuilder()
										.append("The default shift click option for '").append(Text.removeTags(entry.getTarget())).append("' ")
										.append("has been reset.")
										.build();

									chatMessageManager.queue(QueuedMessage.builder()
										.type(ChatMessageType.CONSOLE)
										.runeLiteFormattedMessage(message)
										.build());

									log.debug("Unset ui shift swap for {}/{}", componentId, menuEntry.getTarget());

									unsetUiSwapConfig(true, componentId, itemId);
								}));
						}

						if (!leftClickMenus.isEmpty())
						{
							MenuEntry sub = client.createMenuEntry(2)
								.setOption("Swap left click")
								.setTarget(entry.getTarget())
								.setType(MenuAction.RUNELITE_SUBMENU);
							leftClickMenus.forEach(menu -> menu.setParent(sub));
						}

						if (!shiftClickMenus.isEmpty())
						{
							MenuEntry sub = client.createMenuEntry(1)
								.setOption("Swap shift click")
								.setTarget(entry.getTarget())
								.setType(MenuAction.RUNELITE_SUBMENU);
							shiftClickMenus.forEach(menu -> menu.setParent(sub));
						}
					}
				}
			}
		}
	}

	private int findLowestOp(Widget w)
	{
		for (int i = 0; i <= 9; ++i)
		{
			if (i == 5)
			{
				if (isOpTarget(w) && !Strings.isNullOrEmpty(w.getTargetVerb()))
				{
					return 0;
				}
			}

			if ((testOpMask(w, i) || w.getOnOpListener() != null) && !Strings.isNullOrEmpty(w.getActions()[i]))
			{
				return i + 1;
			}
		}
		return -1;
	}

	private boolean testOpMask(Widget w, int op)
	{
		var n = client.getWidgetFlags().get((long) w.getId() << 32 | w.getIndex());
		int mask = n != null ? n.getValue() : w.getClickMask();
		return (mask >> op + 1 & 1) != 0;
	}

	private boolean isOpTarget(Widget w)
	{
		var n = client.getWidgetFlags().get((long) w.getId() << 32 | w.getIndex());
		int mask = n != null ? n.getValue() : w.getClickMask();
		return (mask & (WidgetConfig.USE_GROUND_ITEM | WidgetConfig.USE_NPC | WidgetConfig.USE_OBJECT | WidgetConfig.USE_PLAYER | WidgetConfig.USE_ITEM | WidgetConfig.USE_WIDGET)) != 0;
	}

	private Consumer<MenuEntry> uiConsumer(String option, String target, boolean shift, int componentId, int itemId, int opId)
	{
		return e ->
		{
			final String message = new ChatMessageBuilder()
				.append("The default ").append(shift ? "shift" : "left").append(" click option for '").append(Text.removeTags(target)).append("' ")
				.append("has been set to '").append(Text.removeTags(option)).append("'.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());

			log.debug("Set ui {} swap for {}/{} to {}", shift ? "shift" : "left", componentId, itemId, opId);
			setUiSwapConfig(shift, componentId, itemId, opId);
		};
	}

	private boolean swapBank(MenuEntry menuEntry, MenuAction type)
	{
		if (type != MenuAction.CC_OP && type != MenuAction.CC_OP_LOW_PRIORITY)
		{
			return false;
		}

		final int widgetGroupId = WidgetUtil.componentToInterface(menuEntry.getParam1());
		final boolean isDepositBoxPlayerInventory = widgetGroupId == InterfaceID.DEPOSIT_BOX;
		final boolean isChambersOfXericStorageUnitPlayerInventory = widgetGroupId == InterfaceID.CHAMBERS_OF_XERIC_INVENTORY;
		final boolean isGroupStoragePlayerInventory = widgetGroupId == InterfaceID.GROUP_STORAGE_INVENTORY;
		// Swap to shift-click deposit behavior
		// Deposit- op 1 is the current withdraw amount 1/5/10/x for deposit box interface and chambers of xeric storage unit.
		// Deposit- op 2 is the current withdraw amount 1/5/10/x for bank interface
		if (shiftModifier() && config.bankDepositShiftClick() != ShiftDepositMode.OFF
			&& type == MenuAction.CC_OP
			&& menuEntry.getIdentifier() == (isDepositBoxPlayerInventory || isGroupStoragePlayerInventory || isChambersOfXericStorageUnitPlayerInventory ? 1 : 2)
			&& (menuEntry.getOption().startsWith("Deposit-") || menuEntry.getOption().startsWith("Store") || menuEntry.getOption().startsWith("Donate")))
		{
			ShiftDepositMode shiftDepositMode = config.bankDepositShiftClick();
			final int opId = isDepositBoxPlayerInventory ? shiftDepositMode.getIdentifierDepositBox()
				: isChambersOfXericStorageUnitPlayerInventory ? shiftDepositMode.getIdentifierChambersStorageUnit()
				: isGroupStoragePlayerInventory ? shiftDepositMode.getIdentifierGroupStorage()
				: shiftDepositMode.getIdentifier();
			final MenuAction action = opId >= 6 ? MenuAction.CC_OP_LOW_PRIORITY : MenuAction.CC_OP;
			bankModeSwap(action, opId);
			return true;
		}

		// Swap to shift-click withdraw behavior
		// Deposit- op 1 is the current withdraw amount 1/5/10/x
		if (shiftModifier() && config.bankWithdrawShiftClick() != ShiftWithdrawMode.OFF
			&& type == MenuAction.CC_OP && menuEntry.getIdentifier() == 1
			&& menuEntry.getOption().startsWith("Withdraw"))
		{
			ShiftWithdrawMode shiftWithdrawMode = config.bankWithdrawShiftClick();
			final MenuAction action;
			final int opId;
			if (widgetGroupId == InterfaceID.CHAMBERS_OF_XERIC_STORAGE_UNIT_PRIVATE || widgetGroupId == InterfaceID.CHAMBERS_OF_XERIC_STORAGE_UNIT_SHARED)
			{
				action = MenuAction.CC_OP;
				opId = shiftWithdrawMode.getIdentifierChambersStorageUnit();
			}
			else
			{
				action = shiftWithdrawMode.getMenuAction();
				opId = shiftWithdrawMode.getIdentifier();
			}
			bankModeSwap(action, opId);
			return true;
		}

		return false;
	}

	private void bankModeSwap(MenuAction entryType, int entryIdentifier)
	{
		MenuEntry[] menuEntries = client.getMenuEntries();

		for (int i = menuEntries.length - 1; i >= 0; --i)
		{
			MenuEntry entry = menuEntries[i];

			if (entry.getType() == entryType && entry.getIdentifier() == entryIdentifier)
			{
				// Raise the priority of the op so it doesn't get sorted later
				entry.setType(MenuAction.CC_OP);

				menuEntries[i] = menuEntries[menuEntries.length - 1];
				menuEntries[menuEntries.length - 1] = entry;

				client.setMenuEntries(menuEntries);
				break;
			}
		}
	}

	private void swapMenuEntry(MenuEntry[] menuEntries, int index, MenuEntry menuEntry)
	{
		final int eventId = menuEntry.getIdentifier();
		final MenuAction menuAction = menuEntry.getType();
		final String option = Text.removeTags(menuEntry.getOption()).toLowerCase();
		final String target = Text.removeTags(menuEntry.getTarget()).toLowerCase();

		final boolean itemOp = menuEntry.isItemOp();
		// Custom shift-click item swap
		if (shiftModifier() && itemOp)
		{
			// Special case use shift click due to items not actually containing a "Use" option, making
			// the client unable to perform the swap itself.
			if (config.shiftClickCustomization() && !option.equals("use"))
			{
				Integer customOption = getItemSwapConfig(true, menuEntry.getItemId());

				if (customOption != null && customOption == -1)
				{
					swap(menuEntries, "use", target, index, true);
				}
			}

			// don't perform swaps on items when shift is held; instead prefer the client menu swap, which
			// we may have overwrote
			return;
		}

		// Custom left-click item swap
		if (itemOp && config.leftClickCustomization())
		{
			Integer swapIndex = getItemSwapConfig(false, menuEntry.getItemId());
			if (swapIndex != null)
			{
				final int swapAction = swapIndex >= 0
					? 1 + swapIndex
					: -1;

				if (swapAction == -1)
				{
					swap(menuEntries, "use", target, index, true);
				}
				else if (swapAction == menuEntry.getItemOp())
				{
					swap(optionIndexes, menuEntries, index, menuEntries.length - 1);
				}
				return;
			}
		}

		// Worn items swap
		final Widget w = menuEntry.getWidget();
		if (w != null && WidgetUtil.componentToInterface(w.getId()) == InterfaceID.EQUIPMENT)
		{
			Widget child = w.getChild(1);
			if (child != null && child.getItemId() > -1)
			{
				final Integer wornItemSwapConfig = getWornItemSwapConfig(shiftModifier(), child.getItemId());
				if (wornItemSwapConfig != null)
				{
					if (wornItemSwapConfig == menuEntry.getIdentifier())
					{
						swap(optionIndexes, menuEntries, index, menuEntries.length - 1);
					}
					return;
				}
			}
		}

		if (OBJECT_MENU_TYPES.contains(menuAction))
		{
			// Get multiloc id
			int objectId = eventId;
			ObjectComposition objectComposition = client.getObjectDefinition(objectId);
			if (objectComposition.getImpostorIds() != null)
			{
				objectComposition = objectComposition.getImpostor();
				objectId = objectComposition.getId();
			}

			Integer customOption = getObjectSwapConfig(shiftModifier(), objectId);
			if (customOption != null && customOption >= 0)
			{
				MenuAction swapAction = OBJECT_MENU_TYPES.get(customOption);
				if (swapAction == menuAction)
				{
					swap(optionIndexes, menuEntries, index, menuEntries.length - 1);
					return;
				}
			}
		}

		if (NPC_MENU_TYPES.contains(menuAction))
		{
			final NPC npc = menuEntry.getNpc();
			assert npc != null;
			final NPCComposition composition = npc.getTransformedComposition();
			assert composition != null;

			Integer customOption = getNpcSwapConfig(shiftModifier(), composition.getId());
			if (customOption != null && customOption >= 0)
			{
				MenuAction swapAction = NPC_MENU_TYPES.get(customOption);
				if (swapAction == menuAction)
				{
					// Advance to the top-most op for this NPC.
					int i = index;
					while (i < menuEntries.length - 1 && NPC_MENU_TYPES.contains(menuEntries[i + 1].getType()))
					{
						++i;
					}

					swap(optionIndexes, menuEntries, index, i);
					return;
				}
			}
		}

		// UI swaps
		if ((menuAction == MenuAction.CC_OP || menuAction == MenuAction.CC_OP_LOW_PRIORITY || menuAction == MenuAction.WIDGET_TARGET)
			&& w != null && (w.getIndex() == -1 || w.getItemId() != -1)
			&& w.getActions() != null
			&& !itemOp && WidgetUtil.componentToInterface(w.getId()) != InterfaceID.EQUIPMENT)
		{
			// fast check to avoid hitting config on components with single ops
			if ((index > 0 && menuEntries[index - 1].getWidget() == w) ||
				(index + 1 < menuEntries.length && menuEntries[index + 1].getWidget() == w))
			{
				final int componentId = w.getId(); // on dynamic components, this is the parent layer id
				final int itemId = w.getIndex() == -1 ? -1 : ItemVariationMapping.map(w.getItemId());
				final Integer op = getUiSwapConfig(shiftModifier(), componentId, itemId);
				if (op != null && op == menuEntry.getIdentifier())
				{
					swap(optionIndexes, menuEntries, index, menuEntries.length - 1);
					return;
				}
			}
		}

		if (swapBank(menuEntry, menuAction))
		{
			return;
		}

		final NPC hintArrowNpc = client.getHintArrowNpc();

		// Don't swap on hint arrow npcs, usually they need "Talk-to" for clues.
		if (hintArrowNpc != null
			&& hintArrowNpc.getIndex() == eventId
			&& NPC_MENU_TYPES.contains(menuAction))
		{
			return;
		}

		// Built-in swaps
		Collection<Swap> swaps = this.swaps.get(option);
		for (Swap swap : swaps)
		{
			if (swap.getTargetPredicate().test(target) && swap.getEnabled().get())
			{
				if (swap(menuEntries, swap.getSwappedOption(), target, index, swap.isStrict()))
				{
					break;
				}
			}
		}
	}

	@Subscribe
	public void onClientTick(ClientTick clientTick)
	{
		if (client.isMenuOpen())
		{
			return;
		}

		// Walk here swaps. These work via deprioritizing swapped menus instead of prioritizing the Walk here
		// option above swapped menus. This is because a Walk here swap doesn't mean Walk here should always
		// be at the top, it should only be above the individual entries being swapped.
		//
		// For example:
		// cancel -> walk here -> ground item op -> npc op
		// with a npc <-> walk here swap should result in
		// cancel -> npc op -> walk here -> ground item op
		// which cannot be achieved with a simple swap.

		for (MenuEntry menuEntry : client.getMenuEntries())
		{
			MenuAction type = menuEntry.getType();

			if (OBJECT_MENU_TYPES.contains(type))
			{
				// Get multiloc id
				int objectId = menuEntry.getIdentifier();
				ObjectComposition objectComposition = client.getObjectDefinition(objectId);
				if (objectComposition.getImpostorIds() != null)
				{
					objectComposition = objectComposition.getImpostor();
					objectId = objectComposition.getId();
				}

				final boolean shift = shiftModifier();
				Integer customOption = getObjectSwapConfig(shift, objectId);
				if ((customOption == null && shift && config.objectShiftClickWalkHere())
					|| (customOption != null && customOption == -1))
				{
					menuEntry.setDeprioritized(true);
				}
			}
			else if (NPC_MENU_TYPES.contains(type))
			{
				final NPC npc = menuEntry.getNpc();
				assert npc != null;
				final NPCComposition composition = npc.getTransformedComposition();
				assert composition != null;

				boolean shift = shiftModifier();
				Integer customOption = getNpcSwapConfig(shift, composition.getId());
				if ((customOption == null && shift && config.npcShiftClickWalkHere())
					|| (customOption != null && customOption == -1))
				{
					menuEntry.setDeprioritized(true);
				}
			}
			else if (type == MenuAction.GROUND_ITEM_FIRST_OPTION || type == MenuAction.GROUND_ITEM_SECOND_OPTION
				|| type == MenuAction.GROUND_ITEM_THIRD_OPTION || type == MenuAction.GROUND_ITEM_FOURTH_OPTION
				|| type == MenuAction.GROUND_ITEM_FIFTH_OPTION)
			{
				if (shiftModifier() && config.groundItemShiftClickWalkHere())
				{
					menuEntry.setDeprioritized(true);
				}
			}
		}
	}

	@Subscribe
	public void onPostMenuSort(PostMenuSort postMenuSort)
	{
		// The menu is not rebuilt when it is open, so don't swap or else it will
		// repeatedly swap entries
		if (client.isMenuOpen())
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
			swapMenuEntry(menuEntries, idx++, entry);
		}

		if (config.removeDeadNpcMenus())
		{
			removeDeadNpcs();
		}
	}

	private void removeDeadNpcs()
	{
		MenuEntry[] oldEntries = client.getMenuEntries();
		MenuEntry[] newEntries = Arrays.stream(oldEntries)
			.filter(e ->
			{
				final NPC npc = e.getNpc();
				return npc == null || !npcUtil.isDying(npc);
			})
			.toArray(MenuEntry[]::new);
		if (oldEntries.length != newEntries.length)
		{
			client.setMenuEntries(newEntries);
		}
	}

	@Subscribe
	public void onPostItemComposition(PostItemComposition event)
	{
		if (!config.shiftClickCustomization())
		{
			// since shift-click is done by the client we have to check if our shift click customization is on
			// prior to altering the item shift click action index.
			return;
		}

		ItemComposition itemComposition = event.getItemComposition();
		Integer option = getItemSwapConfig(true, itemComposition.getId());

		if (option != null && option < itemComposition.getInventoryActions().length)
		{
			itemComposition.setShiftClickActionIndex(option);
		}
	}

	private boolean swap(MenuEntry[] menuEntries, String option, String target, int index, boolean strict)
	{
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

		MenuEntry entry1 = entries[index1],
			entry2 = entries[index2];

		entries[index1] = entry2;
		entries[index2] = entry1;

		// Item op4 and op5 are CC_OP_LOW_PRIORITY so they get added underneath Use,
		// but this also makes them right-click only. Change them to CC_OP to avoid this.
		if (entry1.getType() == MenuAction.CC_OP_LOW_PRIORITY)
		{
			entry1.setType(MenuAction.CC_OP);
		}
		if (entry2.getType() == MenuAction.CC_OP_LOW_PRIORITY)
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

	private static <T extends Comparable<? super T>> void sortedInsert(List<T> list, T value) // NOPMD: UnusedPrivateMethod: false positive
	{
		int idx = Collections.binarySearch(list, value);
		list.add(idx < 0 ? -idx - 1 : idx, value);
	}

	private boolean shiftModifier()
	{
		return client.isKeyPressed(KeyCode.KC_SHIFT);
	}

	private Integer getObjectSwapConfig(boolean shift, int objectId)
	{
		String config = configManager.getConfiguration(MenuEntrySwapperConfig.GROUP, (shift ? OBJECT_SHIFT_KEY_PREFIX : OBJECT_KEY_PREFIX) + objectId);
		if (config == null || config.isEmpty())
		{
			return null;
		}

		return Integer.parseInt(config);
	}

	private void setObjectSwapConfig(boolean shift, int objectId, int index)
	{
		configManager.setConfiguration(MenuEntrySwapperConfig.GROUP, (shift ? OBJECT_SHIFT_KEY_PREFIX : OBJECT_KEY_PREFIX) + objectId, index);
	}

	private void unsetObjectSwapConfig(boolean shift, int objectId)
	{
		configManager.unsetConfiguration(MenuEntrySwapperConfig.GROUP, (shift ? OBJECT_SHIFT_KEY_PREFIX : OBJECT_KEY_PREFIX) + objectId);
	}

	private static MenuAction defaultAction(ObjectComposition objectComposition)
	{
		String[] actions = objectComposition.getActions();
		// GAME_OBJECT_FIFTH_OPTION is never the default, even if it is the only option, because it
		// gets depriotizied below Walk here
		for (int i = 0; i < OBJECT_MENU_TYPES.size() - 1; ++i)
		{
			if (!Strings.isNullOrEmpty(actions[i]))
			{
				return OBJECT_MENU_TYPES.get(i);
			}
		}
		return null;
	}

	private Integer getNpcSwapConfig(boolean shift, int npcId)
	{
		String config = configManager.getConfiguration(MenuEntrySwapperConfig.GROUP,
			(shift ? NPC_SHIFT_KEY_PREFIX : NPC_KEY_PREFIX) + npcId);
		if (config == null || config.isEmpty())
		{
			return null;
		}

		return Integer.parseInt(config);
	}

	private void setNpcSwapConfig(boolean shift, int npcId, int index)
	{
		configManager.setConfiguration(MenuEntrySwapperConfig.GROUP, (shift ? NPC_SHIFT_KEY_PREFIX : NPC_KEY_PREFIX) + npcId, index);
	}

	private void unsetNpcSwapConfig(boolean shift, int npcId)
	{
		configManager.unsetConfiguration(MenuEntrySwapperConfig.GROUP, (shift ? NPC_SHIFT_KEY_PREFIX : NPC_KEY_PREFIX) + npcId);
	}

	private static MenuAction defaultAction(NPCComposition composition)
	{
		String[] actions = composition.getActions();
		for (int i = 0; i < NPC_MENU_TYPES.size(); ++i)
		{
			if (!Strings.isNullOrEmpty(actions[i]) && !actions[i].equalsIgnoreCase("Attack"))
			{
				return NPC_MENU_TYPES.get(i);
			}
		}
		return null;
	}

	private int defaultOp(ItemComposition itemComposition, boolean shift)
	{
		if (shift)
		{
			final int shiftClickActionIndex = itemComposition.getShiftClickActionIndex();

			if (shiftClickActionIndex >= 0)
			{
				return shiftClickActionIndex;
			}
		}

		// take the first op above Use
		final String[] actions = itemComposition.getInventoryActions();
		for (int actionIdx = 0; actionIdx < 3; ++actionIdx)
		{
			if (!Strings.isNullOrEmpty(actions[actionIdx]))
			{
				return actionIdx;
			}
		}

		return -1; // use
	}

	private Integer getUiSwapConfig(boolean shift, int componentId, int itemId)
	{
		String config = configManager.getConfiguration(MenuEntrySwapperConfig.GROUP,
			(shift ? UI_SHIFT_KEY_PREFIX : UI_KEY_PREFIX) + componentId + (itemId != -1 ? "_" + itemId : ""));
		if (config == null || config.isEmpty())
		{
			return null;
		}

		return Integer.parseInt(config);
	}

	private void setUiSwapConfig(boolean shift, int componentId, int itemId, int op)
	{
		configManager.setConfiguration(MenuEntrySwapperConfig.GROUP,
			(shift ? UI_SHIFT_KEY_PREFIX : UI_KEY_PREFIX) + componentId + (itemId != -1 ? "_" + itemId : ""),
			op);
	}

	private void unsetUiSwapConfig(boolean shift, int componentId, int itemId)
	{
		configManager.unsetConfiguration(MenuEntrySwapperConfig.GROUP,
			(shift ? UI_SHIFT_KEY_PREFIX : UI_KEY_PREFIX) + componentId + (itemId != -1 ? "_" + itemId : ""));
	}
}
