/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@PluginDescriptor(
	name = "Supplies Used Tracker",
	description = "Tracks supplies used during the session",
	tags = {"cost"},
	enabledByDefault = false
)
@Slf4j
public class SuppliesTrackerPlugin extends Plugin
{
	private static final String SANFEW_SERUM_DRINK_MESSAGE = "You drink some of your Sanfew Serum.";
	private static final String SUPER_COMBAT_DRINK_MESSAGE = "You drink some of your super combat potion.";
	private static final String SARADOMIN_BREW_DRINK_MESSAGE = "You drink some of the foul liquid.";
	private static final String PRAYER_POTION_DRINK_MESSAGE = "You drink some of your restore prayer potion.";
	private static final String RANGING_POTION_DRINK_MESSAGE = "You drink some of your ranging potion.";
	private static final String ANTI_VENOM_PLUS_DRINK_MESSAGE = "You drink some of your super antivenom potion";
	private static final String SUPER_RESTORE_DRINK_MESSAGE = "You drink some of your super restore potion.";
	private static final String ANTIDOTE_PLUS_PLUS_DRINK_MESSAGE = "You drink some of your antipoison potion.";
	private static final String SUPER_STRENGTH_DRINK_MESSAGE = "You drink some of your strength potion.";
	private static final String EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended super antifire potion.";
	private static final String SUPER_DEFENSE_DRINK_MESSAGE = "You drink some of your defence potion.";
	private static final String SUPER_ATTACK_DRINK_MESSAGE = "You drink some of your attack potion.";
	private static final String MAGIC_POTION_DRINK_MESSAGE = "You drink some of your magic potion.";
	private static final String BATTLEMAGE_POTION_DRINK_MESSAGE = "You drink some of your battlemage potion. It's a little tangy.";
	private static final String BASTION_POTION_DRINK_MESSAGE = "You drink some of your bastion potion. It's a little tangy.";
	private static final String STAMINA_POTION_DRINK_MESSAGE = "You drink some of your stamina potion.";
	private static final String COMBAT_POTION_DRINK_MESSAGE = "You drink some of your combat potion.";
	private static final String ANTIFIRE_POTION_DRINK_MESSAGE = "You drink some of your antifire potion.";
	private static final String EXTENDED_ANTIFIRE_POTION_DRINK_MESSAGE = "You drink some of your extended antifire potion.";
	private static final String FISHING_POTION_DRINK_MESSAGE = "You drink some of your fishing potion.";
	private static final String SUPER_ANTIFIRE_POTION_DRINK_MESSAGE = "You drink some of your super antifire potion.";
	private static final String RESTORE_POTION_DRINK_MESSAGE = "You drink some of your stat restoration potion.";
	private static final String HUNTER_POTION_DRINK_MESSAGE = "You drink some of your Hunter potion.";
	private static final String ANTIVENOM_POTION_DRINK_MESSAGE = "You drink some of your antivenom potion";
	private static final String RELICYMS_BALM_POTION_DRINK_MESSAGE = "You drink some of the Relicym's Balm.";
	private static final String AGILITY_POTION_DRINK_MESSAGE = "You drink some of your agility potion.";
	private static final String MANTA_RAY_EAT_MESSAGE = "You eat the manta ray.";
	private static final String SHARK_EAT_MESSAGE = "You eat the shark.";
	private static final String ANGLER_FISH_EAT_MESSAGE = "You eat the anglerfish.";
	private static final String KARAMBWAN_EAT_MESSAGE = "You eat the Karambwan.";
	private static final String SHRIMP_FOOD_EVENT_MESSAGE  = "You eat the shrimps.";
	private static final String COOKED_CHICKEN_FOOD_EVENT_MESSAGE  = "You eat the chicken.";
	private static final String COOKED_MEAT_FOOD_EVENT_MESSAGE  = "You eat the meat.";
	private static final String SARDINE_FOOD_EVENT_MESSAGE  = "You eat the sardine.";
	private static final String BREAD_FOOD_EVENT_MESSAGE  = "You eat the bread.";
	private static final String HERRING_FOOD_EVENT_MESSAGE  = "You eat the herring.";
	private static final String MACKEREL_FOOD_EVENT_MESSAGE  = "You eat the mackerel.";
	private static final String TROUT_FOOD_EVENT_MESSAGE  = "You eat the trout.";
	private static final String COD_FOOD_EVENT_MESSAGE  = "You eat the cod.";
	private static final String PIKE_FOOD_EVENT_MESSAGE  = "You eat the pike.";
	private static final String SALMON_FOOD_EVENT_MESSAGE  = "You eat the salmon.";
	private static final String TUNA_FOOD_EVENT_MESSAGE  = "You eat the tuna.";
	private static final String JUG_OF_WINE_FOOD_EVENT_MESSAGE  = "You drink the wine.";
	private static final String STEW_FOOD_EVENT_MESSAGE  = "You eat the stew.";
	private static final String LOBSTER_FOOD_EVENT_MESSAGE  = "You eat the lobster.";
	private static final String BASS_FOOD_EVENT_MESSAGE  = "You eat the bass.";
	private static final String SWORDFISH_FOOD_EVENT_MESSAGE  = "You eat the swordfish.";
	private static final String BAKED_POTATO_FOOD_EVENT_MESSAGE  = "You eat a baked potato.";
	private static final String POTATO_WITH_CHEESE_FOOD_EVENT_MESSAGE  = "You eat a baked potato with butter and cheese.";
	private static final String POTATO_WITH_BUTTER_FOOD_EVENT_MESSAGE  = "You eat a baked potato with butter.";
	private static final String MUSHROOM_POTATO_FOOD_EVENT_MESSAGE  = "You eat a baked potato with mushroom and onion.";
	private static final String CHILLI_POTATO_FOOD_EVENT_MESSAGE  = "You eat a baked potato with chilli con carne.";
	private static final String TUNA_POTATO_FOOD_EVENT_MESSAGE  = "You eat a baked potato with tuna and sweetcorn.";
	private static final String MONKFISH_FOOD_EVENT_MESSAGE  = "You eat the monkfish.";
	private static final String CURRY_FOOD_EVENT_MESSAGE  = "You eat the curry.";
	private static final String UGTHANKI_KEBAB_FOOD_EVENT_MESSAGE  = "You eat the ugthanki kebab.";
	private static final String SEA_TURTLE_FOOD_EVENT_MESSAGE  = "You eat the sea turtle.";
	private static final String DARK_CRAB_FOOD_EVENT_MESSAGE  = "You eat the dark crab.";
	private static final String STRAWBERRIES_FOOD_EVENT_MESSAGE  = "You eat a strawberry.";
	private static final String GUTHIX_REST_FOOD_EVENT_MESSAGE  = "You drink the herbal tea.";
	private static final String MEAT_PIE_FOOD_EVENT_MESSAGE  = "You eat half the meat pie.";
	private static final String HALF_MEAT_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining meat pie.";
	private static final String REDBERRY_PIE_FOOD_EVENT_MESSAGE  = "You eat half the redberry pie.";
	private static final String HALF_REDBERRY_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining redberry pie.";
	private static final String GARDEN_PIE_FOOD_EVENT_MESSAGE  = "You eat half the Garden pie.";
	private static final String HALF_GARDEN_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining Garden pie.";
	private static final String SUMMER_PIE_FOOD_EVENT_MESSAGE  = "You eat half the Summer pie.";
	private static final String HALF_SUMMER_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining Summer pie.";
	private static final String FISH_PIE_FOOD_EVENT_MESSAGE  = "You eat half the Fish pie.";
	private static final String HALF_FISH_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining Fish pie.";
	private static final String BOTANICAL_PIE_FOOD_EVENT_MESSAGE  = "You eat half the Botanical pie.";
	private static final String HALF_BOTANICAL_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining Botanical pie.";
	private static final String MUSHROOM_PIE_FOOD_EVENT_MESSAGE  = "You eat half the Mushroom pie.";
	private static final String HALF_MUSHROOM_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining Mushroom pie.";
	private static final String ADMIRAL_PIE_FOOD_EVENT_MESSAGE  = "You eat half the Admiral pie.";
	private static final String HALF_ADMIRAL_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining Admiral pie.";
	private static final String WILD_PIE_FOOD_EVENT_MESSAGE  = "You eat half the Wild pie.";
	private static final String HALF_WILD_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining Wild pie.";
	private static final String APPLE_PIE_FOOD_EVENT_MESSAGE  = "You eat half the apple pie.";
	private static final String HALF_APPLE_PIE_FOOD_EVENT_MESSAGE  = "You eat the remaining apple pie.";
	private static final String PLAIN_PIZZA_FOOD_EVENT_MESSAGE  = "You eat half of the pizza.";
	private static final String HALF_PLAIN_PIZZA_FOOD_EVENT_MESSAGE  = "You eat the remaining pizza.";
	private static final String MEAT_PIZZA_FOOD_EVENT_MESSAGE  = "You eat half of the meat pizza.";
	private static final String HALF_MEAT_PIZZA_FOOD_EVENT_MESSAGE  = "You eat the remaining meat pizza.";
	private static final String ANCHOVY_PIZZA_FOOD_EVENT_MESSAGE  = "You eat half of the anchovy pizza.";
	private static final String HALF_ANCHOVY_PIZZA_FOOD_EVENT_MESSAGE  = "You eat the remaining anchovy pizza.";
	private static final String PINEAPPLE_PIZZA_FOOD_EVENT_MESSAGE  = "You eat half of the pineapple pizza.";
	private static final String HALF_PINEAPPLE_PIZZA_FOOD_EVENT_MESSAGE  = "You eat the remaining pineapple pizza.";
	private static final String FULL_CAKE_FOOD_EVENT_MESSAGE  = "You eat part of the cake.";
	private static final String SECOND_CAKE_FOOD_EVENT_MESSAGE  = "You eat some more of the cake.";
	private static final String SLICE_CAKE_FOOD_EVENT_MESSAGE  = "You eat the slice of cake.";
	private static final String CHOCOLATE_CAKE_FOOD_EVENT_MESSAGE  = "You eat part of the chocolate cake.";
	private static final String SECOND_CHOCOLATE_CAKE_FOOD_EVENT_MESSAGE  = "You eat some more of the chocolate cake.";
	private static final String SLICE_CHOCOLATE_CAKE_FOOD_EVENT_MESSAGE  = "You eat the slice of chocolate cake.";
	private final int[] POTIONS = {2430, 2434, 6685, 12695, 10925, 2440, 2436, 22209, 2442 , 5952, 3024, 12913, 2444, 4417, 2450, 3040, 22449, 22461, 12625, 2446, 2448, 9739, 2452, 11951, 2438, 21978, 127, 9998, 12905, 4842, 3032, 5943};
	private final int[] PIZZASPIES = {2301, 2297, 2293, 2289, 2323, 7208, 7198, 21690, 19662, 7188, 7218, 7178, 2325, 2327};

