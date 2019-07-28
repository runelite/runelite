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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemDefinition;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.PvPValueBrokenItem;
import net.runelite.client.game.WorldLocation;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.PvPUtil;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.discord.DiscordClient;
import net.runelite.http.api.discord.DiscordEmbed;
import net.runelite.http.api.discord.DiscordMessage;
import net.runelite.http.api.discord.embed.AuthorEmbed;
import net.runelite.http.api.discord.embed.FieldEmbed;
import net.runelite.http.api.discord.embed.FooterEmbed;
import net.runelite.http.api.discord.embed.ThumbnailEmbed;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;
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
	private static final HiscoreClient HISCORE_CLIENT = new HiscoreClient();
	private static final DiscordClient DISCORD_CLIENT = new DiscordClient();
	private static final Map<WorldArea, String> WILD_LOCS = WorldLocation.getLocationMap();
	private static final SimpleDateFormat SDF = new SimpleDateFormat("MMM dd h:mm a z");
	private static final String ICONBASEURL = "https://www.osrsbox.com/osrsbox-db/items-icons/"; // Add item id + ".png"
	@Inject
	private Client client;
	@Inject
	private ItemManager itemManager;
	@Inject
	private PlayerScouterConfig config;
	@Inject
	private EventBus eventBus;
	private Set<PlayerContainer> playerContainer = new HashSet<>();
	private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
	private Map<HiscoreResult, String> resultCache = new HashMap<>();
	private Map<String, Integer> blacklist = new HashMap<>();
	private HttpUrl url;
	private int minimumRisk;
	private int minimumValue;
	private int timeout;
	private boolean onlyWildy;
	private boolean outputItems;


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
		addSubscriptions();
	}

	@Override
	protected void shutDown()
	{
		playerContainer.clear();
		blacklist.clear();
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(PlayerDespawned.class, this, this::onPlayerDespawned);
		eventBus.subscribe(PlayerSpawned.class, this, this::onPlayerSpawned);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("playerscouter"))
		{
			return;
		}

		updateConfig();
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			return;
		}

		blacklist.clear();
	}

	private void onGameTick(GameTick event)
	{
		resetBlacklist();

		if (!checkWildy() || playerContainer.isEmpty())
		{
			return;
		}

		playerContainer.forEach(player ->
		{
			update(player);
			if (player.getRisk() > this.minimumRisk)
			{
				scoutPlayer(player);
			}
		});
	}

	private void onPlayerDespawned(PlayerDespawned event)
	{
		final Player player = event.getPlayer();

		playerContainer.removeIf(p -> p.getPlayer() == player);
	}

	private void onPlayerSpawned(PlayerSpawned event)
	{
		final Player player = event.getPlayer();

		if (player == client.getLocalPlayer())
		{
			return;
		}

		if (!blacklist.isEmpty() && blacklist.keySet().contains(player.getName()))
		{
			return;
		}

		playerContainer.add(new PlayerContainer(player));
		blacklist.put(player.getName(), client.getTickCount() + this.timeout);
	}


	private void resetBlacklist()
	{
		if (blacklist.isEmpty())
		{
			return;
		}

		blacklist.forEach((k, v) ->
		{
			if (v == client.getTickCount())
			{
				blacklist.remove(k, v);
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
		this.url = HttpUrl.parse(config.webhook());
		this.minimumRisk = config.minimumRisk();
		this.minimumValue = config.minimumValue();
		this.timeout = config.timeout();
		this.onlyWildy = config.onlyWildy();
		this.outputItems = config.outputItems();
	}

	private void update(PlayerContainer player)
	{
		player.setRisk(0);
		updatePlayerGear(player);
		updateStats(player);
		player.setLocation(location(player));
		player.setWildyLevel(PvPUtil.getWildernessLevelFrom(player.getPlayer().getWorldLocation()));
		player.setTargetString(targetStringBuilder(player));
		if (player.isScouted())
		{
			player.setScoutTimer(player.getScoutTimer() - 1);
			if (player.getScoutTimer() <= 0)
			{
				player.setScouted(false);
				player.setScoutTimer(500);
			}
		}
		log.debug(player.toString());
	}

	private void updateStats(PlayerContainer player)
	{
		if (player.getSkills() == null)
		{
			if (player.isHttpRetry())
			{
				return;
			}
			executorService.submit(() ->
			{
				player.setHttpRetry(true);
				HiscoreResult result = null;
				try
				{
					if (!resultCache.values().contains(player.getName()))
					{
						result = HISCORE_CLIENT.lookup(player.getName());
					}
					else
					{
						for (Map.Entry<HiscoreResult, String> entry : resultCache.entrySet())
						{
							if (!entry.getValue().equals(player.getName()))
							{
								continue;
							}
							result = entry.getKey();
						}
					}
				}
				catch (IOException ex)
				{
					log.warn("Error fetching Hiscore data " + ex.getMessage());
					player.setHttpRetry(false);
					return;
				}
				resultCache.put(result, player.getName());
				player.setHttpRetry(false);
				player.setSkills(result);
				player.setPrayer(player.getSkills().getPrayer().getLevel());
			});
		}
	}

	private void updatePlayerGear(PlayerContainer player)
	{
		Map<Integer, Integer> prices = new HashMap<>();

		if (player.getPlayer().getPlayerAppearance() != null)
		{
			for (KitType kitType : KitType.values())
			{
				if (kitType.equals(KitType.RING) || kitType.equals(KitType.AMMUNITION))
				{
					continue;
				}

				final int id = player.getPlayer().getPlayerAppearance().getEquipmentId(kitType);

				if (id == -1)
				{
					continue;
				}

				if (kitType.equals(KitType.WEAPON))
				{
					player.setWeapon(id);
				}

				final ItemStats item = itemManager.getItemStats(id, false);
				final ItemDefinition itemDefinition = itemManager.getItemDefinition(id);

				if (item == null)
				{
					log.debug("Item is null: {}", id);
					continue;
				}

				if (PvPValueBrokenItem.breaksOnDeath(id))
				{
					prices.put(id, itemManager.getBrokenValue(id));
					log.debug("Item has a broken value: Id {}, Value {}", id, itemManager.getBrokenValue(id));
				}

				if (!itemDefinition.isTradeable() && !PvPValueBrokenItem.breaksOnDeath(id))
				{
					prices.put(id, itemDefinition.getPrice());
				}
				else if (itemDefinition.isTradeable())
				{
					prices.put(id, itemManager.getItemPrice(id, false));
				}
			}
			updateGear(player, prices);
		}
	}

	private void updateGear(PlayerContainer player, Map<Integer, Integer> prices)
	{
		player.setGear(prices.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)));

		player.setRiskedGear(prices.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)));

		if (player.getPlayer().getSkullIcon() == null)
		{
			removeEntries(player.getRiskedGear(), player.getPrayer() <= 25 ? 3 : 4);
		}
		else
		{
			removeEntries(player.getRiskedGear(), player.getPrayer() <= 25 ? 0 : 1);
		}

		player.getRiskedGear().values().forEach(price -> player.setRisk(player.getRisk() + price));
		prices.clear();
	}

	private static void removeEntries(LinkedHashMap<Integer, Integer> map, int quantity)
	{
		if (map.size() < quantity)
		{
			log.debug("Size is lower than removal quantity.");
		}
		for (int i = 0; i < quantity; i++)
		{
			if (!map.entrySet().iterator().hasNext())
			{
				log.debug("Attempted to remove entries, but there was not enough to remove.");
				return;
			}
			log.debug("Entry Removed: " + map.entrySet().iterator().next());
			map.entrySet().remove(map.entrySet().iterator().next());
		}
	}

	private static Map.Entry getEntry(LinkedHashMap<Integer, Integer> map)
	{
		if (!map.isEmpty())
		{
			Iterator<Map.Entry<Integer, Integer>> entry = map.entrySet().iterator();

			for (int i = 0; i < 1; i++)
			{
				entry.next();
			}

			return entry.next();
		}
		return null;
	}

	private String targetStringBuilder(PlayerContainer player)
	{
		if (player.getPlayer().getInteracting() != null)
		{
			Actor actor = player.getPlayer().getInteracting();
			if (actor instanceof Player)
			{
				return "(Player) " + actor.getName();
			}
			else if (actor instanceof NPC)
			{
				return "(NPC) " + actor.getName();
			}
		}
		return "No Target Detected";
	}

	private void scoutPlayer(PlayerContainer player)
	{
		if (player.isScouted() || player.getSkills() == null)
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
			.url(ICONBASEURL + player.getWeapon() + ".png")
			.build();

		fieldList.add(FieldEmbed.builder()
			.name("Risk")
			.value(StackFormatter.quantityToRSDecimalStack(player.getRisk()))
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

			final int[] items = {0};

			player.getRiskedGear().forEach((gear, value) ->
			{
				if (value <= 0 || value <= this.minimumValue)
				{
					items[0]++;
					return;
				}

				ItemStats item = itemManager.getItemStats(gear, false);

				if (item == null)
				{
					log.error("Item is Null: {}", gear);
					return;
				}

				fieldList.add(FieldEmbed.builder()
					.name(item.getName())
					.value("Value: " + StackFormatter.quantityToRSDecimalStack(value))
					.inline(true)
					.build());
			});

			if (items[0] > 0)
			{
				fieldList.add(FieldEmbed.builder()
					.name("Items below value: " + this.minimumValue)
					.value(Integer.toString(items[0]))
					.inline(true)
					.build());
			}
		}

		String icon = ICONBASEURL + Objects.requireNonNull(getEntry(player.getGear())).getKey() + ".png";
		String name = "☠️ " + player.getName() + " ☠️";

		if (player.getPlayer().getSkullIcon() == null)
		{
			name = player.getName();
		}

		message(name, icon, image, fieldList, color);
		player.setScouted(true);
		fieldList.clear();
	}

	private void message(String name, String iconUrl, ThumbnailEmbed thumbnail, List<FieldEmbed> fields, String color)
	{
		log.debug("Message Contents: {}, {}, {}, {}, {}", name, " ", thumbnail, Arrays.toString(fields.toArray()), this.url);
		log.debug("Fields: {}", fields);

		if (name.isEmpty() || fields.isEmpty())
		{
			log.error("Discord message will fail with a missing name/description/field");
			return;
		}

		final Date currentTime = new Date(System.currentTimeMillis());

		DiscordEmbed discordEmbed = DiscordEmbed.builder()
			.author(AuthorEmbed.builder()
				.icon_url(iconUrl)
				.name(name)
				.build())
			.thumbnail(thumbnail)
			.description(" ")
			.fields(fields)
			.footer(FooterEmbed.builder()
				.icon_url("https://raw.githubusercontent.com/runelite/runelite/master/runelite-client/src/main/resources/net/runelite/client/plugins/hiscore/ultimate_ironman.png")
				.text("Gabon Scouter | Time: " + SDF.format(currentTime))
				.build())
			.color(color)
			.build();

		DiscordMessage discordMessage = new DiscordMessage("Gabon Scouter", " ", "https://i.imgur.com/2A6dr7q.png");
		discordMessage.getEmbeds().add(discordEmbed);
		DISCORD_CLIENT.message(this.url, discordMessage);
		fields.clear();
	}

	private String location(PlayerContainer player)
	{
		final WorldPoint wl = player.getPlayer().getWorldLocation();
		int dist = 10000;
		String s = "";
		WorldArea closestArea = null;
		for (Map.Entry<WorldArea, String> entry : WILD_LOCS.entrySet())
		{
			WorldArea worldArea = entry.getKey();

			if (worldArea.toWorldPointList().contains(wl))
			{
				s = entry.getValue();
				return s;
			}
			int distTo = worldArea.distanceTo(wl);
			if (distTo < dist)
			{
				dist = distTo;
				closestArea = worldArea;
			}
		}
		if (wl.getY() > (Objects.requireNonNull(closestArea).toWorldPoint().getY() + closestArea.getHeight()))
		{
			s = s + "N";
		}
		if (wl.getY() < closestArea.toWorldPoint().getY())
		{
			s = s + "S";
		}
		if (wl.getX() < closestArea.toWorldPoint().getX())
		{
			s = s + "W";
		}
		if (wl.getX() > (closestArea.toWorldPoint().getX() + closestArea.getWidth()))
		{
			s = s + "E";
		}
		s = s + " of ";
		s = s + WILD_LOCS.get(closestArea);
		if (s.startsWith(" of "))
		{
			s = s.substring(3);
		}
		return s;
	}
}
