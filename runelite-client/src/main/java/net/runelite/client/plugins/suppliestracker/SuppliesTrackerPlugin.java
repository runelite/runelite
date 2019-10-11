/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Sir Girion <https://github.com/darakelian>
 * Copyright (c) 2018, Davis Cook <https://github.com/daviscook477>
 * Copyright (c) 2018, Daddy Dozer <Whitedylan7@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.suppliestracker;


import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.api.AnimationID.BLOWPIPE_ATTACK;
import static net.runelite.api.AnimationID.HIGH_LEVEL_MAGIC_ATTACK;
import static net.runelite.api.AnimationID.LOW_LEVEL_MAGIC_ATTACK;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.*;
import net.runelite.api.Player;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.CannonballFired;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import static net.runelite.client.plugins.suppliestracker.ActionType.CAST;
import static net.runelite.client.plugins.suppliestracker.ActionType.CONSUMABLE;
import static net.runelite.client.plugins.suppliestracker.ActionType.TELEPORT;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.item.ItemPrice;


@PluginDescriptor(
	name = "Supplies Used Tracker",
	description = "Tracks supplies used during the session",
	tags = {"cost"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class SuppliesTrackerPlugin extends Plugin
{
	private static final String POTION_PATTERN = "[(]\\d[)]";

	private static final String EAT_PATTERN = "^eat";
	private static final String DRINK_PATTERN = "^drink";
	private static final String TELEPORT_PATTERN = "^teleport";
	private static final String TELETAB_PATTERN = "^break";
	private static final String SPELL_PATTERN = "^cast|^grand\\sexchange|^outside|^seers|^yanille";

	private static final int EQUIPMENT_MAINHAND_SLOT = EquipmentInventorySlot.WEAPON.getSlotIdx();
	private static final int EQUIPMENT_AMMO_SLOT = EquipmentInventorySlot.AMMO.getSlotIdx();
	private static final int EQUIPMENT_CAPE_SLOT = EquipmentInventorySlot.CAPE.getSlotIdx();

	private static final double NO_AVAS_PERCENT = 1.0;
	private static final double ASSEMBLER_PERCENT = 0.20;
	private static final double ACCUMULATOR_PERCENT = 0.28;
	private static final double ATTRACTOR_PERCENT = 0.40;

	private static final int BLOWPIPE_TICKS_RAPID_PVM = 2;
	private static final int BLOWPIPE_TICKS_RAPID_PVP = 3;
	private static final int BLOWPIPE_TICKS_NORMAL_PVM = 3;
	private static final int BLOWPIPE_TICKS_NORMAL_PVP = 4;

	private static final double SCALES_PERCENT = 0.66;

	private static final int POTION_DOSES = 4, CAKE_DOSES = 3, PIZZA_PIE_DOSES = 2;

	private static final Random random = new Random();

	private static final int[] THROWING_IDS = new int[]{BRONZE_DART, IRON_DART, STEEL_DART, BLACK_DART, MITHRIL_DART, ADAMANT_DART, RUNE_DART, DRAGON_DART, BRONZE_KNIFE, IRON_KNIFE, STEEL_KNIFE, BLACK_KNIFE, MITHRIL_KNIFE, ADAMANT_KNIFE, RUNE_KNIFE, BRONZE_THROWNAXE, IRON_THROWNAXE, STEEL_THROWNAXE, MITHRIL_THROWNAXE, ADAMANT_THROWNAXE, RUNE_THROWNAXE, DRAGON_KNIFE, DRAGON_KNIFE_22812, DRAGON_KNIFE_22814, DRAGON_KNIFEP_22808, DRAGON_KNIFEP_22810, DRAGON_KNIFEP, DRAGON_THROWNAXE, CHINCHOMPA_10033, RED_CHINCHOMPA_10034, BLACK_CHINCHOMPA};
	private static final int[] RUNE_IDS = new int[]{AIR_RUNE, WATER_RUNE, EARTH_RUNE, MIND_RUNE, BODY_RUNE, COSMIC_RUNE, CHAOS_RUNE, NATURE_RUNE, LAW_RUNE, DEATH_RUNE, ASTRAL_RUNE, BLOOD_RUNE, SOUL_RUNE, WRATH_RUNE, MIST_RUNE, DUST_RUNE, MUD_RUNE, SMOKE_RUNE, STEAM_RUNE, LAVA_RUNE};

	//Hold Supply Data
	private static final Map<Integer, SuppliesTrackerItem> suppliesEntry = new HashMap<>();
	private ItemContainer old;
	private final Deque<MenuAction> actionStack = new ArrayDeque<>();
	private int ammoId = 0;
	private int ammoAmount = 0;
	private int thrownId = 0;
	private int thrownAmount = 0;
	private boolean ammoLoaded = false;
	private boolean throwingAmmoLoaded = false;
	private boolean mainHandThrowing = false;
	private int mainHand = 0;
	private SuppliesTrackerPanel panel;
	private NavigationButton navButton;
	private final String[] RAIDS_CONSUMABLES = new String[]{"xeric's", "elder", "twisted", "revitalisation", "overload", "prayer enhance", "pysk", "suphi", "leckish", "brawk", "mycil", "roqed", "kyren", "guanic", "prael", "giral", "phluxia", "kryket", "murng", "psykk"};

	private int attackStyleVarbit = -1;
	private int ticks = 0;
	private int ticksInAnimation;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SuppliesTrackerConfig config;

	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		panel = new SuppliesTrackerPanel(itemManager, this);
		final BufferedImage header = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");
		panel.loadHeaderIcon(header);
		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Supplies Tracker")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
		clientToolbar.removeNavigation(navButton);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(CannonballFired.class, this, this::onCannonballFired);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
	}

	@Provides
	SuppliesTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SuppliesTrackerConfig.class);
	}

	private void onGameTick(GameTick tick)
	{
		Player player = client.getLocalPlayer();
		if (player.getAnimation() == BLOWPIPE_ATTACK)
		{
			ticks++;
		}
		if (ticks == ticksInAnimation && (player.getAnimation() == BLOWPIPE_ATTACK))
		{
			double ava_percent = getAccumulatorPercent();
			// randomize the usage of supplies since we CANNOT actually get real supplies used
			if (random.nextDouble() <= ava_percent)
			{
				buildEntries(config.blowpipeAmmo().getDartID());

			}
			if (random.nextDouble() <= SCALES_PERCENT)
			{
				buildEntries(ZULRAHS_SCALES);
			}
			ticks = 0;
		}
	}

	/**
	 * checks the player's cape slot to determine what percent of their darts are lost
	 * - where lost means either break or drop to floor
	 *
	 * @return the percent lost
	 */
	private double getAccumulatorPercent()
	{
		double percent = NO_AVAS_PERCENT;
		ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipment != null && equipment.getItems().length > EQUIPMENT_CAPE_SLOT)
		{
			int capeID = equipment.getItems()[EQUIPMENT_CAPE_SLOT].getId();
			switch (capeID)
			{
				case AVAS_ASSEMBLER:
				case ASSEMBLER_MAX_CAPE:
					percent = ASSEMBLER_PERCENT;
					break;
				case AVAS_ACCUMULATOR:
				case ACCUMULATOR_MAX_CAPE:
					// TODO: the ranging cape can be used as an attractor so this could be wrong
				case RANGING_CAPE:
					percent = ACCUMULATOR_PERCENT;
					break;
				case AVAS_ATTRACTOR:
					percent = ATTRACTOR_PERCENT;
					break;
			}
		}
		return percent;
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		if (attackStyleVarbit == -1 || attackStyleVarbit != client.getVar(VarPlayer.ATTACK_STYLE))
		{
			attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
			if (attackStyleVarbit == 0 || attackStyleVarbit == 3)
			{
				ticksInAnimation = BLOWPIPE_TICKS_NORMAL_PVM;
				if (client.getLocalPlayer() != null &&
					client.getLocalPlayer().getInteracting() instanceof Player)
				{
					ticksInAnimation = BLOWPIPE_TICKS_NORMAL_PVP;
				}
			}
			else if (attackStyleVarbit == 1)
			{
				ticksInAnimation = BLOWPIPE_TICKS_RAPID_PVM;
				if (client.getLocalPlayer() != null &&
					client.getLocalPlayer().getInteracting() instanceof Player)
				{
					ticksInAnimation = BLOWPIPE_TICKS_RAPID_PVP;
				}
			}
		}
	}

	/**
	 * Checks for changes between the provided inventories in runes specifically to add those runes
	 * to the supply tracker
	 * <p>
	 * we can't in general just check for when inventory slots change but this method is only run
	 * immediately after the player performs a cast animation or cast menu click/entry
	 *
	 * @param itemContainer the new inventory
	 * @param oldInv        the old inventory
	 */
	private void checkUsedRunes(ItemContainer itemContainer, Item[] oldInv)
	{
		try
		{
			for (int i = 0; i < itemContainer.getItems().length; i++)
			{
				Item newItem = itemContainer.getItems()[i];
				Item oldItem = oldInv[i];
				boolean isRune = false;
				for (int runeId : RUNE_IDS)
				{
					if (oldItem.getId() == runeId)
					{
						isRune = true;
					}
				}
				if (isRune && (newItem.getId() != oldItem.getId() || newItem.getQuantity() != oldItem.getQuantity()))
				{
					int quantity = oldItem.getQuantity();
					if (newItem.getId() == oldItem.getId())
					{
						quantity -= newItem.getQuantity();
					}
					// ensure that only positive quantities are added since it is reported
					// that sometimes checkUsedRunes is called on the same tick that a player
					// gains runes in their inventory
					if (quantity > 0)
					{
						buildEntries(oldItem.getId(), quantity);
					}
				}
			}
		}
		catch (IndexOutOfBoundsException ignored)
		{
		}
	}

	private void onCannonballFired(CannonballFired cannonballFired)
	{
		buildEntries(CANNONBALL);
	}

	private void onAnimationChanged(AnimationChanged animationChanged)
	{
		if (animationChanged.getActor() == client.getLocalPlayer())
		{
			if (animationChanged.getActor().getAnimation() == HIGH_LEVEL_MAGIC_ATTACK)
			{
				//Trident of the seas
				if (mainHand == TRIDENT_OF_THE_SEAS || mainHand == TRIDENT_OF_THE_SEAS_E || mainHand == TRIDENT_OF_THE_SEAS_FULL)
				{
					buildEntries(CHAOS_RUNE);
					buildEntries(DEATH_RUNE);
					buildEntries(FIRE_RUNE, 5);
					buildEntries(COINS_995, 10);
				}
				//Trident of the swamp
				else if (mainHand == TRIDENT_OF_THE_SWAMP_E || mainHand == TRIDENT_OF_THE_SWAMP || mainHand == UNCHARGED_TOXIC_TRIDENT_E || mainHand == UNCHARGED_TOXIC_TRIDENT)
				{
					buildEntries(CHAOS_RUNE);
					buildEntries(DEATH_RUNE);
					buildEntries(FIRE_RUNE, 5);
					buildEntries(ZULRAHS_SCALES);
				}
				//Sang Staff
				else if (mainHand == SANGUINESTI_STAFF || mainHand == SANGUINESTI_STAFF_UNCHARGED)
				{
					buildEntries(BLOOD_RUNE, 3);
				}
				else
				{
					old = client.getItemContainer(InventoryID.INVENTORY);

					if (old != null && old.getItems() != null && actionStack.stream().noneMatch(a ->
						a.getType() == CAST))
					{
						MenuAction newAction = new MenuAction(CAST, old.getItems());
						actionStack.push(newAction);
					}
				}
			}
			else if (animationChanged.getActor().getAnimation() == LOW_LEVEL_MAGIC_ATTACK)
			{
				old = client.getItemContainer(InventoryID.INVENTORY);

				if (old != null && old.getItems() != null && actionStack.stream().noneMatch(a ->
					a.getType() == CAST))
				{
					MenuAction newAction = new MenuAction(CAST, old.getItems());
					actionStack.push(newAction);
				}
			}
		}
	}

	private void onItemContainerChanged(ItemContainerChanged itemContainerChanged)
	{
		ItemContainer itemContainer = itemContainerChanged.getItemContainer();

		if (itemContainer == client.getItemContainer(InventoryID.INVENTORY) && old != null)
		{
			while (!actionStack.isEmpty())
			{
				MenuAction frame = actionStack.pop();
				ActionType type = frame.getType();
				MenuAction.ItemAction itemFrame;
				Item[] oldInv = frame.getOldInventory();
				switch (type)
				{
					case CONSUMABLE:
						itemFrame = (MenuAction.ItemAction) frame;
						int nextItem = itemFrame.getItemID();
						int nextSlot = itemFrame.getSlot();
						if (itemContainer.getItems()[nextSlot].getId() != oldInv[nextSlot].getId())
						{
							buildEntries(nextItem);
						}
						break;
					case TELEPORT:
						itemFrame = (MenuAction.ItemAction) frame;
						int teleid = itemFrame.getItemID();
						int slot = itemFrame.getSlot();
						if (itemContainer.getItems()[slot].getId() != oldInv[slot].getId() || itemContainer.getItems()[slot].getQuantity() != oldInv[slot].getQuantity())
						{
							buildEntries(teleid);
						}
						break;
					case CAST:
						checkUsedRunes(itemContainer, oldInv);
						break;
				}
			}
		}

		if (itemContainer == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			//set mainhand for trident tracking
			if (itemContainer.getItems().length > EQUIPMENT_MAINHAND_SLOT)
			{
				mainHand = itemContainer.getItems()[EQUIPMENT_MAINHAND_SLOT].getId();
				net.runelite.api.Item mainHandItem = itemContainer.getItems()[EQUIPMENT_MAINHAND_SLOT];
				for (int throwingIDs : THROWING_IDS)
				{
					if (mainHand == throwingIDs)
					{
						mainHandThrowing = true;
						break;
					}
					else
					{
						mainHandThrowing = false;
					}
				}
				if (mainHandThrowing)
				{
					if (throwingAmmoLoaded)
					{
						if (thrownId == mainHandItem.getId())
						{
							if (thrownAmount - 1 == mainHandItem.getQuantity())
							{
								buildEntries(mainHandItem.getId());
								thrownAmount = mainHandItem.getQuantity();
							}
							else
							{
								thrownAmount = mainHandItem.getQuantity();
							}
						}
						else
						{
							thrownId = mainHandItem.getId();
							thrownAmount = mainHandItem.getQuantity();
						}
					}
					else
					{
						thrownId = mainHandItem.getId();
						thrownAmount = mainHandItem.getQuantity();
						throwingAmmoLoaded = true;
					}
				}
			}
			//Ammo tracking
			if (itemContainer.getItems().length > EQUIPMENT_AMMO_SLOT)
			{
				net.runelite.api.Item ammoSlot = itemContainer.getItems()[EQUIPMENT_AMMO_SLOT];
				if (ammoSlot != null)
				{
					if (ammoLoaded)
					{
						if (ammoId == ammoSlot.getId())
						{
							if (ammoAmount - 1 == ammoSlot.getQuantity())
							{
								buildEntries(ammoSlot.getId());
								ammoAmount = ammoSlot.getQuantity();
							}
							else
							{
								ammoAmount = ammoSlot.getQuantity();
							}
						}
						else
						{
							ammoId = ammoSlot.getId();
							ammoAmount = ammoSlot.getQuantity();
						}
					}
					else
					{
						ammoId = ammoSlot.getId();
						ammoAmount = ammoSlot.getQuantity();
						ammoLoaded = true;
					}
				}
			}

		}
	}

	private void onMenuOptionClicked(final MenuOptionClicked event)
	{
		// Uses stacks to push/pop for tick eating
		// Create pattern to find eat/drink at beginning
		Pattern eatPattern = Pattern.compile(EAT_PATTERN);
		Pattern drinkPattern = Pattern.compile(DRINK_PATTERN);
		if ((eatPattern.matcher(event.getOption().toLowerCase()).find() || drinkPattern.matcher(event.getOption().toLowerCase()).find()) &&
			actionStack.stream().noneMatch(a ->
			{
				if (a instanceof MenuAction.ItemAction)
				{
					MenuAction.ItemAction i = (MenuAction.ItemAction) a;
					return i.getItemID() == event.getIdentifier();
				}
				return false;
			}))
		{
			old = client.getItemContainer(InventoryID.INVENTORY);
			int slot = event.getParam0();
			if (old.getItems() != null)
			{
				int pushItem = old.getItems()[event.getParam0()].getId();
				MenuAction newAction = new MenuAction.ItemAction(CONSUMABLE, old.getItems(), pushItem, slot);
				actionStack.push(newAction);
			}
		}

		// Create pattern for teleport scrolls and tabs
		Pattern teleportPattern = Pattern.compile(TELEPORT_PATTERN);
		Pattern teletabPattern = Pattern.compile(TELETAB_PATTERN);
		if (teleportPattern.matcher(event.getTarget().toLowerCase()).find() ||
			teletabPattern.matcher(event.getTarget().toLowerCase()).find())
		{
			old = client.getItemContainer(InventoryID.INVENTORY);

			// Makes stack only contains one teleport type to stop from adding multiple of one teleport
			if (old != null && old.getItems() != null && actionStack.stream().noneMatch(a ->
				a.getType() == TELEPORT))
			{
				int teleid = event.getIdentifier();
				MenuAction newAction = new MenuAction.ItemAction(TELEPORT, old.getItems(), teleid, event.getParam0());
				actionStack.push(newAction);
			}
		}

		// Create pattern for spell cast
		Pattern spellPattern = Pattern.compile(SPELL_PATTERN);
		// note that here we look at the option not target b/c the option for all spells is cast
		// but the target differs based on each spell name
		if (spellPattern.matcher(event.getOption().toLowerCase()).find())
		{
			old = client.getItemContainer(InventoryID.INVENTORY);

			if (old != null && old.getItems() != null && actionStack.stream().noneMatch(a ->
				a.getType() == CAST))
			{
				MenuAction newAction = new MenuAction(CAST, old.getItems());
				actionStack.push(newAction);
			}
		}
	}

	/**
	 * Checks if item name is potion
	 *
	 * @param name the name of the item
	 * @return if the item is a potion - i.e. has a (1) (2) (3) or (4) in the name
	 */
	static boolean isPotion(String name)
	{
		return name.contains("(4)") || name.contains("(3)") || name.contains("(2)") || name.contains("(1)");
	}

	/**
	 * Checks if item name is pizza or pie
	 *
	 * @param name the name of the item
	 * @return if the item is a pizza or a pie - i.e. has pizza or pie in the name
	 */
	static boolean isPizzaPie(String name)
	{
		return name.toLowerCase().contains("pizza") || name.toLowerCase().contains(" pie");
	}

	static boolean isCake(String name, int itemId)
	{
		return name.toLowerCase().contains("cake") || itemId == ItemID.CHOCOLATE_SLICE;
	}

	/**
	 * correct prices for potions, pizzas pies, and cakes
	 * tracker tracks each dose of a potion/pizza/pie/cake as an entire one
	 * so must divide price by total amount of doses in each
	 * this is necessary b/c the most correct/accurate price for these resources is the
	 * full price not the 1-dose price
	 *
	 * @param name   the item name
	 * @param itemId the item id
	 * @param price  the current calculated price
	 * @return the price modified by the number of doses
	 */
	private long scalePriceByDoses(String name, int itemId, long price)
	{
		if (isPotion(name))
		{
			return price / POTION_DOSES;
		}
		if (isPizzaPie(name))
		{
			return price / PIZZA_PIE_DOSES;
		}
		if (isCake(name, itemId))
		{
			return price / CAKE_DOSES;
		}
		return price;
	}

	/**
	 * Add an item to the supply tracker (with 1 count for that item)
	 *
	 * @param itemId the id of the item
	 */
	private void buildEntries(int itemId)
	{
		buildEntries(itemId, 1);
	}

	/**
	 * Add an item to the supply tracker
	 *
	 * @param itemId the id of the item
	 * @param count  the amount of the item to add to the tracker
	 */
	private void buildEntries(int itemId, int count)
	{
		final ItemDefinition itemComposition = itemManager.getItemDefinition(itemId);
		String name = itemComposition.getName();
		long calculatedPrice;

		for (String raidsConsumables : RAIDS_CONSUMABLES)
		{
			if (name.toLowerCase().contains(raidsConsumables))
			{
				return;
			}
		}

		// convert potions, pizzas/pies, and cakes to their full equivalents
		// e.g. a half pizza becomes full pizza, 3 dose potion becomes 4, etc...
		if (isPotion(name))
		{
			name = name.replaceAll(POTION_PATTERN, "(4)");
			itemId = getPotionID(name);
		}
		if (isPizzaPie(name))
		{
			itemId = getFullVersionItemID(itemId);
			name = itemManager.getItemDefinition(itemId).getName();
		}
		if (isCake(name, itemId))
		{
			itemId = getFullVersionItemID(itemId);
			name = itemManager.getItemDefinition(itemId).getName();
		}

		int newQuantity;
		if (suppliesEntry.containsKey(itemId))
		{
			newQuantity = suppliesEntry.get(itemId).getQuantity() + count;
		}
		else
		{
			newQuantity = count;
		}

		// calculate price for amount of doses used
		calculatedPrice = ((long) itemManager.getItemPrice(itemId)) * ((long) newQuantity);
		calculatedPrice = scalePriceByDoses(name, itemId, calculatedPrice);

		// write the new quantity and calculated price for this entry
		SuppliesTrackerItem newEntry = new SuppliesTrackerItem(
			itemId,
			name,
			newQuantity,
			calculatedPrice);

		suppliesEntry.put(itemId, newEntry);
		SwingUtilities.invokeLater(() ->
			panel.addItem(newEntry));
	}

	/**
	 * reset all item stacks
	 */
	void clearSupplies()
	{
		suppliesEntry.clear();
	}

	/**
	 * reset an individual item stack
	 *
	 * @param itemId the id of the item stack
	 */
	void clearItem(int itemId)
	{
		suppliesEntry.remove(itemId);
	}

	/**
	 * Gets the item id that matches the provided name within the itemManager
	 *
	 * @param name the given name
	 * @return the item id for this name
	 */
	private int getPotionID(String name)
	{
		int itemId = 0;

		List<ItemPrice> items = itemManager.search(name);
		for (ItemPrice item : items)
		{
			if (item.getName().contains(name))
			{
				itemId = item.getId();
			}
		}
		return itemId;
	}

	/**
	 * Takes the item id of a partial item (e.g. 1 dose potion, 1/2 a pizza, etc...) and returns
	 * the corresponding full item
	 *
	 * @param itemId the partial item id
	 * @return the full item id
	 */
	private int getFullVersionItemID(int itemId)
	{
		switch (itemId)
		{
			case _12_ANCHOVY_PIZZA:
				itemId = ANCHOVY_PIZZA;
				break;
			case _12_MEAT_PIZZA:
				itemId = MEAT_PIZZA;
				break;
			case _12_PINEAPPLE_PIZZA:
				itemId = PINEAPPLE_PIZZA;
				break;
			case _12_PLAIN_PIZZA:
				itemId = PLAIN_PIZZA;
				break;
			case HALF_A_REDBERRY_PIE:
				itemId = REDBERRY_PIE;
				break;
			case HALF_A_GARDEN_PIE:
				itemId = GARDEN_PIE;
				break;
			case HALF_A_SUMMER_PIE:
				itemId = SUMMER_PIE;
				break;
			case HALF_A_FISH_PIE:
				itemId = FISH_PIE;
				break;
			case HALF_A_BOTANICAL_PIE:
				itemId = BOTANICAL_PIE;
				break;
			case HALF_A_MUSHROOM_PIE:
				itemId = MUSHROOM_PIE;
				break;
			case HALF_AN_ADMIRAL_PIE:
				itemId = ADMIRAL_PIE;
				break;
			case HALF_A_WILD_PIE:
				itemId = WILD_PIE;
				break;
			case HALF_AN_APPLE_PIE:
				itemId = APPLE_PIE;
				break;
			case HALF_A_MEAT_PIE:
				itemId = MEAT_PIE;
				break;
			// note behavior of case means both below cases return CAKE
			case _23_CAKE:
			case SLICE_OF_CAKE:
				itemId = CAKE;
				break;
			case _23_CHOCOLATE_CAKE:
			case CHOCOLATE_SLICE:
				itemId = CHOCOLATE_CAKE;
				break;
		}
		return itemId;
	}
}
