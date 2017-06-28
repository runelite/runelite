/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

package net.runelite.api;

import java.awt.Color;

public enum Skill
{
	ATTACK("Attack", new Color(187, 140, 22)),
	DEFENCE("Defence", new Color(157, 144, 123)),
	STRENGTH("Strength", new Color(165, 146, 112)),
	HITPOINTS("Hitpoints", new Color(146, 29, 18)),
	RANGED("Ranged", new Color(90, 113, 28)),
	PRAYER("Prayer", new Color(190, 181, 182)),
	MAGIC("Magic", new Color(9, 13, 101)),
	COOKING("Cooking", new Color(87, 35, 103)),
	WOODCUTTING("Woodcutting", new Color(129, 105, 59)),
	FLETCHING("Fletching", new Color(8, 76, 78)),
	FISHING("Fishing", new Color(100, 126, 149)),
	FIREMAKING("Firemaking", new Color(172, 93, 20)),
	CRAFTING("Crafting", new Color(114, 86, 64)),
	SMITHING("Smithing", new Color(69, 69, 55)),
	MINING("Mining", new Color(70, 70, 57)),
	HERBLORE("Herblore", new Color(10, 86, 10)),
	AGILITY("Agility", new Color(32, 33, 92)),
	THIEVING("Thieving", new Color(110, 61, 93)),
	SLAYER("Slayer", new Color(174, 168, 163)),
	FARMING("Farming", new Color(34, 77, 37)),
	RUNECRAFT("Runecraft", new Color(207, 134, 54)),
	HUNTER("Hunter", new Color(93, 88, 62)),
	CONSTRUCTION("Construction", new Color(133, 124, 106)),
	OVERALL("Overall", new Color(133, 41, 33));

	private final String name;
	private final Color color;
	Skill(String name, Color color)
	{
		this.name = name;
		this.color = color;
	}

	public String getName()
	{
		return name;
	}

	public Color getColor()
	{
		return color;
	}
}
