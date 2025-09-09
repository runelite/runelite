/*
 *  Copyright (c) 2018, trimbe <github.com/trimbe>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.plugins.randomevents;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.gameval.NpcID;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Notification;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Random Events",
	description = "Notify when random events appear and remove talk/dismiss options on events that aren't yours.",
	enabledByDefault = false
)
@Slf4j
public class RandomEventPlugin extends Plugin
{
	private static final Set<Integer> EVENT_NPCS = ImmutableSet.of(
		NpcID.MACRO_BEEKEEPER_INVITATION,
		NpcID.MACRO_COMBILOCK_PIRATE,
		NpcID.MACRO_JEKYLL, NpcID.MACRO_JEKYLL_UNDERWATER,
		NpcID.MACRO_DWARF,
		NpcID.PATTERN_INVITATION,
		NpcID.MACRO_EVIL_BOB_OUTSIDE, NpcID.MACRO_EVIL_BOB_PRISON,
		NpcID.PINBALL_INVITATION,
		NpcID.MACRO_FORESTER_INVITATION,
		NpcID.MACRO_FROG_CRIER,
		NpcID.MACRO_GENI, NpcID.MACRO_GENI_UNDERWATER,
		NpcID.MACRO_GILES, NpcID.MACRO_GILES_UNDERWATER,
		NpcID.MACRO_GRAVEDIGGER_INVITATION,
		NpcID.MACRO_MILES, NpcID.MACRO_MILES_UNDERWATER,
		NpcID.MACRO_MYSTERIOUS_OLD_MAN, NpcID.MACRO_MYSTERIOUS_OLD_MAN_UNDERWATER,
		NpcID.MACRO_MAZE_INVITATION, NpcID.MACRO_MIME_INVITATION,
		NpcID.MACRO_NILES, NpcID.MACRO_NILES_UNDERWATER,
		NpcID.MACRO_PILLORY_GUARD,
		NpcID.GRAB_POSTMAN,
		NpcID.MACRO_MAGNESON_INVITATION,
		NpcID.MACRO_HIGHWAYMAN, NpcID.MACRO_HIGHWAYMAN_UNDERWATER,
		NpcID.MACRO_SANDWICH_LADY_NPC,
		NpcID.MACRO_DRILLDEMON_INVITATION,
		NpcID.MACRO_COUNTCHECK_SURFACE, NpcID.MACRO_COUNTCHECK_UNDERWATER
	);
	private static final Set<String> EVENT_OPTIONS = ImmutableSet.of(
		"Talk-to",
		"Dismiss"
	);
	private static final int RANDOM_EVENT_TIMEOUT = 150;

	private NPC currentRandomEvent;
	private int lastNotificationTick = -RANDOM_EVENT_TIMEOUT; // to avoid double notifications

	@Inject
	private Client client;

	@Inject
	private Notifier notifier;

	@Inject
	private RandomEventConfig config;

	@Provides
	RandomEventConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RandomEventConfig.class);
	}

	@Override
	protected void shutDown() throws Exception
	{
		lastNotificationTick = 0;
		currentRandomEvent = null;
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		Actor source = event.getSource();
		Actor target = event.getTarget();
		Player player = client.getLocalPlayer();

		// Check that the npc is interacting with the player and the player isn't interacting with the npc, so
		// that the notification doesn't fire from talking to other user's randoms
		if (player == null
			|| target != player
			|| player.getInteracting() == source
			|| !(source instanceof NPC)
			|| !EVENT_NPCS.contains(((NPC) source).getId()))
		{
			return;
		}

		log.debug("Random event spawn: {}", source.getName());

		currentRandomEvent = (NPC) source;

		if (client.getTickCount() - lastNotificationTick > RANDOM_EVENT_TIMEOUT)
		{
			lastNotificationTick = client.getTickCount();

			notifier.notify(shouldNotify(currentRandomEvent.getId()), "Random event spawned: " + currentRandomEvent.getName());
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();

		if (npc == currentRandomEvent)
		{
			currentRandomEvent = null;
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (event.getType() >= MenuAction.NPC_FIRST_OPTION.getId()
			&& event.getType() <= MenuAction.NPC_FIFTH_OPTION.getId()
			&& EVENT_OPTIONS.contains(event.getOption()))
		{
			NPC npc = event.getMenuEntry().getNpc();
			if (npc != null && EVENT_NPCS.contains(npc.getId()) && npc != currentRandomEvent && config.removeMenuOptions())
			{
				client.setMenuEntries(Arrays.copyOf(client.getMenuEntries(), client.getMenuEntries().length - 1));
			}
		}
	}

	private Notification shouldNotify(int id)
	{
		Notification notification = null;
		switch (id)
		{
			case NpcID.MACRO_BEEKEEPER_INVITATION:
				notification = config.notifyBeekeeper();
				break;
			case NpcID.MACRO_COMBILOCK_PIRATE:
				notification = config.notifyArnav();
				break;
			case NpcID.MACRO_DWARF:
				notification = config.notifyDwarf();
				break;
			case NpcID.MACRO_DRILLDEMON_INVITATION:
				notification = config.notifyDemon();
				break;
			case NpcID.MACRO_FORESTER_INVITATION:
				notification = config.notifyForester();
				break;
			case NpcID.MACRO_FROG_CRIER:
				notification = config.notifyFrog();
				break;
			case NpcID.MACRO_GENI:
			case NpcID.MACRO_GENI_UNDERWATER:
				notification = config.notifyGenie();
				break;
			case NpcID.MACRO_GILES:
			case NpcID.MACRO_GILES_UNDERWATER:
			case NpcID.MACRO_NILES:
			case NpcID.MACRO_NILES_UNDERWATER:
			case NpcID.MACRO_MILES:
			case NpcID.MACRO_MILES_UNDERWATER:
				notification = config.notifyCerters();
				break;
			case NpcID.MACRO_JEKYLL:
			case NpcID.MACRO_JEKYLL_UNDERWATER:
				notification = config.notifyJekyll();
				break;
			case NpcID.MACRO_EVIL_BOB_OUTSIDE:
				notification = config.notifyBob();
				break;
			case NpcID.MACRO_EVIL_BOB_PRISON:
				notification = config.notifyPrison();
				break;
			case NpcID.MACRO_GRAVEDIGGER_INVITATION:
				notification = config.notifyGravedigger();
				break;
			case NpcID.MACRO_MYSTERIOUS_OLD_MAN:
			case NpcID.MACRO_MYSTERIOUS_OLD_MAN_UNDERWATER:
				notification = config.notifyMoM();
				break;
			case NpcID.MACRO_MAZE_INVITATION:
				notification = config.notifyMaze();
				break;
			case NpcID.MACRO_MIME_INVITATION:
				notification = config.notifyMime();
				break;
			case NpcID.MACRO_PILLORY_GUARD:
				notification = config.notifyPillory();
				break;
			case NpcID.GRAB_POSTMAN:
				notification = config.notifyTwin();
				break;
			case NpcID.MACRO_MAGNESON_INVITATION:
				notification = config.notifyQuiz();
				break;
			case NpcID.MACRO_HIGHWAYMAN:
			case NpcID.MACRO_HIGHWAYMAN_UNDERWATER:
				notification = config.notifyTurpentine();
				break;
			case NpcID.PATTERN_INVITATION:
				notification = config.notifyDunce();
				break;
			case NpcID.MACRO_SANDWICH_LADY_NPC:
				notification = config.notifySandwich();
				break;
			case NpcID.PINBALL_INVITATION:
				notification = config.notifyFlippa();
				break;
			case NpcID.MACRO_COUNTCHECK_SURFACE:
			case NpcID.MACRO_COUNTCHECK_UNDERWATER:
				notification = config.notifyCountCheck();
				break;
		}

		if (notification != null && notification.isEnabled())
		{
			return notification;
		}

		return config.notifyAllEvents();
	}
}
