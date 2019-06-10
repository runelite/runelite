/*
 * Copyright (c) 2019, Jacky <liangj97@gmail.com>
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
package net.runelite.client.plugins.inferno;

import java.awt.Color;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;

public class InfernoNPC
{
	public enum Attackstyle
	{
		MAGE("Mage", Color.CYAN),
		RANGE("Range", Color.GREEN),
		MELEE("Melee", Color.WHITE),
		RANDOM("Random", Color.ORANGE);

		@Getter
		private String name = "";

		@Getter
		private Color color;

		Attackstyle(String s, Color c)
		{
			this.name = s;
			this.color = c;
		}
	}

	@Getter
	private NPC npc;

	@Getter
	private String name;

	@Getter
	@Setter
	private Attackstyle attackstyle;

	@Getter
	private int attackTicks;

	@Getter
	private int priority;

	@Getter
	@Setter
	private int ticksTillAttack = -1;

	@Getter
	@Setter
	private boolean attacking = false;

	@Getter
	private int attackAnimation;

	@Getter
	private boolean isMidAttack = false;

	@Getter
	@Setter
	private int distanceToPlayer = 0;

	@Getter
	int textLocHeight;

	public InfernoNPC(NPC npc)
	{
		this.npc = npc;
		textLocHeight = npc.getLogicalHeight() + 40;
		switch (npc.getId())
		{
			case NpcID.JALAKREKKET:
				attackTicks = 4;
				name = "lil mel";
				attackAnimation = 7582;
				attackstyle = Attackstyle.MELEE;
				priority = 7;
				break;

			case NpcID.JALAKREKXIL:
				attackTicks = 4;
				name = "lil range";
				attackAnimation = 7583;
				attackstyle = Attackstyle.RANGE;
				priority = 6;
				break;

			case NpcID.JALAKREKMEJ:
				attackTicks = 4;
				name = "lil mage";
				attackAnimation = 7581;
				attackstyle = Attackstyle.MAGE;
				priority = 5;
				break;

			case NpcID.JALMEJRAH:
				attackTicks = 3;
				name = "bat";
				attackAnimation = 7578;
				attackstyle = Attackstyle.RANGE;
				priority = 4;
				break;

			case NpcID.JALAK:
				attackTicks = 6;
				name = "blob";
				attackAnimation = 7583; // also 7581
				attackstyle = Attackstyle.RANDOM;
				priority = 3;
				break;

			case NpcID.JALIMKOT:
				attackTicks = 4;
				name = "meleer";
				attackAnimation = 7597;
				attackstyle = Attackstyle.MELEE;
				priority = 2;
				break;

			case NpcID.JALXIL:
				attackTicks = 4;
				name = "ranger";
				attackAnimation = 7605;
				attackstyle = Attackstyle.RANGE;
				priority = 1;
				break;

			case NpcID.JALZEK:
				attackTicks = 4;
				name = "mager";
				attackAnimation = 7610;
				attackstyle = Attackstyle.MAGE;
				priority = 0;
				break;

			default:
				attackTicks = 0;
		}
	}

	public String info()
	{
		String info = "";

		if (attacking)
		{
			info += ticksTillAttack;
		}
		//info += " D: " + distanceToPlayer;

		return info;
	}

	public void attacked()
	{
		ticksTillAttack = attackTicks;
		attacking = true;
	}
}
