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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * An enumeration of skills that a player can level.
 */
@Getter
@AllArgsConstructor
public enum Skill
{
	ATTACK("Attack", false),
	DEFENCE("Defence", false),
	STRENGTH("Strength", false),
	HITPOINTS("Hitpoints", false),
	RANGED("Ranged", false),
	PRAYER("Prayer", false),
	MAGIC("Magic", false),
	COOKING("Cooking", false),
	WOODCUTTING("Woodcutting", false),
	FLETCHING("Fletching", true),
	FISHING("Fishing", false),
	FIREMAKING("Firemaking", false),
	CRAFTING("Crafting", false),
	SMITHING("Smithing", false),
	MINING("Mining", false),
	HERBLORE("Herblore", true),
	AGILITY("Agility", true),
	THIEVING("Thieving", true),
	SLAYER("Slayer", true),
	FARMING("Farming", true),
	RUNECRAFT("Runecraft", false),
	HUNTER("Hunter", true),
	CONSTRUCTION("Construction", true),
	/**
	 * The level of all skills added together.
	 */
	OVERALL("Overall", false);

	private final String name;
	private final boolean membersOnly;
}
