/*
 * Copyright (c) 2019, GeChallengeM <https://github.com/GeChallengeM>
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
package net.runelite.client.plugins.npcstatus;

import java.awt.Color;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.Actor;

@Getter
class MemorizedNPC
{
	private NPC npc;
	private int npcIndex;
	private String npcName;
	private int attackSpeed;
	@Setter(AccessLevel.PACKAGE)
	private int combatTimerEnd;
	@Setter(AccessLevel.PACKAGE)
	private int timeLeft;
	@Setter(AccessLevel.PACKAGE)
	private int flinchTimerEnd;
	@Setter(AccessLevel.PACKAGE)
	private Status status;
	@Setter(AccessLevel.PACKAGE)
	private WorldArea lastnpcarea;
	@Setter(AccessLevel.PACKAGE)
	private Actor lastinteracted;

	MemorizedNPC(final NPC npc, final int attackSpeed, final WorldArea worldArea)
	{
		this.npc = npc;
		this.npcIndex = npc.getIndex();
		this.npcName = npc.getName();
		this.attackSpeed = attackSpeed;
		this.combatTimerEnd = -1;
		this.flinchTimerEnd = -1;
		this.timeLeft = 0;
		this.status = Status.OUT_OF_COMBAT;
		this.lastnpcarea = worldArea;
		this.lastinteracted = null;
	}

	@Getter(AccessLevel.PACKAGE)
	@AllArgsConstructor
	enum Status
	{
		FLINCHING("Flinching", Color.GREEN),
		IN_COMBAT_DELAY("In Combat Delay", Color.ORANGE),
		IN_COMBAT("In Combat", Color.RED),
		OUT_OF_COMBAT("Out of Combat", Color.BLUE);

		private String name;
		private Color color;
	}
}