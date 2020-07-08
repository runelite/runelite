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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.inferno.displaymodes.InfernoPrayerDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoSafespotDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoWaveDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoZukShieldDisplayMode;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Inferno",
	enabledByDefault = false,
	description = "Inferno helper",
	tags = {"combat", "overlay", "pve", "pvm"}

)
@Slf4j
public class InfernoPlugin extends Plugin
{
	private static final int INFERNO_REGION = 9043;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private NPCManager npcManager;

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
	private boolean finalPhaseTick = false;
	@Getter(AccessLevel.PACKAGE)
	private NPC zukShield = null;
	private NPC zuk = null;
	private WorldPoint zukShieldLastPosition = null;
	private WorldPoint zukShieldBase = null;
	private int zukShieldCornerTicks = -2;

	private int zukShieldNegativeXCoord = -1;
	private int zukShieldPositiveXCoord = -1;
	private int zukShieldLastNonZeroDelta = 0;
	private int zukShieldLastDelta = 0;
	private int zukShieldTicksLeftInCorner = -1;

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

	private InfernoSpawnTimerInfobox spawnTimerInfoBox;

	@Provides
	InfernoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InfernoConfig.class);
	}

	@Override
	protected void startUp()
	{
		waveOverlay.setDisplayMode(config.waveDisplay());
		waveOverlay.setWaveHeaderColor(config.getWaveOverlayHeaderColor());
		waveOverlay.setWaveTextColor(config.getWaveTextColor());

		if (isInInferno())
		{
			overlayManager.add(infernoOverlay);

			if (config.waveDisplay() != InfernoWaveDisplayMode.NONE)
			{
				overlayManager.add(waveOverlay);
			}

			overlayManager.add(jadOverlay);
			overlayManager.add(prayerOverlay);
			hideNpcDeaths();
		}
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(infernoOverlay);
		overlayManager.remove(waveOverlay);
		overlayManager.remove(jadOverlay);
		overlayManager.remove(prayerOverlay);

		infoBoxManager.removeInfoBox(spawnTimerInfoBox);

		currentWaveNumber = -1;

		showNpcDeaths();
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!"inferno".equals(event.getGroup()))
		{
			return;
		}

		hideNpcDeaths();
		showNpcDeaths();

		if (event.getKey().endsWith("color"))
		{
			waveOverlay.setWaveHeaderColor(config.getWaveOverlayHeaderColor());
			waveOverlay.setWaveTextColor(config.getWaveTextColor());
		}
		else if ("waveDisplay".equals(event.getKey()))
		{
			overlayManager.remove(waveOverlay);

			waveOverlay.setDisplayMode(config.waveDisplay());

			if (isInInferno() && config.waveDisplay() != InfernoWaveDisplayMode.NONE)
			{
				overlayManager.add(waveOverlay);
			}
		}
		if (event.getKey().equals("mirrorMode"))
		{
			if (isInInferno())
			{
				infernoOverlay.determineLayer();
				jadOverlay.determineLayer();
				prayerOverlay.determineLayer();
				overlayManager.remove(infernoOverlay);
				overlayManager.remove(jadOverlay);
				overlayManager.remove(prayerOverlay);
				overlayManager.add(infernoOverlay);
				overlayManager.add(jadOverlay);
				overlayManager.add(prayerOverlay);

				if (config.waveDisplay() != InfernoWaveDisplayMode.NONE)
				{
					waveOverlay.determineLayer();
					overlayManager.remove(waveOverlay);
					overlayManager.add(waveOverlay);
				}
			}
		}
	}

	@Subscribe
	private void onGameTick(GameTick event)
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

		calculateSpawnTimerInfobox();

		//no longer on the same tick that finalPhase started
		if (finalPhaseTick)
		{
			finalPhaseTick = false;
		}
	}

	@Subscribe
	private void onNpcSpawned(NpcSpawned event)
	{
		if (!isInInferno())
		{
			return;
		}

		final int npcId = event.getNpc().getId();

		if (npcId == NpcID.ANCESTRAL_GLYPH)
		{
			zukShield = event.getNpc();
			return;
		}

		final InfernoNPC.Type infernoNPCType = InfernoNPC.Type.typeFromId(npcId);

		if (infernoNPCType == null)
		{
			return;
		}

		switch (infernoNPCType)
		{
			case BLOB:
				// Blobs need to be added to the end of the list because the prayer for their detection tick
				// will be based on the upcoming attacks of other NPC's
				infernoNpcs.add(new InfernoNPC(event.getNpc()));
				return;
			case MAGE:
				if (zuk != null && spawnTimerInfoBox != null)
				{
					spawnTimerInfoBox.reset();
					spawnTimerInfoBox.run();
				}
				break;
			case ZUK:
				finalPhase = false;
				zukShieldCornerTicks = -2;
				zukShieldLastPosition = null;
				zukShieldBase = null;
				log.debug("[INFERNO] Zuk spawn detected, not in final phase");

				if (config.spawnTimerInfobox())
				{
					zuk = event.getNpc();

					if (spawnTimerInfoBox != null)
					{
						infoBoxManager.removeInfoBox(spawnTimerInfoBox);
					}

					spawnTimerInfoBox = new InfernoSpawnTimerInfobox(itemManager.getImage(ItemID.TZREKZUK), this);
					infoBoxManager.addInfoBox(spawnTimerInfoBox);
				}
				break;
			case HEALER_ZUK:
				finalPhase = true;
				finalPhaseTick = true;
				for (InfernoNPC infernoNPC : infernoNpcs)
				{
					if (infernoNPC.getType() == InfernoNPC.Type.ZUK)
					{
						infernoNPC.setTicksTillNextAttack(-1);
					}
				}
				log.debug("[INFERNO] Final phase detected!");
				break;
		}

		infernoNpcs.add(0, new InfernoNPC(event.getNpc()));
	}

	@Subscribe
	private void onNpcDespawned(NpcDespawned event)
	{
		if (!isInInferno())
		{
			return;
		}

		int npcId = event.getNpc().getId();

		switch (npcId)
		{
			case NpcID.ANCESTRAL_GLYPH:
				zukShield = null;
				return;
			case NpcID.TZKALZUK:
				zuk = null;

				if (spawnTimerInfoBox != null)
				{
					infoBoxManager.removeInfoBox(spawnTimerInfoBox);
				}

				spawnTimerInfoBox = null;
				break;
			default:
				break;
		}

		infernoNpcs.removeIf(infernoNPC -> infernoNPC.getNpc() == event.getNpc());
	}

	@Subscribe
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

	@Subscribe
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

			zukShield = null;
			zuk = null;

			if (spawnTimerInfoBox != null)
			{
				infoBoxManager.removeInfoBox(spawnTimerInfoBox);
			}

			spawnTimerInfoBox = null;
		}
		else if (currentWaveNumber == -1)
		{
			infernoNpcs.clear();

			currentWaveNumber = 1;

			overlayManager.add(infernoOverlay);
			overlayManager.add(jadOverlay);
			overlayManager.add(prayerOverlay);

			if (config.waveDisplay() != InfernoWaveDisplayMode.NONE)
			{
				overlayManager.add(waveOverlay);
			}
		}
	}

	@Subscribe
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
			infernoNPC.gameTick(client, lastLocation, finalPhase, finalPhaseTick);

			if (infernoNPC.getType() == InfernoNPC.Type.ZUK && zukShieldCornerTicks == -1)
			{
				infernoNPC.updateNextAttack(InfernoNPC.Attack.UNKNOWN, 12); // TODO: Could be 10 or 11. Test!
				zukShieldCornerTicks = 0;
			}

			// Map all upcoming attacks and their priority + determine which NPC is about to attack next
			if (infernoNPC.getTicksTillNextAttack() > 0 && isPrayerHelper(infernoNPC)
				&& (infernoNPC.getNextAttack() != InfernoNPC.Attack.UNKNOWN
				|| (config.indicateBlobDetectionTick() && infernoNPC.getType() == InfernoNPC.Type.BLOB
				&& infernoNPC.getTicksTillNextAttack() >= 4)))
			{
				upcomingAttacks.computeIfAbsent(infernoNPC.getTicksTillNextAttack(), k -> new HashMap<>());

				if (config.indicateBlobDetectionTick() && infernoNPC.getType() == InfernoNPC.Type.BLOB
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
		if (config.prayerDisplayMode() == InfernoPrayerDisplayMode.PRAYER_TAB
			|| config.prayerDisplayMode() == InfernoPrayerDisplayMode.BOTH)
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
			if (config.safespotDisplayMode() != InfernoSafespotDisplayMode.OFF)
			{
				int checkSize = (int) Math.floor(config.safespotsCheckSize() / 2.0);

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

			if (zukShieldLastPosition != null && zukShieldLastPosition.getX() != zukShieldCurrentPosition.getX() && zukShieldCornerTicks == -2)
			{
				zukShieldBase = zukShieldLastPosition;
				zukShieldCornerTicks = -1;
			}

			if (zukShieldLastPosition != null)
			{
				int zukShieldDelta = zukShieldCurrentPosition.getX() - zukShieldLastPosition.getX();

				//if zuk shield moved, update zukShieldLastNonZeroDelta to show the direction
				if (zukShieldDelta != 0)
				{
					zukShieldLastNonZeroDelta = zukShieldDelta;
				}

				//reset corner ticks when the shield started to move out of the corner
				if (zukShieldLastDelta == 0 && zukShieldDelta != 0)
				{
					zukShieldTicksLeftInCorner = 4;
				}

				//if zuk shield did not move, also set the negative/positive XCoords for the shield
				if (zukShieldDelta == 0)
				{
					if (zukShieldLastNonZeroDelta > 0)
					{
						zukShieldPositiveXCoord = zukShieldCurrentPosition.getX();
					}
					else if (zukShieldLastNonZeroDelta < 0)
					{
						zukShieldNegativeXCoord = zukShieldCurrentPosition.getX();
					}

					//if zukShieldCorner Ticks > 0, decrement it
					if (zukShieldTicksLeftInCorner > 0)
					{
						zukShieldTicksLeftInCorner--;
					}
				}

				zukShieldLastDelta = zukShieldDelta;
			}

			zukShieldLastPosition = zukShieldCurrentPosition;

			if (config.safespotDisplayMode() != InfernoSafespotDisplayMode.OFF)
			{
				if ((finalPhase && config.safespotsZukShieldAfterHealers() == InfernoZukShieldDisplayMode.LIVE)
					|| (!finalPhase && config.safespotsZukShieldBeforeHealers() == InfernoZukShieldDisplayMode.LIVE))
				{
					drawZukSafespot(zukShield.getWorldLocation().getX(), zukShield.getWorldLocation().getY(), 0);
				}

				if ((finalPhase && config.safespotsZukShieldAfterHealers() == InfernoZukShieldDisplayMode.LIVEPLUSPREDICT)
					|| (!finalPhase && config.safespotsZukShieldBeforeHealers() == InfernoZukShieldDisplayMode.LIVEPLUSPREDICT))
				{
					//draw the normal live safespot
					drawZukSafespot(zukShield.getWorldLocation().getX(), zukShield.getWorldLocation().getY(), 0);

					drawZukPredictedSafespot();
				}
				else if ((finalPhase && config.safespotsZukShieldAfterHealers() == InfernoZukShieldDisplayMode.PREDICT)
					|| (!finalPhase && config.safespotsZukShieldBeforeHealers() == InfernoZukShieldDisplayMode.PREDICT))
				{
					drawZukPredictedSafespot();
				}
			}
		}
	}

	private void drawZukPredictedSafespot()
	{
		final WorldPoint zukShieldCurrentPosition = zukShield.getWorldLocation();
		//only do this if both xcoords defined.
		if (zukShieldPositiveXCoord != -1 && zukShieldNegativeXCoord != -1)
		{
			int nextShieldXCoord = zukShieldCurrentPosition.getX();

			//calculate the next zuk shield position
			for (InfernoNPC infernoNPC : infernoNpcs)
			{
				if (infernoNPC.getType() == InfernoNPC.Type.ZUK)
				{
					int ticksTilZukAttack = finalPhase ? infernoNPC.getTicksTillNextAttack() : infernoNPC.getTicksTillNextAttack() - 1;

					if (ticksTilZukAttack < 1)
					{
						if (finalPhase)
						{
							//if ticksTilZukAttack < 1 and finalPhase, must be due to finalPhase. don't render predicted safepot until next attack.
							return;
						}
						else
						{
							//safe to start to render the next safespot
							ticksTilZukAttack = 10;
						}
					}

					//if zuk shield moving in positive direction
					if (zukShieldLastNonZeroDelta > 0)
					{
						nextShieldXCoord += ticksTilZukAttack;

						//nextShieldPosition appears to be past the rightmost spot, must adjust
						if (nextShieldXCoord > zukShieldPositiveXCoord)
						{
							//reduce by number of ticks spent in corner
							nextShieldXCoord -= zukShieldTicksLeftInCorner;

							//nextShieldPosition is LT or equal to the rightmost spot
							if (nextShieldXCoord <= zukShieldPositiveXCoord)
							{
								//shield should be at that spot
								nextShieldXCoord = zukShieldPositiveXCoord;
							}
							else
							{
								//nextShieldPosition is right of the rightmost spot still
								nextShieldXCoord = zukShieldPositiveXCoord - nextShieldXCoord + zukShieldPositiveXCoord;
							}
						}
					}
					else
					{
						//moving in negative direction
						nextShieldXCoord -= ticksTilZukAttack;

						//nextShieldPosition appears to be past the leftmost spot, must adjust
						if (nextShieldXCoord < zukShieldNegativeXCoord)
						{
							//add by number of ticks spent in corner
							nextShieldXCoord += zukShieldTicksLeftInCorner;

							//nextShieldPosition is GT or equal to the leftmost spot
							if (nextShieldXCoord >= zukShieldNegativeXCoord)
							{
								//shield should be at that spot
								nextShieldXCoord = zukShieldNegativeXCoord;
							}
							else
							{
								//nextShieldPosition is left of the leftmost spot still
								nextShieldXCoord = zukShieldNegativeXCoord - nextShieldXCoord + zukShieldNegativeXCoord;
							}
						}
					}
				}
			}

			//draw the predicted safespot
			drawZukSafespot(nextShieldXCoord, zukShield.getWorldLocation().getY(), 2);
		}
	}

	private void drawZukSafespot(int xCoord, int yCoord, int colorSafeSpotId)
	{
		for (int x = xCoord - 1; x <= xCoord + 3; x++)
		{
			for (int y = yCoord - 4; y <= yCoord - 2; y++)
			{
				safeSpotMap.put(new WorldPoint(x, y, client.getPlane()), colorSafeSpotId);
			}
		}
	}

	private void calculateSafespotAreas()
	{
		if (config.safespotDisplayMode() == InfernoSafespotDisplayMode.AREA)
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

	private void calculateSpawnTimerInfobox()
	{
		if (zuk == null || finalPhase || spawnTimerInfoBox == null)
		{
			return;
		}

		final int pauseHp = 600;
		final int resumeHp = 480;

		int hp = calculateNpcHp(zuk.getHealthRatio(), zuk.getHealthScale(), npcManager.getHealth(zuk.getId()));

		if (hp <= 0)
		{
			return;
		}

		if (spawnTimerInfoBox.isRunning())
		{
			if (hp >= resumeHp && hp < pauseHp)
			{
				spawnTimerInfoBox.pause();
			}
		}
		else
		{
			if (hp < resumeHp)
			{
				spawnTimerInfoBox.run();
			}
		}
	}

	private static int calculateNpcHp(int ratio, int health, int maxHp)
	{
		// See OpponentInfo Plugin
		// Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
		// Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>

		if (ratio < 0 || health <= 0 || maxHp == -1)
		{
			return -1;
		}

		int exactHealth = 0;

		if (ratio > 0)
		{
			int minHealth = 1;
			int maxHealth;

			if (health > 1)
			{
				if (ratio > 1)
				{
					minHealth = (maxHp * (ratio - 1) + health - 2) / (health - 1);
				}

				maxHealth = (maxHp * ratio - 1) / (health - 1);

				if (maxHealth > maxHp)
				{
					maxHealth = maxHp;
				}
			}
			else
			{
				maxHealth = maxHp;
			}

			exactHealth = (minHealth + maxHealth + 1) / 2;
		}

		return exactHealth;
	}

	private boolean isPrayerHelper(InfernoNPC infernoNPC)
	{
		switch (infernoNPC.getType())
		{
			case BAT:
				return config.prayerBat();
			case BLOB:
				return config.prayerBlob();
			case MELEE:
				return config.prayerMeleer();
			case RANGER:
				return config.prayerRanger();
			case MAGE:
				return config.prayerMage();
			case HEALER_JAD:
				return config.prayerHealerJad();
			case JAD:
				return config.prayerJad();
			default:
				return false;
		}
	}

	boolean isTicksOnNpc(InfernoNPC infernoNPC)
	{
		switch (infernoNPC.getType())
		{
			case BAT:
				return config.ticksOnNpcBat();
			case BLOB:
				return config.ticksOnNpcBlob();
			case MELEE:
				return config.ticksOnNpcMeleer();
			case RANGER:
				return config.ticksOnNpcRanger();
			case MAGE:
				return config.ticksOnNpcMage();
			case HEALER_JAD:
				return config.ticksOnNpcHealerJad();
			case JAD:
				return config.ticksOnNpcJad();
			case ZUK:
				return config.ticksOnNpcZuk();
			default:
				return false;
		}
	}

	boolean isNormalSafespots(InfernoNPC infernoNPC)
	{
		switch (infernoNPC.getType())
		{
			case BAT:
				return config.safespotsBat();
			case BLOB:
				return config.safespotsBlob();
			case MELEE:
				return config.safespotsMeleer();
			case RANGER:
				return config.safespotsRanger();
			case MAGE:
				return config.safespotsMage();
			case HEALER_JAD:
				return config.safespotsHealerJad();
			case JAD:
				return config.safespotsJad();
			default:
				return false;
		}
	}

	boolean isIndicateNpcPosition(InfernoNPC infernoNPC)
	{
		switch (infernoNPC.getType())
		{
			case BAT:
				return config.indicateNpcPositionBat();
			case BLOB:
				return config.indicateNpcPositionBlob();
			case MELEE:
				return config.indicateNpcPositionMeleer();
			case RANGER:
				return config.indicateNpcPositionRanger();
			case MAGE:
				return config.indicateNpcPositionMage();
			default:
				return false;
		}
	}

	private void hideNpcDeaths()
	{

//		if (config.hideNibblerDeath())
//		{
//			client.addHiddenNpcDeath("Jal-Nib");
//		}
//		if (config.hideBatDeath())
//		{
//			client.addHiddenNpcDeath("Jal-MejRah");
//		}
//		if (config.hideBlobDeath())
//		{
//			client.addHiddenNpcDeath("Jal-Ak");
//		}
//		if (config.hideBlobSmallMeleeDeath())
//		{
//			client.addHiddenNpcDeath("Jal-AkRek-Ket");
//		}
//		if (config.hideBlobSmallMagicDeath())
//		{
//			client.addHiddenNpcDeath("Jal-AkRek-Mej");
//		}
//		if (config.hideBlobSmallRangedDeath())
//		{
//			client.addHiddenNpcDeath("Jal-AkRek-Xil");
//		}
//		if (config.hideMeleerDeath())
//		{
//			client.addHiddenNpcDeath("Jal-ImKot");
//		}
//		if (config.hideRangerDeath())
//		{
//			client.addHiddenNpcDeath("Jal-Xil");
//		}
//		if (config.hideMagerDeath())
//		{
//			client.addHiddenNpcDeath("Jal-Zek");
//		}
//		if (config.hideHealerJadDeath() && isInInferno())
//		{
//			client.addHiddenNpcDeath("Yt-HurKot");
//		}
//		if (config.hideJadDeath())
//		{
//			client.addHiddenNpcDeath("JalTok-Jad");
//		}
//		if (config.hideHealerZukDeath())
//		{
//			client.addHiddenNpcDeath("Jal-MejJak");
//		}
//		if (config.hideZukDeath())
//		{
//			client.addHiddenNpcDeath("TzKal-Zuk");
//		}
	}

	private void showNpcDeaths()
	{

//		if (!config.hideNibblerDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-Nib");
//		}
//		if (!config.hideBatDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-MejRah");
//		}
//		if (!config.hideBlobDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-Ak");
//		}
//		if (!config.hideBlobSmallMeleeDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-AkRek-Ket");
//		}
//		if (!config.hideBlobSmallMagicDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-AkRek-Mej");
//		}
//		if (!config.hideBlobSmallRangedDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-AkRek-Xil");
//		}
//		if (!config.hideMeleerDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-ImKot");
//		}
//		if (!config.hideRangerDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-Xil");
//		}
//		if (!config.hideMagerDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-Zek");
//		}
//		if (!config.hideHealerJadDeath())
//		{
//			client.removeHiddenNpcDeath("Yt-HurKot");
//		}
//		if (!config.hideJadDeath())
//		{
//			client.removeHiddenNpcDeath("JalTok-Jad");
//		}
//		if (!config.hideHealerZukDeath())
//		{
//			client.removeHiddenNpcDeath("Jal-MejJak");
//		}
//		if (!config.hideZukDeath())
//		{
//			client.removeHiddenNpcDeath("TzKal-Zuk");
//		}
	}
}