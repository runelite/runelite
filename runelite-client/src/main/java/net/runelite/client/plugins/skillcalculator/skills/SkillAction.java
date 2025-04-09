/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import java.util.Collections;
import java.util.Set;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.ItemManager;

/**
 * An object representing a single skill action which grants some xp.
 */
public interface SkillAction
{
	/**
	 * Gets the name of this skill action, usually the item or object created, or the spell cast. This name may be
	 * fetched via {@link ItemComposition#getMembersName()} from some defined item ID or explicitly defined.
	 *
	 * @param itemManager An {@link ItemManager item manager} instance.
	 * @return The name of this skill action.
	 */
	String getName(final ItemManager itemManager);

	/**
	 * Gets the level required to perform this skill action.
	 *
	 * @return The level required to perform this skill action.
	 */
	int getLevel();

	/**
	 * Gets the amount of xp granted for performing this skill action.
	 *
	 * @return The amount of xp granted for performing this skill action.
	 */
	float getXp();

	/**
	 * Gets the item icon ID for this skill action, if applicable.
	 * <p>
	 * Note: Either this method or {@link #getSprite()} will always return {@code -1}, and the other will return some
	 * value {@code 0} or greater.
	 *
	 * @return The item icon ID of this skill action, or {@code -1} if its icon should be represented using a sprite.
	 * @see net.runelite.api.gameval.ItemID
	 * @see #getSprite()
	 */
	default int getIcon()
	{
		return -1;
	}

	/**
	 * Gets the sprite ID for this skill action, if applicable.
	 * <p>
	 * Note: Either this method or {@link #getIcon()} will always return {@code -1}, and the other will return some
	 * value {@code 0} or greater.
	 *
	 * @return The sprite ID of this skill action, or {@code -1} if its icon should be represented using an item icon.
	 * @see net.runelite.api.SpriteID
	 * @see #getIcon()
	 */
	default int getSprite()
	{
		return -1;
	}

	/**
	 * Returns {@code true} if this skill action is affected by the specified {@link SkillBonus skill bonus}, {@code false} otherwise.
	 *
	 * @return {@code true} if this skill action is affected by the specified skill bonus, {@code false} otherwise.
	 */
	default boolean isBonusApplicable(SkillBonus bonus)
	{
		return !getExcludedSkillBonuses().contains(bonus);
	}

	boolean isMembers(final ItemManager itemManager);

	default Set<? extends SkillBonus> getExcludedSkillBonuses()
	{
		return Collections.emptySet();
	}
}
