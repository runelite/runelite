/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2019 Im2be <https://github.com/Im2be>
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

package net.runelite.client.plugins.cerberus.domain;

import com.google.common.collect.ImmutableMap;
import java.awt.Color;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Skill;

@Getter
@RequiredArgsConstructor
public enum Ghost
{
	RANGE(NpcID.SUMMONED_SOUL, Skill.RANGED, Color.GREEN),
	MAGE(NpcID.SUMMONED_SOUL_5868, Skill.MAGIC, Color.BLUE),
	MELEE(NpcID.SUMMONED_SOUL_5869, Skill.ATTACK, Color.RED);

	private static final Map<Integer, Ghost> MAP;

	static
	{
		final ImmutableMap.Builder<Integer, Ghost> builder = new ImmutableMap.Builder<>();

		for (final Ghost ghost : values())
		{
			builder.put(ghost.getNpcId(), ghost);
		}

		MAP = builder.build();
	}

	private final int npcId;
	private final Skill type;
	private final Color color;

	/**
	 * Try to identify if NPC is ghost
	 *
	 * @param npc npc
	 * @return optional ghost
	 */
	@Nullable
	public static Ghost fromNPC(final NPC npc)
	{
		return MAP.get(npc.getId());
	}
}