	//Hold Supply Data
	private static HashMap<Integer, Integer> suppliesUsed = new HashMap<>();
	private static HashMap<Integer, SuppliesTrackerItemEntry> suppliesEntry = new HashMap<>();

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private Client client;

	private SuppliesTrackerPanel panel;
	private NavigationButton navButton;

	
	@Override
	protected void startUp() throws Exception
	{
		panel = new SuppliesTrackerPanel(itemManager);
		final BufferedImage header = ImageUtil.getResourceStreamFromClass(getClass(), "sarabrew.png");
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
		clientToolbar.removeNavigation(navButton);
	}


	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		int temp;
		int itemId;

		//Cost Calc Triggers
		switch (event.getMessage())
		{
			case SANFEW_SERUM_DRINK_MESSAGE:
				itemId = 10925;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SUPER_COMBAT_DRINK_MESSAGE:
				itemId = 12695;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SARADOMIN_BREW_DRINK_MESSAGE:
				itemId = 6685;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case PRAYER_POTION_DRINK_MESSAGE:
				itemId = 2434;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);

				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case RANGING_POTION_DRINK_MESSAGE:
				itemId = 2444;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case ANTI_VENOM_PLUS_DRINK_MESSAGE:
				itemId = 12913;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SUPER_RESTORE_DRINK_MESSAGE:
				itemId = 3024;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case ANTIDOTE_PLUS_PLUS_DRINK_MESSAGE:
				itemId = 5952;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SUPER_STRENGTH_DRINK_MESSAGE:
				itemId = 2440;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));

				break;
			case EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE:
				itemId = 22209;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SUPER_DEFENSE_DRINK_MESSAGE:
				itemId = 2442;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SUPER_ATTACK_DRINK_MESSAGE:
				itemId = 2436;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case MANTA_RAY_EAT_MESSAGE:
				itemId = 391;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SHARK_EAT_MESSAGE:
				itemId = 385;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case ANGLER_FISH_EAT_MESSAGE:
				itemId = 13441;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case KARAMBWAN_EAT_MESSAGE:
				itemId = 3144;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SHRIMP_FOOD_EVENT_MESSAGE:
				itemId = 315;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case COOKED_CHICKEN_FOOD_EVENT_MESSAGE:
				itemId = 2140;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case COOKED_MEAT_FOOD_EVENT_MESSAGE:
				itemId = 2142;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SARDINE_FOOD_EVENT_MESSAGE:
				itemId = 325;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case BREAD_FOOD_EVENT_MESSAGE:
				itemId = 2309;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case HERRING_FOOD_EVENT_MESSAGE:
				itemId = 347;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case MACKEREL_FOOD_EVENT_MESSAGE:
				itemId = 355;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case TROUT_FOOD_EVENT_MESSAGE:
				itemId = 333;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case COD_FOOD_EVENT_MESSAGE:
				itemId = 339;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case PIKE_FOOD_EVENT_MESSAGE:
				itemId = 351;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SALMON_FOOD_EVENT_MESSAGE:
				itemId = 329;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case TUNA_FOOD_EVENT_MESSAGE:
				itemId = 361;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case JUG_OF_WINE_FOOD_EVENT_MESSAGE:
				itemId = 1993;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case STEW_FOOD_EVENT_MESSAGE:
				itemId = 2003;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case LOBSTER_FOOD_EVENT_MESSAGE:
				itemId = 379;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case BASS_FOOD_EVENT_MESSAGE:
				itemId = 365;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SWORDFISH_FOOD_EVENT_MESSAGE:
				itemId = 373;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case BAKED_POTATO_FOOD_EVENT_MESSAGE:
				itemId = 6701;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case POTATO_WITH_CHEESE_FOOD_EVENT_MESSAGE:
				itemId = 6705;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case POTATO_WITH_BUTTER_FOOD_EVENT_MESSAGE:
				itemId = 6703;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case MUSHROOM_POTATO_FOOD_EVENT_MESSAGE:
				itemId = 7058;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case CHILLI_POTATO_FOOD_EVENT_MESSAGE:
				itemId = 7054;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case TUNA_POTATO_FOOD_EVENT_MESSAGE:
				itemId = 7060;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case MONKFISH_FOOD_EVENT_MESSAGE:
				itemId = 7946;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case CURRY_FOOD_EVENT_MESSAGE:
				itemId = 2011;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case UGTHANKI_KEBAB_FOOD_EVENT_MESSAGE:
				itemId = 1883;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SEA_TURTLE_FOOD_EVENT_MESSAGE:
				itemId = 397;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case DARK_CRAB_FOOD_EVENT_MESSAGE:
				itemId = 11936;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case STRAWBERRIES_FOOD_EVENT_MESSAGE:
				itemId = 5504;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case GUTHIX_REST_FOOD_EVENT_MESSAGE:
				itemId = 4417;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case MEAT_PIE_FOOD_EVENT_MESSAGE:
			case HALF_MEAT_PIE_FOOD_EVENT_MESSAGE:
				itemId = 2327;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case REDBERRY_PIE_FOOD_EVENT_MESSAGE:
			case HALF_REDBERRY_PIE_FOOD_EVENT_MESSAGE:
				itemId = 2325;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case GARDEN_PIE_FOOD_EVENT_MESSAGE:
			case HALF_GARDEN_PIE_FOOD_EVENT_MESSAGE:
				itemId = 7178;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SUMMER_PIE_FOOD_EVENT_MESSAGE:
			case HALF_SUMMER_PIE_FOOD_EVENT_MESSAGE:
				itemId = 7218;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case FISH_PIE_FOOD_EVENT_MESSAGE:
			case HALF_FISH_PIE_FOOD_EVENT_MESSAGE:
				itemId = 7188;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case BOTANICAL_PIE_FOOD_EVENT_MESSAGE:
			case HALF_BOTANICAL_PIE_FOOD_EVENT_MESSAGE:
				itemId = 19662;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case MUSHROOM_PIE_FOOD_EVENT_MESSAGE:
			case HALF_MUSHROOM_PIE_FOOD_EVENT_MESSAGE:
				itemId = 21690;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case ADMIRAL_PIE_FOOD_EVENT_MESSAGE:
			case HALF_ADMIRAL_PIE_FOOD_EVENT_MESSAGE:
				itemId = 7198;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case WILD_PIE_FOOD_EVENT_MESSAGE:
			case HALF_WILD_PIE_FOOD_EVENT_MESSAGE:
				itemId = 7208;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case APPLE_PIE_FOOD_EVENT_MESSAGE:
			case HALF_APPLE_PIE_FOOD_EVENT_MESSAGE:
				itemId = 2323;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case PLAIN_PIZZA_FOOD_EVENT_MESSAGE:
			case HALF_PLAIN_PIZZA_FOOD_EVENT_MESSAGE:
				itemId = 2289;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case MEAT_PIZZA_FOOD_EVENT_MESSAGE:
			case HALF_MEAT_PIZZA_FOOD_EVENT_MESSAGE:
				itemId = 2293;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case ANCHOVY_PIZZA_FOOD_EVENT_MESSAGE:
			case HALF_ANCHOVY_PIZZA_FOOD_EVENT_MESSAGE:
				itemId = 2297;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case PINEAPPLE_PIZZA_FOOD_EVENT_MESSAGE:
			case HALF_PINEAPPLE_PIZZA_FOOD_EVENT_MESSAGE:
				itemId = 2301;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case FULL_CAKE_FOOD_EVENT_MESSAGE:
			case SECOND_CAKE_FOOD_EVENT_MESSAGE:
			case SLICE_CAKE_FOOD_EVENT_MESSAGE:
				itemId = 1891;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case CHOCOLATE_CAKE_FOOD_EVENT_MESSAGE:
			case SECOND_CHOCOLATE_CAKE_FOOD_EVENT_MESSAGE:
			case SLICE_CHOCOLATE_CAKE_FOOD_EVENT_MESSAGE:
				itemId = 1897;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case MAGIC_POTION_DRINK_MESSAGE:
				itemId = 3040;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case BATTLEMAGE_POTION_DRINK_MESSAGE:
				itemId = 22449;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case BASTION_POTION_DRINK_MESSAGE:
				itemId = 22461;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case STAMINA_POTION_DRINK_MESSAGE:
				itemId = 12625;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case COMBAT_POTION_DRINK_MESSAGE:
				itemId = 9739;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case ANTIFIRE_POTION_DRINK_MESSAGE:
				itemId = 2452;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case EXTENDED_ANTIFIRE_POTION_DRINK_MESSAGE:
				itemId = 11951;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case FISHING_POTION_DRINK_MESSAGE:
				itemId = 2438;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case SUPER_ANTIFIRE_POTION_DRINK_MESSAGE:
				itemId = 21978;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case RESTORE_POTION_DRINK_MESSAGE:
				itemId = 2430;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case HUNTER_POTION_DRINK_MESSAGE:
				itemId = 9998;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case ANTIVENOM_POTION_DRINK_MESSAGE:
				itemId = 12905;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case RELICYMS_BALM_POTION_DRINK_MESSAGE:
				itemId = 4842;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
			case AGILITY_POTION_DRINK_MESSAGE:
				itemId = 3032;
				if (suppliesUsed.containsKey(itemId))
				{
					temp = suppliesUsed.get(itemId) + 1;
					suppliesUsed.put(itemId, temp);
				}
				else
				{
					suppliesUsed.put(itemId, 1);
				}
				buildEntries(itemId, suppliesUsed.get(itemId));
				break;
		}


	}

	private void buildEntries(int itemId, int quantity)
	{
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;
		String name = itemComposition.getName();
		long price = (long)itemManager.getItemPrice(realItemId) * (long)quantity;
		boolean potion = false;
		boolean pizzapie = false;

		//Check if item is potion, pie, or pizza
		for (int element:POTIONS)
		{
			if ( element == itemId )
			{
				potion = true;
			}
		}
		for (int element:PIZZASPIES)
		{
			if ( element == itemId )
			{
				pizzapie = true;
			}
		}

		//Divide price if true
		if (potion)
		{
			price = price / 4;
		}
		if (pizzapie)
		{
			price = price / 2;
		}

		//Correct price for cake
		if (itemId == 1891 || itemId == 1897)
		{
			price = price / 3;
		}

		//Check for duplicates
		if (!suppliesEntry.containsKey(itemId))
		{
			suppliesEntry.put(itemId, new SuppliesTrackerItemEntry(
				itemId,
				name,
				quantity,
				price));
		}
		else
			{
				suppliesEntry.remove(itemId);
				suppliesEntry.put(itemId, new SuppliesTrackerItemEntry(
					itemId,
					name,
					quantity,
					price));
			}
		SwingUtilities.invokeLater(() ->
		{
			try
			{
				panel.addRow(suppliesEntry);
			}
			catch (ExecutionException e)
			{
				e.printStackTrace();
			}
		});
	}

	//Used for reset all
	void clearSupplies()
	{
		suppliesEntry.clear();
		suppliesUsed.clear();
	}


	//Used for reset item row
	void clearItem(int itemId)
	{
		suppliesUsed.remove(itemId);
		suppliesEntry.remove(itemId);
	}

}
