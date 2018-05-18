/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, PandahRS <https://github.com/PandahRS>
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
package net.runelite.client.plugins.discord;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

@AllArgsConstructor
@Getter
enum DiscordGameEventType
{

	IN_GAME("In Game", -3),
	IN_MENU("In Menu", -3),
	TRAINING_ATTACK(Skill.ATTACK),
	TRAINING_DEFENCE(Skill.DEFENCE),
	TRAINING_STRENGTH(Skill.STRENGTH),
	TRAINING_HITPOINTS(Skill.HITPOINTS, -1),
	TRAINING_SLAYER(Skill.SLAYER, 1),
	TRAINING_RANGED(Skill.RANGED),
	TRAINING_MAGIC(Skill.MAGIC),
	TRAINING_PRAYER(Skill.PRAYER),
	TRAINING_COOKING(Skill.COOKING),
	TRAINING_WOODCUTTING(Skill.WOODCUTTING),
	TRAINING_FLETCHING(Skill.FLETCHING),
	TRAINING_FISHING(Skill.FISHING),
	TRAINING_FIREMAKING(Skill.FIREMAKING),
	TRAINING_CRAFTING(Skill.CRAFTING),
	TRAINING_SMITHING(Skill.SMITHING),
	TRAINING_MINING(Skill.MINING),
	TRAINING_HERBLORE(Skill.HERBLORE),
	TRAINING_AGILITY(Skill.AGILITY),
	TRAINING_THIEVING(Skill.THIEVING),
	TRAINING_FARMING(Skill.FARMING),
	TRAINING_RUNECRAFT(Skill.RUNECRAFT),
	TRAINING_HUNTER(Skill.HUNTER),
	TRAINING_CONSTRUCTION(Skill.CONSTRUCTION);

	private static final Map<Integer, DiscordGameEventType> FROM_REGION = new HashMap<>();

	static
	{
		for (DiscordGameEventType discordGameEventType : DiscordGameEventType.values())
		{
			if (discordGameEventType.getRegionIds() == null)
			{
				continue;
			}

			for (int region : discordGameEventType.getRegionIds())
			{
				assert !FROM_REGION.containsKey(region);
				FROM_REGION.put(region, discordGameEventType);
			}
		}
	}

	private String imageKey;
	private String state;
	private String details;
	private int priority;
	private boolean shouldClear;
	private boolean shouldTimeout;

	private DiscordAreaType discordAreaType;
	private int[] regionIds;

	DiscordGameEventType(Skill skill)
	{
		this(skill, 0);
	}

	DiscordGameEventType(Skill skill, int priority)
	{
		this.state = training(skill);
		this.priority = priority;
		this.imageKey = imageKeyOf(skill);
		this.priority = priority;
		this.shouldTimeout = true;
	}

	DiscordGameEventType(String areaName, DiscordAreaType areaType, int... regionIds)
	{
		this.details = exploring(areaType, areaName);
		this.priority = -2;
		this.discordAreaType = areaType;
		this.regionIds = regionIds;
		this.shouldClear = true;
	}

	DiscordGameEventType(String state, int priority)
	{
		this.details = state;
		this.priority = priority;
		this.shouldClear = true;
	}

	private static String training(final Skill skill)
	{
		return training(skill.getName());
	}

	private static String training(final String what)
	{
		return "Training: " + what;
	}

	private static String imageKeyOf(final Skill skill)
	{
		return imageKeyOf(skill.getName().toLowerCase());
	}

	private static String imageKeyOf(final String what)
	{
		return "icon_" + what;
	}

	private static String exploring(DiscordAreaType areaType, String areaName)
	{
		switch (areaType)
		{
			case BOSSES:
				return "Fighting: " + areaName;
			case DUNGEONS:
				return "Exploring: " + areaName;
			case CITIES:
				return "Location: " + areaName;
			case MINIGAMES:
				return "Playing: " + areaName;
		}

		return "";
	}

	public static DiscordGameEventType fromSkill(final Skill skill)
	{
		switch (skill)
		{
			case ATTACK: return TRAINING_ATTACK;
			case DEFENCE: return TRAINING_DEFENCE;
			case STRENGTH: return TRAINING_STRENGTH;
			case RANGED: return TRAINING_RANGED;
			case PRAYER: return TRAINING_PRAYER;
			case MAGIC: return TRAINING_MAGIC;
			case COOKING: return TRAINING_COOKING;
			case WOODCUTTING: return TRAINING_WOODCUTTING;
			case FLETCHING: return TRAINING_FLETCHING;
			case FISHING: return TRAINING_FISHING;
			case FIREMAKING: return TRAINING_FIREMAKING;
			case CRAFTING: return TRAINING_CRAFTING;
			case SMITHING: return TRAINING_SMITHING;
			case MINING: return TRAINING_MINING;
			case HERBLORE: return TRAINING_HERBLORE;
			case AGILITY: return TRAINING_AGILITY;
			case THIEVING: return TRAINING_THIEVING;
			case SLAYER: return TRAINING_SLAYER;
			case FARMING: return TRAINING_FARMING;
			case RUNECRAFT: return TRAINING_RUNECRAFT;
			case HUNTER: return TRAINING_HUNTER;
			case CONSTRUCTION: return TRAINING_CONSTRUCTION;
			default: return null;
		}
	}

	public static DiscordGameEventType fromRegion(final int regionId)
	{
		return FROM_REGION.get(regionId);
	}
}
