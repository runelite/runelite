/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.corp;

import com.google.inject.Provides;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.specialcounter.SpecialCounterUpdate;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ws.PartyMember;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;

@PluginDescriptor(
	name = "Corporeal Beast",
	description = "Show damage statistics and highlight dark energy cores",
	tags = {"bosses", "combat", "pve", "overlay"}
)
@Slf4j
public class CorpPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private NPC corp;

	@Getter(AccessLevel.PACKAGE)
	private NPC core;

	@Getter(AccessLevel.PACKAGE)
	private int yourDamage;

	@Getter(AccessLevel.PACKAGE)
	private int totalDamage;

	@Getter(AccessLevel.PACKAGE)
	private final Set<Actor> players = new HashSet<>();

	@Inject
	private PartyService party;

	@Inject
	private ClientThread clientThread;

	@Inject
	private WSClient wsClient;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CorpDamageOverlay corpOverlay;

	@Inject
	private CoreOverlay coreOverlay;

	@Provides
	CorpConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CorpConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(corpOverlay);
		overlayManager.add(coreOverlay);
		wsClient.registerMessage(CorpDamageUpdate.class);
		wsClient.registerMessage(CorpDespawnedUpdate.class);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(corpOverlay);
		overlayManager.remove(coreOverlay);
		wsClient.unregisterMessage(CorpDamageUpdate.class);
		wsClient.unregisterMessage(CorpDespawnedUpdate.class);

		corp = core = null;
		yourDamage = 0;
		totalDamage = 0;
		players.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOADING)
		{
			players.clear();
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();

		switch (npc.getId())
		{
			case NpcID.CORPOREAL_BEAST:
				if(corp != null && !party.getMembers().isEmpty()) {
					corp = npc;
					return;
				}
				log.debug("Corporeal beast spawn: {}", npc);
				corp = npc;
				yourDamage = 0;
				totalDamage = 0;
				players.clear();
				break;
			case NpcID.DARK_ENERGY_CORE:
				core = npc;
				break;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();

		if (npc == corp)
		{
			log.debug("Corporeal beast despawn: {}", npc);

			if (npc.isDead())
			{
				showKillStats();
				if(!party.getMembers().isEmpty())
				{
					final CorpDespawnedUpdate update = new CorpDespawnedUpdate();
					update.setMemberId(party.getLocalMember().getMemberId());
					wsClient.send(update);
				}
			}
		}
		else if (npc == core)
		{
			core = null;
		}
	}

	private void showKillStats()
	{
		corp = null;
		players.clear();
		// Show kill stats
		String message = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Corporeal Beast: Your damage: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(yourDamage))
			.append(ChatColorType.NORMAL)
			.append(", Total damage: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(totalDamage))
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(message)
			.build());
	}

	@Subscribe
	public void onCorpDespawnedUpdate(CorpDespawnedUpdate update)
	{
		String name = party.getMemberById(update.getMemberId()).getName();
		if (name == null)
		{
			return;
		}

		if(corp == null) {
			return;
		}

		clientThread.invoke(() ->
		{
			showKillStats();
		});
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied)
	{
		Actor actor = hitsplatApplied.getActor();

		if (actor != corp)
		{
			return;
		}

		Hitsplat hitsplat = hitsplatApplied.getHitsplat();
		int damage = hitsplat.getAmount();
		if (hitsplat.isMine())
		{
			yourDamage += damage;
		}

		if(party.getMembers().isEmpty())
		{
			totalDamage += damage;
		}
		else if (hitsplat.isMine())
		{
			final CorpDamageUpdate update = new CorpDamageUpdate(damage, totalDamage);
			update.setMemberId(party.getLocalMember().getMemberId());
			wsClient.send(update);
		}
	}

	@Subscribe
	public void onCorpDamageUpdate(CorpDamageUpdate update) {
		String name = party.getMemberById(update.getMemberId()).getName();
		if (name == null)
		{
			return;
		}

		clientThread.invoke(() ->
		{
			// you have no idea what a corp is
			if(corp == null)
			{
				return;
			}

			if(totalDamage < update.getTotalDamageSync())
			{
				totalDamage = update.getTotalDamageSync();
			}

			totalDamage += update.getHit();
		});
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged interactingChanged)
	{
		Actor source = interactingChanged.getSource();
		Actor target = interactingChanged.getTarget();

		if (corp == null || target != corp) {
			return;
		}

		// a source actor that leaves and comes back is a new actor to the client? so they are not part of the player list
		for(Actor actor : players) {
			if(actor.getName().equals(source.getName())) {
				return;
			}
		}
		players.add(source);
	}
}
