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
	private Map<NPC, NPCContainer> npcContainer = new HashMap<>();

	@Provides
	TickTimersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TickTimersConfig.class);
	}

	@Override
	public void startUp()
	{
		npcContainer.clear();
	}

	@Override
	public void shutDown()
	{
		npcContainer.clear();
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
		npcContainer.clear();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		switch (npc.getId())
		{
			case NpcID.SERGEANT_STRONGSTACK:
			case NpcID.SERGEANT_STEELWILL:
			case NpcID.SERGEANT_GRIMSPIKE:
			case NpcID.GENERAL_GRAARDOR:
			case NpcID.GENERAL_GRAARDOR_6494:
				npcContainer.put(npc, new NPCContainer(npc));
				break;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (npcContainer.remove(event.getNpc()) != null && !npcContainer.isEmpty())
		{
			npcContainer.remove(event.getNpc());
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
		for (NPCContainer npcs : getNpcContainer().values())
		{
			switch (npcs.getNpc().getId())
			{
				case NpcID.SERGEANT_STRONGSTACK:
					npcs.setTicksUntilAttack(npcs.getTicksUntilAttack() - 1);
					npcs.setAttackStyle(NPCContainer.Attackstyle.MELEE);
					switch (npcs.getNpc().getAnimation())
					{
						case AnimationID.MINION_AUTO1:
						case AnimationID.MINION_AUTO2:
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(5);
							}
							break;
					}
					break;
				case NpcID.SERGEANT_STEELWILL:
					npcs.setTicksUntilAttack(npcs.getTicksUntilAttack() - 1);
					npcs.setAttackStyle(NPCContainer.Attackstyle.MAGE);
					switch (npcs.getNpc().getAnimation())
					{
						case AnimationID.MINION_AUTO1:
						case AnimationID.MINION_AUTO2:
						case AnimationID.MINION_AUTO3:
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(5);
							}
							break;
					}
				case NpcID.SERGEANT_GRIMSPIKE:
					npcs.setTicksUntilAttack(npcs.getTicksUntilAttack() - 1);
					npcs.setAttackStyle(NPCContainer.Attackstyle.RANGE);
					switch (npcs.getNpc().getAnimation())
					{
						case AnimationID.MINION_AUTO1:
						case AnimationID.MINION_AUTO2:
						case AnimationID.MINION_AUTO4:
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(5);
							}
							break;
					}
					break;
				case NpcID.GENERAL_GRAARDOR:
				case NpcID.GENERAL_GRAARDOR_6494:
					npcs.setTicksUntilAttack(npcs.getTicksUntilAttack() - 1);
					npcs.setAttackStyle(NPCContainer.Attackstyle.MELEE);
					switch (npcs.getNpc().getAnimation())
					{
						case AnimationID.GENERAL_AUTO1:
						case AnimationID.GENERAL_AUTO2:
						case AnimationID.GENERAL_AUTO3:
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(6);
							}
							break;
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
