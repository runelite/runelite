/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2019, Ganom <https://github.com/ganom>
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
package net.runelite.client.plugins.zulrah;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.Sound;
import net.runelite.client.game.SoundManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.zulrah.overlays.ZulrahCurrentPhaseOverlay;
import net.runelite.client.plugins.zulrah.overlays.ZulrahNextPhaseOverlay;
import net.runelite.client.plugins.zulrah.overlays.ZulrahOverlay;
import net.runelite.client.plugins.zulrah.overlays.ZulrahPrayerOverlay;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPattern;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternA;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternB;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternC;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternD;
import net.runelite.client.plugins.zulrah.phase.ZulrahPhase;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Zulrah Helper",
	description = "Shows tiles on where to stand during the phases and what prayer to use.",
	tags = {"zulrah", "boss", "helper"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Slf4j
@Singleton
public class ZulrahPlugin extends Plugin
{
	private static final ZulrahPattern[] patterns = new ZulrahPattern[]
		{
			new ZulrahPatternA(),
			new ZulrahPatternB(),
			new ZulrahPatternC(),
			new ZulrahPatternD()
		};
	@Getter(AccessLevel.PACKAGE)
	private NPC zulrah;
	@Inject
	private Client client;
	@Inject
	private ZulrahConfig config;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private SoundManager soundManager;
	@Inject
	private ZulrahCurrentPhaseOverlay currentPhaseOverlay;
	@Inject
	private ZulrahNextPhaseOverlay nextPhaseOverlay;
	@Inject
	private ZulrahPrayerOverlay zulrahPrayerOverlay;
	@Inject
	private ZulrahOverlay zulrahOverlay;
	@Inject
	private EventBus eventBus;
	private ZulrahInstance instance;

	@Provides
	ZulrahConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ZulrahConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		overlayManager.add(currentPhaseOverlay);
		overlayManager.add(nextPhaseOverlay);
		overlayManager.add(zulrahPrayerOverlay);
		overlayManager.add(zulrahOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(currentPhaseOverlay);
		overlayManager.remove(nextPhaseOverlay);
		overlayManager.remove(zulrahPrayerOverlay);
		overlayManager.remove(zulrahOverlay);
		zulrah = null;
		instance = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
	}

	private void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (zulrah == null)
		{
			if (instance != null)
			{
				log.debug("Zulrah encounter has ended.");
				instance = null;
			}
			return;
		}

		if (instance == null)
		{
			instance = new ZulrahInstance(zulrah);
			log.debug("Zulrah encounter has started.");
		}

		ZulrahPhase currentPhase = ZulrahPhase.valueOf(zulrah, instance.getStartLocation());

		if (instance.getPhase() == null)
		{
			instance.setPhase(currentPhase);
		}
		else if (!instance.getPhase().equals(currentPhase))
		{
			ZulrahPhase previousPhase = instance.getPhase();
			instance.setPhase(currentPhase);
			instance.nextStage();

			log.debug("Zulrah phase has moved from {} -> {}, stage: {}", previousPhase, currentPhase, instance.getStage());
		}

		ZulrahPattern pattern = instance.getPattern();

		if (pattern == null)
		{
			int potential = 0;
			ZulrahPattern potentialPattern = null;

			for (ZulrahPattern p : patterns)
			{
				if (p.stageMatches(instance.getStage(), instance.getPhase()))
				{
					potential++;
					potentialPattern = p;
				}
			}

			if (potential == 1)
			{
				log.debug("Zulrah pattern identified: {}", potentialPattern);

				instance.setPattern(potentialPattern);
			}
		}
		else if (pattern.canReset(instance.getStage()) && (instance.getPhase() == null || instance.getPhase().equals(pattern.get(0))))
		{
			log.debug("Zulrah pattern has reset.");

			instance.reset();
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		if (instance == null)
		{
			return;
		}

		ZulrahPhase currentPhase = instance.getPhase();
		ZulrahPhase nextPhase = instance.getNextPhase();

		if (currentPhase == null || nextPhase == null)
		{
			return;
		}

		final Actor actor = event.getActor();

		if (config.sounds() && zulrah != null && zulrah.equals(actor) && zulrah.getAnimation() == AnimationID.ZULRAH_PHASE)
		{
			Prayer prayer = nextPhase.getPrayer();

			if (prayer == null)
			{
				return;
			}

			switch (prayer)
			{
				case PROTECT_FROM_MAGIC:
					soundManager.playSound(Sound.PRAY_MAGIC);
					break;
				case PROTECT_FROM_MISSILES:
					soundManager.playSound(Sound.PRAY_RANGED);
					break;
			}
		}
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		if (npc != null && npc.getName() != null &&
			npc.getName().toLowerCase().contains("zulrah"))
		{
			zulrah = npc;
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();
		if (npc != null && npc.getName() != null &&
			npc.getName().toLowerCase().contains("zulrah"))
		{
			zulrah = null;
		}
	}

	public ZulrahInstance getInstance()
	{
		return instance;
	}
}
