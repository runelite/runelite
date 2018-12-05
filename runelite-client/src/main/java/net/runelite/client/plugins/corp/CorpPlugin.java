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
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Corporeal Beast",
	description = "Show damage statistics and highlight dark energy cores",
	tags = {"bosses", "combat", "pve", "overlay"}
)
@Slf4j
public class CorpPlugin extends Plugin
{
	private static final int NPC_SECTION_ACTION = MenuAction.NPC_SECOND_OPTION.getId();
	private static final String ATTACK = "Attack";
	private static final String DARK_ENERGY_CORE = "Dark energy core";

	@Getter(AccessLevel.PACKAGE)
	private NPC corp;

	@Getter(AccessLevel.PACKAGE)
	private NPC core;

	private int yourDamage;

	@Getter(AccessLevel.PACKAGE)
	private int totalDamage;

	@Getter(AccessLevel.PACKAGE)
	private final Set<Actor> players = new HashSet<>();

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

	@Inject
	private CorpConfig config;

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
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(corpOverlay);
		overlayManager.remove(coreOverlay);

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
			corp = null;
			players.clear();

			if (npc.isDead())
			{
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
					.type(ChatMessageType.GAME)
					.runeLiteFormattedMessage(message)
					.build());
			}
		}
		else if (npc == core)
		{
			core = null;
		}
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied)
	{
		Actor actor = hitsplatApplied.getActor();

		if (actor != corp)
		{
			return;
		}

		int myDamage = client.getVar(Varbits.CORP_DAMAGE);
		// sometimes hitsplats are applied after the damage counter has been reset
		if (myDamage > 0)
		{
			yourDamage = myDamage;
		}
		totalDamage += hitsplatApplied.getHitsplat().getAmount();
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged interactingChanged)
	{
		Actor source = interactingChanged.getSource();
		Actor target = interactingChanged.getTarget();

		if (corp == null || target != corp)
		{
			return;
		}

		players.add(source);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
	{
		if (menuEntryAdded.getType() != NPC_SECTION_ACTION
			|| !config.leftClickCore() || !menuEntryAdded.getOption().equals(ATTACK))
		{
			return;
		}

		final int npcIndex = menuEntryAdded.getIdentifier();
		final NPC npc = client.getCachedNPCs()[npcIndex];
		if (npc == null || !npc.getName().equals(DARK_ENERGY_CORE))
		{
			return;
		}

		// since this is the menu entry add event, this is the last menu entry
		MenuEntry[] menuEntries = client.getMenuEntries();
		MenuEntry menuEntry = menuEntries[menuEntries.length - 1];

		menuEntry.setType(NPC_SECTION_ACTION + MENU_ACTION_DEPRIORITIZE_OFFSET);
		client.setMenuEntries(menuEntries);
	}
}
