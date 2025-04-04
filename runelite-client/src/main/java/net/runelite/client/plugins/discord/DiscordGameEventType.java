/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, PandahRS <https://github.com/PandahRS>
 * Copyright (c) 2020, Brooklyn <https://github.com/Broooklyn>
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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.GameArea;
import net.runelite.client.game.GameArea.RegionArea;
import net.runelite.client.game.GameAreaType;

@AllArgsConstructor
@Getter
enum DiscordGameEventType
{

	IN_MENU("In Menu", -3, true, true, true, false),
	IN_GAME("In Game", -3, true, false, false, false),
	PLAYING_DEADMAN("Playing Deadman Mode", -3),
	PLAYING_PVP("Playing in a PVP world", -3),
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
	TRAINING_FISHING(Skill.FISHING, 1),
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
	TRAINING_CONSTRUCTION(Skill.CONSTRUCTION),
	;

	@Value
	@VisibleForTesting
	static class DiscordEventArea
	{
		private final GameArea gameArea;
		@Nullable
		private final WorldArea area;
	}

	@VisibleForTesting
	static final Multimap<Integer, DiscordEventArea> FROM_POINT;

	static
	{
		ImmutableMultimap.Builder<Integer, DiscordEventArea> pointMapBuilder = new ImmutableMultimap.Builder<>();
		for (GameArea gameArea : GameArea.values())
		{
			if (gameArea.getRegionAreas() == null)
			{
				continue;
			}

			for (RegionArea regionArea : gameArea.getRegionAreas())
			{
				pointMapBuilder.put(regionArea.getRegion(), new DiscordEventArea(gameArea, regionArea.getArea()));
			}
		}
		FROM_POINT = pointMapBuilder.build();
	}

	@Nullable
	private String imageKey;

	@Nullable
	private String state;

	@Nullable
	private String details;

	private int priority;

	/**
	 * Determines if event should clear other clearable events when triggered
	 */
	private boolean shouldClear;

	/**
	 * Determines if event should be processed when it timeouts based on action timeout
	 */
	private boolean shouldTimeout;

	/**
	 * Determines if event start time should be reset when processed
	 */
	private boolean shouldRestart;

	/**
	 * Determines if event should be cleared when processed
	 */
	private boolean shouldBeCleared = true;

	@Nullable
	private GameAreaType gameAreaType;

	@Nullable
	private List<RegionArea> regionAreas;

	DiscordGameEventType(Skill skill)
	{
		this(skill, 0);
	}

	DiscordGameEventType(Skill skill, int priority)
	{
		this.details = training(skill);
		this.priority = priority;
		this.imageKey = imageKeyOf(skill);
		this.shouldTimeout = true;
	}

	DiscordGameEventType(String state, int priority, boolean shouldClear, boolean shouldTimeout, boolean shouldRestart, boolean shouldBeCleared)
	{
		this.state = state;
		this.priority = priority;
		this.shouldClear = shouldClear;
		this.shouldTimeout = shouldTimeout;
		this.shouldRestart = shouldRestart;
		this.shouldBeCleared = shouldBeCleared;
	}

	DiscordGameEventType(String state, int priority)
	{
		this(state, priority, true, false, false, true);
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

	public static GameArea fromPoint(final WorldPoint worldPoint)
	{
		GameArea fullRegionArea = null;
		for (DiscordEventArea area : FROM_POINT.get(worldPoint.getRegionID()))
		{
			if (area.getArea() == null)
			{
				fullRegionArea = area.getGameArea();
			}
			else
			{
				if (area.getArea().contains2D(worldPoint))
				{
					return area.getGameArea();
				}
			}
		}
		return fullRegionArea;
	}
}
