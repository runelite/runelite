/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.npchighlight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.coords.WorldPoint;

@Getter(AccessLevel.PACKAGE)
class MemorizedNpc
{
	private int npcIndex;
	private Set<String> npcNames;
	private int npcSize;
	/**
	 * The time the npc died at, in game ticks, relative to the tick counter
	 */
	@Setter(AccessLevel.PACKAGE)
	private int diedOnTick;
	/**
	 * The time it takes for the npc to respawn, in game ticks
	 */
	@Setter(AccessLevel.PACKAGE)
	private int respawnTime;
	@Setter(AccessLevel.PACKAGE)
	private List<WorldPoint> possibleRespawnLocations;

	MemorizedNpc(final NPC npc)
	{
		this.npcNames = new HashSet<>();
		this.npcNames.add(npc.getName());
		this.npcIndex = npc.getIndex();
		this.possibleRespawnLocations = new ArrayList<>();
		this.respawnTime = -1;
		this.diedOnTick = -1;

		final NPCDefinition composition = npc.getTransformedDefinition();

		if (composition != null)
		{
			this.npcSize = composition.getSize();
		}
	}
}