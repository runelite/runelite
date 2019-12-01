/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.playerscouter;

import com.google.inject.Provides;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.PlayerContainer;
import net.runelite.client.game.PlayerManager;
import net.runelite.client.game.WorldLocation;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.http.api.discord.DiscordClient;
import net.runelite.http.api.discord.DiscordEmbed;
import net.runelite.http.api.discord.DiscordMessage;
import net.runelite.http.api.discord.embed.AuthorEmbed;
import net.runelite.http.api.discord.embed.FieldEmbed;
import net.runelite.http.api.discord.embed.FooterEmbed;
import net.runelite.http.api.discord.embed.ThumbnailEmbed;
import net.runelite.http.api.item.ItemStats;
import okhttp3.HttpUrl;

@PluginDescriptor(
	name = "Player Scouter",
	description = "Scout players and output them to your discord channel!",
	type = PluginType.PVP,
	enabledByDefault = false
)
@Slf4j
public class PlayerScouter extends Plugin
{
	private static final DiscordClient DISCORD_CLIENT = new DiscordClient();
	private static final SimpleDateFormat SDF = new SimpleDateFormat("MMM dd h:mm a z");
	private static final String ICON_URL = "https://www.osrsbox.com/osrsbox-db/items-icons/"; // Add item id + ".png"

	@Inject
	private Client client;
	@Inject
	private ItemManager itemManager;
	@Inject
	private PlayerScouterConfig config;
	@Inject
	private PlayerManager playerManager;

	private final Map<String, Integer> blacklist = new HashMap<>();
	private HttpUrl webhook;
	private int minimumRisk;
	private int minimumValue;
	private int timeout;
	private int minimumCombat;
	private int maximumCombat;
	private boolean onlyWildy;
	private boolean outputItems;
	private boolean scoutFriends;
	private boolean scoutClan;

