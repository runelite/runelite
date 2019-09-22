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

import java.util.HashMap;
import java.util.List;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.util.Text;
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSProjectile;
import net.runelite.rs.api.RSScene;

@Mixin(RSScene.class)
public abstract class EntityHiderMixin implements RSScene
{
	@Shadow("client")
	private static RSClient client;

	@Shadow("isHidingEntities")
	private static boolean isHidingEntities;

	@Shadow("hidePlayers")
	private static boolean hidePlayers;

	@Shadow("hidePlayers2D")
	private static boolean hidePlayers2D;

	@Shadow("hideFriends")
	private static boolean hideFriends;

	@Shadow("hideClanMates")
	private static boolean hideClanMates;

	@Shadow("hideLocalPlayer")
	private static boolean hideLocalPlayer;

	@Shadow("hideLocalPlayer2D")
	private static boolean hideLocalPlayer2D;

	@Shadow("hideNPCs")
	private static boolean hideNPCs;

	@Shadow("hiddenNpcsName")
	private static HashMap<String, Integer> hiddenNpcsName;

	@Shadow("hiddenNpcsDeath")
	private static HashMap<String, Integer> hiddenNpcsDeath;

	@Shadow("hideSpecificPlayers")
	private static List<String> hideSpecificPlayers;

	@Shadow("hideNPCs2D")
	private static boolean hideNPCs2D;

	@Shadow("hideAttackers")
	private static boolean hideAttackers;

	@Shadow("hideProjectiles")
	private static boolean hideProjectiles;

	@Shadow("hideDeadNPCs")
	private static boolean hideDeadNPCs;

	@Copy("newGameObject")
	abstract boolean addEntityMarker(int var1, int var2, int var3, int var4, int var5, int x, int y, int var8, RSEntity entity, int var10, boolean var11, long var12, int var13);

	@Replace("newGameObject")
	boolean rl$addEntityMarker(int var1, int var2, int var3, int var4, int var5, int x, int y, int var8, RSEntity entity, int var10, boolean var11, long var12, int var13)
	{
		final boolean shouldDraw = shouldDraw(entity, false);

		if (!shouldDraw)
		{
			final int tileX = x >> 7;
			final int tileY = y >> 7;
			/*
			 * Set the 'occupied' tick to -1, to reset the tile being 'occupied',
			 * making the game think an entity hasn't been rendered at the location yet.
			 */
			client.getOccupiedTilesTick()[tileX][tileY] = -1;
		}

		return shouldDraw &&
			addEntityMarker(var1, var2, var3, var4, var5, x, y, var8, entity, var10, var11, var12, var13);
	}

	@Copy("drawActor2d")
	private static void draw2DExtras(RSActor actor, int var1, int var2, int var3, int var4, int var5)
	{
		throw new RuntimeException();
	}

	@Replace("drawActor2d")
	private static void rl$draw2DExtras(RSActor actor, int var1, int var2, int var3, int var4, int var5)
	{
		if (shouldDraw(actor, true))
		{
			draw2DExtras(actor, var1, var2, var3, var4, var5);
		}
	}

	@Inject
	private static boolean shouldDraw(Object entity, boolean drawingUI)
	{
		if (!isHidingEntities)
		{
			return true;
		}

		if (entity instanceof RSPlayer)
		{
			boolean local = drawingUI ? hideLocalPlayer2D : hideLocalPlayer;
			boolean other = drawingUI ? hidePlayers2D : hidePlayers;
			boolean isLocalPlayer = entity == client.getLocalPlayer();
			RSPlayer player = (RSPlayer) entity;

			for (String name : hideSpecificPlayers)
			{
				if (name != null && !name.equals(""))
				{
					if (player.getName() != null && player.getName().equalsIgnoreCase(name))
					{
						return false;
					}
				}
			}

			if (isLocalPlayer ? local : other)
			{
				if (!hideAttackers)
				{
					if (player.getInteracting() == client.getLocalPlayer())
					{
						return true;
					}
				}

				if (player.getName() == null)
				{
					// player.isFriend() and player.isClanMember() npe when the player has a null name
					return false;
				}

				return (!hideFriends && player.isFriend()) ||
					(!isLocalPlayer && !hideClanMates && player.isClanMember());
			}
		}
		else if (entity instanceof RSNPC)
		{
			RSNPC npc = (RSNPC) entity;

			if (!hideAttackers)
			{
				if (npc.getInteracting() == client.getLocalPlayer())
				{
					return true;
				}
			}

			if (hideDeadNPCs && npc.getHealthRatio() == 0)
			{
				return false;
			}

			if (npc.getName() != null &&
				hiddenNpcsName.getOrDefault(Text.standardize(npc.getName().toLowerCase()), 0) > 0)
			{
				return false;
			}

			if (npc.getName() != null && npc.getHealthRatio() == 0 &&
				hiddenNpcsDeath.getOrDefault(Text.standardize(npc.getName().toLowerCase()), 0) > 0)
			{
				return false;
			}

			return drawingUI ? !hideNPCs2D : !hideNPCs;
		}
		else if (entity instanceof RSProjectile)
		{
			return !hideProjectiles;
		}

		return true;
	}
}
