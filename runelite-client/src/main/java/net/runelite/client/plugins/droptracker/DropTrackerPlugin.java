/*
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
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
package net.runelite.client.plugins.droptracker;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Actor;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.Node;
import net.runelite.api.Item;
import net.runelite.api.ItemLayer;
import net.runelite.api.Player;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import net.runelite.api.events.ActorDespawned;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ActorDeath;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.plugins.grounditems.GroundItemsConfig;

import javax.imageio.ImageIO;
import javax.inject.Inject;

@PluginDescriptor(
	name = "Drop Tracker",
	moreThenOneConfig = true,
	skipTest = true
)
@Slf4j
public class DropTrackerPlugin extends Plugin implements KeyListener
{
	private List<Opponent> opponent = new ArrayList<>();

	private NavigationButton navButton;
	private DropTrackerPanel dropTrackerPanel;

	@Inject
	private DropTrackerConfig dropTrackerConfig;

	@Provides
	DropTrackerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DropTrackerConfig.class);
	}

	@Inject
	private GroundItemsConfig groundItemsConfig;

	@Provides
	GroundItemsConfig getConfig1(ConfigManager configManager)
	{
		return configManager.getConfig(GroundItemsConfig.class);
	}

	@Inject
	private ItemManager itemManager;

	@Inject
	private Client client;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private KeyManager keyManager;

	@Getter
	private boolean keyIsPress;

	@Override
	protected void startUp() throws Exception
	{
		dropTrackerPanel = new DropTrackerPanel(this, client, dropTrackerConfig, groundItemsConfig);

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("slayer.png"));
		}

		navButton = NavigationButton.builder()
				.tooltip("Drop Tracker")
				.icon(icon)
				.priority(5)
				.panel(dropTrackerPanel)
				.build();

		pluginToolbar.addNavigation(navButton);

		keyIsPress = false;

		if (dropTrackerConfig.fastRemove())
		{
			keyManager.registerKeyListener(this);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(navButton);
		keyManager.unregisterKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() != KeyEvent.VK_SHIFT && !dropTrackerConfig.fastRemove())
		{
			return;
		}
		keyIsPress = true;
		dropTrackerPanel.KeyListenerChanged();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() != KeyEvent.VK_SHIFT && !dropTrackerConfig.fastRemove())
		{
			return;
		}
		keyIsPress = false;
		dropTrackerPanel.KeyListenerChanged();
	}

	@Subscribe
	public void onConfigChange(ConfigChanged event)
	{
		if (event.getKey().equals("fastRemove"))
		{
			if (event.getNewValue().equals("true"))
			{
				keyManager.registerKeyListener(this);
				return;
			}
			keyManager.unregisterKeyListener(this);
			keyIsPress = false;
		}
		else
		{
			dropTrackerPanel.reload();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (getOpponent() == null)
		{
			return;
		}
		for (Opponent opp : opponent)
		{
			if (opp.getOpponent() == getOpponent())
			{
				return;
			}
		}

		opponent.add(new Opponent(getOpponent()));
		log.debug("game tick detect - " + opponent.toString());
	}

	@Subscribe
	public void onActorDeath(ActorDeath event)
	{
		if (event.getActor() == null)
		{
			return;
		}
		for (Opponent opp : opponent)
		{
			if (opp.getOpponent() != event.getActor())
			{
				continue;
			}
			opp.setActorIsDead(true);
			opp.setOldDroppedItems(GetItemDropFromActor(opp.getOpponent()));
			return;
		}
	}

	//Update the tile between ticks because I want to get the most accurate drops
	//And sometimes items spawn in the middle of the death animation
	//So this will check the tile just before the Actor is despawn
	@Schedule(
			period = 100,
			unit = ChronoUnit.MILLIS
	)
	public void UpdateDeadActorTile()
	{
		for (Opponent opp : opponent)
		{
			if (opp.isActorIsDead())
			{
				opp.setOldDroppedItems(GetItemDropFromActor(opp.getOpponent()));
			}
		}
	}

	@Subscribe
	public void onActorDespawned(ActorDespawned event)
	{
		if (event.getActor() == null)
		{
			return;
		}
		for (Opponent opp : opponent)
		{
			if (opp.getOpponent() != event.getActor() || !opp.isActorIsDead())
			{
				continue;
			}

			opp.setActorIsDead(false);

			List<ItemData> newItemData = new ArrayList<>();
			for (ItemData newItem : GetItemDropFromActor(opp.getOpponent()))
			{
				boolean match = false;
				for (ItemData oldItem : opp.getOldDroppedItems())
				{
					if (newItem.getId() != oldItem.getId())
					{
						continue;
					}
					if (newItem.getAmount() <= oldItem.getAmount())
					{
						match = true;
						break;
					}
					newItemData.add(new ItemData(newItem.getId(), newItem.getAmount() - oldItem.getAmount(), itemManager));
					match = true;
					break;
				}
				if (match)
				{
					continue;
				}
				newItemData.add(newItem);
			}
			opp.setNewDroppedItems(newItemData);
			dropTrackerPanel.newDrop(new Drop(opp.getOpponent().getName(), opp.getNewDroppedItems()));
			log.debug("npc drop - " + opp.getNewDroppedItems().toString());
			opponent.remove(opp);
			return;
		}
	}

	private List<Item> getItemListFromActor(Actor actor)
	{
		final Region region = client.getRegion();
		final Tile[][][] tiles = region.getTiles();
		//get the drop X location
		final int x = actor.getLocalLocation().getRegionX() - actor.getWorldArea().getWidth() + 1;
		//get the drop Y location
		final int y = actor.getLocalLocation().getRegionY() - actor.getWorldArea().getHeight() + 1;
		final int z = client.getPlane();

		ItemLayer layer = tiles[z][x][y].getItemLayer();
		if (layer == null)
		{
			return null;
		}

		List<Item> result = new ArrayList<>();
		Node node = layer.getBottom();
		while (node instanceof Item)
		{
			result.add((Item)node);
			node = node.getNext();
		}
		return result;
	}

	private List<ItemData> GetItemDropFromActor(Actor actor)
	{
		List<Item> itemsFromTile = getItemListFromActor(actor);
		if (itemsFromTile == null)
		{
			return new ArrayList<>();
		}
		List<ItemData> itemData = new ArrayList<>();
		for (Item current : itemsFromTile)
		{
			ItemData ID = new ItemData(current, itemManager);
			boolean match = false;
			for (ItemData item : itemData)
			{
				if (item.getId() != ID.getId())
				{
					continue;
				}
				item.addAmount(ID.getAmount());
				match = true;
			}
			if (match)
			{
				continue;
			}
			itemData.add(ID);
		}
		return itemData;
	}

	private Actor getOpponent()
	{
		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		return player.getInteracting();
	}

	//This part is for dev mode only, to test drops and stuff

	private int amount = 0;

	void testDrops()
	{
		ItemData[] ID = new ItemData[6];
		Integer[] ItemID = {68, 9542, 568, 1256, 13576, 12817};
		Integer[] Amount = {30, 5, 15, 3148, 2, 1};
		for (int i = 0; i < 6; i++)
		{
			ID[i] = new ItemData(ItemID[i], Amount[i], itemManager);
		}

		log.debug(Arrays.asList(ID).toString());
		Drop drop = new Drop("test" + amount, ID);
		dropTrackerPanel.newDrop(drop);
		amount++;
	}
}
