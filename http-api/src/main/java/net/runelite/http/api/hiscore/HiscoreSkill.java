/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.api.hiscore;

public enum HiscoreSkill
{
	OVERALL("Overall"),
	ATTACK("Attack", true),
	DEFENCE("Defence", true),
	STRENGTH("Strength", true),
	HITPOINTS("Hitpoints", true),
	RANGED("Ranged", true),
	PRAYER("Prayer", true),
	MAGIC("Magic", true),
	COOKING("Cooking", true),
	WOODCUTTING("Woodcutting", true),
	FLETCHING("Fletching", true),
	FISHING("Fishing", true),
	FIREMAKING("Firemaking", true),
	CRAFTING("Crafting", true),
	SMITHING("Smithing", true),
	MINING("Mining", true),
	HERBLORE("Herblore", true),
	AGILITY("Agility", true),
	THIEVING("Thieving", true),
	SLAYER("Slayer", true),
	FARMING("Farming", true),
	RUNECRAFT("Runecraft", true),
	HUNTER("Hunter", true),
	CONSTRUCTION("Construction", true),
	CLUE_SCROLL_EASY("Clue Scrolls (easy)"),
	CLUE_SCROLL_MEDIUM("Clue Scrolls (medium)"),
	CLUE_SCROLL_ALL("Clue Scrolls (all)"),
	BOUNTY_HUNTER_ROGUE("Bounty Hunter - Rogue"),
	BOUNTY_HUNTER_HUNTER("Bounty Hunter - Hunter"),
	CLUE_SCROLL_HARD("Clue Scrolls (hard)"),
	LAST_MAN_STANDING("Last Man Standing"),
	CLUE_SCROLL_ELITE("Clue Scrolls (elite)"),
	CLUE_SCROLL_MASTER("Clue Scrolls (master)");

	private final String name;
	private final boolean virtualLevels;

	HiscoreSkill(String name)
	{
		this(name, false);
	}

	HiscoreSkill(String name, boolean virtualLevels)
	{
		this.name = name;
		this.virtualLevels = virtualLevels;
	}

	public String getName()
	{
		return name;
	}

	public boolean hasVirtualLevels()
	{
		return virtualLevels;
	}
}
