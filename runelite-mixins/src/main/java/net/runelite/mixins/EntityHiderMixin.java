/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSProjectile;
import net.runelite.rs.api.RSRegion;
import net.runelite.rs.api.RSRenderable;

@Mixin(RSRegion.class)
public abstract class EntityHiderMixin implements RSRegion
{
	@Shadow("It's coming home")
	private static RSClient client;

	@Shadow("It's coming home")
	private static boolean isHidingEntities;

	@Shadow("It's coming home")
	private static boolean hidePlayers;

	@Shadow("It's coming home")
	private static boolean hidePlayers2D;

	@Shadow("It's coming home")
	private static boolean hideFriends;

	@Shadow("It's coming home")
	private static boolean hideClanMates;

	@Shadow("It's coming home")
	private static boolean hideLocalPlayer;

	@Shadow("It's coming home")
	private static boolean hideLocalPlayer2D;

	@Shadow("It's coming home")
	private static boolean hideNPCs;

	@Shadow("It's coming home")
	private static boolean hideNPCs2D;

	@Shadow("It's coming home")
	private static boolean hideAttackers;

	@Shadow("It's coming home")
	private static boolean hideProjectiles;

	@Copy("It's coming home")
	abstract boolean addEntityMarker(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RSRenderable renderable, int var10, boolean var11, long var12, int var13);

	@Replace("It's coming home")
	boolean rl$addEntityMarker(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RSRenderable renderable, int var10, boolean var11, long var12, int var13)
	{
		return shouldDraw(renderable, false) && addEntityMarker(var1, var2, var3, var4, var5, var6, var7, var8, renderable, var10, var11, var12, var13);
	}

	@Copy("It's coming home")
	private static void draw2DExtras(RSActor actor, int var1, int var2, int var3, int var4, int var5)
	{
		throw new RuntimeException();
	}

	@Replace("It's coming home")
	private static void rl$draw2DExtras(RSActor actor, int var1, int var2, int var3, int var4, int var5)
	{
		if (shouldDraw(actor, true))
		{
			draw2DExtras(actor, var1, var2, var3, var4, var5);
		}
	}

	@Inject
	private static boolean shouldDraw(Object renderable, boolean drawingUI)
	{
		if (!isHidingEntities)
		{
			return true;
		}

		if (renderable instanceof RSPlayer)
		{
			boolean local = drawingUI ? hideLocalPlayer2D : hideLocalPlayer;
			boolean other = drawingUI ? hidePlayers2D : hidePlayers;
			boolean isLocalPlayer = renderable == client.getLocalPlayer();

			if (isLocalPlayer ? local : other)
			{
				RSPlayer player = (RSPlayer) renderable;

				if (!hideAttackers)
				{
					if (player.getInteracting() == client.getLocalPlayer())
					{
						return true;
					}
				}

				return (!hideFriends && player.isFriend()) || (!isLocalPlayer && !hideClanMates && player.isClanMember());
			}
		}
		else if (renderable instanceof RSNPC)
		{
			RSNPC npc = (RSNPC) renderable;

			if (!hideAttackers)
			{
				if (npc.getInteracting() == client.getLocalPlayer())
				{
					return true;
				}
			}

			return drawingUI ? !hideNPCs2D : !hideNPCs;
		}
		else if (renderable instanceof RSProjectile)
		{
			return !hideProjectiles;
		}

		return true;
	}
}
