/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MenuEntrySwapperTest
{
	private static final String[] SLAYER_MASTER_NAMES = {
		"Turael",
		"Krystilia",
		"Mazchna",
		"Vannaka",
		"Chaeldar",
		"Nieve",
		"Steve",
		"Duradel",
	};
	private static final String[] BANKER_NAMES = {
		"Banker",
		"Banker tutor",
		"TzHaar-Ket-Kuh",
		"TzHaar-Ket-Yil",
		"Gnome banker",
		"Ghost banker",
		"Yusuf",
	};
	private static final String[] BIRDHOUSE_NAMES = {
		"Birdhouse",
		"Oak Birdhouse",
		"Willow Birdhouse",
		"Teak Birdhouse",
		"Maple Birdhouse",
		"Mahogany Birdhouse",
		"Yew Birdhouse",
		"Magic Birdhouse",
		"Redwood Birdhouse",
	};
	private static final String[] CAT_NAMES = {
		"Kitten",
		"Cat",
		"Overgrown cat",
		"Wily cat",
		"Lazy cat",
		"Hellkitten",
		"Hellcat",
		"Overgrown hellcat",
		"Wily hellcat",
		"Lazy hellcat",
	};
	private static final String[] DECANT_NPCS = {
		"Bob Barter (herbs)",
		"Murky Matt (runes)",
	};
	private static final String[] GARDENER_NAMES = {
		"Elstan",
		"Lyra",
		"Dantaera",
		"Kragen",
		"Marisi",
		"My Arm",
		"Boulder",
		"Vasquen",
		"Rhonen",
		"Selena",
		"Francis",
		"Draven",
		"Taria",
		"Torrell",
		"Rhazien",
		"Fayeth",
		"Treznor",
		"Heskel",
		"Alain",
		"Prissy Scilla",
		"Bolongo",
		"Ellena",
		"Gileth",
		"Garth",
		"Liliwen",
		"Yulf Squecks",
		"Frizzy Skernip",
		"Praistan Ebola",
		"Lammy Langle",
		"Squirrel",
		"Mernia",
		"Gallow",
		"Ayesha",
		"Imiago",
	};
	// These NPCs have only "Talk-to" and "Trade" options
	private static final String[] SHOPKEEPERS = {
		"Shop keeper",
		"Shop assistant",
		"Lowe",
		"Horvik",
		"Cassie",
		"Hudo",
		"Gnome waiter",
		"Rometti",
		"Barman",
		"Arhein",
		"Smith",
	};
	private static final String[] TRAVEL_NPCS = {
		"Squire",
		"Daero",
		"Waydar",
		"Lumdo",
		"Sailor",
		"Jarvald",
		"Lokar Searunner",
		"Larry",
		"Cabin Boy Colin",
		"Captain Bentley",
	};
	private static final String[] PAY_FARE_NPCS = {
		"Seaman Lorris",
		"Seaman Thresnor",
		"Captain Tobias",
		"Customs officer",
		"Captain Barnaby",
	};
	private static final String[] UPGRADEABLE_STORAGE_CHESTS = {
		"Small storage unit",
		"Medium storage unit",
	};
	private static final String[] CHARTER_NPCS = {
		"Trader Crewmember",
		"Trader Stan",
	};
	private static final String[] TAKE_BOAT_NPCS = {
		"Monk of Entrana",
	};
	private static final String[] FLY_NPCS = {
		"Assistant Marrow",
		"Assistant Lori",
		"Assistant Brock",
		"Assistant Stan",
		"Assistant Serf",
		"Auguste",
	};
	private static final String[] RELLEKKA_TRAVEL_NPCS = {
		"Mord Gunnars",
		"Maria Gunnars",
	};
	private static final String[] FOLLOW_NPCS = {
		"Elkoy",
	};
	private static final String[] TRANSPORT_NPCS = {
		"Brother Tranquility",
	};
	private static final String[] TELEPORT_CAPES = {
		"Hunter cape",
		"Hunter cape(t)",
		"Crafting cape",
		"Crafting cape(t)",
		"Strength cape",
		"Strength cape(t)",
		"Mythical cape",
	};
	private static final String[] CONSTRUCTION_CAPES = {
		"Construct. cape",
		"Construct. cape(t)",
	};
	private static final String[] TRIMMABLE_TELEPORT_CAPES = {
		"Achievement diary cape",
		"Music cape",
		"Quest point cape",
	};
	private static final String[] UN_TRIMMABLE_TELEPORT_CAPES = {
		"Achievement diary cape (t)",
		"Music cape(t)",
		"Quest point cape (t)",
	};
	private static final String[] TELEPORT_WEAPONS = {
		"Western banner 1",
		"Western banner 2",
		"Western banner 3",
		"Western banner 4",
		"Wilderness sword 3",
		"Wilderness sword 4",
	};
	private static final String[] TELEPORT_JEWELLERY_AND_ARMOR = {
		"Fremennik sea boots 1",
		"Fremennik sea boots 2",
		"Fremennik sea boots 3",
		"Fremennik sea boots 4",
		"Desert amulet 1",
		"Desert amulet 2",
		"Desert amulet 3",
		"Kandarin headgear 3",
		"Kandarin headgear 4",
	};
	private static final String[] TELEPORT_JEWELLERY = {
		"Amulet of eternal glory",
		"Amulet of glory",
		"Amulet of glory",
		"Amulet of glory (t)",
		"Amulet of glory (t1)",
		"Amulet of glory (t2)",
		"Amulet of glory (t3)",
		"Amulet of glory (t4)",
		"Amulet of glory (t5)",
		"Amulet of glory (t6)",
		"Amulet of glory(1)",
		"Amulet of glory(2)",
		"Amulet of glory(3)",
		"Amulet of glory(4)",
		"Amulet of glory(5)",
		"Amulet of glory(6)",
		"Burning amulet(1)",
		"Burning amulet(2)",
		"Burning amulet(3)",
		"Burning amulet(4)",
		"Burning amulet(5)",
		"Combat bracelet",
		"Combat bracelet(1)",
		"Combat bracelet(2)",
		"Combat bracelet(3)",
		"Combat bracelet(4)",
		"Combat bracelet(5)",
		"Combat bracelet(6)",
		"Digsite pendant (1)",
		"Digsite pendant (2)",
		"Digsite pendant (3)",
		"Digsite pendant (4)",
		"Digsite pendant (5)",
		"Games necklace(1)",
		"Games necklace(2)",
		"Games necklace(3)",
		"Games necklace(4)",
		"Games necklace(5)",
		"Games necklace(6)",
		"Games necklace(7)",
		"Games necklace(8)",
		"Necklace of passage(1)",
		"Necklace of passage(2)",
		"Necklace of passage(3)",
		"Necklace of passage(4)",
		"Necklace of passage(5)",
		"Ring of dueling(1)",
		"Ring of dueling(2)",
		"Ring of dueling(3)",
		"Ring of dueling(4)",
		"Ring of dueling(5)",
		"Ring of dueling(6)",
		"Ring of dueling(7)",
		"Ring of dueling(8)",
		"Ring of returning(1)",
		"Ring of returning(2)",
		"Ring of returning(3)",
		"Ring of returning(4)",
		"Ring of returning(5)",
		"Skills necklace",
		"Skills necklace(1)",
		"Skills necklace(2)",
		"Skills necklace(3)",
		"Skills necklace(4)",
		"Skills necklace(5)",
		"Skills necklace(6)",
		"Void seal(1)",
		"Void seal(2)",
		"Void seal(3)",
		"Void seal(4)",
		"Void seal(5)",
		"Void seal(6)",
		"Void seal(7)",
		"Void seal(8)",
	};
	private static final String[] SLAYER_RINGS = {
		"Slayer ring (1)",
		"Slayer ring (2)",
		"Slayer ring (3)",
		"Slayer ring (4)",
		"Slayer ring (5)",
		"Slayer ring (6)",
		"Slayer ring (7)",
		"Slayer ring (8)",
		"Slayer ring (eternal)",
	};
	private static final String[] RINGS_OF_WEALTH = {
		"Ring of wealth (1)",
		"Ring of wealth (2)",
		"Ring of wealth (3)",
		"Ring of wealth (4)",
		"Ring of wealth (5)",
		"Ring of wealth (i)",
		"Ring of wealth (i1)",
		"Ring of wealth (i2)",
		"Ring of wealth (i3)",
		"Ring of wealth (i4)",
		"Ring of wealth (i5)",
		"Ring of wealth",
	};
	private static final String[] EXPLORERS_RINGS = {
		"Explorer's Ring 2",
		"Explorer's Ring 3",
		"Explorer's Ring 4",
	};
	private static final String[] MOUNTED_ADMIRE_CAPES = {
		"Mounted Fire Cape",
		"Mounted Max Cape", // max fire/infernal/god cape
		"Mounted Agility Cape",
		"Mounted Agility Cape (t)",
		"Mounted Attack Cape",
		"Mounted Attack Cape (t)",
		"Mounted Cooking Cape",
		"Mounted Cooking Cape (t)",
		"Mounted Defence Cape",
		"Mounted Defence Cape (t)",
		"Mounted Farming Cape",
		"Mounted Farming Cape (t)",
		"Mounted Firemaking Cape",
		"Mounted Firemaking Cape (t)",
		"Mounted Hitpoints Cape",
		"Mounted Hitpoints Cape (t)",
		"Mounted Mining Cape",
		"Mounted Mining Cape (t)",
		"Mounted Prayer Cape",
		"Mounted Prayer Cape (t)",
		"Mounted Range Cape",
		"Mounted Range Cape (t)",
		"Mounted Runecrafting Cape",
		"Mounted Runecrafting Cape (t)",
		"Mounted Slayer Cape",
		"Mounted Slayer Cape (t)",
		"Mounted Smithing Cape",
		"Mounted Smithing Cape (t)",
		"Mounted Thieving Cape",
		"Mounted Thieving Cape (t)",
		"Mounted Woodcutting Cape",
		"Mounted Woodcutting Cape (t)",
	};
	private static final String[] MOUNTED_TELEPORT_CAPES = {
		"Mounted Achievement Diary Cape",
		"Mounted Music Cape",
		"Mounted Quest Cape",
		"Mounted Construction Cape",
		"Mounted Construction Cape (t)",
		"Mounted Crafting Cape",
		"Mounted Crafting Cape (t)",
		"Mounted Fishing Cape",
		"Mounted Fishing Cape (t)",
		"Mounted Hunting Cape",
		"Mounted Hunting Cape (t)",
		"Mounted Strength Cape",
		"Mounted Strength Cape (t)",
	};
	private static final String[] MOUNTED_SEARCH_CAPES = {
		"Mounted Fletching Cape",
		"Mounted Fletching Cape (t)",
		"Mounted Herblore Cape",
		"Mounted Herblore Cape (t)",
	};
	private static final String[] MOUNTED_SPELLBOOK_CAPES = {
		"Mounted Magic Cape",
		"Mounted Magic Cape (t)",
	};
	private static final MenuEntry TALK_TO_FIRST_ENTRY = minimalMenuEntry("Talk-to", MenuAction.NPC_FIRST_OPTION);

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ConfigManager configManager;

	@Mock
	@Bind
	MenuEntrySwapperConfig config;

	@Inject
	MenuEntrySwapperPlugin plugin;

	@Mock
	@Bind
	ScheduledExecutorService scheduledExecutorService;

	@Inject
	MenuManager menuManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		// Mock config
		when(config.shiftClickCustomization()).thenReturn(true);
		when(config.swapAdmire()).thenReturn(true);
		when(config.swapAssignment()).thenReturn(true);
		when(config.swapBank()).thenReturn(true);
		when(config.swapBirdhouseEmpty()).thenReturn(true);
		when(config.swapBones()).thenReturn(true);
		when(config.swapChase()).thenReturn(true);
		when(config.claimSlime()).thenReturn(true);
		when(config.swapDarkMage()).thenReturn(true);
		when(config.swapDecant()).thenReturn(true);
		when(config.swapExchange()).thenReturn(true);
		when(config.swapHarpoon()).thenReturn(true);
		when(config.swapPickpocket()).thenReturn(true);
		when(config.swapPay()).thenReturn(true);
		when(config.swapPrivate()).thenReturn(true);
		when(config.swapQuick()).thenReturn(true);
		when(config.swapBoxTrap()).thenReturn(true);
		when(config.swapTeleportItem()).thenReturn(true);
		when(config.swapAbyssTeleport()).thenReturn(true);
		when(config.swapTrade()).thenReturn(true);
		when(config.swapTravel()).thenReturn(true);

		// Mock client
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
	}

	private static class StaffOfTheDeadItemComposition implements ItemComposition
	{
		private static final int ITEM_ID = ItemID.STAFF_OF_THE_DEAD;
		private static final String ITEM_NAME = "Staff of the Dead";
		private static final String[] MENU_OPTIONS = {
			"Wield",
			"Drop",
		};
		private static final int DEFAULT_SHIFT_CLICK_ACTION_INDEX = MENU_OPTIONS.length - 1;

		private int shiftClickActionIndex = DEFAULT_SHIFT_CLICK_ACTION_INDEX;

		@Override
		public String getName()
		{
			return ITEM_NAME;
		}

		@Override
		public int getId()
		{
			return ITEM_ID;
		}

		@Override
		public int getNote()
		{
			return 0;
		}

		@Override
		public int getLinkedNoteId()
		{
			return 0;
		}

		@Override
		public int getPlaceholderId()
		{
			return 0;
		}

		@Override
		public int getPlaceholderTemplateId()
		{
			return 0;
		}

		@Override
		public int getPrice()
		{
			return 0;
		}

		@Override
		public boolean isMembers()
		{
			return true;
		}

		@Override
		public boolean isStackable()
		{
			return false;
		}

		@Override
		public boolean isTradeable()
		{
			return true;
		}

		@Override
		public String[] getInventoryActions()
		{
			return Arrays.copyOf(MENU_OPTIONS, MENU_OPTIONS.length);
		}

		@Override
		public int getShiftClickActionIndex()
		{
			return shiftClickActionIndex;
		}

		@Override
		public void setShiftClickActionIndex(int shiftclickActionIndex)
		{
			shiftClickActionIndex = shiftclickActionIndex;
		}

		@Override
		public void resetShiftClickActionIndex()
		{
			shiftClickActionIndex = DEFAULT_SHIFT_CLICK_ACTION_INDEX;
		}

		/**
		 * Converts a {@link MenuEntry} index to an inventoryActions index. (i.e. account for "Use" entry which does not
		 * exist in the inventory actions array)
		 *
		 * @param originalIndex Index of a menu entry, as might be returned from {@link MenuOpened#getMenuEntries()}
		 * @return An inventory action index which corresponds to the given menu index.
		 */
		private static int getUseAdjustedIndex(final int originalIndex)
		{
			return originalIndex <= 1 ? originalIndex : originalIndex - 1;
		}

		/**
		 * Converts an inventory action index to a {@link MenuEntry} index. (i.e. account for added "Use" entry)
		 *
		 * @param originalIndex The inventory action index of an option
		 * @return An adjusted index which corresponds to a menu entry, as might be returned from
		 *         {@link MenuOpened#getMenuEntries()}.
		 */
		private static int reverseUseAdjustedIndex(final int originalIndex)
		{
			return originalIndex == 0 ? originalIndex : originalIndex + 1;
		}
	}

	@Test
	public void configureInventoryShiftClickSwaps()
	{
		// Definitions
		final WidgetInfo inventoryWidget = WidgetInfo.INVENTORY;
		final WidgetInfo[] inventoryTabWidgets = {
			WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB,
			WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB,
			WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB,
		};
		final ItemComposition sotdItemComposition = new StaffOfTheDeadItemComposition();
		when(client.getItemDefinition(StaffOfTheDeadItemComposition.ITEM_ID)).thenReturn(sotdItemComposition);

		// Register key listener and add menu manager entries
		plugin.startUp();

		// Run test routine for each inventory tab widget; loop is idempotent
		for (final WidgetInfo inventoryTabWidget : inventoryTabWidgets)
		{
			// Definitions depending upon inventoryTabWidget
			final MenuEntry inventoryMenuEntry = new MenuEntry();
			inventoryMenuEntry.setOption("Inventory");
			inventoryMenuEntry.setType(MenuAction.WIDGET_DEFAULT.getId());
			inventoryMenuEntry.setParam1(inventoryTabWidget.getId());
			final MenuEntry configureMenuEntry = new MenuEntry();
			configureMenuEntry.setOption("Configure");
			configureMenuEntry.setTarget(WidgetMenuOption.applyTargetMenuColor(MenuEntrySwapperPlugin.MENU_TARGET));
			configureMenuEntry.setType(MenuAction.RUNELITE.getId());
			configureMenuEntry.setParam1(inventoryTabWidget.getId());
			final MenuEntry saveMenuEntry = new MenuEntry();
			saveMenuEntry.setOption("Save");
			saveMenuEntry.setTarget(WidgetMenuOption.applyTargetMenuColor(MenuEntrySwapperPlugin.MENU_TARGET));
			saveMenuEntry.setType(MenuAction.RUNELITE.getId());
			saveMenuEntry.setParam1(inventoryTabWidget.getId());
			final MenuEntryAdded inventoryTabMenuEntryAdded = new MenuEntryAdded(
				inventoryMenuEntry.getOption(),
				inventoryMenuEntry.getTarget(),
				inventoryMenuEntry.getType(),
				inventoryMenuEntry.getIdentifier(),
				inventoryMenuEntry.getParam0(),
				inventoryMenuEntry.getParam1());
			when(client.getMenuEntries()).thenReturn(new MenuEntry[] { inventoryMenuEntry });

			// Right-click inventory icon, verify a "Configure Shift-click" menu option exists
			menuManager.onMenuEntryAdded(inventoryTabMenuEntryAdded);
			verify(client, atLeastOnce()).setMenuEntries(new MenuEntry[]{
				inventoryMenuEntry,
				configureMenuEntry,
			});

			// Click "Configure Shift-click" on inventory tab, confirm configuration mode is on
			final WidgetMenuOptionClicked inventoryTabConfigureClicked = new WidgetMenuOptionClicked();
			inventoryTabConfigureClicked.setMenuOption(MenuEntrySwapperPlugin.CONFIGURE);
			inventoryTabConfigureClicked.setMenuTarget(MenuEntrySwapperPlugin.MENU_TARGET);
			inventoryTabConfigureClicked.setWidget(inventoryTabWidget);
			plugin.onWidgetMenuOptionClicked(inventoryTabConfigureClicked);
			assert plugin.configuringShiftClick : "Configuring item shift click mode should be enabled.";

			// Right-click inventory icon, verify a "Save Shift-click" menu option exists
			menuManager.onMenuEntryAdded(inventoryTabMenuEntryAdded);
			verify(client, atLeastOnce()).setMenuEntries(new MenuEntry[]{
				inventoryMenuEntry,
				saveMenuEntry,
			});

			// Confirm right-clicking an item adds an asterisk to its shift-click option (default "Drop")
			final MenuEntry[] sotdOptions = new MenuEntry[StaffOfTheDeadItemComposition.MENU_OPTIONS.length + 1]; // extra index for "Use" option
			for (int i = 0; i < sotdOptions.length; i++)
			{
				final int index = StaffOfTheDeadItemComposition.getUseAdjustedIndex(i);
				String option;
				if (i == 1)
				{
					option = "Use";
				}
				else
				{
					option = StaffOfTheDeadItemComposition.MENU_OPTIONS[index];
				}

				sotdOptions[i] = new MenuEntry();
				sotdOptions[i].setOption(option);
				sotdOptions[i].setTarget(StaffOfTheDeadItemComposition.ITEM_NAME);
				sotdOptions[i].setIdentifier(StaffOfTheDeadItemComposition.ITEM_ID);
				sotdOptions[i].setParam1(inventoryWidget.getId());
			}
			final MenuOpened sotdMenuOpened = new MenuOpened();
			sotdMenuOpened.setMenuEntries(sotdOptions);
			plugin.onMenuOpened(sotdMenuOpened);
			assertEquals("* " + sotdItemComposition.getInventoryActions()[sotdItemComposition.getShiftClickActionIndex()], sotdMenuOpened.getMenuEntries()[StaffOfTheDeadItemComposition.reverseUseAdjustedIndex(sotdItemComposition.getShiftClickActionIndex())].getOption());

			// Click "Wield" in configuration mode, confirm its shift click action index changed
			final int wieldIndex = 0;
			final MenuOptionClicked shiftClickSelectWield = new MenuOptionClicked();
			shiftClickSelectWield.setId(StaffOfTheDeadItemComposition.ITEM_ID);
			shiftClickSelectWield.setMenuAction(MenuAction.RUNELITE);
			shiftClickSelectWield.setWidgetId(inventoryWidget.getId());
			shiftClickSelectWield.setMenuOption(StaffOfTheDeadItemComposition.MENU_OPTIONS[wieldIndex]);
			shiftClickSelectWield.setMenuTarget(StaffOfTheDeadItemComposition.ITEM_NAME);
			plugin.onMenuOptionClicked(shiftClickSelectWield);
			assertEquals(wieldIndex, sotdItemComposition.getShiftClickActionIndex());
			verify(configManager, atLeastOnce()).setConfiguration(MenuEntrySwapperPlugin.CONFIG_GROUP, MenuEntrySwapperPlugin.ITEM_KEY_PREFIX + StaffOfTheDeadItemComposition.ITEM_ID, wieldIndex);

			// Confirm right-clicking the item adds an asterisk to the "Wield" option
			plugin.onMenuOpened(sotdMenuOpened);
			assertEquals("* " + sotdItemComposition.getInventoryActions()[wieldIndex], sotdMenuOpened.getMenuEntries()[StaffOfTheDeadItemComposition.getUseAdjustedIndex(sotdItemComposition.getShiftClickActionIndex())].getOption());

			// Click "Use" in configuration mode, confirm its shift click action index changed (to -1)
			final int useIndex = -1;
			final String useText = "Use";
			final MenuOptionClicked shiftClickSelectUse = new MenuOptionClicked();
			shiftClickSelectUse.setId(StaffOfTheDeadItemComposition.ITEM_ID);
			shiftClickSelectUse.setMenuAction(MenuAction.RUNELITE);
			shiftClickSelectUse.setWidgetId(inventoryWidget.getId());
			shiftClickSelectUse.setMenuOption(useText);
			shiftClickSelectUse.setMenuTarget(StaffOfTheDeadItemComposition.ITEM_NAME);
			plugin.onMenuOptionClicked(shiftClickSelectUse);
			assertEquals(useIndex, sotdItemComposition.getShiftClickActionIndex());
			verify(configManager, atLeastOnce()).setConfiguration(MenuEntrySwapperPlugin.CONFIG_GROUP, MenuEntrySwapperPlugin.ITEM_KEY_PREFIX + StaffOfTheDeadItemComposition.ITEM_ID, useIndex);

			// Confirm right-clicking the item adds an asterisk to the "Use" option
			final int useMenuEntryIndex = 1;
			plugin.onMenuOpened(sotdMenuOpened);
			assertEquals("* " + useText, sotdMenuOpened.getMenuEntries()[useMenuEntryIndex].getOption());

			// Click "Reset" in configuration mode, confirm its shift click action index was reset
			final MenuOptionClicked shiftClickReset = new MenuOptionClicked();
			shiftClickReset.setId(StaffOfTheDeadItemComposition.ITEM_ID);
			shiftClickReset.setMenuAction(MenuAction.RUNELITE);
			shiftClickReset.setWidgetId(inventoryWidget.getId());
			shiftClickReset.setMenuOption(MenuEntrySwapperPlugin.RESET);
			shiftClickReset.setMenuTarget(MenuEntrySwapperPlugin.MENU_TARGET);
			plugin.onMenuOptionClicked(shiftClickReset);
			assertEquals(StaffOfTheDeadItemComposition.DEFAULT_SHIFT_CLICK_ACTION_INDEX, sotdItemComposition.getShiftClickActionIndex());
			verify(configManager, atLeastOnce()).unsetConfiguration(MenuEntrySwapperPlugin.CONFIG_GROUP, MenuEntrySwapperPlugin.ITEM_KEY_PREFIX + StaffOfTheDeadItemComposition.ITEM_ID);

			// Click "Save Shift-click" on inventory tab, confirm configuration mode is off
			final WidgetMenuOptionClicked inventoryTabSaveClicked = new WidgetMenuOptionClicked();
			inventoryTabSaveClicked.setMenuOption(MenuEntrySwapperPlugin.SAVE);
			inventoryTabSaveClicked.setMenuTarget(MenuEntrySwapperPlugin.MENU_TARGET);
			inventoryTabSaveClicked.setWidget(inventoryTabWidget);
			plugin.onWidgetMenuOptionClicked(inventoryTabSaveClicked);
			assert !plugin.configuringShiftClick : "Configuring item shift click mode should be enabled.";

			// Right-click inventory icon, verify a "Configure Shift-click" menu option exists
			menuManager.onMenuEntryAdded(inventoryTabMenuEntryAdded);
			verify(client, atLeastOnce()).setMenuEntries(new MenuEntry[]{
				inventoryMenuEntry,
				configureMenuEntry,
			});
		}
	}

	@Test
	public void testMountedNoExtraOptionsCape()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_SECOND_OPTION);
		for (final String noOtherOptionsCape : MOUNTED_ADMIRE_CAPES)
		{
			testEntrySwapNegative(noOtherOptionsCape, firstEntry, secondEntry);
		}
	}

	@Test
	public void testMountedTeleportCapeSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		for (final String teleportMountedCape : MOUNTED_TELEPORT_CAPES)
		{
			testEntrySwap(teleportMountedCape, 1, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testMountedSearchCapeNoSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Search", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		for (final String searchMountedCape : MOUNTED_SEARCH_CAPES)
		{
			testEntrySwapNegative(searchMountedCape, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testMountedSpellbookCapeSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Spellbook", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		for (final String spellbookMountedCape : MOUNTED_SPELLBOOK_CAPES)
		{
			testEntrySwap(spellbookMountedCape, 1, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testMountedPerksCapeSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Perks", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		// only mounted normal max capes have the "Perks" option
		testEntrySwap("Mounted Max Cape", 1, firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testMountedCommuneCapeNoSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Commune", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		// only mounted ava's max capes have the "Commune" option
		testEntrySwapNegative("Mounted Max Cape", firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testMountedNoExtraOptionsCapeNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapAdmire()).thenReturn(false);
		for (final String noOtherOptionsCape : MOUNTED_ADMIRE_CAPES)
		{
			testEntrySwapNegative(noOtherOptionsCape, firstEntry, secondEntry);
		}
	}

	@Test
	public void testMountedTeleportCapeSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapAdmire()).thenReturn(false);
		for (final String teleportMountedCape : MOUNTED_TELEPORT_CAPES)
		{
			testEntrySwapNegative(teleportMountedCape, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testMountedSearchCapeNoSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Search", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapAdmire()).thenReturn(false);
		for (final String searchMountedCape : MOUNTED_SEARCH_CAPES)
		{
			testEntrySwapNegative(searchMountedCape, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testMountedSpellbookCapeSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Spellbook", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapAdmire()).thenReturn(false);
		for (final String spellbookMountedCape : MOUNTED_SPELLBOOK_CAPES)
		{
			testEntrySwapNegative(spellbookMountedCape, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testMountedPerksCapeSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Perks", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapAdmire()).thenReturn(false);
		// only mounted normal max capes have the "Perks" option
		testEntrySwapNegative("Mounted Max Cape", firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testMountedCommuneCapeNoSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Admire", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Commune", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Take", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapAdmire()).thenReturn(false);
		// only mounted ava's max capes have the "Commune" option
		testEntrySwapNegative("Mounted Max Cape", firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testSlayerAssignmentOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Assignment", MenuAction.NPC_THIRD_OPTION);
		final int[] swapOrder = {2, 1}; // assignment is processed before trade for entry swapping
		for (final String slayerMaster : SLAYER_MASTER_NAMES)
		{
			testEntrySwap(slayerMaster, swapOrder, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testSlayerAssignmentOptionSwapPartialNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Assignment", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTrade()).thenReturn(false);
		for (final String slayerMaster : SLAYER_MASTER_NAMES)
		{
			testEntrySwap(slayerMaster, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testSlayerAssignmentOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Assignment", MenuAction.NPC_THIRD_OPTION);
		when(config.swapAssignment()).thenReturn(false);
		for (final String slayerMaster : SLAYER_MASTER_NAMES)
		{
			testEntrySwap(slayerMaster, 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testSlayerAssignmentOptionSwapFullNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Assignment", MenuAction.NPC_THIRD_OPTION);
		when(config.swapAssignment()).thenReturn(false);
		when(config.swapTrade()).thenReturn(false);
		for (final String slayerMaster : SLAYER_MASTER_NAMES)
		{
			testEntrySwapNegative(slayerMaster, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testBankerBankOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Bank", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Collect", MenuAction.NPC_THIRD_OPTION);
		for (final String bankerName : BANKER_NAMES)
		{
			testEntrySwap(bankerName, 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testFinancialWizardBankOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Bank", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Collect", MenuAction.NPC_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Deposit-box", MenuAction.NPC_FOURTH_OPTION);
		testEntrySwap("Financial Wizard", 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry, fourthEntry);
	}

	@Test public void testBankerBankOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Bank", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Collect", MenuAction.NPC_THIRD_OPTION);
		when(config.swapBank()).thenReturn(false);
		for (final String bankerName : BANKER_NAMES)
		{
			testEntrySwapNegative(bankerName, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testFinancialWizardBankOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Bank", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Collect", MenuAction.NPC_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Deposit-box", MenuAction.NPC_FOURTH_OPTION);
		when(config.swapBank()).thenReturn(false);
		testEntrySwapNegative("Financial Wizard", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testBirdhouseEmptyOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Interact", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Seeds", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Empty", MenuAction.GAME_OBJECT_THIRD_OPTION);
		for (final String birdhouseName : BIRDHOUSE_NAMES)
		{
			testEntrySwap(birdhouseName, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testBirdhouseEmptyOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Interact", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Seeds", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Empty", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapBirdhouseEmpty()).thenReturn(false);
		for (final String birdhouseName : BIRDHOUSE_NAMES)
		{
			testEntrySwapNegative(birdhouseName, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testBoneBuryOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Bury", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Use", MenuAction.ITEM_SECOND_OPTION);
		testEntrySwap("Bones", firstEntry, secondEntry);
	}

	@Test
	public void testBoneBuryOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Bury", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Use", MenuAction.ITEM_SECOND_OPTION);
		when(config.swapBones()).thenReturn(false);
		testEntrySwapNegative("Bones", firstEntry, secondEntry);
	}

	@Test
	public void testCatChaseOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Pick-up", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Talk-to", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry =  minimalMenuEntry("Chase", MenuAction.NPC_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Interact", MenuAction.NPC_FOURTH_OPTION);
		for (final String catName : CAT_NAMES)
		{
			testEntrySwap(catName, 2, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testCatChaseOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Pick-up", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Talk-to", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry =  minimalMenuEntry("Chase", MenuAction.NPC_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Interact", MenuAction.NPC_FOURTH_OPTION);
		when(config.swapChase()).thenReturn(false);
		for (final String catName : CAT_NAMES)
		{
			testEntrySwapNegative(catName, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testClaimSlimeOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Claim-slime", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Robin", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testClaimSlimeOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Claim-slime", MenuAction.NPC_SECOND_OPTION);
		when(config.claimSlime()).thenReturn(false);
		testEntrySwapNegative("Robin", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testDarkMageRepairsOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Repairs", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Dark mage", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testDarkMageRepairsOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Repairs", MenuAction.NPC_SECOND_OPTION);
		when(config.swapDarkMage()).thenReturn(false);
		testEntrySwapNegative("Dark mage", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testDecantOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Prices", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Decant", MenuAction.NPC_THIRD_OPTION);
		for (final String decantNpc : DECANT_NPCS)
		{
			testEntrySwap(decantNpc, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testDecantOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Prices", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Decant", MenuAction.NPC_THIRD_OPTION);
		when(config.swapDecant()).thenReturn(false);
		for (final String decantNpc : DECANT_NPCS)
		{
			testEntrySwapNegative(decantNpc, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testBankerExchangeOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Exchange", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("History", MenuAction.NPC_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Sets", MenuAction.NPC_FOURTH_OPTION);
		testEntrySwap("Grand Exchange Clerk", 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testBankerExchangeOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Exchange", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("History", MenuAction.NPC_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Sets", MenuAction.NPC_FOURTH_OPTION);
		when(config.swapExchange()).thenReturn(false);
		testEntrySwapNegative("Grand Exchange Clerk", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testFairyRingLastDestinationSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Zanaris", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Configure", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Last-destination (AIQ)", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.LAST_DESTINATION);
		testEntrySwap("Fairy ring", 2, firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testFairyRingZanarisSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Zanaris", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Configure", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Last-destination (AIQ)", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.ZANARIS);
		testEntrySwap("Fairy ring", 0, firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testFairyRingConfigureSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Zanaris", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Configure", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Last-destination (AIQ)", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.CONFIGURE);
		testEntrySwap("Fairy ring", 1, firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testFairyRingSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Zanaris", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Configure", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Last-destination (AIQ)", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.OFF);
		testEntrySwapNegative("Fairy ring", firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testZanarisFairyRingLastDestinationSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Configure", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Last-destination (AIQ)", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.LAST_DESTINATION);
		testEntrySwap("Fairy ring", firstEntry, secondEntry);
	}

	@Test
	public void testZanarisFairyRingZanarisSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Configure", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Last-destination (AIQ)", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.ZANARIS);
		testEntrySwapNegative("Fairy ring", firstEntry, secondEntry);
	}

	@Test
	public void testZanarisFairyRingConfigureSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Configure", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Last-destination (AIQ)", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.CONFIGURE);
		testEntrySwap("Fairy ring", 0, firstEntry, secondEntry);
	}

	@Test
	public void testZanarisFairyRingSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Configure", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Last-destination (AIQ)", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.OFF);
		testEntrySwapNegative("Fairy ring", firstEntry, secondEntry);
	}

	@Test
	public void testHouseSpiritTreeRingLastDestinationSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Tree", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Ring-Zanaris", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Ring-configure", MenuAction.GAME_OBJECT_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Ring-last-destination (AIQ)", MenuAction.GAME_OBJECT_FOURTH_OPTION);
		final MenuEntry fifthEntry = minimalMenuEntry("Remove", MenuAction.GAME_OBJECT_FIFTH_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.LAST_DESTINATION);
		testEntrySwap("Spiritual Fairy Tree", 3, firstEntry, secondEntry, thirdEntry, fourthEntry, fifthEntry);
	}

	@Test
	public void testHouseSpiritTreeRingZanarisSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Tree", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Ring-Zanaris", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Ring-configure", MenuAction.GAME_OBJECT_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Ring-last-destination (AIQ)", MenuAction.GAME_OBJECT_FOURTH_OPTION);
		final MenuEntry fifthEntry = minimalMenuEntry("Remove", MenuAction.GAME_OBJECT_FIFTH_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.ZANARIS);
		testEntrySwap("Spiritual Fairy Tree", 1, firstEntry, secondEntry, thirdEntry, fourthEntry, fifthEntry);
	}

	@Test
	public void testHouseSpiritTreeRingConfigureSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Tree", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Ring-Zanaris", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Ring-configure", MenuAction.GAME_OBJECT_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Ring-last-destination (AIQ)", MenuAction.GAME_OBJECT_FOURTH_OPTION);
		final MenuEntry fifthEntry = minimalMenuEntry("Remove", MenuAction.GAME_OBJECT_FIFTH_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.CONFIGURE);
		testEntrySwap("Spiritual Fairy Tree", 2, firstEntry, secondEntry, thirdEntry, fourthEntry, fifthEntry);
	}

	@Test
	public void testHouseSpiritTreeRingSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Tree", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Ring-Zanaris", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Ring-configure", MenuAction.GAME_OBJECT_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Ring-last-destination (AIQ)", MenuAction.GAME_OBJECT_FOURTH_OPTION);
		final MenuEntry fifthEntry = minimalMenuEntry("Remove", MenuAction.GAME_OBJECT_FIFTH_OPTION);
		when(config.swapFairyRing()).thenReturn(FairyRingMode.OFF);
		testEntrySwapNegative("Spiritual Fairy Tree", firstEntry, secondEntry, thirdEntry, fourthEntry, fifthEntry);
	}

	@Test
	public void testCageHarpoonFishingSpotHarpoonOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Cage", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Harpoon", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Fishing spot", firstEntry, secondEntry);
	}

	@Test
	public void testSmallNetHarpoonFishingSpotHarpoonOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Net", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Harpoon", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Fishing spot", firstEntry, secondEntry);
	}

	@Test
	public void testBigNetHarpoonFishingSpotHarpoonOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Big Net", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Harpoon", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Fishing spot", firstEntry, secondEntry);
	}

	@Test
	public void testLureBaitFishingSpotHarpoonOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Lure", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Bait", MenuAction.NPC_SECOND_OPTION);
		testEntrySwapNegative("Fishing spot", firstEntry, secondEntry);
	}

	@Test
	public void testCageHarpoonFishingSpotHarpoonOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Cage", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Harpoon", MenuAction.NPC_SECOND_OPTION);
		when(config.swapHarpoon()).thenReturn(false);
		testEntrySwapNegative("Fishing spot", firstEntry, secondEntry);
	}

	@Test
	public void testSmallNetHarpoonFishingSpotHarpoonOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Net", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Harpoon", MenuAction.NPC_SECOND_OPTION);
		when(config.swapHarpoon()).thenReturn(false);
		testEntrySwapNegative("Fishing spot", firstEntry, secondEntry);
	}

	@Test
	public void testBigNetHarpoonFishingSpotHarpoonOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Big Net", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Harpoon", MenuAction.NPC_SECOND_OPTION);
		when(config.swapHarpoon()).thenReturn(false);
		testEntrySwapNegative("Fishing spot", firstEntry, secondEntry);
	}

	@Test
	public void testLureBaitFishingSpotHarpoonOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Lure", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Bait", MenuAction.NPC_SECOND_OPTION);
		when(config.swapHarpoon()).thenReturn(false);
		testEntrySwapNegative("Fishing spot", firstEntry, secondEntry);
	}

	@Test
	public void testHousePortalHomeOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Enter", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Home", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Build mode", MenuAction.GAME_OBJECT_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Friend's house", MenuAction.GAME_OBJECT_FOURTH_OPTION);
		when(config.swapHomePortal()).thenReturn(HouseMode.HOME);
		testEntrySwap("Portal", 1, firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testHousePortalFriendsHouseOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Enter", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Home", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Build mode", MenuAction.GAME_OBJECT_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Friend's house", MenuAction.GAME_OBJECT_FOURTH_OPTION);
		when(config.swapHomePortal()).thenReturn(HouseMode.FRIENDS_HOUSE);
		testEntrySwap("Portal", 3, firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testHousePortalBuildModeOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Enter", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Home", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Build mode", MenuAction.GAME_OBJECT_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Friend's house", MenuAction.GAME_OBJECT_FOURTH_OPTION);
		when(config.swapHomePortal()).thenReturn(HouseMode.BUILD_MODE);
		testEntrySwap("Portal", 2, firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testHousePortalOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Enter", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Home", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Build mode", MenuAction.GAME_OBJECT_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Friend's house", MenuAction.GAME_OBJECT_FOURTH_OPTION);
		when(config.swapHomePortal()).thenReturn(HouseMode.ENTER);
		testEntrySwap("Portal", 0, firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testHamMemberPickpocketOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Pickpocket", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("H.A.M. Member", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testHamMemberPickpocketOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Pickpocket", MenuAction.NPC_SECOND_OPTION);
		when(config.swapPickpocket()).thenReturn(false);
		testEntrySwapNegative("H.A.M. Member", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testGardenerPayOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Pay", MenuAction.NPC_SECOND_OPTION);
		for (final String gardenerName : GARDENER_NAMES)
		{
			testEntrySwap(gardenerName, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testGardenerPayOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Pay", MenuAction.NPC_SECOND_OPTION);
		when(config.swapPay()).thenReturn(false);
		for (final String gardenerName : GARDENER_NAMES)
		{
			testEntrySwapNegative(gardenerName, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testShoreSandicrahbQuickTravelOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Quick-travel", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Sandicrahb", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testIslandSandicrahbQuickTravelOptionNoSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Leave-island", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick-travel", MenuAction.NPC_SECOND_OPTION);
		testEntrySwapNegative("Sandicrahb", firstEntry, secondEntry);
	}

	@Test
	public void testBargeGuardQuickTravelOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Board", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Quick-Travel", MenuAction.NPC_THIRD_OPTION);
		testEntrySwap("Barge guard", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testCloisterBellQuickStartOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Ring", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick-start", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("The Cloister Bell", firstEntry, secondEntry);
	}

	@Test
	public void testBarbAssaultLadderOptionNoSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Climb-down", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick-start", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwapNegative("Ladder", firstEntry, secondEntry);
	}

	@Test
	public void testRaidsOlmBarrierQuickPassOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Pass", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick-pass", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("Mystical barrier", firstEntry, secondEntry);
	}

	@Test
	public void testCerberusFlamesQuickPassOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Pass", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick Pass", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("Flames", firstEntry, secondEntry);
	}

	@Test
	public void testShoreSandicrahbQuickTravelOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Quick-travel", MenuAction.NPC_SECOND_OPTION);
		when(config.swapQuick()).thenReturn(false);
		testEntrySwapNegative("Sandicrahb", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testIslandSandicrahbQuickTravelOptionNoSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Leave-island", MenuAction.NPC_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick-travel", MenuAction.NPC_SECOND_OPTION);
		when(config.swapQuick()).thenReturn(false);
		testEntrySwapNegative("Sandicrahb", firstEntry, secondEntry);
	}

	@Test
	public void testBargeGuardQuickTravelOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Board", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Quick-Travel", MenuAction.NPC_THIRD_OPTION);
		when(config.swapQuick()).thenReturn(false);
		testEntrySwapNegative("Barge guard", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testCloisterBellQuickStartOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Ring", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick-start", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapQuick()).thenReturn(false);
		testEntrySwapNegative("The Cloister Bell", firstEntry, secondEntry);
	}

	@Test
	public void testBarbAssaultLadderOptionNoSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Climb-down", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick-start", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapQuick()).thenReturn(false);
		testEntrySwapNegative("Ladder", firstEntry, secondEntry);
	}

	@Test
	public void testRaidsOlmBarrierQuickPassOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Pass", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick-pass", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapQuick()).thenReturn(false);
		testEntrySwapNegative("Mystical barrier", firstEntry, secondEntry);
	}

	@Test
	public void testCerberusFlamesQuickPassOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Pass", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Quick Pass", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapQuick()).thenReturn(false);
		testEntrySwapNegative("Flames", firstEntry, secondEntry);
	}

	@Test
	public void testShakingBoxTrapResetOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Check", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Reset", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("Shaking Box", firstEntry, secondEntry);
	}

	@Test
	public void testSprungBoxTrapResetOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Dismantle", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Reset", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("Box trap", firstEntry, secondEntry);
	}

	@Test
	public void testCollapsedBoxTrapLayOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Take", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Lay", MenuAction.ITEM_SECOND_OPTION);
		testEntrySwap("Box trap", firstEntry, secondEntry);
	}

	@Test
	public void testWaitingBoxTrapOptionsUnmodified()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Dismantle", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Investigate", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwapNegative("Box trap", firstEntry, secondEntry);
	}

	@Test
	public void testBoxTrapResetOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Check", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Reset", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapBoxTrap()).thenReturn(false);
		testEntrySwapNegative("Shaking Box", firstEntry, secondEntry);
	}

	@Test
	public void testSprungBoxTrapResetOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Dismantle", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Reset", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapBoxTrap()).thenReturn(false);
		testEntrySwapNegative("Box trap", firstEntry, secondEntry);
	}

	@Test
	public void testCollapsedBoxTrapLayOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Take", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Lay", MenuAction.ITEM_SECOND_OPTION);
		when(config.swapBoxTrap()).thenReturn(false);
		testEntrySwapNegative("Box trap", firstEntry, secondEntry);
	}

	@Test
	public void testTeleportCapeOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		for (final String teleportCape : TELEPORT_CAPES)
		{
			testEntrySwap(teleportCape, 1, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testConstructionCapeOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Tele to POH", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_FOURTH_OPTION);
		for (final String constructionCape : CONSTRUCTION_CAPES)
		{
			testEntrySwap(constructionCape, 1, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testTrimmableTeleportCapeOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Trim", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_FOURTH_OPTION);
		for (final String trimmableCape : TRIMMABLE_TELEPORT_CAPES)
		{
			testEntrySwap(trimmableCape, 1, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testUnTrimmableTeleportCapeOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Untrim", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_FOURTH_OPTION);
		for (final String unTrimmableCape : UN_TRIMMABLE_TELEPORT_CAPES)
		{
			testEntrySwap(unTrimmableCape, 1, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testTeleportWeaponOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wield", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		for (final String teleportWeapon : TELEPORT_WEAPONS)
		{
			testEntrySwap(teleportWeapon, 1, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testTeleportJewelleryAndArmorOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		for (final String teleportJewelleryOrArmor : TELEPORT_JEWELLERY_AND_ARMOR)
		{
			testEntrySwap(teleportJewelleryOrArmor, 1, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testTeleportJewelleryOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Rub", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		for (final String teleportJewellery : TELEPORT_JEWELLERY)
		{
			testEntrySwap(teleportJewellery, 1, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testSlayerRingTeleportOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Rub", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Check", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		for (final String slayerRing : SLAYER_RINGS)
		{
			testEntrySwap(slayerRing, 1, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testRingOfWealthTeleportOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Features", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Rub", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		for (final String ringOfWealth : RINGS_OF_WEALTH)
		{
			testEntrySwap(ringOfWealth, 2, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testExplorersRingTeleportOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Functions", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		for (final String explorersRing : EXPLORERS_RINGS)
		{
			testEntrySwap(explorersRing, 1, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testChronicleTeleportOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wield", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Check charges", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Destroy", MenuAction.ITEM_FOURTH_OPTION);
		testEntrySwap("Chronicle", 1, firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testXericsTalismanTeleportOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Rub", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Check", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Uncharge", MenuAction.ITEM_FOURTH_OPTION);
		testEntrySwap("Xeric's talisman", 1, firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testDrakansMedallionTeleportOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Rub", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Destroy", MenuAction.ITEM_THIRD_OPTION);
		testEntrySwap("Drakan's medallion", 1, firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testCamuletTeleportOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Check-charge", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Rub", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_FOURTH_OPTION);
		testEntrySwap("Camulet", 2, firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testTeleportCapeOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String teleportCape : TELEPORT_CAPES)
		{
			testEntrySwapNegative(teleportCape,firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testConstructionCapeOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Tele to POH", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_FOURTH_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String constructionCape : CONSTRUCTION_CAPES)
		{
			testEntrySwapNegative(constructionCape, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testTrimmableTeleportCapeOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Trim", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_FOURTH_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String trimmableCape : TRIMMABLE_TELEPORT_CAPES)
		{
			testEntrySwapNegative(trimmableCape, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testUnTrimmableTeleportCapeOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Untrim", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_FOURTH_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String unTrimmableCape : UN_TRIMMABLE_TELEPORT_CAPES)
		{
			testEntrySwapNegative(unTrimmableCape, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testTeleportWeaponOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wield", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String teleportWeapon : TELEPORT_WEAPONS)
		{
			testEntrySwapNegative(teleportWeapon, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testTeleportJewelleryAndArmorOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String teleportJewelleryOrArmor : TELEPORT_JEWELLERY_AND_ARMOR)
		{
			testEntrySwapNegative(teleportJewelleryOrArmor, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testTeleportJewelleryOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Rub", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String teleportJewellery : TELEPORT_JEWELLERY)
		{
			testEntrySwapNegative(teleportJewellery, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testSlayerRingTeleportOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Rub", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Check", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String slayerRing : SLAYER_RINGS)
		{
			testEntrySwapNegative(slayerRing, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testRingOfWealthTeleportOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Features", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Rub", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String ringOfWealth : RINGS_OF_WEALTH)
		{
			testEntrySwapNegative(ringOfWealth, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testExplorersRingTeleportOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Functions", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_THIRD_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		for (final String explorersRing : EXPLORERS_RINGS)
			{
			testEntrySwapNegative(explorersRing, firstEntry, secondEntry, thirdEntry, fourthEntry);
		}
	}

	@Test
	public void testChronicleTeleportOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wield", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Teleport", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Check charges", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Destroy", MenuAction.ITEM_FOURTH_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		testEntrySwapNegative("Chronicle", firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testXericsTalismanTeleportOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Rub", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Check", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Uncharge", MenuAction.ITEM_FOURTH_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		testEntrySwapNegative("Xeric's talisman", firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testDrakansMedallionTeleportOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Rub", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Destroy", MenuAction.ITEM_THIRD_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		testEntrySwapNegative("Drakan's medallion", firstEntry, secondEntry, thirdEntry);
	}

	@Test
	public void testCamuletTeleportOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Wear", MenuAction.ITEM_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Check-charge", MenuAction.ITEM_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Rub", MenuAction.ITEM_THIRD_OPTION);
		final MenuEntry fourthEntry = minimalMenuEntry("Drop", MenuAction.ITEM_FOURTH_OPTION);
		when(config.swapTeleportItem()).thenReturn(false);
		testEntrySwapNegative("Camulet", firstEntry, secondEntry, thirdEntry, fourthEntry);
	}

	@Test
	public void testZamorakMageTeleportOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Teleport", MenuAction.NPC_THIRD_OPTION);
		final int[] swapOrder = {2, 1}; // zamorak mage teleport is processed before trade for entry swapping
		testEntrySwap("Mage of Zamorak", swapOrder, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testZamorakMageTeleportOptionSwapPartialNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Teleport", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTrade()).thenReturn(false);
		testEntrySwap("Mage of Zamorak", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testZamorakMageTeleportOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Teleport", MenuAction.NPC_THIRD_OPTION);
		when(config.swapAbyssTeleport()).thenReturn(false);
		testEntrySwap("Mage of Zamorak", 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testZamorakMageTeleportOptionSwapFullNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Teleport", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTrade()).thenReturn(false);
		when(config.swapAbyssTeleport()).thenReturn(false);
		testEntrySwapNegative("Mage of Zamorak", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testUpgradeableStorageUnitPrivateOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Shared", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Private", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Upgrade", MenuAction.GAME_OBJECT_THIRD_OPTION);
		for (final String upgradeableChest : UPGRADEABLE_STORAGE_CHESTS)
		{
			testEntrySwap(upgradeableChest, 1, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testStorageUnitPrivateOptionSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Shared", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Private", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("Large storage unit", firstEntry, secondEntry);
	}

	@Test
	public void testUpgradeableStorageUnitPrivateOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Shared", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Private", MenuAction.GAME_OBJECT_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Upgrade", MenuAction.GAME_OBJECT_THIRD_OPTION);
		when(config.swapPrivate()).thenReturn(false);
		for (final String upgradeableChest : UPGRADEABLE_STORAGE_CHESTS)
		{
			testEntrySwapNegative(upgradeableChest, firstEntry, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testStorageUnitPrivateOptionSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Shared", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Private", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapPrivate()).thenReturn(false);
		testEntrySwapNegative("Large storage unit", firstEntry, secondEntry);
	}

	@Test
	public void testShopKeeperTradeOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		for (final String shopKeeper : SHOPKEEPERS)
		{
			testEntrySwap(shopKeeper, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testCharterTradeOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Charter", MenuAction.NPC_THIRD_OPTION);
		final int[] swapOrder = {1, 2}; // trade is processed before travel for entry swapping
		for (final String charterNpc : CHARTER_NPCS)
		{
			testEntrySwap(charterNpc, swapOrder, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testBobTradeOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Repair", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Bob", 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testAuburyTradeOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Teleport", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Aubury", 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testShopKeeperTradeOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTrade()).thenReturn(false);
		for (final String shopKeeper : SHOPKEEPERS)
		{
			testEntrySwapNegative(shopKeeper, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testCharterTradeOptionSwapPartialNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Charter", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String charterNpc : CHARTER_NPCS)
		{
			testEntrySwap(charterNpc, 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testCharterTradeOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Charter", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTrade()).thenReturn(false);
		for (final String charterNpc : CHARTER_NPCS)
		{
			testEntrySwap(charterNpc, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testCharterTradeOptionSwapFullNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Charter", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTrade()).thenReturn(false);
		when(config.swapTravel()).thenReturn(false);
		for (final String charterNpc : CHARTER_NPCS)
		{
			testEntrySwapNegative(charterNpc, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testBobTradeOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Repair", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTrade()).thenReturn(false);
		testEntrySwapNegative("Bob", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testAuburyTradeOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Teleport", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTrade()).thenReturn(false);
		testEntrySwapNegative("Aubury", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testEnergyBarrierPayTollSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Pass", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Pay-toll(2-Ecto)", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("Energy barrier", firstEntry, secondEntry);
	}

	@Test
	public void testAlKharidGatePayTollSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Open", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Pay-toll(10gp)", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("Gate", firstEntry, secondEntry);
	}

	@Test
	public void testGrandExchangeKeldagrimTrapdoorSwap()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Inspect", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Travel", MenuAction.GAME_OBJECT_SECOND_OPTION);
		testEntrySwap("Trapdoor", firstEntry, secondEntry);
	}

	@Test
	public void testNpcTravelOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Travel", MenuAction.NPC_SECOND_OPTION);
		for (final String travelNpc : TRAVEL_NPCS)
		{
			testEntrySwap(travelNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testTorfinnTravelOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Travel", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Collect", MenuAction.NPC_THIRD_OPTION);
		testEntrySwap("Torfinn", 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testNpcPayFareOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Pay-fare", MenuAction.NPC_SECOND_OPTION);
		for (final String payFareNpc : PAY_FARE_NPCS)
		{
			testEntrySwap(payFareNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcCharterOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Charter", MenuAction.NPC_THIRD_OPTION);
		final int[] swapOrder = {1, 2}; // trade is processed before travel for entry swapping
		for (final String charterNpc : CHARTER_NPCS)
		{
			testEntrySwap(charterNpc, swapOrder, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testNpcTakeBoatOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Take-boat", MenuAction.NPC_SECOND_OPTION);
		for (final String takeBoatNpc : TAKE_BOAT_NPCS)
		{
			testEntrySwap(takeBoatNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcFlyOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Fly", MenuAction.NPC_SECOND_OPTION);
		for (final String flyNpc : FLY_NPCS)
		{
			testEntrySwap(flyNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcJatizsoOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Jatizso", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Mord Gunnars", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testNpcNeitiznotOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Neitiznot", MenuAction.NPC_SECOND_OPTION);
		testEntrySwap("Maria Gunnars", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testNpcRellekkaOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Rellekka", MenuAction.NPC_SECOND_OPTION);
		for (final String rellekkaNpc : RELLEKKA_TRAVEL_NPCS)
		{
			testEntrySwap(rellekkaNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcFollowOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Follow", MenuAction.NPC_SECOND_OPTION);
		for (final String followNpc : FOLLOW_NPCS)
		{
			testEntrySwap(followNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcTransportOptionSwap()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Transport", MenuAction.NPC_SECOND_OPTION);
		for (final String transportNpc : TRANSPORT_NPCS)
		{
			testEntrySwap(transportNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testEnergyBarrierPayTollSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Pass", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Pay-toll(2-Ecto)", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		testEntrySwapNegative("Energy barrier", firstEntry, secondEntry);
	}

	@Test
	public void testAlKharidGatePayTollSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Open", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Pay-toll(10gp)", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		testEntrySwapNegative("Gate", firstEntry, secondEntry);
	}

	@Test
	public void testGrandExchangeKeldagrimTrapdoorSwapNegative()
	{
		final MenuEntry firstEntry = minimalMenuEntry("Inspect", MenuAction.GAME_OBJECT_FIRST_OPTION);
		final MenuEntry secondEntry = minimalMenuEntry("Travel", MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		testEntrySwapNegative("Trapdoor", firstEntry, secondEntry);
	}

	@Test
	public void testNpcTravelOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Travel", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String travelNpc : TRAVEL_NPCS)
		{
			testEntrySwapNegative(travelNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testTorfinnTravelOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Travel", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Collect", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTravel()).thenReturn(false);
		testEntrySwapNegative("Torfinn", TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
	}

	@Test
	public void testNpcPayFareOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Pay-fare", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String payFareNpc : PAY_FARE_NPCS)
		{
			testEntrySwapNegative(payFareNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcCharterOptionSwapPartialNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Charter", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTrade()).thenReturn(false);
		for (final String charterNpc : CHARTER_NPCS)
		{
			testEntrySwap(charterNpc, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testNpcCharterOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Charter", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String charterNpc : CHARTER_NPCS)
		{
			testEntrySwap(charterNpc, 1, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testNpcCharterOptionSwapFullNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Trade", MenuAction.NPC_SECOND_OPTION);
		final MenuEntry thirdEntry = minimalMenuEntry("Charter", MenuAction.NPC_THIRD_OPTION);
		when(config.swapTrade()).thenReturn(false);
		when(config.swapTravel()).thenReturn(false);
		for (final String charterNpc : CHARTER_NPCS)
		{
			testEntrySwapNegative(charterNpc, TALK_TO_FIRST_ENTRY, secondEntry, thirdEntry);
		}
	}

	@Test
	public void testNpcTakeBoatOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Take-boat", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String takeBoatNpc : TAKE_BOAT_NPCS)
		{
			testEntrySwapNegative(takeBoatNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcFlyOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Fly", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String flyNpc : FLY_NPCS)
		{
			testEntrySwapNegative(flyNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcJatizsoOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Jatizso", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		testEntrySwapNegative("Mord Gunnars", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testNpcNeitiznotOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Neitiznot", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		testEntrySwapNegative("Maria Gunnars", TALK_TO_FIRST_ENTRY, secondEntry);
	}

	@Test
	public void testNpcRellekkaOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Rellekka", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String rellekkaNpc : RELLEKKA_TRAVEL_NPCS)
		{
			testEntrySwapNegative(rellekkaNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcFollowOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Follow", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String followNpc : FOLLOW_NPCS)
		{
			testEntrySwapNegative(followNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	@Test
	public void testNpcTransportOptionSwapNegative()
	{
		final MenuEntry secondEntry = minimalMenuEntry("Transport", MenuAction.NPC_SECOND_OPTION);
		when(config.swapTravel()).thenReturn(false);
		for (final String transportNpc : TRANSPORT_NPCS)
		{
			testEntrySwapNegative(transportNpc, TALK_TO_FIRST_ENTRY, secondEntry);
		}
	}

	private void testEntrySwap(
		final String target,
		final MenuEntry... menuEntries)
	{
		testEntrySwap(target, menuEntries.length - 1, menuEntries);
	}

	private void testEntrySwapNegative(
		final String target,
		final MenuEntry... menuEntries)
	{
		testEntrySwap(target, 0, menuEntries);
	}

	private void testEntrySwap(
		final String target,
		final int swapIndex,
		final MenuEntry... menuEntries)
	{
		testEntrySwap(target, new int[] { swapIndex }, menuEntries);
	}

	/**
	 * Emulates menu entry plugin behavior for swapping menu entries and verifies that the appropriate menu swaps are
	 * performed, or not performed.
	 *
	 * @param target      The target to use for the mocked {@link MenuEntry}s and {@link MenuEntryAdded} event
	 * @param swapIndices An array of entry swaps to be sequentially performed to mimic plugin swap behavior.
	 *                    For instance, [1, 3, 2] would indicate swapping the top entry with menu entries of indexes
	 *                    1, then with index 2, finally with index 3 to result in an ordering of [1, 3, 0, 2].
	 *                    An index of 0 is allowed if and only if it is the only element in the array, in which case
	 *                    this function will assert that no entry swaps occurred.
	 * @param menuEntries An array of {@link MenuEntry}s to be mocked for {@link Client#getMenuEntries()} and compare
	 *                    against the plugin's behavior.
	 */
	private void testEntrySwap(
		final String target,
		final int[] swapIndices,
		final MenuEntry... menuEntries
	)
	{
		assert menuEntries.length >= 2;
		assert swapIndices != null;
		assert swapIndices.length > 0;
		final Set<Integer> swapIndexes = new HashSet<>();
		for (final int swapIndex : swapIndices)
		{
			assert swapIndex >= 0 : "All swap indices must be greater than or equal to 0";
			assert swapIndex < menuEntries.length : "Swap indices must not exceed the number of menu entries provided";
			assert swapIndexes.add(swapIndex) : "There is no case where swap indexes should be duplicated";
			assert swapIndices.length <= 1 || swapIndex >= 1 : "When multiple swap indices are given, no swap should occur for index 0";
		}

		final MenuEntryAdded event = new MenuEntryAdded(
			menuEntries[0].getOption().toLowerCase(),
			target.toLowerCase(),
			menuEntries[0].getType(),
			-1,
			-1,
			-1);
		final MenuEntry[] clientMenuEntries = new MenuEntry[menuEntries.length];

		for (int i = 0; i < clientMenuEntries.length; i++)
		{
			final MenuEntry newMenuEntry = menuEntries[i];
			newMenuEntry.setTarget(target);

			clientMenuEntries[i] = newMenuEntry;
		}

		when(client.getMenuEntries()).thenReturn(Arrays.copyOf(clientMenuEntries, clientMenuEntries.length));
		plugin.onMenuEntryAdded(event);

		if (swapIndices.length == 1 && swapIndices[0] == 0)
		{
			verify(client, times(0)).setMenuEntries(any());
		}
		else
		{
			final MenuEntry[] swappedEntries = Arrays.copyOf(clientMenuEntries, clientMenuEntries.length);
			int swapEntryIndex = 0;

			for (int swapIndex : swapIndices)
			{
				final MenuEntry temp = swappedEntries[swapEntryIndex];
				swappedEntries[swapEntryIndex] = swappedEntries[swapIndex];
				swappedEntries[swapIndex] = temp;
				swapEntryIndex = swapIndex;
			}

			verify(client, atLeastOnce()).setMenuEntries(swappedEntries);
		}
	}

	/**
	 * Creates a minimal {@link MenuEntry} for the purpose of testing menu entry swaps.
	 *
	 * @param option The option of the given menu option. (e.g. "Talk-to" in "Talk-to Hans")
	 * @param action The {@link MenuAction} associated with the menu entry
	 * @return A {@link MenuEntry} with only option and type fields set.
	 */
	private static MenuEntry minimalMenuEntry(final String option, final MenuAction action)
	{
		final MenuEntry newMenuEntry = new MenuEntry();
		newMenuEntry.setOption(option);
		newMenuEntry.setType(action.getId());
		return newMenuEntry;
	}
}
