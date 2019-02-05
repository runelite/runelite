/*
 * Copyright (c) 2019, Spedwards <https://github.com/Spedwards>
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
package net.runelite.client.plugins.pohhosts;

import com.google.inject.Provides;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GraphicsObject;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import static net.runelite.api.ObjectID.*;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SetMessage;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import net.runelite.http.api.chat.ChatClient;
import net.runelite.http.api.chat.House;

@PluginDescriptor(
	name = "POH Hosts",
	description = "Adds a chat command broadcasting hosts on your world",
	tags = {"house", "prayer", "rimmington", "yanille"}
)
@Slf4j
public class POHHostsPlugin extends Plugin
{
	private static final String COMMAND_STRING = "!hosts";
	private static final int RIMMINGTON_REGION_ID = 11_826;
	private static final int YANILLE_REGION_ID = 10_032;
	private static final int HOUSE_REGION_ID = 7_769;

	@Inject
	private Client client;

	@Inject
	private ChatClient chatClient;

	@Inject
	private POHHostsConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ChatCommandManager chatCommandManager;

	private House house;
	private int houseState = 0;
	private HouseLocation houseLocation = null;
	private boolean playerInHouse;
	private GameState gameState;

	@Provides
	POHHostsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(POHHostsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		chatCommandManager.registerCommandAsync(COMMAND_STRING, this::hostLookup);
	}

	@Override
	protected void shutDown()
	{
		chatCommandManager.unregisterCommand(COMMAND_STRING);

		removeHost();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		GameState newState = event.getGameState();
		if (gameState == GameState.LOGGED_IN)
		{
			if (newState == GameState.LOGIN_SCREEN || newState == GameState.HOPPING)
			{
				removeHost();
			}
		}
		gameState = newState;
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		IntStream stream = IntStream.of(client.getMapRegions());
		if (stream.anyMatch(id -> id == RIMMINGTON_REGION_ID))
		{
			houseLocation = HouseLocation.RIMMINGTON;
		}
		else if (stream.anyMatch(id -> id == YANILLE_REGION_ID))
		{
			houseLocation = HouseLocation.YANILLE;
		}
		else
		{
			houseLocation = null;
		}

		boolean playerInHouseNew = stream.anyMatch(id -> id == HOUSE_REGION_ID);

		int houseLoadingScreen = client.getVar(Varbits.HOUSE_LOADING_SCREEN);
		if (houseState == 0 && houseLoadingScreen == 2)
		{
			// Entering a house
			houseState = 2;
		}
		else if (houseState == 2 && houseLoadingScreen == 0)
		{
			// Entered a house
			houseState = 0;

			checkNewHost();
		}
		else if (playerInHouseNew && !playerInHouse)
		{
			// Exited a house
			removeHost();
		}

		playerInHouse = playerInHouseNew;
	}

	private void hostLookup(SetMessage setMessage, String message)
	{
		ChatMessageType type = setMessage.getType();

		int world = client.getWorld();
		HouseLocation location = config.location();

		House[] hosts;
		try
		{
			hosts = chatClient.getHosts(world, location.getName());
		}
		catch (IOException ex)
		{
			return;
		}

		List<String> filteredHosts = Arrays.stream(hosts)
			.filter(house ->
			{
				if (config.gildedAltar() && !house.isGuildedAltarPresent())
				{
					return false;
				}
				if (config.occultAltar() && !house.isOccultAltarPresent())
				{
					return false;
				}
				if (config.spiritTree() && !house.isSpiritTreePresent())
				{
					return false;
				}
				if (config.fairyRing() && !house.isFairyRingPresent())
				{
					return false;
				}
				if (config.wildernessObelisk() && !house.isWildernessObeliskPresent())
				{
					return false;
				}
				if (config.repairStand() && !house.isRepairStandPresent())
				{
					return false;
				}
				if (config.combatDummy() && !house.isRepairStandPresent())
				{
					return false;
				}
				return true;
			})
			.map(House::getOwner)
			.limit(5)
			.collect(Collectors.toList());

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Hosts: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.join(", ", filteredHosts))
			.build();

		final MessageNode messageNode = setMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private void checkNewHost()
	{
		Widget privateText = client.getWidget(WidgetInfo.CHATBOX_PRIVATE_MODE);
		if (client.getPlayers().size() > 0)
		{
			return;
		}

		if (client.getVar(Varbits.HOUSE_BUILDING_MODE) == 0 && Text.removeTags(privateText.getText()).equals("On")
			&& client.getVar(Varbits.ACCOUNT_TYPE) == 0)
		{
			if (client.getRealSkillLevel(Skill.CONSTRUCTION) < 67)
			{
				return;
			}

			LocalPoint pos = client.getLocalPlayer().getLocalLocation();
			house = new House();
			house.setOwner(client.getUsername());
			List<GraphicsObject> objects = client.getGraphicsObjects();
			List<NPC> npcs = client.getNpcs();
			objects.forEach(obj ->
			{
				if (obj.getId() == ALTAR_13197 && obj.getLocation().distanceTo(pos) < 10)
				{
					house.setGuildedAltarPresent(true);
				}
				if (obj.getId() == ALTAR_OF_THE_OCCULT && obj.getLocation().distanceTo(pos) < 15)
				{
					house.setOccultAltarPresent(true);
				}
				// TODO: Get Spirit Tree ID
				// TODO: Get Fairy Ring ID
				if (obj.getId() == SPIRITUAL_FAIRY_TREE)
				{
					house.setSpiritTreePresent(true);
					house.setFairyRingPresent(true);
				}
				if (obj.getId() == OBELISK_31554)
				{
					house.setWildernessObeliskPresent(true);
				}
				if (obj.getId() == ARMOUR_REPAIR_STAND)
				{
					house.setRepairStandPresent(true);
				}
				if (obj.getId() == COMBAT_DUMMY || obj.getId() == UNDEAD_COMBAT_DUMMY)
				{
					house.setCombatDummyPresent(true);
				}
			});
			npcs.forEach(npc ->
			{
				if (npc.getId() == NpcID.COMBAT_DUMMY || npc.getId() == NpcID.UNDEAD_COMBAT_DUMMY)
				{
					house.setCombatDummyPresent(true);
				}
			});

			if (house.isGuildedAltarPresent() || house.isOccultAltarPresent())
			{
				try
				{
					chatClient.submitHost(client.getWorld(), houseLocation.getName(), house);
				}
				catch (Exception ex)
				{
					log.warn("unable to submit new host", ex);
				}
			}
		}
	}

	void removeHost()
	{
		try
		{
			chatClient.removeHost(client.getWorld(), houseLocation.getName(), house);
		}
		catch (Exception ex)
		{
			log.warn("unable to remove host", ex);
		}
	}
}
