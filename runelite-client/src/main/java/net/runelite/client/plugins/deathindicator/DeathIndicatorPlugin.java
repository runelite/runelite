/*
 * Copyright (c) 2018, Danny <DannysPVM@gmail.com>
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
package net.runelite.client.plugins.deathindicator;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.PlayerDeath;
import net.runelite.api.events.PostItemDefinition;
import net.runelite.api.util.Text;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.Timer;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Death Indicator",
	description = "Show where you last died, and on what world",
	tags = {"arrow", "hints", "world", "map", "overlay"}
)
@Singleton
@Slf4j
public class DeathIndicatorPlugin extends Plugin
{
	private static final Object BONES = new Object();
	// A random number, that jagex probably won't actually use in the near future
	static final int HIJACKED_ITEMID = 0x69696969;

	private static final Set<Integer> RESPAWN_REGIONS = ImmutableSet.of(
		12850, // Lumbridge
		11828, // Falador
		12342, // Edgeville
		11062, // Camelot
		13150, // Prifddinas (it's possible to spawn in 2 adjacent regions)
		12894 // Prifddinas
	);

	@Inject
	private Client client;

	@Inject
	private DeathIndicatorConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private EventBus eventBus;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientThread clientThread;

	private final Bones bones = new Bones();

	private BufferedImage mapArrow;

	private Timer deathTimer;

	private WorldPoint lastDeath;
	private Instant lastDeathTime;
	private int lastDeathWorld;
	private int despawnIdx = 0;
	@Provides
	DeathIndicatorConfig deathIndicatorConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DeathIndicatorConfig.class);
	}

	@Override
	protected void startUp()
	{
		addSubscriptions();

		if (!hasDied())
		{
			return;
		}

		resetInfobox();

		if (client.getWorld() != config.deathWorld())
		{
			return;
		}

		if (config.showDeathHintArrow() && !client.hasHintArrow())
		{
			client.setHintArrow(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane()));
		}

		if (config.showDeathOnWorldMap())
		{
			worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			worldMapPointManager.add(new DeathWorldMapPoint(new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane()), this));
		}

		if (config.permaBones() && client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invokeLater(this::initBones);
		}
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
		eventBus.unregister(BONES);

		if (client.hasHintArrow())
		{
			client.clearHintArrow();
		}

		if (deathTimer != null)
		{
			infoBoxManager.removeInfoBox(deathTimer);
			deathTimer = null;
		}

		worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);

		clientThread.invokeLater(this::clearBones);
		saveBones();
	}

	private void initBones()
	{
		bones.init(client, configManager);
	}

	private void saveBones()
	{
		bones.save(configManager);
	}

	private void clearBones()
	{
		bones.clear(client.getScene());
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(LocalPlayerDeath.class, this, this::onLocalPlayerDeath);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		if (config.permaBones())
		{
			addBoneSubs();
		}
	}

	private void addBoneSubs()
	{
		eventBus.subscribe(ItemDespawned.class, BONES, this::onItemDespawn);
		eventBus.subscribe(PlayerDeath.class, BONES, this::onPlayerDeath);
		eventBus.subscribe(MenuEntryAdded.class, BONES, this::onMenuEntryAdded);
		eventBus.subscribe(MenuOptionClicked.class, BONES, this::onMenuOptionClicked);
		eventBus.subscribe(MenuOpened.class, BONES, this::onMenuOpened);
		eventBus.subscribe(PostItemDefinition.class, BONES, this::onPostItemDefinition);
	}

	private void onPostItemDefinition(PostItemDefinition def)
	{
		ItemDefinition itemDef = def.getItemDefinition();
		if (itemDef.getId() == HIJACKED_ITEMID)
		{
			itemDef.setModelOverride(ItemID.BONES);
			itemDef.setName("Bones");
			// This is so never hide untradeables doesn't not hide it
			itemDef.setTradeable(true);
		}
	}

	private void onPlayerDeath(PlayerDeath death)
	{
		Player p = death.getPlayer();
		Bone b = new Bone();

		b.setName(Text.sanitize(p.getName()));
		b.setTime(Instant.now());
		b.setLoc(p.getWorldLocation());

		while (!bones.add(b))
		{
			initBones();
		}

		b.addToScene(client.getScene());
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (event.getIdentifier() == HIJACKED_ITEMID)
		{
			if (event.getOpcode() == MenuOpcode.GROUND_ITEM_THIRD_OPTION.getId())
			{
				client.setMenuOptionCount(client.getMenuOptionCount() - 1);
			}
		}
	}

	private void onMenuOpened(MenuOpened event)
	{
		int idx = 0;

		for (MenuEntry entry : event)
		{
			if (entry.getIdentifier() != HIJACKED_ITEMID)
			{
				continue;
			}

			// Only entries with appropriate identifier here will be examine so that's easy
			// Add idx to id field, so we can find that back from clicked event
			entry.setIdentifier(HIJACKED_ITEMID + idx);

			Bone bone = bones.get(
				WorldPoint.fromScene(client, entry.getParam0(), entry.getParam1(), client.getPlane()),
				idx++
			);

			entry.setTarget(bone.getName());
			event.setModified();
		}
	}

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getIdentifier() >= HIJACKED_ITEMID
			&& event.getOpcode() == MenuOpcode.EXAMINE_ITEM_GROUND.getId())
		{
			Bone b = bones.get(
				WorldPoint.fromScene(client, event.getParam0(), event.getParam1(), client.getPlane()),
				event.getIdentifier() - HIJACKED_ITEMID
			);

			client.addChatMessage(ChatMessageType.ITEM_EXAMINE, "", b.getExamine(), "");
			event.consume();
		}
	}

	private void onLocalPlayerDeath(LocalPlayerDeath death)
	{
		if (client.isInInstancedRegion())
		{
			return;
		}

		lastDeath = client.getLocalPlayer().getWorldLocation();
		lastDeathWorld = client.getWorld();
		lastDeathTime = Instant.now();
	}

	private void onGameTick(GameTick event)
	{
		// Check if player respawned in a death respawn location
		if (lastDeath != null && !client.getLocalPlayer().getWorldLocation().equals(lastDeath))
		{
			if (!RESPAWN_REGIONS.contains(client.getLocalPlayer().getWorldLocation().getRegionID()))
			{
				log.debug("Died, but did not respawn in a known respawn location: {}",
					client.getLocalPlayer().getWorldLocation().getRegionID());

				lastDeath = null;
				lastDeathTime = null;
				return;
			}

			log.debug("Died! Grave at {}", lastDeath);

			// Save death to config
			config.deathLocationX(lastDeath.getX());
			config.deathLocationY(lastDeath.getY());
			config.deathLocationPlane(lastDeath.getPlane());
			config.timeOfDeath(lastDeathTime);
			config.deathWorld(lastDeathWorld);

			if (config.showDeathHintArrow())
			{
				client.setHintArrow(lastDeath);
			}

			if (config.showDeathOnWorldMap())
			{
				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
				worldMapPointManager.add(new DeathWorldMapPoint(lastDeath, this));
			}

			resetInfobox();

			lastDeath = null;
			lastDeathTime = null;
		}

		if (!hasDied() || client.getWorld() != config.deathWorld())
		{
			return;
		}

		// Check if the player is at their death location, or timer has passed
		WorldPoint deathPoint = new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane());
		if (deathPoint.equals(client.getLocalPlayer().getWorldLocation()) || (deathTimer != null && deathTimer.cull()))
		{
			client.clearHintArrow();

			if (deathTimer != null)
			{
				infoBoxManager.removeInfoBox(deathTimer);
				deathTimer = null;
			}

			worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);

			resetDeath();
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("deathIndicator"))
		{
			if ("permaBones".equals(event.getKey()))
			{
				if (config.permaBones())
				{
					addBoneSubs();

					if (client.getGameState() == GameState.LOGGED_IN)
					{
						clientThread.invokeLater(this::initBones);
					}
				}
				else
				{
					eventBus.unregister(BONES);

					if (client.getGameState() == GameState.LOGGED_IN)
					{
						clientThread.invokeLater(this::clearBones);
						saveBones();
					}
				}
				return;
			}
			if (!config.showDeathHintArrow() && hasDied())
			{
				client.clearHintArrow();
			}

			if (!config.showDeathInfoBox() && deathTimer != null)
			{
				infoBoxManager.removeInfoBox(deathTimer);
				deathTimer = null;
			}

			if (!config.showDeathOnWorldMap())
			{
				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			}

			if (!hasDied())
			{
				client.clearHintArrow();

				resetInfobox();

				worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
			}
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
				clearBones();
				saveBones();
				break;
			case LOGGED_IN:
				if (config.permaBones())
				{
					initBones();
				}

				if (!hasDied())
				{
					return;
				}

				if (client.getWorld() == config.deathWorld())
				{
					WorldPoint deathPoint = new WorldPoint(config.deathLocationX(), config.deathLocationY(), config.deathLocationPlane());

					if (config.showDeathHintArrow())
					{
						client.setHintArrow(deathPoint);
					}

					if (config.showDeathOnWorldMap())
					{
						worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
						worldMapPointManager.add(new DeathWorldMapPoint(deathPoint, this));
					}
				}
				else
				{
					worldMapPointManager.removeIf(DeathWorldMapPoint.class::isInstance);
				}
				break;
		}

	}

	private void onItemDespawn(ItemDespawned event)
	{
		if (event.getItem().getId() == HIJACKED_ITEMID)
		{
			List<Bone> list = bones.get(event.getTile().getWorldLocation());
			if (list == null)
			{
				return;
			}
			if (list.size() <= despawnIdx)
			{
				despawnIdx = 0;
			}
			Bone bone = list.get(despawnIdx++);
			bone.addToScene(client.getScene());
		}
	}

	private boolean hasDied()
	{
		return config.timeOfDeath() != null;
	}

	private void resetDeath()
	{
		config.deathLocationX(0);
		config.deathLocationY(0);
		config.deathLocationPlane(0);
		config.deathWorld(0);
		config.timeOfDeath(null);
	}

	private void resetInfobox()
	{
		if (deathTimer != null)
		{
			infoBoxManager.removeInfoBox(deathTimer);
			deathTimer = null;
		}

		if (hasDied() && config.showDeathInfoBox())
		{
			Instant now = Instant.now();
			Duration timeLeft = Duration.ofHours(1).minus(Duration.between(config.timeOfDeath(), now));
			if (!timeLeft.isNegative() && !timeLeft.isZero())
			{
				deathTimer = new Timer(timeLeft.getSeconds(), ChronoUnit.SECONDS, getBonesImage(), this);
				deathTimer.setTooltip("Died on world: " + config.deathWorld());
				infoBoxManager.addInfoBox(deathTimer);
			}
		}
	}

	BufferedImage getMapArrow()
	{
		if (mapArrow != null)
		{
			return mapArrow;
		}

		mapArrow = ImageUtil.getResourceStreamFromClass(getClass(), "/util/clue_arrow.png");

		return mapArrow;
	}

	BufferedImage getBonesImage()
	{
		return itemManager.getImage(ItemID.BONES);
	}
}
