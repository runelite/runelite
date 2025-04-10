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

import net.runelite.client.game.ItemManager;

/**
 * An object representing a single skill action involving an item which grants some xp.
 */
public interface ItemSkillAction extends SkillAction
{
	/**
	 * Gets the item ID used for this action.
	 *
	 * @return The item ID used for this action.
	 * @see net.runelite.api.gameval.ItemID
	 */
	int getItemId();

	/**
	 * Gets the item icon ID for this skill action.
	 *
	 * @return The item icon ID of this skill action.
	 * @see net.runelite.api.gameval.ItemID
	 * @see #getItemId()
	 */
	@Override
	default int getIcon()
	{
		return getItemId();
	}

	/**
	 * Gets the name of this skill action's associated item.
	 *
	 * @param itemManager An {@link ItemManager item manager} instance.
	 * @return The name of this skill action item.
	 * @see #getItemId()
	 */
	@Override
	default String getName(final ItemManager itemManager)
	{
		return itemManager.getItemComposition(getItemId()).getMembersName();
	}

	@Override
	default boolean isMembers(final ItemManager itemManager)
	{
		return itemManager.getItemComposition(getItemId()).isMembers();
	}
}
