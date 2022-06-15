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
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import net.runelite.api.Renderable;
import net.runelite.api.Varbits;
import net.runelite.client.callback.Hooks;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
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
	@Inject
	private Client client;

	@Inject
	private EntityHiderConfig config;

	@Inject
	private Hooks hooks;

	private boolean hideOthers;
	private boolean hideOthers2D;
	private boolean hideFriends;
	private boolean hideFriendsChatMembers;
	private boolean hideClanMembers;
	private boolean hideIgnoredPlayers;
	private boolean hideLocalPlayer;
	private boolean hideLocalPlayer2D;
	private boolean hideNPCs;
	private boolean hideNPCs2D;
	private boolean hidePets;
	private boolean hideAttackers;
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

		hideFriends = config.hideFriends();
		hideFriendsChatMembers = config.hideFriendsChatMembers();
		hideClanMembers = config.hideClanChatMembers();
		hideIgnoredPlayers = config.hideIgnores();

		hideLocalPlayer = config.hideLocalPlayer();
		hideLocalPlayer2D = config.hideLocalPlayer2D();

		hideNPCs = config.hideNPCs();
		hideNPCs2D = config.hideNPCs2D();

		hidePets = config.hidePets();

		hideAttackers = config.hideAttackers();

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

			final boolean inPvp = client.getVarbitValue(Varbits.PVP_SPEC_ORB) == 1;
			if (inPvp)
			{
				// In PVP we only allow hiding everyone or no one
				return !(drawingUI ? hideOthers2D : hideOthers);
			}

			if (hideAttackers && player.getInteracting() == local)
			{
				return false; // hide
			}

			if (player.isFriend())
			{
				return !hideFriends;
			}
			if (player.isFriendsChatMember())
			{
				return !hideFriendsChatMembers;
			}
			if (player.isClanMember())
			{
				return !hideClanMembers;
			}
			if (client.getIgnoreContainer().findByName(player.getName()) != null)
			{
				return !hideIgnoredPlayers;
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

			if (npc.getInteracting() == client.getLocalPlayer())
			{
				boolean b = hideAttackers;
				// Kludge to make hide attackers only affect 2d or 3d if the 2d or 3d hide is on
				// This allows hiding 2d for all npcs, including attackers.
				if (hideNPCs2D || hideNPCs)
				{
					b &= drawingUI ? hideNPCs2D : hideNPCs;
				}
				return !b;
			}

			return !(drawingUI ? hideNPCs2D : hideNPCs);
		}
		else if (renderable instanceof Projectile)
		{
			return !hideProjectiles;
		}

		return true;
	}
}
