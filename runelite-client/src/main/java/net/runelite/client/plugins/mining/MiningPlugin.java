/*
 * Copyright (c) 2018, Craftiii4 <Craftiii4@gmail.com>
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

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.TileObject;
import net.runelite.api.WallObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Set;

@PluginDescriptor(
	name = "Mining",
	description = "Show helpful information when mining",
	tags = {"mining", "mine"},
	enabledByDefault = false
)
public class MiningPlugin extends Plugin
{

	@Inject
	private OverlayManager overlayManager;

	@Inject
	MiningRockOverlay oreOverlay;

	@Inject
	MiningWorldHopperOverlay worldHopperOverlay;

	@Inject
	MiningOverlay miningOverlay;

	@Inject
	MiningConfig config;

	@Inject
	private Client client;

	@Getter(AccessLevel.PACKAGE)
	private int miningLevel;

	@Getter(AccessLevel.PACKAGE)
	private final HashMap<TileObject, MinedRock> ores = new HashMap<>();

	@Provides
	MiningConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MiningConfig.class);
	}

	@Getter(AccessLevel.PACKAGE)
	private MiningSession session;

	@Getter(AccessLevel.PUBLIC)
	private MiningWorldTracker miningTracker;

	private static final Set<Integer> MOTHERLODE_MAP_REGIONS = ImmutableSet.of(14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193);
	private static final int P2P_MINING_GUILD_REGION = 12183;
	private final static int MINING_GUILD_RESPAWN_RATE_HALVE_Y = 9727;

	@Override
	protected void startUp()
	{
		overlayManager.add(miningOverlay);
		overlayManager.add(oreOverlay);
		overlayManager.add(worldHopperOverlay);
		session = new MiningSession();
		if (config.trackWorldRock() !=  MiningRockType.WorldRock.None)
		{
			miningTracker = new MiningWorldTracker(config.trackWorldRock());
		}
		else
		{
			miningTracker = null;
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(miningOverlay);
		overlayManager.remove(oreOverlay);
		overlayManager.remove(worldHopperOverlay);
		ores.clear();
		miningLevel = Experience.getLevelForXp(client.getSkillExperience(Skill.MINING));
		session = null;
		miningTracker = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("trackWorldRock"))
		{
			MiningRockType.WorldRock worldRock = config.trackWorldRock();
			if (worldRock == MiningRockType.WorldRock.None)
			{
				miningTracker = null;
			}
			else
			{
				miningTracker = new MiningWorldTracker(config.trackWorldRock());
			}
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject object = event.getGameObject();
		MiningRockType rock = MiningRockType.getTypeFromID(object.getId());
		if (rock != null)
		{
			for (TileObject o : ores.keySet())
			{
				if (o.getX() == object.getX() && o.getY() == object.getY())
				{
					// Remove ground rock as it has respawned
					ores.remove(o);
					break;
				}
			}
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		Duration timeSinceStart = Duration.between(session.getIgnoreSpawn(), Instant.now());
		// Ignore anything spawned within 1 second of logging in or changing regions (prevents timers appearing on already mined rocks)
		if (timeSinceStart.getSeconds() > 1)
		{
			GameObject object = event.getGameObject();
			MiningRockType rock = MiningRockType.getTypeFromID(object.getId());
			if (rock != null && miningLevel >= rock.getRequiredMiningLevel())
			{
				if (!ores.containsKey(object))
				{
					ores.put(object, new MinedRock(rock, isInMiningGuildPay2Play(object.getWorldLocation())));
				}
			}
		}
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		Duration timeSinceStart = Duration.between(session.getIgnoreSpawn(), Instant.now());
		// Ignore anything spawned within 1 second of logging in or changing regions (prevents timers appearing on already mined rocks)
		if (timeSinceStart.getSeconds() > 1)
		{
			WallObject object = event.getWallObject();
			MiningRockType rock = MiningRockType.getTypeFromID(object.getId());
			if (rock != null && miningLevel >= rock.getRequiredMiningLevel())
			{
				if (!ores.containsKey(object))
				{
					ores.put(object, new MinedRock(rock, isInMiningGuildPay2Play(object.getWorldLocation())));
				}
			}
		}
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		WallObject object = event.getWallObject();
		MiningRockType rock = MiningRockType.getTypeFromID(object.getId());
		if (rock != null)
		{
			for (TileObject o : ores.keySet())
			{
				if (o.getX() == object.getX() && o.getY() == object.getY())
				{
					// Remove wall rock as it has respawned
					ores.remove(o);
					break;
				}
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		GameState state = event.getGameState();
		if (state == GameState.HOPPING)
		{
			MiningRockType.WorldRock worldRock = config.trackWorldRock();
			if (worldRock != MiningRockType.WorldRock.None)
			{
				int world = client.getWorld();
				for (TileObject rock : ores.keySet())
				{
					if (worldRock.getRockType() == ores.get(rock).getType())
					{
						// If the type matches the multi-world rock then add to the mining tracker for this world
						miningTracker.addTracked(world, rock, ores.get(rock));
					}
				}
			}
		}
		else if (state == GameState.LOADING)
		{
			ores.clear();
			session.setIgnoreSpawn(Instant.now());
		}
		else if (state == GameState.LOGGED_IN)
		{
			int world = client.getWorld();
			if (miningTracker != null && miningTracker.getTrackedWorlds().containsKey(world))
			{
				MiningWorld track = miningTracker.getTrackedWorlds().get(world);
				track.clearNegativeRespawnTimes();
				// Load all the tracked ores in this world into the current session. Causing their respawn times to be rendered
				for (TileObject o : track.getRocks().keySet())
				{
					ores.put(o, track.getRocks().get(o));
				}
				// We're on this world now, so don't track it in the world tracker anymore
				miningTracker.getTrackedWorlds().remove(world);
			}
		}
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		if (event.getSkill() == Skill.MINING)
		{
			miningLevel = Experience.getLevelForXp(client.getSkillExperience(Skill.MINING));
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}
		if (event.getMessage().startsWith("You manage to mine some"))
		{
			String oreName = event.getMessage().substring(24).replace(".", "");
			MiningRockType rock = MiningRockType.getTypeFromName(oreName);
			if (rock != null)
			{
				session.increaseRockMine(rock);
			}

		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void checkIsMining()
	{
		for (MiningRockType rock : MiningRockType.values())
		{
			if (session.getSessionStats().get(rock).getLastOreMined() != null)
			{
				Duration statTimeout = Duration.ofMinutes(config.statTimeout());
				Duration sinceMined = Duration.between(session.getSessionStats().get(rock).getLastOreMined(), Instant.now());
				if (sinceMined.compareTo(statTimeout) >= 0)
				{
					session.clearSessionFor(rock);
				}
			}
		}
	}

	public boolean isInMlm()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return false;
		}

		int[] currentMapRegions = client.getMapRegions();
		// Verify that all regions exist in MOTHERLODE_MAP_REGIONS
		for (int region : currentMapRegions)
		{
			if (!MOTHERLODE_MAP_REGIONS.contains(region))
			{
				return false;
			}
		}

		return true;
	}

	public boolean isInMiningGuildPay2Play(WorldPoint point)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return false;
		}

		int[] currentMapRegions = client.getMapRegions();
		for (int region : currentMapRegions)
		{
			if (region == P2P_MINING_GUILD_REGION)
			{
				return (point.getY() <= MINING_GUILD_RESPAWN_RATE_HALVE_Y);
			}
		}
		return false;
	}

}
