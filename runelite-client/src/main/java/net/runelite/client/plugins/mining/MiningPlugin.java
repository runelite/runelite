/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Anthony <cvballa3g0@gmail.com>
 * Copyright (c) 2019, Jarred Vardy <jarred.vardy@gmail.com>
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
package net.runelite.client.plugins.mining;

import com.google.inject.Provides;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26665;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26666;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26667;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26668;
import static net.runelite.api.ObjectID.EMPTY_WALL;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import net.runelite.api.WallObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Mining",
	description = "Show ore respawn timers and coal bag overlay",
	tags = {"overlay", "skilling", "timers", "coal", "coalbag", "coal bag"},
	enabledByDefault = false
)
@Singleton
public class MiningPlugin extends Plugin
{
	// private static final int ROCK_DISTANCE = 14;
	private static final int MINING_GUILD_REGION = 12183;

	private static final Pattern COAL_BAG_EMPTY_MESSAGE = Pattern.compile("^The coal bag is (now )?empty\\.$");
	private static final Pattern COAL_BAG_ONE_MESSAGE = Pattern.compile("^The coal bag contains one piece of coal\\.$");
	private static final Pattern COAL_BAG_AMOUNT_MESSAGE = Pattern.compile("^The coal bag contains (\\d+) pieces of coal\\.$");

	private static final int MAX_INVENTORY_SPACE = 28;
	private static final int FULL_COAL_BAG_AMOUNT = 27;

	private static final String FILL_OPTION = "fill";
	private static final String EMPTY_OPTION = "empty";

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MiningOverlay miningOverlay;

	@Inject
	private MiningCoalBagOverlay coalBagOverlay;

	@Inject
	private MiningConfig config;

	@Getter(AccessLevel.PACKAGE)
	private final List<RockRespawn> respawns = new ArrayList<>();
	private boolean recentlyLoggedIn;

	@Getter(AccessLevel.PACKAGE)
	private boolean showCoalBagOverlay;
	@Getter(AccessLevel.PACKAGE)
	private int amountOfCoalInCoalBag;

	@Override
	protected void startUp()
	{
		this.showCoalBagOverlay = config.showCoalBagOverlay();
		this.amountOfCoalInCoalBag = config.amountOfCoalInCoalBag();

		overlayManager.add(miningOverlay);
		overlayManager.add(coalBagOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(miningOverlay);
		overlayManager.remove(coalBagOverlay);
		respawns.clear();
	}

	@Provides
	MiningConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MiningConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
			case HOPPING:
				respawns.clear();
				break;
			case LOGGED_IN:
				// After login rocks that are depleted will be changed,
				// so wait for the next game tick before watching for
				// rocks to deplete
				recentlyLoggedIn = true;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		recentlyLoggedIn = false;
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || recentlyLoggedIn)
		{
			return;
		}

		final GameObject object = event.getGameObject();

		Rock rock = Rock.getRock(object.getId());
		if (rock != null)
		{
			RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(inMiningGuild()).toMillis(), rock.getZOffset());
			respawns.add(rockRespawn);
		}
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final WallObject object = event.getWallObject();

		switch (object.getId())
		{
			case EMPTY_WALL:
			{
				Rock rock = Rock.AMETHYST;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(inMiningGuild()).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
				break;
			}
			case DEPLETED_VEIN_26665: // Depleted motherlode vein
			case DEPLETED_VEIN_26666: // Depleted motherlode vein
			case DEPLETED_VEIN_26667: // Depleted motherlode vein
			case DEPLETED_VEIN_26668: // Depleted motherlode vein
			{
				Rock rock = Rock.ORE_VEIN;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(inMiningGuild()).toMillis(), rock.getZOffset());
				respawns.add(rockRespawn);
				break;
			}
			case ORE_VEIN_26661: // Motherlode vein
			case ORE_VEIN_26662: // Motherlode vein
			case ORE_VEIN_26663: // Motherlode vein
			case ORE_VEIN_26664: // Motherlode vein
			{
				// If the vein respawns before the timer is up, remove it
				final WorldPoint point = object.getWorldLocation();
				respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
				break;
			}
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		//TODO: should work hopefully
		if (event.getMenuAction() != MenuAction.RUNELITE || event.getActionParam1() != WidgetInfo.INVENTORY.getId())
		{
			return;
		}

		ItemContainer inventoryItemContainer = client.getItemContainer(InventoryID.INVENTORY);
		Item[] inventoryItems = new Item[0];
		if (inventoryItemContainer != null)
		{
			inventoryItems = inventoryItemContainer.getItems();
		}

		switch (event.getOption().toLowerCase())
		{
			case FILL_OPTION:
				int coalInInventoryCount = (int) Arrays.stream(inventoryItems).filter(i -> i.getId() == ItemID.COAL).count();
				updateAmountOfCoalInBag(coalInInventoryCount);
				break;

			case EMPTY_OPTION:
				int emptyInventorySpaceCount = (int) Arrays.stream(inventoryItems).filter(i -> i.getId() != -1).count();
				int difference = MAX_INVENTORY_SPACE - emptyInventorySpaceCount;
				updateAmountOfCoalInBag(-difference);
				break;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		String chatMsg = event.getMessage();
		if (COAL_BAG_EMPTY_MESSAGE.matcher(chatMsg).find())
		{
			updateAmountOfCoalInBag(0);
		}
		else if (COAL_BAG_ONE_MESSAGE.matcher(chatMsg).find())
		{
			updateAmountOfCoalInBag(1);
		}
		else
		{
			Matcher matcher = COAL_BAG_AMOUNT_MESSAGE.matcher(chatMsg);
			if (matcher.find())
			{
				updateAmountOfCoalInBag(Integer.parseInt(matcher.group(1)) - this.amountOfCoalInCoalBag);
			}
		}
	}

	/**
	 * Update the player's count of coal in their Coal Bag
	 *
	 * @param delta How much to add/subtract from the amount.
	 *              Supply a negative number to subtract, or positive number to add.
	 */
	private void updateAmountOfCoalInBag(int delta)
	{
		// check for upper/lower bounds of amount of coal in a bag
		// 0 <= X <= 27
		int coalbagAmount = Math.max(0, Math.min(FULL_COAL_BAG_AMOUNT, this.amountOfCoalInCoalBag + delta));
		config.amountOfCoalInCoalBag(coalbagAmount);
		this.amountOfCoalInCoalBag = coalbagAmount;
	}

	private boolean inMiningGuild()
	{
		return client.getLocalPlayer().getWorldLocation().getRegionID() == MINING_GUILD_REGION;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("mining"))
		{
			return;
		}

		this.showCoalBagOverlay = config.showCoalBagOverlay();
		this.amountOfCoalInCoalBag = config.amountOfCoalInCoalBag();
	}
}
