/*
 * Copyright (c) 2022, Jordan Atwood <nightfirecat@nightfirec.at>
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
package net.runelite.client.game;

import net.runelite.api.NPC;
import net.runelite.api.NpcID;

public class NpcUtil
{
	/**
	 * Returns whether an NPC is dying and can no longer be interacted with, or if it is still alive or in some special
	 * state where it can be 0hp without dying. (For example, Gargoyles and other slayer monsters with item weaknesses
	 * are not killed by reaching 0hp, so would not be dead based on that alone.)
	 *
	 * @param npc NPC to check whether it is dying
	 * @return {@code true} if the NPC is dying
	 */
	public static boolean isDying(final NPC npc)
	{
		final int id = npc.getId();
		switch (id)
		{
			// These NPCs hit 0hp but don't actually die
			case NpcID.GARGOYLE:
			case NpcID.GARGOYLE_413:
			case NpcID.GARGOYLE_1543:
			case NpcID.MARBLE_GARGOYLE:
			case NpcID.MARBLE_GARGOYLE_7408:
			case NpcID.DAWN:
			case NpcID.DAWN_7852:
			case NpcID.DAWN_7853:
			case NpcID.DAWN_7884:
			case NpcID.DAWN_7885:
			case NpcID.DUSK:
			case NpcID.DUSK_7851:
			case NpcID.DUSK_7854:
			case NpcID.DUSK_7855:
			case NpcID.DUSK_7882:
			case NpcID.DUSK_7883:
			case NpcID.DUSK_7886:
			case NpcID.DUSK_7887:
			case NpcID.DUSK_7888:
			case NpcID.DUSK_7889:
			case NpcID.ZYGOMITE:
			case NpcID.ZYGOMITE_1024:
			case NpcID.ANCIENT_ZYGOMITE:
			case NpcID.ROCKSLUG:
			case NpcID.ROCKSLUG_422:
			case NpcID.DESERT_LIZARD:
			case NpcID.DESERT_LIZARD_460:
			case NpcID.DESERT_LIZARD_461:
			case NpcID.GROWTHLING:
			case NpcID.KALPHITE_QUEEN_963:
			case NpcID.KALPHITE_QUEEN_965:
			case NpcID.VETION:
			case NpcID.VETION_REBORN:
			case NpcID.PHOSANIS_NIGHTMARE:
			case NpcID.PHOSANIS_NIGHTMARE_9416:
			case NpcID.PHOSANIS_NIGHTMARE_9417:
			case NpcID.PHOSANIS_NIGHTMARE_9418:
			case NpcID.PHOSANIS_NIGHTMARE_9419:
			case NpcID.PHOSANIS_NIGHTMARE_9420:
			case NpcID.PHOSANIS_NIGHTMARE_9421:
			case NpcID.PHOSANIS_NIGHTMARE_9422:
			case NpcID.PHOSANIS_NIGHTMARE_9423:
			case NpcID.PHOSANIS_NIGHTMARE_11153:
			case NpcID.PHOSANIS_NIGHTMARE_11154:
			case NpcID.PHOSANIS_NIGHTMARE_11155:
			case NpcID.THE_NIGHTMARE:
			case NpcID.THE_NIGHTMARE_9425:
			case NpcID.THE_NIGHTMARE_9426:
			case NpcID.THE_NIGHTMARE_9427:
			case NpcID.THE_NIGHTMARE_9428:
			case NpcID.THE_NIGHTMARE_9429:
			case NpcID.THE_NIGHTMARE_9430:
			case NpcID.THE_NIGHTMARE_9431:
			case NpcID.THE_NIGHTMARE_9432:
			case NpcID.THE_NIGHTMARE_9433:
			case NpcID.THE_NIGHTMARE_9460:
			case NpcID.THE_NIGHTMARE_9461:
			case NpcID.THE_NIGHTMARE_9462:
			case NpcID.THE_NIGHTMARE_9463:
			case NpcID.THE_NIGHTMARE_9464:
				return false;
			default:
				return npc.isDead();
		}
	}
}
