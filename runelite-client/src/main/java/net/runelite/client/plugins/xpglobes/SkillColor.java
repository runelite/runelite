/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.xpglobes;

import java.awt.Color;

public enum SkillColor
{
	ATTACK(105, 32, 7),
	DEFENCE(98, 119, 190),
	STRENGTH(4, 149, 90),
	HITPOINTS(164, 162, 149),
	RANGED(109, 144, 23),
	PRAYER(240, 229, 46),
	MAGIC(50, 80, 193),
	COOKING(112, 35, 134),
	WOODCUTTING(52, 140, 37),
	FLETCHING(3, 121, 125),
	FISHING(116, 142, 174),
	FIREMAKING(209, 130, 18),
	CRAFTING(151, 110, 77),
	SMITHING(108, 107, 82),
	MINING(82, 138, 161),
	HERBLORE(2, 143, 7),
	AGILITY(48, 50, 127),
	THIEVING(108, 52, 87),
	SLAYER(18, 18, 18),
	FARMING(109, 170, 43),
	RUNECRAFT(180, 151, 36),
	HUNTER(92, 89, 65),
	CONSTRUCTION(160, 146, 125);

	private final Color color;

	SkillColor(int red, int green, int blue)
	{
		this.color = new Color(red, green, blue);
	}

	public Color getColor()
	{
		return color;
	}
}