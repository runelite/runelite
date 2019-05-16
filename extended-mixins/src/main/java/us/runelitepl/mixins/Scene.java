/*
 *  Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
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

package us.runelitepl.mixins;

import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSProjectile;
import us.runelitepl.mixinprocessor.annotations.Overwrite;

public class Scene
{
	
	@Overwrite
	public static boolean shouldDraw(Object renderable, boolean drawingUI)
	{
		
		if (!Client.isHidingEntities)
		{
			return true;
		}
		
		if(renderable instanceof RSPlayer)
		{
			RSPlayer p = (RSPlayer) renderable;
			if(Client.hideClanMates && p.isClanMember())
			{
				return false;
			}
		}
		
		if (renderable instanceof RSPlayer)
		{
			boolean local = drawingUI ? Client.hideLocalPlayer2D : Client.hideLocalPlayer;
			boolean other = drawingUI ? Client.hidePlayers2D : Client.hidePlayers;
			boolean isLocalPlayer = renderable == ((RSClient)Client.INSTANCE).getLocalPlayer();
			
			if (isLocalPlayer ? local : other)
			{
				RSPlayer player = (RSPlayer) renderable;
				
				if (!Client.hideAttackers)
				{
					if (player.getInteracting() == ((RSClient)Client.INSTANCE).getLocalPlayer())
					{
						return true;
					}
				}
				
				if (player.getName() == null)
				{
					// player.isFriend() and player.isClanMember() npe when the player has a null name
					return false;
				}
				
				return (!Client.hideFriends && player.isFriend()) || (!isLocalPlayer && !Client.hideClanMates && player.isClanMember());
			}
		}
		else if (renderable instanceof RSNPC)
		{
			RSNPC npc = (RSNPC) renderable;
			
			if (!Client.hideAttackers)
			{
				if (npc.getInteracting() == ((RSClient)Client.INSTANCE).getLocalPlayer())
				{
					return true;
				}
			}
			
			return drawingUI ? !Client.hideNPCs2D : !Client.hideNPCs;
		}
		else if (renderable instanceof RSProjectile)
		{
			return !Client.hideProjectiles;
		}
		
		return true;
	}
	
}
