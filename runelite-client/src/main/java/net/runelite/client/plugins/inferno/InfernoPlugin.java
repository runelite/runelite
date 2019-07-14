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
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.HeadIcon;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
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
	private InfernoJadOverlay jadOverlay;

	@Inject
	private InfernoInfobox infernoInfobox;

	@Inject
	private InfernoNibblerOverlay nibblerOverlay;

	@Inject
	private InfernoConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private int currentWave = -1;

	@Getter(AccessLevel.PACKAGE)
	private Map<NPC, InfernoNPC> monsters;

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, ArrayList<InfernoNPC>> monsterCurrentAttackMap;

	@Getter(AccessLevel.PACKAGE)
	private List<NPC> nibblers;

	@Getter(AccessLevel.PACKAGE)
	private InfernoNPC[] priorityNPC;

	@Getter(AccessLevel.PACKAGE)
	@Nullable
	private InfernoJadAttack attack;

	private NPC jad;

	@Getter(AccessLevel.PACKAGE)
	private int currentWaveNumber;

	private final List<Actor> waveMonsters;

	public InfernoPlugin()
	{
		waveMonsters = new ArrayList<>();
	}

	@Getter(AccessLevel.PACKAGE)
	private boolean displayNibblerOverlay;
	@Getter(AccessLevel.PACKAGE)
	private boolean showPrayerHelp;
	private InfernoWaveDisplayMode waveDisplay;
	private Color getWaveOverlayHeaderColor;
	private Color getWaveTextColor;

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

		if (isInInferno())
		{
			overlayManager.add(infernoOverlay);
			overlayManager.add(infernoInfobox);
			overlayManager.add(nibblerOverlay);

			if (this.waveDisplay != InfernoWaveDisplayMode.NONE)
			{
				overlayManager.add(waveOverlay);
			}

			overlayManager.add(jadOverlay);
		}

		waveOverlay.setWaveHeaderColor(this.getWaveOverlayHeaderColor);
		waveOverlay.setWaveTextColor(this.getWaveTextColor);

		monsters = new HashMap<>();
		monsterCurrentAttackMap = new HashMap<>(6);

		for (int i = 1; i <= 6; i++)
		{
			monsterCurrentAttackMap.put(i, new ArrayList<>());
		}

		nibblers = new ArrayList<>();
		priorityNPC = new InfernoNPC[4];
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(infernoInfobox);
		overlayManager.remove(infernoOverlay);
		overlayManager.remove(nibblerOverlay);
		overlayManager.remove(waveOverlay);
		overlayManager.remove(jadOverlay);
		jad = null;
		attack = null;
		monsters = null;
		currentWaveNumber = -1;
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

	private void onNpcSpawned(NpcSpawned event)
	{
		if (client.getMapRegions()[0] != 9043)
		{
			return;
		}

		NPC npc = event.getNpc();
		if (isValidInfernoMob(npc))
		{
			monsters.put(npc, new InfernoNPC(npc));
			log.debug(String.valueOf(monsters.size()));
		}

		if (npc.getId() == NpcID.JALNIB)
		{
			nibblers.add(npc);
		}

		final int id = event.getNpc().getId();

		if (id == NpcID.JALTOKJAD || id == NpcID.JALTOKJAD_7704)
		{
			jad = event.getNpc();
		}

		final Actor actor = event.getActor();

		if (actor != null)
		{
			waveMonsters.add(actor);
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		if (client.getMapRegions()[0] != 9043)
		{
			return;
		}

		NPC npc = event.getNpc();
		if (monsters.containsKey(npc))
		{
			monsters.remove(npc);
			log.debug(String.valueOf(monsters.size()));
		}

		if (npc.getId() == NpcID.JALNIB)
		{
			nibblers.remove(npc);
		}

		if (jad == event.getNpc())
		{
			jad = null;
			attack = null;
		}
		final Actor actor = event.getActor();
		if (actor != null)
		{
			waveMonsters.remove(actor);
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
			currentWaveNumber = -1;
			overlayManager.remove(infernoInfobox);
			overlayManager.remove(infernoOverlay);
			overlayManager.remove(nibblerOverlay);
			overlayManager.remove(waveOverlay);
			overlayManager.remove(jadOverlay);
		}
		else if (currentWaveNumber == -1)
		{
			currentWaveNumber = 1;
			overlayManager.add(infernoOverlay);
			overlayManager.add(infernoInfobox);
			overlayManager.add(nibblerOverlay);

			if (this.waveDisplay != InfernoWaveDisplayMode.NONE)
			{
				overlayManager.add(waveOverlay);
			}

			overlayManager.add(jadOverlay);
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
			currentWaveNumber = Integer.parseInt(message.substring(0, message.indexOf("<")));
		}
	}

	private void onGameTick(GameTick event)
	{
		if (client.getMapRegions()[0] != 9043)
		{
			return;
		}

		clearMapAndPriority();

		for (InfernoNPC monster : monsters.values())
		{
			calculateDistanceToPlayer(monster);

			NPC npc = monster.getNpc();

			// if they are not attacking but are still attacking
			if (monster.isAttacking())
			{
				monster.setTicksTillAttack(monster.getTicksTillAttack() - 1);

				// sets the blobs attack style
				if (monster.getName().equals("blob") && monster.getTicksTillAttack() == 3 && monster.getDistanceToPlayer() <= 15)
				{
					if (client.getLocalPlayer().getOverheadIcon() == null)
					{
						monster.setAttackstyle(InfernoNPC.Attackstyle.RANDOM);
					}
					else if (client.getLocalPlayer().getOverheadIcon().equals(HeadIcon.MAGIC))
					{
						monster.setAttackstyle(InfernoNPC.Attackstyle.RANGE);
					}
					else if (client.getLocalPlayer().getOverheadIcon().equals(HeadIcon.RANGED))
					{
						monster.setAttackstyle(InfernoNPC.Attackstyle.MAGE);
					}
				}

				// we know the monster is not attacking because it should have attacked and is idling
				if (monster.getTicksTillAttack() == 0)
				{
					if (npc.getAnimation() == -1)
					{
						monster.setAttacking(false);
					}
					else
					{
						// want to reset the monsters attack back to attacking
						monster.attacked();
					}
				}
			}
			else
			{
				// they've just attacked
				if (npc.getAnimation() == monster.getAttackAnimation() || npc.getAnimation() == 7581) // special case for blob
				{
					monster.attacked();
				}
			}

			if (monster.getTicksTillAttack() >= 1)
			{
				monsterCurrentAttackMap.get(monster.getTicksTillAttack()).add(monster);
			}
		}

		calculatePriorityNPC();
	}

	private void onAnimationChanged(final AnimationChanged event)
	{
		if (event.getActor() != jad)
		{
			return;
		}

		if (jad.getAnimation() == InfernoJadAttack.MAGIC.getAnimation())
		{
			attack = InfernoJadAttack.MAGIC;
		}
		else if (jad.getAnimation() == InfernoJadAttack.RANGE.getAnimation())
		{
			attack = InfernoJadAttack.RANGE;
		}
	}

	private void calculatePriorityNPC()
	{
		for (int i = 0; i < priorityNPC.length; i++)
		{
			ArrayList<InfernoNPC> monsters = monsterCurrentAttackMap.get(i + 1);

			if (monsters.size() == 0)
			{
				continue;
			}

			int priority = monsters.get(0).getPriority();

			InfernoNPC infernoNPC = monsters.get(0);

			for (InfernoNPC npc : monsters)
			{
				if (npc.getPriority() < priority)
				{
					priority = npc.getPriority();
					infernoNPC = npc;
				}
			}

			priorityNPC[i] = infernoNPC;

			log.debug("i: " + i + " " + infernoNPC.getName());
		}
	}

	// TODO: blob calculator
	private void calculateDistanceToPlayer(InfernoNPC monster)
	{
		monster.setDistanceToPlayer(client.getLocalPlayer().getWorldLocation().distanceTo(monster.getNpc().getWorldArea()));
	}

	private void clearMapAndPriority()
	{
		for (List<InfernoNPC> l : monsterCurrentAttackMap.values())
		{
			l.clear();
		}

		for (int i = 0; i < priorityNPC.length; i++)
		{
			priorityNPC[i] = null;
		}
	}

	private boolean isValidInfernoMob(NPC npc)
	{
		// we only want the bat, blob, melee, ranger and mager
		return npc.getId() == NpcID.JALMEJRAH ||
			npc.getId() == NpcID.JALAK ||
			npc.getId() == NpcID.JALIMKOT ||
			npc.getId() == NpcID.JALXIL ||
			npc.getId() == NpcID.JALZEK;
	}

	private boolean isInInferno()
	{
		return ArrayUtils.contains(client.getMapRegions(), INFERNO_REGION);
	}

	boolean isNotFinalWave()
	{
		return currentWaveNumber <= 68;
	}

	List<Actor> getWaveMonsters()
	{
		return waveMonsters;
	}

	int getNextWaveNumber()
	{
		return currentWaveNumber == -1 || currentWaveNumber == 69 ? -1 : currentWaveNumber + 1;
	}

	private void updateConfig()
	{
		this.displayNibblerOverlay = config.displayNibblerOverlay();
		this.showPrayerHelp = config.showPrayerHelp();
		this.waveDisplay = config.waveDisplay();
		this.getWaveOverlayHeaderColor = config.getWaveOverlayHeaderColor();
		this.getWaveTextColor = config.getWaveTextColor();
	}
}
