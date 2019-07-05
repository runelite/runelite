/*
 * Copyright (c) 2019, GeChallengeM <https://github.com/GeChallengeM>
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
package net.runelite.client.plugins.npcstatus;

import com.google.inject.Provides;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GraphicID;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "NPC Status Timer",
	description = "Adds a timer on NPC's for their attacks and flinching.",
	tags = {"flinch", "npc"},
	enabledByDefault = false
)
@Singleton
public class NpcStatusPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private final Set<MemorizedNPC> memorizedNPCs = new HashSet<>();

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private NPCManager npcManager;

	@Inject
	private NpcStatusConfig config;

	@Inject
	private NpcStatusOverlay npcStatusOverlay;

	@Getter(AccessLevel.PACKAGE)
	private Instant lastTickUpdate;

	private WorldArea lastPlayerLocation;

	private int getRange;

	@Provides
	NpcStatusConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NpcStatusConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		this.getRange = config.getRange();
		overlayManager.add(npcStatusOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(npcStatusOverlay);
		memorizedNPCs.clear();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		final NPC npc = npcSpawned.getNpc();
		final String npcName = npc.getName();

		if (npcName == null || !Arrays.asList(npc.getDefinition().getActions()).contains("Attack"))
		{
			return;
		}
		memorizedNPCs.add(new MemorizedNPC(npc, npcManager.getAttackSpeed(npc.getId()), npc.getWorldArea()));
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();
		memorizedNPCs.removeIf(c -> c.getNpc() == npc);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN ||
			event.getGameState() == GameState.HOPPING)
		{
			memorizedNPCs.clear();
		}
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		if (event.getActor().getInteracting() != client.getLocalPlayer())
		{
			return;
		}
		final Hitsplat hitsplat = event.getHitsplat();
		if (hitsplat.getHitsplatType() == Hitsplat.HitsplatType.DAMAGE || hitsplat.getHitsplatType() == Hitsplat.HitsplatType.BLOCK)
		{
			if (event.getActor() instanceof NPC)
			{
				for (MemorizedNPC mn : memorizedNPCs)
				{
					if (mn.getStatus() == MemorizedNPC.Status.OUT_OF_COMBAT || (mn.getStatus() == MemorizedNPC.Status.IN_COMBAT && mn.getCombatTimerEnd() - client.getTickCount() < 1) || mn.getLastinteracted() == null)
					{
						mn.setStatus(MemorizedNPC.Status.FLINCHING);
						mn.setCombatTimerEnd(-1);
						mn.setFlinchTimerEnd(client.getTickCount() + mn.getAttackSpeed() / 2 + 1);
					}
				}
			}
		}
	}

	private void checkStatus()
	{
		for (MemorizedNPC npc : memorizedNPCs)
		{
			final int ATTACK_SPEED = npc.getAttackSpeed();
			final double CombatTime = npc.getCombatTimerEnd() - client.getTickCount();
			final double FlinchTime = npc.getFlinchTimerEnd() - client.getTickCount();
			if (npc.getNpc().getWorldArea() == null)
			{
				continue;
			}
			if (npc.getNpc().getInteracting() == client.getLocalPlayer())
			{
				if (npc.getLastspotanimation() == GraphicID.SPLASH && npc.getNpc().getSpotAnimation() == GraphicID.SPLASH) //For splash flinching
				{
					npc.setLastspotanimation(-1);
					if ((npc.getStatus() == MemorizedNPC.Status.OUT_OF_COMBAT) || npc.getLastinteracted() == null)
					{
						npc.setStatus(MemorizedNPC.Status.FLINCHING);
						npc.setCombatTimerEnd(-1);
						npc.setFlinchTimerEnd(client.getTickCount() + ATTACK_SPEED / 2 + 1);
						npc.setLastnpcarea(npc.getNpc().getWorldArea());
						npc.setLastinteracted(npc.getNpc().getInteracting());
						continue;
					}
				}
				//Checks: will the NPC attack this tick?
				if (((npc.getNpc().getWorldArea().canMelee(client, lastPlayerLocation) && this.getRange == 1) //Separate mechanics for meleerange-only NPC's because they have extra collisiondata checks (fences etc.) and can't attack diagonally
					|| (lastPlayerLocation.hasLineOfSightTo(client, npc.getNpc().getWorldArea()) && npc.getNpc().getWorldArea().distanceTo(lastPlayerLocation) <= this.getRange && this.getRange > 1))
					&& ((npc.getStatus() != MemorizedNPC.Status.FLINCHING && CombatTime < 9) || (npc.getStatus() == MemorizedNPC.Status.FLINCHING && FlinchTime < 2))
					&& npc.getNpc().getAnimation() != -1 //Failsafe, attacking NPC's always have an animation.
					&& !(npc.getLastnpcarea().distanceTo(lastPlayerLocation) == 0 && npc.getLastnpcarea() != npc.getNpc().getWorldArea())) //Weird mechanic: NPC's can't attack on the tick they do a random move
				{
					npc.setCombatTimerEnd(client.getTickCount() + ATTACK_SPEED + 8);
					npc.setStatus(MemorizedNPC.Status.IN_COMBAT_DELAY);
					npc.setLastnpcarea(npc.getNpc().getWorldArea());
					npc.setLastspotanimation(npc.getNpc().getSpotAnimation());
					npc.setLastinteracted(npc.getNpc().getInteracting());
					continue;
				}
			}
			switch (npc.getStatus())
			{
				case IN_COMBAT:
					if (CombatTime < 2)
					{
						npc.setStatus(MemorizedNPC.Status.OUT_OF_COMBAT);
					}
					break;
				case IN_COMBAT_DELAY:
					if (CombatTime < 9)
					{
						npc.setStatus(MemorizedNPC.Status.IN_COMBAT);
					}
					break;
				case FLINCHING:
					if (FlinchTime < 2)
					{
						npc.setStatus(MemorizedNPC.Status.IN_COMBAT);
						npc.setCombatTimerEnd(client.getTickCount() + 8);
					}
			}
			npc.setLastnpcarea(npc.getNpc().getWorldArea());
			npc.setLastspotanimation(npc.getNpc().getSpotAnimation());
			npc.setLastinteracted(npc.getNpc().getInteracting());
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		lastTickUpdate = Instant.now();
		checkStatus();
		lastPlayerLocation = client.getLocalPlayer().getWorldArea();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("npcstatus"))
		{
			return;
		}

		this.getRange = config.getRange();
	}
}
