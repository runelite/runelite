/*
 * Copyright (c) 2019, Jacky <liangj97@gmail.com>
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
package net.runelite.client.plugins.inferno;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.inferno.displaymodes.InfernoNamingDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoPrayerDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoSafespotDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoWaveDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoZukShieldDisplayMode;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Inferno",
	description = "Inferno helper",
	tags = {"combat", "overlay", "pve", "pvm"},
	type = PluginType.PVM
)
@Slf4j
@Singleton
public class InfernoPlugin extends Plugin
{
	private static final int INFERNO_REGION = 9043;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InfernoOverlay infernoOverlay;

	@Inject
	private InfernoWaveOverlay waveOverlay;

	@Inject
	private InfernoInfoBoxOverlay jadOverlay;

	@Inject
	private InfernoOverlay prayerOverlay;

	@Inject
	private InfernoConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private InfernoConfig.FontStyle fontStyle = InfernoConfig.FontStyle.BOLD;
	@Getter(AccessLevel.PACKAGE)
	private int textSize = 32;

	private WorldPoint lastLocation = new WorldPoint(0, 0, 0);

	@Getter(AccessLevel.PACKAGE)
	private int currentWaveNumber;

	@Getter(AccessLevel.PACKAGE)
	private final List<InfernoNPC> infernoNpcs = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private final Map<Integer, Map<InfernoNPC.Attack, Integer>> upcomingAttacks = new HashMap<>();
	@Getter(AccessLevel.PACKAGE)
	private InfernoNPC.Attack closestAttack = null;

	@Getter(AccessLevel.PACKAGE)
	private final List<WorldPoint> obstacles = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private boolean finalPhase = false;
	private NPC zukShield = null;
	private WorldPoint zukShieldLastPosition = null;
	private WorldPoint zukShieldBase = null;
	private int zukShieldCornerTicks = -2;

	@Getter(AccessLevel.PACKAGE)
	private InfernoNPC centralNibbler = null;

	// 0 = total safespot
	// 1 = pray melee
	// 2 = pray range
	// 3 = pray magic
	// 4 = pray melee, range
	// 5 = pray melee, magic
	// 6 = pray range, magic
	// 7 = pray all
	@Getter(AccessLevel.PACKAGE)
	private final Map<WorldPoint, Integer> safeSpotMap = new HashMap<>();
	@Getter(AccessLevel.PACKAGE)
	private final Map<Integer, List<WorldPoint>> safeSpotAreas = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private long lastTick;

	@Getter(AccessLevel.PACKAGE)
	private InfernoPrayerDisplayMode prayerDisplayMode;
	@Getter(AccessLevel.PACKAGE)
	private boolean descendingBoxes;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateNonPriorityDescendingBoxes;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateBlobDetectionTick;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateWhenPrayingCorrectly;

	private InfernoWaveDisplayMode waveDisplay;
	@Getter(AccessLevel.PACKAGE)
	private InfernoNamingDisplayMode npcNaming;
	@Getter(AccessLevel.PACKAGE)
	private boolean npcLevels;
	private Color getWaveOverlayHeaderColor;
	private Color getWaveTextColor;

	@Getter(AccessLevel.PACKAGE)
	private InfernoSafespotDisplayMode safespotDisplayMode;
	@Getter(AccessLevel.PACKAGE)
	private int safespotsCheckSize;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateNonSafespotted;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateTemporarySafespotted;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateSafespotted;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateObstacles;

	@Getter(AccessLevel.PACKAGE)
	private boolean indicateNibblers;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateCentralNibbler;

	@Getter(AccessLevel.PACKAGE)
	private boolean indicateActiveHealersJad;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateActiveHealersZuk;

	private boolean indicateNpcPositionBat;
	private boolean indicateNpcPositionBlob;
	private boolean indicateNpcPositionMeleer;
	private boolean indicateNpcPositionRanger;
	private boolean indicateNpcPositionMage;

	private boolean ticksOnNpcBat;
	private boolean ticksOnNpcBlob;
	private boolean ticksOnNpcMeleer;
	private boolean ticksOnNpcRanger;
	private boolean ticksOnNpcMage;
	private boolean ticksOnNpcHealerJad;
	private boolean ticksOnNpcJad;
	private boolean ticksOnNpcZuk;

	private boolean safespotsBat;
	private boolean safespotsBlob;
	private boolean safespotsMeleer;
	private boolean safespotsRanger;
	private boolean safespotsMage;
	private boolean safespotsHealerJad;
	private boolean safespotsJad;
	private InfernoZukShieldDisplayMode safespotsZukShieldBeforeHealers;
	private InfernoZukShieldDisplayMode safespotsZukShieldAfterHealers;

	private boolean prayerBat;
	private boolean prayerBlob;
	private boolean prayerMeleer;
	private boolean prayerRanger;
	private boolean prayerMage;
	private boolean prayerHealerJad;
	private boolean prayerJad;

	private boolean hideNibblerDeath;
	private boolean hideBatDeath;
	private boolean hideBlobDeath;
	private boolean hideBlobSmallRangedDeath;
	private boolean hideBlobSmallMagicDeath;
	private boolean hideBlobSmallMeleeDeath;
	private boolean hideMeleerDeath;
	private boolean hideRangerDeath;
	private boolean hideMagerDeath;
	private boolean hideJadDeath;
	private boolean hideHealerJadDeath;
	private boolean hideHealerZukDeath;
	private boolean hideZukDeath;

	@Provides
	InfernoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InfernoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		waveOverlay.setDisplayMode(this.waveDisplay);
		waveOverlay.setWaveHeaderColor(this.getWaveOverlayHeaderColor);
		waveOverlay.setWaveTextColor(this.getWaveTextColor);

		if (isInInferno())
		{
			overlayManager.add(infernoOverlay);

			if (this.waveDisplay != InfernoWaveDisplayMode.NONE)
			{
				overlayManager.add(waveOverlay);
			}

			overlayManager.add(jadOverlay);
			overlayManager.add(prayerOverlay);
			hideNpcDeaths();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(infernoOverlay);
		overlayManager.remove(waveOverlay);
		overlayManager.remove(jadOverlay);
		overlayManager.remove(prayerOverlay);

		currentWaveNumber = -1;

		showNpcDeaths();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!"inferno".equals(event.getGroup()))
		{
			return;
		}

		updateConfig();
		hideNpcDeaths();
		showNpcDeaths();

		if (event.getKey().endsWith("color"))
		{
			waveOverlay.setWaveHeaderColor(this.getWaveOverlayHeaderColor);
			waveOverlay.setWaveTextColor(this.getWaveTextColor);
		}
		else if ("waveDisplay".equals(event.getKey()))
		{
			overlayManager.remove(waveOverlay);

			waveOverlay.setDisplayMode(this.waveDisplay);

			if (isInInferno() && this.waveDisplay != InfernoWaveDisplayMode.NONE)
			{
				overlayManager.add(waveOverlay);
			}
		}
	}

	private void onGameTick(GameTick GameTickEvent)
	{
		if (!isInInferno())
		{
			return;
		}

		lastTick = System.currentTimeMillis();

		upcomingAttacks.clear();
		calculateUpcomingAttacks();

		closestAttack = null;
		calculateClosestAttack();

		safeSpotMap.clear();
		calculateSafespots();

		safeSpotAreas.clear();
		calculateSafespotAreas();

		obstacles.clear();
		calculateObstacles();

		centralNibbler = null;
		calculateCentralNibbler();
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		if (!isInInferno())
		{
			return;
		}

		if (event.getNpc().getId() == NpcID.ANCESTRAL_GLYPH)
		{
			zukShield = event.getNpc();
		}

		final InfernoNPC.Type infernoNPCType = InfernoNPC.Type.typeFromId(event.getNpc().getId());

		if (infernoNPCType == null)
		{
			return;
		}

		if (infernoNPCType == InfernoNPC.Type.ZUK)
		{
			log.debug("[INFERNO] Zuk spawn detected, not in final phase");
			finalPhase = false;
			zukShieldCornerTicks = -2;
			zukShieldLastPosition = null;
			zukShieldBase = null;
		}
		if (infernoNPCType == InfernoNPC.Type.HEALER_ZUK)
		{
			log.debug("[INFERNO] Final phase detected!");
			finalPhase = true;
		}

		// Blobs need to be added to the end of the list because the prayer for their detection tick will be based
		// on the upcoming attacks of other NPC's
		if (infernoNPCType == InfernoNPC.Type.BLOB)
		{
			infernoNpcs.add(new InfernoNPC(event.getNpc()));
		}
		else
		{
			infernoNpcs.add(0, new InfernoNPC(event.getNpc()));
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		if (!isInInferno())
		{
			return;
		}

		if (event.getNpc().getId() == NpcID.ANCESTRAL_GLYPH)
		{
			zukShield = null;
		}

		infernoNpcs.removeIf(infernoNPC -> infernoNPC.getNpc() == event.getNpc());
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		if (!isInInferno())
		{
			return;
		}

		if (event.getActor() instanceof NPC)
		{
			final NPC npc = (NPC) event.getActor();

			if (ArrayUtils.contains(InfernoNPC.Type.NIBBLER.getNpcIds(), npc.getId())
				&& npc.getAnimation() == 7576)
			{
				infernoNpcs.removeIf(infernoNPC -> infernoNPC.getNpc() == npc);
			}
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (!isInInferno())
		{
			infernoNpcs.clear();

			currentWaveNumber = -1;

			overlayManager.remove(infernoOverlay);
			overlayManager.remove(waveOverlay);
			overlayManager.remove(jadOverlay);
			overlayManager.remove(prayerOverlay);
		}
		else if (currentWaveNumber == -1)
		{
			infernoNpcs.clear();

			currentWaveNumber = 1;

			overlayManager.add(infernoOverlay);
			overlayManager.add(jadOverlay);
			overlayManager.add(prayerOverlay);

			if (this.waveDisplay != InfernoWaveDisplayMode.NONE)
			{
				overlayManager.add(waveOverlay);
			}
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (!isInInferno() || event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		String message = event.getMessage();

		if (event.getMessage().contains("Wave:"))
		{
			message = message.substring(message.indexOf(": ") + 2);
			currentWaveNumber = Integer.parseInt(message.substring(0, message.indexOf('<')));
		}
	}

	private boolean isInInferno()
	{
		return ArrayUtils.contains(client.getMapRegions(), INFERNO_REGION);
	}

	int getNextWaveNumber()
	{
		return currentWaveNumber == -1 || currentWaveNumber == 69 ? -1 : currentWaveNumber + 1;
	}

	private void calculateUpcomingAttacks()
	{
		for (InfernoNPC infernoNPC : infernoNpcs)
		{
			infernoNPC.gameTick(client, lastLocation, finalPhase);

			if (infernoNPC.getType() == InfernoNPC.Type.ZUK && zukShieldCornerTicks == -1)
			{
				infernoNPC.updateNextAttack(InfernoNPC.Attack.UNKNOWN, 12); // TODO: Could be 10 or 11. Test!
				zukShieldCornerTicks = 0;
			}

			// Map all upcoming attacks and their priority + determine which NPC is about to attack next
			if (infernoNPC.getTicksTillNextAttack() > 0 && isPrayerHelper(infernoNPC)
				&& (infernoNPC.getNextAttack() != InfernoNPC.Attack.UNKNOWN
				|| (indicateBlobDetectionTick && infernoNPC.getType() == InfernoNPC.Type.BLOB
				&& infernoNPC.getTicksTillNextAttack() >= 4)))
			{
				upcomingAttacks.computeIfAbsent(infernoNPC.getTicksTillNextAttack(), k -> new HashMap<>());

				if (indicateBlobDetectionTick && infernoNPC.getType() == InfernoNPC.Type.BLOB
					&& infernoNPC.getTicksTillNextAttack() >= 4)
				{
					upcomingAttacks.computeIfAbsent(infernoNPC.getTicksTillNextAttack() - 3, k -> new HashMap<>());
					upcomingAttacks.computeIfAbsent(infernoNPC.getTicksTillNextAttack() - 4, k -> new HashMap<>());

					// If there's already a magic attack on the detection tick, group them
					if (upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).containsKey(InfernoNPC.Attack.MAGIC))
					{
						if (upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).get(InfernoNPC.Attack.MAGIC) > InfernoNPC.Type.BLOB.getPriority())
						{
							upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).put(InfernoNPC.Attack.MAGIC, InfernoNPC.Type.BLOB.getPriority());
						}
					}
					// If there's already a ranged attack on the detection tick, group them
					else if (upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).containsKey(InfernoNPC.Attack.RANGED))
					{
						if (upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).get(InfernoNPC.Attack.RANGED) > InfernoNPC.Type.BLOB.getPriority())
						{
							upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).put(InfernoNPC.Attack.RANGED, InfernoNPC.Type.BLOB.getPriority());
						}
					}
					// If there's going to be a magic attack on the blob attack tick, pray range on the detect tick so magic is prayed on the attack tick
					else if (upcomingAttacks.get(infernoNPC.getTicksTillNextAttack()).containsKey(InfernoNPC.Attack.MAGIC)
						|| upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 4).containsKey(InfernoNPC.Attack.MAGIC))
					{
						if (!upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).containsKey(InfernoNPC.Attack.RANGED)
							|| upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).get(InfernoNPC.Attack.RANGED) > InfernoNPC.Type.BLOB.getPriority())
						{
							upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).put(InfernoNPC.Attack.RANGED, InfernoNPC.Type.BLOB.getPriority());
						}
					}
					// If there's going to be a ranged attack on the blob attack tick, pray magic on the detect tick so range is prayed on the attack tick
					else if (upcomingAttacks.get(infernoNPC.getTicksTillNextAttack()).containsKey(InfernoNPC.Attack.RANGED)
						|| upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 4).containsKey(InfernoNPC.Attack.RANGED))
					{
						if (!upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).containsKey(InfernoNPC.Attack.MAGIC)
							|| upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).get(InfernoNPC.Attack.MAGIC) > InfernoNPC.Type.BLOB.getPriority())
						{
							upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).put(InfernoNPC.Attack.MAGIC, InfernoNPC.Type.BLOB.getPriority());
						}
					}
					// If there's no magic or ranged attack on the detection tick, create a magic pray blob
					else
					{
						upcomingAttacks.get(infernoNPC.getTicksTillNextAttack() - 3).put(InfernoNPC.Attack.MAGIC, InfernoNPC.Type.BLOB.getPriority());
					}
				}
				else
				{
					final InfernoNPC.Attack attack = infernoNPC.getNextAttack();
					final int priority = infernoNPC.getType().getPriority();

					if (!upcomingAttacks.get(infernoNPC.getTicksTillNextAttack()).containsKey(attack)
						|| upcomingAttacks.get(infernoNPC.getTicksTillNextAttack()).get(attack) > priority)
					{
						upcomingAttacks.get(infernoNPC.getTicksTillNextAttack()).put(attack, priority);
					}
				}
			}
		}
	}

	private void calculateClosestAttack()
	{
		if (prayerDisplayMode == InfernoPrayerDisplayMode.PRAYER_TAB
			|| prayerDisplayMode == InfernoPrayerDisplayMode.BOTH)
		{
			int closestTick = 999;
			int closestPriority = 999;

			for (Integer tick : upcomingAttacks.keySet())
			{
				final Map<InfernoNPC.Attack, Integer> attackPriority = upcomingAttacks.get(tick);

				for (InfernoNPC.Attack currentAttack : attackPriority.keySet())
				{
					final int currentPriority = attackPriority.get(currentAttack);
					if (tick < closestTick || (tick == closestTick && currentPriority < closestPriority))
					{
						closestAttack = currentAttack;
						closestPriority = currentPriority;
						closestTick = tick;
					}
				}
			}
		}
	}

	private void calculateSafespots()
	{
		if (currentWaveNumber < 69)
		{
			if (safespotDisplayMode != InfernoSafespotDisplayMode.OFF)
			{
				int checkSize = (int) Math.floor(safespotsCheckSize / 2.0);

				for (int x = -checkSize; x <= checkSize; x++)
				{
					for (int y = -checkSize; y <= checkSize; y++)
					{
						final WorldPoint checkLoc = client.getLocalPlayer().getWorldLocation().dx(x).dy(y);

						if (obstacles.contains(checkLoc))
						{
							continue;
						}

						for (InfernoNPC infernoNPC : infernoNpcs)
						{
							if (!isNormalSafespots(infernoNPC))
							{
								continue;
							}

							if (!safeSpotMap.containsKey(checkLoc))
							{
								safeSpotMap.put(checkLoc, 0);
							}

							if (infernoNPC.canAttack(client, checkLoc)
								|| infernoNPC.canMoveToAttack(client, checkLoc, obstacles))
							{
								if (infernoNPC.getType().getDefaultAttack() == InfernoNPC.Attack.MELEE)
								{
									if (safeSpotMap.get(checkLoc) == 0)
									{
										safeSpotMap.put(checkLoc, 1);
									}
									else if (safeSpotMap.get(checkLoc) == 2)
									{
										safeSpotMap.put(checkLoc, 4);
									}
									else if (safeSpotMap.get(checkLoc) == 3)
									{
										safeSpotMap.put(checkLoc, 5);
									}
									else if (safeSpotMap.get(checkLoc) == 6)
									{
										safeSpotMap.put(checkLoc, 7);
									}
								}

								if (infernoNPC.getType().getDefaultAttack() == InfernoNPC.Attack.MAGIC
									|| (infernoNPC.getType() == InfernoNPC.Type.BLOB
									&& safeSpotMap.get(checkLoc) != 2 && safeSpotMap.get(checkLoc) != 4))
								{
									if (safeSpotMap.get(checkLoc) == 0)
									{
										safeSpotMap.put(checkLoc, 3);
									}
									else if (safeSpotMap.get(checkLoc) == 1)
									{
										safeSpotMap.put(checkLoc, 5);
									}
									else if (safeSpotMap.get(checkLoc) == 2)
									{
										safeSpotMap.put(checkLoc, 6);
									}
									else if (safeSpotMap.get(checkLoc) == 5)
									{
										safeSpotMap.put(checkLoc, 7);
									}
								}

								if (infernoNPC.getType().getDefaultAttack() == InfernoNPC.Attack.RANGED
									|| (infernoNPC.getType() == InfernoNPC.Type.BLOB
									&& safeSpotMap.get(checkLoc) != 3 && safeSpotMap.get(checkLoc) != 5))
								{
									if (safeSpotMap.get(checkLoc) == 0)
									{
										safeSpotMap.put(checkLoc, 2);
									}
									else if (safeSpotMap.get(checkLoc) == 1)
									{
										safeSpotMap.put(checkLoc, 4);
									}
									else if (safeSpotMap.get(checkLoc) == 3)
									{
										safeSpotMap.put(checkLoc, 6);
									}
									else if (safeSpotMap.get(checkLoc) == 4)
									{
										safeSpotMap.put(checkLoc, 7);
									}
								}

								if (infernoNPC.getType() == InfernoNPC.Type.JAD
									&& infernoNPC.getNpc().getWorldArea().isInMeleeDistance(checkLoc))
								{
									if (safeSpotMap.get(checkLoc) == 0)
									{
										safeSpotMap.put(checkLoc, 1);
									}
									else if (safeSpotMap.get(checkLoc) == 2)
									{
										safeSpotMap.put(checkLoc, 4);
									}
									else if (safeSpotMap.get(checkLoc) == 3)
									{
										safeSpotMap.put(checkLoc, 5);
									}
									else if (safeSpotMap.get(checkLoc) == 6)
									{
										safeSpotMap.put(checkLoc, 7);
									}
								}
							}
						}
					}
				}
			}
		}
		else if (currentWaveNumber == 69 && zukShield != null)
		{
			final WorldPoint zukShieldCurrentPosition = zukShield.getWorldLocation();

			if (zukShieldLastPosition != null && zukShieldLastPosition.getX() != zukShieldCurrentPosition.getX()
				&& zukShieldCornerTicks == -2)
			{
				zukShieldBase = zukShieldLastPosition;
				zukShieldCornerTicks = -1;
			}

			zukShieldLastPosition = zukShield.getWorldLocation();

			if (safespotDisplayMode != InfernoSafespotDisplayMode.OFF)
			{
				if ((finalPhase && safespotsZukShieldAfterHealers == InfernoZukShieldDisplayMode.LIVE)
					|| (!finalPhase && safespotsZukShieldBeforeHealers == InfernoZukShieldDisplayMode.LIVE))
				{
					for (int x = zukShield.getWorldLocation().getX() - 1; x <= zukShield.getWorldLocation().getX() + 3; x++)
					{
						for (int y = zukShield.getWorldLocation().getY() - 4; y <= zukShield.getWorldLocation().getY() - 2; y++)
						{
							safeSpotMap.put(new WorldPoint(x, y, client.getPlane()), 0);
						}
					}
				}
				else if ((finalPhase && safespotsZukShieldAfterHealers == InfernoZukShieldDisplayMode.PREDICT)
					|| (!finalPhase && safespotsZukShieldBeforeHealers == InfernoZukShieldDisplayMode.PREDICT))
				{
					if (zukShieldCornerTicks >= 0)
					{
						// TODO: Predict zuk shield safespots
						// Calculate distance from zukShieldCurrentPosition to zukShieldBase.
						// - If shield is not in corner: calculate next position in current direction (use
						//   difference between current and last position to get direction)
						// - If shield is in corner: increment zukShieldCornerTicks and predict next shield
						//   position based on how many ticks the shield has been in the corner.
					}
				}
			}
		}
	}

	private void calculateSafespotAreas()
	{
		if (safespotDisplayMode == InfernoSafespotDisplayMode.AREA)
		{
			for (WorldPoint worldPoint : safeSpotMap.keySet())
			{
				if (!safeSpotAreas.containsKey(safeSpotMap.get(worldPoint)))
				{
					safeSpotAreas.put(safeSpotMap.get(worldPoint), new ArrayList<>());
				}

				safeSpotAreas.get(safeSpotMap.get(worldPoint)).add(worldPoint);
			}
		}

		lastLocation = client.getLocalPlayer().getWorldLocation();
	}

	private void calculateObstacles()
	{
		for (NPC npc : client.getNpcs())
		{
			obstacles.addAll(npc.getWorldArea().toWorldPointList());
		}
	}

	private void calculateCentralNibbler()
	{
		InfernoNPC bestNibbler = null;
		int bestAmountInArea = 0;
		int bestDistanceToPlayer = 999;

		for (InfernoNPC infernoNPC : infernoNpcs)
		{
			if (infernoNPC.getType() != InfernoNPC.Type.NIBBLER)
			{
				continue;
			}

			int amountInArea = 0;
			final int distanceToPlayer = infernoNPC.getNpc().getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation());

			for (InfernoNPC checkNpc : infernoNpcs)
			{
				if (checkNpc.getType() != InfernoNPC.Type.NIBBLER
					|| checkNpc.getNpc().getWorldArea().distanceTo(infernoNPC.getNpc().getWorldArea()) > 1)
				{
					continue;
				}

				amountInArea++;
			}

			if (amountInArea > bestAmountInArea
				|| (amountInArea == bestAmountInArea && distanceToPlayer < bestDistanceToPlayer))
			{
				bestNibbler = infernoNPC;
			}
		}

		if (bestNibbler != null)
		{
			centralNibbler = bestNibbler;
		}
	}

	private boolean isPrayerHelper(InfernoNPC infernoNPC)
	{
		switch (infernoNPC.getType())
		{
			case BAT:
				return prayerBat;
			case BLOB:
				return prayerBlob;
			case MELEE:
				return prayerMeleer;
			case RANGER:
				return prayerRanger;
			case MAGE:
				return prayerMage;
			case HEALER_JAD:
				return prayerHealerJad;
			case JAD:
				return prayerJad;
			default:
				return false;
		}
	}

	boolean isTicksOnNpc(InfernoNPC infernoNPC)
	{
		switch (infernoNPC.getType())
		{
			case BAT:
				return ticksOnNpcBat;
			case BLOB:
				return ticksOnNpcBlob;
			case MELEE:
				return ticksOnNpcMeleer;
			case RANGER:
				return ticksOnNpcRanger;
			case MAGE:
				return ticksOnNpcMage;
			case HEALER_JAD:
				return ticksOnNpcHealerJad;
			case JAD:
				return ticksOnNpcJad;
			case ZUK:
				return ticksOnNpcZuk;
			default:
				return false;
		}
	}

	boolean isNormalSafespots(InfernoNPC infernoNPC)
	{
		switch (infernoNPC.getType())
		{
			case BAT:
				return safespotsBat;
			case BLOB:
				return safespotsBlob;
			case MELEE:
				return safespotsMeleer;
			case RANGER:
				return safespotsRanger;
			case MAGE:
				return safespotsMage;
			case HEALER_JAD:
				return safespotsHealerJad;
			case JAD:
				return safespotsJad;
			default:
				return false;
		}
	}

	boolean isIndicateNpcPosition(InfernoNPC infernoNPC)
	{
		switch (infernoNPC.getType())
		{
			case BAT:
				return indicateNpcPositionBat;
			case BLOB:
				return indicateNpcPositionBlob;
			case MELEE:
				return indicateNpcPositionMeleer;
			case RANGER:
				return indicateNpcPositionRanger;
			case MAGE:
				return indicateNpcPositionMage;
			default:
				return false;
		}
	}

	private void hideNpcDeaths()
	{

		if (this.hideNibblerDeath)
		{
			client.addHiddenNpcDeath("Jal-Nib");
		}
		if (this.hideBatDeath)
		{
			client.addHiddenNpcDeath("Jal-MejRah");
		}
		if (this.hideBlobDeath)
		{
			client.addHiddenNpcDeath("Jal-Ak");
		}
		if (this.hideBlobSmallMeleeDeath)
		{
			client.addHiddenNpcDeath("Jal-AkRek-Ket");
		}
		if (this.hideBlobSmallMagicDeath)
		{
			client.addHiddenNpcDeath("Jal-AkRek-Mej");
		}
		if (this.hideBlobSmallRangedDeath)
		{
			client.addHiddenNpcDeath("Jal-AkRek-Xil");
		}
		if (this.hideMeleerDeath)
		{
			client.addHiddenNpcDeath("Jal-ImKot");
		}
		if (this.hideRangerDeath)
		{
			client.addHiddenNpcDeath("Jal-Xil");
		}
		if (this.hideMagerDeath)
		{
			client.addHiddenNpcDeath("Jal-Zek");
		}
		if (this.hideHealerJadDeath && isInInferno())
		{
			client.addHiddenNpcDeath("Yt-HurKot");
		}
		if (this.hideJadDeath)
		{
			client.addHiddenNpcDeath("JalTok-Jad");
		}
		if (this.hideHealerZukDeath)
		{
			client.addHiddenNpcDeath("Jal-MejJak");
		}
		if (this.hideZukDeath)
		{
			client.addHiddenNpcDeath("TzKal-Zuk");
		}
	}

	private void showNpcDeaths()
	{

		if (!this.hideNibblerDeath)
		{
			client.removeHiddenNpcDeath("Jal-Nib");
		}
		if (!this.hideBatDeath)
		{
			client.removeHiddenNpcDeath("Jal-MejRah");
		}
		if (!this.hideBlobDeath)
		{
			client.removeHiddenNpcDeath("Jal-Ak");
		}
		if (!this.hideBlobSmallMeleeDeath)
		{
			client.removeHiddenNpcDeath("Jal-AkRek-Ket");
		}
		if (!this.hideBlobSmallMagicDeath)
		{
			client.removeHiddenNpcDeath("Jal-AkRek-Mej");
		}
		if (!this.hideBlobSmallRangedDeath)
		{
			client.removeHiddenNpcDeath("Jal-AkRek-Xil");
		}
		if (!this.hideMeleerDeath)
		{
			client.removeHiddenNpcDeath("Jal-ImKot");
		}
		if (!this.hideRangerDeath)
		{
			client.removeHiddenNpcDeath("Jal-Xil");
		}
		if (!this.hideMagerDeath)
		{
			client.removeHiddenNpcDeath("Jal-Zek");
		}
		if (!this.hideHealerJadDeath)
		{
			client.removeHiddenNpcDeath("Yt-HurKot");
		}
		if (!this.hideJadDeath)
		{
			client.removeHiddenNpcDeath("JalTok-Jad");
		}
		if (!this.hideHealerZukDeath)
		{
			client.removeHiddenNpcDeath("Jal-MejJak");
		}
		if (!this.hideZukDeath)
		{
			client.removeHiddenNpcDeath("TzKal-Zuk");
		}
	}

	private void updateConfig()
	{
		this.prayerDisplayMode = config.prayerDisplayMode();
		this.descendingBoxes = config.descendingBoxes();
		this.indicateWhenPrayingCorrectly = config.indicateWhenPrayingCorrectly();
		this.indicateNonPriorityDescendingBoxes = config.indicateNonPriorityDescendingBoxes();
		this.indicateBlobDetectionTick = config.indicateBlobDetectionTick();

		this.waveDisplay = config.waveDisplay();
		this.npcNaming = config.npcNaming();
		this.npcLevels = config.npcLevels();
		this.getWaveOverlayHeaderColor = config.getWaveOverlayHeaderColor();
		this.getWaveTextColor = config.getWaveTextColor();

		this.safespotDisplayMode = config.safespotDisplayMode();
		this.safespotsCheckSize = config.safespotsCheckSize();
		this.indicateNonSafespotted = config.indicateNonSafespotted();
		this.indicateTemporarySafespotted = config.indicateTemporarySafespotted();
		this.indicateSafespotted = config.indicateSafespotted();
		this.indicateObstacles = config.indicateObstacles();
		this.safespotsZukShieldBeforeHealers = config.safespotsZukShieldBeforeHealers();

		this.indicateNibblers = config.indicateNibblers();
		this.indicateCentralNibbler = config.indicateCentralNibbler();

		this.indicateActiveHealersJad = config.indicateActiveHealerJad();
		this.indicateActiveHealersZuk = config.indicateActiveHealerZuk();

		this.indicateNpcPositionBat = config.indicateNpcPositionBat();
		this.indicateNpcPositionBlob = config.indicateNpcPositionBlob();
		this.indicateNpcPositionMeleer = config.indicateNpcPositionMeleer();
		this.indicateNpcPositionRanger = config.indicateNpcPositionRanger();
		this.indicateNpcPositionMage = config.indicateNpcPositionMage();

		this.ticksOnNpcBat = config.ticksOnNpcBat();
		this.ticksOnNpcBlob = config.ticksOnNpcBlob();
		this.ticksOnNpcMeleer = config.ticksOnNpcMeleer();
		this.ticksOnNpcRanger = config.ticksOnNpcRanger();
		this.ticksOnNpcMage = config.ticksOnNpcMage();
		this.ticksOnNpcHealerJad = config.ticksOnNpcHealerJad();
		this.ticksOnNpcJad = config.ticksOnNpcJad();
		this.ticksOnNpcZuk = config.ticksOnNpcZuk();

		this.safespotsBat = config.safespotsBat();
		this.safespotsBlob = config.safespotsBlob();
		this.safespotsMeleer = config.safespotsMeleer();
		this.safespotsRanger = config.safespotsRanger();
		this.safespotsMage = config.safespotsMage();
		this.safespotsHealerJad = config.safespotsHealerJad();
		this.safespotsJad = config.safespotsJad();
		this.safespotsZukShieldBeforeHealers = config.safespotsZukShieldBeforeHealers();
		this.safespotsZukShieldAfterHealers = config.safespotsZukShieldAfterHealers();

		this.prayerBat = config.prayerBat();
		this.prayerBlob = config.prayerBlob();
		this.prayerMeleer = config.prayerMeleer();
		this.prayerRanger = config.prayerRanger();
		this.prayerMage = config.prayerMage();
		this.prayerHealerJad = config.prayerHealerJad();
		this.prayerJad = config.prayerJad();

		this.hideNibblerDeath = config.hideNibblerDeath();
		this.hideBatDeath = config.hideBatDeath();
		this.hideBlobDeath = config.hideBlobDeath();
		this.hideBlobSmallRangedDeath = config.hideBlobSmallRangedDeath();
		this.hideBlobSmallMagicDeath = config.hideBlobSmallMagicDeath();
		this.hideBlobSmallMeleeDeath = config.hideBlobSmallMeleeDeath();
		this.hideMeleerDeath = config.hideMeleerDeath();
		this.hideRangerDeath = config.hideRangerDeath();
		this.hideMagerDeath = config.hideMagerDeath();
		this.hideHealerJadDeath = config.hideHealerJadDeath();
		this.hideJadDeath = config.hideJadDeath();
		this.hideHealerZukDeath = config.hideHealerZukDeath();
		this.hideZukDeath = config.hideZukDeath();
	}
}