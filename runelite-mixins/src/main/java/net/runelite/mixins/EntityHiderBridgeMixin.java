/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
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
package net.runelite.mixins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSClient;

@Mixin(RSClient.class)
public abstract class EntityHiderBridgeMixin implements RSClient
{
	@Inject
	public static boolean isHidingEntities;

	@Inject
	public static boolean hidePlayers;

	@Inject
	public static boolean hidePlayers2D;

	@Inject
	public static boolean hideFriends;

	@Inject
	public static boolean hideClanMates;

	@Inject
	public static boolean hideLocalPlayer;

	@Inject
	public static boolean hideLocalPlayer2D;

	@Inject
	public static boolean hideNPCs;

	@Inject
	public static boolean hideNPCs2D;

	@Inject
	public static boolean hideAttackers;

	@Inject
	public static boolean hideProjectiles;

	@Inject
	public static boolean hideDeadNPCs;

	@Inject
	public static HashMap<String, Integer> hiddenNpcsName = new HashMap<>();

	@Inject
	public static HashMap<String, Integer> hiddenNpcsDeath = new HashMap<>();

	@Inject
	public static List<String> hideSpecificPlayers = new ArrayList<>();

	@Inject
	@Override
	public void setIsHidingEntities(boolean state)
	{
		isHidingEntities = state;
	}

	@Inject
	@Override
	public void setPlayersHidden(boolean state)
	{
		hidePlayers = state;
	}

	@Inject
	@Override
	public void setPlayersHidden2D(boolean state)
	{
		hidePlayers2D = state;
	}

	@Inject
	@Override
	public void setFriendsHidden(boolean state)
	{
		hideFriends = state;
	}

	@Inject
	@Override
	public void setClanMatesHidden(boolean state)
	{
		hideClanMates = state;
	}

	@Inject
	@Override
	public void setLocalPlayerHidden(boolean state)
	{
		hideLocalPlayer = state;
	}

	@Inject
	@Override
	public void setLocalPlayerHidden2D(boolean state)
	{
		hideLocalPlayer2D = state;
	}

	@Inject
	@Override
	public void setNPCsHidden(boolean state)
	{
		hideNPCs = state;
	}

	@Inject
	@Override
	public void setNPCsHidden2D(boolean state)
	{
		hideNPCs2D = state;
	}

	@Inject
	@Override
	public void addHiddenNpcName(String npc)
	{
		npc = npc.toLowerCase();
		int i = hiddenNpcsName.getOrDefault(npc, 0);
		if (i == Integer.MAX_VALUE)
		{
			throw new RuntimeException("NPC name " + npc + " has been hidden Integer.MAX_VALUE times, is something wrong?");
		}

		hiddenNpcsName.put(npc, ++i);
	}

	@Inject
	@Override
	public void removeHiddenNpcName(String npc)
	{
		npc = npc.toLowerCase();
		int i = hiddenNpcsName.getOrDefault(npc, 0);
		if (i == 0)
		{
			return;
		}

		hiddenNpcsName.put(npc, --i);
	}

	@Inject
	@Override
	public void forciblyUnhideNpcName(String npc)
	{
		npc = npc.toLowerCase();
		hiddenNpcsName.put(npc, 0);
	}

	@Inject
	@Override
	public void addHiddenNpcDeath(String npc)
	{
		npc = npc.toLowerCase();
		int i = hiddenNpcsDeath.getOrDefault(npc, 0);
		if (i == Integer.MAX_VALUE)
		{
			throw new RuntimeException("NPC death " + npc + " has been hidden Integer.MAX_VALUE times, is something wrong?");
		}

		hiddenNpcsDeath.put(npc, ++i);
	}

	@Inject
	@Override
	public void removeHiddenNpcDeath(String npc)
	{
		npc = npc.toLowerCase();
		int i = hiddenNpcsDeath.getOrDefault(npc, 0);
		if (i == 0)
		{
			return;
		}

		hiddenNpcsDeath.put(npc, --i);
	}

	@Inject
	@Override
	public void forciblyUnhideNpcDeath(String npc)
	{
		npc = npc.toLowerCase();
		hiddenNpcsDeath.put(npc, 0);
	}

	@Inject
	@Override
	public void setHideSpecificPlayers(List<String> players)
	{
		hideSpecificPlayers = players;
	}

	@Inject
	@Override
	public void setAttackersHidden(boolean state)
	{
		hideAttackers = state;
	}

	@Inject
	@Override
	public void setProjectilesHidden(boolean state)
	{
		hideProjectiles = state;
	}

	@Inject
	@Override
	public void setDeadNPCsHidden(boolean state)
	{
		hideDeadNPCs = state;
	}
}
