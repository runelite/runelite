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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.PvPUtil;
import net.runelite.client.util.WildernessLocation;
import net.runelite.http.api.discord.DiscordClient;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
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
	private static final String ICONBASEURL = "https://www.osrsbox.com/osrsbox-db/items-icons/"; // Add item id + ".png"
	private static final HiscoreClient HISCORE_CLIENT = new HiscoreClient();
	private static final Map<WorldArea, String> WILD_LOCS = getLocationMap();
	@Inject
	private Client client;
	@Inject
	private ItemManager itemManager;
	@Inject
	private AttackerOverlay attackerOverlay;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private ClientThread clientThread;
	@Inject
	private PlayerScouterConfig config;
	@Inject
	private EventBus eventBus;
	@Getter(AccessLevel.PACKAGE)
	private Set<PlayerContainer> playerContainer = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private boolean overlayEnabled;
	private boolean onlyWildy;
	private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
	private Map<String, Integer> blacklist = new HashMap<>();
	private int reset;
	private HttpUrl url;
	private int minimumRisk;
	private int minimumValue;
	private int timeout;
	private boolean outputItems;

	private static Map<WorldArea, String> getLocationMap()
	{
		Map<WorldArea, String> hashMap = new HashMap<>();
		Arrays.stream(WildernessLocation.values()).forEach(wildernessLocation ->
			hashMap.put(wildernessLocation.getWorldArea(), wildernessLocation.getName()));
		return hashMap;
	}

	@Provides
	PlayerScouterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PlayerScouterConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(attackerOverlay);
		blacklist.clear();
		updateConfig();
		addSubscriptions();
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(attackerOverlay);
		playerContainer.clear();
		blacklist.clear();
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(PlayerSpawned.class, this, this::onPlayerSpawned);
		eventBus.subscribe(PlayerDespawned.class, this, this::onPlayerDespawned);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			return;
		}

		blacklist.clear();
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("playerscouter"))
		{
			return;
		}

		updateConfig();
	}

	private void onInteractingChanged(InteractingChanged event)
	{
		if ((event.getSource() instanceof Player) && (event.getTarget() instanceof Player))
		{
			final Player source = (Player) event.getSource();
			final Player target = (Player) event.getTarget();

			if (source == client.getLocalPlayer())
			{
				if (!PvPUtil.isAttackable(client, target))
				{
					return;
				}

				playerContainer.forEach(player ->
				{
					if (player.getPlayer() == target)
					{
						player.setTimer(16);
						player.setTarget(true);
					}
				});
			}
			else if (target == client.getLocalPlayer())
			{
				if (!PvPUtil.isAttackable(client, source))
				{
					return;
				}
				playerContainer.forEach(player ->
				{
					if (player.getPlayer() == source)
					{
						player.setTimer(16);
						player.setTarget(true);
					}
				});
			}
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (actor.getInteracting() != client.getLocalPlayer())
		{
			return;
		}

		if (!(actor instanceof Player))
		{
			return;
		}

		if (PvPUtil.isAttackable(client, (Player) actor) && actor.getAnimation() != -1)
		{
			playerContainer.forEach(player ->
			{
				if (player.getPlayer() == actor)
				{
					player.setTimer(16);
					player.setTarget(true);
					player.setAttacking(true);
				}
			});
		}
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

		executorService.submit(() ->
		{
			SingleHiscoreSkillResult result;

			try
			{
				result = HISCORE_CLIENT.lookup(player.getName(), HiscoreSkill.PRAYER);
			}
			catch (IOException ex)
			{
				log.warn("Error fetching Hiscore data " + ex.getMessage());
				return;
			}

			playerContainer.add(new PlayerContainer(player, result.getSkill()));
			blacklist.put(player.getName(), client.getTickCount() + this.timeout);
		});
	}

	private void onPlayerDespawned(PlayerDespawned event)
	{
		final Player player = event.getPlayer();

		playerContainer.removeIf(p -> p.getPlayer() == player);
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
			Utils.reset(player);
			Utils.update(player, itemManager, 6, WILD_LOCS);

			if (player.getRisk() > this.minimumRisk)
			{
				Utils.scoutPlayer(player, url, DISCORD_CLIENT, itemManager, client, this.minimumValue, this.outputItems);
			}
		});
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

	private void updateConfig()
	{
		this.url = HttpUrl.parse(config.webhook());
		this.minimumRisk = config.minimumRisk();
		this.minimumValue = config.minimumValue();
		this.overlayEnabled = config.overlayEnabled();
		this.timeout = config.timeout();
		this.onlyWildy = config.onlyWildy();
		this.outputItems = config.outputItems();
	}

	private boolean checkWildy()
	{
		if (!this.onlyWildy)
		{
			return true;
		}
		return client.getVar(Varbits.IN_WILDERNESS) == 1 || WorldType.isPvpWorld(client.getWorldType());
	}
}
