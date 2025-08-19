/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.entityhider;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import net.runelite.api.Renderable;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.SpotanimID;
import net.runelite.client.callback.Hooks;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.NpcUtil;
import net.runelite.client.party.PartyService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Entity Hider",
	description = "Hide players, NPCs, and/or projectiles",
	tags = {"npcs", "players", "projectiles"},
	enabledByDefault = false
)
public class EntityHiderPlugin extends Plugin
{
	private static final Set<Integer> THRALL_IDS = ImmutableSet.of(
		NpcID.ARCEUUS_THRALL_GHOST_LESSER, NpcID.ARCEUUS_THRALL_SKELETON_LESSER, NpcID.ARCEUUS_THRALL_ZOMBIE_LESSER,  // Lesser Thrall (ghost, skeleton, zombie)
		NpcID.ARCEUUS_THRALL_GHOST_SUPERIOR, NpcID.ARCEUUS_THRALL_SKELETON_SUPERIOR, NpcID.ARCEUUS_THRALL_ZOMBIE_SUPERIOR,  // Superior Thrall (ghost, skeleton, zombie)
		NpcID.ARCEUUS_THRALL_GHOST_GREATER, NpcID.ARCEUUS_THRALL_SKELETON_GREATER, NpcID.ARCEUUS_THRALL_ZOMBIE_GREATER   // Greater Thrall (ghost, skeleton, zombie)
	);
	private static final Set<Integer> RANDOM_EVENT_NPC_IDS = ImmutableSet.of(
		NpcID.MACRO_BEEKEEPER_INVITATION,
		NpcID.MACRO_COMBILOCK_PIRATE,
		NpcID.MACRO_JEKYLL, NpcID.MACRO_JEKYLL_UNDERWATER,
		NpcID.MACRO_DWARF,
		NpcID.PATTERN_INVITATION,
		NpcID.MACRO_EVIL_BOB_OUTSIDE, NpcID.MACRO_EVIL_BOB_PRISON,
		NpcID.PINBALL_INVITATION,
		NpcID.MACRO_FORESTER_INVITATION,
		NpcID.MACRO_FROG_CRIER, NpcID.MACRO_FROG_GENERIC, NpcID.MACRO_FROG_SULKING, NpcID.MACRO_FROG_NONCOMBAT, NpcID.MACRO_FROG_NOHAT, NpcID.MACRO_FROG_PRIN_HE, NpcID.MACRO_FROG_PRIN_SHE, NpcID.MACRO_FROG_PRIN_A, NpcID.MACRO_FROG_PRIN_B,
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

	@Inject
	private Client client;

	@Inject
	private EntityHiderConfig config;

	@Inject
	private Hooks hooks;

	@Inject
	private NpcUtil npcUtil;

	@Inject
	private PartyService partyService;

	private boolean hideOthers;
	private boolean hideOthers2D;
	private boolean hidePartyMembers;
	private boolean hidePartyMembers2D;
	private boolean hideFriends;
	private boolean hideFriends2D;
	private boolean hideFriendsChatMembers;
	private boolean hideFriendsChatMembers2D;
	private boolean hideClanMembers;
	private boolean hideClanMembers2D;
	private boolean hideIgnoredPlayers;
	private boolean hideIgnoredPlayers2D;
	private boolean hideLocalPlayer;
	private boolean hideLocalPlayer2D;
	private boolean hideNPCs;
	private boolean hideNPCs2D;
	private boolean hideDeadNpcs;
	private boolean hidePets;
	private boolean hideThralls;
	private boolean hideRandomEvents;
	private boolean hideAttackers;
	private boolean hideAttackers2D;
	private boolean hideProjectiles;

	private final Hooks.RenderableDrawListener drawListener = this::shouldDraw;

	@Provides
	EntityHiderConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EntityHiderConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();

		hooks.registerRenderableDrawListener(drawListener);
	}

