/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26665;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26666;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26667;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26668;
import static net.runelite.api.ObjectID.EMPTY_WALL;
import net.runelite.api.WallObject;
import net.runelite.api.events.ChatMessage;
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
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Mining",
	description = "Show ore respawn timers and coal bag overlay",
	tags = {"overlay", "skilling", "timers", "coal", "coalbag", "coal bag"},
	enabledByDefault = false
)
public class MiningPlugin extends Plugin
{
	private static final int ROCK_DISTANCE = 14;
	private static final int MINING_GUILD_REGION = 12183;

	private static final Pattern COAL_BAG_EMPTY_MESSAGE = Pattern.compile("^The coal bag is (now )?empty\\.$");
	private static final Pattern COAL_BAG_ONE_MESSAGE = Pattern.compile("^The coal bag contains one piece of coal\\.$");
	private static final Pattern COAL_BAG_AMOUNT_MESSAGE = Pattern.compile("^The coal bag contains (\\d+) pieces of coal\\.$");

	static final int MAX_INVY_SPACE = 28;
	private static final int FULL_BAG_AMOUNT = 27;

	static final String FILL_OPTION = "fill";
	static final String EMPTY_OPTION = "empty";


	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MiningOverlay miningOverlay;

	@Inject
	private MiningCoalBagOverlay coalBagOverlay;

	@Getter
	@Setter
	private int amountOfCoalInBag;

	@Getter(AccessLevel.PACKAGE)
	private final List<RockRespawn> respawns = new ArrayList<>();
	private boolean recentlyLoggedIn;

	@Override
	protected void startUp()
	{
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
			RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(inMiningGuild()).toMillis());
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
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(inMiningGuild()).toMillis());
				respawns.add(rockRespawn);
				break;
			}
			case DEPLETED_VEIN_26665: // Depleted motherlode vein
			case DEPLETED_VEIN_26666: // Depleted motherlode vein
			case DEPLETED_VEIN_26667: // Depleted motherlode vein
			case DEPLETED_VEIN_26668: // Depleted motherlode vein
			{
				Rock rock = Rock.ORE_VEIN;
				RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(), (int) rock.getRespawnTime(inMiningGuild()).toMillis());
				respawns.add(rockRespawn);
				break;
			}
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getWidgetId() != WidgetInfo.INVENTORY.getId())
		{
			return;
		}

		ItemContainer inventoryItemContainer = client.getItemContainer(InventoryID.INVENTORY);

		switch (event.getMenuOption().toLowerCase())
		{
			case FILL_OPTION:
				update((int) Arrays.stream(inventoryItemContainer.getItems()).filter(i -> i.getId() == ItemID.COAL).count());
				break;
			case EMPTY_OPTION:
				int amt = MAX_INVY_SPACE - (int) Arrays.stream(inventoryItemContainer.getItems()).filter(i -> i.getId() != -1).count();
				update(-amt);
				break;
		}
	}

	/**
	 * Use onChatMessage when a player chooses the `Check` menu option on coal bags.
	 *
	 * @param event
	 */
	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String chatMsg = Text.removeTags(event.getMessage());
		if (COAL_BAG_EMPTY_MESSAGE.matcher(chatMsg).find())
		{
			update(-getAmountOfCoalInBag());
		}
		else if (COAL_BAG_ONE_MESSAGE.matcher(chatMsg).find())
		{
			update(-getAmountOfCoalInBag() + 1);
		}
		else
		{
			Matcher matcher = COAL_BAG_AMOUNT_MESSAGE.matcher(chatMsg);
			if (matcher.find())
			{
				update(Integer.parseInt(matcher.group(1)) - getAmountOfCoalInBag());
			}
		}
	}

	/**
	 * Update the player's count of coal in their Coal Bag
	 *
	 * @param delta How much to add/subtract from the amount.
	 *              Supply a negative number to subtract, or positive number to add.
	 */
	protected void update(int delta)
	{
		// check for upper/lower bounds of amount of coal in a bag
		// 0 <= X <= 27
		setAmountOfCoalInBag(Math.max(0, Math.min(FULL_BAG_AMOUNT, getAmountOfCoalInBag() + delta)));
	}

	private boolean inMiningGuild()
	{
		return client.getLocalPlayer().getWorldLocation().getRegionID() == MINING_GUILD_REGION;
	}
}
