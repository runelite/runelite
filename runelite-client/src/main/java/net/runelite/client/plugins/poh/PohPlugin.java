/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.poh;

import com.google.common.collect.Sets;
import com.google.inject.Provides;

import java.awt.*;
import java.io.IOException;
import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.hiscore.HiscoreManager;
import net.runelite.client.hiscore.HiscoreSkill;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.hiscore.HiscoreEndpoint;
import net.runelite.client.hiscore.HiscoreResult;
import net.runelite.client.hiscore.Skill;

@PluginDescriptor(
	name = "Player-owned House",
	description = "Show minimap icons and mark unlit/lit burners",
	tags = {"construction", "poh", "minimap", "overlay"}
)
@Slf4j
public class PohPlugin extends Plugin
{
	static final Set<Integer> BURNER_UNLIT = Sets.newHashSet(ObjectID.INCENSE_BURNER, ObjectID.INCENSE_BURNER_13210, ObjectID.INCENSE_BURNER_13212);
	static final Set<Integer> BURNER_LIT = Sets.newHashSet(ObjectID.INCENSE_BURNER_13209, ObjectID.INCENSE_BURNER_13211, ObjectID.INCENSE_BURNER_13213);
	static final Set<Integer> PORTALS = Sets.newHashSet(ObjectID.LUMBRIDGE_PORTAL, ObjectID.FALADOR_PORTAL, NullObjectID.NULL_13615, NullObjectID.NULL_13618,
			ObjectID.ARDOUGNE_PORTAL, NullObjectID.NULL_13620, ObjectID.LUNAR_ISLE_PORTAL, ObjectID.WATERBIRTH_ISLAND_PORTAL, ObjectID.FISHING_GUILD_PORTAL,
			ObjectID.SENNTISTEN_PORTAL, ObjectID.KHARYRLL_PORTAL, ObjectID.ANNAKARL_PORTAL, ObjectID.KOUREND_PORTAL, ObjectID.MARIM_PORTAL,
			ObjectID.TROLL_STRONGHOLD_PORTAL, ObjectID.CARRALLANGAR_PORTAL, ObjectID.CATHERBY_PORTAL, ObjectID.WEISS_PORTAL, ObjectID.GHORROCK_PORTAL,
			ObjectID.APE_ATOLL_DUNGEON_PORTAL, ObjectID.BARROWS_PORTAL, ObjectID.BATTLEFRONT_PORTAL, ObjectID.CEMETERY_PORTAL, ObjectID.DRAYNOR_MANOR_PORTAL,
			ObjectID.FENKENSTRAINS_CASTLE_PORTAL, ObjectID.HARMONY_ISLAND_PORTAL, ObjectID.LUMBRIDGE_GRAVEYARD_PORTAL, ObjectID.MIND_ALTAR_PORTAL,
			ObjectID.SALVE_GRAVEYARD_PORTAL, ObjectID.WEST_ARDOUGNE_PORTAL);

	@Getter(AccessLevel.PACKAGE)
	private final Map<TileObject, Tile> pohObjects = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final Map<Tile, IncenseBurner> incenseBurners = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final Map<Tile, TeleportPortal> portals = new HashMap<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PohOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private HiscoreManager hiscoreManager;

	@Inject
	private BurnerOverlay burnerOverlay;

	@Inject
	private PortalLabelOverlay portalLabelOverlay;

	@Provides
	PohConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PohConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(burnerOverlay);
		overlayManager.add(portalLabelOverlay);
		overlay.updateConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(burnerOverlay);
		overlayManager.remove(portalLabelOverlay);
		pohObjects.clear();
		incenseBurners.clear();
		portals.clear();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		overlay.updateConfig();
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();

		if (!BURNER_LIT.contains(gameObject.getId()) && !BURNER_UNLIT.contains(gameObject.getId()))
		{
			//Populates portal array
			if (PORTALS.contains(gameObject.getId())) {
				int objectID = gameObject.getId();
				LocalPoint localPoint = gameObject.getLocalLocation();
				Rectangle rectangleBounds = gameObject.getCanvasTilePoly().getBounds();

				portals.put(event.getTile(), new TeleportPortal(objectID, localPoint, rectangleBounds));
			}
			if (PohIcons.getIcon(gameObject.getId()) != null)
			{
				pohObjects.put(gameObject, event.getTile());
			}

			return;
		}

		IncenseBurner incenseBurner = incenseBurners.computeIfAbsent(event.getTile(), k -> new IncenseBurner());
		incenseBurner.setStart(Instant.now());
		incenseBurner.setLit(BURNER_LIT.contains(gameObject.getId()));
		incenseBurner.setEnd(null);
		// The burner timers are set when observing a player light the burner
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		GameObject gameObject = event.getGameObject();
		pohObjects.remove(gameObject);
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		DecorativeObject decorativeObject = event.getDecorativeObject();
		if (PohIcons.getIcon(decorativeObject.getId()) != null)
		{
			pohObjects.put(decorativeObject, event.getTile());
		}
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		DecorativeObject decorativeObject = event.getDecorativeObject();
		pohObjects.remove(decorativeObject);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			pohObjects.clear();
			incenseBurners.clear();
			portals.clear();
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();
		final String actorName = actor.getName();

		if (!(actor instanceof Player) || actor.getAnimation() != AnimationID.INCENSE_BURNER)
		{
			return;
		}

		final LocalPoint loc = actor.getLocalLocation();

		// Find burner closest to player
		incenseBurners.keySet()
			.stream()
			.min(Comparator.comparingInt(a -> loc.distanceTo(a.getLocalLocation())))
			.ifPresent(tile ->
			{
				final IncenseBurner incenseBurner = incenseBurners.get(tile);
				incenseBurner.reset();

				if (actor == client.getLocalPlayer())
				{
					int level = client.getRealSkillLevel(net.runelite.api.Skill.FIREMAKING);
					updateBurner(incenseBurner, level);
				}
				else if (actorName != null)
				{
					lookupPlayer(actorName, incenseBurner);
				}
			});

	}

	private void lookupPlayer(String playerName, IncenseBurner incenseBurner)
	{
		executor.execute(() ->
		{
			try
			{
				final HiscoreResult playerStats = hiscoreManager.lookup(playerName, HiscoreEndpoint.NORMAL);

				if (playerStats == null)
				{
					return;
				}

				final Skill fm = playerStats.getSkill(HiscoreSkill.FIREMAKING);
				final int level = fm.getLevel();
				updateBurner(incenseBurner, Math.max(level, 1));
			}
			catch (IOException e)
			{
				log.warn("Error fetching Hiscore data " + e.getMessage());
			}
		});
	}

	private static void updateBurner(IncenseBurner incenseBurner, int fmLevel)
	{
		final double tickLengthSeconds = Constants.GAME_TICK_LENGTH / 1000.0;
		incenseBurner.setCountdownTimer((200 + fmLevel) * tickLengthSeconds);
		incenseBurner.setRandomTimer((fmLevel - 1) * tickLengthSeconds);
		log.debug("Set burner timer for firemaking level {}", fmLevel);
	}
}