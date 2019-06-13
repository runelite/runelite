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
package net.runelite.client.plugins.ticktimers;

import com.google.inject.Provides;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Boss Tick Timers",
	description = "Tick timers for bosses",
	tags = {"pvm", "bossing"},
	enabledByDefault = false,
	type = PluginType.PVM
)

@Slf4j
public class TickTimersPlugin extends Plugin
{
	private static final int GENERAL_REGION = 11347;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TimersOverlay timersOverlay;

	@Inject
	private TickTimersConfig config;

	@Getter(AccessLevel.PACKAGE)
	private Map<NPC, NPCContainer> Strongstack = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private Map<NPC, NPCContainer> Steelwill = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private Map<NPC, NPCContainer> Grimspike = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private Map<NPC, NPCContainer> General = new HashMap<>();

	@Provides
	TickTimersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TickTimersConfig.class);
	}

	@Override
	public void startUp()
	{
		Strongstack.clear();
		Steelwill.clear();
		Grimspike.clear();
		General.clear();
	}

	@Override
	public void shutDown()
	{
		Strongstack.clear();
		Steelwill.clear();
		Grimspike.clear();
		General.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			if (isInGeneralRegion())
			{
				overlayManager.add(timersOverlay);
			}
			else
			{
				overlayManager.remove(timersOverlay);
			}
		}
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		Strongstack.clear();
		Steelwill.clear();
		Grimspike.clear();
		General.clear();

	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		switch (npc.getId())
		{
			case NpcID.SERGEANT_STRONGSTACK:
				Strongstack.put(npc, new NPCContainer(npc));
				break;
			case NpcID.SERGEANT_STEELWILL:
				Steelwill.put(npc, new NPCContainer(npc));
				break;
			case NpcID.SERGEANT_GRIMSPIKE:
				Grimspike.put(npc, new NPCContainer(npc));
				break;
			case NpcID.GENERAL_GRAARDOR:
			case NpcID.GENERAL_GRAARDOR_6494:
				General.put(npc, new NPCContainer(npc));
				break;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (Grimspike.remove(event.getNpc()) != null && !Grimspike.isEmpty())
		{
			Grimspike.clear();
		}
		if (Steelwill.remove(event.getNpc()) != null && !Steelwill.isEmpty())
		{
			Steelwill.clear();
		}
		if (Strongstack.remove(event.getNpc()) != null && !Strongstack.isEmpty())
		{
			Strongstack.clear();
		}
		if (General.remove(event.getNpc()) != null && !General.isEmpty())
		{
			General.clear();
		}
	}

	@Subscribe
	public void onGameTick(GameTick Event)
	{
		if (config.graardor())
		{
			graardorHandler();
		}
	}

	private void graardorHandler()
	{
		for (NPCContainer grimspike : getGrimspike().values())
		{
			grimspike.setTicksUntilAttack(grimspike.getTicksUntilAttack() - 1);
			switch (grimspike.getNpc().getAnimation())
			{
				case AnimationID.MINION_AUTO1:
				case AnimationID.MINION_AUTO2:
				case AnimationID.MINION_AUTO4:
					if (grimspike.getTicksUntilAttack() < 1)
					{
						grimspike.setTicksUntilAttack(5);
					}
					break;
			}
		}

		for (NPCContainer strongstack : getStrongstack().values())
		{
			strongstack.setTicksUntilAttack(strongstack.getTicksUntilAttack() - 1);
			switch (strongstack.getNpc().getAnimation())
			{
				case AnimationID.MINION_AUTO1:
				case AnimationID.MINION_AUTO2:
					if (strongstack.getTicksUntilAttack() < 1)
					{
						strongstack.setTicksUntilAttack(5);
					}
					break;
			}
		}

		for (NPCContainer steelwill : getSteelwill().values())
		{
			steelwill.setTicksUntilAttack(steelwill.getTicksUntilAttack() - 1);
			switch (steelwill.getNpc().getAnimation())
			{
				case AnimationID.MINION_AUTO1:
				case AnimationID.MINION_AUTO2:
				case AnimationID.MINION_AUTO3:
					if (steelwill.getTicksUntilAttack() < 1)
					{
						steelwill.setTicksUntilAttack(5);
					}
					break;
			}
		}

		for (NPCContainer boss : getGeneral().values())
		{
			boss.setTicksUntilAttack(boss.getTicksUntilAttack() - 1);
			switch (boss.getNpc().getAnimation())
			{
				case AnimationID.GENERAL_AUTO1:
				case AnimationID.GENERAL_AUTO2:
				case AnimationID.GENERAL_AUTO3:
					if (boss.getTicksUntilAttack() < 1)
					{
						boss.setTicksUntilAttack(6);
					}
					break;
			}
		}
	}

	private boolean isInGeneralRegion()
	{
		return ArrayUtils.contains(client.getMapRegions(), GENERAL_REGION);
	}
}
