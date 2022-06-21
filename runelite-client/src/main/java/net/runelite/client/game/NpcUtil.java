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

import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.NpcID;
import net.runelite.client.RuntimeConfig;
import org.apache.commons.lang3.ArrayUtils;

@Singleton
public class NpcUtil
{
	private final RuntimeConfig runtimeConfig;

	@Inject
	private NpcUtil(@Nullable RuntimeConfig runtimeConfig)
	{
		this.runtimeConfig = runtimeConfig;
	}

	/**
	 * Returns whether an NPC is dying and can no longer be interacted with, or if it is still alive or in some special
	 * state where it can be 0hp without dying. (For example, Gargoyles and other slayer monsters with item weaknesses
	 * are not killed by reaching 0hp, so would not be dead based on that alone.)
	 *
	 * @param npc NPC to check whether it is dying
	 * @return {@code true} if the NPC is dying
	 */
	public boolean isDying(final NPC npc)
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
			case NpcID.GIANT_ROCKSLUG:
			case NpcID.DESERT_LIZARD:
			case NpcID.DESERT_LIZARD_460:
			case NpcID.DESERT_LIZARD_461:
			case NpcID.LIZARD:
			case NpcID.SMALL_LIZARD:
			case NpcID.SMALL_LIZARD_463:
			case NpcID.GROWTHLING:
			case NpcID.KALPHITE_QUEEN_963: // KQ's first form sometimes regenerates 1hp after reaching 0hp, thus not dying
				return false;
			default:
				if (runtimeConfig != null)
				{
					Set<Integer> ignoredNpcs = runtimeConfig.getIgnoreDeadNpcs();
					if (ignoredNpcs != null && ignoredNpcs.contains(id))
					{
						return false;
					}
				}

				final NPCComposition npcComposition = npc.getTransformedComposition();
				boolean hasAttack = npcComposition != null && ArrayUtils.contains(npcComposition.getActions(), "Attack");
				return hasAttack && npc.isDead();
		}
	}
}