	@Provides
	PlayerScouterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PlayerScouterConfig.class);
	}

	@Override
	protected void startUp()
	{
		blacklist.clear();
		updateConfig();
	}

	@Override
	protected void shutDown()
	{
		blacklist.clear();
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("playerscouter"))
		{
			return;
		}

		updateConfig();
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			return;
		}

		blacklist.clear();
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		resetBlacklist();

		if (!checkWildy() || this.webhook == null)
		{
			return;
		}

		final List<PlayerContainer> players = new ArrayList<>();

		for (PlayerContainer player : playerManager.getPlayerContainers())
		{
			if (player.isScouted())
			{
				player.setScoutTimer(player.getScoutTimer() - 1);
				if (player.getScoutTimer() <= 0)
				{
					player.setScouted(false);
					player.setScoutTimer(500);
				}
				continue;
			}

			if (player.getPlayer().getCombatLevel() < this.minimumCombat || player.getPlayer().getCombatLevel() > this.maximumCombat)
			{
				continue;
			}

			if ((player.getPlayer().getCombatLevel() >= this.minimumCombat &&
				player.getPlayer().getCombatLevel() <= this.maximumCombat) &&
				player.getRisk() > this.minimumRisk)
			{
				if (player.getSkills() == null)
				{
					if (player.isHttpRetry())
					{
						continue;
					}
					playerManager.updateStats(player.getPlayer());
					continue;
				}
				if (config.mini())
				{
					players.add(player);
					continue;
				}
				addPlayer(player);
			}
		}

		if (config.mini())
		{
			players.sort(Comparator.comparingInt(PlayerContainer::getRisk).reversed());
			scoutMini(players);
		}
	}

	private void addPlayer(PlayerContainer player)
	{
		if (player.getPlayer() == client.getLocalPlayer()
			|| (!blacklist.isEmpty() && blacklist.containsKey(player.getName()))
			|| (!this.scoutFriends && client.isFriended(player.getName(), false)
			|| (!this.scoutClan && client.isClanMember(player.getName()))))
		{
			log.debug("Player Rejected: {}", player.getName());
			return;
		}

		blacklist.put(player.getName(), client.getTickCount() + this.timeout);
		scoutPlayer(player);
	}

	private void resetBlacklist()
	{
		if (blacklist.isEmpty())
		{
			return;
		}

		Iterator<Map.Entry<String, Integer>> iter = blacklist.entrySet().iterator();

		iter.forEachRemaining(entry ->
		{
			if (entry.getValue() == client.getTickCount())
			{
				iter.remove();
			}
		});
	}

	private boolean checkWildy()
	{
		if (!this.onlyWildy)
		{
			return true;
		}

		return client.getVar(Varbits.IN_WILDERNESS) == 1 || WorldType.isPvpWorld(client.getWorldType());
	}

	private void updateConfig()
	{
		this.webhook = HttpUrl.parse(config.webhook());
		this.minimumRisk = config.minimumRisk();
		this.minimumValue = config.minimumValue();
		this.timeout = config.timeout();
		this.onlyWildy = config.onlyWildy();
		this.outputItems = config.outputItems();
		this.scoutClan = config.scoutClan();
		this.scoutFriends = config.scoutFriends();
		this.minimumCombat = config.minimumCombat();
		this.maximumCombat = config.maximumCombat();
	}

	private void scoutMini(List<PlayerContainer> players)
	{
		if (client.getLocalPlayer() == null)
		{
			return;
		}

		final List<FieldEmbed> fieldList = new ArrayList<>();
		final String location = WorldLocation.location(client.getLocalPlayer().getWorldLocation());
		final int cap = Math.min(players.size(), 25);

		int highestValue = 0;
		int id = 0;
		int risk = 0;
		for (int i = 0; i < cap; i++)
		{
			final PlayerContainer player = players.get(i);
			final Map.Entry entry = getEntry(player.getGear());
			risk += player.getRisk();
			if (entry != null)
			{
				final int mostValued = (int) entry.getValue();
				final int mostValuedId = (int) entry.getKey();

				if (mostValued > highestValue)
				{
					highestValue = mostValued;
					id = mostValuedId;
				}
			}

			String name = "☠️ " + player.getName() + " ☠️";

			if (player.getPlayer().getSkullIcon() == null)
			{
				name = player.getName();
			}

			fieldList.add(FieldEmbed.builder()
				.name(name)
				.value(QuantityFormatter.quantityToRSDecimalStack(player.getRisk()))
				.inline(true)
				.build());

			player.setScouted(true);
		}

		String iconId = String.valueOf(id);
		String icon = ICON_URL + iconId + ".png";

		ThumbnailEmbed image = ThumbnailEmbed.builder()
			.url(ICON_URL + iconId + ".png")
			.build();

		String color = "8388352";

		if (risk < 1000000 && risk > 150000)
		{
			//blue
			color = "32767";
		}
		else if (risk > 1000000)
		{
			//orange
			color = "16744448";
		}

		message(location, icon, image, fieldList, color);
	}

	private void scoutPlayer(PlayerContainer player)
	{
		if (player.isScouted())
		{
			return;
		}

		List<FieldEmbed> fieldList = new ArrayList<>();
		//green
		String color = "8388352";

		if (player.getRisk() < 1000000 && player.getRisk() > 150000)
		{
			//blue
			color = "32767";
		}
		else if (player.getRisk() > 1000000)
		{
			//orange
			color = "16744448";
		}

		ThumbnailEmbed image = ThumbnailEmbed.builder()
			.url(ICON_URL + player.getWeapon() + ".png")
			.build();

		fieldList.add(FieldEmbed.builder()
			.name("Risk")
			.value(QuantityFormatter.quantityToRSDecimalStack(player.getRisk()))
			.inline(true)
			.build());

		fieldList.add(FieldEmbed.builder()
			.name("World")
			.value(Integer.toString(client.getWorld()))
			.inline(true)
			.build());

		fieldList.add(FieldEmbed.builder()
			.name("Combat Level")
			.value(Integer.toString(player.getPlayer().getCombatLevel()))
			.inline(true)
			.build());

		if (client.getVar(Varbits.IN_WILDERNESS) == 1)
		{
			fieldList.add(FieldEmbed.builder()
				.name("Wildy Level")
				.value(Integer.toString(player.getWildyLevel()))
				.inline(true)
				.build());

			fieldList.add(FieldEmbed.builder()
				.name("Location")
				.value(player.getLocation())
				.inline(true)
				.build());
		}

		fieldList.add(FieldEmbed.builder()
			.name("Target")
			.value(player.getTargetString())
			.inline(true)
			.build());

		if (this.outputItems)
		{
			fieldList.add(FieldEmbed.builder()
				.name("Risked Items Sorted by Value")
				.value("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
				.build());

			int items = 0;

			for (Map.Entry<Integer, Integer> entry : player.getRiskedGear().entrySet())
			{
				Integer gear = entry.getKey();
				Integer value = entry.getValue();
				if (value <= 0 || value <= this.minimumValue)
				{
					items++;
					continue;
				}

				ItemStats item = itemManager.getItemStats(gear, false);
				String name = itemManager.getItemDefinition(gear).getName();

				if (item == null)
				{
					log.error("Item is Null: {}", gear);
					continue;
				}

				fieldList.add(FieldEmbed.builder()
					.name(name)
					.value("Value: " + QuantityFormatter.quantityToRSDecimalStack(value))
					.inline(true)
					.build());
			}

			if (items > 0)
			{
				fieldList.add(FieldEmbed.builder()
					.name("Items below value: " + this.minimumValue)
					.value(Integer.toString(items))
					.inline(true)
					.build());
			}
		}


		Map.Entry entry = getEntry(player.getGear());
		String iconId = entry == null ? String.valueOf(1) : String.valueOf(entry.getKey());
		String icon = ICON_URL + iconId + ".png";
		String name = "☠️ " + player.getName() + " ☠️";

		if (player.getPlayer().getSkullIcon() == null)
		{
			name = player.getName();
		}

		message(name, icon, image, fieldList, color);
		player.setScouted(true);
	}

	private void message(String name, String iconUrl, ThumbnailEmbed thumbnail, List<FieldEmbed> fields, String color)
	{
		log.debug("Message Contents: {}, {}, {}, {}, {}", name, " ", thumbnail, Arrays.toString(fields.toArray()), this.webhook);
		log.debug("Fields: {}", fields);

		if (name.isEmpty() || fields.isEmpty())
		{
			log.debug("Discord message will fail with a missing name/description/field");
			return;
		}

		final Date currentTime = new Date(System.currentTimeMillis());

		DiscordEmbed discordEmbed = new DiscordEmbed(
			AuthorEmbed.builder()
				.icon_url(iconUrl)
				.name(name)
				.build(),
			thumbnail,
			" ",
			FooterEmbed.builder()
				.icon_url("https://raw.githubusercontent.com/runelite/runelite/master/runelite-client/src/main/resources/net/runelite/client/plugins/hiscore/ultimate_ironman.png")
				.text("Gabon Scouter | Time: " + SDF.format(currentTime))
				.build(),
			color,
			fields
		);

		DiscordMessage discordMessage = discordEmbed.toDiscordMessage("Gabon Scouter", " ", "https://i.imgur.com/2A6dr7q.png");

		DISCORD_CLIENT.message(this.webhook, discordMessage);
	}

	private static Map.Entry getEntry(LinkedHashMap<Integer, Integer> map)
	{
		if (!map.isEmpty())
		{
			return map.entrySet().iterator().next();
		}
		return null;
	}
}
