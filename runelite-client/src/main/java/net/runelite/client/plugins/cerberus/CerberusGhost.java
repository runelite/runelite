/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.cerberus;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Skill;

@Getter(AccessLevel.PACKAGE)
@RequiredArgsConstructor
public enum CerberusGhost
{
	RANGE(NpcID.SUMMONED_SOUL, Skill.RANGED),
	MAGE(NpcID.SUMMONED_SOUL_5868, Skill.MAGIC),
	MELEE(NpcID.SUMMONED_SOUL_5869, Skill.ATTACK);

	private final int npcId;
	private final Skill type;

	private static final Map<Integer, CerberusGhost> MAP;

	static
	{
		ImmutableMap.Builder<Integer, CerberusGhost> builder = new ImmutableMap.Builder<>();

		for (final CerberusGhost ghost : values())
		{
			builder.put(ghost.getNpcId(), ghost);
		}

		MAP = builder.build();
	}

	/**
	 * Try to identify if NPC is ghost
	 *
	 * @param npc npc
	 * @return optional ghost
	 */
	public static Optional<CerberusGhost> fromNPC(final NPC npc)
	{
		return npc == null ? Optional.empty() : Optional.ofNullable(MAP.get(npc.getId()));
	}
}