	@Override
	protected void shutDown()
	{
		hooks.unregisterRenderableDrawListener(drawListener);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged e)
	{
		if (e.getGroup().equals(EntityHiderConfig.GROUP))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		hideOthers = config.hideOthers();
		hideOthers2D = config.hideOthers2D();

		hidePartyMembers = config.hidePartyMembers();
		hidePartyMembers2D = config.hidePartyMembers2D();

		hideFriends = config.hideFriends();
		hideFriends2D = config.hideFriends2D();

		hideFriendsChatMembers = config.hideFriendsChatMembers();
		hideFriendsChatMembers2D = config.hideFriendsChatMembers2D();

		hideClanMembers = config.hideClanChatMembers();
		hideClanMembers2D = config.hideClanChatMembers2D();

		hideIgnoredPlayers = config.hideIgnores();
		hideIgnoredPlayers2D = config.hideIgnores2D();

		hideLocalPlayer = config.hideLocalPlayer();
		hideLocalPlayer2D = config.hideLocalPlayer2D();

		hideNPCs = config.hideNPCs();
		hideNPCs2D = config.hideNPCs2D();
		hideDeadNpcs = config.hideDeadNpcs();

		hidePets = config.hidePets();

		hideThralls = config.hideThralls();
		hideRandomEvents = config.hideRandomEvents();

		hideAttackers = config.hideAttackers();
		hideAttackers2D = config.hideAttackers2D();

		hideProjectiles = config.hideProjectiles();
	}

	@VisibleForTesting
	boolean shouldDraw(Renderable renderable, boolean drawingUI)
	{
		if (renderable instanceof Player)
		{
			Player player = (Player) renderable;
			Player local = client.getLocalPlayer();

			if (player.getName() == null)
			{
				// player.isFriend() and player.isFriendsChatMember() npe when the player has a null name
				return true;
			}

			// Allow hiding local self in pvp, which is an established meta.
			// It is more advantageous than renderself due to being able to still render local player 2d
			if (player == local)
			{
				return !(drawingUI ? hideLocalPlayer2D : hideLocalPlayer);
			}

			if (player.getInteracting() == local)
			{
				if (!drawingUI && hideAttackers)
				{
					return false;
				}
				if (drawingUI && hideAttackers2D)
				{
					return false;
				}
			}

			if (partyService.isInParty() && partyService.getMemberByDisplayName(player.getName()) != null)
			{
				return !(drawingUI ? hidePartyMembers2D : hidePartyMembers);
			}
			if (player.isFriend())
			{
				return !(drawingUI ? hideFriends2D : hideFriends);
			}
			if (player.isFriendsChatMember())
			{
				return !(drawingUI ? hideFriendsChatMembers2D : hideFriendsChatMembers);
			}
			if (player.isClanMember())
			{
				return !(drawingUI ? hideClanMembers2D : hideClanMembers);
			}
			if (client.getIgnoreContainer().findByName(player.getName()) != null)
			{
				return !(drawingUI ? hideIgnoredPlayers2D : hideIgnoredPlayers);
			}

			return !(drawingUI ? hideOthers2D : hideOthers);
		}
		else if (renderable instanceof NPC)
		{
			NPC npc = (NPC) renderable;

			if (npc.getComposition().isFollower() && npc != client.getFollower())
			{
				return !hidePets;
			}

			// dead npcs can also be interacting so prioritize it over the interacting check
			if (npcUtil.isDying(npc) && hideDeadNpcs)
			{
				return false;
			}

			if (npc.getInteracting() == client.getLocalPlayer())
			{
				if (!drawingUI && hideAttackers)
				{
					return false;
				}
				if (drawingUI && hideAttackers2D)
				{
					return false;
				}
			}

			if (THRALL_IDS.contains(npc.getId()))
			{
				return !hideThralls;
			}

			if (RANDOM_EVENT_NPC_IDS.contains(npc.getId()))
			{
				return !hideRandomEvents;
			}

			return !(drawingUI ? hideNPCs2D : hideNPCs);
		}
		else if (renderable instanceof Projectile)
		{
			return !hideProjectiles;
		}
		else if (renderable instanceof GraphicsObject)
		{
			if (!hideDeadNpcs)
			{
				return true;
			}

			switch (((GraphicsObject) renderable).getId())
			{
				case SpotanimID.TOB_NYLOCAS_DEATH_MELEE_STANDARD:
				case SpotanimID.TOB_NYLOCAS_DEATH_RANGED_STANDARD:
				case SpotanimID.TOB_NYLOCAS_DEATH_MAGIC_STANDARD:
				case SpotanimID.TOB_NYLOCAS_DEATH_MELEE_DETONATE:
				case SpotanimID.TOB_NYLOCAS_DEATH_RANGED_DETONATE:
				case SpotanimID.TOB_NYLOCAS_DEATH_MAGIC_DETONATE:
					return false;
				default:
					return true;
			}
		}

		return true;
	}
}
