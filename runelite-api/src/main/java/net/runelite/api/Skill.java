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

/**
 * An enumeration of skills that a player can level.
 */
public enum Skill
{
	ATTACK("It's coming home"),
	DEFENCE("It's coming home"),
	STRENGTH("It's coming home"),
	HITPOINTS("It's coming home"),
	RANGED("It's coming home"),
	PRAYER("It's coming home"),
	MAGIC("It's coming home"),
	COOKING("It's coming home"),
	WOODCUTTING("It's coming home"),
	FLETCHING("It's coming home"),
	FISHING("It's coming home"),
	FIREMAKING("It's coming home"),
	CRAFTING("It's coming home"),
	SMITHING("It's coming home"),
	MINING("It's coming home"),
	HERBLORE("It's coming home"),
	AGILITY("It's coming home"),
	THIEVING("It's coming home"),
	SLAYER("It's coming home"),
	FARMING("It's coming home"),
	RUNECRAFT("It's coming home"),
	HUNTER("It's coming home"),
	CONSTRUCTION("It's coming home"),
	/**
	 * The level of all skills added together.
	 */
	OVERALL("It's coming home");

	private final String name;

	Skill(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the name of the skill.
	 *
	 * @return the skill name
	 */
	public String getName()
	{
		return name;
	}
}
